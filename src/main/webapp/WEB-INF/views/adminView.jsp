<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Fandango admin</title>
    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />

    <style>
        /*body {*/
            /*position: relative;*/
        /*}*/
        /*#section1 {padding-top:50px;height:500px;color: #fff; background-color: #1E88E5;}*/
        /*#section2 {padding-top:50px;height:500px;color: #fff; background-color: #673ab7;}*/
        /*#section3 {padding-top:50px;height:500px;color: #fff; background-color: #ff9800;}*/
        <%--table, th, td {--%>
            <%--border: 2px solid #337ab7;--%>
            <%--border-collapse: collapse;--%>
        <%--}--%>
        <%--th, td {--%>
            <%--padding: 5px;--%>
        <%--}--%>
    </style>
</head>

<body data-spy="scroll" data-target=".navbar" data-offset="50">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/fandango/index">Fandango admin</a>
        </div>
        <div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="#section1">Список Сеансов</a></li>
                    <li><a href="#section2">Список Кинотеатров</a></li>
                    <li><a href="#section3">Список Фильмов</a></li>
                    <li><a href="/schedule/addSchedule">Добавить сеанс</a></li>
                    <li><a href="/cinema/addCinemaForm/">Добавить Кинотеатр</a></li>
                    <li><a href="/movie/addMovie/">Добавить Фильм</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<div class="container">
<div id="section1" class="container-fluid">
    <h1>Список Расписаний</h1>
    <table class="table table-bordered table-striped" width="80%">
        <tr>
            <th>Удалить</th>
            <th>Название кинотеатра</th>
            <th>Дата сеанса</th>
            <th>Название фильма</th>
            <th>Количество свободных мест</th>
            <th>Описание фильма</th>
            <th>Длительность фильма</th>
            <th>Рейтинг фильма</th>
            <th>Адрес Кинотеатра</th>
        </tr>
        <c:forEach items="${schedule}" var="schedule">
            <tr>
                <td><p>
                    <form align =left action="/login/delete/" method="POST">
                        <input type="hidden" name="scheduleId" value=${schedule.scheduleId}>
                        <input align="center" type="submit" value="Удалить">
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
        </c:forEach>
    </table>
</div>
<div id="section2" class="container-fluid">
    <h1>Список Кинотеатров</h1>
    <table class="table table-bordered table-striped" width="80%">
        <tr>
            <th>Выбрать</th>
            <th>Название кинотеатра</th>
            <th>Адрес </th>
            <th>Количество мест</th>
        </tr>
        <c:forEach items="${cinemas}" var="cinema">
            <tr>
                <td><p>
                    <form align =center action="/login/delete/" method="POST">
                        <input type="hidden" width="20px" name="cinemaId" value=${cinema.cinemaId}>
                        <input type="submit" value="Удалить">
                    </form>
                    </p></td>
                <td>${cinema.name}</td>
                <td>${cinema.adresses}</td>
                <td>${cinema.numberOfSeats}</td>
            </tr>
        </c:forEach>
    </table>

</div>
<div id="section3" class="container-fluid">
    <h1>Список Фильмов</h1>
    <table class="table table-bordered table-striped" width="80%">
        <tr>
            <th>Удалить </th>
            <th>Название фильма </th>
            <th>Описание</th>
            <th>Рейтинг</th>
            <th>Жанр</th>
            <th>Продолжительность</th>
            <th>Обновить</th>
        </tr>
        <c:forEach items="${movie}" var="movie">
        <form action="/movie/update/" method="POST">
            <tr>
                <td><p>
                    <form align =center action="/login/delete/" maxlength="300" method="post">
                        <input type="hidden" name="movieId" value=${movie.movieId}>
                        <input type="submit" value="Удалить">
                    </form>
                        ${movie.movieId}
                    </p></td>
                <td><input name="movieName" value=${movie.name}></td>
                <%--<td>${movie.name}</td>--%>
                <td>${movie.description}</td>
                <td>${movie.rating}</td>
                <td>${movie.genre}</td>
                <td>${movie.duration} минут</td>
                <td><input align="right" type="submit" value="Обновить"></td>
            </tr>
        </form>
        </c:forEach>
    </table>


</div>
</div>
<footer><p>&copy; Brazhenko 2015</p></footer>
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>