<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/style.css" type="text/css" rel="stylesheet" />
    <title>Fact Racing</title>
</head>
<body>

<div id="contentOut">
    <div id="contentIn">
        <h1>Fact Racing</h1>

        <form action="/buttonsMain" method="post" class="form">
            <button type="submit" name="create" value="1">Create New Gameroom</button><br/>
            <button type="submit" name="join" value="1">Join Random Game</button><br/>
            <button type="submit" name="read" value="1">Read manual</button>
        </form>
    </div>
</div>
</body>
</html>
