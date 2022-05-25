package com.kcbgroup.main.repos;

import com.kcbgroup.main.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Integer> {
}
