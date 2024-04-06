package com.zosh.recipesharingyoutube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.recipesharingyoutube.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
    
}