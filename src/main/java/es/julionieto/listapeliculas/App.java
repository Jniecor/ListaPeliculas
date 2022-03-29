package es.julionieto.listapeliculas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Pane paneRoot = new Pane();  
        Scene scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();      
        
        Pelicula pelicula = new Pelicula();
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("Los 7");
        pelicula1.setDirector("Tarantino");
        pelicula1.setActores("Will Smith, Jason Statham");
        pelicula1.setDuracion(124);
        pelicula1.setFechaEstreno("12-04-2023");
        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("Los 8");
        pelicula2.setDirector("Tarantino");
        pelicula2.setActores("Will Smith");
        pelicula2.setDuracion(125);
        pelicula2.setFechaEstreno("12-04-2024");
        
        //Creamos la lista y añadimos las peliculas
        ListaPeliculas listaPeliculas = new ListaPeliculas();
        listaPeliculas.getListaPeliculas().add(pelicula1);
        listaPeliculas.getListaPeliculas().add(pelicula2);
        
        final Button botonGuardar = new Button("Guardar Archivo");
        botonGuardar.setLayoutX(100);
        paneRoot.getChildren().add(botonGuardar);
        botonGuardar.setOnAction((t) -> {       
            UtilXML.guardarArchivoXML(stage, listaPeliculas);
        });
        final Button botonAbrir = new Button("Abrir Archivo");
        paneRoot.getChildren().add(botonAbrir);
        botonAbrir.setOnAction((t) -> {       
            UtilXML.abrirArchivoXML(stage, pelicula, listaPeliculas);
        });
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}