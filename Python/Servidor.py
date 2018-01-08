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

# RAIZ
@app.route('/', methods = ['GET'])
def init():
	return "metodos: /ingresar, /salir, /insertar_usuario, /agregar_cancion, /eliminar_ano, /eliminar_genero, /eliminar_artistas, /eliminar_artista, /eliminar_album, eliminar_cancion..."

# LOGIN
@app.route('/ingresar', methods = ['POST'])
def ingresar():
	nombre = (request.form['nombre']).encode('utf8')
	contrasena = (request.form['contrasena']).encode('utf8')
	lg = usuarios.buscar(nombre, contrasena)
	if lg == None:
		return "Credenciales incorrectas."
	return "Ingreso exitoso."

# LOGOUT
@app.route('/salir', methods = ['POST'])
def salir():
	txt = (request.form['txt']).encode('utf8')
	return ""

# INSERTAR
@app.route('/insertar_usuario', methods = ['POST'])
def insertar_usuario():
	nombre = (request.form['nombre']).encode('utf8')
	contrasena = (request.form['contrasena']).encode('utf8')
	if usuarios.insertar(nombre, contrasena):
		return "Usuario creado."
	return "Nombre de usuario ya en uso."

@app.route('/agregar_a_lista', methods = ['POST'])
def agregar_a_lista():
	nombre = (request.form['nombre']).encode('utf8')
	path = (request.form['path']).encode('utf8')
	usuario = (request.form['usuario']).encode('utf8')
	contrasena = (request.form['contrasena']).encode('utf8')
	logueado = usuarios.buscar(usuario, contrasena)
	if logueado != None:
		usr = logueado.Usuario
		if usr.lista == None:
			usr.lista = ListaCanciones.ListaCanciones()
		usr.lista.insertar(nombre, path)
	return ""	

@app.route('/agregar_cancion', methods=['POST'])
def agregar_cancion():
	ano = (request.form['ano']).encode('utf8')
	genero = (request.form['genero']).encode('utf8')
	artista = (request.form['artista']).encode('utf8')
	album = (request.form['album']).encode('utf8')
	nombre = (request.form['nombre']).encode('utf8')
	path = (request.form['path']).encode('utf8')
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
			ab.artistas.insertar(artista, albumes)
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
@app.route('/eliminar_usuario', methods=['POST'])
def eliminar_usuario():
	nombre = (request.form['nombre']).encode('utf8')
	contrasena = (request.form['contrasena']).encode('utf8')
	usuario = (request.form['usuario']).encode('utf8')
	contrasena2 = (request.form['contrasena2']).encode('utf8')
	if nombre == usuario:
		return "No te puedes eliminar."
	usuario_ = usuarios.buscar(nombre, contrasena)
	if usuario_ != None:
		usuarios.eliminar(nombre)
		return "Usuario eliminado."
	return "Usuario no encontrado."

@app.route('/eliminar_ano', methods=['POST'])
def eliminar_ano():
	ano = (request.form['ano']).encode('utf8')
	auxiliar = repertorio.inicio.derecha
	while auxiliar != None:
		repertorio.eliminar(ano, auxiliar.genero)
		auxiliar = auxiliar.derecha
	return ""

@app.route('/eliminar_genero', methods=['POST'])
def eliminar_genero():
	genero = (request.form['genero']).encode('utf8')
	auxiliar = repertorio.inicio.abajo
	while auxiliar != None:
		repertorio.eliminar(auxiliar.ano, genero)
		auxiliar = auxiliar.abajo
	return ""

@app.route('/eliminar_artistas', methods=['POST'])
def eliminar_artistas():
	ano = (request.form['ano']).encode('utf8')
	genero = (request.form['genero']).encode('utf8')
	repertorio.eliminar(ano, genero)
	return ""

@app.route('/eliminar_artista', methods=['POST'])
def eliminar_artista():
	artista = (request.form['artista']).encode('utf8')
	if repertorio.id != 1:
		nodoFila = repertorio.inicio.abajo
		nodoDato = None
		while nodoFila != None:
			nodoDato = nodoFila.derecha
			while nodoDato != None:
				nodoDato.artistas.eliminar(artista)
				if nodoDato.artistas.raiz == None or nodoDato.artistas.raiz.cuenta == 0:
					repertorio.eliminar(nodoDato.ano, nodoDato.genero)
				nodoDato = nodoDato.derecha
			nodoFila = nodoFila.abajo
	return ""

@app.route('/eliminar_album', methods=['POST'])
def eliminar_album():
	ano = (request.form['ano']).encode('utf8')
	genero = (request.form['genero']).encode('utf8')
	artista = (request.form['artista']).encode('utf8')
	album = (request.form['album']).encode('utf8')
	ab = repertorio.obtenerArtistas(ano, genero)
	if ab != None:
		indice = 0
		pagina = None
		pagina, indice = ab.artistas.buscar(ab.artistas.raiz, artista, indice)
		if pagina != None:
			abb = pagina.nodos[indice].albumes
			abb.eliminar(album)
			if abb.nodo == None:
				ab.artistas.eliminar(artista)
				if ab.artistas.raiz == None or ab.artistas.raiz.cuenta == 0:
					repertorio.eliminar(ano, genero)
	return ""

@app.route('/eliminar_cancion', methods=['POST'])
def eliminar_cancion():
	ano = (request.form['ano']).encode('utf8')
	genero = (request.form['genero']).encode('utf8')
	artista = (request.form['artista']).encode('utf8')
	album = (request.form['album']).encode('utf8')
	nombre = (request.form['nombre']).encode('utf8')
	ab = repertorio.obtenerArtistas(ano, genero)
	if ab != None:
		indice = 0
		pagina = None
		pagina, indice = ab.artistas.buscar(ab.artistas.raiz, artista, indice)
		if pagina != None:
			abb = pagina.nodos[indice].albumes
			lc = abb.buscar(album)
			if lc != None:
				lc.lista.eliminar(nombre)
				if lc.lista.inicio == None:
					abb.eliminar(album)
					if abb.nodo == None:
						ab.artistas.eliminar(artista)
						if ab.artistas.raiz == None or ab.artistas.raiz.cuenta == 0:
							repertorio.eliminar(ano, genero)
	return ""

# GRAFICAR
@app.route('/graficar_matriz', methods=['POST'])
def graficar_matriz():
	path = (request.form['path']).encode('utf8')
	repertorio.graficar(path)
	return ""

@app.route('/graficar_arbol_b', methods=['POST'])
def graficar_arbol_b():
	ano = (request.form['ano']).encode('utf8')
	genero = (request.form['genero']).encode('utf8')
	path = (request.form['path']).encode('utf8')
	ab = repertorio.obtenerArtistas(ano, genero)
	if ab != None:
		ab.artistas.graficar(path)
	return ""

@app.route('/graficar_abb', methods=['POST'])
def graficar_abb():
	ano = (request.form['ano']).encode('utf8')
	genero = (request.form['genero']).encode('utf8')
	artista = (request.form['artista']).encode('utf8')
	path = (request.form['path']).encode('utf8')
	ab = repertorio.obtenerArtistas(ano, genero)
	if ab != None:
		indice = 0
		pagina = None
		pagina, indice = ab.artistas.buscar(ab.artistas.raiz, artista, indice)
		if pagina != None:
			pagina.nodos[indice].albumes.graficar(path)
	return ""

@app.route('/graficar_lista_circular', methods=['POST'])
def graficar_lista_circular():
	ano = (request.form['ano']).encode('utf8')
	genero = (request.form['genero']).encode('utf8')
	artista = (request.form['artista']).encode('utf8')
	album = (request.form['album']).encode('utf8')
	path = (request.form['path']).encode('utf8')
	ab = repertorio.obtenerArtistas(ano, genero)
	if ab != None:
		indice = 0
		pagina = None
		pagina, indice = ab.artistas.buscar(ab.artistas.raiz, artista, indice)
		if pagina != None:
			abb = pagina.nodos[indice].albumes
			lc = abb.buscar(album)
			if lc != None:
				lc.lista.graficar(False, path)
	return ""

@app.route('/graficar_lista_doble', methods=['POST'])
def graficar_lista_doble():
	path = (request.form['path']).encode('utf8')
	usuarios.graficar(path)
	return ""

@app.route('/graficar_cola_circular_usuario', methods=['POST'])
def graficar_cola_circular_usuario():
	path = (request.form['path']).encode('utf8')
	usuario = (request.form['usuario']).encode('utf8')
	contrasena = (request.form['contrasena']).encode('utf8')
	logueado = usuarios.buscar(usuario, contrasena)
	if logueado != None:
		usr = logueado.Usuario
		if usr.lista != None:
			usr.lista.graficar(True, path)
	return ""

# OBTENER LISTA A REPRODUCIR
@app.route('/canciones_artista', methods = ['POST'])
def canciones_artista():
	artista = (request.form['artista']).encode('utf8')
	texto = ""
	nodo = repertorio.inicio.abajo
	indice = 0
	pagina = None
	ab = None
	while nodo != None:
		ab = nodo.derecha
		while ab != None:
			pagina, indice = ab.artistas.buscar(ab.artistas.raiz, artista, indice)
			if pagina != None:
				abb = pagina.nodos[indice].albumes
				texto += abb.obtenerLista(abb.nodo, texto)
			indice = 0
			pagina = None
			ab = ab.derecha
		nodo = nodo.abajo
	return texto

@app.route('/canciones_album', methods = ['POST'])
def canciones_album():
	ano = (request.form['ano']).encode('utf8')
	genero = (request.form['genero']).encode('utf8')
	artista = (request.form['artista']).encode('utf8')
	album = (request.form['album']).encode('utf8')
	ab = repertorio.obtenerArtistas(ano, genero)
	if ab != None:
		indice = 0
		pagina = None
		pagina, indice = ab.artistas.buscar(ab.artistas.raiz, artista, indice)
		if pagina != None:
			abb = pagina.nodos[indice].albumes
			lc = abb.buscar(album)
			if lc != None:
				return lc.lista.obtenerLista()
	return ""

@app.route('/canciones_shuffle', methods = ['POST'])
def canciones_shuffle():
	txt = (request.form['txt']).encode('utf8')
	return ""

@app.route('/canciones_genero', methods = ['POST'])
def canciones_genero():
	genero = (request.form['genero']).encode('utf8')
	ab = repertorio.obtenerGenero(genero)
	txt = ""
	texto = ""
	if ab != None:
		ab = ab.abajo
		while ab != None:
			texto += ab.artistas.obtenerLista(ab.artistas.raiz, txt)
			ab = ab.abajo
	return texto

@app.route('/canciones_ano', methods = ['POST'])
def canciones_ano():
	ano = (request.form['ano']).encode('utf8')
	ab = repertorio.obtenerAno(ano)
	txt = ""
	texto = ""
	if ab != None:
		ab = ab.derecha
		while ab != None:
			texto += ab.artistas.obtenerLista(ab.artistas.raiz, txt)
			ab = ab.derecha
	return texto

@app.route('/canciones_usuario', methods = ['POST'])
def canciones_usuario():
	usuario = (request.form['usuario']).encode('utf8')
	contrasena = (request.form['contrasena']).encode('utf8')
	logueado = usuarios.buscar(usuario, contrasena)
	if logueado != None:
		usr = logueado.Usuario
		if usr.lista != None:
			return usr.lista.obtenerLista()
	return ""

@app.route('/buscar_album', methods = ['POST'])
def buscar_album():
	album = (request.form['album']).encode('utf8')
	cadena = ""
	fila = repertorio.inicio.abajo
	indice = 0
	pagina = None
	nodo = None
	ab = None
	while fila != None:
		nodo = fila.derecha
		while nodo != None:
			ab = nodo.artistas
			cadena += ab.buscar_album(ab.raiz, album, nodo.genero, nodo.ano)
			nodo = nodo.derecha
		fila = fila.abajo
	return cadena

#RUN DEL SERVER
if __name__ == "__main__":
  app.run(debug=True, host='0.0.0.0')