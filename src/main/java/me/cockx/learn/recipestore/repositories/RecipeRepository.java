package me.cockx.learn.recipestore.repositories;

import me.cockx.learn.recipestore.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {




}
