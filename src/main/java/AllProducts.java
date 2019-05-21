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
      final String PASS = "root";

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");
      try {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         out.println("Attempting connection...<br/>");
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         out.println("Connection successfully established<br/>");

         // Execute SQL query
         Statement stmt = conn.createStatement();
         String sql;
         sql = "SELECT * from product";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
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
            
            out.println("id: " + id + "<br/>");
            out.println("name: " + name + "<br/>");
            out.println("price: " + price + "<br/>");
            out.println("type: " + type + "<br/>");
            out.println("category: " + category + "<br/>");
            out.println("page_url: " + page_url + "<br/>");
            out.println("image_url: " + image_url + "<br/>");
            out.println("summary: " + summary + "<br/>");
            out.println("description: " + description + "<br/>");
            out.println("benefits: " + benefits + "<br/>");
            out.println("<br/>");
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
         }
         out.println("</body></html>");

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