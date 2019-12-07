function getAll() {
    $.ajax(
        {
            URL: 'api/film/get?id=1',
            type: 'GET',
            contentType: 'application/json; charset=utf-8',
            complete: function pipe(data) {
                var film = data;
                console.log(film.title);
            }
        }
    );
}