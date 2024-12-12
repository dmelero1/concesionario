<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%><!doctype html>
<html lang="en">
<head>
    <title>Coche</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="container shadow">
        <header class="p-2">
            <div>
                <nav
                    class="navbar navbar-expand-sm navbar-light bg-light">
                    <div class="container">
                    	<a href="Controller?operacion=iniciar">
                    	<img class="me-5" src="resources/img/logo.png" alt="" width="100">                    
                    	</a>
                            
                        <form action="Controller?operacion=cambiomarca" method="post">
                        	<select class="form-select form-select-lg form-select-sm" name="idmarca" id="" onchange="this.form.submit()">
                            	<option value="0" disabled selected>Elija Marca</option>
                            	<option value="0">Todas</option>
                                <c:forEach items="${marcas}" var="marca">
                            	<option value="${marca.id}" ${marca.id==idmarca?'selected':''} >${marca.nombre}</option>
                            	</c:forEach>
                            </select>
                    	</form>
                    <form action="Controller?operacion=cambioorden" method="post">
                        <select class="form-select form-select-lg form-select-sm" name="orden" id="" onchange="this.form.submit()">
                            <option value="0" disabled selected>Elija Orden</option>
                            <option value="nombre" ${orden=='nombre'?'selected':''}>Nombre</option>
                            <option value="modelo" ${orden=='modelo'?'selected':''} >Modelo</option>
                            <option value="anio" ${orden=='anio'?'selected':''}>Año</option>
                            <option value="km" ${orden=='km'?'selected':''}>Kilometros</option>
                            <option value="cv" ${orden=='cv'?'selected':''}>Caballos</option>
                            <option value="precio" ${orden=='precio'?'selected':''}>Precio</option>
                        </select>
                    </form>
                    </div>
                </nav>
                
            </div>
        </header>
        <main>            
            <c:if test="${coches!=null}">
            <div class="row justify-content-center mt-3">
                <c:forEach items="${coches}" var="coche" >
                <div class="col-xl-4 col-lg-6 col-md-6 col-sm-12  position-relative mb-3">
                    <div class="card pb-3" style="background-color: rgb(61, 61, 61);">
                        <img class="card-img-top" src="${coche.foto}" alt="Title" />
                        <div class="card-body">
                            <h4 class="card-title text-end text-white">${coche.likes}
                            	<a class="text-decoration-none text-white" href="Controller?operacion=like&idcoche=${coche.id}">
                            		<i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
                            	</a>
                            </h4>
                            
                            <p class="card-text row">
                                <p class="text-start text-white">${coche.nombre}</p>
                                <p class="text-end text-danger"><strong>${coche.precioantes}$</strong></p>
                            </p>
                            <p style="width:29%" class="card-text text-white">${coche.modelo}
                                <p class="text-end text-success"><strong>${coche.precio}$</strong></p>
                            </p>
                            <p class="card-text text-white">${coche.anio} | ${coche.km}km | ${coche.cv}CV</p>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
            </c:if>
        </main>
        <footer class="text-white pt-2 pb-1" style="background-color:rgb(61, 61, 61);">
            <h5 class="text-center">&copy; Daniel Melero</h5>
        </footer>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>

</html>