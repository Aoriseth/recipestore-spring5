package me.cockx.learn.recipestore.controllers;

import me.cockx.learn.recipestore.domain.Recipe;
import me.cockx.learn.recipestore.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Captor
    ArgumentCaptor<Set<Recipe>> argumentCaptor;

    private MainController mainController;

    @Before
    public void setUp() {
        mainController = new MainController(recipeService);
    }

    @Test
    public void index() {
        Set<Recipe> testSet = new HashSet<>();
        testSet.add(Recipe.builder().description("Cabbage Cake").build());
        testSet.add(Recipe.builder().description("Guacamole").build());

        when(recipeService.getRecipes()).thenReturn(testSet);

        String page = mainController.index(model);

        assertEquals("index",page);
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        verify(recipeService,times(1)).getRecipes();

        Set<Recipe> actual = argumentCaptor.getValue();
        assertEquals(2,actual.size());
        assertTrue(actual.stream().anyMatch(s->s.getDescription().equals("Guacamole")));

    }
}