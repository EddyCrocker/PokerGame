var playerArray = [];
var cardArraySave = [];
var cardDistribute = [];

var cardNumber = {
    T : 'T',
    J : 'J',
    Q : 'Q',
    K : 'K',
    A : 'A'
};

var switchNumber = function (number) {
    var card;
    switch(number){
        case 'TWO':
            card = 2;
            break;
        case 'THREE':
            card = 3;
            break;
        case 'FOUR':
            card = 4;
            break;
        case 'FIVE':
            card = 5;
            break;

        case 'SIX':
            card = 6;
            break;

        case 'SEVEN':
            card = 7;
            break;

        case 'EIGHT':
            card = 8;
            break;

        case 'NINE':
            card = 9;
            break;

        case 'TEN':
            card = cardNumber.T;
            break;

        case 'JACK':
            card = cardNumber.J;
            break;

        case 'QUEEN':
            card = cardNumber.Q;
            break;

        case 'KING':
            card = cardNumber.K;
            break;

        case 'ACE':
            card = cardNumber.A;
            break;

    }
    return card;
};

var cardType = {
    S:'S',
    C:'C',
    D:'D',
    H:'H'
};

var switchcardType = function(type){
    var typeCard;
    switch(type){
        case 'PICCHE':
            typeCard = cardType.S;
            break;

        case 'FIORI':
            typeCard = cardType.C;
            break;

        case 'QUADRI':
            typeCard = cardType.D;
            break;

        case 'CUORI':
            typeCard = cardType.H;
            break;

    }
    return typeCard;
};

$(document).ready(function(){
    var baseUrl = "http://localhost:8080/demo/";
    $("#clickme").click(function(){
        $.ajax({url: baseUrl + "start",
                success: function(result){
                resultSuccess(result);
            }
        });
    });
});

var resultSuccess = function (data) {

    cardArraySave = data;

    for(var i in data){
        for(var x in data[i]){
            var valueConvert = switchNumber(data[i].cardNumber);
            var typeConverter = switchcardType(data[i].cardType);
            var html = '';
            var carta = valueConvert+typeConverter;
            html += '<img class="card" src="img/'+ carta +'.svg"/>';
            $('#my').append(html);
            break;
        }
    }
};
$(document).ready(function() {
    $("#submit").click(function () {
        var numberPlayers = $('#numberPlayers').val();
        var list = $('#form').serializeArray();
        var namePlayer;
        for (var i in list) {
            namePlayer = list[i].value;
        }

        if (numberPlayers !== 0) {
            var baseUrl = "http://localhost:8080/demo/";
            $.ajax({
                type: "GET",
                url: baseUrl + "countPlayer",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: {numberPlayer: numberPlayers,namePlayers:namePlayer},
                success: function (returnedData) {
                    makeAvatar(returnedData);
                }
            });
        }
    });
});

var makeAvatar = function (data) {
    for(var i in data) {

        var playerObject = {
            idPlayer : data[i]['idPlayer'],
            nickName: data[i]['nickName'],
            point: data[i]['point']
        };

        playerArray.push(playerObject);

        var html = '';
        html += '<div class="field"  id="' + data[i]['idPlayer'] + '">' +
            '<img class="" src="img/avatar.svg"/>' +
            '<a> ' + data[i]['nickName'] + '</a>';
        html += '</div>';
        $('#avatarSpace').append(html);
    }
    // resetPlayer();
};

$(document).ready(function() {
    $("#distribute").click(function () {
        if (playerArray.length !== 0) {
            var baseUrl = "http://localhost:8080/demo/";
            var playerObject;
            for (var i in playerArray) {
                console.log(playerArray[i]);
                playerObject = {
                    idPlayer: playerArray[i]['idPlayer'],
                    nickName: playerArray[i]['nickName'],
                    point: playerArray[i]['point']
                };
            }
            $.ajax({
                type: "GET",
                url: baseUrl + "distribute",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: playerObject,
                success: function (returnedData) {

                    for(var i in returnedData){
                        cardDistribute.push(returnedData[i]);
                    }
                }
            });
        }
    });
});

$(document).ready(function() {
    $("#refresh").click(function () {
        if (cardDistribute.length !== 0) {
            var baseUrl = "http://localhost:8080/demo/";
            $.ajax({
                type: "GET",
                url: baseUrl + "update",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: {cards : cardDistribute},
                success: function (returnedData) {
                    console.log(returnedData);
                    cardArraySave = returnedData;
                }
            });
        }
    });
});






