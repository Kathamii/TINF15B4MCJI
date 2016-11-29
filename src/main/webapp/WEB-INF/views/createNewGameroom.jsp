<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <title>Fact Racing</title>
</head>
<body>
<div id="contentOut">
    <div id="contentIn">
        <h1>Fact Racing - Create New Gameroom</h1>

        <form action="gameroom" method="post" class="form">
            <input placeholder="Minimum of players:" type="text" name="minP"><br/>
            <input placeholder="Maximum of players:" type="text" name="maxP"><br/>
            <button type="submit">Create Game Room</button>
        </form>
    </div>
</div>

</body>
</html>

