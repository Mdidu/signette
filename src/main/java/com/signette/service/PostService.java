package com.signette.service;


import com.signette.domains.Post;
import com.signette.domains.PostPK;

import java.util.List;
import java.util.Optional;

public interface PostService extends GlobalService<Post, PostPK>{

    Optional<Post> findById(PostPK postPK);

    List<Post> findByTripId (long id);

    List<Post> findByUserId(long id);

    Post findByTripIdAndUserId(long tripId,long userId);
}
