<%-- 
    Document   : process-updatebus
    Created on : 28 May 2024, 1:47:34 pm
    Author     : irfan yahya
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Bus</title>
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

        h1, h2 {
            text-align: center;
        }

        fieldset {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 8px;
        }

        legend {
            font-size: 1.2em;
            font-weight: bold;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table td {
            padding: 10px;
        }

        input[type="text"], input[type="number"] {
            width: calc(100% - 20px);
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"], input[type="button"] {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }

        input[type="submit"] {
            background-color: maroon;
            color: white;
        }

        input[type="button"] {
            background-color: gray;
            color: white;
        }

        input[type="submit"]:hover, input[type="button"]:hover {
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
        <h1>Bus Management System</h1>
        
        <nav>
            <input type="button" value="Manage Bus"
                   onclick="window.location.href='process-viewbus.jsp'; return false;"/>
            <input type="button" value="Manage Route"
                   onclick="window.location.href='process-viewroute.jsp'; return false;"/>
            
        </nav>
    </header>
    
    <main>
        <div class="form-container">
            <h2>Update Bus</h2>
            <%
                int busid = Integer.parseInt(request.getParameter("id"));
                String myplatno = "", mytype = "", mycapacity = "", mystatus="";

                Class.forName("com.mysql.jdbc.Driver");

                String myUrl = "jdbc:mysql://localhost:3306/bus_route";
                Connection myconnection = DriverManager.getConnection(myUrl, "root", "admin");

                Statement myStatement = myconnection.createStatement();

                String myQuery = "select * from bus where id=" + busid;

                ResultSet myRs = myStatement.executeQuery(myQuery);

                while (myRs.next()) {
                    myplatno = myRs.getString(2);
                    mytype = myRs.getString(3);
                    mycapacity = myRs.getString(4);
                    mystatus = myRs.getString(5);
                }  
                myconnection.close();
            %>
            <fieldset>
                <legend>Update Bus</legend>
                <form action="process-updatebus2.jsp" method="POST">
                    <input type="hidden" name="hidid" value="<%=busid%>"/>
                    <table>
                        <tbody>
                            <tr>
                                <td><label>Plat Number:</label></td>
                                <td><input type="text" name="platno" value="<%=myplatno%>" required/></td>
                            </tr>
                            <tr>
                                <td><label>Type Of Bus:</label></td>
                                <td><input type="text" name="type" value="<%=mytype%>" required/></td>
                            </tr>
                            <tr>
                                <td><label>Capacity:</label></td>
                                <td><input type="number" name="capacity" value="<%=mycapacity%>" required/></td>
                            </tr>
                            <tr>
                                <td><label>Status Of Bus:</label></td>
                                <td><input type="text" name="status" value="<%=mystatus%>" required/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input type="submit" value="Update"/> 
                                    <input type="button" value="Cancel" 
                                           onclick="window.location.href='process-viewbus.jsp'; return false;"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </fieldset>
        </div>
    </main>
    
    <footer>
        <p>&copy; 2024 Bus Management System. All rights reserved.</p>
    </footer>
</body>
</html>