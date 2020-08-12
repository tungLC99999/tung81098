<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>   
<head>
<title> Xóa sản phẩm</title>
</head>
<body>


<c:url value="/admin/delete" var="urlDelete"/>
<c:url value="/admin/edit" var="urlEdit"/>
<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="<c:url value="/admin/index"/>">Quản trị</a> <span class="divider">/</span></li>
		<li class="active">Xóa sản phẩm</li>
    </ul>
	<div class="well well-small">
		<h1>Danh sách sản phẩm <small class="pull-right"> </small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Hình ảnh</th>
                  <th>Tên sản phẩm</th>                  
                  <th>Mô tả</th>
                  <th>ID sản phẩm</th>  
                  
                  <th>Giá bán</th>                 
                  <th>Chỉnh sửa </th>
                  <th>Xóa </th>
                 
				</tr>
              </thead>
              <tbody>
              
				<c:forEach var="item" items="${ products }">
					<tr>
	                  <td><img width="100" src="<c:url value="/assets/user/img/${item.img }"/>" alt=""></td>
	                  <td>${ item.name }</td>
	                  <td>${ item.title }</td>
	                  <td>${ item.id_product }</td>
	                  
	                  <td><fmt:formatNumber type="number" groupingUsed="true" value="${ item.price }"/> ₫</td>
	                  
	                  <td>
	                  
	                  	<a href="${urlEdit}" class="btn btn-mini btn-danger edit-cart" type="button">
	                  		<span class="icon-edit"></span>
	          	     	</a>
	                  	
	                  </td>
	                 
	                   <td>
	                  	<a href="${urlDelete}/${item.id_product}" class="btn btn-mini btn-danger" type="submit">
	                  		<span class="icon-remove"></span>
	                  	</a>
	                  </td>
	               
	                </tr>
				</c:forEach>
                
				</tbody>
            </table><br/>
	

</div>
</div>
</div>







</body>