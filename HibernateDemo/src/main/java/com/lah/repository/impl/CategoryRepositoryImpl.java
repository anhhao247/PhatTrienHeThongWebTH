/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lah.repository.impl;
import com.lah.hibernatedemo.HibernateUtils;
import com.lah.pojo.Category;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author hao
 */
public class CategoryRepositoryImpl {
    public List<Category> getCates() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
                CriteriaBuilder cb = s.getCriteriaBuilder();
                CriteriaQuery<Category> q = cb.createQuery(Category.class);
                Root root = q.from(Category.class);
                q.select(root);
                
                Query query = s.createQuery(q);
                return query.getResultList();
        }
    }
}
