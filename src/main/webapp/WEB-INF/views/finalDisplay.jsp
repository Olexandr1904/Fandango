<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
  <title>Final page</title>
  <spring:url value="/resources/core/css/hello.css" var="coreCss" />
  <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
  <link href="${bootstrapCss}" rel="stylesheet" />
  <link href="${coreCss}" rel="stylesheet" />
    <style>
        table { table-layout: fixed; }
        table th, table td { overflow: hidden; }
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
<table class="table table-nonfluid table-bordered table-striped">
 <tr><td>Дата сеанса:
 <h3><fmt:formatDate value="${chooseschedule.time.time}" type="BOTH" dateStyle="SHORT" timeStyle="short"/></h3></td>
     <th style="width: 30%" rowspan="3"><img align="left" src="/qrc.png" alt="QR code"></th></tr>
 <tr><td>Кинотаетр: <br>
 <h3>${chooseschedule.cinema.name}</h3></td></tr>
 <tr><td>Фильм:
 <h3>${chooseschedule.movie.name}</h3></td> </tr>
  </table>
    <form align =left action="/send/mail/" method="POST">
        <input name="email">
        <input type=hidden name="ticket" value=${ticket.ticketId}>
        <input type="submit" value="Send ticket">
    </form>
    <p>
       <a onClick="window.print()" class="btn btn-success btn-lg">
           <span class="glyphicon glyphicon-envelope"> Print</span>
        </a>
    </p>
    <hr>
<footer>
  <p>&copy; Brazhenko 2015</p>
</footer>
</div>
</div>
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>
