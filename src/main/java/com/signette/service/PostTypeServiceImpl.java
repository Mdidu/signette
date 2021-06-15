package com.signette.service;

import com.signette.domains.Post;
import com.signette.domains.PostType;
import com.signette.repository.PostTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostTypeServiceImpl implements PostTypeService{

    @Autowired
    PostTypeRepository postTypeRepository;

    @Override
    public void add(PostType postTypeEntity) {
        postTypeRepository.save(postTypeEntity);
    }

    @Override
    public void delete(PostType postTypeEntity) {
        postTypeRepository.delete(postTypeEntity);
    }

    @Override
    public void update(PostType postTypeEntity) {
        postTypeRepository.save(postTypeEntity);
    }

    @Override
    public List<PostType> findAll() {
        return postTypeRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postTypeRepository.findById(id).get();
    }
}
