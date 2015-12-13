<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}" />
<c:set var="requestpath"
	value="${requestScope['javax.servlet.forward.request_uri']}" />
<div id="menuCreateForm">
	<form method="POST" action="${contextpath }/manageRoles/getRoleDetails">
		Roles: <select name="userRole" id="userRole">
			<c:forEach var="availableRole" items="${availableRoles}">
				<option value="${availableRole}" label="${availableRole}"
					<c:if test="${selectedRole==availableRole}">selected</c:if> />

			</c:forEach>
		</select> <input value="Submit" type="submit" />
	</form>
	<c:if test="${role!=null}">

		<form:form method="POST" commandName="role" action="updateRole">
			Update roles for : ${role.userRole}
			<div>
				<form:hidden path="userRole" />
				<ul>
					<c:forEach var="menu" items="${role.menus}" varStatus="x">
						<li><form:label path="menus[${x.index }].menuName">${menu.menuName}</form:label>
							<c:choose>
								<c:when test="${not empty menu.subMenus}">
									<div>
										<ul>
											<c:forEach var="subMenu" items="${menu.subMenus}"
												varStatus="y">
												<li><form:label
														path="menus[${x.index }].subMenus[${y.index }].menuName">${subMenu.menuName}</form:label>
													<div>
														<div class="checkbox">
															<label>ADD <form:checkbox
																	path="menus[${x.index }].subMenus[${y.index }].add"
																	value="Add" /></label>
														</div>
														<div class="checkbox">
															<label>VIEW <form:checkbox
																	path="menus[${x.index }].subMenus[${y.index }].view"
																	value="view" /></label>
														</div>
														<div class="checkbox">
															<label>UPDATE <form:checkbox
																	path="menus[${x.index }].subMenus[${y.index }].update"
																	value="update" />
															</label>
														</div>
														<form:hidden
															path="menus[${x.index }].subMenus[${y.index }].menuName" />
														<form:hidden
															path="menus[${x.index }].subMenus[${y.index }].id" /></li>
											</c:forEach>




										</ul>
									</div>
								</c:when>
								<c:otherwise>
									<div>
										<div class="checkbox">
											<label>ADD<form:checkbox
													path="menus[${x.index }].add" value="Add" />
											</label>
										</div>
										<div class="checkbox">
											<label>VIEW<form:checkbox
													path="menus[${x.index }].view" value="view" />
											</label>
										</div>
										<div class="checkbox">
											<label>UPDATE<form:checkbox
													path="menus[${x.index }].update" value="update" />
											</label>
										</div>
									</div>
								</c:otherwise>
							</c:choose> <form:hidden path="menus[${x.index }].menuName" /> <form:hidden
								path="menus[${x.index }].id" /></li>
					</c:forEach>
				</ul>
			</div>
			<input value="Submit" type="submit" />
		</form:form>
	</c:if>
</div>