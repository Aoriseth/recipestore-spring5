package me.cockx.learn.recipestore.controllers;

import lombok.extern.slf4j.Slf4j;
import me.cockx.learn.recipestore.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {

    private final RecipeService recipeService;

    public MainController(RecipeService recipeService) {
        log.warn("Building MainController");
        this.recipeService = recipeService;
    }

    @GetMapping({"/","","index","index.html"})
    public String index(Model model){

        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }
}
