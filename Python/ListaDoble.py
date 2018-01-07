import subprocess
class NodoDoble:
	def __init__(self, Usuario):
		self.Usuario = Usuario
		self.siguiente = None
		self.anterior = None

class Usuario:
	def __init__ (self, nombre, contrasena):
		self.nombre = nombre
		self.contrasena = contrasena
		self.lista = None

class ListaDoble:
	def __init__(self):
		self.cabeza = None

	def __existe(self, nombre):
		buscado = self.cabeza
		while buscado != None:
			if buscado.Usuario.nombre == nombre:
				return True
			buscado = buscado.siguiente
		return False

	def insertar(self, nombre, contrasena):
		if self.__existe(nombre):
			return False
		nuevo = NodoDoble(Usuario(nombre, contrasena))
		nuevo.siguiente = self.cabeza
		if self.cabeza != None:
			self.cabeza.anterior = nuevo
		self.cabeza = nuevo
		return True

	def __buscar(self, nombre):
		buscado = self.cabeza
		while buscado != None and buscado.Usuario.nombre != nombre:
			buscado = buscado.siguiente
		return buscado

	def buscar(self, nombre, contrasena):
		buscado = self.cabeza
		while buscado != None and not (buscado.Usuario.nombre == nombre and buscado.Usuario.contrasena == contrasena):
			buscado = buscado.siguiente
		return buscado
	
	def eliminar(self, nombre):
		eliminado = self.__buscar(nombre)
		if eliminado != None:
			if eliminado == self.cabeza:
				self.cabeza = eliminado.siguiente
			if eliminado.anterior != None:
				eliminado.anterior.siguiente = eliminado.siguiente
			if eliminado.siguiente != None:
				eliminado.siguiente.anterior = eliminado.anterior
  	
	def graficar(self, path):
		path += "ListaDoble"
		file = open(path + '.dot', 'w')
		file.write("digraph ListaDoble{\n label=\"Lista Doble\"\n \tnode [fontcolor=\"red\",height=0.5,color=\"black\"]\n \tedge [color=\"black\", dir=fordware]\n")
		nodito = self.cabeza
		contador = 0
		while nodito != None:
			file.write("nodo" + str(contador)+ "[label= \"" + str(nodito.Usuario.nombre) + ", " + str(nodito.Usuario.contrasena) + "\"];\n")
			nodito = nodito.siguiente
			contador += 1
		contador = 0
		nodito = self.cabeza
		while nodito.siguiente != None:
			file.write("nodo" + str(contador) + "-> nodo" + str(contador+1) + ";\n")
			file.write("nodo" + str(contador+1) + "-> nodo" + str(contador) + ";\n")
			nodito = nodito.siguiente
			contador += 1
		file.write("\n}")
		file.close()
		subprocess.call(["dot", path + ".dot", "-Tpng", "-o", path + ".png", "-Gcharset=latin1"])