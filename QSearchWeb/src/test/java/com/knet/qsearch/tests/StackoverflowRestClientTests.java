/**
 * 
 */
package com.knet.qsearch.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.knet.qsearch.apiclients.ApiClient;
import com.knet.qsearch.apiclients.StackoverflowRestClient;
import com.knet.qsearch.core.QuestionsSearchQuery;
import com.knet.qsearch.core.QuestionsSearchResult;

/**
 * @author I301205
 *
 */
public class StackoverflowRestClientTests {

	private ApiClient apiclient;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.apiclient = new StackoverflowRestClient();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		QuestionsSearchQuery query = new QuestionsSearchQuery();
		query.setQuery("java");
		
		List<QuestionsSearchResult> result = this.apiclient.SearchQuestions(query);
		assertEquals(true, result.size() > 0);
	}
}