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

	def __obtenerGenero(self, genero):
		auxiliar = self.inicio.derecha
		while auxiliar != None:
			if auxiliar.genero == genero:
				break
			auxiliar = auxiliar.derecha
		return auxiliar

	def __obtenerAno(self, ano):
		auxiliar = self.inicio.abajo
		while auxiliar != None:
			if auxiliar.ano == ano:
				break
			auxiliar = auxiliar.abajo
		return auxiliar

	def __obtenerArtistas(self, ano, genero):
		auxiliar = ano.derecha
		while auxiliar != None:
			if auxiliar.genero == genero.genero:
				break
			auxiliar = auxiliar.derecha
		return auxiliar

	def obtenerArtistas(self, ano, genero):
		if self.__obtenerAno(ano) != None and self.__obtenerGenero(genero) != None:
			nodoAno = self.__obtenerAno(ano)
			nodoGenero = self.__obtenerGenero(genero)
			return self.__obtenerArtistas(nodoAno, nodoGenero)
		return None

	def insertar(self, ano, genero, artistas):
		NodoFila = NodoMatriz(None)
		NodoColumna = NodoMatriz(None)
		NodoDato = NodoMatriz(artistas)
		NodoFila.ano = ano
		NodoColumna.genero = genero
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
		elif NodoFila.derecha.genero.lower() > genero.lower():
			NodoDato.derecha = NodoFila.derecha
			NodoFila.derecha.izquierda = NodoDato
			NodoDato.izquierda = NodoFila
			NodoFila.derecha = NodoDato
		else:
			auxiliar = NodoFila.derecha
			while auxiliar != None:
				if auxiliar.genero.lower() == genero.lower():
					break
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

	def eliminar(self, ano, genero):
		if self.__obtenerAno(ano) != None and self.__obtenerGenero(genero) != None:
			NodoGenero = self.__obtenerGenero(genero)
			NodoAno = self.__obtenerAno(ano)
			NodoDato = self.__obtenerArtistas(NodoAno, NodoGenero)
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

	def graficar(self):
		Grafo_dot = "digraph Matriz{\n\trankdir=UD;\n\tnode [shape = box];\n\tlabel = \"Matriz\"" 
		paraAbajo = self.inicio
		paraDerecha = paraAbajo.derecha
		y = 0
		while paraAbajo != None:
			if y == 0:
				Grafo_dot += "\n\t{\n\t\trank=min;"
				Grafo_dot += "\n\t\tNode" + str(paraAbajo.id) + " [label = \"" + paraAbajo.id + "\", rankdir = LR]"
			elif paraAbajo.abajo == None:
				Grafo_dot += "\n\t{\n\t\trank=max;"
				Grafo_dot += "\n\t\tNode" + str(paraAbajo.id) + " [label = \"" + paraAbajo.id + "\"]"
			else:	
				Grafo_dot += "\n\t{\n\t\trank=same;"
				Grafo_dot += "\n\t\tNode" + str(paraAbajo.id) + " [label = \"" + paraAbajo.id + "\"]"
			while paraDerecha != None:
				if y == 0:
					Grafo_dot += "\n\t\tNode" + str(paraDerecha.id) + " [label = \"" + paraDerecha.id + "\", rankdir = LR]"
				else:
					Grafo_dot += "\n\t\tNode" + str(paraDerecha.id) + " [label = \"" + paraDerecha.id + "\"]"
				paraDerecha = paraDerecha.derecha
			Grafo_dot += "\n\t}"
			y += 1
			paraAbajo = paraAbajo.abajo
			if paraAbajo != None:
				paraDerecha = paraAbajo.derecha
		Grafo_dot += "\n\n"
		paraAbajo = self.inicio
		paraDerecha = paraAbajo.derecha
		while paraAbajo != None:
			if paraAbajo.abajo != None:
				Grafo_dot += "\n\tNode" + str(paraAbajo.id) + " -> Node" + str(paraAbajo.abajo.id) + ";"
			if paraAbajo.arriba != None:
				Grafo_dot += "\n\tNode" + str(paraAbajo.id) + " -> Node" + str(paraAbajo.arriba.id) + ";"
			if paraAbajo.derecha != None:
				Grafo_dot += "\n\tNode" + str(paraAbajo.id) + " -> Node" + str(paraAbajo.derecha.id) + ";"
			if paraAbajo.izquierda != None:
				Grafo_dot += "\n\tNode" + str(paraAbajo.id) + " -> Node" + str(paraAbajo.izquierda.id) + ";"
			while paraDerecha != None:
				if paraDerecha.abajo != None:
					Grafo_dot += "\n\tNode" + str(paraDerecha.id) + " -> Node" + str(paraDerecha.abajo.id) + ";"
				if paraDerecha.arriba != None:
					Grafo_dot += "\n\tNode" + str(paraDerecha.id) + " -> Node" + str(paraDerecha.arriba.id) + ";"
				if paraDerecha.derecha != None:
					Grafo_dot += "\n\tNode" + str(paraDerecha.id) + " -> Node" + str(paraDerecha.derecha.id) + ";"
				if paraDerecha.izquierda != None:
					Grafo_dot += "\n\tNode" + str(paraDerecha.id) + " -> Node" + str(paraDerecha.izquierda.id) + ";"
				if paraDerecha.atras != None:
					Grafo_dot += "\n\tNode" + str(paraDerecha.id) + " -> Node" + str(paraDerecha.atras.id) + ";"
				if paraDerecha.adelante != None:
					Grafo_dot += "\n\tNode" + str(paraDerecha.id) + " -> Node" + str(paraDerecha.adelante.id) + ";"
				paraDerecha = paraDerecha.derecha
			paraAbajo = paraAbajo.abajo
			if paraAbajo != None:
				paraDerecha = paraAbajo.derecha
		Grafo_dot += "\n}" 
		Archivo = open('Matriz.dot', 'w') 
		Archivo.write(Grafo_dot) 
		Archivo.close() 
		subprocess.call(['dot', 'Matriz.dot', '-o', 'Matriz.png', '-Tpng', '-Gcharset=utf8'])