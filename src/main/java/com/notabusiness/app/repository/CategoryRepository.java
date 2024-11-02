package com.notabusiness.app.repository;

import com.notabusiness.app.entity.Category;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select cat.category_id, cat.category_title, cat.sub_title, sk.skill_id, sk.title, count(*) over() as total_count " +
            "from category cat " +
            "inner join skill sk on cat.category_id = sk.category_id " +
            "where (cat.category_id in ( select category_id from category where category_title LIKE :title offset :offset limit :limit))", nativeQuery = true)
    public List<Tuple> getAllCategoriesWithCount(String title, int offset, int limit);

}
