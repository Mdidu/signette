package com.signette.repository;

import com.signette.domains.DataContratPdf;
import com.signette.domains.Post;
import com.signette.domains.PostPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, PostPK> {

    Post findById_TripIdAndId_UserId (long tripId,long userId);

    @Query(value ="select public.post.*, public.posttype.post_name ,public.userentity.user_lastname, public.userentity.name_user, public.userentity.user_phone FROM public.post INNER JOIN public.userentity ON public.userentity.user_id = public.post.user_id LEFT JOIN public.posttype ON public.posttype.post_id = public.post.post_id WHERE post.trip_id = :trip_id", nativeQuery = true)
    List<Object[]> findByTripId (@Param("trip_id") long tripid);
  
    @Query(value = "SELECT COUNT(*), public.center.center_name, public.userentity.user_lastname, public.userentity.name_user FROM public.post LEFT JOIN public.userentity ON public.userentity.user_id = public.post.user_id LEFT JOIN public.trip ON public.trip.trip_id = public.post.trip_id LEFT JOIN public.center ON public.center.center_id = public.trip.center_id WHERE public.post.user_id = :user_id GROUP BY public.center.center_id, public.userentity.user_lastname, public.userentity.name_user", nativeQuery = true)
    List<Object[]> findByTripByCenter(@Param("user_id") long id);

    @Query(value = "SELECT trip.trip_id, post.user_id, posttype.post_name, center.center_name, client.client_wording, trip.trip_end_date FROM public.post LEFT JOIN public.trip ON public.trip.trip_id = public.post.trip_id LEFT JOIN public.posttype ON public.posttype.post_id = public.post.post_id LEFT JOIN public.center ON public.trip.center_id = public.center.center_id LEFT JOIN public.client ON public.client.client_id = public.trip.client_id WHERE trip_end_date > :date AND user_id = :userId", nativeQuery = true)
    List<Object[]> findByPostUser(@Param("date") Date date, @Param("userId") long userId);

    @Query(value = "SELECT trip.trip_id, post.user_id, posttype.post_name, center.center_name, client.client_wording, trip.trip_end_date FROM public.post LEFT JOIN public.trip ON public.trip.trip_id = public.post.trip_id LEFT JOIN public.posttype ON public.posttype.post_id = public.post.post_id LEFT JOIN public.center ON public.trip.center_id = public.center.center_id LEFT JOIN public.client ON public.client.client_id = public.trip.client_id WHERE user_id = :userId", nativeQuery = true)
    List<Object[]> findByPost(@Param("userId") long userId);

    @Query(value = "SELECT public.trip.trip_id,public.trip.trip_end_date,public.trip.trip_start_date, public.center.center_name, public.client.client_wording FROM public.post LEFT JOIN public.userentity ON public.userentity.user_id = public.post.user_id LEFT JOIN public.trip ON public.trip.trip_id = public.post.trip_id LEFT JOIN public.center ON public.trip.center_id = public.center.center_id LEFT JOIN public.client ON public.client.client_id = public.trip.client_id WHERE public.post.user_id =:user_id", nativeQuery = true)
    List<Object[]> findTripByUser(@Param("user_id") long id);

    @Query(value = "SELECT userentity.name_user, userentity.user_lastname, userentity.user_mail, userentity.user_phone, trip.trip_start_date, trip.trip_end_date, center.center_name FROM post LEFT JOIN userentity ON userentity.user_id = post.user_id LEFT JOIN trip ON trip.trip_id = post.trip_id LEFT JOIN center ON center.center_id = trip.center_id WHERE public.post.trip_id = :trip_id AND public.post.user_id = :user_id", nativeQuery = true)
    List<Object[]> findListPDFData(@Param("user_id") long userId, @Param("trip_id") long tripId);

    List<Post> findById_UserId(long userid);
}
