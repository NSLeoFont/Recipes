package com.leofont.recipes.controllers;

import com.leofont.recipes.domain.Category;
import com.leofont.recipes.domain.UnitOfMeasure;
import com.leofont.recipes.repositories.CategoryRepository;
import com.leofont.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id is: " + categoryOptional.get().getId());
        System.out.println("UOM id is: " + unitOfMeasure.get().getId());

        return "index";
    }
}
