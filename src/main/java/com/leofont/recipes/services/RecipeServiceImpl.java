package com.leofont.recipes.services;

import com.leofont.recipes.domain.Recipe;
import com.leofont.recipes.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {

        //log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Recipe findById(long l) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if (!recipeOptional.isPresent()) {

            throw new RuntimeException("Recipe Not Found!");
        }
        return recipeOptional.get();
    }
}
