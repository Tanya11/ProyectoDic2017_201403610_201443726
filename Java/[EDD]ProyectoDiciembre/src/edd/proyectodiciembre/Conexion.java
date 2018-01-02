package edd.proyectodiciembre;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author moramaz
 */
public class Conexion {

    private final OkHttpClient webClient;
    private RequestBody rb;

    public Conexion() {
        this.webClient = new OkHttpClient();
    }

    public void ingresar(String nombre, String contrasena) { ////////////////////LOGIN
        rb = new FormEncodingBuilder()
                .add("nombre", nombre)
                .add("contrasena", contrasena)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/ingresar");
            Request request = new Request.Builder().url(url).post(rb).build();
            webClient.newCall(request).execute();
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
            webClient.newCall(request).execute();
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
            Response response = webClient.newCall(request).execute();
            String response_string = response.body().string();
            if (response_string.equals("-1996")) {
                return;
            }

        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void eliminar_artista(String ano, String genero, String artista) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_artista");
            Request request = new Request.Builder().url(url).post(rb).build();
            Response response = webClient.newCall(request).execute();
            String response_string = response.body().string();
            if (response_string.equals("-1996")) {
            }

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
            Response response = webClient.newCall(request).execute();
            String response_string = response.body().string();
            if (response_string.equals("-1996")) {
               
            } else {
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public String eliminar_cancion(String ano, String genero, String artista, String album, String nombre, String path) {
        rb = new FormEncodingBuilder()
                .add("ano", ano)
                .add("genero", genero)
                .add("artista", artista)
                .add("album", album)
                .add("nombre", nombre)
                .add("path", path)
                .build();
        try {
            URL url = new URL("http://0.0.0.0:5000/eliminar_cancion");
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

}
