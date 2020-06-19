package customerApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOClass implements ProductDAO { 
	
	List<Product> productList;

	   public ProductDAOClass(){
		   productList = new ArrayList<Product>(); 
		}
	
	   @Override
	     public List <Product> getAllProducts() {
			   Connection con = ConnectionFact.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
			        List<Product> productList = new ArrayList<Product>();

			        while(rs.next())
			        {
			        	Product p = new Product();
		                p.setProductCode(rs.getInt("ProductCode")); 
		                p.setProductName(rs.getString("ProductName") );
		                p.setPrice(rs.getDouble("Price") ); 
		                p.setQuantity(rs.getInt("Quantity") ); 
		                productList.add(p);
			        }
			        return productList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
			}
	   

	   @Override
	   public Product getProduct(int id) {
		    Connection con = ConnectionFact.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM Product WHERE ProductCode=" + id);
		            if(rs.next())
		            {
		            	Product p = new Product();
		            	p.setProductCode(rs.getInt("ProductCode")); 
		                p.setProductName(rs.getString("ProductName") );
		                p.setPrice(rs.getDouble("Price") ); 
		                p.setQuantity(rs.getInt("Quantity") );
		            return p;
		            }
		        } catch (SQLException ex) {
	            ex.printStackTrace();
		        }
		    return null;
		} 
	   
	   @Override
	     public List <Product> getProductCusto() {
			   Connection con = ConnectionFact.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery("Select * from Product, Orders where Product.ProductCode = Orders.ProductCode;");
			        List<Product> productList = new ArrayList<Product>();

			        while(rs.next())
			        {
			        	Product p = new Product();
		                p.setProductCode(rs.getInt("ProductCode")); 
		                p.setProductName(rs.getString("ProductName") ); 
		                productList.add(p);
			        }
			        return productList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
			} 
	   
	   @Override
	   public int update(int number, int code) {
		    Connection con = ConnectionFact.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            int count = stmt.executeUpdate("Update Product Set Quantity = "+number+" Where ProductCode = "+code+"");
		            return count;
		        } catch (SQLException ex) {
	            ex.printStackTrace();
		        }  
		        
		        return 0;
		} 

}
