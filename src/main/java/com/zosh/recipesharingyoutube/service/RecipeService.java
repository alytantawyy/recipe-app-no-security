package com.zosh.recipesharingyoutube.service;

import java.util.List;

import com.zosh.recipesharingyoutube.model.Recipe;
import com.zosh.recipesharingyoutube.model.User;

public interface RecipeService {

    public Recipe createRecipe(Recipe recipe, User user);

    public Recipe findRecipeByid(Long Id) throws Exception;

    public void deleteRecipe(Long Id) throws Exception;

    public Recipe updateRecipe(Recipe recipe, Long Id) throws Exception;

    public List<Recipe> findAllRecipe();

    public Recipe likeRecipe(Long recipeId, User user) throws Exception; 
     
}