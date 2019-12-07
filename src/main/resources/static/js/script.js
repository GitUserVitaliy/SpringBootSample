function getAll() {
    $.ajax(
        {
            URL: 'api/film/get?id=1',
            type: 'GET',
            contentType: 'application/json; charset=utf-8'
            complete: function (data) {
                var film = data;
               console.log(film.title);
            }

        }
    );
}