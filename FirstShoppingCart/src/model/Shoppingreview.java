package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the SHOPPINGREVIEWS database table.
 * 
 */
@Entity
@Table(name="SHOPPINGREVIEWS")
@NamedQuery(name="Shoppingreview.findAll", query="SELECT s FROM Shoppingreview s")
public class Shoppingreview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "shoppingreviewsSeq", sequenceName = "shoppingreviews_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppingreviewsSeq")
	private int reviewid;

	private int pid;

	private String review;

	private String reviewdate;

	private String username;
	
	private int rating;

	public Shoppingreview() {
	}

	public int getReviewid() {
		return this.reviewid;
	}

	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewdate() {
		return this.reviewdate;
	}

	public void setReviewdate(String reviewdate) {
		this.reviewdate = reviewdate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}