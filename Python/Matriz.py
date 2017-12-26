class NodoMatriz:
	def __init__(self, artistas):
		self.artistas = artistas
		self.id = None
		self.ano = None
		self.genero = None
		self.arriba = None
		self.abajo = None
		self.derecha = None
		self.izquierda = None

class Matriz:
	def __init__(self):
		self.inicio = NodoMatriz("Matriz")
		self.inicio.id = 0
		self.id = 1

	def __generoExiste(self, genero):
		auxiliar = self.inicio.derecha
		while auxiliar != None:
			if auxiliar.genero == genero:
				return True
			auxiliar = auxiliar.derecha
		return False

	def __anoExiste(self, ano):
		auxiliar = self.inicio.abajo
		while auxiliar != None:
			if auxiliar.ano == ano:
				return True
			auxiliar = auxiliar.abajo
		return False

	def __obtenerGenero(self, genero):
		auxiliar = self.inicio.derecha
		while auxiliar != None:
			if auxiliar.genero == genero:
				return auxiliar
			auxiliar = auxiliar.derecha

	def __obtenerAno(self, ano):
		auxiliar = self.inicio.abajo
		while auxiliar != None:
			if auxiliar.ano == ano:
				return auxiliar
			auxiliar = auxiliar.abajo

	def obtenerArtistas(self, ano, genero):
		auxiliar = ano.derecha
		while auxiliar != None:
			if auxiliar.genero == genero.genero:
				break
			auxiliar = auxiliar.derecha
		return auxiliar

	def Insertar(self, ano, genero, artistas):
		NodoFila = NodoMatriz(None)
		NodoColumna = NodoMatriz(None)
		NodoDato = NodoMatriz(artistas)
		NodoFila.ano = ano
		NodoFila.genero = genero
		NodoDato.id = self.id
		self.id += 1
		if self.inicio.abajo == None:
			self.inicio.abajo = NodoFila
			NodoFila.id = self.id
			self.id += 1
		elif self.inicio.abajo.ano.lower() > ano.lower():
			NodoFila.abajo = self.inicio.abajo
			self.inicio.abajo.arriba = NodoFila
			self.inicio.abajo = NodoFila
			NodoFila.id = self.id
			self.id += 1
		else:
			auxiliar = self.inicio.abajo
			while auxiliar != None:
				if auxiliar.ano.lower() < ano.lower() and auxiliar.abajo == None:
					auxiliar.abajo = NodoFila
					NodoFila.arriba = auxiliar
					NodoFila.id = self.id
					self.id += 1
					break
				elif auxiliar.ano.lower() < ano.lower():
					auxiliar = auxiliar.abajo
				elif auxiliar.ano.lower() == ano.lower():
					NodoFila = auxiliar
					break
				else:
					NodoFila.arriba = auxiliar.arriba
					auxiliar.arriba.abajo = NodoFila
					NodoFila.abajo = auxiliar
					auxiliar.arriba = NodoFila
					NodoFila.id = self.id
					self.id += 1
					break
		if self.inicio.derecha == None:
			self.inicio.derecha = NodoColumna
			NodoColumna.id = self.id
			self.id += 1
		elif self.inicio.derecha.genero.lower() > genero.lower():
			NodoColumna.derecha = self.inicio.derecha
			self.inicio.derecha.izquierda = NodoColumna
			self.inicio.derecha = NodoColumna
			NodoColumna.id = self.id
			self.id += 1
		else:
			auxiliar = self.inicio.derecha
			while auxiliar != None:
				if auxiliar.genero.lower() < genero.lower() and auxiliar.derecha == None:
					auxiliar.derecha = NodoColumna
					NodoColumna.izquierda = auxiliar
					NodoColumna.id = self.id
					self.id += 1
					break
				elif auxiliar.genero.lower() < genero.lower():
					auxiliar = auxiliar.derecha
				elif auxiliar.genero.lower() == genero.lower():
					NodoColumna = auxiliar
					break
				else:
					NodoColumna.izquierda = auxiliar.izquierda
					auxiliar.izquierda.derecha = NodoColumna
					NodoColumna.derecha = auxiliar
					auxiliar.izquierda = NodoColumna
					NodoColumna.id = self.id
					self.id += 1
					break
		NodoDato.ano = ano
		NodoDato.genero = genero
		if NodoColumna.abajo == None:
			NodoColumna.abajo = NodoDato
			NodoDato.arriba = NodoColumna
		elif NodoColumna.abajo.ano.lower() > ano.lower():
			NodoDato.abajo = NodoColumna.abajo
			NodoColumna.abajo.arriba = NodoDato
			NodoDato.arriba = NodoColumna
			NodoColumna.abajo = NodoDato
		else:
			auxiliar = NodoColumna.abajo
			while auxiliar != None:
				if auxiliar.ano.lower() == ano.lower():
					break
				elif auxiliar.abajo == None and auxiliar.ano.lower() < ano.lower():
					auxiliar.abajo = NodoDato
					NodoDato.arriba = auxiliar
					break
				elif auxiliar.artistas.lower() < NodoDato.artistas.lower():
					auxiliar = auxiliar.abajo
				else:
					NodoDato.arriba = auxiliar.arriba
					auxiliar.arriba.abajo = NodoDato
					NodoDato.abajo = auxiliar
					auxiliar.arriba = NodoDato
					break
		if NodoFila.derecha == None:
			NodoFila.derecha = NodoDato
			NodoDato.izquierda = NodoFila
		elif NodoFila.derecha.ano.lower() > ano.lower():
			NodoDato.derecha = NodoFila.derecha
			NodoFila.derecha.izquierda = NodoDato
			NodoDato.izquierda = NodoFila
			NodoFila.derecha = NodoDato
		else:
			auxiliar = NodoFila.derecha
			while auxiliar != None:
				if auxiliar.derecha == None and auxiliar.genero.lower() < NodoDato.genero.lower():
					auxiliar.derecha = NodoDato
					NodoDato.izquierda = auxiliar
					break
				elif auxiliar.genero.lower() < NodoDato.genero.lower():
					auxiliar = auxiliar.derecha
				else:
					NodoDato.izquierda = auxiliar.izquierda
					auxiliar.izquierda.derecha = NodoDato
					NodoDato.derecha = auxiliar
					auxiliar.izquierda = NodoDato
					break

	def Eliminar(self, ano, genero):
		if self.__anoExiste(ano) and self.__generoExiste(genero):
			NodoGenero = self.__obtenerGenero(genero)
			NodoAno = self.__obtenerAno(ano)
			NodoDato = self.obtenerArtistas(NodoAno, NodoGenero)
			if NodoDato != None:
				NodoDato.izquierda.derecha = NodoDato.derecha
				NodoDato.arriba.abajo = NodoDato.abajo
				if NodoDato.derecha != None:
					NodoDato.derecha.izquierda = NodoDato.izquierda
				if NodoDato.abajo != None:
					NodoDato.abajo.arriba = NodoDato.arriba
				if NodoGenero.abajo == None:
					if NodoGenero.izquierda != None:
						NodoGenero.izquierda.derecha = NodoGenero.derecha
					else:
						self.inicio.derecha = NodoGenero.derecha
					if NodoGenero.derecha != None:
						if NodoGenero.izquierda != None:
							NodoGenero.derecha.izquierda = NodoGenero.izquierda
						else:
							NodoGenero.derecha.izquierda = None
				if NodoAno.derecha == None:
					if NodoAno.arriba != None:
						NodoAno.arriba.abajo = NodoAno.abajo
					else:
						self.inicio.abajo = NodoAno.abajo
					if NodoAno.abajo != None:
						if NodoAno.arriba != None:
							NodoAno.abajo.arriba = NodoAno.arriba
						else:
							NodoAno.abajo.arriba = None
			else:
				print "El dato no existe alv"
		else:
			print "El dato no existe alv"