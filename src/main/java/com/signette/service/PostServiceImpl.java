package com.signette.service;

import com.signette.domains.Post;
import com.signette.domains.PostPK;
import com.signette.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService{

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


    @Override
    public Optional<Post> findById(PostPK postPK) {
        return postRepository.findById(postPK);
    }

    @Override
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
