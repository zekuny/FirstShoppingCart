package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the SHOPPINGHISTORY database table.
 * 
 */
@Entity
@NamedQuery(name="Shoppinghistory.findAll", query="SELECT s FROM Shoppinghistory s")
public class Shoppinghistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "shoppinghistorySeq", sequenceName = "shoppinghistory_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppinghistorySeq")
	private int shid;

	private int pid;

	private String productname;

	private String username;

	public Shoppinghistory() {
	}

	public int getShid() {
		return this.shid;
	}

	public void setShid(int shid) {
		this.shid = shid;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}