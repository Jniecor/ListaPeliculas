package es.julionieto.listapeliculas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    
    static int peliculaActual = 0;
        
    @Override
    public void start(Stage stage) {
        
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        HBox hRoot = new HBox();
        hRoot.setAlignment(Pos.CENTER);
        hRoot.setSpacing(10);
        
        TextArea textArea = new TextArea();
        root.getChildren().add(textArea);
        textArea.setEditable(false);
        root.getChildren().add(hRoot);
        
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
        hRoot.getChildren().add(botonGuardar);
        botonGuardar.setOnAction((t) -> {
            try {
                UtilXML.guardarArchivoXML(stage, peliculas);
            } catch(Exception ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Hay un error dentro del botón guardar");
                alert.showAndWait();
            }
        });
        final Button botonImportar = new Button("Importar Archivo");
        hRoot.getChildren().add(botonImportar);
        botonImportar.setOnAction((t) -> {
            try {
                Peliculas peliculasImport = UtilXML.importarArchivoXML(stage);
                System.out.println("Numero de peliculas importadas: " + peliculasImport.getListaPeliculas().size());
                peliculas.unirPeliculas(peliculasImport);
            } catch(Exception ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Hay un error dentro del botón importar");
                alert.showAndWait();
            }
        });
        
        final Button botonAnterior = new Button("Anterior");
        hRoot.getChildren().add(botonAnterior);
        botonAnterior.setOnAction((t) -> {       
            peliculaActual--;
            if (peliculaActual < 0){
                peliculaActual = 0;
            }
            try {
                textArea.setText(peliculas.getListaPeliculas().get(peliculaActual).toString());
            } catch(Exception ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Hay un error dentro del botón anterior");
                alert.showAndWait();
            }
        });
        
        final Button botonSiguiente = new Button("Siguiente");
        hRoot.getChildren().add(botonSiguiente);
        botonSiguiente.setOnAction((t) -> {
            peliculaActual++;
            if (peliculaActual > peliculas.getListaPeliculas().size() - 1){
                peliculaActual = peliculas.getListaPeliculas().size() -1 ;
            }
            try {
                textArea.setText(peliculas.getListaPeliculas().get(peliculaActual).toString());
            } catch(Exception ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Hay un error dentro del botón siguiente");
                alert.showAndWait();
            }
        });
        
        textArea.setText(peliculas.getListaPeliculas().get(peliculaActual).toString());
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}