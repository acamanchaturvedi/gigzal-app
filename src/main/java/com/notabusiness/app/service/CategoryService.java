package com.notabusiness.app.service;


import com.notabusiness.app.util.CountCategorySearchResponse;

public interface CategoryService {

    public CountCategorySearchResponse getCategories(String category, String range);
}
