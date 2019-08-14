package ec.hulkStore.model;

import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;
	
	@Column(name = "name")
	@Length(min = 3, message = "*The name must have at least 5 characters")
	private String name;
	
	@Column(name = "price", nullable = false)
	@DecimalMin(value = "0.00", message = "*The price cannot be a negative value")
	private BigDecimal price;
	

	@Column(name = "quantity", nullable = false)
	@Min(value = 0, message = "*The quantity cannot be a negative value")
	private Integer quantity;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long id;



	




	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal unitPrice) {
		this.price = unitPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
		super();
	}

 

	public Product(Category category, String description, String image,String name, BigDecimal price, Integer quantity) {
		super();
		this.category = category;
		this.description = description;
		this.image = image;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		return id.equals(product.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
