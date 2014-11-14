<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="content">

	<div>
		<table>
			<tr>
				<td>序号</td>
				<td>角色名称</td>
				<td>用户名</td>
				<td>昵称</td>
				<td>姓名</td>
				<td>邮箱</td>
				<td>电话</td>
				<td>创建时间</td>
				<td>更新时间</td>
			</tr>
			<c:forEach items="${userList}" var="user" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.role.name}</td>
					<td>${user.username}</td>
					<td>${user.nickName}</td>
					<td>${user.fullname}</td>
					<td>${user.email}</td>
					<td>${user.phone}</td>
					<td>${user.createTime}</td>
					<td>${user.updateTime}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>