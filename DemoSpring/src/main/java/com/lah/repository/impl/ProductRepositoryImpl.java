///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.lah.repository.impl;
//
//import com.lah.hibernatedemo.HibernateUtils;
//import com.lah.pojo.Category;
//import com.lah.pojo.Product;
//import jakarta.persistence.Query;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import org.hibernate.Session;
//
///**
// *
// * @author hao
// */
//public class ProductRepositoryImpl {
//
//    private static final int PAGE_SIZE = 6;
//
//    public List<Product> getProducts(Map<String, String> params) {
//        try (Session s = HibernateUtils.getFactory().openSession()) {
//            CriteriaBuilder cb = s.getCriteriaBuilder();
//            CriteriaQuery<Product> q = cb.createQuery(Product.class);
//            Root root = q.from(Product.class);
//            q.select(root);
//
//            if (params != null) {
//                // Dung cho TH co nhieu where trong truy van
//                List<Predicate> predicate = new ArrayList<>();
//
//                String kw = params.get("kw");
//                if (kw != null && !kw.isEmpty()) {
//                    predicate.add(cb.like(root.get("name"), String.format("%%%s%%", kw)));
//                }
//
//                String fromPrice = params.get("fromPrice");
//                if (fromPrice != null && !fromPrice.isEmpty()) {
//                    predicate.add(cb.greaterThanOrEqualTo(root.get("price"), fromPrice));
//                }
//
//                String toPrice = params.get("toPrice");
//                if (toPrice != null && !toPrice.isEmpty()) {
//                    predicate.add(cb.lessThanOrEqualTo(root.get("price"), toPrice));
//                }
//
//                String cateId = params.get("categoryId");
//                if (cateId != null && !cateId.isEmpty()) {
//                    predicate.add(cb.equal(root.get("categoryId").get("id"), cateId));
//                }
//                // Chuyen thanh mang cac ptu roi rac
//                if (!predicate.isEmpty()) {
//                    q.where(predicate.toArray(Predicate[]::new));
//                }
//
//                String sort = params.get("sort");
//                if (sort != null && !sort.isEmpty()) {
//                    q.orderBy(cb.asc(root.get(sort)));
//                }
//            }
//
//            Query query = s.createQuery(q);
//
//            if (params != null) {
//                int page = Integer.parseInt(params.getOrDefault("page", "1"));
//                int start = (page - 1) * PAGE_SIZE;
//                query.setMaxResults(PAGE_SIZE);
//                query.setFirstResult(start);
//            }
//
//            return query.getResultList();
//        }
//    }
//    
//    public Product getProductById(int id) {
//        try (Session s = HibernateUtils.getFactory().openSession()) {
//            return s.get(Product.class, id);
//        }
//    }
//    
//    public Product addOrUpdate(Product p) {
//        try (Session s = HibernateUtils.getFactory().openSession()) {
//            if (p.getId() == null) {
//                s.persist(p);
//            } else {
//                s.merge(p);
//            }
//            
//            // Lam moi(truy van lai) de cap nhat du lieu moi nhat cua p truoc khi tra ve
//            s.refresh(p);
//            return p;
//        }
//    }
//    //    public List<Product> getProductsFromCateId(int cateId) {
////        try (Session s = HibernateUtils.getFactory().openSession()) {
////            CriteriaBuilder cb = s.getCriteriaBuilder();
////            CriteriaQuery<Product> q = cb.createQuery(Product.class);
////            Root root = q.from(Product.class);
////            q.select(root).where(cb.equal(root.get("category").get("id"), cateId));
////
////            Query query = s.createQuery(q);
////            query.setMaxResults(10);
////            query.setFirstResult(0);
////
////            return query.getResultList();
////        }
////    }
//}
