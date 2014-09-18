package com.myorg.example.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

public class Article implements Serializable {
	
	@SequenceGenerator(name="article_seq",sequenceName="ARTICLE_SEQ")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="article_seq")
	@Column(name="ARTICLE_ID")
	private long articleId;
	
	@Column(name="ARTICLE_TITLE")
	private String articleTitle;
	
	@Column(name="ARTICLE_CONTENT")
	private byte[] content;
	
	@Version
	private long version;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="ARTICLE_AUTHOR",joinColumns={@JoinColumn(name="ARTICLE_ID")},
			inverseJoinColumns={@JoinColumn(name="authorId")})
	private Set<Author> authors;

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	

}
