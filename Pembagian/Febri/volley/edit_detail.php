<?php

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $name = $_POST['name'];
    $email = $_POST['email'];
    $id = $_POST['id'];

    require_once 'koneksi.php';

    $sql = "UPDATE users_table SET name='$name', email='$email' WHERE id='$id' ";

    if (mysqli_query($koneksi471, $sql)) {

        $result["success"] = "1";
        $result["message"] = "success";

        echo json_encode($result);
        mysqli_close($koneksi471);
    }
} else {

    $result["success"] = "0";
    $result["message"] = "error!";
    echo json_encode($result);

    mysqli_close($koneksi471);
}
