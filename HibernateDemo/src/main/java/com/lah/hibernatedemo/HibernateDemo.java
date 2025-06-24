/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lah.hibernatedemo;

import com.lah.repository.impl.CategoryRepositoryImpl;
import com.lah.repository.impl.ProductRepositoryImpl;

/**
 *
 * @author hao
 */
public class HibernateDemo {

    public static void main(String[] args) {
        ProductRepositoryImpl s = new ProductRepositoryImpl();
        s.getProducts(1).forEach(p -> System.out.println(p.getName()));
    }
}
