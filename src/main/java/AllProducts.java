/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emery
 */
public class AllProducts extends HttpServlet {

     @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
      // JDBC driver name and database URL
      final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      final String DB_URL="jdbc:mysql://localhost:3306/petsrus?serverTimezone=UTC";

      //  Database credentials
      final String USER = "root";
      final String PASS = "beer";
      
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      try {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         Statement stmt = conn.createStatement();
         String sql;
         sql = "SELECT * from product";
         ResultSet rs = stmt.executeQuery(sql);
         
        /* start html code output */
        out.println("<!doctype html>");
        out.println("<html lang=\"en\">");
        out.println("<head><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"src/styles.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"src/product-pages/products.css\">");
        out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"assets/favicon.ico\"/>");
        out.println("<script type=\"text/javascript\" src=\"src/product-pages/products.js\"></script>");
        out.println("<title>Home</title></head>");
        
        /* start html body */
        out.println("<body>");
      
        /* nav bar */
        out.println("<div class=\"navbar2\">");
        out.println("<a href=\"/PetsRUs-mvn\">Home</a>");
        out.println("<a href=\"src/about.html\">About</a>");
        out.println("<div class=\"dropdown2\">");
        out.println("<button class=\"dropbtn2\">Products");
        out.println("<i class=\"fa fa-caret-down\"></i>");
        out.println("</button>");
        out.println("<div class=\"dropdown-content2\">");
        out.println("<a href=\"AllProducts\">All</a>");
        out.println("<a href=\"src/product-pages/dog.html\">Dogs</a>");
        out.println("<a href=\"src/product-pages/cat.html\">Cats</a>");
        out.println("<a href=\"src/product-pages/reptile.html\">Reptiles</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        
        /* start container */
        out.println("<div class=\"container-fluid\">");

        /* cover image */
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-lg-12 px-0\">");
        out.println("<div style=\"text-align: center;\">");
        out.println("<img src=\"assets/pets.png\" alt=\"dog-cover-photo\" class=\"cover-img\"/>");
        out.println("<div class=\"transparent-box\">All Pets</div></div></div>");

        /* main row */
        out.println("<div class=\"row pt-2\">");
        out.println("<div class=\"col-2\"></div>");
        out.println("<div class=\"col-8\">");
        out.println("<table class=\"table table-light\">");

        /*table head */
        out.println("<thead class=\"purple-header\">");
        out.println("<tr><th scope=\"col\">Product</th>");
        out.println("<th scope=\"col\">Description</th></tr></thead>");

        /* table body */
        out.println("<tbody>");

        /* extract data from resultset */
        while(rs.next()){

             /* iterate and display all the products */
            int id = rs.getInt("id");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            String type = rs.getString("type");
            String category = rs.getString("category");
            String page_url = rs.getString("page_url");
            String image_url = rs.getString("image_url");
            String summary = rs.getString("summary");
            String description = rs.getString("description");
            String benefits = rs.getString("benefits");
            
            out.println("<tr>");
            out.println("<th scope=\"row\"><img src=\"assets/" + image_url + "\" alt=\"cat-food\" onclick=\"handleClick('" + id + "')\" class=\"product-img\"/></th>");
            out.println("<td class=\"text\">");
            out.println("<div class=\"product-title\">" + name + "</div>");
            out.println("<p>" + summary + "</p>");
            out.println("<div class=\"price\">$" + price + "</div>");
            out.println("<button type=\"button\" class=\"btn btn-secondary btn-md\" onclick=\"handleClick('" + id + "')\">More Info</button>");
            out.println("</td></tr>");

         }
        out.println("</tbody></table></div><div class=\"col-2\"></div></div></body></html>");
        // Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
     } catch(SQLException se) {
        //Handle errors for JDBC
        se.printStackTrace();
     } catch(Exception e) {
        //Handle errors for Class.forName
        e.printStackTrace();
    } //end try
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}