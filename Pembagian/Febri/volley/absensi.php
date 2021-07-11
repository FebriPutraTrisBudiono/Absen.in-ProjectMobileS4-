<?php
require("koneksi.php");

//menangkap post dari android
$tgl = $_POST["tgl"];
$waktu = $_POST["waktu"];
$keterangan = $_POST["keterangan"];
$id_user = $_POST["id_user"];
$longlat = $_POST["longlat"];

//insert data ke database
$d = array();
$sql = "INSERT into absensi values('','$tgl','$waktu','$keterangan' ,'$id_user', '$longlat')";
if ($koneksi471->query($sql) === TRUE) {
    $d['status'] = "oke";
    echo json_encode($d);
} else {
    $d['status'] = "gagal";
    echo json_encode($d);
}
