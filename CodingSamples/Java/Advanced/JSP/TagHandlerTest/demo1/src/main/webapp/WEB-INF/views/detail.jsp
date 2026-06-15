<%@ taglib prefix="a" uri="demo.app.tags" %>
<jsp:useBean id="customer" class="app.components.CustomerModelBean" scope="request" />
<html>
    <head>
        <title>DemoApp</title>
    </head>
    <body>
        <h1>Welcome Customer</h1>
        <h2>${customer.id} Orders</h2>
        <table border="1">
            <tr>
                <th>Product No</th>
                <th>Quantity</th>
                <th>Order Date</th>
            </tr>
            <a:fetchOrder orderVar="entry" orderSource="${customer.orders}">
                <tr>
                    <td>${entry.productNo}</td>
                    <td>${entry.quantity}</td>
                    <td>${entry.orderDate}</td>
                </tr>
            </a:fetchOrder>
        </table>
        <p>
            <a href="/">Logout</a>
        </p>
    </body>
</html>
