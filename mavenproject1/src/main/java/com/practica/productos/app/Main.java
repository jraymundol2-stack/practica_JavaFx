/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.productos.app;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos; 
public class Main extends Application {

    @Override
public void start(Stage stage) {
    // Componentes de la interfaz
    TextField campo = new TextField();
    campo.setPromptText("Escribe un producto...");
    
    Button boton = new Button("Mostrar");
    Label label = new Label("Aquí aparecerá el texto");

    // Lógica: Al presionar el botón, el texto del campo pasa al label
    boton.setOnAction(e -> {
        label.setText("Producto: " + campo.getText());
    });

    // Diseño: Los ponemos uno debajo del otro con 10px de espacio
    VBox layout = new VBox(10, campo, boton, label);
    layout.setStyle("-fx-padding: 20;"); // Margen interno

    Scene scene = new Scene(layout, 300, 250);
    stage.setTitle("Práctica CRUD");
    stage.setScene(scene);
    stage.show();
}
