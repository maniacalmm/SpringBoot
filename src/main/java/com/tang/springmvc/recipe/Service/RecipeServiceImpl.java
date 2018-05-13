package com.tang.springmvc.recipe.Service;

import com.tang.springmvc.recipe.Model.Recipe;
import com.tang.springmvc.recipe.Repos.RecipeRepos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
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

    @Override
    @Transactional
    public Recipe findById(Long id) {
        Optional<Recipe> recipe = recipeRepos.findById(id);

        if (!recipe.isPresent()) throw new RuntimeException("not such recipe exist");

        return recipe.get();
    }

    @Override
    @Transactional
    public Recipe saveRecipe(Recipe recipe) {
        log.debug("saving recipe");
        return recipeRepos.save(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepos.deleteById(id);
    }


}
