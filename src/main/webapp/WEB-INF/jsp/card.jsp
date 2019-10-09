<html>
    <head>
        <script src="webjars/jquery/3.4.0/jquery.js"></script>
        <link href="${pageContext.request.contextPath}/css/cards.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="https://unpkg.com/cardsJS/dist/cards.min.css" />
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </head>
        <body>
            <h1>LISTA CARTE</h1>
            <button id="clickme">click me</button>
            <div id="my" class="hand hhand-compact active-hand">
            </div>
            <div>
                <form id="form">
                    <input type="text" id="namePlayer1" name="nickName">
                    <label for="namePlayer1">INSERISCI NICKNAME</label>
                </form>
                <button id="submit">SAVE</button>
            </div>
        <div id="avatarSpace">

        </div>
        </body>
</html>