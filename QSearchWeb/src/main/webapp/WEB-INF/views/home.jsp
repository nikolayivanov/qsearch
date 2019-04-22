<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"
	session="false"%>
<html>
<head>
<title>Questions Search Application</title>

<!-- Bootstrap Core CSS -->
<link href="${webappRoot}/qsearch/resources/css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Custom CSS -->
<link href="${webappRoot}/qsearch/resources/css/main.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${webappRoot}/qsearch/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="${webappRoot}/qsearch/resources/js/main.js"></script>
</head>
<body>
	<div class="container" id="wrapper">
		<div class="row">
			<div class="col-md-12"></div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<form:form method="POST" modelAttribute="searchquery"
					action="get-results" class="form" role="form">
					<div class="input-group">
						<form:input path="query" class="form-control" placeholder="Search"
							aria-label="Search Ajax" />
						<span class="input-group-btn">
							<button class="btn btn-outline-success" type="submit"
								onclick="postQuestionsViaAjax(); return false;">Ajax
								Search</button>
						</span>
					</div>
				</form:form>

			</div>
			<div id="spinner" class="spinner"></div>
			<div id="div-questions" class="col-md-12"></div>			
		</div>
	</div>
</body>
</html>
