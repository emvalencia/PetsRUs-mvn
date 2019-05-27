/**
 *
 * @author kflor
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Product_Details extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
      
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession(true);
        
         // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL="jdbc:mysql://localhost:3306/petsrus?serverTimezone=UTC";
        String temp = req.getParameter("ID");
        final int ID_Num = Integer.parseInt(temp);
        //  Database credentials
        final String USER = "root";
        final String PASS = "root";
        
        try{
            if(ID_Num < 1000000001 || ID_Num > 1000000010)
                throw new Exception("ID Number does not exist in DB");
            
            // Register JDBC driver
             Class.forName("com.mysql.jdbc.Driver");

             // Open a connection
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

             // Execute SQL query
             Statement stmt = conn.createStatement();
             String sql;
             sql = "SELECT select * from product where id =" + ID_Num + "";
             ResultSet rs = stmt.executeQuery(sql);
             
              /* Get all info for requested page from DB */
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
            
            // < Meta tags
            out.println("!-- Required meta tags -->");
            out.println("<!doctype html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<!-- Required meta tags -->");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"../products.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"../../styles.css\">");
            out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"../../../assets/favicon.ico\" />");
            out.println("<script src=\"../products.js\"></script>");
            out.println("<title>Dog Food</title>");
            out.println("</head>");
            out.println("<body>");

            // Nav bar 
            out.println("<!-- nav bar -->");
            out.println("<div class=\"navbar2\">");
            out.println("<a href=\"/PetsRUs-mvn\">Home</a>");
            out.println(" <a href=\"../../about.html\">About</a>");
            out.println("<div class=\"dropdown2\">");
            out.println("<button class=\"dropbtn2\">Products");
            out.println("<i class=\"fa fa-caret-down\"></i>");
            out.println("</button>");
            out.println("<div class=\"dropdown-content2\">");
            out.println("<a href=\"../../../AllProducts\">All</a>");
            out.println("<a href=\"../dog.html\">Dogs</a>");
            out.println("<a href=\"../cat.html\">Cats</a>");
            out.println("<a href=\"../reptile.html\">Reptiles</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"container-fluid\">");

            // row #1
            out.println("<!-- row #1 -->");
            out.println("<div class=\"row pt-2\">");
            out.println("<div class=\"col-2\"></div>");
            out.println("<div class=\"col-8 purple-header\">");
            out.println("<h3 id=\"product-name\">"+ name +"</h3>");                             /// Specific to page ******************
            out.println("</div>");
            out.println("<div class=\"col-2\"></div>");
            out.println("</div>");

            // row #2
            out.println("<!-- row #2 -->");
            out.println("<div class=\"row pt-2\">");
            out.println("<div class=\"col-2\"></div>");
            out.println("<div class=\"col-sm\">");
            out.println("<img src=\"../../../assets/"+ image_url +"/>");                                          /// Specific to page ****************** 
            out.println("</div>");
            out.println("<div class=\"col-sm\">");
            out.println("<h3 id=\"product-description\">"+ name +"</h3>");                      /// Specific to page ******************
            out.println("<h3 id=\"product-price\">$"+ price +"</h3>");                          /// Specific to page ******************
            out.println("<!-- <button type=\"button\" class=\"btn btn-success btn-md\" onclick=\"handleClick('buy')\">Buy</button> -->");
            out.println("</div>");
            out.println("<div class=\"col-2\"></div>");
            out.println("</div>");
            
            // row #3
            out.println("<!-- row #3 -->");
            out.println("<div class=\"row pt-2\">");
            out.println("<div class=\"col-2\"></div>");
            out.println("<div class=\"col-8\">");
            out.println("<p>");
            out.println("<strong>Description</strong>");
                                                                                                /// Specific to page START
            out.println(description);
                                                                                                /// Specific to page END
            out.println("</p>");
            out.println("<p>");
            out.println("<strong>Key Benefits</strong>");
                                                                                                /// Specific to page START
            out.println(benefits);
                                                                                                /// Specific to page END
            out.println("</p>");
            out.println("</div>");
            out.println("<div class=\"col-2\"></div>");
            out.println("</div>");
            
            // row #1
            out.println("<!-- row #1 -->");
            out.println("<div class=\"row pt-2\">");
            out.println("<div class=\"col-2\"></div>");
            out.println("<div class=\"col-8 purple-header\">");
            out.println("<h3>Purchase Item</h3>");
            out.println("</div>");
            out.println("<div class=\"col-2\"></div>");
            out.println("</div>");
            out.println("</div>");

            out.println("<!-- Optional JavaScript -->");
            out.println("<!-- jQuery first, then Popper.js, then Bootstrap JS -->");
            out.println("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>");
            out.println("</body>");
            out.println("<div class=\"footer\">");
            out.println("<div>Designed and created by Kevin Florio, Emery Valencia, and Jose Vargas.</div>");
            out.println("<div>Copyright © 2019 PetsRUs, Inc. All Rights Reserved.</div>");
            out.println("</div>");
            out.println("</html>");
            out.println("");
            out.println("");
        
        }catch(SQLException se) {
        //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
        //Handle errors for Class.forName
            e.printStackTrace();
        } // End catch
        
    } // end doGet()
    
    
} // end class

  /*
        switch(ID_Num){
                case 1000000004:
                    out.println("src/product-pages/dog-pages/dog-food.html");
                    session.setAttribute(temp, "dog-food");
                    break;
                case 1000000006:
                    out.println("src/product-pages/dog-pages/dog-toy.html");
                    session.setAttribute(temp, "dog-toy");
                    break;
                case 1000000005:
                    out.println("src/product-pages/dog-pages/dog-harness.html");
                    session.setAttribute(temp, "dog-harness");
                    break;
                case 1000000007:
                    out.println("src/product-pages/dog-pages/dog-treat.html");
                    session.setAttribute(temp, "dog-treat");
                    break;
                case 1000000002:
                    out.println("src/product-pages/cat-pages/cat-food.html");
                    session.setAttribute(temp, "cat-food");
                    break;
                case 1000000003:
                    out.println("src/product-pages/cat-pages/cat-playground.html");
                    session.setAttribute(temp, "cat-playground");
                    break;
                case 1000000001:
                    out.println("src/product-pages/cat-pages/cat-carrier.html");
                    session.setAttribute(temp, "cat-carrier");
                    break;
                case 1000000008:
                    out.println("src/product-pages/reptile-pages/reptile-food.html");
                    session.setAttribute(temp, "reptile-food");
                    break;
                case 1000000009:
                    out.println("src/product-pages/reptile-pages/reptile-habitat.html");
                    session.setAttribute(temp, "reptile-habitat");
                    break;
                case 1000000010:
                    out.println("src/product-pages/reptile-pages/reptile-meds.html");
                    session.setAttribute(temp, "reptile-meds");
                    break;
                default:
                    out.println("Error Page....");
            }
        
                    ************ Example ****************
        String s, products[] = {"Fifa 15", "Battlefield 5", "GTA 6"};
        double price []={10,20,30};
        double cost;
        
        if ( session == null ) return;
        for (int i = 0; i < products.length; i++)
        if ( session.getAttribute(products[i]) == null )
            session.setAttribute(products[i], new Integer(0));

        if ((s = req.getParameter("buy")) != null ) {
            int n = ((Integer)session.getAttribute(s)).intValue();
            session.setAttribute(s, new Integer(n + 1));
        }
        out.println("<html><body><h2>Shopping Cart</h2><ul>");
        for (int i = 0; i < products.length; i++) {
            int n = ((Integer)session.getAttribute(products[i])).intValue();
            if ( n > 0 ){
                out.println("<li><b>" + products[i] + "</b> : " + n +":"+ price[i] +"</li>");
                cost=n*price[i];
                out.println(cost);}
            }
        out.println("</ul></body></html>");


        1000000004 = window.location.href = "src/product-pages/dog-pages/dog-food.html";
        1000000006 = window.location.href = "src/product-pages/dog-pages/dog-toy.html";
        1000000005 = window.location.href = "src/product-pages/dog-pages/dog-harness.html";
        1000000007 = window.location.href = "src/product-pages/dog-pages/dog-treat.html";
        1000000002 = window.location.href = "src/product-pages/cat-pages/cat-food.html";
        1000000003 = window.location.href = "src/product-pages/cat-pages/cat-playground.html";
        1000000001 = window.location.href = "src/product-pages/cat-pages/cat-carrier.html";
        1000000008 = window.location.href = "src/product-pages/reptile-pages/reptile-food.html";
        1000000009 = window.location.href = "src/product-pages/reptile-pages/reptile-habitat.html";
        1000000010 = window.location.href = "src/product-pages/reptile-pages/reptile-meds.html";
        */
        