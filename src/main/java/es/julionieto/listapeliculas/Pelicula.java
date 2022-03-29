package es.julionieto.listapeliculas;

public class Pelicula {
    
    private String titulo;
    private String director;
    private String actores;
    private int duracion;
    private String fechaEstreno;    
    
    public Pelicula(){
    
    }
    
    public String getTitulo(){
    
        return titulo;
        
    }
    
    public void setTitulo(String titulo){
    
        this.titulo = titulo.toUpperCase();
    
    }
    
    public String getDirector(){
    
        return director;
    
    }
    
    public void setDirector(String director){
    
        this.director = director.toUpperCase();
    
    }
    
    public String getActores(){
    
        return actores;
    
    }
    
    public void setActores(String actores){
    
        this.actores = actores.toUpperCase();
    
    }
    
    public int getDuracion(){
    
        return duracion;
    
    }
    
    public void setDuracion(int duracion){
    
        this.duracion = duracion;
    
    }
    
    public String getFechaEstreno(){
    
        return fechaEstreno;
    
    }
    
    public void setFechaEstreno(String fechaEstreno){
    
        this.fechaEstreno = fechaEstreno;
    
    }
    
    @Override
    public String toString(){
    
        String r = "";
        r += "Titulo: " + titulo + "\n";
        r += "Director: " + director + "\n";
        r += "Actores: " + actores + "\n";
        r += "Duracion : " + duracion + "\n";
        r += "Fecha de estreno: " + fechaEstreno + "\n";
        return r;
    
    }
    
}

