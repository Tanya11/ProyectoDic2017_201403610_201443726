package ListaDoble;

public class ListaDoble {

    private NodoDoble Cabeza, Auxiliar;

    public ListaDoble() {
        this.Cabeza = null;
        this.Auxiliar = null;
    }

    public void Insertar(int AniodePublicacion, int nodeCanciones, String Nombre) {
        Auxiliar = new NodoDoble(AniodePublicacion, nodeCanciones, Nombre);
        Auxiliar.setSiguiente(Cabeza);
        if (getCabeza() != null) {
            getCabeza().setAnterior(Auxiliar);
        }
        setCabeza(Auxiliar);
    }

    public NodoDoble Buscar(int anio) {
        try {
            Auxiliar = getCabeza();
            while (Auxiliar.getAniodePublicacion() != anio) {
                this.Auxiliar = Auxiliar.getSiguiente();
            }
        } catch (Exception e) {
        }
        if (Auxiliar == null) {
            System.out.println("No se ha encontrado el dato.");
        }
        return Auxiliar;
    }

    public NodoDoble Eliminar(int anio) {
        Auxiliar = Buscar(anio);
        try {
            Auxiliar.getAnterior().setSiguiente(Auxiliar.getSiguiente());
            Auxiliar.getSiguiente().setAnterior(Auxiliar.getAnterior());
        } catch (Exception e) {
        }
        return Auxiliar;
    }

    public NodoDoble getCabeza() {
        return Cabeza;
    }

    public void setCabeza(NodoDoble Cabeza) {
        this.Cabeza = Cabeza;
    }
}
