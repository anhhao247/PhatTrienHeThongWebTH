/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lah.services.impl;

import com.lah.pojo.Category;
import com.lah.repositories.CatogoryRepository;
import com.lah.services.CategoryServices;
import com.lah.repository.impl.CategoryRepositoryImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CategoryServicesImpl implements CategoryServices{
    @Autowired
    private CatogoryRepository cateRepo;

    
    @Override
    public List<Category> getCates() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
