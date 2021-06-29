package com.signette.service;

import com.signette.domains.Post;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PostService extends GlobalService<Post> {
    List<Object[]> findByTripId (long id);

    List<Post> findByUserId(long id);

    Post findByTripIdAndUserId(long tripId,long userId);
    
    List<Object[]> findByTripByCenter(long id);

    List<Object[]> findByPostUser(Date date, long userId);

    List<Object[]> findByPost(long userId);

    List<Object[]> findTripByUser(long id);
}
