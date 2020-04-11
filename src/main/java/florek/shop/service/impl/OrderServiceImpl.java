package florek.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import florek.shop.domain.Product;
import florek.shop.domain.repository.ProductRepository;
import florek.shop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductRepository productRepository;
	
	public void processOrder(String productId, int count) {
		Product productById = productRepository.getProductById(productId);
		
		if (productById.getUnitsInStock() < count) {
			throw new IllegalArgumentException("Zbyt ma³o towaru. Obecna liczba sztuk w magazynie: " + productById.getUnitsInStock());
		}
		
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}
}
