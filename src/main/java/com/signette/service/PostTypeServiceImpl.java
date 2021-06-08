package com.signette.service;

import com.signette.domains.PostTypeEntity;
import com.signette.repository.PostTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostTypeServiceImpl implements PostTypeService{

    @Autowired
    PostTypeRepository postTypeRepository;

    @Override
    public void add(PostTypeEntity postTypeEntity) {
        postTypeRepository.save(postTypeEntity);
    }

    @Override
    public void delete(PostTypeEntity postTypeEntity) {
        postTypeRepository.delete(postTypeEntity);
    }

    @Override
    public void update(PostTypeEntity postTypeEntity) {
        postTypeRepository.save(postTypeEntity);
    }

    @Override
    public List<PostTypeEntity> findAll() {
        return postTypeRepository.findAll();
    }

    @Override
    public PostTypeEntity findById(int id) {
        return postTypeRepository.findById(id).get();
    }
}
