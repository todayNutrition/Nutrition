<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
시작하시겠습니까?
<a href="StartInput.jsp">Start</a>


<nav class="navbar navbar-light bg-light fixed-top">
  <div class="container-fluid">
<!--     <a class="navbar-brand" href="#">메인페이지</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button> -->
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
<!--         <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Offcanvas</h5> -->
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">메인페이지</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">성분표 업로드</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">그래프</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">목표 설정</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="offcanvasNavbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              달력
            </a>
            <ul class="dropdown-menu" aria-labelledby="offcanvasNavbarDropdown">
              <li><a class="dropdown-item" href="#">상세내역</a></li>
<!--               <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul> -->
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>