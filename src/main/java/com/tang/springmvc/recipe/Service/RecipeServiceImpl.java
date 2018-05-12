package com.tang.springmvc.recipe.Service;

import com.tang.springmvc.recipe.Model.Recipe;
import com.tang.springmvc.recipe.Repos.RecipeRepos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepos recipeRepos;

    public RecipeServiceImpl(RecipeRepos recipeRepos) {
        this.recipeRepos = recipeRepos;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm a debug logger inside service");
        Set<Recipe> set = new HashSet<>();
        recipeRepos.findAll().iterator().forEachRemaining(set::add);
        return set;
    }
}
