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

class ListaDoble:
	def __init__(self):
		self.cabeza = None

	def insertar(self, nombre, contrasena):
		auxiliar = NodoDoble(Usuario(nombre, contrasena))
		auxiliar.siguiente = self.cabeza
		if self.cabeza != None:
			self.cabeza.anterior = auxiliar
		self.cabeza = auxiliar

	def Buscar(self, nombre):
		auxiliar = self.cabeza
		while auxiliar != None and auxiliar.nombre != nombre:
			auxiliar = auxiliar.siguiente
		if auxiliar != None:
			return auxiliar
		print("No se encontro el usuario")
	
	def Eliminar(self, nombre):
		auxiliar = Buscar(nombre)
		if auxiliar != None:
			if auxiliar == self.cabeza:
				self.cabeza = auxiliar.siguiente
			if auxiliar.anterior != None:
				auxiliar.anterior.siguiente = auxiliar.siguiente
			if auxiliar.siguiente != None:
				auxiliar.siguiente.anterior = auxiliar.anterior
  	
	def GraficarListaDoble(self):
		file = open('ListaDoble.dot', 'w')
		file.write("digraph ListaDoble{\n label=\"Lista Doble\"\n \tnode [fontcolor=\"red\",height=0.5,color=\"black\"]\n \tedge [color=\"black\", dir=fordware]\n")
		nodito = self.cabeza
		contador = 0
		while nodito != None:
			file.write("nodo" + str(contador)+ "[label= \"" + str(nodito.Usuario.nombre) + "\"];\n")
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
		subprocess.call(["dot","ListaDoble.dot","-Tpng","-o","ListaDoble.png"])

lista = ListaDoble()
lista.insertar("Fernandito", "dEf")
lista.insertar("Lester","123")
lista.insertar("Tanya","algo")
lista.GraficarListaDoble()