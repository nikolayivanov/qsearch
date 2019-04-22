/**
 * 
 */
package com.knet.qsearch.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.knet.qsearch.core.QuestionsSearchQuery;
import com.knet.qsearch.core.QuestionsSearchResult;
import com.knet.qsearch.core.caching.CacheService;
import com.knet.qsearch.core.caching.GuavaBasedCacheService;

/**
 * @author I301205
 *
 */
public class GuavaBasedCacheServiceTests {
	
	private CacheService cacheservice;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.cacheservice = new GuavaBasedCacheService();
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
		
		assertNull(this.cacheservice.getFromCache(query));
		List<QuestionsSearchResult> result = GetTestResultList();
		this.cacheservice.addToCache(query, result);
		
		List<QuestionsSearchResult> resfromcache = this.cacheservice.getFromCache(query);
		assertEquals(1, resfromcache.size());
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
