import ListaCanciones

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