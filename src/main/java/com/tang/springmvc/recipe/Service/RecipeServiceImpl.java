package com.tang.springmvc.recipe.Service;

import com.tang.springmvc.recipe.Model.Recipe;
import com.tang.springmvc.recipe.Repos.RecipeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepos recipeRepos;

    public RecipeServiceImpl(RecipeRepos recipeRepos) {
        this.recipeRepos = recipeRepos;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> set = new HashSet<>();
        recipeRepos.findAll().iterator().forEachRemaining(set::add);
        return set;
    }
}
