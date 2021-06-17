package com.signette.repository;

import com.signette.domains.Post;
import com.signette.domains.PostPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, PostPK> {

    Post findById_TripIdAndId_UserId (long tripId,long userId);

    List<Post> findById_UserId(long userid);

    @Query(value ="select public.post.*, public.posttype.post_name ,public.userentity.user_lastname, public.userentity.name_user, , public.userentity.user_phone FROM public.post INNER JOIN public.userentity ON public.userentity.user_id = public.post.user_id LEFT JOIN public.posttype ON public.posttype.post_id = public.post.post_id WHERE post.trip_id = :trip_id", nativeQuery = true)
    List<Object[]> findByTripId (@Param("trip_id") long tripid);
  
    @Query(value = "SELECT COUNT(*), public.center.center_name, public.userentity.user_lastname, public.userentity.name_user FROM public.post LEFT JOIN public.userentity ON public.userentity.user_id = public.post.user_id LEFT JOIN public.trip ON public.trip.trip_id = public.post.trip_id LEFT JOIN public.center ON public.center.center_id = public.trip.center_id WHERE public.post.user_id = :user_id GROUP BY public.center.center_id, public.userentity.user_lastname, public.userentity.name_user", nativeQuery = true)
    List<Object[]> findByTripByCenter(@Param("user_id") long id);
}
