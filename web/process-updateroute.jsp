<%-- 
    Document   : process-updateroute
    Created on : 28 May 2024, 6:16:09 pm
    Author     : irfan yahya
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Route</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }

        header, footer {
            background-color: maroon;
            color: white;
            text-align: center;
            padding: 15px 0;
        }
        
        header nav {
            position: absolute;
            top: 30px;
            right: 20px;
            
        }

        nav input[type="button"] {
            background-color: white;
            color: maroon;
            border: 1px solid maroon;
            padding: 10px 20px;
            margin-left: 10px;
            border-radius: 4px;
            cursor: pointer;
            font-family: Arial, sans-serif;
        }

        nav input[type="button"]:hover {
            background-color: grey;
            color: white;
        }

        main {
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: calc(100vh - 120px); 
        }

        .form-container {
            background-color: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            width: 100%;
            max-width: 600px;
            box-sizing: border-box;
        }

        h2 {
            text-align: center;
        }

        form table {
            width: 100%;
            margin: 20px 0;
        }

        form table td {
            padding: 10px;
        }

        form input[type="text"], form input[type="number"], form input[type="time"] {
            width: calc(100% - 20px);
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form input[type="submit"], form input[type="button"] {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }

        form input[type="submit"] {
            background-color: maroon;
            color: white;
        }

        form input[type="button"] {
            background-color: gray;
            color: white;
        }

        form input[type="submit"]:hover, form input[type="button"]:hover {
            opacity: 0.9;
        }

        footer {
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>Bus Booking System</h1>
        
        <nav>
            <input type="button" value="Manage Bus"
                   onclick="window.location.href='process-viewbus.jsp'; return false;"/>
            <input type="button" value="Manage Route"
                   onclick="window.location.href='process-viewroute.jsp'; return false;"/>
            
        </nav>
    </header>
    
    <main>
        <div class="form-container">
            <%
                String routeid1 = request.getParameter("routeid");
                String myplatno="" ,myorigin = "", mydestination = "", mydeparture = "", myarrival = "", myprice = "";

                Class.forName("com.mysql.jdbc.Driver");

                String myUrl = "jdbc:mysql://localhost:3306/bus_route";
                Connection myconnection = DriverManager.getConnection(myUrl, "root", "admin");

                Statement myStatement = myconnection.createStatement();

               String myQuery = "select * from route where routeid= '" + routeid1 + "'";
                ResultSet myRs = myStatement.executeQuery(myQuery);

                while (myRs.next()) {
                    myplatno = myRs.getString(2);
                    myorigin = myRs.getString(3);
                    mydestination = myRs.getString(4);
                    mydeparture = myRs.getString(5);
                    myarrival = myRs.getString(6);
                    myprice = myRs.getString(7);
                }
                myconnection.close();
            %>
            <h2>Update Route</h2>
            <form action="process-updateroute2.jsp" method="POST"> 
                <input type="hidden" name="hidid" value="<%=routeid1%>"/> 
                <table>
                    <tr>
                                <td><label for="bus">Bus : </label></td>
                                <td><select name="platno" id="platno" >

                                        <% while (myRs.next()) {%>
                                        <option  value="<%= myRs.getString("platno")%>"><%= myRs.getString("platno")%></option>


                                        <% }%>
                                    </select></td>
                            </tr>
                    <tr>
                        <td><label>Origin: </label></td>
                        <td><input type="text" name="origin" value="<%=myorigin%>" required /></td>
                    </tr>
                    <tr>
                        <td><label>Destination: </label></td>
                        <td><input type="text" name="destination" value="<%=mydestination%>" required/></td>
                    </tr>
                    <tr>
                        <td><label>Departure Time: </label></td>
                        <td><input type="time" name="departuretime" value="<%=mydeparture%>" required/></td>
                    </tr>
                    <tr>
                        <td><label>Arrival Time: </label></td>
                        <td><input type="time" name="arrivaltime" value="<%=myarrival%>" required/></td>
                    </tr>
                    <tr>
                        <td><label>Price: </label></td>
                        <td><input type="number" name="price" value="<%=myprice%>" required/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Update"/> 
                            <input type="button" value="Cancel" 
                                   onclick="window.location.href='process-viewroute.jsp'; return false;"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </main>
    
    <footer>
        <p>&copy; 2024 Bus Booking System. All rights reserved.</p>
    </footer>
</body>
</html>