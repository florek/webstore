package florek.shop.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import florek.shop.domain.Product;
import florek.shop.domain.repository.ProductRepository;
import florek.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepostiory;
	
	public List<Product> getAllProducts() {
		return productRepostiory.getAllProducts();
	}

	public List<Product> getProductsByCategory(String category) {
		return productRepostiory.getProductsByCategory(category);
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepostiory.getProductsByFilter(filterParams);
	}

	public Product getProductById(String productId) {
		return productRepostiory.getProductById(productId);
	}

	public Set<Product> getProductsByPriceAndManufacturerAndCategory(
		Map<String, List<String>> filterParams, 
		String manufacturer, 
		String category
	) {
		return productRepostiory.getProductsByPriceAndManufacturerAndCategory(filterParams, manufacturer, category);
	}

	public void addProduct(Product product) {
		productRepostiory.addProduct(product);
	}
}
