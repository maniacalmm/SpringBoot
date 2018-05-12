package com.tang.springmvc.recipe.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setup() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 213L;

        category.setId(idValue);
        assertEquals(category.getId(), idValue);
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}