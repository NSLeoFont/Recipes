package com.leofont.recipes.services;

import com.leofont.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(long l);
}
