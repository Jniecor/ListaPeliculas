package es.julionieto.listapeliculas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage stage) {
        
        HBox root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();      
        
        Pelicula pelicula = new Pelicula();
        Pelicula pelicula0 = new Pelicula();
        pelicula0.setTitulo("Los 7");
        pelicula0.setDirector("Tarantino");
        pelicula0.setActores("Will Smith, Jason Statham");
        pelicula0.setDuracion(124);
        pelicula0.setFechaEstreno("12-04-2023");
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("Los 8");
        pelicula1.setDirector("Tarantino");
        pelicula1.setActores("Will Smith");
        pelicula1.setDuracion(125);
        pelicula1.setFechaEstreno("12-04-2024");
        
        //Creamos la lista y añadimos las peliculas
        Peliculas peliculas = new Peliculas();
        peliculas.getListaPeliculas().add(pelicula0);
        peliculas.getListaPeliculas().add(pelicula1);
        
        final Button botonGuardar = new Button("Guardar Archivo");
        root.getChildren().add(botonGuardar);
        botonGuardar.setOnAction((t) -> {       
            UtilXML.guardarArchivoXML(stage, peliculas);
        });
        final Button botonImportar = new Button("Importar Archivo");
        root.getChildren().add(botonImportar);
        botonImportar.setOnAction((t) -> {       
            Peliculas peliculasImport = UtilXML.importarArchivoXML(stage);
            System.out.println("Numero de peliculas importadas: " + peliculasImport.getListaPeliculas().size());
        });
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}