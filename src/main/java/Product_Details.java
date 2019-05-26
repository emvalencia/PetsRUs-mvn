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
        
        String temp = req.getParameter("ID");
        int ID_Num = Integer.parseInt(temp);
        String name = "";
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
        
        
    }
}

  /*
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
        