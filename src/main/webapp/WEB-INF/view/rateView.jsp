<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<!DOCTYPE html>
<html>
<body>

<div class="main">
<br><h2 class="blueL">BLUE LOCK players</h2>
<br><br>
    <c:forEach var="x" items="${allPlayers}">
    <div class="player">
        <div class="rate"><h1 class="rateP">${x.rate}</h1></div>
        <div class="photo">
            <img src="${x.url}" class="blueLF">
        </div>
        <div class="info">
            <a href="#" class="PlayerINFO"> <h1 class="playerI">${x.name} ${x.surname}</h1> </a>
            <p class="defI">Team: ${x.team}</p>
        </div>
        <div class="button" text-align: center; vertical-align: middle;>
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="playerId" value="${x.id}"/>
        </c:url>

            <c:url var="deleteButton" value="/deletePlayer">
                <c:param name="playerId" value="${x.id}"/>
            </c:url>

        <input type="button" class="button-35" value="Update" onclick="window.location.href='${updateButton}'"/>
            <div display: inline-block;>
            <input type="button" class="button-35" value="Delete" onclick="window.location.href='${deleteButton}'"/>
            </div>
        </div>
    </div>
    </c:forEach>
    <br><br>
    <input type="button" value="Add" class="addButn" onclick="window.location.href='addNewPlayer'">

</div>
</body>
</html>
