define(function() {
    var internals = {
        handlers: {},
        elements: {}
    };

    var externals = {};

    internals.createButton = function() {
        return '<button type="button" class="btn btn-dark">Hit Me for a Chuck Norris Fact</button>';
    };

    internals.createJokeCard = function(joke) {
        return (
            '<div>' +
            '<p><strong>True Story: </strong>' +
            joke.value +
            '</p>' +
            '</div>'
        );
    };

    internals.renderJoke = function(joke) {
        if (internals.elements.jokeCard) {
            internals.elements.jokeCard.empty();
        }

        internals.elements.jokeCard = $(internals.createJokeCard(joke));
        internals.elements.app.append(internals.elements.jokeCard);
    };

    internals.renderButton = function() {
        if (internals.elements.button) {
            return;
        }

        internals.elements.button = $(internals.createButton());
        internals.elements.button.click(internals.handlers['button']);
        internals.elements.app.append(internals.elements.button);
    };

    externals.bind = function(event, handler) {
        internals.handlers[event] = handler;
    };

    externals.render = function(joke) {
        internals.elements.app = $('#app');
        internals.renderButton();

        if (joke) {
            internals.renderJoke(joke);
        }
    };

    return externals;
});
