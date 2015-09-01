package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the SHOPPINGREVIEWCOMMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Shoppingreviewcomment.findAll", query="SELECT s FROM Shoppingreviewcomment s")
public class Shoppingreviewcomment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "shoppingreviewcommentSeq", sequenceName = "shoppingreviewcomment_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppingreviewcommentSeq")
	private int srcid;

	private String reviewcomment;

	private int reviewid;

	public Shoppingreviewcomment() {
	}

	public int getSrcid() {
		return this.srcid;
	}

	public void setSrcid(int srcid) {
		this.srcid = srcid;
	}

	public String getReviewcomment() {
		return this.reviewcomment;
	}

	public void setReviewcomment(String reviewcomment) {
		this.reviewcomment = reviewcomment;
	}

	public int getReviewid() {
		return this.reviewid;
	}

	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}

}