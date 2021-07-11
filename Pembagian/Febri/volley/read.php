<?php
require("koneksi.php");

//read data ke database
$query = mysqli_query($koneksi471, "SELECT * FROM data_siswa");
$data = array();
foreach ($query as $query) :
    $data[] = array(
        'id_mahasiswa' => $query['id_mahasiswa'],
        'nama_mahasiswa' => $query['nama_mahasiswa'],
        'kelas' => $query['kelas'],
        'jenis_kelamin' => $query['jenis_kelamin'],
        'no_handphone' => $query['no_handphone'],
    );
endforeach;
echo json_encode(array(
    'data' => $data
));
