package com.signette.repository;
import com.signette.domains.Post;
import com.signette.domains.PostPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, PostPK> {

    Post findById_TripIdAndId_UserId (long tripId,long userId);

    List<Post> findById_UserId(long userid);

    List<Post> findById_TripId(long tripid);

}