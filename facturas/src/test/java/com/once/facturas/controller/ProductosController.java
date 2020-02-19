package com.once.facturas.controller;

import com.once.facturas.model.Producto;
import com.once.facturas.model.RepositoryProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * MainControler ProductosController
 * 
 * etiqueta para crear un controller
 * 
 */

 @Controller
 public class ProductosController {


     @Autowired

RepositoryProducto repositoryproducto ;


     
     @GetMapping( "/producto")
     @ResponseBody
     public ModelAndView clientePost(){

        ModelAndView modelAndView=new  ModelAndView ("producto");
        modelAndView.addObject("mensaje", "");
        return modelAndView;
    }
        
         
         @PostMapping("/producto")
         public ModelAndView clientePost(
             @RequestParam("descripcion") String descripcion,
             @RequestParam("fabricante") String fabricante,
             @RequestParam("precio") Float precio
         ){
             ModelAndView modelAndView=new ModelAndView("producto");
             Producto producto=new Producto(descripcion, fabricante, precio);
       
             repositoryproducto.save(producto);
             
             return modelAndView;
         }
    
    
        
         // creamos el endpoint /contar - vamos a contar el numero de productos que tenemos
    
         
    
         @GetMapping("/count")
         @ResponseBody
         public String countProducto() {
    
           return "Tengo " + String.valueOf(repositoryproducto.count()) + " productos " ;
    
         }
    
    }   
    







 
