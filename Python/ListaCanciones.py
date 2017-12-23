class InfoCancion(object):
	def __init__(self, nombre, path):
		self.nombre = nombre
		self.path = path

class NodoCancion(object):
	def __init__(self, anterior, info, siguiente):
		self.info = info
		self.siguiente = siguiente
		self.anterior = anterior

class ListaCanciones(object):
	def __init__(self):
		self.inicio = None
		self.tamano = 0

	def estaVacia(self):
		return (False, True)[self.tamano == 0]

	def __existe(self, info):
		aux = self.inicio
		for x in range(self.tamano):
			if aux.info == info:
				return True
			aux = aux.siguiente
		return False

	def insertar(self, info):
		nuevo = None
		if self.estaVacia():
			nuevo = NodoCancion(None, info, None)
			nuevo.siguiente = nuevo
			nuevo.anterior = nuevo
			self.inicio = nuevo
		elif self.__existe(info):
			return False
		else:
			nuevo = NodoCancion(self.inicio.anterior, info, self.inicio)
			self.inicio.anterior.siguiente = nuevo
			self.inicio.anterior = nuevo
		self.tamano = self.tamano + 1
		return True

	def eliminar(self, nombre):
		aux = self.inicio
		for x in range(self.tamano):
			if aux.info.nombre == nombre:
				self.tamano = self.tamano - 1
				if self.tamano == 1:
					self.inicio	= None
					return True
				elif self.inicio == aux:
					self.inicio = aux.siguiente
				aux.anterior.siguiente = aux.siguiente
				aux.siguiente.anterior = aux.anterior
				return True
			aux = aux.siguiente
		return False

lista = ListaCanciones()
lista.insertar(1)
lista.insertar(2)
lista.insertar(3)
lista.insertar(4)

i = lista.tamano + 1
actual = lista.inicio
while(i > 0):
	print str(actual.info)
	print "|"
	print "v"
	actual = actual.siguiente
	i= i - 1