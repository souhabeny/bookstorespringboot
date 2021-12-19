package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message = "Title is mandatory")
	@Column(name = "title")
	private String title;
	@NotBlank(message = "Author is mandatory")
	@Column(name = "author")
	private String author;
	
	@Column(name = "price")
	private float price;

	@Column(name = "pdate")
	private String pdate;
	@Column(name = "qte")
	private int qte;
	@NotBlank(message = "Description is mandatory")
	@Column(name = "description")
	private String description;
	@Column(name = "picture")
	private String picture;
	/**** Many To One ****/
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "categorie_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Categorie categorie;
	
	
	public Book(long id, @NotBlank(message = "Title is mandatory") String title,
			@NotBlank(message = "Author is mandatory") String author,
			float price, String pdate, int qte,
			@NotBlank(message = "Description is mandatory") String desc, String picture, Categorie categorie) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pdate = pdate;
		this.qte = qte;
		this.description = desc;
		this.picture = picture;
		this.categorie = categorie;
	}
	
	public Book() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", pdate=" + pdate
				+ ", qte=" + qte + ", description=" + description + ", picture=" + picture + ", categorie=" + categorie
				+ "]";
	}
	
}
