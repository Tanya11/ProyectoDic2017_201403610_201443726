import subprocess

class InfoCancion(object):
	def __init__(self, nombre, path):
		self.nombre = nombre
		self.path = path

class NodoCancion(object):
	def __init__(self, anterior, info, siguiente):
		self.id = 0
		self.info = info
		self.siguiente = siguiente
		self.anterior = anterior

class ListaCanciones(object):
	def __init__(self):
		self.inicio = None
		self.tamano = 0

	def insertar(self, nombre, path):
		info = InfoCancion(nombre, path)
		if self.tamano == 0:
			self.inicio = NodoCancion(None, info, None)
			self.inicio.siguiente = self.inicio
			self.inicio.anterior = self.inicio
			self.inicio.id = 0
			self.tamano = 1
		else:
			nuevo = NodoCancion(self.inicio.anterior, info, self.inicio)
			nuevo.id = nuevo.anterior.id + 1
			nuevo.anterior.siguiente = nuevo
			self.inicio.anterior = nuevo
			self.tamano += 1
		return True

	def eliminar(self, nombre):
		aux = self.inicio
		for iterador in range(self.tamano):
			if aux.info.nombre == nombre:
				if self.tamano == 1:
					self.inicio	= None
					self.tamano = 0
					return True
				elif self.inicio == aux:
					self.inicio = aux.siguiente
				self.tamano -= 1
				aux.anterior.siguiente = aux.siguiente
				aux.siguiente.anterior = aux.anterior
				return True
			aux = aux.siguiente
		return False

	def graficar(self, cola, path):
		if cola:
			path += "ColaCircular"
			file = open(path + '.dot', 'w')
			file.write("digraph ColaCircular{\n label=\"Cola Circular\"\n \tnode [fontcolor=\"red\",height=0.5,color=\"black\"]\n \tedge [color=\"black\", dir=fordware]\n")
		else:
			path += "ListaCircular"
			file = open(path + '.dot', 'w')
			file.write("digraph ListaCircular{\n label=\"Lista Circular\"\n \tnode [fontcolor=\"red\",height=0.5,color=\"black\"]\n \tedge [color=\"black\", dir=fordware]\n")
		nodo = self.inicio
		contador = 0
		while contador < self.tamano:
			file.write("nodo" + str(nodo.id) + " [label = \"cancion: " + nodo.info.nombre + "\"];\n")
			file.write("nodo" + str(nodo.id) + " -> nodo" + str(nodo.siguiente.id) + ";\n")
			if not cola:
				file.write("nodo" + str(nodo.id) + " -> nodo" + str(nodo.anterior.id) + ";\n")
			nodo = nodo.siguiente
			contador += 1
		file.write("\n}")
		file.close()
		subprocess.call(["dot", path + ".dot","-Tpng", "-o", path + ".png", "-Gcharset=latin1"])

	def obtenerLista(self):
		nodo = self.inicio
		contador = 0
		texto = ""
		while contador < self.tamano:
			texto += nodo.info.nombre + " ---- " + nodo.info.path + "\n"
			nodo = nodo.siguiente
			contador += 1
		return texto

	def canciones(self, album, artista, genero, ano):
		nodo = self.inicio
		contador = 0
		texto = ""
		while contador < self.tamano:
			texto += artista + " ---- " + album + " ---- " + ano + " ---- " + genero + " ---- " + nodo.info.nombre + " ---- " + nodo.info.path + "\n"
			nodo = nodo.siguiente
			contador += 1
		return texto