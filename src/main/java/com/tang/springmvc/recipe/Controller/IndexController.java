package com.tang.springmvc.recipe.Controller;

import com.tang.springmvc.recipe.Model.Category;
import com.tang.springmvc.recipe.Repos.CategoryRepos;
import com.tang.springmvc.recipe.Repos.UnitOfMeasureRepos;
import com.tang.springmvc.recipe.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"/", "", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService
                                        .getRecipes()
                                        .stream()
                                        .sorted(Comparator.comparing(r -> r.getId()))
                                        .toArray()
        );
        return "index";
    }

}
