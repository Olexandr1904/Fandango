<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <style type="text/css">
    .carousel{
      background: #343434;
      margin-top: 0px;
    }
    .carousel .item img{
      margin: 0 auto; /* Align slide image horizontally center */
    }
    .bs-example{
      margin: 0px;
    }
  </style>
  <title>Fandango</title>
  <spring:url value="/resources/core/css/hello.css" var="coreCss" />
  <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
  <link href="${bootstrapCss}" rel="stylesheet" />
  <link href="${coreCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/fandango/index">Brazole project</a>
    </div>
  </div>
</nav>

<div class="jumbotron">
  <div class="container">
        <h3> <c:if test="${reqQuantity !=null}">
          <p>Quantite of ticket on that schedule: <c:out value="${availableTickets}"/><p>
            </c:if>
        </h3>
        <form class="form-inline" role="form" align="right" action="/login/login/" method="POST">
          <div class="form-group">
            <input type="email" name="email" class="form-control" id="email" placeholder="Email">
          </div>
          <div class="form-group">
            <input type="password" name="password" class="form-control" id="pwd" placeholder="Password">
          </div>
          <button type="submit" class="btn btn-default">Enter</button>
          <h5><a href="/login/addUser/">Registration</a></h5>
        </form>
  </div>
</div>
<div class="bs-example">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Carousel indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for carousel items -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="/1.jpg" alt="First Slide">
      </div>
      <div class="item">
        <img src="/2.jpg" alt="Second Slide">
      </div>
      <div class="item">
        <img src="/3.jpg" alt="Third Slide">
      </div>
    </div>
    <!-- Carousel controls -->
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
  </div>
</div>


<div class="container">
  <div class="row">
    <div class="col-md-4">
      <h2>Кинотеатры</h2>
      <p>
        <a class="btn btn-success" href="/cinema/getAllCinemas" role="button">Movie theatre</a>
      </p>
    </div>
    <div class="col-md-4">
      <h2>Фильмы</h2>
      <p>
        <a class="btn btn-success" href="/movie/getAllMovies" role="button">Movies</a>
      </p>
    </div>
    <div class="col-md-4">
      <h2>Расписание</h2>
      <p>
        <a class="btn btn-success" href="/schedule/getAllSchedule" role="button">Schedules</a>
      </p>
    </div>
  </div>

  <hr>
  <footer>
    <p>&copy; Brazhenko 2015 <a href="https://www.facebook.com/sdgeq" class="btn btn-primary btn-mini"><i class="icon-white icon-globe"></i></a></i>
    </a></p>
  </footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>