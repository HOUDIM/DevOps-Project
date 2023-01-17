<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<c:if test="${produit.id!=null}">
    <title>Modifier Produit</title>
  </c:if>
  <c:if test="${produit.id==null}">
    <title>Ajouter Produit</title>
  </c:if>
<link
rel="stylesheet"
href="${pageContext.request.contextPath}/assets/extensions/choices.js/public/assets/styles/choices.css"
/>

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
              <div class="col-12 col-md-6 order-md-1 order-last">
                <c:if test="${produit.id!=null}">
                  <h3>Modification de ${produit.nom}</h3>
                </c:if>
                <c:if test="${produit.id==null}">
                  <h3>Ajout d'un Produit</h3>
                </c:if>
                <p class="text-subtitle text-muted">
                  
                </p>
              </div>
              <div class="col-12 col-md-6 order-md-2 order-first">
                <nav
                  aria-label="breadcrumb"
                  class="breadcrumb-header float-start float-lg-end"
                >
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <a href="index.html"></a>
                    </li>
                    
                  </ol>
                </nav>
              </div>
            </div>
          </div>
                  <section id="multiple-column-form">
            <div class="row match-height">
              <div class="col-12">
                <div class="card">
                  
                  <div class="card-content">
                    <div class="card-body">
                      <form class="form" action="/app/produit/sauvgarder" method="post" enctype="multipart/form-data">
                        <div class="row">
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Nom</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="nom"
                                  value="${produit.nom}"
                                  placeholder="Entrer un nom "
                                />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Prix</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="prix"
                                  value="${produit.prix}"
                                  placeholder="Entrer un Prix "
                                />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Qauntité</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="quantite"
                                  value="${produit.quantite}"
                                  placeholder="Entrer une Qauntité "
                                />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Description</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="description"
                                  value="${produit.description}"
                                  placeholder="Entrer une Description "
                                />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="formFileMultiple" class="form-label"
                                >Photos</label
                              >
                              <input
                                class="form-control"
                                type="file"
                                id="formFileMultiple"
                                name="mainPhoto"
                                accept="image/png,image/jpeg"
                              />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="formFileMultiple" class="form-label"
                                >Photos</label
                              >
                              <input
                                class="form-control"
                                type="file"
                                id="formFileMultiple"
                                name="extraImages"
                                multiple
                                accept="image/png,image/jpeg"
                              />
                            </div>
                          </div>
                         <div class="col-md-6 col-12">
                          <div class="form-group">
                            <label for="formFileMultiple" class="form-label"
                                >Sous categorie</label
                              >
                            <select
                              class="choices form-select multiple-remove"
                              multiple="multiple" name="sousCategorie"
                            >
                            <c:forEach items="${sousCategorie}" var="cc">
                              <option value=${cc.id} <c:forEach items="${produit.sousCategorie}" var="pc"> <c:if test="${pc.id==cc.id}">selected="true"</c:if>  </c:forEach>>${cc.nom} </option>
                            </c:forEach>
                            </select>
                          </div>
                         </div>
                         <input type=hidden name="photo1" value="${produit.photos.photo1}">
                         <c:if test="${produit.photos.photo2!=null}">
                            <input type=hidden name="photo2" value="${produit.photos.photo2}">
                          </c:if>
                          <c:if test="${produit.photos.photo3!=null}">
                            <input type=hidden name="photo3" value="${produit.photos.photo3}">
                          </c:if>
                          <c:if test="${produit.photos.photo4!=null}">
                            <input type=hidden name="photo4" value="${produit.photos.photo4}">
                          </c:if>
                         <input type=hidden name=id value="${produit.id}">
                          <div class="col-12 d-flex justify-content-end" style="margin-top: 20px;">
                            <c:if test="${produit.id!=null}">
                              <button type="submit" class="btn btn-primary me-1 mb-1">Modifier</button>
                            </c:if>
                            <c:if test="${produit.id==null}">
                              <button type="submit" class="btn btn-primary me-1 mb-1">Ajouter</button>
                            </c:if>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
          

      
         
        </div>

    
        <%@ include file="footer.html" %>  
      </div>
    </div>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/assets/extensions/choices.js/public/assets/scripts/choices.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/pages/form-element-select.js"></script>
  </body>
</html>
