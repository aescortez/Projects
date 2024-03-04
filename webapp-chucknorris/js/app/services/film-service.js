define(function() {
    var internals = {}; // internal state
    var externals = {}; // external api



   externals.fetchJoke = function(cb) {
        var apiUrl = `https://api.chucknorris.io/jokes/random`;
        
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                cb(data); // Pass the fetched IMDb data to the callback function
            })
            .catch(error => {
                console.error('Error fetching joke data:', error);
                cb(null); // Pass null to the callback in case of an error
            });
    };

    return externals;
});














