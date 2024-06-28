<?php
$host = trim(fgets(STDIN));
$user = trim(fgets(STDIN));
$password = trim(fgets(STDIN));
$data_base = trim(fgets(STDIN));
$conn = new mysqli($host, $user, $password, $data_base);
if ($conn->connect_error) {
    die($conn->connect_error);
}

// Consulta para obtener el nombre de la tabla de servicios
$consulta_tabla_origen = "SELECT kcu.REFERENCED_TABLE_NAME as Tabla_Origen
    FROM information_schema.key_column_usage kcu
    WHERE kcu.TABLE_NAME = 'facturas' AND kcu.COLUMN_NAME = 'id_Servicio'";
$resultado_tabla_origen = $conn->query($consulta_tabla_origen);

if ($resultado_tabla_origen->num_rows > 0) {
    $fila_tabla_origen = $resultado_tabla_origen->fetch_assoc();
    $tabla_origen = $fila_tabla_origen["Tabla_Origen"];

    // Consulta SQL utilizando el nombre de la tabla obtenido
    $sql = "SELECT s.Nombre AS Nombre_Servicio, COALESCE(p.Cantidad_Pagos, 0) AS Cantidad_Pagos, COALESCE(ROUND(p.Monto_Total, 2), 0) AS Monto_Total
            FROM $tabla_origen s
            LEFT JOIN (
                SELECT id_Servicio, COUNT(*) AS Cantidad_Pagos, SUM(Monto) AS Monto_Total
                FROM facturas
                WHERE (fecha_Pago NOT IN ('0000-00-00', '0000-00-00') OR fecha_Pago IS NULL) AND fecha_Pago <= fecha_Vencimiento
                GROUP BY id_Servicio
            ) p ON s.id = p.id_Servicio
            ORDER BY s.Nombre";

    $resultado = $conn->query($sql);
    if ($resultado->num_rows > 0) {
        while ($fila = $resultado->fetch_assoc()) {
            echo $fila["Nombre_Servicio"] . ":" . $fila["Cantidad_Pagos"] . ":$" . $fila["Monto_Total"] . "<br>";
        }
    } 
} 
$conn->close();