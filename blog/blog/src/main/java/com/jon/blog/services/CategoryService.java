package com.jon.blog.services;

import com.jon.blog.domain.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> listCategories();
}
