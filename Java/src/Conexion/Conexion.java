package Conexion;

import Reproductor.Cancion;
import java.net.*;
import java.io.IOException;
import java.util.ArrayList;
import com.squareup.okhttp.*;

/**
 *
 * @author moramaz
 */
public class Conexion {

    private final OkHttpClient webClient;
    private RequestBody rb;
    public ArrayList<Cancion> actual;

    public Conexion() {
        this.webClient = new OkHttpClient();
        this.actual = new ArrayList<>();
    }

    public String ingresar(String nombre, String contrasena) {
        rb = new FormEncodingBuilder()
                .add("nombre", nombre)
                .add("contrasena", contrasena)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/ingresar");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response response = webClient.newCall(request).execute();
            return response.body().string();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    public void salir() {
        rb = new FormEncodingBuilder()
                .add("txt", "")
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/salir");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void insertar_usuario(String nombre, String contrasena) {
        System.out.println("\tNombre\t\tContraseña");
        System.out.println("\t" + nombre + "\t\t" + contrasena);
        rb = new FormEncodingBuilder()
                .add("nombre", nombre)
                .add("contrasena", contrasena)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/insertar_usuario");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response respuesta = webClient.newCall(request).execute();
            if(!respuesta.body().string().equals("Usuario creado."))
                System.out.println("Nombre de usuario \"" + nombre + "\" ya en uso.");
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void agregar_cancion(String ano, String genero, String artista, String album, String nombre, String path) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
                .add("album", album)
                .add("nombre", nombre)
                .add("path", path)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/agregar_cancion");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
            actual.add(new Cancion(nombre, path, album, artista, ano, genero));
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        System.out.println(nombre + " " + path);
    }

    public void agregar_a_lista(String nombre, String path, String usuario, String contrasena) {
        rb = new FormEncodingBuilder()
                .add("nombre", nombre)
                .add("path", path)
                .add("usuario", usuario)
                .add("contrasena", contrasena)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/agregar_a_lista");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public String eliminar_usuario(String nombre, String contrasena, String usuario, String contrasena2){
        rb = new FormEncodingBuilder()
                .add("nombre", nombre)
                .add("contrasena", contrasena)
                .add("usuario", usuario)
                .add("contrasena2", contrasena2)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_usuario");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response r = webClient.newCall(request).execute();
            return r.body().string();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    public void eliminar_ano(String ano) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_ano");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void eliminar_genero(String genero) {
        rb = new FormEncodingBuilder()
                .add("genero", genero)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_genero");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void eliminar_artistas(String ano, String genero) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_artistas");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void eliminar_artista(String artista) {
        rb = new FormEncodingBuilder()
                .add("artista", artista)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_artista");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void eliminar_album(String ano, String genero, String artista, String album) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
                .add("album", album)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_album");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void eliminar_cancion(String ano, String genero, String artista, String album, String nombre) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
                .add("album", album)
                .add("nombre", nombre)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_cancion");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void graficar_matriz(String path) {
        rb = new FormEncodingBuilder()
                .add("path", path)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/graficar_matriz");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void graficar_arbol_b(String ano, String genero, String path) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("path", path)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/graficar_arbol_b");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void graficar_abb(String ano, String genero, String artista, String path) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
                .add("path", path)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/graficar_abb");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void graficar_lista_circular(String ano, String genero, String artista, String album, String path) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
                .add("album", album)
                .add("path", path)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/graficar_lista_circular");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void graficar_lista_doble(String path) {
        rb = new FormEncodingBuilder()
                .add("path", path)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/graficar_lista_doble");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void graficar_cola_circular_usuario(String path, String usuario, String contrasena) {
        rb = new FormEncodingBuilder()
                .add("path", path)
                .add("usuario", usuario)
                .add("contrasena", contrasena)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/graficar_cola_circular_usuario");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public String canciones_artista(String artista){
        rb = new FormEncodingBuilder()
                .add("artista", artista)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/canciones_artista");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response response = webClient.newCall(request).execute();
            return response.body().string();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    public String canciones_album(String ano, String genero, String artista, String album){
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
                .add("album", album)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/canciones_album");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response response = webClient.newCall(request).execute();
            return response.body().string();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    public String canciones_genero(String genero){
        rb = new FormEncodingBuilder()
                .add("genero", genero)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/canciones_genero");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response response = webClient.newCall(request).execute();
            return response.body().string();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    public String canciones_ano(String ano){
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/canciones_ano");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response response = webClient.newCall(request).execute();
            return response.body().string();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    public String canciones_usuario(String usuario, String contrasena){
        rb = new FormEncodingBuilder()
                .add("usuario", "usuario")
                .add("contrasena", "contrasena")
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/canciones_usuario");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response response = webClient.newCall(request).execute();
            return response.body().string();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    public void canciones_shuffle(){
        rb = new FormEncodingBuilder()
                .add("txt", "")
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/canciones_shuffle");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
