package com.signette.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PostType", schema = "public", catalog = "SIGNETTE")
public class PostTypeEntity {
    private int postId;
    private String postName;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "POST_SEQ")
    @SequenceGenerator(name = "POST_SEQ", sequenceName = "POST_SEQ", allocationSize = 1)
    @Column(name = "post_id", nullable = false)
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "post_name", nullable = false, length = 20)
    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTypeEntity that = (PostTypeEntity) o;
        return postId == that.postId && Objects.equals(postName, that.postName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postName);
    }
}
