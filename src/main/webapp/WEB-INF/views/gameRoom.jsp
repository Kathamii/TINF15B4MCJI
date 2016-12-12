<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <title>Fact Racing</title>
</head>
<body>
<div id="contentOut">
    <div id="contentIn">
        <h1>Fact Racing - Game Room</h1>

        <form action="/gameField" method="post" class="form2">
            <label>Minimal players:
                <select name="minP">
                    <option value="default">${minP}</option>
                    <option>2</option>
                    <option value="3">3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                </select>
            </label>
            <br/>
            <label>Maximal players:
                <select name="maxP">
                    <option>${maxP}</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option value="5">5</option>
                    <option>6</option>
                </select>
            </label>
            <br/>
            <label>Decks:
                <select name="decks" size="5" multiple>
                    <option value="sport">Sport</option>
                    <option>Music</option>
                    <option value="nature">Nature</option>
                    <option>Literature</option>
                    <option value="sciene">Sciene</option>
                </select>
            </label>
            <br/>
            <input type="radio" name="visibility" value="private" checked>private room
            <input type="radio" name="visibility" value="public">public room
            <br />
            <button type="submit" name="submit">Start Game</button>
        </form>
    </div>
</div>

</body>
</html>