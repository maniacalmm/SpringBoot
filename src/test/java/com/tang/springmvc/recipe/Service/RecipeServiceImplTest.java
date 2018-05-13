package com.tang.springmvc.recipe.Service;

import com.tang.springmvc.recipe.Model.Recipe;
import com.tang.springmvc.recipe.Repos.RecipeRepos;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepos recipeRepos;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepos);
    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepos.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipedReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipedReturned);
        verify(recipeRepos, times(1)).findById(anyLong());
        verify(recipeRepos, never()).findAll();

    }

    @Test
    public void getRecipes() throws Exception {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesData);

        assertEquals(recipeService.getRecipes().size(), 1);
    }


}