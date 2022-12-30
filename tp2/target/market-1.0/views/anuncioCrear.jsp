

<%@include file="/views/partials/header.jsp" %>

<%
  
  if (!(boolean)session.getAttribute("isLogin")){
    response.sendRedirect("/market");
  } 
%>

<main class="container d-flex justify-content-center align-items-center">

    
    <form method="POST" action="/market/anuncios/crear" class="w-50 px-5 py-4 rounded" >
        <h2 class="mb-4 text-center">Publicar Anuncio</h2>
        <div class="row mb-3">
            <label for="vendedor" class="col-4 formlabel">Vendedor:</label>
            <input type="text" id="vendedor" name="vendedor" class="col-8 formcontrol" value="<%= (String) session.getAttribute("actualUsername") %>" disabled>
        </div>

        <div class="row mb-3">
            <label for="titulo" class="col-4 formlabel">Titulo</label>
            <input type="text" id="titulo" name="titulo" class="col-8 formcontrol" required>
        </div>

        <div class="row mb-3">
            <label for="descripcion" class="col-4 formlabel">descripcion</label>
            <input type="text" id="descripcion" name="descripcion" class="col-8 formcontrol" required>
        </div>

        <div class="row mb-3">
            <label for="precio" class="col-4 formlabel">precio</label>
            <input type="number" id="precio" name="precio" class="col-8 formcontrol" required="">
        </div>

        <div class="row align-items-center justify-content-between">
            <div class="col-auto">
                <button class="btn btn-dark" type="submit">Publicar</button>
            </div>
            <div class="col-auto">
                <a href="/market" class="link-primary">Inicio</a>
            </div>
        </div>
    </form>
</main>

<%@include file="/views/partials/footer.jsp" %>
