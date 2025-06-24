/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lah.repository.impl;
import com.lah.hibernatedemo.HibernateUtils;
import com.lah.pojo.Category;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author hao
 */
public class CategoryRepositoryImpl {
    public List<Category> getCates() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            Query q = s.createQuery("FROM Category", Category.class);
            return q.getResultList();
        }
    }
}
