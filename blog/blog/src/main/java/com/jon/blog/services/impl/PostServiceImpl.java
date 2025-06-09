package com.jon.blog.services.impl;

import com.jon.blog.domain.PostStatus;
import com.jon.blog.domain.entities.Category;
import com.jon.blog.domain.entities.Post;
import com.jon.blog.domain.entities.Tag;
import com.jon.blog.domain.entities.User;
import com.jon.blog.repositories.CategoryRepository;
import com.jon.blog.repositories.PostRepository;
import com.jon.blog.services.CategoryService;
import com.jon.blog.services.PostService;
import com.jon.blog.services.TagService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final TagService tagService;

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllPosts(UUID categoryId, UUID tagId) {
        if (categoryId != null && tagId != null){
            Category category = categoryService.getCategoryById(categoryId);
            Tag tag = tagService.findTagById(tagId);

            return postRepository.findAllByStatusAndCategoryAndTagsContaining(
                    PostStatus.PUBLISHED,
                    category,
                    tag
            );
        }

        if (categoryId != null){
            Category category = categoryService.getCategoryById(categoryId);
            return postRepository.findAllByStatusAndCategory(
                    PostStatus.PUBLISHED,
                    category
            );

        }

        if (tagId != null){
            Tag tag = tagService.findTagById(tagId);
            return postRepository.findAllByStatusAndTagsContaining(
                    PostStatus.PUBLISHED,
                    tag
            );
        }

        return postRepository.findAllByStatus(PostStatus.PUBLISHED);
    }

    @Override
    public List<Post> getDraftPosts(User user) {
        return postRepository.findAllByAuthorAndStatus(user, PostStatus.DRAFT);
    }
}
