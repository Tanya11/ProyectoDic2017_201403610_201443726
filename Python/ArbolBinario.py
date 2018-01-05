import subprocess, commands

class NodoBinario(object):
	def __init__(self, album, lista):
		self.album = album
		self.lista = lista
		self.aidi = 0
		self.izquierda = ArbolBinario()
		self.derecha = ArbolBinario()

class ArbolBinario(object):
	def __init__(self):
		self.nodo = None
		self.contador = 0

	def buscar(self, album):
		if self.nodo == None:
			return None
		if self.nodo.album == album:
			return self.nodo
		elif self.nodo.album < album:
			return self.nodo.derecha.buscar(album)
		else:
			return self.nodo.izquierda.buscar(album)

	def insertar(self, album, lista):
		if self.nodo == None:
			self.nodo = NodoBinario(album, lista)
		elif self.nodo.album > album:
			self.nodo.izquierda.insertar(album, lista)
		elif self.nodo.album < album:
			self.nodo.derecha.insertar(album, lista)
		else:
			print "El archivo ya existe."

	def eliminar(self, album):
		if self.nodo != None:
			if self.nodo.album == album:
				if self.nodo.izquierda.nodo == None and self.nodo.derecha.nodo == None:
					self.nodo = None
				elif self.nodo.izquierda.nodo != None and self.nodo.derecha.nodo == None:
					self.nodo = self.nodo.izquierda.nodo
				elif self.nodo.izquierda.nodo == None and self.nodo.derecha.nodo != None:
					self.nodo = self.nodo.derecha.nodo
				else:
					predecesor = self.nodo.izquierda.nodo
					while predecesor.derecha.nodo != None:
						predecesor = predecesor.derecha.nodo
					self.nodo.album = predecesor.album
					self.nodo.lista = predecesor.lista
					self.nodo.izquierda.eliminar(predecesor.album)
			elif self.nodo.album > album:
				self.nodo.izquierda.eliminar(album)
			else:
				self.nodo.derecha.eliminar(album)

	def graficar(self):
		self.generarID(self.nodo, self.contador)
		cadena = "digraph arbol {\n"
		if(self.nodo != None):
			cadena = self.__listar(self.nodo, cadena)
			cadena += "\n"
			cadena = self.__enlazar(self.nodo, cadena)
		cadena += "}"
		Archivo = open('ArbolBinario.dot', 'w')
		Archivo.write(cadena)
		Archivo.close()
		subprocess.call(["dot","ArbolBinario.dot","-Tpng","-o","ArbolBinario.png", "-Gcharset=latin1"])

	def generarID(self, nodo, contador):
		if nodo != None:
			nodo.aidi = contador
			contador += 1
			contador = nodo.izquierda.generarID(nodo.izquierda.nodo, contador)
			contador = nodo.izquierda.generarID(nodo.derecha.nodo, contador)
		return contador

	def __listar(self, actual, cadena):
		if(actual != None):
			print actual.album
			cadena += "n" + str(actual.aidi) + " [label = \"" + str(actual.album) + "\"];\n"
			print actual.album.split(" ")
			if(actual.izquierda != None and actual.derecha != None):
				cadena = self.__listar(actual.izquierda.nodo, cadena)
				cadena = self.__listar(actual.derecha.nodo, cadena)
			elif(actual.nodo.izquierda != None):
				cadena = self.__listar(actual.izquierda.nodo, cadena)
			elif(actual.nodo.derecha != None):
				cadena = self.__listar(actual.derecha.nodo, cadena)
		return cadena;

	def __enlazar(self, actual, cadena):
		if(actual != None):
			if(actual.derecha.nodo != None):
				cadena += "n" + str(actual.aidi) + " -> n" + str(actual.derecha.nodo.aidi) + "[label = \"d\"];\n"
				cadena = self.__enlazar(actual.derecha.nodo, cadena)
			if(actual.izquierda.nodo != None):
				cadena += "n" + str(actual.aidi) + " -> n"+ str(actual.izquierda.nodo.aidi) + "[label = \"i\"];\n"
				cadena = self.__enlazar(actual.izquierda.nodo, cadena)
		return cadena

	def obtenerLista(self, nodo, texto):
		if nodo != None:
			texto += nodo.izquierda.obtenerLista(nodo.izquierda.nodo, texto)
			texto += nodo.lista.obtenerLista()
			texto += nodo.derecha.obtenerLista(nodo.derecha.nodo, texto)
		return texto