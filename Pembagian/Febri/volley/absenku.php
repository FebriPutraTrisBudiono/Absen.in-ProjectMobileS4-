<?php
require("koneksi.php");

//read data ke database
$query = mysqli_query($koneksi471, "SELECT * FROM absensi");
$data = array();
foreach ($query as $query) :
    $data[] = array(
        'id_absen' => $query['id_absen'],
        'tgl' => $query['tgl'],
        'waktu' => $query['waktu'],
        'keterangan' => $query['keterangan'],
        'id_user' => $query['id_user'],
        'longlat' => $query['longlat'],
    );
endforeach;
echo json_encode(array(
    'data' => $data
));
