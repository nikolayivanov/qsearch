package com.knet.qsearch.core;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knet.qsearch.apiclients.ApiClient;
import com.knet.qsearch.core.caching.CacheService;

/**
 * @author I301205 Questions search service implementation.
 */
@Service
public class QuestionsSearchServiceImpl implements QuestionsSearchService {
	private static final Logger logger = LoggerFactory.getLogger(QuestionsSearchServiceImpl.class);

	@Autowired
	private ApiClient apiclient;

	@Autowired
	private CacheService cacheservice;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see QuestionsSearchService#SearchQuestions(QuestionsSearchQuery)
	 */
	@Override
	public List<QuestionsSearchResult> SearchQuestions(QuestionsSearchQuery query) {
		// example business logic here - this will be used in tests
		if (query.getQuery().equals("0 questions")) {
			return new ArrayList<QuestionsSearchResult>();
		}

		List<QuestionsSearchResult> result = this.cacheservice.getFromCache(query);
		if (result != null) {
			logger.debug("Found in cache.");
			return result;
		} else {
			result = this.apiclient.SearchQuestions(query);
			this.cacheservice.addToCache(query, result);
			return result;
		}
	}

	public ApiClient getApiClient() {
		return apiclient;
	}

	public void setApiClient(ApiClient apiclient) {
		this.apiclient = apiclient;
	}

}
