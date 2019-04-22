package com.knet.qsearch.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knet.qsearch.core.QuestionsSearchQuery;
import com.knet.qsearch.core.QuestionsSearchResult;
import com.knet.qsearch.core.QuestionsSearchService;

/**
 * @author I301205
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private QuestionsSearchService service;

	public QuestionsSearchService getService() {
		return service;
	}

	public void setService(QuestionsSearchService service) {
		this.service = service;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home", "searchquery", new QuestionsSearchQuery());
	}
	
	/**
	 * Get questions list results via post ajax method.
	 *
	 * @param searchquery the search query
	 * @return the model and view
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/get-results-ajax", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public ModelAndView resultsajax(@RequestBody QuestionsSearchQuery searchquery) throws Exception {
		if (searchquery.getQuery().equals("fire exception"))
		{
			throw new Exception("My exception message.");
		}
		
		List<QuestionsSearchResult> reslist = this.service.SearchQuestions(searchquery);
		ModelAndView model = new ModelAndView();
		model.setViewName("results");
		model.addObject("reslist", reslist);
		return model;
	}
	
	/**
	 * Handle all exceptions in HomeController.
	 *
	 * @param ex the ex
	 * @return the model and view
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex)
	{
		logger.error("HomeController Exception handler started.", ex);
		ModelAndView model = new ModelAndView("error");
		model.addObject("errormsg", ex.getMessage());
		return model;
	}	
}
