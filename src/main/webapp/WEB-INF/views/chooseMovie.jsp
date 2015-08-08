<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Fandango schedule</title>
    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
    <%--<style>--%>
        <%--table, th, td {--%>
            <%--border: 2px solid #337ab7;--%>
            <%--border-collapse: collapse;--%>
        <%--}--%>
        <%--th, td {--%>
            <%--padding: 5px;--%>
        <%--}--%>
    <%--</style>--%>
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

    <c:if test="${choosemovie.name==null}">
        <h3>Вы выбрали фильм: ${choosemovie.name}</h3>
    </c:if>

    <table class="table table-bordered table-striped" width="80%">
        <tr>
            <th>Ticket quantity</th>
            <th>Movie theatre</th>
            <th>Schedule date</th>
            <th>Movie</th>
            <th>Free places</th>
            <th>Movie description</th>
            <th>Duration</th>
            <th>Rating</th>
            <th>Movie theatre address</th>
        </tr>
        <c:forEach items="${schedule}" var="schedule">
            <c:if test="${choosecinema.name != null}">
                <c:if test="${choosecinema.cinemaId == schedule.cinema.cinemaId}">

                    <tr>
                        <td><p>

                            <form align =left action="/schedule/sellTicket/" method="POST">
                                <input align="center"  name="ticketquantity" size="1" value="1">
                                <input type=hidden name="scheduleId" value=${schedule.scheduleId}>
                                <input align="center"  type="submit" value="Buy">
                            </form>
                            </p></td>
                        <td>${schedule.cinema.name}</td>
                        <td><fmt:formatDate value="${schedule.time.time}" type="BOTH" dateStyle="SHORT" timeStyle="short"/><br>
                        <td>${schedule.movie.name}</td>
                        <td>${schedule.freePlace}</td>
                        <td>${schedule.movie.description}</td>
                        <td>${schedule.movie.duration}</td>
                        <td>${schedule.movie.rating}</td>
                        <td>${schedule.cinema.adresses}</td>
                    </tr>
                </c:if>
            </c:if>
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