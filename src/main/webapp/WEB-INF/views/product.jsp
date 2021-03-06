<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Produkt</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Produkt</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
			    <img src="<c:url value="/resource/images/${product.productId}.jpg"></c:url>" alt="image" style="width: 100%"/>
			</div>
            <c:if test="${not empty product.productIntroduction}">
				<div class="col-md-5">
	                <a href="<spring:url value="/resource/pdf/${product.productId}.pdf"></spring:url>">
	                    Pobierz instrukcję
	                </a>
	            </div>
            </c:if>
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Kod produktu: </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>Producent</strong>: ${product.manufacturer}
				</p>
				<p>
					<strong>Kategoria</strong>: ${product.category}
				</p>
				<p>
					<strong>Dostępna liczba sztuk</strong>: ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice}PLN</h4>
				<p>
                    <a href="#" class="btn btn-warning btn-large"> <span
                        class="glyphicon-shopping-cart glyphicon"></span> Zamów teraz
                    </a>
					<a href="<spring:url value="/products" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Wstecz
					</a> 
				</p>
			</div>
		</div>
	</section>
</body>
</html>
