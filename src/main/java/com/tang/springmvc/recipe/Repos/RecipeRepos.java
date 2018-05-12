package com.tang.springmvc.recipe.Repos;

import com.tang.springmvc.recipe.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RecipeRepos extends CrudRepository<Recipe, Long> {
}
