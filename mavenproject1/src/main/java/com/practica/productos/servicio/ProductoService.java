/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.productos.servicio;
import com.practica.productos.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author umg
 */
public class ProductoService {
    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto p) {
        productos.add(p);
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }
} 

