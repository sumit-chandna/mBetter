<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<c:url var="cssUrl" value="/resources/static/css/bootstrap.css" />
<link href="${cssUrl}" rel="stylesheet" />
<style>
body {
	padding-top: 41px;
}
</style>
</head>
<body>
	<div id="nav-bar" class="navbar navbar-fixed-top" >
		<div class="navbar-inner">
			<div class="container">
				<c:url var="welcomeUrl" value="/" />
				<a class="brand" href="${welcomeUrl}">mBetter</a>
				<div class="nav-collapse">
				</div>
				<div id="nav-account" class="nav-collapse pull-right">
					<ul class="nav">
						<security:authorize var="authenticated" access="authenticated" />
						<c:choose>
							<c:when test="${authenticated}">
								<li id="greeting"><div>
										Welcome
										<security:authentication property="principal.name" />
									</div></li>
								<c:url var="logoutUrl" value="/logout" />
								<li><a href="${logoutUrl}">logout</a></li>
							</c:when>
							<c:otherwise>
								<c:url var="loginUrl" value="/login/form" />
								<li><a id="navLoginLink" href="${loginUrl}">Login</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>

	</div>
