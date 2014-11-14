<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content">
	<div id="searchId">
		<form action="/admin/customer/queryResume.html" id="search" method="post">
		<span>姓名：</span> 
		<input type="text" name="name" <c:if test="${not empty name }">value="${name}"</c:if> />&nbsp; 
		
		<span>工作年限：</span>
		<select name="jobYear">
			<option value="">不限年限</option>
			<option value="1" <c:if test="${not empty jobYear and jobYear == 1 }">selected="selected"</c:if>>1年以下工作经验</option>
			<option value="3" <c:if test="${not empty jobYear and jobYear == 3 }">selected="selected"</c:if>>3年以下工作经验</option>
			<option value="5" <c:if test="${not empty jobYear and jobYear == 5 }">selected="selected"</c:if>>5年以下工作经验</option>
			<option value="8" <c:if test="${not empty jobYear and jobYear == 8 }">selected="selected"</c:if>>8年以下工作经验</option>
		</select>&nbsp; 
		
		<input type="submit" value="查询" id="searchadmin" class="btn" />
		<input type="button" value="新增简历" class="btn addadminBtn" />
		</form>
	</div>
	<div style="margin-top: 20px;">
		<table border="1" >
			<tr>
				<td>姓名</td>
				<td>性别</td>
				<td>出生年月</td>
				<td>工作年限</td>
				<td>学历</td>
				<td>技能</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${resumeList}" var="resume">
				<tr>
					<td>${resume.name}</td>
					<td>${resume.sex}</td>
					<td>${resume.year}-${resume.month}</td>
					<td>${resume.jobYear}</td>
					<td>${resume.educationCN}</td>
					<td>${resume.technologyString}</td>
					<td>
						<a href="javascript:void(0);" class="editadmin" data-resumeId="${resume.id}">修改</a> 
						<a href="javascript:void(0);" class="deleteResume" data-resumeId="${resume.id}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div style="margin-top: 20px;">
		<input type="button" value="新增简历" class="btn addadminBtn"/>
	</div>
</div>
<script src="http://localhost/admin/resources/js/index.js" type="text/javascript"></script>
