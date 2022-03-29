package es.julionieto.listapeliculas;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    
    public static void guardarArchivoXML(Stage stage, ListaPeliculas listaPeliculas){
    
        JAXBContext contexto;
         try {
            FileChooser fileChooserListaPeliculas = new FileChooser();
            fileChooserListaPeliculas.setTitle("Guardar Archivo");
            File fileListaPeliculas = fileChooserListaPeliculas.showSaveDialog(stage);
            //File fileListaPeliculas = new File("ListaPeliculas.xml");
            contexto = JAXBContext.newInstance(ListaPeliculas.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(listaPeliculas, System.out);
            marshaller.marshal(listaPeliculas, fileListaPeliculas);
         } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();
         }
    
    }
    
    public static void abrirArchivoXML(Stage stage, Pelicula pelicula){
    
        try {
            JAXBContext context = JAXBContext.newInstance( Pelicula.class );
            FileChooser fileChooserListaPeliculas = new FileChooser();
            fileChooserListaPeliculas.setTitle("Abrir Archivo");
            File fileListaPeliculas = fileChooserListaPeliculas.showOpenDialog(stage);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ListaPeliculas listaPeliculas = (ListaPeliculas)unmarshaller.unmarshal(
                new File("src/Pelicula.xml") );
            System.out.println(pelicula.getTitulo());
            System.out.println(pelicula.getDirector());
            System.out.println(pelicula.getActores());
            System.out.println(pelicula.getDuracion());
            System.out.println(pelicula.getFechaEstreno());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    
    }
    
}