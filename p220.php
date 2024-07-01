<?php
$host = trim(fgets(STDIN));
$usuario = trim(fgets(STDIN));
$password = trim(fgets(STDIN));
$base_datos = trim(fgets(STDIN));
$conn = new mysqli($host, $usuario, $password, $base_datos);
if ($conn->connect_error) {
    die($conn->connect_error);
}
$sql_monto_total = "SELECT FORMAT(SUM(ROUND(f.Monto, 2)), 2) AS Adeudo_Total 
                    FROM BD_PagoServ_Facturas f
                    JOIN Usuarios u ON f.id_Cliente = u.Usuario 
                    WHERE f.fecha_Vencimiento <= '2019-01-20' 
                    AND (f.fecha_Pago = '0000-00-00' OR f.fecha_Pago IS NULL)";
$resultado_monto_total = $conn->query($sql_monto_total);
if ($resultado_monto_total->num_rows > 0) {
    $row = $resultado_monto_total->fetch_assoc();
    $adeudo_total = $row["Adeudo_Total"];
    echo "Total de Adeudos: $" . $adeudo_total . "n";
}

$sql_deudas_por_cliente = "SELECT CONCAT(u.Apellidos,' ', u.Nombre) AS nombre, 
                          SUM(ROUND(f.Monto,2)) AS total_adeudo,
                          s.Nombre AS servicio, 
                          ROUND(f.Monto,2) AS total, 
                          f.fecha_Vencimiento AS fecha 
                          FROM BD_PagoServ_Facturas f 
                          JOIN Usuarios u ON f.id_Cliente = u.Usuario 
                          JOIN BD_PagoServ_Servicios s ON f.id_Servicio = s.id 
                          WHERE f.fecha_Vencimiento < '2019-01-20' 
                          AND (f.fecha_Pago = '0000-00-00' OR f.fecha_Pago IS NULL) 
                          GROUP BY u.Usuario, s.Nombre
                          ORDER BY nombre ASC, f.fecha_Vencimiento ASC";
$resultado_deudas_por_cliente = $conn->query($sql_deudas_por_cliente);
$nombre_actual = '';
while ($row = $resultado_deudas_por_cliente->fetch_assoc()) {
    if ($nombre_actual != $row['nombre']) {
        echo "Cliente: " . $row['nombre']." Total de Adeudo: $" . $row['total_adeudo']."n";
        $nombre_actual = $row['nombre'];
    }
    echo "Servicio: " . $row['servicio']." Total: $" . $row['total']." Fecha Venc.: " . $row['fecha'] . "n";
}
$conn->close();
