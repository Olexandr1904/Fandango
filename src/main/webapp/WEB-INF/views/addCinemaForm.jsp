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
  <div class="row">
    <div class="col-sm-8">
      <a class="navbar-brand"  href="/fandango/index">Fandango project</a>
    </div>

    <div class="col-sm-4">
      <a class="navbar-brand" href="/fandango/addUser">Регистрация</a>
    </div>
  </div>
</nav>

<div class="jumbotron">
  <div class="container">
    <h1>Привет Админ </h1>
  </div>
</div>



<div class="container">
  <form name="addCinema" role="form" action="/cinema/addCinema/" method="POST">
    <div class="form-group">
      <label for="usr">Название кинотеатра:</label>
      <input type="text" class="form-control" name="name" id="usr">

      <label for="comment">Описание:</label>
      <textarea class="form-control" rows="2" name="adress" id="comment"></textarea>

      <label for="sq">Количество свободных мест:</label>
      <input type="text" class="form-control" name="numberOfSeats" id="sq">
      <input align="center"  type="submit" value="Добавить">
    </div>
  </form>
</div>




  <footer>
    <p>&copy; Brazhenko 2015</p>
  </footer>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>