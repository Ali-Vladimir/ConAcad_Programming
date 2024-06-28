<?php
$host = trim(fgets(STDIN));
$user = trim(fgets(STDIN));
$password = trim(fgets(STDIN));
$data_base = trim(fgets(STDIN));
$conn = new mysqli($host, $user, $password, $data_base);
if ($conn->connect_error) {
    die($conn->connect_error);
}
class Experiments{
    public $a_string;
    public $a_array;
    public $a_seen;
    function __construct($string){
        $this->a_string = $string;
        $this->a_array = explode(" ", $string);
        $this->a_seen = array();
    }
    function m_checkRepeat(){
        $v_flag = false;
        $this->a_seen[0] = $this->a_array[0];
        $v_lastBox = 1;
        $v_iterator = 1;
        while($v_iterator < count($this->a_array)){
            $v_iterator2 = 0;
            while($v_iterator2 < $v_lastBox){
                if($this->a_array[$v_iterator] == $this->a_seen[$v_iterator2]){
                    $v_flag = true;
                }
                $v_iterator2++;
            }
            $this->a_seen[$v_lastBox++] = $this->a_array[$v_iterator];
            $v_iterator++;
        }
        return $v_flag;
    }

    function m_checkDirection(){
        $v_flag = false;
        $v_iterator = 2;
        $v_cache = $this->a_string[$v_iterator];
        while($v_iterator < strlen($this->a_string)-1){
            $v_iterator += 2;
            if($v_cache != $this->a_string[$v_iterator]){
                $v_flag = true;
            }
            $v_iterator += 2;
            $v_cache = $this->a_string[$v_iterator];
        }
        return $v_flag;
    }
}
$sql = "SELECT j.id, u1.Nombre AS nombre_usuario, u1.Apellidos AS apellidos_usuario, u2.Nombre AS nombre_invitado, u2.Apellidos AS apellidos_invitado, j.secuencia, j.id_estatus 
        FROM Juegos j
        INNER JOIN usuarios u1 ON j.id_usuario = u1.Usuario
        INNER JOIN usuarios u2 ON j.id_invitado = u2.Usuario";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while ($fila = $result->fetch_assoc()) {
        $id_game = $fila['id'];
        $user_name = $fila['nombre_usuario'] . ' ' . $fila['apellidos_usuario'];
        $invited_user = $fila['nombre_invitado'] . ' ' . $fila['apellidos_invitado'];
        $sequence = $fila['secuencia'];
        $id_status = $fila['id_estatus'];
        if ($id_status != 2) {
            $experiment = new Experiments($sequence);
            $repetitions = $experiment->m_checkRepeat();
            $direction = $experiment->m_checkDirection();
            if ($repetitions && $direction) {
                echo "$id_game:$user_name:$invited_user:Ficha Duplicada"."<br>";
            } else if ($repetitions) {
                echo "$id_game:$user_name:$invited_user:Ficha Duplicada"."<br>";
            } else if ($direction) {
                echo "$id_game:$user_name:$invited_user:Secuencia Mal"."<br>";
            }
        }
    }
}
$conn->close();