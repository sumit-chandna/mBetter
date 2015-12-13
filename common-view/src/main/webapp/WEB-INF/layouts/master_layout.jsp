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
				<li><a href='#'><span>About</span></a></li>

				<c:forEach var="sideBarMenu" items="${rolemenus.menus}">

					<c:choose>
						<c:when test="${sideBarMenu.isPageRedirect}">
							<li class='has-sub'><a href='#'><span>${sideBarMenu.menuName}</span></a>
								<ul>
									<c:if test="${sideBarMenu.add==true}">
										<li><a
											href='${contextpath}/${sideBarMenu.redirectPageName}?menu=${sideBarMenu.id}&option=add'>Add</span></a></li>
									</c:if>
									<c:if test="${sideBarMenu.view==true}">
										<li><a
											href='${contextpath}/${sideBarMenu.redirectPageName}?menu=${sideBarMenu.id}&option=view'>View</span></a></li>
									</c:if>
									<c:if test="${sideBarMenu.update==true}">
										<li><a
											href='${contextpath}/${sideBarMenu.redirectPageName}?menu=${sideBarMenu.id}&option=update'>Update</span></a></li>
									</c:if>
								</ul></li>
						</c:when>
						<c:otherwise>
							<li class='has-sub'><a href='#'><span>${sideBarMenu.menuName}</span></a>
								<ul>
									<c:choose>
										<c:when test="${not empty sideBarMenu.subMenus}">
											<c:forEach var="sideBarSubMenu"
												items="${sideBarMenu.subMenus}">
												<c:choose>
													<c:when test="${sideBarSubMenu.isPageRedirect}">
														<li class='has-sub'><a href='#'><span>${sideBarSubMenu.menuName}</span></a>
															<ul>
																<c:if test="${sideBarSubMenu.add==true}">
																	<li><a
																		href='${contextpath}/${sideBarSubMenu.redirectPageName}?menu=${sideBarMenu.id}&submenu=${sideBarSubMenu.id}&option=add'>Add</span></a></li>
																</c:if>
																<c:if test="${sideBarSubMenu.view==true}">
																	<li><a
																		href='${contextpath}/${sideBarSubMenu.redirectPageName}?menu=${sideBarMenu.id}&submenu=${sideBarSubMenu.id}&option=view'>View</span></a></li>
																</c:if>
																<c:if test="${sideBarSubMenu.update==true}">
																	<li><a
																		href='${contextpath}/${sideBarSubMenu.redirectPageName}?menu=${sideBarMenu.id}&submenu=${sideBarSubMenu.id}&option=update'>Update</span></a></li>
																</c:if>
															</ul></li>
													</c:when>
												</c:choose>
											</c:forEach>
										</c:when>
									</c:choose>
								</ul></li>
						</c:otherwise>
					</c:choose>

				</c:forEach>
				<li><span></span></li>
				<li class='last'><a href='#'><span>Contact</span></a></li>
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
