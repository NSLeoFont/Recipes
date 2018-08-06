package com.leofont.recipes.controllers;

import com.leofont.recipes.domain.Category;
import com.leofont.recipes.domain.UnitOfMeasure;
import com.leofont.recipes.repositories.CategoryRepository;
import com.leofont.recipes.repositories.UnitOfMeasureRepository;
import com.leofont.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

   // private CategoryRepository categoryRepository;
   //  private UnitOfMeasureRepository unitOfMeasureRepository;

   // public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
   //     this.categoryRepository = categoryRepository;
   //     this.unitOfMeasureRepository = unitOfMeasureRepository;
   // }

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage(Model model) {

        //Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        //Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        //System.out.println("Cat id is: " + categoryOptional.get().getId());
        //System.out.println("UOM id is: " + unitOfMeasure.get().getId());

        model.addAttribute("recipes", recipeService.getRecipes());

        log.debug("Into the controller recipes");

        return "index";
    }
}
