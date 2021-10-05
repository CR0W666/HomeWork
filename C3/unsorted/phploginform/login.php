<?php session_start();
var_dump($_SESSION);
if ($_SESSION['UserData']['Logged'] ?? null) {
    header("location:lorem.php");
}
if (isset($_POST['Submit'])) {
    if(isset($_SESSION['UserName']) && isset($_SESSION['UserName'])) {
            $logins = array( $_SESSION['UserName'] =>  $_SESSION['UserPass']);

            $Username = isset($_POST['Username']) ? $_POST['Username'] : '';
            $Password = isset($_POST['Password']) ? $_POST['Password'] : '';
            $Logged = false;
            if (isset($logins[$Username]) && $logins[$Username] == $Password) {
            $_SESSION['UserData']['Username'] = $logins[$Username];
            $Logged = true;
            $_SESSION['UserData']['Logged'] = $Logged;
            header("location:index.php");
            exit;
        } else {
            $msg = "<span style='color:red'>Invalid Login Details</span>";
        }
    } else {
        $msg = "<span style='color:red'>n-word plz register first</span>";
    }

}
if(isset($_POST['Register'])) {
    header("location:registration.php");
    exit;
}
?>

<form action="" method="post" name="Login_Form">
    <table width="400" border="0" align="center" cellpadding="5" cellspacing="1" class="Table">
        <?php if (isset($msg)) { ?>
            <tr>
                <td colspan="2" align="center" valign="top"><?php echo $msg; ?></td>
            </tr>
        <?php } ?>
        <tr>
            <td colspan="2" align="left" valign="top">
                <h3>Login</h3>
            </td>
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
            <td><input name="Submit" type="submit" value="Login" class="Button3"></td>
        </tr>
    </table>
    <div align="center">
        <input name="Register" type="submit" value="Register" class="Button4" ></td>
        <a href="lorem.php" style="color: white" > hidden lorem lul </a>
    </div>
    
    
</form>