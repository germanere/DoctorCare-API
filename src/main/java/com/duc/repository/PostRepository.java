package com.duc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duc.entity.Post;

@Repository("postrepository")
public interface PostRepository extends JpaRepository<Post, Integer>{

}
