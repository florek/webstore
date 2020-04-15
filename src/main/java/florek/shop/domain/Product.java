package florek.shop.domain;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

@XmlRootElement
public class Product {
    private String productId;
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discountinued;
    private String condition;
    private MultipartFile productImage;
    private MultipartFile productIntroduction;

    public Product() {
	super();
    }

    public Product(String productId, String name, BigDecimal unitPrice) {
	this.productId = productId;
	this.name = name;
	this.unitPrice = unitPrice;
    }

    public void setProductId(String productId) {
	this.productId = productId;
    }

    public String getProductId() {
	return this.productId;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return this.name;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
	this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() {
	return this.unitPrice;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getDescription() {
	return this.description;
    }

    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
	return this.manufacturer;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getCategory() {
	return this.category;
    }

    public void setUnitsInStock(long unitsInStock) {
	this.unitsInStock = unitsInStock;
    }

    public long getUnitsInStock() {
	return this.unitsInStock;
    }

    public void setUnitsInOrder(long unitsInOrder) {
	this.unitsInOrder = unitsInOrder;
    }

    public long getUnitsInOrder() {
	return this.unitsInOrder;
    }

    public void setDiscountinued(boolean discountinued) {
	this.discountinued = discountinued;
    }

    public boolean getDiscountinued() {
	return this.discountinued;
    }

    public void setCondition(String condition) {
	this.condition = condition;
    }

    public String getCondition() {
	return this.condition;
    }

    public void setProductImage(MultipartFile productImage) {
	this.productImage = productImage;
    }

    @XmlTransient
    public MultipartFile getProductImage() {
	return productImage;
    }
    
    public void setProductIntroduction(MultipartFile productIntroduction) {
	this.productIntroduction = productIntroduction;
    }
    
    @XmlTransient
    public MultipartFile getProductIntroduction() {
	return productIntroduction;
    }

    @Override
    public boolean equals(Object obj) {

	if (this == obj)
	    return true;

	if (obj == null)
	    return false;

	if (getClass() != obj.getClass())
	    return false;

	Product other = (Product) obj;

	if (productId == null)
	    if (other.productId != null)
		return false;

	return true;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((productId == null) ? 0 : productId.hashCode());

	return result;
    }

    @Override
    public String toString() {
	return "Produkt [productId=" + productId + ", nazwa=" + name + "]";
    }
}
