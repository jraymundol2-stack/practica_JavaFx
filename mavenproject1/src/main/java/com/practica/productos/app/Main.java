/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.productos.app;



import com.practica.productos.modelo.Producto;
import com.practica.productos.servicio.ProductoService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    // Instanciamos el servicio para usarlo en toda la clase
    private ProductoService servicio = new ProductoService();

    @Override
    public void start(Stage stage) {
        TextField campo = new TextField();
        campo.setPromptText("Nombre del producto...");
        
        Button boton = new Button("Guardar Producto");
        
        // Usamos TextArea para que se vea como una lista real
        TextArea areaLista = new TextArea();
        areaLista.setEditable(false); 
        areaLista.setPromptText("Lista de productos vacía...");

        boton.setOnAction(e -> {
            try {
                // Creamos el producto y lo agregamos al servicio
                Producto nuevo = new Producto(campo.getText());
                servicio.agregar(nuevo);
                
                // Actualizamos el área de texto con todos los productos
                StringBuilder sb = new StringBuilder();
                for (Producto p : servicio.listar()) {
                    sb.append("- ").append(p.getNombre()).append("\n");
                }
                areaLista.setText(sb.toString());
                campo.clear(); // Limpiamos el campo después de guardar
                
            } catch (Exception ex) {
                // Si hay error (nombre vacío), lo mostramos en una alerta
                areaLista.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10, new Label("Ingrese Producto:"), campo, boton, areaLista);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 400, 400);
        stage.setTitle("CRUD de Productos - JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}