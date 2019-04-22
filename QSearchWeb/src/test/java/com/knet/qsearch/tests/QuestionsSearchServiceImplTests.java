/**
 * 
 */
package com.knet.qsearch.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.knet.qsearch.apiclients.ApiClient;
import com.knet.qsearch.core.QuestionsSearchQuery;
import com.knet.qsearch.core.QuestionsSearchResult;
import com.knet.qsearch.core.QuestionsSearchService;
import com.knet.qsearch.core.QuestionsSearchServiceImpl;
import com.knet.qsearch.core.caching.CacheService;

/**
 * @author I301205
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionsSearchServiceImplTests {
	@Mock
	private ApiClient apiclient;

	@Mock
	private CacheService cacheservice;

	@InjectMocks
	QuestionsSearchService service = new QuestionsSearchServiceImpl();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.knet.qsearch.core.QuestionsSearchServiceImpl#SearchQuestions(com.knet.qsearch.core.QuestionsSearchQuery)}.
	 */
	@Test
	public void testSearchQuestions() {
		QuestionsSearchQuery query = new QuestionsSearchQuery();
		query.setQuery("java");

		List<QuestionsSearchResult> reslist = GetTestResultList();
		when(this.apiclient.SearchQuestions(query)).thenReturn(reslist);

		// define return value for method apiclient.SearchQuestions()
		when(this.cacheservice.getFromCache(query)).thenReturn(null);
		doNothing().when(this.cacheservice).addToCache(query, reslist);

		List<QuestionsSearchResult> list = service.SearchQuestions(query);
		assertThat(list.size(), is(1));
	}

	@Test
	public void testSearchQuestionsBusinessLogic() {
		QuestionsSearchQuery query = new QuestionsSearchQuery();
		query.setQuery("0 questions");

		// define return value for method apiclient.SearchQuestions()
		List<QuestionsSearchResult> reslist = GetTestResultList();
		when(this.apiclient.SearchQuestions(query)).thenReturn(reslist);

		// define return value for method apiclient.SearchQuestions()
		when(this.cacheservice.getFromCache(query)).thenReturn(null);
		doNothing().when(this.cacheservice).addToCache(query, reslist);

		List<QuestionsSearchResult> list = service.SearchQuestions(query);
		assertThat(list.size(), is(0));
	}

	private List<QuestionsSearchResult> GetTestResultList() {
		List<QuestionsSearchResult> reslist = new ArrayList<QuestionsSearchResult>();
		QuestionsSearchResult res = new QuestionsSearchResult();
		res.setTitle("my first question");
		res.setIsAnswered(true);
		res.setOwnerDisplayName("Nikolay Ivanov");
		res.setCreationDate(new Date());
		reslist.add(res);
		return reslist;
	}
}
