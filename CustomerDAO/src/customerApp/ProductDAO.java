package customerApp;

import java.util.List;

public interface ProductDAO { 
	
	public Product getProduct(int id);
	public List<Product> getAllProducts();
	public List<Product> getProductCusto(); 
	public int update(int number, int code);

}
