package florek.shop.domain.repository;

import java.util.List;

import florek.shop.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
}
