package florek.shop.service;

import java.util.List;

import florek.shop.domain.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public List<Product> getProductsByCategory(String category);
}
