package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int pid;

	private String description;

	@Column(name="IMAGE_URL")
	private String imageUrl;

	@Column(name="P_NAME")
	private String pName;

	@Column(name="price")
	private double price;

	public Product() {
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPName() {
		return this.pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override 
	public boolean equals(Object other){ 
		if(this == other) 
			return true; 
		if(other == null || (this.getClass() != other.getClass())){ 
			return false; 
		} 
		Product product = (Product) other; 
		return this.pid == product.pid; 
	}
	
	@Override 
	public int hashCode(){ 
		int result = 0; 
		result = 31 * result + pid; 
		result = 31 * result + (pName !=null ? pName.hashCode() : 0); 
		return result; 
	} 
}