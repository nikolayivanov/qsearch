<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:choose>
	<c:when test="${reslist.size() == 0}">
		<h4>0 questions</h4>
	</c:when>
	<c:otherwise>
		<c:forEach items="${reslist}" var="question">
			<div class="row">
				<div class="col-md-2">
					<div
						class="alert ${question.getIsAnswered() ? 'alert-success' : 'alert-info'}"
						role="alert">
						<c:choose>
							<c:when test="${question.getIsAnswered()}">
								<span class="glyphicon glyphicon-ok"></span> Answered 
							    </c:when>
							<c:otherwise>
							        Not Answered
							    </c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-md-10">
					<div>
						<h4>
							<a href="${question.url}" class="question-hyperlink">${question.title}</a>
						</h4>
					</div>
					<div>
						Asked At <span><b>${question.getCreationDate()}</b></span> By <span><b>${question.getOwnerDisplayName()}</b></span>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>