package com.hibernate.model.many.to.many;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName = "prod_seq", allocationSize = 1)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price_per_unit")
	private String pricePerUnit;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="supplier_product",
			joinColumns = @JoinColumn(name="product_id"),
			inverseJoinColumns = @JoinColumn(name="supplier_id"))
	private List<Supplier> suppliers;

	public Product() {
	}

	public Product(String name, String description, String pricePerUnit) {
		this.name = name;
		this.description = description;
		this.pricePerUnit = pricePerUnit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	@Override
	public String toString() {
		return "Product [" +
				"id=" + id +
				", name=" + name +
				", description=" + description +
				", pricePerUnit=" + pricePerUnit + "]";
	}
}




