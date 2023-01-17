<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<c:if test="${visiteur.id!=null}">
    <title>Modifier Utilisateur</title>
  </c:if>
  <c:if test="${visiteur.id==null}">
    <title>Ajouter Utilisateur</title>
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
                <c:if test="${visiteur.id!=null}">
                  <h3>Modification de ${visiteur.prenom} ${visiteur.nom}</h3>
                </c:if>
                <c:if test="${visiteur.id==null}">
                  <h3>Ajout d'un utilisateur</h3>
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
                      <form class="form" action="/app/visiteur/sauvgarder" method="post" enctype="multipart/form-data">
                        <div class="row">
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Nom</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="nom"
                                  value="${visiteur.nom}"
                                  placeholder="Entrer un nom "
                                  required
                                />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Prenom</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="prenom"
                                  value="${visiteur.prenom}"
                                  placeholder="Entrer un prenom "
                                  required
                                />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Email</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="email"
                                  value="${visiteur.email}"
                                  placeholder="Entrer un email "
                                  required
                                />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Mot de passe</label>
                                <input
                                  type="password"
                                  class="form-control"
                                  id="basicInput"
                                  name="password"
                                  value="${visiteur.password}"
                                  placeholder="Entrer un Mot de passe "
                                  required
                                />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="formFileMultiple" class="form-label"
                                >Photo</label
                              >
                              <input
                                class="form-control"
                                type="file"
                                id="formFileMultiple"
                                name="photo1"
                                accept="image/png,image/jpeg"
                                required
                              />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Rue</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="rue"
                                  value="${visiteur.adresse.rue}"
                                  placeholder="Entrer un Rue "
                                  required
                                />
                            </div>
                          </div>
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Ville</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="ville"
                                  value="${visiteur.adresse.ville}"
                                  placeholder="Entrer une Ville "
                                  required
                                />
                            </div>
                          </div>
                        
                          <div class="col-md-6 col-12">
                            <div class="form-group">
                              <label for="basicInput">Numero</label>
                                <input
                                  type="text"
                                  class="form-control"
                                  id="basicInput"
                                  name="numero"
                                  value="${visiteur.adresse.numero}"
                                  placeholder="Entrer un Numero "
                                  required
                                />
                            </div>
                            
                            <div class="col-md-6 col-12">
                              <div class="form-group">
                                <label for="basicInput">Code Postal</label>
                                  <input
                                    type="text"
                                    class="form-control"
                                    id="basicInput"
                                    name="codePostal"
                                    value="${visiteur.adresse.codePostal}"
                                    placeholder="Entrer un Code Postal "
                                    required
                                  />
                              </div>
                            </div>
                            
                            
                          
                          <input type=hidden name="photo" value="${visiteur.photo}">
                          <input type=hidden name="id" value="${visiteur.id}">
                          <div class="col-12 d-flex justify-content-end" style="margin-top: 20px;">
                            <c:if test="${visiteur.id!=null}">
                              <button type="submit" class="btn btn-primary me-1 mb-1">Modifier</button>
                            </c:if>
                            <c:if test="${visiteur.id==null}">
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
