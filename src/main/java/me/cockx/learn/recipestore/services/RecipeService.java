package me.cockx.learn.recipestore.services;

import me.cockx.learn.recipestore.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
