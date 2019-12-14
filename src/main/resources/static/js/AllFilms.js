function test() {
    $.ajax({
        url: '/api/film/get?id=1',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (film) {
            console.log(film);
            console.log(film.title);
            console.log(film.rating);
            alert('success');
        },
        error: function (response) {
            alert('error');
        }
    });
}
$(document).ready(function (){
    $.ajax({
        url: '/api/film/all',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (films) {
            for (var i = 0; i < films.length; i++) {
                $("#forAdd").before("<tr>" +
                    "<td>" + films[i].id + "</td>" +
                    "<td>" + films[i].title + "</td>" +
                    "<td>" + films[i].rating + "</td>" +
                    "<td>" + films[i].age + "</td>" + "<td>" +
                    "<a class=\"btn btn-primary\" href=\"@{'/FilmService/EditFilm?id=" + films[i].id +"\">Edit</a>" +
                    "<a class=\"btn btn-danger\" href=\"@{'/FilmService/DeleteFilm?id=" + films[i].id +"\">Delete</a>" +
                    "</td>" + "</tr>>")
            }
        },
        error: function (response) {
            alert('error');
        }
    });
});
    
