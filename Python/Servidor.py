__author__ = "201403610 - 201443726"

from flask import Flask, request, Response
import subprocess, Matriz, ArbolB, ArbolBinario, ListaCanciones, ListaDoble

app = Flask("ProyectoDic2017")

# ESTRUCTURAS
repertorio = Matriz.Matriz() # Todo
artistas = ArbolB.ArbolB(5) # auxiliar
albumes = ArbolBinario.ArbolBinario() # auxiliar
canciones = ListaCanciones.ListaCanciones() # auxiliar
usuarios = ListaDoble.ListaDoble() # Usuarios

# USUARIO EN EL SISTEMA
logueado = None

# RAIZ
@app.route('/', methods = ['GET'])
def init():
	return "metodos: /ingresar, /salir, /insertar_usuario, /agregar_cancion, /eliminar_ano, /eliminar_genero, /eliminar_artistas, /eliminar_artista, /eliminar_album, eliminar_cancion..."

# LOGIN
@app.route('/ingresar', methods = ['POST'])
def ingresar():
	nombre = str(request.form['nombre'])
	contrasena = str(request.form['contrasena'])
	lg = usuarios.buscar(nombre, contrasena)
	if lg == None:
		return "Credenciales incorrectas."
	logueado = lg.Usuario
	return "Ingreso exitoso."

# LOGOUT
@app.route('/salir', methods = ['POST'])
def salir():
	logueado = None
	return ""

# INSERTAR
@app.route('/insertar_usuario', methods = ['POST'])
def insertar_usuario():
	nombre = str(request.form['nombre'])
	contrasena = str(request.form['contrasena'])
	if usuarios.insertar(nombre, contrasena):
		return "Usuario creado."
	return "Nombre de usuario ya en uso."

@app.route('/agregar_cancion', methods=['POST'])
def agregar_cancion():
	ano = str(request.form['ano'])
	genero = str(request.form['genero'])
	artista = str(request.form['artista'])
	album = str(request.form['album'])
	nombre = str(request.form['nombre'])
	path = str(request.form['path'])
	ab = repertorio.obtenerArtistas(ano, genero)
	if (ab == None): # No existe el nodo con ese ano y genero: se inserta desde la matriz
		canciones = ListaCanciones.ListaCanciones()
		canciones.insertar(nombre, path)
		albumes = ArbolBinario.ArbolBinario()
		albumes.insertar(album, canciones)
		artistas = ArbolB.ArbolB(5)
		artistas.insertar(artista, albumes)
		repertorio.insertar(ano, genero, artistas)
	else: # Si existe el nodo con ese ano y genero
		indice = 0
		pagina = None
		pagina, indice = ab.artistas.buscar(ab.artistas.raiz, artista, indice)
		if pagina == None: # No existe el nodo con ese artista: se inserta desde el arbol b
			canciones = ListaCanciones.ListaCanciones()
			canciones.insertar(nombre, path)
			albumes = ArbolBinario.ArbolBinario()
			albumes.insertar(album, canciones)
			ab.insertar(artista, albumes)
		else: # Si existe el nodo con ese artista
			abb = pagina.nodos[indice].albumes
			lc = abb.buscar(album)
			if lc == None: # No existe el nodo con ese album: se inserta desde el arbol binario de busqueda
				canciones = ListaCanciones.ListaCanciones()
				canciones.insertar(nombre, path)
				abb.insertar(album, canciones)
			else: # Si existe el nodo con ese album: se inserta solo en la lista de canciones
				lc.lista.insertar(nombre, path)
	return ""

# ELIMINAR
@app.route('/eliminar_ano', methods=['POST'])
def eliminar_ano():
	ano = str(request.form['ano'])
	auxiliar = repertorio.inicio.derecha
	while auxiliar != None:
		repertorio.eliminar(ano, auxiliar.genero)
		auxiliar = auxiliar.derecha
	return ""

@app.route('/eliminar_genero', methods=['POST'])
def eliminar_genero():
	genero = str(request.form['genero'])
	auxiliar = repertorio.inicio.abajo
	while auxiliar != None:
		repertorio.eliminar(auxiliar.ano, genero)
		auxiliar = auxiliar.abajo
	return ""

@app.route('/eliminar_artistas', methods=['POST'])
def eliminar_artistas():
	ano = str(request.form['ano'])
	genero = str(request.form['genero'])
	repertorio.eliminar(ano, genero)
	return ""

@app.route('/eliminar_artista', methods=['POST'])
def eliminar_artista():
	ano = str(request.form['ano'])
	genero = str(request.form['genero'])
	artista = str(request.form['artista'])
	ab = repertorio.obtenerArtistas(ano, genero)
	if ab == None:
		return
	else:
		ab.artistas.eliminar(artista)
		if ab.artistas.raiz.cuenta == 0:
			repertorio.eliminar(ano, genero)
	return ""

@app.route('/eliminar_album', methods=['POST'])
def eliminar_album():
	ano = str(request.form['ano'])
	genero = str(request.form['genero'])
	artista = str(request.form['artista'])
	album = str(request.form['album'])
	ab = repertorio.obtenerArtistas(ano, genero)
	if ab == None:
		return
	else:
		indice = 0
		pagina = None
		pagina, indice = ab.artistas.buscar(ab.raiz, artista, bandera)
		if pagina == None:
			return
		else:
			abb = pagina.nodos[indice].albumes
			abb.eliminar(album)
			if abb.nodo == None:
				ab.artistas.eliminar(artista)
				if ab.artistas.raiz.cuenta == 0:
					repertorio.eliminar(ano, genero)
	return ""

@app.route('/eliminar_cancion', methods=['POST'])
def eliminar_cancion():
	ano = str(request.form['ano'])
	genero = str(request.form['genero'])
	artista = str(request.form['artista'])
	album = str(request.form['album'])
	nombre = str(request.form['nombre'])
	path = str(request.form['path'])
	repertorio.eliminar(ano, genero)
	ab = repertorio.obtenerArtistas(ano, genero)
	if ab == None:
		return
	else:
		indice = 0
		pagina = None
		pagina, indice = ab.artistas.buscar(ab.raiz, artista, bandera)
		if pagina == None:
			return
		else:
			abb = pagina.nodos[indice].albumes
			lc = abb.buscar(album)
			if lc == None:
				return
			else:
				lc.lista.eliminar(path)
				if lc.lista.inicio == None:
					abb.eliminar(album)
					if abb.nodo == None:
						ab.artistas.eliminar(artista)
						if ab.artistas.raiz.cuenta == 0:
							repertorio.eliminar(ano, genero)
	return ""

# OBTENER

if __name__ == "__main__":
  app.run(debug=True, host='0.0.0.0')