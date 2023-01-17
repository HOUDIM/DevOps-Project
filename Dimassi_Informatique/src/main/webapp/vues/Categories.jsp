
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Categories</title>

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
            <h3>Categories</h3>
          </div>
        </div>
      </div>
      <section class="section">
        <div class="card"> 
            <div class="card-body">
              <div class="row">
                <h6>Recherche</h6>
                <div class="col-12" style="display: flex; justify-content: space-between;align-items: center;margin-bottom: 50px;">
                  <div class="form-group position-relative has-icon-right" >
                    <input type="text" class="form-control" placeholder="Chercher..." style="width: 500px;"/>
                    <div class="form-control-icon">
                      <i class="bi bi-search"></i>
                    </div>
                  </div>
                  <a href="/app/categorie/ajouter" class="btn btn-primary rounded-pill" style="width: 100px;" >Ajouter</a>
                </div>      
                <!-- table contextual / colored -->
                <div class="table-responsive">
                  <table class="table table-striped mb-0">
                    <thead>
                      <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${liste}" var="p">
                        <tr >
                          <td>${p.id}</td>
                          <td>${p.nom}</td>
                          <td>
                            
                            <a href="/app/categorie/modifier/${p.id}"><i class="bi bi-gear" style="font-size: 20px; margin-right: 6px;color: rgb(0, 227, 91);"></i></a>
                            <a href="/app/categorie/supprimer/${p.id}" class="sidebar-item"><i class="bi bi-trash" style="font-size: 20px; margin-right: 6px; color: red;"></i></a>
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
