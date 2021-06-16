package com.signette.service;

import com.signette.domains.PostPK;

import java.util.List;

public interface PostService extends GlobalService<PostPK> {
    List<Object[]> findByTripByCenter(long id);
}
