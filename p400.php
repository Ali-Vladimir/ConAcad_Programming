<?php
$entrada = explode(' ', trim(fgets(STDIN)));
$nombre_tabla = $entrada[0];
$num_registros = (int)$entrada[1];
$num_campos = (int)$entrada[2];
$campos = [];
for ($i = 0; $i < $num_campos; $i++) {
    $campo = explode(' ', trim(fgets(STDIN)));
    $nombre_campo = $campo[0];
    $tipo_dato = $campo[1];
    $datos_extra = count($campo) > 2 ? implode(' ', array_slice($campo, 2)) : '';

    $campos[] = ['nombre' => $nombre_campo, 'tipo' => $tipo_dato, 'extra' => $datos_extra];
}
$sql_script = "DROP TABLE IF EXISTS `$nombre_tabla`;\n";
$sql_script .= "CREATE TABLE `$nombre_tabla` (\n";
$sql_script .= "`id` int AUTO_INCREMENT,\n";
foreach ($campos as $campo) {
    $nombre_campo = $campo['nombre'];
    $tipo_dato = $campo['tipo'];
    $datos_extra = $campo['extra'];
    $sql_script .= "`$nombre_campo` $tipo_dato";
    if ($tipo_dato === 'char') {
        $sql_script .= "(255)";
    }
    if ($datos_extra === '') {
        $sql_script .= " DEFAULT NULL";
    } else {
        $sql_script .= " NOT NULL";
    }
    $sql_script .= ",\n";
}
$sql_script .= "PRIMARY KEY (`id`)\n";
$sql_script .= ") AUTO_INCREMENT = 1;\n";
$sql_script .= "INSERT INTO `$nombre_tabla` (";
$nombres_campos_aleatorios = array_map(function($campo) {
    return $campo['nombre'];
}, array_filter($campos, function($campo) {
    return $campo['extra'] !== '';
}));
$sql_script .= "`" . implode("`,`", $nombres_campos_aleatorios) . "`";
$sql_script .= ")\nVALUES\n";
for ($i = 0; $i < $num_registros; $i++) {
    $valores = [];
    foreach ($campos as $campo) {
        $tipo_dato = $campo['tipo'];
        $datos_extra = $campo['extra'];
        if ($datos_extra === '') {
            continue;
        }
        if ($tipo_dato === 'int') {
            $rango = explode(' ', $datos_extra);
            $valores[] = rand($rango[0], $rango[1]);
        } elseif ($tipo_dato === 'date') {
            $rango_fechas = explode(' ', $datos_extra);
            $fecha_inicio = strtotime($rango_fechas[0]);
            $fecha_fin = strtotime($rango_fechas[1]);
            $fecha_aleatoria = rand($fecha_inicio, $fecha_fin);
            $valores[] = "'" . date('Y-m-d', $fecha_aleatoria) . "'";
        } elseif ($tipo_dato === 'char') {
            if ($datos_extra === 'nombre') {
                $nombres = ['Juan', 'Ana', 'Maria', 'Luisa', 'Luis', 'Pedro', 'Angel', 'Carla', 'Alicia', 'Josefina', 'Fernando'];
                $valores[] = "'" . $nombres[array_rand($nombres)] . "'";
            } elseif ($datos_extra === 'apellido') {
                $apellidos = ['Lopez', 'Perez', 'Martinez', 'Jimenez', 'Gutierrez', 'Vera', 'Ortega', 'Castillo', 'Mireles', 'Frias', 'Morales', 'Mejia', 'Garcia'];
                $valores[] = "'" . $apellidos[array_rand($apellidos)] . "'";
            } elseif (strpos($datos_extra, 'telefono') === 0) {
                $lada = explode(' ', $datos_extra)[1];
                $telefono = implode(' ', [rand(100, 999), rand(10, 99), rand(10, 99)]);
                $valores[] = "'" . $lada . ' ' . $telefono . "'";
            }
        }
    }
    $sql_script .= "(" . implode(",", $valores) . ")";
    if ($i < $num_registros - 1) {
        $sql_script .= ",\n";
    }
}
$sql_script .= ";\n";
echo $sql_script;