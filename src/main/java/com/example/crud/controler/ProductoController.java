package com.example.crud.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.interfaceService.IProductoService;
import com.example.crud.modelo.Producto;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ProductoController {
    @Autowired
    private IProductoService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Producto>productos = service.listar();
        model.addAttribute("productos", productos);
        return "producto/listar";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("producto", new Producto());
        return "producto/form";
    }

    @PostMapping("/save")
    public String save(Producto p, Model model){
        service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Producto>producto = service.listarId(id);
        model.addAttribute("producto", producto);
        return "producto/form";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }
}
