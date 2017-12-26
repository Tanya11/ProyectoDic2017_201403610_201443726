import ListaCanciones, subprocess

class NodoBinario(object):
	def __init__(self, album):
		self.album = album
		self.lista = ListaCanciones.ListaCanciones()
		self.izquierda = ArbolBinario()
		self.derecha = ArbolBinario()

class ArbolBinario(object):
	def __init__(self):
		self.nodo = None

	def insertar(self, album):
		nuevo = NodoBinario(album)
		if self.nodo == None:
			self.nodo = nuevo
		elif self.nodo.album > album:
			self.nodo.izquierda.insertar(album)
		elif self.nodo.album < album:
			self.nodo.derecha.insertar(album)
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
					self.nodo.izquierda.eliminar(predecesor.album)
			elif self.nodo.album > album:
				self.nodo.izquierda.eliminar(album)
			else:
				self.nodo.derecha.eliminar(album)

	def graficar(self):
		cadena = "digraph arbol {\n"
		if(self.nodo != None):
			cadena = self.__listar(self.nodo, cadena)
			cadena += "\n"
			cadena = self.__enlazar(self.nodo, cadena)
		cadena += "}"
		Archivo = open('ArbolBinario.dot', 'w')
		Archivo.write(cadena)
		Archivo.close()
		subprocess.call(['dot', 'ArbolBinario.dot', '-o', 'ArbolBinario.png', '-Tpng', '-Gcharset=utf8']) 

	def __listar(self, actual, cadena):
		if(actual != None):
			cadena += "n" + str("".join(actual.album.split("."))) + " [label = \"" + str(actual.album) + "\"];\n"
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
				cadena += "n" + str("".join(actual.album.split("."))) + " -> n" + str("".join(actual.derecha.nodo.album.split("."))) + "[label = \"d\"];\n"
				cadena = self.__enlazar(actual.derecha.nodo, cadena)
			if(actual.izquierda.nodo != None):
				cadena += "n" + str("".join(actual.album.split("."))) + " -> n" + str("".join(actual.izquierda.nodo.album.split("."))) + "[label = \"i\"];\n"
				cadena = self.__enlazar(actual.izquierda.nodo, cadena)
		return cadena

tree = ArbolBinario()
# descomentando uno a uno se ve el proceso
tree.insertar("hola.wma")
tree.insertar("hola.png")
tree.insertar("hola.jpg")
tree.insertar("hola.zip")
tree.insertar("hola.txt")
#tree.insertar("hola.mp3")
#tree.insertar("hola.mp4")
tree.graficar()