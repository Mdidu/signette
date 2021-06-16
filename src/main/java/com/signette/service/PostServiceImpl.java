package com.signette.service;

import com.signette.domains.Post;
import com.signette.domains.PostPK;
import com.signette.domains.PostType;
import com.signette.repository.PostRepository;
import com.signette.repository.PostTypeRepository;
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
    public void add(Post post) {
        postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public void update(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    //inutiliser
    @Override
    public Post findById(long id) {
        return null;
    }

    @Override
    public List<Object[]> findByTripByCenter(long id) {
        List<Object[]> test = postRepository.findByTripByCenter(id);
        return test;

    public List<Post> findByTripId(long id) {
        return postRepository.findById_TripId(id);
    }

    @Override
    public List<Post> findByUserId(long userid) {
        return postRepository.findById_UserId(userid);
    }

    @Override
    public Post findByTripIdAndUserId(long tripId, long userId) {
        return postRepository.findById_TripIdAndId_UserId(tripId, userId);
    }
}
