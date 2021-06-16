package com.signette.service;

import com.signette.domains.PostPK;
import com.signette.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void add(PostPK type) {

    }

    @Override
    public void delete(PostPK type) {

    }

    @Override
    public void update(PostPK type) {

    }

    @Override
    public List<PostPK> findAll() {
        return null;
    }

    @Override
    public PostPK findById(long id) {
        return null;
    }

    @Override
    public List<Object[]> findByTripByCenter(long id) {
        List<Object[]> test = postRepository.findByTripByCenter(id);
        return test;
    }
}
