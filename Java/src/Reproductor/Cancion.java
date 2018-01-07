package Reproductor;

/**
 *
 * @author Usuario
 */
public class Cancion {
    private String nombre, path, album, artista, ano, genero;

    public Cancion(String nombre, String path, String album, String artista, String ano, String genero) {
        this.nombre = nombre;
        this.path = path;
        this.album = album;
        this.artista = artista;
        this.ano = ano;
        this.genero = genero;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public String getAlbum() {
        return album;
    }
    
    public void setAlbum(String album) {
        this.album = album;
    }
    
    public String getArtista() {
        return artista;
    }
    
    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    public String getAno() {
        return ano;
    }
    
    public void setAno(String ano) {
        this.ano = ano;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
