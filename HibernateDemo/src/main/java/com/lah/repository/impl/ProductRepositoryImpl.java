/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lah.repository.impl;
import com.lah.hibernatedemo.HibernateUtils;
import com.lah.pojo.Category;
import com.lah.pojo.Product;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hao
 */
public class ProductRepositoryImpl {
    public List<Product> getProducts(int cateId) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            Query q = s.createQuery("SELECT p FROM Product p WHERE p.category.id = :cateId", Product.class);
            q.setParameter("cateId", cateId);
            return q.getResultList();
        }
    }
}
