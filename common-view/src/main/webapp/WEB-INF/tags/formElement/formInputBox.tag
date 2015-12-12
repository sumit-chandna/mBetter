<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" required="false" type="java.lang.String"%>
<%@ attribute name="idKey" required="true" type="java.lang.String"%>
<%@ attribute name="labelKey" required="false" type="java.lang.String"%>
<%@ attribute name="defaultText" required="false" type="java.lang.String"%>
<%@ attribute name="path" required="true" type="java.lang.String"%>
<%@ attribute name="mandatory" required="false" type="java.lang.Boolean"%>
<%@ attribute name="labelCSS" required="false" type="java.lang.String"%>
<%@ attribute name="inputCSS" required="false" type="java.lang.String"%>
<%@ attribute name="tabindex" required="false" rtexprvalue="true"%>
<%@ attribute name="autocomplete" required="false"
	type="java.lang.String"%>
<%@ attribute name="placeholder" required="false"
	type="java.lang.String"%>
<%@ attribute name="showLabel" required="false" type="java.lang.Boolean"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template"%>
<%@ attribute name="readOnly" required="false" type="java.lang.Boolean"%>
<%@ attribute name="maxLength" required="false" type="java.lang.Integer"%>
<%@ attribute name="reviewErrorField" required="false"
	type="java.lang.Boolean"%>

<%-- <template:errorSpanField path="${path}"> --%>
<c:if test="${showLabel != false}">
	<label class="control-label ${labelCSS}" for="${idKey}"> <c:if
			test="${labelKey != null}">
			<spring:message code="${labelKey}" text="${defaultText}"/>
		</c:if> <c:if test="${mandatory != null && mandatory == true}">
			<span class="mandatory"> <spring:message code="login.required"
					var="loginrequiredText" /> <img width="5" height="6"
				alt="${loginrequiredText}" title="${loginrequiredText}"
				src="${commonResourcePath}/images/mandatory.gif">
			</span>
		</c:if> <c:if test="${reviewErrorField != true}">
			<span class="skip"><form:errors path="${path}" /></span>
		</c:if>
	</label>
</c:if>
<div class="controls">
	<form:input value="${value}" readonly="${readOnly }"
		maxlength="${maxLength }" cssClass="${inputCSS}" id="${idKey}"
		path="${path}" tabindex="${tabindex}" autocomplete="${autocomplete}"
		placeholder="${placeholder}" />
</div>

<%-- </template:errorSpanField> --%>
