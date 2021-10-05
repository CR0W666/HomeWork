<?php session_start();
    if(isset($_POST['Submit'])){
        if($_POST['Username'] != "" && $_POST['Password'] != "") {
            $_SESSION['UserName'] = $_POST['Username'];
            $_SESSION['UserPass'] = $_POST['Password'];
            header("location:login.php");
            exit;
        } else {
            $msg = "<span style='color:red'>Please enter sumn n-word</span>";
        }



    }

?>

<form action="" method="post" name="Login_Form">
    <table width="400" border="0" align="center" cellpadding="5" cellspacing="1" class="Table">
        <?php if(isset($msg)){?>
            <tr>
                <td colspan="2" align="center" valign="top"><?php echo $msg;?></td>
            </tr>
        <?php } ?>
        <tr>
            <td colspan="2" align="left" valign="top"><h3>Register</h3></td>
        </tr>
        <tr>
            <td align="right" valign="top">Username</td>
            <td><input name="Username" type="text" class="Input"></td>
        </tr>
        <tr>
            <td align="right">Password</td>
            <td><input name="Password" type="password" class="Input"></td>
        </tr>
        <tr>
            <td> </td>
            <td><input name="Submit" type="submit" value="Register" class="Button3"></td>
        </tr>
    </table>
</form>
