package com.knet.qsearch.core;

import java.util.List;

/**
 * @author I301205
 * Question search service interface.
 */
public interface QuestionsSearchService {
	/**
	 * @param query
	 * @return
	 */
	List<QuestionsSearchResult> SearchQuestions(QuestionsSearchQuery query);
}