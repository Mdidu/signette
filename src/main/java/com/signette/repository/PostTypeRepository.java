package com.signette.repository;

import com.signette.domains.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTypeRepository extends JpaRepository<PostType, Long> {
}
