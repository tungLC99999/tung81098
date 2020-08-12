z<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Thêm sản phẩm</title>
</head>
<body>



	<ul class="breadcrumb">
		<li><a href="<c:url value="/admin/index"/>">Quản trị</a> <span
			class="divider">/</span></li>
		<li class="active">Sửa sản phẩm</li>
	</ul>
	<div class="span4">
		<div class="well">
			<h3>SỬA SẢN PHẨM</h3>

			<h3>${ status }</h3>

			<form:form action="" method="POST" modelAttribute="product">

				<div class="control-group">
					<label class="control-label" for="inputEmail">Mã sản phẩm</label>
					<div class="controls">
						<form:input type="text" class="span3" placeholder="id_product"
							path="id_product" />

					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputEmail">Tên sản phẩm</label>
					<div class="controls">
						<form:input type="text" class="span3" placeholder="name"
							path="name" />

					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="inputEmail">Kích cỡ sản
						phẩm</label>
					<div class="controls">
						<form:input type="text" class="span3" path="sizes" />

					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputEmail">Giá sản phẩm</label>
					<div class="controls">
						<form:input type="text" class="span3" path="price" />

					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputEmail">Giảm giá</label>
					<div class="controls">
						<form:input type="text" class="span3" path="sale" />

					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputEmail">Tiêu đề sản
						phẩm</label>
					<div class="controls">
						<form:input type="text" class="span3" path="title" />

					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="inputEmail">Có phải sản
						phẩm mới</label>
					<div class="controls">
						<form:input type="text" class="span3" path="new_product" />

					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputEmail">Chi tiết sản
						phẩm </label>
					<div class="controls">
						<form:input type="text" class="span3" path="details" />

					</div>
				</div>
				<!--<div class="control-group">
					<label class="control-label" for="inputEmail">Ảnh mô tả</label>
					<div class="controls">
						<form:input type="text" class="span3" path="img" />

					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="inputEmail">Màu sắc</label>
					<div class="controls">
						<form:input type="text" class="span3" path="name_color" />

					</div>
				</div>-->


				<div class="control-group">
					<div class="controls">
						<button type="submit" class="defaultBtn">Cập nhật</button>

					</div>
				</div>
			</form:form>
		</div>
	</div>


	</div>
</body>

