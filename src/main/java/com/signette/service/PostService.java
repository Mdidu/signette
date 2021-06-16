package com.signette.service;

import com.signette.domains.Post;
import com.signette.domains.PostPK;

import java.util.List;

public interface PostService extends GlobalService<Post> {
    List<Post> findByTripId (long id);

    List<Post> findByUserId(long id);

    Post findByTripIdAndUserId(long tripId,long userId);
    
    List<Object[]> findByTripByCenter(long id);
}
