package com.zosh.recipesharingyoutube.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.recipesharingyoutube.model.Recipe;
import com.zosh.recipesharingyoutube.model.User;
import com.zosh.recipesharingyoutube.repository.RecipeRepository;

@Service
public class RecipeServiceImplementation implements RecipeService{
    
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe createRecipe(Recipe recipe, User user) {

        Recipe createdRecipe = new Recipe();
        createdRecipe.setTitle(recipe.getTitle());
        createdRecipe.setImage(recipe.getImage());
        createdRecipe.setDescription(recipe.getDescription());
        createdRecipe.setVegetarian(recipe.getVegetarian());
        createdRecipe.setUser(user);
        createdRecipe.setCreatedAt(LocalDateTime.now());

        return recipeRepository.save(createdRecipe);
    }

    @Override
    public Recipe findRecipeByid(Long Id) throws Exception {
        Optional<Recipe> opt = recipeRepository.findById(Id);

        if(opt.isPresent()){
            return opt.get();
        }

        throw new Exception("recipe not found with id"  + Id);
    }

    @Override
    public void deleteRecipe(Long Id) throws Exception {
        findRecipeByid(Id);
        recipeRepository.deleteById(Id);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, Long Id) throws Exception {
        Recipe oldRecipe = findRecipeByid(Id);
        if(recipe.getTitle()!=null){
            oldRecipe.setTitle(recipe.getTitle());
        }
        if(recipe.getImage()!=null){
            oldRecipe.setImage(recipe.getImage());
        }
        if(recipe.getDescription()!=null){
            oldRecipe.setDescription(recipe.getDescription());
        }
        if(recipe.getVegetarian()!=null){
            oldRecipe.setVegetarian(recipe.getVegetarian());
        }
        return recipeRepository.save(oldRecipe);
    }

    @Override
    public List<Recipe> findAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe likeRecipe(Long recipeId, User user) throws Exception {
        
        Recipe recipe = findRecipeByid(recipeId);
        if(recipe.getLikes().contains(user.getId())){
            recipe.getLikes().remove(user.getId());
        }
        else{
            recipe.getLikes().add(user.getId());
        }

        return recipeRepository.save(recipe);
    }
}