<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <c:if test="${commentaire.id!=null}">
    <title>Modifier Commentaire</title>
  </c:if>
  <c:if test="${commentaire.id==null}">
    <title>Ajouter Commentaire</title>
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
                <c:if test="${commentaire.id!=null}">
                  <h3>Modification de Commentaire</h3>
                </c:if>
                <c:if test="${commentaire.id==null}">
                  <h3>Ajout d'une sous Commentaire</h3>
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
                      <form class="form" action="/app/commentaire/sauvgarder" method="post" enctype="multipart/form-data">
                        <div class="row">
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label class="form-label" for="basicInput">Date</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="date"
                                  value="${commentaire.date}"
                                  placeholder="Entrer une date"
                                />
                            </div>
                          </div>

                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label class="form-label" for="basicInput">Texte</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="texte"
                                  value="${commentaire.texte}"
                                  placeholder="Entrer une Commentaire"
                                />
                            </div>
                          </div>
                          
                          
                    
                         <div class="col-md-6 col-12">
                          <div class="form-group">
                            <label for="formFileMultiple" class="form-label"
                                >Visiteur</label
                              >
                              <select class="form-select" id="basicSelect" name="visiteur">
                                <option selected>Choisir un visiteur</option>
                                <c:forEach items="${visiteur}" var="cc" >
                                  <option value=${cc.id} <c:if test="${commentaire.visiteur.id==cc.id}">selected="true"</c:if>>${cc.nom} </option>
                                </c:forEach>
                              </select>
                          </div>
                         </div>

                         <div class="col-md-6 col-12">
                          <div class="form-group">
                            <label for="formFileMultiple" class="form-label"
                                >Produit</label
                              >
                              <select class="form-select" id="basicSelect" name="produit">
                                <option selected>Choisir un Produit</option>
                                <c:forEach items="${produit}" var="cc" >
                                  <option value=${cc.id} <c:if test="${commentaire.produit.id==cc.id}">selected="true"</c:if>>${cc.nom} </option>
                                </c:forEach>
                              </select>
                          </div>
                         </div>
                         <input type=hidden name="id" value="${commentaire.id}">
                          <div class="col-12 d-flex justify-content-end" style="margin-top: 20px;">
                            <c:if test="${commentaire.id!=null}">
                              <button type="submit" class="btn btn-primary me-1 mb-1">Modifier</button>
                            </c:if>
                            <c:if test="${commentaire.id==null}">
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
