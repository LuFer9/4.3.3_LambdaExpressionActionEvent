/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpressionactionevent4.pkg3.pkg3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JLabel;

/**
 *
 * @author Luis
 */
public class LambdaExpressionActionEvent433 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Elgimos el layout
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER); //centramos todos los elementos dentro del pane
        root.setHgap(5); //separacion entre columnas
        root.setVgap(5); //separacion entre filas
        //root.setPadding(new Insets(25, 25, 25, 25)); añade padding top, right, bottom, left; empty por defecto
        
        //añadimos el layout y la escena
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Lambda Expression");
        primaryStage.setScene(scene);
        
        //Añadimos el label y los text field de cada input
        Label label_1 = new Label("Anual Interest rate: ");
        TextField txt_1 = new TextField();
        
        Label label_2 = new Label("Number of years: ");
        TextField txt_2 = new TextField();
        
        Label label_3 = new Label("Loan Amount: ");
        TextField txt_3 = new TextField();
        
        Label label_4 = new Label("Monthly payment: ");
        TextField txt_4 = new TextField();
        
        Label label_5 = new Label("Total payment: ");
        TextField txt_5 = new TextField();
        
        //txt_1.setPrefColumnCount(14); preguntar
        
        
        //primer numero son las columnas y el segundo numero las filas
        root.add(label_1, 0, 1);
        root.add(txt_1, 1, 1);
        
        root.add(label_2, 0, 2);
        root.add(txt_2, 1, 2);
        
        root.add(label_3, 0, 3);
        root.add(txt_3, 1, 3);
        
        root.add(label_4, 0, 4);
        root.add(txt_4, 1, 4);
        
        root.add(label_5, 0, 5);
        root.add(txt_5, 1, 5);
            
        
        
        Button btn = new Button();
        btn.setText("Calculate");
        
        
        //expresion lambda para gestionar el evento
        btn.setOnAction(e -> {
            
            Double interes = Double.parseDouble(txt_1.getText());
            Double anos = Double.parseDouble(txt_2.getText());
            Double hipoteca = Double.parseDouble(txt_3.getText());
            double r = calcularR(interes);
            double totalMensual = calcularPrestamo(hipoteca, anos, r);
            double total = (totalMensual * 12) * anos;
            
            txt_4.setText("€" + Double.toString(totalMensual));
            txt_5.setText("€" + Double.toString(total));
            
            
           
        });
        
        root.add(btn, 1, 6);
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    //Calculamos la cuota mensual
    public double calcularPrestamo(double hipoteca, double anos, double r){
        
        double cuotaMensual;
        
            cuotaMensual = (hipoteca * r) / (1 -  Math.pow(1 + r, -12 * anos));
        
        
        return cuotaMensual;
    }
    
    
    //calculamos R
    public double calcularR(double interes){
        
        double r;
            
            r = interes / (100*12);
            
        
        return r;
    }
    
}
