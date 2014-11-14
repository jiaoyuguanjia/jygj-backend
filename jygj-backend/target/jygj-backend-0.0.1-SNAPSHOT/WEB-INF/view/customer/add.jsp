<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="content">
<h3>
	<c:if test="${not empty resume.id}">更新</c:if>
	<c:if test="${empty resume.id}">新增</c:if>简历
</h3>
<form name="addadminForm" action="/admin/customer/addadmin.html" method="POST">
	<input type="hidden" name="id" value="${resume.id}"/>
	<table>
		<tr>
			<td><font style="color:red;">*</font> 姓名：</td>
			<td><input type="text" name="name" value="${resume.name}"/></td>
		</tr>
		<tr>
			<td><font style="color:red;">*</font> 性别：</td>
			<td>
				<input type="radio" <c:if test="${resume.sex == '男'}">checked="checked"</c:if> name="sex" value="男"/>男
				<input type="radio" <c:if test="${resume.sex == '女'}">checked="checked"</c:if>name="sex" value="女"/>女
			</td>
		</tr>
		<tr>
			<td><font style="color:red;">*</font> 出生年月：</td>
			<td>
				<select name="year"></select>
				<select name="month"></select>
			</td>
		</tr>
		<tr>
			<td><font style="color:red;">*</font> 所在地：</td>
			<td>
				<select name="provinceCode"></select>
				<select name="cityCode"></select>
				<select name="areaCode"></select>
			</td>
		</tr>
		<tr>
			<td><font style="color:red;">*</font> 工作年限：</td>
			<td><input type="text" name="jobYear" value="${resume.jobYear}" /></td>
		</tr>
		<tr>
			<td><font style="color:red;">*</font> 学历：</td>
			<td>
				<select name="education">
					<option>请选择学历</option>
					<c:forEach items="${educationTypes }" var="educationType">
						<option <c:if test="${resume.education == educationType}">selected="selected"</c:if> value="${educationType}">${educationType.message}</option>
					</c:forEach>
				</select> 
			</td>
		</tr>
		<tr>
			<td><font style="color:red;">*</font> 工作经历：</td>
			<td>
				<textarea rows="10" cols="60" name="jobExperience">${resume.jobExperience}</textarea>
			</td>
		</tr>
		<tr>
			<td><font style="color:red;">*</font> 项目经历：</td>
			<td>
				<textarea rows="10" cols="60" name="projectExperience">${resume.projectExperience}</textarea>
			</td>
		</tr>
		<tr>
			<td><font style="color:red;">*</font> 技能：</td>
			<td>
				<c:forEach items="${technologyTypes}" var="technologyType">
					<input type="checkbox" <c:if test="${fn:contains(fn:join(resume.technology, '-'), technologyType)}">checked="checked"</c:if> name="technology" value="${technologyType}">${technologyType}
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="提交简历" class="btn"/>&nbsp;&nbsp;
				<input type="reset" value="重置" class="btn"/>&nbsp;&nbsp;
				<input type="button" value="返回" onclick="back();" class="btn"/>
			</td>
		</tr>
	</table>
</form>
</div>
<script src="http://localhost/admin/resources/js/add.js" type="text/javascript"></script>