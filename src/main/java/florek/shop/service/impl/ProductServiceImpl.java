package florek.shop.service.impl;

import java.util.List;

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
}
