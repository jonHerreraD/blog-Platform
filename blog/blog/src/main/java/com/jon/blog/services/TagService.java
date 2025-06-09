package com.jon.blog.services;

import com.jon.blog.domain.entities.Tag;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TagService {

    List<Tag> getTags();
    List<Tag> createTags(Set<String> tagNames);
    void deleteTag(UUID id);
    Tag findTagById(UUID id);
    List<Tag> getTagByIds(Set<UUID> ids);
}
