<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>

<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/formElement"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}" />
<div>
	${contextpath}
	<table>
		<form:form method="post" action="${contextpath}/login/save"
			class="form-horizontal" autocomplete="off"
			modelAttribute="RegisterForm">

			<tr>
				<td width="33%"><formElement:formInputBox idKey="employeeCode"
						placeholder="Employee Code" labelKey="register.employeeCode"
						defaultText="Employee Name" path="employeeCode" showLabel="true" /></td>
				<td width="33%" />

				<td width="33%"><formElement:formInputBox idKey="employeeName"
						placeholder="Employee Name" labelKey="register.employeeName"
						defaultText="Employee Name" path="employeeName" showLabel="true" /></td>

			</tr>

			<tr>
				<td width="33%"><formElement:formSelectBox idKey="employeeType"
						labelKey="register.employeeType" defaultText="Employee Type"
						path="employeeType" mandatory="true" skipBlank="true"
						items="${employeeType}" tabindex="1" itemValue="dropDownValue"
						itemLabel="dropDownText" /></td>
				<td width="33%"><formElement:formSelectBox
						idKey="employeeDepartment" labelKey="register.employeeDepartment"
						defaultText="Employee Department" path="employeeDepartment"
						mandatory="true" skipBlank="true" items="${employeeDepartment}"
						tabindex="2" itemValue="id" itemLabel="departmentName" /></td>

				<td width="33%"><formElement:formSelectBox
						idKey="employeeDepartment" labelKey="register.employeeDepartment"
						defaultText="Employee Sub Department" path="employeeDepartment"
						mandatory="true" skipBlank="true" items="${employeeSubDepartment}"
						tabindex="2" itemValue="id" itemLabel="subDepartmentName" /></td>

			</tr>

			<tr>
				<td width="33%"><formElement:formSelectBox
						idKey="employeeDepartment" labelKey="register.employeeDepartment"
						defaultText="Reporting Manager" path="employeeDepartment"
						mandatory="true" skipBlank="true" items="${employeeType}"
						tabindex="2" itemValue="dropDownValue" itemLabel="dropDownText" />
				</td>

				<td width="33%" />
				<td width="33%"><formElement:formSelectBox
						idKey="employeeDepartment" labelKey="register.employeeDepartment"
						defaultText="Hospital Location" path="employeeDepartment"
						mandatory="true" skipBlank="true" items="${employeeType}"
						tabindex="2" itemValue="dropDownValue" itemLabel="dropDownText" />
				</td>


			</tr>


			<tr>
				<td width="33%"><formElement:formInputBox idKey="emailId"
						placeholder="Email Id" labelKey="register.emailId"
						defaultText="Email Id" path="emailId" showLabel="true" /></td>

				<td width="33%"><formElement:formInputBox idKey="mobileNumber"
						placeholder="Mobile Number" labelKey="register.mobileNumber"
						defaultText="Mobile Number" path="mobileNumber" showLabel="true" />
				</td>

				<td width="33%"><formElement:formInputBox idKey="dateOfBirth"
						placeholder="dd/mm/yyyy" labelKey="register.dateOfBirth"
						defaultText="Date of Birth" path="dateOfBirth" showLabel="true" />
				</td>

			</tr>

			<tr>
				<td width="33%"><formElement:formInputBox idKey="aadharNumber"
						placeholder="Aadhar Number" labelKey="register.aadharNumber"
						defaultText="Aadhar Number" path="aadharNumber" showLabel="true" /></td>

				<td width="33%"><formElement:formInputBox idKey="addressLine1"
						placeholder="Address Line1" labelKey="register.addressLine1"
						defaultText="Address Line1" path="addressLine1" showLabel="true" /></td>

				<td width="33%"><formElement:formInputBox idKey="addressLine2"
						placeholder="Address Line2" labelKey="register.addressLine2"
						defaultText="Address Line2" path="addressLine2" showLabel="true" /></td>

			</tr>

			<tr>
				<td width="33%"><formElement:formInputBox idKey="city"
						placeholder="City" labelKey="register.city" defaultText="City"
						path="city" showLabel="true" /></td>

				<td width="33%"><formElement:formInputBox idKey="state"
						placeholder="State" labelKey="register.state" defaultText="State"
						path="state" showLabel="true" /></td>

				<td width="33%"><formElement:formInputBox idKey="pincode"
						placeholder="Pincode" labelKey="register.pincode"
						defaultText="Pincode" path="pincode" showLabel="true" /></td>

			</tr>



			<tr>
				<td width="33%"><formElement:formSelectBox idKey="active"
						labelKey="register.active" defaultText="Active" path="active"
						mandatory="true" skipBlank="true" items="${employeeType}"
						tabindex="2" itemValue="dropDownValue" itemLabel="dropDownText" /></td>

				<td width="33%">
					<%-- <formElement:formCheckbox idKey="generateLogin" labelKey="register.generateLogin" path="generateLogin" mandatory="false" defaultText="Generate Login"/> --%>
				</td>

				<td width="33%"><formElement:formSelectBox idKey="userRole"
						labelKey="register.userRole" defaultText="User Role"
						path="userRole" mandatory="true" skipBlank="true"
						items="${employeeType}" tabindex="2" itemValue="dropDownValue"
						itemLabel="dropDownText" /></td>

			</tr>


			<tr>
				<td width="33%"><formElement:formInputBox idKey="startDate"
						placeholder="Start Date" labelKey="register.startDate"
						defaultText="Start Date" path="startDate" showLabel="true"
						readOnly="true" /></td>

				<td width="33%"><formElement:formInputBox idKey="endDate"
						placeholder="End Date" labelKey="register.endDate"
						defaultText="End Date" path="endDate" showLabel="true"
						readOnly="true" /></td>

				<td width="33%"><formElement:formInputBox
						idKey="passwordValidityDays" placeholder="Password Validity Days"
						labelKey="register.passwordValidityDays"
						defaultText="Password Validity Days" path="passwordValidityDays"
						showLabel="true" readOnly="true" /></td>

			</tr>



			<tr>
				<td><input id="submit" name="submit" type="submit"
					value="Login" /></td>
			</tr>


		</form:form>
	</table>
</div>