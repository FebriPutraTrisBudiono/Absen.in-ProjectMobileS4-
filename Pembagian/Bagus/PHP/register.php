<?php

if ($_SERVER ['REQUEST_METHOD'] =='POST'){

  $name = $_POST['name'];
  $email = $_POST['email'];
  $password = $_POST['password'];

  $password = password_hash($password, PASSWORD_DEFAULT);

  require_once 'connect.php';

  $sql = "INSERT INTO users_table(name, email, password) VALUES ('$name', '$email', '$password')";
  

  if($res=mysqli_query($conn, $sql)){
    $result["succes"] = "1";
    $result["message"] = "succes";

  }else{

    $result["succes"] = "0";
    $result["message"] = "error";

    
    
  }
  echo json_encode($result);
  mysqli_close($conn);
}

?>