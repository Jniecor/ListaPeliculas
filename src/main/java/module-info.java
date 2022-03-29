module es.julionieto.listapeliculas {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.julionieto.listapeliculas;
    opens es.julionieto.listapeliculas to java.xml.bind;
}
