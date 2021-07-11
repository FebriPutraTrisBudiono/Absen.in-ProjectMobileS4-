<?php
require("koneksi.php");

//menangkap post dari android
$nama_mahasiswa = $_POST["nama"];
$kelas = $_POST["kelas"];
$jenis_kelamin = $_POST["jenis_kelamin"];
$no_handphone = $_POST["no_handphone"];

//insert data ke database
$d = array();
$sql = "insert into data_siswa values('','$nama_mahasiswa','$jenis_kelamin','$kelas' ,'$no_handphone')";
if ($koneksi471->query($sql) === TRUE) {
    $d['status'] = "oke";
    echo json_encode($d);
} else {
    $d['status'] = "gagal";
    echo json_encode($d);
}
