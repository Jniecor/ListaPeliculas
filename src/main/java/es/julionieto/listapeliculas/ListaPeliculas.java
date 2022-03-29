package es.julionieto.listapeliculas;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaPeliculas {
    
    private ArrayList<Pelicula> listaPeliculas = new <Pelicula>ArrayList();
    
    public ArrayList<Pelicula> getListaPeliculas(){
    
        return listaPeliculas;
    
    }
    
    @XmlElement(name = "pelicula")
    public void setListaPeliculas(ArrayList<Pelicula> listaListaPeliculas){
    
        this.listaPeliculas = listaPeliculas;
    
    }
    
}
