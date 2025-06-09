package com.jon.blog.services;

import com.jon.blog.domain.entities.Post;
import com.jon.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
}
