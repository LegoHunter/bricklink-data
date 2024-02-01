package net.lego.data.v2.mybatis.mapper;

import net.lego.data.v2.dto.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

public interface CategoryMapper {
    @Insert("""
            INSERT INTO category (category_id, category_type, category_name) \
            VALUES (#{categoryId}, #{categoryType}, #{categoryName})\
            """)
    void insert(Category category);

    @Update("""
            UPDATE category SET category_type = #{categoryType}, category_name = #{categoryName} \
            WHERE category_id = #{categoryId}\
            """)
    void update(Category category);

    @Select("""
            SELECT category_id,\
                   category_type,\
                   category_name \
            FROM category\
            """)
    @ResultMap("categoryResultMap")
    List<Category> findAll();

    @Select("""
            SELECT category_id,\
                   category_type,\
                   category_name \
            FROM category \
            WHERE category_id = #{categoryId}\
            """)
    @ResultMap("categoryResultMap")
    Optional<Category> findCategoryById(Long categoryId);
}
