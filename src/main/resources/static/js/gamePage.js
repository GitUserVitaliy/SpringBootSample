function removeByJquery() {
    let element = $("#card-to-delete");
    element.remove();
}

function add() {
    let but2 = $("#button-to-add");
    but2.after("<h2>Hello, ma friend</h2>");
}

let colorGamer1;
let colorGamer2;

function turn2(number) {
    for (let i = 0; i <= 90; i+=10) {
        if(i == number){
            colorGamer1 = $("#color"+i).css("background-color");
            $("#colorPlayer1").css("background-color", colorGamer1);
        }
    }
    console.log(colorGamer1);
    for (let i = 0; i <= 99; i+=11) {
        if(i == number){
            colorGamer2 = $("#color"+i).css("background-color");
            $("#colorPlayer2").css("background-color",colorGamer2);
        }
    }

    console.log(colorGamer2);
    if (colorGamer1 === colorGamer2) {
        $("#check").text("Выберите два разных цвета");
    } else if (colorGamer1 === undefined || colorGamer2 === undefined) {
        $("#check").text("Выберите второй цвет");
    } else {
        $("#check").text("");
    }

}


let current = colorGamer1;
let colors = ["none", "none", "none", "none", "none", "none", "none", "none", "none"];

let score1 = 0;
let score2 = 0;

function turn(number) {
    // $("#s" + number).css("background-color", current);
    $("#a" + number).animate({
        backgroundColor: current,
        borderColor: "#fff"
    }, 300);
    colors[number - 1] = current;
    if (current === colorGamer1) {
        current = colorGamer2;
    } else {
        current = colorGamer1;
    }

    $("#a" + number).prop("disabled", true);
    let result = check();
    if (result != "none") {
        for (let i = 0; i < 10; i++) {
            $("#a" + i).prop("disabled", true);
        }
        $("#result").animate({
            backgroundColor: result,
        }, 200);
        if (result === colorGamer1) {
            score1++;
            $("#score1").text(score1);
        } else if (result === colorGamer2) {
            score2++;
            $("#score2").text(score2);
        } else {
            $("#result").text("Draw");
        }
    }
    console.log(result);
}

function check() {
    for (let i = 0; i < 7; i += 3) {
        if (colors[0 + i] == colors[1 + i] && colors[1 + i] == colors[2 + i] && colors[2 + i] != "none") {
            return colors[0 + i];
        }
    }
    for (let i = 0; i < 3; i += 1) {
        if (colors[0 + i] == colors[3 + i] && colors[3 + i] == colors[6 + i] && colors[6 + i] != "none") {
            return colors[0 + i];
        }
    }
    if (colors[0] == colors[4] && colors[4] == colors[8] && colors[0] != "none") {
        return colors[0];


    }
    if (colors[2] == colors[4] && colors[4] == colors[6] && colors[6] != "none") {
        return colors[2];
    }
    let wasNone = false;
    for (let i = 0; i < 9; i++) {
        if (colors[i] == "none") {
            wasNone = true;
        }
    }
    if (wasNone == false) {
        return "draw";
    }
    return "none";
}

function Play() {
    if (colorGamer1 !== colorGamer2) {
        for (let i = 1; i < 10; i++) {
            $("#a" + i).css("background-color", "#d1ecf1");
            $("#a" + i).prop("disabled", false);
        }
        for (let i = 0; i < 9; i++) {
            colors[i] = "none";
        }
        current = colorGamer1;
        $("#result").css("background", "none");
        $("#result").text("");

        for (let i = 1; i <= 2; i++) {
            $("#player"+i).prop('disabled', true);
            $("#player"+i).css("border", "none");
            $("#player"+i).css("background-color", "#fff");
        }
        for (let i = 10; i <= 90; i+=10) {
            $("#color"+i).prop('disabled', true);
        }
        for (let i = 11; i <= 99; i+=11) {
            $("#color"+i).prop('disabled', true);
        }

    }
}

function Name(namePlayer) {
    console.log(namePlayer)
}