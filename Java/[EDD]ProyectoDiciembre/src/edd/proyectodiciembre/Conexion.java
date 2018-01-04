package edd.proyectodiciembre;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public String ingresar(String nombre, String contrasena) { ////////////////////LOGIN
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
            ex.printStackTrace();
        }
        return null;
    }

    public void Logout() { ////////////////////////////////////// LOGOUT
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

    public void insertar_usuario(String nombre, String contrasena) { //recibe nobmre y contraseña: AGREGAR USUARIO
        rb = new FormEncodingBuilder()
                .add("nombre", nombre)
                .add("contrasena", contrasena)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/insertar_usuario");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response respuesta = webClient.newCall(request).execute();
            if(!respuesta.body().string().equals("Usuario creado.")){
                System.out.println("Nombre de usuario \"" + nombre + "\" ya en uso.");
            }
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
    }

    public void agregar_a_lista(String nombre, String path) {
        rb = new FormEncodingBuilder()
                .add("nombre", nombre)
                .add("path", path)
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

    public void eliminar_usuario(String nombre, String contrasena){
        rb = new FormEncodingBuilder()
                .add("nombre", nombre)
                .add("contrasena", contrasena)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_usuario");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
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

    public void graficar_matriz() {
        rb = new FormEncodingBuilder()
                .add("txt", "")
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

    public void graficar_arbol_b(String ano, String genero) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
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

    public void graficar_abb(String ano, String genero, String artista) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
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
    }//

    public void graficar_lista_circular(String ano, String genero, String artista, String album) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
                .add("album", album)
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

    public void graficar_lista_doble() {
        rb = new FormEncodingBuilder()
                .add("txt", "")
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
    }//graficar_lista_circular_usuario

    public void graficar_lista_circular_usuario() {
        rb = new FormEncodingBuilder()
                .add("txt", "")
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/graficar_lista_circular_usuario");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
