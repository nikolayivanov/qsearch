/**
 * 
 */
package com.knet.qsearch.core.caching;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.knet.qsearch.core.QuestionsSearchQuery;
import com.knet.qsearch.core.QuestionsSearchResult;

/**
 * @author I301205
 * Cache service implementation based on google core projects cache. 
 */
@Service
public class GuavaBasedCacheService implements CacheService {
	private static final Logger logger = LoggerFactory.getLogger(GuavaBasedCacheService.class);
	
	private static final Cache<String, List<QuestionsSearchResult>> GUAVACACHE = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .build();
	
	/* (non-Javadoc)
	 * @see com.knet.qsearch.core.caching.CacheService#getFromCache(com.knet.qsearch.core.QuestionsSearchQuery)
	 */
	@Override
	public List<QuestionsSearchResult> getFromCache(QuestionsSearchQuery query) {
		try
		{
			return GUAVACACHE.getIfPresent(query.getQuery());
		}
		catch(Exception ex)
		{
			logger.error("Error in guava cache.", ex);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.knet.qsearch.core.caching.CacheService#addToCache(com.knet.qsearch.core.QuestionsSearchQuery, java.util.List)
	 */
	@Override
	public void addToCache(QuestionsSearchQuery query, List<QuestionsSearchResult> result) {
		try
		{
			GUAVACACHE.put(query.getQuery(), result);
		}
		catch(Exception ex)
		{
			logger.error("Error in guava cache.", ex);
		}
	}
}
