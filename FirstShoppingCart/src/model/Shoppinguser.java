package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the SHOPPINGUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Shoppinguser.findAll", query="SELECT s FROM Shoppinguser s")
public class Shoppinguser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "shoppinguserSeq", sequenceName = "shoppinguser_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppinguserSeq")
	private long userid;

	private String email;

	private String password;

	private String username;
	
	private double credit;

	public Shoppinguser() {
		credit = 0.0;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}