package com.jon.blog.services;

import com.jon.blog.domain.entities.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {

    List<Tag> getTags();
    List<Tag> createTags(Set<String> tagNames);
}
