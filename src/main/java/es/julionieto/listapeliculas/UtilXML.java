package es.julionieto.listapeliculas;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    
    public static void guardarArchivoXML(Stage stage, Peliculas peliculas){
    
        JAXBContext contexto;
         try {
            FileChooser fileChooserListaPeliculasExport = new FileChooser();
            fileChooserListaPeliculasExport.setTitle("Guardar Archivo");
            File fileListaPeliculasExport = fileChooserListaPeliculasExport.showSaveDialog(stage);
            contexto = JAXBContext.newInstance(Peliculas.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(peliculas, System.out);
            marshaller.marshal(peliculas, fileListaPeliculasExport);
         } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();
         }
    
    }
    
    public static Peliculas importarArchivoXML(Stage stage){
    
        try {
            JAXBContext context = JAXBContext.newInstance( Peliculas.class );
            Peliculas peliculas;
            FileChooser fileChooserListaPeliculasImport = new FileChooser();
            fileChooserListaPeliculasImport.setTitle("Importar Archivo");
            File fileListaPeliculasImport = fileChooserListaPeliculasImport.showOpenDialog(stage);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            peliculas = (Peliculas)unmarshaller.unmarshal(fileListaPeliculasImport);
            for (int i = 0; i < peliculas.getListaPeliculas().size(); i++){
                System.out.println(peliculas.getListaPeliculas().get(0));
            }
            return peliculas;           
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }    
}
