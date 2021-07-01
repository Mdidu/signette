package com.signette.service;

import com.signette.domains.PostType;
import com.signette.repository.PostTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PostTypeServiceImplTest {

    @Mock
    PostTypeRepository postTypeRepository;

    @InjectMocks
    PostTypeServiceImpl postTypeService;

    PostType postType1;
    PostType postType2;

    List<PostType> listPostType;

    @BeforeEach
    void setUp() {
        listPostType = new ArrayList<>();

        postType1 = new PostType(1, "Animateur pour adulte");
        postType2 = new PostType(2, "Animateur pour enfant");

        listPostType.add(postType1);
        listPostType.add(postType2);

        initMocks(this);

        when(postTypeRepository.findAll()).thenReturn(listPostType);
        when(postTypeRepository.findById(Matchers.anyLong())).thenReturn(Optional.ofNullable(postType1));
    }

    @Test
    void add() {
        postTypeService.add(postType1);
        verify(postTypeRepository).save(postType1);
    }

    @Test
    void delete() {
        postTypeService.delete(postType1);
        verify(postTypeRepository).delete(postType1);
    }

    @Test
    void update() {
        PostType postType3 = new PostType(1, "Animateur pour adulte");

        postType1.setPostName("Animateur pour mineur");

        postTypeService.update(postType1);

        verify(postTypeRepository).save(postType1);

        assertNotEquals(postType3.getPostName(), postType1.getPostName());
    }

    @Test
    void findAll() {
        List<PostType> getPost = postTypeService.findAll();
        assertEquals(2, getPost.size());
    }

    @Test
    void findById() {
        PostType getPost = postTypeService.findById(1);
        assertEquals(postType1.getPostId(), getPost.getPostId());
    }
}