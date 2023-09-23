package com.husseinblog.blog.repositories;

import com.husseinblog.blog.models.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryRepository extends JpaRepository<Industry, Integer>, JpaSpecificationExecutor<Industry> {


}