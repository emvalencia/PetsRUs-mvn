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
public class Shopping_cart extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
       
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession(true);
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL="jdbc:mysql://localhost:3306/petsrus?serverTimezone=UTC";
        String temp = req.getParameter("ID");
        final int ID_Num = Integer.parseInt(temp);
        //  Database credentials
        final String USER = "root";
        final String PASS = "root";
        
        try{
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
            
         }catch(SQLException se) {
        //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
        //Handle errors for Class.forName
            e.printStackTrace();
        } // End catch
        
        
        /*
        HTML FOR CART:
        <!DOCTYPE html>
        <html>
        <head>
        <title>Cart Page</title>
        </head>
        <body>

	<table cellpadding="2" cellspacing="2" border="5">
		<tr>
			<th>Option</th>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
		<set var="total" value="0"></set>
		<forEach var="item" items="${sessionScope.cart }">
			<set var="total" value="${total + item.product.price * item.quantity }"></set>
			<tr>
				<td align="center">
					<a href="LINK TO REMOVE ITEM"
					onclick="return confirm('Are you sure?')">Remove</a>
				</td>
				<td>Product_ID</td>
				<td>Product_Name</td>
				<td>
					<img src="Product pic" width="120">
				</td>
				<td>$_Item_Cost_$</td>
				<td>Item_Qty</td>
				<td>$_SubTotal_$</td>
			</tr>
		</forEach>
		<tr>
			<td colspan="6" align="right">Total</td>
			<td>$_Total_Amount_$</td>
		</tr>
	</table>
	<br>
	<a href="LINK BACK TO PRODUCT PAGES">Continue Shopping</a>

        </body>
        </html>

        */
        
    }
}
