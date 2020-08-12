<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Kết qủa tìm kiếm</title>
</head>
<body>
<h1>${product.name}</h1>
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="<c:url value="/"/>">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Tìm kiếm</li>
			</ul>
		</div>
		
		
		<div class="span12">
			<form:form action="" class="navbar-search pull-left"	method="GET" modelAttribute="product">

				<input type="text"  name="name" placeholder="Enter Text to search" path="name"   />
				<button href="/search/${product.name}"  type="submit" class="defaultBtn">Tìm kiếm</button>
				
			</form:form>
			</div>
			
			
			
			
			
			<div class="span12">
				<div class="well well-small">
					<h1>Kết quả</h1>
					<hr class="soften" />

					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Hình ảnh</th>
								<th>Mô tả</th>
								<th>Màu sắc</th>
								<th>Giá bán</th>
								<th>Xem chi tiết</th>

							</tr>
						</thead>
						<tbody>

							
								<tr>
									<td><img width="100"
										src="<c:url value="/assets/user/img/${ product.img }"/>"
										alt=""></td>
									<td>${ product.title }</td>
									<td><span class="shopBtn"
										style="background-color:${ product.code_color };"><span
											class="icon-ok"></span></span></td>
									<td><fmt:formatNumber type="number" groupingUsed="true"
											value="${ product.price }" /> ₫</td>

									<td><a href="<c:url value="/chi-tiet-san-pham/${ product.id_product }"/>"
										class="btn btn-mini btn-danger" type="button"> <span
										class="icon-remove"></span>
									</a>
									</td>

								</tr>
							

						</tbody>
					</table>
					<br />



				</div>
			</div>
		</div>
		<content tag="script"> <script>
			$(".edit-cart").on("click", function() {

				var id = $(this).data("id");
				var quanty = $("#quanty-cart-" + id).val();
				window.location = "EditCart/" + id + "/" + quanty;
			});
		</script> </content>
		
</body>