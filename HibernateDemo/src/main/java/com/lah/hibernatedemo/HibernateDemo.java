/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.lah.hibernatedemo;

import com.lah.repository.impl.CategoryRepositoryImpl;
import com.lah.repository.impl.ProductRepositoryImpl;
import com.lah.repository.impl.StatsRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hao
 */
public class HibernateDemo {

    public static void main(String[] args) {
        StatsRepositoryImpl stats = new StatsRepositoryImpl();
        stats.statsRevenuebyMonth(2020).forEach(s -> System.out.printf("Thang %d - %d\n",s[0], s[1]));
        System.out.println("===================================");
        StatsRepositoryImpl stats2 = new StatsRepositoryImpl();
        stats2.statsRevenuebyQuarter(2020).forEach(s -> System.out.printf("Quy %d - %d\n",s[0], s[1]));
        
//        Map<String, String> params = new HashMap<>();
////        params.put("kw", "ipad");
////        params.put("categoryId", "2");
//        params.put("page", "1");
//        params.put("sort", "price");

//        ProductRepositoryImpl s = new ProductRepositoryImpl();
//        s.getProducts(params).forEach(p -> System.out.printf("%d - %s: %d\n", p.getId(), p.getName(), p.getPrice()));

//        StatsRepositoryImpl stats = new StatsRepositoryImpl();
//        stats.statsRevenuebyProduct().forEach(s -> System.out.printf("%d - %s - %d\n",s[0], s[1], s[2]));
        

//        ProductRepositoryImpl s2 = new ProductRepositoryImpl();
//        s2.getProductsFromName("ipad").forEach(p -> System.out.println(p.getName()));
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCates().forEach(c -> System.out.println(c.getName()));
    }
}
