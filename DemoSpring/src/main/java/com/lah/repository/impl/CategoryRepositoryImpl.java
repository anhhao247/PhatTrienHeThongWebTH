/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lah.repository.impl;
//import com.lah.hibernatedemo.HibernateUtils;

import com.lah.pojo.Category;
import com.lah.repositories.CatogoryRepository;
//import jakarta.data.repository.Repository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hao
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CatogoryRepository {

    @Autowired
    private LocalSessionFactoryBean fatory;

    
    @Override
    public List<Category> getCates() {
        Session s = this.fatory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Category> q = cb.createQuery(Category.class);
        Root root = q.from(Category.class);

        q.select(root);

        Query query = s.createQuery(q);

        return query.getResultList();

    }
}
