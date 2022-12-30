
<%@page import="model.Anuncio"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.LinkedList" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Collections" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/views/partials/header.jsp" %>

<%    List<Anuncio> listaAnuncios = (List<Anuncio>) session.getAttribute("listaAnuncios");
    String clase;
%>


<main class="container">

    <div id="card_container" class=" container h-100 w-100 row gap-5  mt-5 p-5">

        <%
            for (int idx = 0; idx < listaAnuncios.size(); idx++) {
                Anuncio elem = listaAnuncios.get(idx);
                clase = "card col-md-4 col-sm-12";

        %>
        <% if (!elem.getComprador().equals("")) {
                clase = "card bg-success text-light justify-content-between col-md-3 col-sm-12";
            }%>
        <div  class="<%= clase%>">


            <div class="card-body ">
                <h5 class="card-title"> <%= elem.getTitulo()%> </h5>
                <p class="card-text"><%= elem.getDescripcion()%></p>
                <p class="card-text text-info">Vendedor: <%= elem.getVendedor()%></p>
                <p class="card-text text-warning">Precio: <%= elem.getPrecio()%></p>
                <p class="card-text text-warning">Comprador: <%= elem.getComprador()%></p>
            </div>
            <div class="card-footer h-20">
                <%
                    if (elem.getComprador().equals("") && !elem.getVendedor().equals((String) session.getAttribute("actualUsername"))) {
                %>
                <a href="/market/anuncios/comprar?id=<%= elem.getId()%>"  class="btn btn-primary">Comprar</a>
                <%
                    }
                    if (elem.getVendedor().equals((String) session.getAttribute("actualUsername"))) {
                        if (elem.getComprador().equals("")) {
                %>
                <a href="/market/anuncios/editar?id=<%= elem.getId()%>"  class="btn btn-warning">Editar</a>
                <%
                    }
                %>
                <a href="/market/anuncios/borrar?id=<%= elem.getId()%>"  class="btn btn-danger">Borrar</a>
                <%

                    }%>
            </div>
        </div>


        <%

            }

        %>



</main>




<%@include file="/views/partials/footer.jsp" %>
