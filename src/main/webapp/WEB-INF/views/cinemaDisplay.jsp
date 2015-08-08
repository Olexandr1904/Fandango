<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Fandango cinemas</title>
  <spring:url value="/resources/core/css/hello.css" var="coreCss" />
  <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
  <link href="${bootstrapCss}" rel="stylesheet" />
  <link href="${coreCss}" rel="stylesheet" />
  <style>
    table, th, td {
      border: 2px solid #337ab7;
      border-collapse: collapse;
    }
    th, td {
      padding: 5px;
    }
  </style>
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
    <h1>${title}</h1>
    <p>
      <a class="btn btn-primary btn-lg" href="/fandango/index" role="button">Main page</a>
    </p>
  </div>
</div>

<div class="container">
  <table class="table table-bordered table-striped" width="80%">
      <tr>
        <th>Choose</th>
        <th>Movie theatre</th>
        <th>Address</th>
        <th>Place quantity</th>
      </tr>
      <c:forEach items="${cinemas}" var="cinema">
        <tr>
          <td><p>
            <form align =center action="/movie/chooseMovie" method="POST">
              <input type=hidden name="cinemaId" value=${cinema.cinemaId}>
              <input type="submit" value="Choose">
            </form>
          </p></td>
          <td>${cinema.name}</td>
          <td>${cinema.adresses}</td>
          <td>${cinema.numberOfSeats}</td>
        </tr>
      </c:forEach>
    </table>

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