class Pagina(object):
	def __init__(self):
		self.nodos = [None, None, None, None, None]
		self.ramas = [None, None, None, None, None]
		self.cuenta = 0

	def estaLlena(self):
		return (self.cuenta == 4)

	def estaVacia(self):
		return (self.cuenta == 0)

	def graficar(self):
		index = 0
		identificador = 0
		cadena  = 'node' + str(self.nodos[1].album) + '[label = \"<D0>'
		while index <= self.cuenta:
			if self.nodos[index]!= None:
				cadena += '|<F' + str(index-1) + '> album: ' + self.nodos[index].album + '|<D' + str(identificador)  + '>' 
			index += 1
			identificador = identificador + 1
		cadena += '\"];\n'
		return cadena 