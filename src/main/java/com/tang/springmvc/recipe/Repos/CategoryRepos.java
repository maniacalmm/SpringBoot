package com.tang.springmvc.recipe.Repos;

import com.tang.springmvc.recipe.Model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepos extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String desc);
}
