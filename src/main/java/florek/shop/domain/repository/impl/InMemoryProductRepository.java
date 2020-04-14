package florek.shop.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;
import florek.shop.domain.Product;
import florek.shop.domain.repository.ProductRepository;


@Repository
public class InMemoryProductRepository implements ProductRepository {
	private List<Product> listOfProducts = new ArrayList<Product>();

	public InMemoryProductRepository() {
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));

		iphone.setDescription("Apple iPhone 5s, "
			+ "smartfon z 4-calowym wyœwietlaczem o rozdzielczoœci 640x1136 oraz 8-megapikselowym aparatem");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);

		Product laptopDell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
		laptopDell.setDescription("Dell Inspirion, 14-calowy laptop (czarny) z procesorem Intel Core 3. generacji");
		laptopDell.setCategory("Laptop");
		laptopDell.setManufacturer("Dell");
		laptopDell.setUnitsInStock(1000);

		Product tabletNexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
		tabletNexus.setCategory("Tablet");
		tabletNexus.setManufacturer("Google");
		tabletNexus.setUnitsInStock(1000);

		listOfProducts.add(iphone);
		listOfProducts.add(laptopDell);
		listOfProducts.add(tabletNexus);
	}

	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	public Product getProductById(String productId) {
		Product productById = null;

		for (Product product : listOfProducts) {
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}

		if (productById == null) {
			throw new IllegalArgumentException("Brak produktu o wskazanym id: " + productId);
		}

		return productById;
	}

	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<Product>();

		for (Product product : listOfProducts) {
			if (category.equalsIgnoreCase(product.getCategory())) {
				productsByCategory.add(product);
			}
		}

		return productsByCategory;
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();

		if (criterias.contains("brand")) {
			for (String brandName : filterParams.get("brand")) {
				for (Product product : listOfProducts) {
					if (brandName.equalsIgnoreCase(product.getManufacturer())) {
						productsByBrand.add(product);
					}
				}
			}
		}
		
		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		
		productsByCategory.retainAll(productsByBrand);
		
		return productsByCategory;
	}
	
	public Set<Product> getProductsByPriceAndManufacturerAndCategory(
			Map<String, List<String>> filterParams, 
			String manufacturer, 
			String category
	) {
		Set<Product> filteredProducts = new HashSet<Product>();
		Set<Product> filteredProductsByPrice = getProductsByPrice(filterParams);
		
		for (Product filteredProduct : filteredProductsByPrice) {
			if (manufacturer.equalsIgnoreCase(filteredProduct.getManufacturer())
				&& category.equalsIgnoreCase(filteredProduct.getCategory())
			) {
				filteredProducts.add(filteredProduct);
			}
		}
		
		return filteredProducts;
	}

	private Set<Product> getProductsByPrice(Map<String, List<String>> filterParams) {
		Set<Product> productsByPrices = new HashSet<Product>();
		Set<Map.Entry<String, List<String>>> entries = filterParams.entrySet();
		BigDecimal priceLow = null;
		BigDecimal priceHigh = null;
		
		for (Map.Entry<String, List<String>> entry : entries) {
			if (entry.getKey().equals(LOW)) {
				priceLow = new BigDecimal(entry.getValue().get(0));
			} else if (entry.getKey().equals(HIGH)) {
				priceHigh = new BigDecimal(entry.getValue().get(0));
			}
		}
		
		for (Product product : listOfProducts) {
			boolean shouldBeAdded = true;
			
			if (priceLow != null && product.getUnitPrice().doubleValue() < priceLow.doubleValue()) {
				shouldBeAdded = false;
			}
			
			if (priceHigh != null && product.getUnitPrice().doubleValue() > priceHigh.doubleValue()) {
				shouldBeAdded = false;
			}
			
			if (shouldBeAdded) {
				productsByPrices.add(product);
			}
		}
		
		return productsByPrices;
	}

	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
}
