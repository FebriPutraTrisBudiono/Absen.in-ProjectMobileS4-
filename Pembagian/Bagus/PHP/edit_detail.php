<?php

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $name = $_POST['name'];
    $email = $_POST['email'];
    $nomer = $_POST['nomer'];
    $alamat = $_POST['alamat'];
    $password = $_POST['password'];
    $password = password_hash($password, PASSWORD_DEFAULT);
    $id = $_POST['id'];

    require_once 'connect.php';

    $sql = "UPDATE users_table SET name='$name', email='$email', nomer='$nomer', alamat='$alamat', password='$password' WHERE id='$id' ";

    if(mysqli_query($conn, $sql)) {

          $result["success"] = "1";
          $result["message"] = "success";

          echo json_encode($result);
          mysqli_close($conn);
      }
  }

else{

   $result["success"] = "0";
   $result["message"] = "error!";
   echo json_encode($result);

   mysqli_close($conn);
}

?>


