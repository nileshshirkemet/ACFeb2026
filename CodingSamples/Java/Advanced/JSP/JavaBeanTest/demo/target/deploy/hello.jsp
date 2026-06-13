<jsp:useBean id="greeter" class="app.components.GreetingBean" scope="session" />
<jsp:setProperty name="greeter" property="person" param="guest" />
<jsp:setProperty name="greeter" property="period" />
<html>
    <head>
        <title>DemoApp</title>
    </head>
    <body>
        <h1>${greeter.message}</h1>
        <form method="post">
            <p>
                <b>Person: </b>
                <input required name="guest" />
            </p>
            <p>
                <b>Period: </b>
                <select name="period">
                    <option>Night</option>
                    <option>Morning</option>
                    <option>Afternoon</option>
                    <option>Evening</option>
                </select>
            </p>
            <p>
                <input type="submit" value="Greet" />
            </p>
        </form>
        <p>
            <b>Number of Greetings: </b>${greeter.greetCount}
        </p>
    </body>
</html>