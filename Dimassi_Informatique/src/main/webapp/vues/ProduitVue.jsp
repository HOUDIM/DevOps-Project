<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>${produit.nom}</title>

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
                <h3>${produit.nom}</h3>
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
          <div class="card collapse-icon accordion-icon-rotate">
          
            <div class="card-content">
              <div class="card-body">
                <div class="accordion" id="cardAccordion">
                  <div class="card">
                    <span class="collapsed collapse-title"><H3>Nom</H3></span>
                    <div class="card-body">
                      ${produit.nom}
                    </div>
                  </div>
                  <div class="card collapse-header">
                    <span class="collapsed collapse-title"><H3>Prix</H3></span>
                      <div class="card-body">
                        ${produit.prix}
                      </div>
                  </div>
                  <div class="card open">
                    <span class="collapsed collapse-title"><H3>Quantite</H3></span>
                    <div class="card-body">
                      ${produit.quantite}
                    </div>
                  </div>
                  <div class="card">
                      <span class="collapsed collapse-title"><H3>Description</H3></span>
                      <div class="card-body">
                        ${produit.description}
                      </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

      
         
        </div>

        <section class="section">
          <div class="row">
            <div class="col-12">
              <div class="card">
                <div class="card-header">
                  <h5 class="card-title">Photos de ${produit.nom}</h5>
                </div>
                <div class="card-body">
                  <div
                    class="row gallery"
                    data-bs-toggle="modal"
                    data-bs-target="#galleryModal"
                  >
                    <div
                      class="col-6 col-sm-6 col-lg-3 mt-2 mt-md-0 mb-md-0 mb-2"
                    >
                      <a>
                        <img
                          class="w-100 active"
                          src="/../Images/${produit.photos.photo1}"
                          data-bs-target="#Gallerycarousel"
                          data-bs-slide-to="0"
                        />
                      </a>
                    </div>
                    <div
                      class="col-6 col-sm-6 col-lg-3 mt-2 mt-md-0 mb-md-0 mb-2"
                    >
                    <c:if test="${produit.photos.photo2!=null}">
                      <a href="#">
                        <img
                          class="w-100"
                          src="/../Images/${produit.photos.photo2}"
                          data-bs-target="#Gallerycarousel"
                          data-bs-slide-to="1"
                        />
                      </a>
                    </c:if>	  
                    </div>
                    <div
                      class="col-6 col-sm-6 col-lg-3 mt-2 mt-md-0 mb-md-0 mb-2"
                    >
                    <c:if test="${produit.photos.photo3!=null}">
                      <a href="#">
                        <img
                          class="w-100"
                          src="/../Images/${produit.photos.photo3}"
                          data-bs-target="#Gallerycarousel"
                          data-bs-slide-to="2"
                        />
                      </a>
                    </c:if>	  
                    </div>
                    <div
                      class="col-6 col-sm-6 col-lg-3 mt-2 mt-md-0 mb-md-0 mb-2"
                    >
                    <c:if test="${produit.photos.photo4!=null}">
                      <a href="#">
                        <img
                          class="w-100"
                          src="/../Images/${produit.photos.photo4}"
                          data-bs-target="#Gallerycarousel"
                          data-bs-slide-to="3"
                        />
                      </a>
                    </c:if>	  
                    </div>
                  </div>

                  <div
                    class="row mt-2 mt-md-4 gallery"
                    data-bs-toggle="modal"
                    data-bs-target="#galleryModal"
                  >
        
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
