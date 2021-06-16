package com.signette.repository;

import com.signette.domains.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    @Query(value = "SELECT COUNT(*), public.center.center_name, public.userentity.user_lastname, public.userentity.name_user FROM public.post LEFT JOIN public.userentity ON public.userentity.user_id = public.post.user_id LEFT JOIN public.trip ON public.trip.trip_id = public.post.trip_id LEFT JOIN public.center ON public.center.center_id = public.trip.center_id WHERE public.post.user_id = :user_id GROUP BY public.center.center_id, public.userentity.user_lastname, public.userentity.name_user", nativeQuery = true)
    List<Object[]> findByTripByCenter(@Param("user_id") long id);
}
