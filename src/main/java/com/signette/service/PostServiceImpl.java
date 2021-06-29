package com.signette.service;

import com.signette.domains.Post;
import com.signette.domains.PostPK;
import com.signette.domains.PostType;
import com.signette.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        return postRepository.findByTripByCenter(id);
    }

    @Override
    public List<Object[]> findByPostUser(Date date, long userId) {
        return postRepository.findByPostUser(date, userId);
    }

    @Override
    public List<Object[]> findByPost(long userId) {
        return postRepository.findByPost(userId);
    }

    @Override
    public List<Object[]> findTripByUser(long id) {
        return postRepository.findTripByUser(id);
    }

    public List<Object[]> findByTripId(long id) {
        return postRepository.findByTripId(id);
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
