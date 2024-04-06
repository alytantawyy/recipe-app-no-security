package com.zosh.recipesharingyoutube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.recipesharingyoutube.model.Recipe;
import com.zosh.recipesharingyoutube.model.User;
import com.zosh.recipesharingyoutube.service.RecipeService;
import com.zosh.recipesharingyoutube.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    
    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping("/user/{userId}")  
    public Recipe createRecipe(@RequestBody Recipe recipe, @PathVariable Long userId) throws Exception{

        User user = userService.findUserById(userId);

        Recipe createdRecipe = recipeService.createRecipe(recipe, user);
        return createdRecipe;
    }

    @GetMapping()  
    public List<Recipe> getallRecipe(){

        List<Recipe> recipes = recipeService.findAllRecipe();
        return recipes;
    }

    @DeleteMapping("/{recipeId}")  
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

        recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";
        
    }


    @PutMapping("/{recipeId}")  
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long recipeId) throws Exception {

        Recipe updatedRecipe = recipeService.updateRecipe(recipe, recipeId);
        return updatedRecipe;
    }

    @PutMapping("/{recipeId}/like/user/{userId}")  
    public Recipe likeRecipe(@PathVariable Long recipeId, @PathVariable Long userId) throws Exception {

        User user = userService.findUserById(userId);

        Recipe likedRecipe = recipeService.likeRecipe(recipeId, user);
        return likedRecipe; 
    }


}