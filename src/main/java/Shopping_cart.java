/**
 *
 * @author kflor
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Shopping_cart extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
       
        PrintWriter out = res.getWriter();
        
        
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
