<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Hóa Đơn</title>
</head>
<body>
	<div class="well well-small">
		<h1>
			Hóa Đơn <small class="pull-right"> ${TotalQuantyCart } Sản
				phẩm chờ thanh toán </small>
		</h1>
		<hr class="soften" />
		<form:form action="dang-ky" method="POST" modelAttribute="user">

			
			<div class="control-group">
				<label class="control-label" for="inputEmail">Họ và tên</label>
				<span
					class="badge badge-warning"> <h5>${ LoginInfo.username } </h5>
				</span>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputEmail">Địa chỉ</label>
				<span
					class="badge badge-warning"> <h5>${ LoginInfo.address } </h5>
				</span>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputEmail">Tài khoản ví</label>
				<span
					class="badge badge-warning"><fmt:formatNumber type="number"
						groupingUsed="true" value="${ LoginInfo.wallet }" /> ₫  
				</span>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputEmail">Tổng Tiền</label> 
				<span
					class="badge badge-warning"> <fmt:formatNumber type="number"
						groupingUsed="true" value="${ TotalPriceCart }" /> ₫
				</span>
			</div>


		</form:form>


		<table class="table table-bordered table-condensed">
			<thead>
				<tr>
					<th>Hình ảnh</th>
					<th>Mô tả</th>
					<th>Màu sắc</th>
					<th>Giá bán</th>
					<th>Số lượng</th>
					<th>Chỉnh sửa</th>
					<th>Xóa</th>
					<th>Tổng tiền</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="item" items="${ Cart }">
					<tr>
						<td><img width="100"
							src="<c:url value="/assets/user/img/${ item.value.product.img }"/>"
							alt=""></td>
						<td>${ item.value.product.title }</td>
						<td><span class="shopBtn"
							style="background-color:${ item.value.product.code_color };"><span
								class="icon-ok"></span></span></td>
						<td><fmt:formatNumber type="number" groupingUsed="true"
								value="${ item.value.product.price }" /> ₫</td>
						<td><input type="number" min="0" max="1000" class="span1"
							style="max-width: 34px" placeholder="1"
							id="quanty-cart-${ item.key }" size="16" type="text"
							value="${ item.value.quanty }"></td>
						<td>
							<button data-id="${ item.key }"
								class="btn btn-mini btn-danger edit-cart" type="button">
								<span class="icon-edit"></span>
							</button>
						</td>
						<td><a href="<c:url value="/DeleteCart/${ item.key }"/>"
							class="btn btn-mini btn-danger" type="button"> <span
								class="icon-remove"></span>
						</a></td>
						<td><fmt:formatNumber type="number" groupingUsed="true"
								value="${ item.value.totalPrice }" /> ₫</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<br /> <a href="<c:url value="/trang-chu"/>"
			class="shopBtn btn-large"> Thanh toán khi nhận hàng </a> <a
			href="<c:url value="/paid"/>" class="shopBtn btn-large pull-right">Thanh
			toán </a>

	</div>
</body>
</html>