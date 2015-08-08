<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Fandango</title>
  <spring:url value="/resources/core/css/hello.css" var="coreCss" />
  <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
  <link href="${bootstrapCss}" rel="stylesheet" />
  <link href="${coreCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/fandango/index">Fandango project</a>
    </div>
  </div>
</nav>

<div class="jumbotron">
  <div class="container">
    <h4>Welcome ${user.email}</h4>
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
        <a class="btn btn-success" href="/movie/getAllMovies" role="button">Movie</a>
      </p>
    </div>
    <div class="col-md-4">
      <h2>Расписание</h2>
      <p>
        <a class="btn btn-success" href="/schedule/getAllSchedule" role="button">Schedule</a>
      </p>
    </div>
  </div>

  <hr>
  <footer>
    <p>&copy; Brazhenko 2015</p>
  </footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>