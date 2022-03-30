package es.julionieto.listapeliculas;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Peliculas {
    
    private ArrayList<Pelicula> listaPeliculas = new <Pelicula>ArrayList();
    
    public ArrayList<Pelicula> getListaPeliculas(){
    
        return listaPeliculas;
    
    }
    
    @XmlElement(name = "pelicula")
    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas){
    
        this.listaPeliculas = listaPeliculas;
    
    }
    
    public void unirPeliculas(){

//        for (int i = 0; i < peliculasImport.getListaPeliculas().size(); i++){
//        
//            
//            
//        }

    }
    
}
