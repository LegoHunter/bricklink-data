package net.lego.data.v2.dao;

import lombok.RequiredArgsConstructor;
import net.lego.data.v2.dto.Category;
import net.lego.data.v2.mybatis.mapper.CategoryMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryDao {
    private final CategoryMapper categoryMapper;

    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    public Optional<Category> findCategoryById(final Long categoryId) {
        return categoryMapper.findCategoryById(categoryId);
    }

    public void insert(Category category) {
        categoryMapper.insert(category);
    }

    public void update(Category category) {
        categoryMapper.update(category);
    }
}
