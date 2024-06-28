<?php
$host = trim(fgets(STDIN));
$user = trim(fgets(STDIN));
$password = trim(fgets(STDIN));
$data_base = trim(fgets(STDIN));
$conn = new mysqli($host, $user, $password, $data_base);
if ($conn->connect_error) {
    die($conn->connect_error);
}
$sql_invited = "SELECT u.Nombre, u.Apellidos, COUNT(j.id_usuario) AS total_invitaciones
               FROM juegos j
               JOIN usuarios u ON j.id_usuario = u.Usuario
               GROUP BY j.id_usuario
               HAVING COUNT(j.id_usuario) = (
                   SELECT COUNT(j2.id_usuario)
                   FROM juegos j2
                   GROUP BY j2.id_usuario
                   ORDER BY COUNT(j2.id_usuario) DESC
                   LIMIT 1
               )
               ORDER BY u.Apellidos ASC";
$invited_result = $conn->query($sql_invited);
echo "Invita"."<br>";
while ($fila_invita = $invited_result->fetch_assoc()) {
    $nombre_invita = $fila_invita['Nombre'] . " " . $fila_invita['Apellidos'];
    echo "$nombre_invita"."<br>";
}
$sql_invitado = "SELECT u.Nombre, u.Apellidos, COUNT(j.id_invitado) AS total_invitaciones
                 FROM juegos j
                 JOIN usuarios u ON j.id_invitado = u.Usuario
                 GROUP BY j.id_invitado
                 HAVING COUNT(j.id_invitado) = (
                     SELECT COUNT(j2.id_invitado)
                     FROM juegos j2
                     GROUP BY j2.id_invitado
                     ORDER BY COUNT(j2.id_invitado) DESC
                     LIMIT 1
                 )
                 ORDER BY u.Apellidos ASC";

$invited_Result = $conn->query($sql_invitado);

echo "Invitado"."<br>";
while ($fila_invitado = $invited_Result->fetch_assoc()) {
    $nombre_invitado = $fila_invitado['Nombre'] . " " . $fila_invitado['Apellidos'];
    echo "$nombre_invitado"."<br>";
}
$conn->close();