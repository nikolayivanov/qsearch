package com.knet.qsearch.apiclients;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.common.net.UrlEscapers;
import com.knet.qsearch.apiclients.dto.ApiResponseDTO;
import com.knet.qsearch.apiclients.dto.QuestionDTO;
import com.knet.qsearch.core.QuestionsSearchQuery;
import com.knet.qsearch.core.QuestionsSearchResult;

/**
 * @author I301205
 * Client for StackExchange API using spring RestTemplate.
 */
@Component
@Primary
public class StackoverflowRestClient implements ApiClient {
	private static final Logger logger = LoggerFactory.getLogger(StackoverflowRestClient.class);

	final String apiurl = "http://api.stackexchange.com/2.2";
	final int pagesize = 12;

	@Override
	public List<QuestionsSearchResult> SearchQuestions(QuestionsSearchQuery query) {
		try {
			final String encodedquery = UrlEscapers.urlPathSegmentEscaper().escape(query.getQuery());
			final String url = String.format(
					"%s/search?page=%d&pagesize=%d&order=desc&sort=activity&intitle=%s&site=stackoverflow", apiurl,
					query.getPagenum(), pagesize, encodedquery);

			RestTemplate restclient = new RestTemplate();
			restclient.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

			// Add the Jackson Message converter
			MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

			// Note: here we are making this converter to process any kind of response,
			// not only application/*json, which is the default behaviour
			List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
			supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
			converter.setSupportedMediaTypes(supportedMediaTypes);
			messageConverters.add(converter);
			restclient.setMessageConverters(messageConverters);

			ResponseEntity<ApiResponseDTO> restResponse = restclient.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<ApiResponseDTO>() {
					});

			ApiResponseDTO questions = restResponse.getBody();

			List<QuestionsSearchResult> list = new ArrayList<QuestionsSearchResult>();

			if (questions != null) {
				if (questions.getError_message() != null && !questions.getError_message().isEmpty()) {
					logger.error(String.format("Rest service returned error_id:%x error_message:%s",
							questions.getError_id(), questions.getError_message()));
				} else {
					for (QuestionDTO q : questions.getItems()) {
						QuestionsSearchResult res = new QuestionsSearchResult();
						res.setTitle(q.getTitle());
						res.setUrl(q.getLink());
						res.setIsAnswered(q.getIs_answered());
						res.setOwnerDisplayName(q.getOwner().getDisplay_name());
						res.setCreationDate(q.getCreation_date());
						list.add(res);
					}
				}
			}

			return list;
		} catch (RestClientException ex) {
			logger.error("Rest client side error.", ex);
			return new ArrayList<QuestionsSearchResult>();
		}
	}
}
