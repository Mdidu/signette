package com.signette.repository;

import com.signette.domains.PostTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTypeRepository extends JpaRepository<PostTypeEntity, Integer> {
}
