<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}" />
<div id="menuViewForm">

	<c:forEach var="role" items="${allRoles}">
Role : ${role.userRole }
<div>
			<ul>
				<c:forEach var="menu" items="${role.menus}">
					<li>Menu Name : ${menu.menuName} <c:choose>
							<c:when test="${not empty menu.subMenus}">
								<div>
									<ul>
										<c:forEach var="subMenu" items="${menu.subMenus}">

											<li>Sub Menu Name : ${subMenu.menuName}
												<div>
													<ul>
														<c:if test="${subMenu.add==true}">
															<li>Add</li>
														</c:if>
														<c:if test="${subMenu.view==true}">
															<li>View</li>
														</c:if>
														<c:if test="${subMenu.update==true}">
															<li>Update</li>
														</c:if>
													</ul>
												</div>
											</li>

										</c:forEach>
									</ul>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<c:if test="${menu.add==true}">
										<li>Add</li>
									</c:if>
									<c:if test="${menu.view==true}">
										<li>View</li>
									</c:if>
									<c:if test="${menu.update==true}">
										<li>Update</li>
									</c:if>
								</div>
							</c:otherwise>
						</c:choose>
					</li>
				</c:forEach>
			</ul>
		</div>
	</c:forEach>
</div>