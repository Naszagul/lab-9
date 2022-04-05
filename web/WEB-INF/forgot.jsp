<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab 9</title>
    </head>
    <body>
        <h1>Lab 9</h1>
        <h2>Forgot Password</h2>
        <p>Please enter your email address to retrieve your password.</p>
        <form action="ForgotPasswordServlet" method="post">
            email: <input type="text" name="email"><br>
            <input type="submit" value="Sign in">
        </form>
    </body>
</html>
