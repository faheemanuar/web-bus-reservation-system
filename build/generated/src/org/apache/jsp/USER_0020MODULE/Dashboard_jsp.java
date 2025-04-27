package org.apache.jsp.USER_0020MODULE;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import java.util.HashSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.*;

public final class Dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\"\n");
      out.write("              href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"index.css\" rel=\"stylesheet\">\n");
      out.write("        <title>Dashboard</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");


            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/bus_route";
            Connection myconnection1 = DriverManager.getConnection(url, "root", "admin");
            Connection myconnection2 = DriverManager.getConnection(url, "root", "admin");

            Statement myStatement1 = myconnection1.createStatement();

            String sql = "SELECT DISTINCT origin FROM route";
            ResultSet myRs1 = myStatement1.executeQuery(sql);

            Set<String> originSet = new HashSet<>();
            while (myRs1.next()) {
                originSet.add(myRs1.getString("origin"));
            }

            sql = "SELECT DISTINCT destination FROM route";
            ResultSet myRs2 = myStatement1.executeQuery(sql);

            Set<String> destinationSet = new HashSet<>();
            while (myRs2.next()) {
                destinationSet.add(myRs2.getString("destination"));
            }

            int userId = (int) session.getAttribute("user_id");
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <header>\n");
      out.write("            <div class=\"bottom-bar\">\n");
      out.write("                <div class=\"bottom-bar__content\">\n");
      out.write("                    <a href=\"Dashboard.html\" class=\"logo\">\n");
      out.write("                        <img class=\"logo__img\" src=\"logo.png\" alt=\"logo\">\n");
      out.write("                        <span class=\"logo__text\">Bus Ticket Reservation</span>\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("                    <nav class=\"nav\">\n");
      out.write("                        <ul class=\"nav__list\">\n");
      out.write("                            <li class=\"nav__item\">\n");
      out.write("                                <a class=\"btn\" href=\"Dashboard.jsp\">Dashboard</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav__item\">\n");
      out.write("                                <a class=\"nav__link\" href=\"booking.jsp\">Booking</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav__item\">\n");
      out.write("                                <a class=\"nav__link\" href=\"viewProfile.jsp\">Profile</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav__item\">\n");
      out.write("                                <a class=\"nav__link\" href=\"feedback.jsp\">Feedback</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("\n");
      out.write("                    <div class=\"hamburger\">\n");
      out.write("                        <div class=\"bar\"></div>\n");
      out.write("                        <div class=\"bar\"></div>\n");
      out.write("                        <div class=\"bar\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <main style=\"height:600px;\">\n");
      out.write("            <div class=\"container\" style=\"padding: 50px;\">\n");
      out.write("\n");
      out.write("                <div class=\"form\">\n");
      out.write("                    <h3>Book Your Ticket</h3>\n");
      out.write("                    <form action=\"showBus.jsp\" method=\"POST\">\n");
      out.write("                        <p>\n");
      out.write("                            <label for=\"origin\">Origin</label>\n");
      out.write("                            <select name=\"origin\" id=\"origin\" >\n");
      out.write("                                <option value=\"\" disabled selected hidden>Origin</option>\n");
      out.write("                                ");
 for (String origin : originSet) {
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( origin);
      out.write('"');
      out.write('>');
      out.print( origin);
      out.write("</option>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <label for=\"destination\">Destination</label>\n");
      out.write("                            <select name=\"destination\" id=\"destination\">\n");
      out.write("                                <option value=\"\" disabled selected hidden>Destination</option>\n");
      out.write("                                <option value=\"\" disabled selected hidden>Destination</option>\n");
      out.write("                                ");
 for (String destination : destinationSet) {
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( destination);
      out.write('"');
      out.write('>');
      out.print( destination);
      out.write("</option>\n");
      out.write("                                ");
 } 
      out.write("                            </select>\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <label for=\"\">Date</label>\n");
      out.write("                            <input type=\"date\" name=\"date\" id=\"date\">\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <label for=\"\">Pax</label>\n");
      out.write("                            <input type=\"number\" id=\"quantity\" name=\"quantity\" min=\"1\">\n");
      out.write("                        </p>\n");
      out.write("\n");
      out.write("                        <p class=\"full-width\">\n");
      out.write("                            <button type=\"submit\" formaction=\"showBus.jsp\">Search Bus</button>\n");
      out.write("                        </p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("\n");
      out.write("        <footer class=\"footer-distributed\">\n");
      out.write("    <div class=\"footer-left\">\n");
      out.write("        <img class=\"logofooter\" src=\"logo.png\" alt=\"logo\">\n");
      out.write("\n");
      out.write("        <p class=\"footer-links\">\n");
      out.write("            <a href=\"Dasboard.jsp\" class=\"link-1\">Dashboard</a>\n");
      out.write("            <a href=\"Booking.jsp\">Booking</a>\n");
      out.write("            <a href=\"viewProfile.jsp\">Profile</a>\n");
      out.write("            <a href=\"feedback.jsp\">Feedback</a>\n");
      out.write("        </p>\n");
      out.write("        <p class=\"footer-company-name\">Tiny Travel Co. © 2024</p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"footer-center\">\n");
      out.write("        <div>\n");
      out.write("            <i class=\"fa fa-map-marker\"></i>\n");
      out.write("            <p><span>Kuala Nerus</span> Terengganu, Malaysia</p>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <i class=\"fa fa-phone\"></i>\n");
      out.write("            <p>+60 123456789</p>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <i class=\"fa fa-envelope\"></i>\n");
      out.write("            <p><a href=\"mailto:tinytravel@company.com\">tinytravel@company.com</a></p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"footer-right\">\n");
      out.write("        <p class=\"footer-company-about\">\n");
      out.write("            <span>About the company</span>\n");
      out.write("            Your go-to solution for easy bus ticket booking! Whether you're commuting, planning a weekend trip, or a long journey, our platform ensures a seamless and convenient booking experience. Travel effortlessly with Tiny Travel Company!\n");
      out.write("        </p>\n");
      out.write("        <div class=\"footer-icons\">\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-github\"></i></a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("               \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            // Get the message from the query parameter\n");
      out.write("            var urlParams = new URLSearchParams(window.location.search);\n");
      out.write("            var message = urlParams.get(\"message\");\n");
      out.write("\n");
      out.write("            // Display the alert message\n");
      out.write("            if (message === \"ok\") {\n");
      out.write("                alert(\"Payment accepted!\");\n");
      out.write("            }\n");
      out.write("            const navEl = document.querySelector('.nav');\n");
      out.write("            const hamburgerEl = document.querySelector('.hamburger');\n");
      out.write("            const navItemEls = document.querySelectorAll('.nav__item');\n");
      out.write("\n");
      out.write("            hamburgerEl.addEventListener('click', () => {\n");
      out.write("                navEl.classList.toggle('nav--open');\n");
      out.write("                hamburgerEl.classList.toggle('hamburger--open');\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            navItemEls.forEach(navItemEl => {\n");
      out.write("                navItemEl.addEventListener('click', () => {\n");
      out.write("                    navEl.classList.remove('nav--open');\n");
      out.write("                    hamburgerEl.classList.remove('hamburger--open');\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        ");
 myconnection1.close();
      out.write("\n");
      out.write("        ");
 myconnection2.close();
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
