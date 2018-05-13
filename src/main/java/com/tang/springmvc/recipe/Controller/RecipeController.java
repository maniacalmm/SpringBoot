package com.tang.springmvc.recipe.Controller;

import com.tang.springmvc.recipe.Model.Recipe;
import com.tang.springmvc.recipe.Service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.Set;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @GetMapping("/recipe/new")
    public String showCreateForm(Model model) {

        model.addAttribute("recipe", new Recipe());
        return "recipe/createRecipe";
    }

    @RequestMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/createRecipe";
    }


    @PostMapping("/recipe")
    public String saveOrUpdate(@ModelAttribute Recipe recipe) {
        Recipe saved = recipeService.saveRecipe(recipe);
        return "redirect:/recipe/" + saved.getId() + "/show";
    }

    @RequestMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id, Model model) {

        log.debug("deleting recipe: " + id);
        recipeService.deleteRecipe(new Long(id));

        model.addAttribute("recipes", recipeService
                                        .getRecipes()
                                        .stream()
                                        .sorted(Comparator.comparing(r -> r.getId()))
                                        .toArray()
        );

        return "index";
    }
}
