package com.notabusiness.app.controller;

import com.notabusiness.app.gigzal.generated.controller.ServiceApi;
import com.notabusiness.app.gigzal.generated.model.CategorySearchResponse;
import com.notabusiness.app.service.CategoryService;
import com.notabusiness.app.util.CountCategorySearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceController implements ServiceApi {

    @Autowired
    CategoryService categoryService;

    @Override
    public List<CategorySearchResponse> findAllCategories(String range, String category) {
        System.out.println(category);
        CountCategorySearchResponse categories = categoryService.getCategories(category, range);
        return categories.getResponse();
    }
}

