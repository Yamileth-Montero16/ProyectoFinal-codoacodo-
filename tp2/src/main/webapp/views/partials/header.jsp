
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Market</title>
        <link rel="stylesheet" href="/market/css/tags.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    </head>
    <body class="vh-100">

        <header class="hambuerguesaDrop" >
            <nav class=" hambuerguesaDrop navbar container-fluid  navbar-expand-lg bg-info ">
                <div class=" hambuerguesaDrop container-fluid  justify-content-between">
                    <a class="navbar-brand px-5" href="/market">
                        <img class="rounded text-warning" style="height: 70px;" src="/market/img/market.png" alt="logo"/>
                        <p class="text-light fw-bolder mt-3 ">
                            Mercado Box  
                        </p>
                    </a>
                    <div  class="hambuerguesaDrop px-5 container-fluid">
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">        

                                <%
                                    boolean isLogin;
                                    if (session.isNew()) {
                                        session.setAttribute("isLogin", false);
                                    }
                                    isLogin = (boolean) session.getAttribute("isLogin");
                                %>

                                <ul class="burger_nav nav nav-pills align-items-center gap-3  p-4">
                                    <li class="nav-item mx-2" style="display: <%= isLogin ? "none" : "initial"%>">
                                        <a class="nav-link active text-light" href="/market/views/login.jsp">Ingresar</a>
                                    </li>
                                    <li class="nav-item mx-2" style="display: <%= isLogin ? "none" : "initial"%>">
                                        <a class="nav-link active text-light" href="/market/views/registro.jsp">Registrarme</a>
                                    </li>
                                    <li class="nav-item mx-2" style="display: <%= !isLogin ? "none" : "initial"%>">
                                        <a class="nav-link active text-light" href="/market/usuario/viewUser">Mi cuenta</a>
                                    </li>
                                    <li class="nav-item mx-2" style="display: <%= !isLogin ? "none" : "initial"%>">
                                        <a class="nav-link active text-light" href="/market/views/anuncioCrear.jsp">Publicar Nuevo anuncio</a>
                                    </li>
                                    <li class="nav-item mx-2" style="display: <%= !isLogin ? "none" : "initial"%>">
                                        <a class="nav-link active text-light" href="/market/anuncios/obtenerLista">Lista de anuncios</a>
                                    </li>
                                    <li class="nav-item mx-2" style="display: <%= !isLogin ? "none" : "initial"%>">
                                        <a class="nav-link active text-light" href="/market/usuario/logoutUser">Salir</a>
                                    </li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </nav>

        </header>

