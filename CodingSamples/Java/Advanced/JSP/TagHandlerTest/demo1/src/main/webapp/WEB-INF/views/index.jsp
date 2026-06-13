<html>
    <head>
        <title>DemoApp</title>
    </head>
    <body>
        <h1>Welcome Customer</h1>
        <h2>Please Sign-In</h2>
        <form method="post">
            <p>
                <b>Customer ID</b><br/>
                <input required type="text" name="custId" />
            </p>
            <p>
                <b>Password</b><br/>
                <input required type="password" name="custPwd" />
            </p>
            <p>
                <input type="submit" value="Login" />
            </p>
        </form>
        <i>${requestScope.problem}</i>
    </body>
</html>
