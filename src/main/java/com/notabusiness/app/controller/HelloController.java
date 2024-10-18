
package com.notabusiness.app.controller;
import com.notabusiness.app.entity.Category;

import com.notabusiness.app.repository.CategoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
//        Category testOneCategory = new Category();
//        testOneCategory.setName("test one");
//        categoryRepository.saveAndFlush(testOneCategory);
        return "Hello Aman! " + request.getSession().getId();
    }

}


