package me.cockx.learn.recipestore.controllers;

import me.cockx.learn.recipestore.domain.Category;
import me.cockx.learn.recipestore.domain.UnitOfMeasure;
import me.cockx.learn.recipestore.repositories.CategoryRepository;
import me.cockx.learn.recipestore.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class MainController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository uomRepository;

    public MainController(CategoryRepository categoryRepository, UnitOfMeasureRepository uomRepository) {
        this.categoryRepository = categoryRepository;
        this.uomRepository = uomRepository;
    }




    @GetMapping({"/","","index","index.html"})
    public String index(){

        Optional<Category> cat = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uom = uomRepository.findByUom("Pinch");

        if(cat.isPresent()&&uom.isPresent()){
            System.out.println("Category id is: " +cat.get().getId());
            System.out.println("Uom id is: "+uom.get().getId());
        }


        return "index";
    }
}
