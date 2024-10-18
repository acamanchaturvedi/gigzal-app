//package com.notabusiness.app.dao;
//
//import jakarta.persistence.Tuple;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class CategorySearchDaoImpl implements CategorySearchDao {
//
//    public static final String SEARCH_CATEGORIES_BY_TITLE = "select cat.category_id, cat.category_title, cat.sub_title, sk.skill_id, sk.title from Category cat " +
//            "inner join skill sk on cat.category_id = sk.category_id where (:title is null or title like concat('%', :title, '%')) offset =:offset limit =:limit";
//
//    @Override
//    public List<Tuple> getAllCategory(String category, String range) {
//
//        return null;
//    }
//}
