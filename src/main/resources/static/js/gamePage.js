var current = "teal";
var colors = ["none", "none", "none", "none", "none", "none", "none", "none", "none"];

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

function turn(number) {
    //	$("#s" + number).css("background-color", current); .non-animate
    $("#s" + number).animate({ // animate
        backgroundColor: current,
        marginTop: 3,
        borderColor: "black",
    }, 322)

    colors[number - 1] = current;
    if (current === "teal") {
        current = "aqua";
    } else {
        current = "teal";
    }
    $("#s" + number).prop("disabled", "true");
    var result = check();
    if (result != "none") {
        for (let i = 0; i < 9; i++) {
            $("#s" + i).prop("disabled", "true");
        }
        $("#result").animate({ // animate
            backgroundColor: result,
        }, 322);
        $("#result").text("<Winner>");
    }
    if (result == "draw") {
        $("#result").animate({ // animate
            backgroundColor: "white",
        }, 322);
        $("#result").text("<Draw>");
    }
}


function check() {
    let count = 0;
    if (colors[0] == colors[1] && colors[1] == colors[2] && colors[0] != "none") {
        return colors[0];
    }
    if (colors[3] == colors[4] && colors[4] == colors[5] && colors[0] != "none") {
        return colors[3];
    }
    if (colors[6] == colors[7] && colors[7] == colors[8] && colors[0] != "none") {
        return colors[6];
    }
    if (colors[0] == colors[3] && colors[3] == colors[6] && colors[0] != "none") {
        return colors[0];
    }
    if (colors[1] == colors[4] && colors[4] == colors[7] && colors[0] != "none") {
        return colors[1];
    }
    if (colors[2] == colors[5] && colors[5] == colors[8] && colors[0] != "none") {
        return colors[2];
    }
    if (colors[0] == colors[4] && colors[4] == colors[8] && colors[0] != "none") {
        return colors[0];
    }
    if (colors[2] == colors[4] && colors[4] == colors[6] && colors[0] != "none") {
        return colors[2];
    }
    for (let i = 0; i < 9; i++) {
        if (colors[i] == "none") {
            count++;
        }
    }
    if (count == 0) {
        return "draw";
    } else {
        return "none";
    }
}

function restart() {
    for (let i = 0; i < 9; i++) {
        colors[i] = "none";
    }
    for (let i = 1; i < 10; i++) {
        $("#s" + i).animate({
            backgroundColor: white
        }, 322)
    }
}