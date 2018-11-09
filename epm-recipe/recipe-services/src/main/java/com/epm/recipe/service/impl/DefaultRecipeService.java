package com.epm.recipe.service.impl;

import com.epm.recipe.domain.Recipe;
import com.epm.recipe.persistence.RecipeRepository;
import com.epm.recipe.service.RecipeService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DefaultRecipeService implements RecipeService {

    private final RecipeRepository recipeRepository;

    public DefaultRecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = Objects.requireNonNull(recipeRepository, "recipeRepository");
    }

    @Override
    public Recipe recipeOfTheDay() {
        List<Recipe> all = recipeRepository.findAll();
        if (all.isEmpty()) {
            throw new IllegalStateException("No recipes at all");
        }
        return all.get(0);
    }

    @Override
    public List<Recipe> findAll() {
        return null;
    }

    @Override
    public Optional<Recipe> findById(long id) {
        return recipeRepository.findAll()
                .stream()
                .filter(recipe -> recipe.id == id)
                .findFirst();
    }

    @Override
    public void create(Recipe recipe) {
    }

    @Override
    public void update(Recipe recipe) {
    }

    @Override
    public void delete(long id) {

    }


}