
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Produits</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main/app.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main/app-dark.css" />
<link
  rel="shortcut icon"

  href="${pageContext.request.contextPath}/assets/images/logo/favicon.svg"
  type="image/x-icon"
/>
<link
  rel="shortcut icon"
  href="${pageContext.request.contextPath}/assets/images/logo/favicon.png"
  type="image/png"
/>
</head>
<body>
<script src="${pageContext.request.contextPath}/assets/js/initTheme.js"></script>
<div id="app">
  
  <%@ include file="sidebar.html" %>
  <div id="main">
    <header class="mb-3">
      <a href="#" class="burger-btn d-block d-xl-none">
        <i class="bi bi-justify fs-3"></i>
      </a>
    </header>
    <div class="page-heading">
      <div class="page-title">
        <div class="row">
          <div class="col-12 col-md-6 order-md-1 order-last" style="margin-top: 20px;margin-bottom: 20px;">
            <h3>Produits informatiques</h3>
          </div>
        </div>
      </div>
      <section class="section">
        <div class="card"> 
            <div class="card-body">
              <div class="row">
                <h6>Recherche</h6>
                <form method=get action=produitmc>
                <div class="col-12" style="display: flex; justify-content: space-between;align-items: center;margin-bottom: 50px;">
                  <div class="form-group position-relative has-icon-right" >
                    
                    <input type="text" class="form-control" placeholder="Chercher..." style="width: 500px;" id="mc" name="mc"/>
                    <div class="form-control-icon">
                      <i class="bi bi-search" ></i>
                      <!-- <button type="submit" class="btn btn-primary">Chercher</button> -->
                    </div>
                    <!-- <div class="col-md-3">
                      <button type="submit" class="btn btn-primary">Chercher</button>
                    </div> -->
                  </div>
                  <a href="/app/produit/ajouter" class="btn btn-primary rounded-pill" style="width: 100px;" >Ajouter</a>
                </div> 
              </form>     
                <!-- table contextual / colored -->
                <div class="table-responsive">
                  <table class="table table-striped mb-0">
                    <thead>
                      <tr>
                        <th>Photo</th>
                        <th>Nom</th>
                        <th>Prix</th>
                        <th>Quantité</th>
                        <th>Sous Catégories</th>
                        <th>Description</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${liste}" var="p">
                        <tr >
                          <td class="text-bold-500"><img src="/../Images/${p.photos.photo1}" alt="Logo" srcset=""
                            style="width: 75px;height: 75px;border-radius: 15%;" /></td>
                          <td>${p.nom}</td>
                          <td>${p.prix}</td>
                          <td>${p.quantite}</td>
                          <td><c:forEach items="${p.sousCategorie}" var="sc" varStatus="ss">${sc.nom}<c:if test="${!ss.last}">, </c:if></c:forEach> </td>                          <td>${p.description}</td>
                          <td>
                            <a href="/app/produit/produitVue/${p.id}" class="sidebar-item"><i class="bi bi-eye" style="font-size: 20px; margin-right: 6px; color: rgb(3, 123, 252);"></i></a>
                            <a href="/app/produit/modifier/${p.id}"><i class="bi bi-gear" style="font-size: 20px; margin-right: 6px;color: rgb(0, 227, 91);"></i></a>
                            <a href="/app/produit/supprimer/${p.id}" class="sidebar-item"><i class="bi bi-trash" style="font-size: 20px; margin-right: 6px; color: red;"></i></a>
                          </td>
                        </tr>
                      </c:forEach>               
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
  </div>
      <!-- Contextual classes end -->
  <%@ include file="footer.html" %>      
  </div>
</div>
<script src="
${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
<script src="
${pageContext.request.contextPath}/assets/js/app.js"></script>
</body>
</html>
