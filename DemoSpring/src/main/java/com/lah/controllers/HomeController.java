/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lah.controllers;

//import jakarta.enterprise.inject.Model;
//import com.mysql.cj.Session;
import com.lah.pojo.Category;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
@Transactional
public class HomeController {
    @Autowired
    private LocalSessionFactoryBean fatory;
    

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to our Website!!!");
        Session s = this.fatory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Category", Category.class);
        model.addAttribute("categories", q.getResultList());
        return "index";
    }
}
