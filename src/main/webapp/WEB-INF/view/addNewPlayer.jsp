<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Player Info</h2>
<br>
<%--@elvariable id="player" type="com.solvd.players.models.Player"--%>
<form:form action="savePlayer" modelAttribute="player" method="get">
    <c:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Rate <form:input path="rate"/>
    <br><br>
    Team Z <form:radiobutton path="team" value="Z"/>, Y <form:radiobutton path="team" value="Y"/>, X
    <form:radiobutton path="team" value="X"/>, W <form:radiobutton path="team" value="W"/>, None
    <form:radiobutton path="team" value="None"/>
    <br><br>
    Photo url <form:input path="url"/>
    <br><br>
    <input type="submit" value="OK"/>
</form:form>
</body>
</html>