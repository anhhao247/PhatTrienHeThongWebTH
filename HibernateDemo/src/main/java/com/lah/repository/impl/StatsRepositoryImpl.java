/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lah.repository.impl;

import com.lah.hibernatedemo.HibernateUtils;
import com.lah.pojo.OrderDetail;
import com.lah.pojo.Product;
import com.lah.pojo.SaleOrder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author hao
 */
public class StatsRepositoryImpl {

    public List<Object[]> statsRevenuebyProduct() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);
            Root root = q.from(OrderDetail.class);
            Join<OrderDetail, Product> join = root.join("productId", JoinType.RIGHT);
            q.multiselect(join.get("id"), join.get("name"), cb.sum(cb.prod(root.get("unitPrice"), root.get("quantity"))));
            q.groupBy(join.get("id"));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }   
    
    public List<Object[]> statsRevenuebyMonth(int year) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);
            Root root = q.from(OrderDetail.class);
            Join<OrderDetail, SaleOrder> join = root.join("orderId", JoinType.RIGHT);
            // Dung Expression de dai dien cho 1 cot (cot month)
            Expression<Integer> month = cb.function("MONTH", Integer.class, join.get("createdDate"));
            Expression<Integer> year2 = cb.function("YEAR", Integer.class, join.get("createdDate"));
                
            q.multiselect(month, cb.sum(cb.prod(root.get("unitPrice"), root.get("quantity"))));
            q.where(cb.equal(year2, year));
                              
            q.groupBy(month);
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    } 
    
    public List<Object[]> statsRevenuebyQuarter(int year) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);
            Root root = q.from(OrderDetail.class);
            Join<OrderDetail, SaleOrder> join = root.join("orderId", JoinType.RIGHT);
            Expression<Integer> quarter = cb.function("QUARTER", Integer.class, join.get("createdDate"));
            Expression<Integer> year2 = cb.function("YEAR", Integer.class, join.get("createdDate"));
                
            q.multiselect(quarter, cb.sum(cb.prod(root.get("unitPrice"), root.get("quantity"))));
            q.where(cb.equal(year2, year));
                              
            q.groupBy(quarter);
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    } 

}
