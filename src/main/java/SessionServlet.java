/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Emery
 */
@WebServlet(urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        
        // if this is a post request, we should add the requested attribute first
        if(request.getMethod().equals("POST")){
            // get input parameters and add an attribute
            session.setAttribute(request.getParameter("attr_name"), request.getParameter("attr_value"));
        }
        
        // get all attributes currently saved on the client's machine
        Enumeration<String> attrNames = session.getAttributeNames();
        
        // iterate on all names
        while(attrNames.hasMoreElements()){
            String attrName = attrNames.nextElement();
            // print <name>: <value>
            out.println(attrName + ": "+ session.getAttribute(attrName));
            out.println("<br>");
        }
        
        // produce the form for adding a new attribute. note that method is post.
        out.println("<form method='post' action='sessions'>");
        out.println("Attribute name: <input name='attr_name' type='text' /> <br>");
        out.println("Attribute value: <input name='attr_value' type='text' /> <br>");
        out.println("<input type='submit' value='Add'/>");
        out.println("</form>");
        
        // tells browser that response is in html format
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
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
