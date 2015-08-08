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

<div class="container">
  <div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container">
        <a class="brand" href="#">Project name</a>
        <div class="nav-collapse collapse">
          <ul class="nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
  </div>
</div>

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