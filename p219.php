<?php
$host = trim(fgets(STDIN));
$user = trim(fgets(STDIN));
$password = trim(fgets(STDIN));
$data_base = trim(fgets(STDIN));
$conn = new mysqli($host, $user, $password, $data_base);
if ($conn->connect_error) {
    die($conn->connect_error);
}
$sql_llave_primeria = "SELECT COLUMN_NAME as Nombre_Llave, COLUMN_TYPE as Tipo_Dato
                        FROM INFORMATION_SCHEMA.COLUMNS
                        WHERE TABLE_NAME = 'BD_PagoServ_Facturas' AND COLUMN_KEY = 'PRI';";
$resultado_llave_primeria = $conn->query($sql_llave_primeria);
if ($resultado_llave_primeria->num_rows > 0) {
    $row = $resultado_llave_primeria->fetch_assoc();
    echo "Nombre de llave primaria: " . $row["Nombre_Llave"]. " [" . $row["Tipo_Dato"]."]". "<br>";
}
echo "Foraneas:","<br>";
$sql_datos_foraneos= "SELECT
                    kcu.COLUMN_NAME AS 'Columna_Foránea',
                    kcu.REFERENCED_TABLE_NAME AS 'Tabla_Referenciada',
                    kcu.REFERENCED_COLUMN_NAME AS 'Campo_Foraneo',
                    c.COLUMN_TYPE AS 'Tipo_Dato'
                    FROM
                    INFORMATION_SCHEMA.KEY_COLUMN_USAGE kcu
                    INNER JOIN
                    INFORMATION_SCHEMA.COLUMNS c
                    ON
                    kcu.TABLE_NAME = c.TABLE_NAME AND
                    kcu.COLUMN_NAME = c.COLUMN_NAME
                    WHERE
                    kcu.TABLE_NAME = 'BD_PagoServ_Facturas' AND
                    kcu.REFERENCED_TABLE_NAME IS NOT NULL
                    ORDER BY
                    kcu.COLUMN_NAME;";
$resultado_datos_foraneos = $conn->query($sql_datos_foraneos);
if ($resultado_datos_foraneos->num_rows > 0) {
    while($row = $resultado_datos_foraneos->fetch_assoc()) {
        echo "Nombre:".$row["Columna_Foránea"]." <=> "."Tabla Referenciada:".$row["Tabla_Referenciada"]." <=> "."CampoForaneo:".$row["Campo_Foraneo"]." <=> "."[".$row["Tipo_Dato"]."]"."<br>";
    }
}
$conn->close();