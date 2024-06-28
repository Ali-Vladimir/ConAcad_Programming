<?php
$host = trim(fgets(STDIN));
$user = trim(fgets(STDIN));
$password = trim(fgets(STDIN));
$data_base = trim(fgets(STDIN));
$con = new mysqli($host, $user, $password, $data_base);
if ($con->connect_error) {
    die($con->connect_error);
}
$sql = "SELECT j.ganador, SUM(j.puntos) AS total_puntos, u.Nombre AS nombre_ganador, u.Apellidos AS apellidos_ganador
        FROM juegos j
        INNER JOIN usuarios u ON j.ganador = u.Usuario
        GROUP BY j.ganador
        ORDER BY total_puntos DESC
        LIMIT 1";
$result = $con->query($sql);
if ($result->num_rows > 0) {
    $fila = $result->fetch_assoc();
    $winner_name = $fila['nombre_ganador'];
    $winner_lastname = $fila['apellidos_ganador'];
    $total = $fila['total_puntos'];
    echo "El jugador con más puntos es: $winner_name $winner_lastname, con un total de $total puntos.";
} else {
    echo "No hay jugadores en la base de datos.";
}
$con->close();