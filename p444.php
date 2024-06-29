<?php
$numbConsults = trim(fgets(STDIN));
for ($index = 0; $index < $numbConsults; $index++) {
    $userInput = trim(fgets(STDIN));
    list($searchType, $searchTerm) = explode(' ', $userInput, 2);
    $apiKey = '1d5d8550';
    $foundMovies = [];
    if ($searchType === 't') {
        $urlApi = "http://www.omdbapi.com/?t=" . urlencode($searchTerm) . "&apikey=$apiKey";
        $answer = file_get_contents($urlApi);
        $datos = json_decode($answer, true);
        if ($datos['Response'] === 'True') {
            $foundMovies[] = ['titulo' => $datos['Title'], 'año' => $datos['Year']];
        }
    } elseif ($searchType === 's') {
        $urlApi = "http://www.omdbapi.com/?s=" . urlencode($searchTerm) . "&apikey=$apiKey";
        $answer = file_get_contents($urlApi);
        $datos = json_decode($answer, true);
        if ($datos['Response'] === 'True') {
            foreach ($datos['Search'] as $movie) {
                $foundMovies[] = ['titulo' => $movie['Title'], 'año' => $movie['Year']];
            }
        }
    }
    if (empty($foundMovies)) {
        echo "No Match Picture\n";
    } else {
        usort($foundMovies, function ($movie, $movie2) {
            if ($movie['año'] == $movie2['año']) {
                return strcasecmp($movie['titulo'], $movie2['titulo']);
            }
            return $movie['año'] - $movie2['año'];
        });
        foreach ($foundMovies as $movie) {
            echo $movie['titulo'] . ' ' . $movie['año'] . "\n";
        }
    }
    if ($index < $numbConsults - 1) {
        echo "******\n";
    }
}