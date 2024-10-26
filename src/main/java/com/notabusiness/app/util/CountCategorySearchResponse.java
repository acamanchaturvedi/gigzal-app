package com.notabusiness.app.util;

import com.notabusiness.app.gigzal.generated.model.CategorySearchResponse;
import lombok.Data;

import java.util.List;

@Data
public class CountCategorySearchResponse {
    List<CategorySearchResponse> response;
    Integer count;
}
