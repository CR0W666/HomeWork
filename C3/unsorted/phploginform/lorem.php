<?php session_start();
    if( isset($_SESSION["UserName"]) && isset($_SESSION["UserPass"])) { 
        $name = $_SESSION["UserName"];
        $pass = $_SESSION["UserPass"];
        $wtf = "lorem";
        $bttn = "Logout";

    } else {
        $name = "not registered";
        $pass = "not registered";
        $wtf = "how did u do this";
        $bttn = "Login";

    }
    if(isset($_POST['Logout'])) {
        header("location:logout.php");
        exit;
    }
    if(isset($_POST['Login'])) {
        header("location:login.php");
        exit;
    }
?>

<header><p>Username:</p><?php echo $name; ?><br><p>Password:</p><?php echo $pass;?></header>

<p><br><?php echo $wtf;?></p>
<form action="lorem.php" method="post">
    <input name=<?php echo $bttn; ?> type="submit" value=<?php echo $bttn; ?> class="Button4" ></td>
</form>

