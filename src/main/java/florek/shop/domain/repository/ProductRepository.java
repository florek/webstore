package florek.shop.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import florek.shop.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	Product getProductById(String productId);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
