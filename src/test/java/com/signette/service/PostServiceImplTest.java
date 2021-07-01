package com.signette.service;

import com.signette.domains.Post;
import com.signette.domains.PostPK;
import com.signette.domains.PostType;
import com.signette.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PostServiceImplTest {

    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostServiceImpl postService;

    Post post1;
    Post post2;
    List<Post> listPost;

    //Object for test ByTripId
    Object[] objectByTripId1;
    Object[] objectByTripId2;
    List<Object[]> listObjectByTripId;

    // Object for test TripByUser
    Object[] objectTripByUser1;
    Object[] objectTripByUser2;
    List<Object[]> listObjectTripByUser;

    //Object for test ByPost
    Object[] objectByPost1;
    Object[] objectByPost2;
    List<Object[]> listObjectByPost;

    //Object for test ByTripByCenter
    Object[] objectByTripByCenter1;
    Object[] objectByTripByCenter2;
    Object[] objectByTripByCenter3;
    List<Object[]> listObjectByTripByCenter;

    @BeforeEach
    void setUp() {
        initPostAndListPost();
        initObjectsByTripId();
        initObjectsTripByUser();
        initObjectsBPost();
        initObjectsByTripByCenter();

        initMocks(this);

        when(postRepository.save(Matchers.any(Post.class))).thenReturn(post1);
        when(postRepository.findAll()).thenReturn(listPost);
        when(postRepository.findByPostUser(Matchers.any(Date.class) ,Matchers.anyLong())).thenReturn(listObjectByPost);
        when(postRepository.findByPost(Matchers.anyLong())).thenReturn(listObjectByPost);
        when(postRepository.findTripByUser(Matchers.anyLong())).thenReturn(listObjectTripByUser);
        when(postRepository.findByTripId(Matchers.anyLong())).thenReturn(listObjectByTripId);
        when(postRepository.findById_UserId(Matchers.anyLong())).thenReturn(listPost);
        when(postRepository.findById_TripIdAndId_UserId(Matchers.anyLong(), Matchers.anyLong())).thenReturn(post1);
    }

    void initPostAndListPost() {
        listPost = new ArrayList<>();

        post1 = new Post(new PostPK(1, 1), new PostType(1, "Animateur junior"));
        post2 = new Post(new PostPK(2, 2), new PostType(2, "Animateur senior"));

        listPost.add(post1);
        listPost.add(post2);
    }

    void initObjectsByTripId() {
        listObjectByTripId = new ArrayList<>();

         // Define objectByTripId1
        objectByTripId1 = new Object[7];
        objectByTripId1[0] = new BigInteger(String.valueOf(1));
        objectByTripId1[1] = new BigInteger(String.valueOf(1));
        objectByTripId1[2] = new BigInteger(String.valueOf(1));
        objectByTripId1[3] = "Animateur junior";
        objectByTripId1[4] = "Repaire";
        objectByTripId1[5] = "Alexandre";
        objectByTripId1[6] = "00.01.00.01.00";

        // Define objectByTripId2
        objectByTripId2 = new Object[7];
        objectByTripId2[0] = new BigInteger(String.valueOf(1));
        objectByTripId2[1] = new BigInteger(String.valueOf(1));
        objectByTripId2[2] = new BigInteger(String.valueOf(1));
        objectByTripId2[3] = "Animateur senior";
        objectByTripId2[4] = "Lagssaibi";
        objectByTripId2[5] = "Farid";
        objectByTripId2[6] = "00.02.00.02.00";

        listObjectByTripId.add(objectByTripId1);
        listObjectByTripId.add(objectByTripId2);
    }

    void initObjectsTripByUser() {
        listObjectTripByUser = new ArrayList<>();

        // Define objectTripByUser1
        objectTripByUser1 = new Object[5];
        objectTripByUser1[0] = new BigInteger(String.valueOf(1));
        objectTripByUser1[1] = new Date(2013, 5, 28);
        objectTripByUser1[2] = new Date(2013, 9, 15);
        objectTripByUser1[3] = "Loisir1";
        objectTripByUser1[4] = "Vacance en france";

        //Define objectTripByUser2
        objectTripByUser2 = new Object[5];
        objectTripByUser2[0] = new BigInteger(String.valueOf(2));
        objectTripByUser2[1] = new Date(2015, 5, 28);
        objectTripByUser2[2] = new Date(2015, 9, 15);
        objectTripByUser2[3] = "Loisir2";
        objectTripByUser2[4] = "Vacance hors france";

        listObjectTripByUser.add(objectTripByUser1);
        listObjectTripByUser.add(objectTripByUser2);
    }

    void initObjectsBPost() {
        listObjectByPost = new ArrayList<>();

        //Define objectByPost1
        objectByPost1 = new Object[6];
        objectByPost1[0] = new BigInteger(String.valueOf(1));
        objectByPost1[1] = new BigInteger(String.valueOf(1));
        objectByPost1[2] = "Animateur junior";
        objectByPost1[3] = "Loisir1";
        objectByPost1[4] = "Vacance en france";
        objectByPost1[5] = new Date(2013, 5, 28);

        //Define objectByPost2
        objectByPost2 = new Object[6];
        objectByPost2[0] = new BigInteger(String.valueOf(2));
        objectByPost2[1] = new BigInteger(String.valueOf(2));
        objectByPost2[2] = "Animateur senior";
        objectByPost2[3] = "Loisir2";
        objectByPost2[4] = "Vacance hors france";
        objectByPost2[5] = new Date(2015, 5, 28);

        listObjectByPost.add(objectByPost1);
        listObjectByPost.add(objectByPost2);
    }

    void initObjectsByTripByCenter() {
        listObjectByTripByCenter = new ArrayList<>();

        //Define objectByTripByCenter1
        objectByTripByCenter1 = new Object[4];
        objectByTripByCenter1[0] = new BigInteger(String.valueOf(1));
        objectByTripByCenter1[1] = "Loisir1";
        objectByTripByCenter1[2] = "Louis";
        objectByTripByCenter1[3] = "Random";

        //Define objectByTripByCenter2
        objectByTripByCenter2 = new Object[4];
        objectByTripByCenter2[0] = new BigInteger(String.valueOf(2));
        objectByTripByCenter2[1] = "Loisir2";
        objectByTripByCenter2[2] = "Louis";
        objectByTripByCenter2[3] = "Random";

        //Define objectByTripByCenter3
        objectByTripByCenter3 = new Object[4];
        objectByTripByCenter3[0] = new BigInteger(String.valueOf(2));
        objectByTripByCenter3[1] = "Loisir3";
        objectByTripByCenter3[2] = "Louis";
        objectByTripByCenter3[3] = "Random";

        listObjectByTripByCenter.add(objectByTripByCenter1);
        listObjectByTripByCenter.add(objectByTripByCenter2);
        listObjectByTripByCenter.add(objectByTripByCenter3);
    }

    @Test
    void add() {
        postService.add(post1);
        verify(postRepository).save(post1);
    }

    @Test
    void delete() {
        postService.delete(post1);
        verify(postRepository).delete(post1);
    }

    @Test
    void update() {
        Post post3 = new Post(new PostPK(1, 1), new PostType(1, "Animateur junior"));

        post1.getPosttype().setPostName("Animateur1");

        postService.update(post1);

        verify(postRepository).save(post1);

        assertNotEquals(post3.getPosttype().getPostName(), post1.getPosttype().getPostName());
    }

    @Test
    void findAll() {
        List<Post> getPost = postService.findAll();
        assertEquals(2, getPost.size());
    }

    @Test
    void findByTripByCenter() {
        List<Object[]> listTrie = listObjectByTripByCenter.stream()
                .filter(obj -> obj[2]=="Louis")
                .filter(obj -> obj[3]=="Random")
                .filter(distinctByTrip(obj -> obj[1]))
                .collect(Collectors.toList());

        System.out.println(listObjectByTripByCenter.size());
        System.out.println(listTrie.size());

        assertEquals(listObjectByTripByCenter, listTrie);
    }

    public static <T> Predicate<T> distinctByTrip(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Test
    void findByPostUser() {
        List<Object[]> getPost = postService.findByPostUser(new Date(),1l);

        assertEquals(listObjectByPost, getPost);
    }

    @Test
    void findByPost() {
        List<Object[]> getPost = postService.findByPost(1l);

        assertEquals(listObjectByPost, getPost);
    }

    @Test
    void findTripByUser() {
        List<Object[]> getPost = postService.findTripByUser(1l);

        assertEquals(listObjectTripByUser, getPost);
    }

    @Test
    void findByTripId() {
        List<Object[]> getPost = postService.findByTripId(1l);

        assertEquals(listObjectByTripId, getPost);
    }

    @Test
    void findByUserId() {
        List<Post> getPost = postService.findByUserId(1l);

        assertEquals(2, getPost.size());
    }

    @Test
    void findByTripIdAndUserId() {
        Post getPost = postService.findByTripIdAndUserId(post1.getId().getTripId(), post1.getId().getUserId());

        assertEquals(post1, getPost);
    }
}
