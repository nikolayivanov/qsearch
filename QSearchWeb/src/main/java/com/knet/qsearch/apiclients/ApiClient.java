package com.knet.qsearch.apiclients;

import java.util.List;

import com.knet.qsearch.core.QuestionsSearchQuery;
import com.knet.qsearch.core.QuestionsSearchResult;

/**
 * @author I301205
 * API Client interface.
 */
public interface ApiClient {
	
	/**
	 * Search questions method.
	 *
	 * @param query the query
	 * @return the list with results
	 */
	List<QuestionsSearchResult> SearchQuestions(QuestionsSearchQuery query);
}
