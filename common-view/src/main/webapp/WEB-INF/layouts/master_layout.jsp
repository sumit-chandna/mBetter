<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- Set global variables ofr  -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}" />
<script type="text/javascript"
	src="${contextpath}/resources/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("	.menuBar").height($(window).height());
		$(window).trigger('resize');
	})
	// for the window resize
	$(window).resize(function() {
		var bodyheight = $(window).height() - 80;
		$(".menuBar").height(bodyheight);
	});
</script>
<!-- start: Meta -->
<meta charset="utf-8">
<title>mBetter</title>
<!-- end: Meta -->

<link rel="stylesheet"
	href="${contextpath}/resources/static/css/styles.css">

</head>

<body>
	<!-- start: Header -->
	<div id="header">
		<jsp:include page="./includes/header.jsp" />
	</div>
	<!-- end: Header -->
	<div class="row">
		<div class="menuBar" id='cssmenu'>
			<ul>
				<li><a href='#'><span>Home</span></a></li>
				<li class='active has-sub'><a href='#'><span>User
							Roles</span></a>
					<ul>
						<li><a href='createRoles'><span>create</span></a></li>
						<li><a href='#'><span>update</span></a></li>
					</ul></li>
				<li><a href='#'><span>About</span></a></li>
				<li><span></span></li>
				<li class='last'><a href='#'><span>Contact</span></a></li>
				<c:forEach var="menu" items="${rolemenus.menus}">

					<li class='has-sub'><a href='#'><span>${menu.menuName}</span></a>
						<ul>
							<c:choose>
								<c:when test="${not empty menu.subMenus}">
									<c:forEach var="subMenu" items="${menu.subMenus}">
										<li class='has-sub'><a href='#'><span>${subMenu.menuName}</span></a>
											<ul>
												<c:if test="${subMenu.add}">
													<li><a href='#'><span>Add</span></a></li>
												</c:if>
												<c:if test="${subMenu.delete}">
													<li><a href='#'><span>Delete</span></a></li>
												</c:if>
												<c:if test="${subMenu.view}">
													<li><a href='#'><span>View</span></a></li>
												</c:if>
											</ul></li>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:if test="${menu.add}">
										<li><a href='#'><span>Add</span></a></li>
									</c:if>
									<c:if test="${menu.delete}">
										<li><a href='#'><span>Delete</span></a></li>
									</c:if>
									<c:if test="${menu.view}">
										<li><a href='#'><span>View</span></a></li>
									</c:if>
								</c:otherwise>
							</c:choose>
						</ul></li>
				</c:forEach>
			</ul>
		</div>
		<div class=data>
			<dec:body />
		</div>
	</div>
	<div id="footer">
		<jsp:include page="./includes/footer.jsp" />
	</div>
</body>
</html>
