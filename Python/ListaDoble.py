class NodoDoble:
	def __init__(self, Usuario):
		self.Usuario = Usuario
		self.siguiente = None
		self.anterior= None

class Usuario:
	def __init__ (self, nombre, contrasena):
		self.nombre= None
		self.contrasena= None

class ListaDoble:
	def __init__(self):
		self.cabeza = None
		self.auxiliar = None

	def insertar(self, nombre, contrasena):
		self.auxiliar = NodoDoble(Usuario(nombre, contrasena))
		self.auxiliar.siguiente = self.cabeza
		if(self.cabeza != None):
			self.cabeza.anterior = self.auxiliar
			self.cabeza= auxiliar

	def Buscar(self, nombre):
		self.auxliar = self.cabeza
		while(auxiliar.nombre != nombre):
			self.auxiliar = self.auxiliar.siguiente
		if(self.auxiliar == None):
			print("no se encontro el usuario")
		return self.auxiliar
	
	def Eliminar(self, nombre):
		self.auxiliar = Buscar(nombre)
		try:
			self.auxiliar.anterior.siguiente(auxiliar.siguiente)
			self.auxiliar.siguiente.anterior(auxiliar.anterior)
		except ValueError:
			return (self.auxiliar)
  	
	def GraficarListaDoble(self):
		file= open('ListaCircular.dot', 'w')
		file.write("digraph ListaDoble{\n label=\"ListaDoble\"\n \tnode [fontcolor=\"purple\",height=0.5,color=\"black\"]\n \tedge [color=\"black\", dir=fordware]\n " )
		self.RecorrerListaDoble(file)
		file.write("\n}")
		file.close()
		subprocess.call(["dot","ListaDoble.dot","-Tpng","-o","ListaDoble.png"])

	def RecorrerListaDoble(self, file):
		nodito= self.cabeza
		texto=""
		while (nodito != None):
			texto = "nodo" + nodito.nombre + nodito.contrasena + "[label= \"" + nodito.nombre + nodito.contrasena + "\"];\n"
			file.write(texto)
			nodito = nodito.siguiente
		while (nodito.siguiente != None):
			nodito = self.cabeza
			texto= "nodo"+ nodito.nombre + nodito.contrasena +"-> nodo" + nodito.siguiente.nombre + nodito.siguiente.contrasena + ";\n"
			file.write(texto)
			nodito= nodito.siguiente
			


lista = ListaDoble()
lista.insertar("df", "df")
lista.insertar("Prueba","123")
lista.insertar("prueba","algo")
lista.GraficarListaDoble()
