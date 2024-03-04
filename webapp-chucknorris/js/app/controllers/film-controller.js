define(['views/film-view', 'services/film-service'], function(
    filmView,
    filmService
) {
    var externals = {};
    var internals = {};

    externals.start = function() {
        internals.bindEventHandlers();
        filmView.render();
    };

    internals.bindEventHandlers = function() {
        filmView.bind('button', internals.buttonHandler);
    };

    internals.buttonHandler = function() {
        filmService.fetchJoke(function(joke) {
            filmView.render(joke);
        });
    }; 

    return externals;
});
