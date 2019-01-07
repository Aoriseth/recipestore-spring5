package me.cockx.learn.recipestore.repositories;

import me.cockx.learn.recipestore.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
