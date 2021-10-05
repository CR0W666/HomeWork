<?php session_start();
if(!isset($_SESSION['UserData']['Username'])){
    header("location:login.php");
    exit;
}

echo $_SESSION['UserData']['Username'];
//echo $_SESSION['UserData']['Logged'];
?>

logged into password protected page. <a href="logout.php">Click here</a> to Logout.


<a href="lorem.php" style="color: white" > hidden lorem lul </a>
