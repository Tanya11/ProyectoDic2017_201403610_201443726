package ListaDoble;

public class NodoDoble {
    
    private int AniodePublicacion, nodeCanciones;
    private String Nombre;
    private NodoDoble Anterior;
    private NodoDoble Siguiente;

    public NodoDoble(int AniodePublicacion, int nodeCanciones, String Nombre) {
        this.AniodePublicacion = AniodePublicacion;
        this.nodeCanciones = nodeCanciones;
        this.Nombre = Nombre;
        this.Anterior = null;
        this.Siguiente = null;
    }
    
    public int getAniodePublicacion() {
        return AniodePublicacion;
    }
    
    public void setAniodePublicacion(int AniodePublicacion) {
        this.AniodePublicacion = AniodePublicacion;
    }
    
    public int getNodeCanciones() {
        return nodeCanciones;
    }
    
    public void setNodeCanciones(int nodeCanciones) {
        this.nodeCanciones = nodeCanciones;
    }
    
    public String getNombre() {
        return Nombre;
    }
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public NodoDoble getAnterior() {
        return Anterior;
    }
    
    public void setAnterior(NodoDoble Anterior) {
        this.Anterior = Anterior;
    }
    
    public NodoDoble getSiguiente() {
        return Siguiente;
    }
    
    public void setSiguiente(NodoDoble Siguiente) {
        this.Siguiente = Siguiente;
    }
}