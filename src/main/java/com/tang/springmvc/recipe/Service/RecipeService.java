package com.tang.springmvc.recipe.Service;


import com.tang.springmvc.recipe.Model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
