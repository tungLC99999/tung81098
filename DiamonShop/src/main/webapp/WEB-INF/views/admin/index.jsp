z<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Admin Page</title>
</head>
<body>
	<h1>Admin Page</h1>
	<h2>Welcome Admin: ${pageContext.request.userPrincipal.name}</h2>

	<form action="<c:url value="/j_spring_security_logout" />"
		method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Logout" />
	</form>
	
	<div class="span3">
		<div class="well">
			<h3>THÊM SẢN PHẨM MỚI</h3>

			<ul class="defaultBtn">
				<a href="<c:url value="add"/>"> Thêm  sản phẩm</a>
				</li>
			</ul>
		</div>
	</div>

	<div class="span3">
		<div class="well">
			<h3>SỬA CHI TIẾT SẢN PHẨM</h3>

			<ul class="defaultBtn">
				<a href="<c:url value="edit"/>"> Sửa sản phẩm</a>
				</li>
			</ul>
		</div>
	</div>

	<div class="span3">
		<div class="well">
			<h3>XÓA SẢN PHẨM TRONG DANH SÁCH</h3>

			<ul class="defaultBtn">
				<a href="<c:url value="delete"/>"> Xóa sản phẩm</a>
				</li>
			</ul>
		</div>
	</div>
	
	
	
	</div>
</body>

