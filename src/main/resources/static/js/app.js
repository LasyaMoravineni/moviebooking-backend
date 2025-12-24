const API_URL = "/api/movies";

async function loadMovies() {
    let genre = document.getElementById("genreFilter").value;
    let language = document.getElementById("languageFilter").value;

    let url = API_URL;

    if (genre) {
        url = `${API_URL}/genre/${genre}`;
    } else if (language) {
        url = `${API_URL}/language/${language}`;
    }

    const response = await fetch(url);
    const movies = await response.json();

    const container = document.getElementById("movies");
    container.innerHTML = "";

    movies.forEach(movie => {
        const card = document.createElement("div");
        card.className = "movie-card";

        card.innerHTML = `
            <h3>${movie.title}</h3>
            <p>🎭 Genre: ${movie.genre}</p>
            <p>🗣 Language: ${movie.language}</p>
            <p>⏱ Duration: ${movie.duration} mins</p>
            ${movie.isUpcoming ? '<span class="badge">Upcoming</span>' : ''}
        `;

        container.appendChild(card);
    });
}

// Load movies on page load
window.onload = loadMovies;
