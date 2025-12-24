function loadMovies() {
    fetch('/api/movies')
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById('movies');
            list.innerHTML = '';
            data.forEach(movie => {
                const li = document.createElement('li');
                li.innerText = movie.title + ' (' + movie.language + ')';
                list.appendChild(li);
            });
        })
        .catch(err => {
            alert('Error loading movies');
            console.error(err);
        });
}

