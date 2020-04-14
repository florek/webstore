package florek.shop.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import florek.shop.domain.Product;

public interface ProductService {
	public Product getProductById(String productId);
	public List<Product> getAllProducts();
	public List<Product> getProductsByCategory(String category);
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	public Set<Product> getProductsByPriceAndManufacturerAndCategory(
		Map<String, List<String>> filterParams, 
		String manufacturer, 
		String category
	);
	public void addProduct(Product product);
}
