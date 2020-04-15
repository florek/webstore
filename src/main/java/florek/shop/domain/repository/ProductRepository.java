package florek.shop.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import florek.shop.domain.Product;

public interface ProductRepository {
    public static String HIGH = "high";
    public static String LOW = "low";

    public List<Product> getAllProducts();

    public List<Product> getProductsByCategory(String category);

    public Product getProductById(String productId);

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    public Set<Product> getProductsByPriceAndManufacturerAndCategory(Map<String, List<String>> filterParams,
	    String manufacturer, String category);

    public void addProduct(Product product);
}
