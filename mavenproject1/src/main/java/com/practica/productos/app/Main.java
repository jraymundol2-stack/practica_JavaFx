/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.productos.app;

import com.practica.productos.modelo.Producto;
import com.practica.productos.servicio.ProductoService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    // ESTA LÍNEA ES VITAL: Es la variable que te marcaba error
    private ProductoService servicio = new ProductoService();

    @Override
    public void start(Stage stage) {
        TextField campo = new TextField();
        campo.setPromptText("Nombre del producto...");

        Button btnAgregar = new Button("Agregar");
        Button btnEliminar = new Button("Eliminar");
        Button btnBuscar = new Button("Buscar");

        TextArea area = new TextArea();
        area.setEditable(false);

        btnAgregar.setOnAction(e -> {
            try {
                servicio.agregar(new Producto(campo.getText()));
                actualizarLista(area);
                campo.clear();
            } catch (Exception ex) {
                area.setText("Error: " + ex.getMessage());
            }
        });

        btnEliminar.setOnAction(e -> {
            servicio.eliminar(campo.getText());
            actualizarLista(area);
            campo.clear();
        });

        btnBuscar.setOnAction(e -> {
            Producto p = servicio.buscar(campo.getText());
            if (p != null) {
                area.setText("Encontrado: " + p.getNombre());
            } else {
                area.setText("No se encontró.");
            }
        });

        HBox filaBotones = new HBox(10, btnAgregar, btnEliminar, btnBuscar);
        filaBotones.setAlignment(Pos.CENTER);

        VBox layout = new VBox(15, new Label("Gestión de Productos"), campo, filaBotones, area);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(layout, 450, 450);
        stage.setTitle("CRUD Completo");
        stage.setScene(scene);
        stage.show();
    }

    // Este es el método que te daba error. Ahora "servicio" ya existe arriba.
    private void actualizarLista(TextArea area) {
        StringBuilder sb = new StringBuilder("--- LISTA ACTUAL ---\n");
        for (Producto p : servicio.listar()) {
            sb.append("- ").append(p.getNombre()).append("\n");
        }
        area.setText(sb.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}