package com.tang.springmvc.recipe.Service;


import com.tang.springmvc.recipe.Model.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    Recipe saveRecipe(Recipe recipe);

    void deleteRecipe(Long id);
}
