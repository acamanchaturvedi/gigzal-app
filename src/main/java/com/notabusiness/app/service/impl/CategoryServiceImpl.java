package com.notabusiness.app.service.impl;


import com.notabusiness.app.gigzal.generated.model.CategorySearchResponse;
import com.notabusiness.app.gigzal.generated.model.Skill;
import com.notabusiness.app.util.GigzalUtil;
import com.notabusiness.app.repository.CategoryRepository;
import com.notabusiness.app.service.CategoryService;
import com.notabusiness.app.util.CountCategorySearchResponse;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CountCategorySearchResponse getCategories(String category, String range) {
        List<Integer> offsetLimitFromRange = GigzalUtil.getOffsetLimitFromRange(range);
        String titlePattern = category;
        if(titlePattern != null){
             titlePattern = "%" + category + "%";
        }else {
            titlePattern ="%%";
        }
        List<Tuple> queryRes = categoryRepository.getAllCategoriesWithCount(titlePattern, offsetLimitFromRange.get(0), offsetLimitFromRange.get(1));

        if(queryRes != null && !queryRes.isEmpty()) {
            Map<Integer, CategorySearchResponse> categoryMap = new HashMap<>();
            Long totalCount = (Long) queryRes.get(0).get("total_count");
            for (Tuple tuple : queryRes) {
                Integer categoryId = (Integer) tuple.get("category_id");


                CategorySearchResponse categoryResponse = categoryMap.getOrDefault(categoryId, new CategorySearchResponse());


                if (categoryResponse.getCategoryId() == null) {
                    categoryResponse.setCategoryId(categoryId);
                    categoryResponse.setCategoryTitle((String) tuple.get("category_title"));
                    categoryResponse.setSubTitle((String) tuple.get("sub_title"));
                }

                Skill skill = new Skill();
                skill.setSkillId((Integer) tuple.get("skill_id"));
                skill.setSkillTitle((String) tuple.get("title"));


                categoryResponse.getSkillResponse().add(skill);


                categoryMap.put(categoryId, categoryResponse);
            }


            List<CategorySearchResponse> categoryResponseList = new ArrayList<>(categoryMap.values());


            CountCategorySearchResponse countCategorySearchResponse = new CountCategorySearchResponse();
            countCategorySearchResponse.setResponse(categoryResponseList);
            countCategorySearchResponse.setCount(Integer.parseInt(totalCount.toString()));


            return countCategorySearchResponse;
        }
        return  new CountCategorySearchResponse();
    }
}
