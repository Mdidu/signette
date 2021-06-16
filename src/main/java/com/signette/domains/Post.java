package com.signette.domains;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the POST database table.
 * 
 */
@Entity
@Table(name = "POST")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PostPK id;

	//bi-directional many-to-one association to Posttype
	@ManyToOne
	@JoinColumn(name="POST_ID")
	private PostType posttype;


	public Post() {
	}

	public PostPK getId() {
		return this.id;
	}

	public PostPK setId(PostPK id) {
		this.id = id;
		return id;
	}

	public PostType getPosttype() {
		return this.posttype;
	}

	public void setPosttype(PostType posttype) {
		this.posttype = posttype;
	}



}