package com.signette.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the POSTTYPE database table.
 * 
 */
@Entity
@Table(name="POSTTYPE")
public class PostType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "POST_SEQ")
	@SequenceGenerator(name = "POST_SEQ", sequenceName = "POST_SEQ", allocationSize = 1)
	@Column(name="POST_ID")
	private long postId;

	@Column(name="POST_NAME")
	private String postName;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="posttype", fetch=FetchType.EAGER)
	private List<Post> posts;

	public PostType() {
	}

	public long getPostId() {
		return this.postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setPosttype(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setPosttype(null);

		return post;
	}

}