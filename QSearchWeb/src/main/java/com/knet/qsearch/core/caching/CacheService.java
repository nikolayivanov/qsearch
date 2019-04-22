/**
 * 
 */
package com.knet.qsearch.core.caching;

import java.util.List;

import com.knet.qsearch.core.QuestionsSearchQuery;
import com.knet.qsearch.core.QuestionsSearchResult;

/**
 * @author I301205 Cache service interface.
 */
public interface CacheService {
	
	/**
	 * Gets the result from cache by query.
	 *
	 * @param query the query
	 * @return the from cache
	 */
	List<QuestionsSearchResult> getFromCache(QuestionsSearchQuery query);

	/**
	 * Adds the query and result into cache.
	 *
	 * @param query the query
	 * @param result the result
	 */
	void addToCache(QuestionsSearchQuery query, List<QuestionsSearchResult> result);
}
