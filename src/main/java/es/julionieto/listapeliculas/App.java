package es.julionieto.listapeliculas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    
    static int peliculaActual = 0;
        
    @Override
    public void start(Stage stage) {
        
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);
        root.setStyle("-fx-background-image: url('/images/Fondo.jpg');");
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Procesamiento XML");
        stage.show();
        HBox hRoot = new HBox();
        hRoot.setAlignment(Pos.CENTER);
        hRoot.setSpacing(50);
        HBox h2Root = new HBox();
        h2Root.setAlignment(Pos.CENTER);
        h2Root.setSpacing(50);
        
        Label labelTitulo = new Label();
        labelTitulo.setFont((new Font("Liberation Serif", 22)));
        labelTitulo.setStyle("-fx-font-weight: bold");
        root.getChildren().add(labelTitulo);
        Label labelXML = new Label();
        labelXML.setFont((new Font("Liberation Serif", 18)));
        root.getChildren().add(hRoot);
        root.getChildren().add(h2Root);
        
//        Pelicula pelicula = new Pelicula();
//        Pelicula pelicula0 = new Pelicula();
//        pelicula0.setTitulo("Los 7");
//        pelicula0.setDirector("Tarantino");
//        pelicula0.setActores("Will Smith, Jason Statham");
//        pelicula0.setDuracion(124);
//        pelicula0.setFechaEstreno("12-04-2023");
//        Pelicula pelicula1 = new Pelicula();
//        pelicula1.setTitulo("Los 8");
//        pelicula1.setDirector("Tarantino");
//        pelicula1.setActores("Will Smith");
//        pelicula1.setDuracion(125);
//        pelicula1.setFechaEstreno("12-04-2024");
        
        //Creamos la lista y añadimos las peliculas
        Peliculas peliculas = new Peliculas();
//        peliculas.getListaPeliculas().add(pelicula0);
//        peliculas.getListaPeliculas().add(pelicula1);
        
        final Button botonGuardar = new Button("Guardar Archivo");
        h2Root.getChildren().add(botonGuardar);
        botonGuardar.setOnAction((t) -> {
            try {
                UtilXML.guardarArchivoXML(stage, peliculas);
            } catch(Exception ex){
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Ha habido un error con el botón guardar");
                alert.showAndWait();
            }
        });
        final Button botonImportar = new Button("Importar Archivo");
        h2Root.getChildren().add(botonImportar);
        botonImportar.setOnAction((t) -> {
            try {
                Peliculas peliculasImport = UtilXML.importarArchivoXML(stage);
                System.out.println("Numero de peliculas importadas: " + peliculasImport.getListaPeliculas().size());
                peliculas.unirPeliculas(peliculasImport);
                labelXML.setText(peliculas.getListaPeliculas().get(peliculaActual).toString());
            } catch(Exception ex){
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Ha habido un error con el botón importar");
                alert.showAndWait();
            }
        });
        
        final Button botonAnterior = new Button("Anterior");
        hRoot.getChildren().add(botonAnterior);
        hRoot.getChildren().add(labelXML);
        botonAnterior.setOnAction((t) -> {       
            peliculaActual--;
            if (peliculaActual < 0){
                peliculaActual = 0;
            }
            try {
                labelXML.setText(peliculas.getListaPeliculas().get(peliculaActual).toString());
                labelTitulo.setText("Procesamiento XML. Usted está en la "+(peliculaActual+1)+" posición.");
            } catch(Exception ex){
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Ha habido un error con el botón anterior");
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
                labelXML.setText(peliculas.getListaPeliculas().get(peliculaActual).toString());
                labelTitulo.setText("Procesamiento XML. Usted está en la "+(peliculaActual+1)+" posición.");

            } catch(Exception ex){
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Ha habido un error con el botón siguiente");
                alert.showAndWait();
            }
        });
        
//        labelXML.setText(peliculas.getListaPeliculas().get(peliculaActual).toString());
        labelTitulo.setText("Procesamiento XML. Usted está en la "+(peliculaActual+1)+" posición.");
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}