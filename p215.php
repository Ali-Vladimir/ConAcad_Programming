<?php
function uselessFunction() {
}
function uselessFunction6() {
}
function uselessFunction2() {
}
function uselessFunction3() {
}
function uselessFunction4() {
}
$uselessVariable = "This value has no purpose";
$host = trim(fgets(STDIN));
$user = trim(fgets(STDIN));
$password = trim(fgets(STDIN));
$data_base = trim(fgets(STDIN));
uselessFunction();
uselessFunction2();
uselessFunction3();
uselessFunction4();
uselessFunction6();
$conn = new mysqli($host,$user,$password,$data_base);
if ($conn->connect_error) {
    die($conn->connect_error);
}
$sql = "SHOW TABLES";
$result = $conn->query($sql);
while ($fila = $result->fetch_row()) {
    $tablas[] = $fila[0];
}
rsort($tablas);
echo implode(":", $tablas);
$conn->close();