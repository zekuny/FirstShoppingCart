package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the USERSHOPPINGCART database table.
 * 
 */
@Entity
@NamedQuery(name="Usershoppingcart.findAll", query="SELECT u FROM Usershoppingcart u")
public class Usershoppingcart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "usershoppingcartSeq", sequenceName = "usershoppingcart_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usershoppingcartSeq")
	private int uscid;

	private int pid;

	private String username;

	public Usershoppingcart() {
	}

	public int getUscid() {
		return this.uscid;
	}

	public void setUscid(int uscid) {
		this.uscid = uscid;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}