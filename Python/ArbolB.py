import NodoB, Pagina, subprocess

class ArbolB(object):
	def __init__ (self, orden):
		self.grafo = ""
		self.orden = orden
		self.medio = orden / 2
		self.raiz = Pagina.Pagina()

	def __buscarNodo(self, actual, artista, indice):
		if artista < actual.nodos[1].artista:
			return False, 0
		else:
			indice = actual.cuenta
			while (artista < actual.nodos[indice].artista and indice > 1):
				indice -= 1
			return artista == actual.nodos[indice].artista, indice

	def buscar(self, actual, artista, indice):
		if actual == None:
			return actual, indice
		else:
			esta = False
			esta, indice = self.__buscarNodo(actual, artista, indice)
			if esta:
				return actual, indice
			else:
				return self.buscar(actual.ramas[indice], artista, indice) 

	def insertar(self, artista, albumes):
		nuevo = NodoB.NodoB(artista, albumes)
		self.raiz = self.__insertar(self.raiz, nuevo)

	def __insertar(self, raiz, artista):
		subir = False
		mediana = NodoB.NodoB("", None)
		nuevo = Pagina.Pagina()
		raiz_ = Pagina.Pagina()
		subir, mediana, nuevo, raiz_ = self.__mover(raiz, artista, mediana, nuevo)
		if subir:
			auxiliar = Pagina.Pagina()
			auxiliar.cuenta = 1
			auxiliar.nodos[1] = mediana
			auxiliar.ramas[0] = raiz_
			auxiliar.ramas[1] = nuevo
			raiz_ = auxiliar
		return raiz_
		
	def __mover(self, actual, artista, mediana, nuevo):
		subir = False
		if actual == None or actual.estaVacia():
			return True, artista, None, None
		else:
			indice = 0
			esta = False
			esta, indice = self.__buscarNodo(actual, artista.artista, indice)
			if esta:
				print "Nombre de artista duplicado: '" + str(artista.artista) + "'."
				return False, None, None, self.raiz
			subir, mediana, nuevo, actual.ramas[indice] = self.__mover(actual.ramas[indice], artista, mediana, nuevo)
			if subir:
				if actual.estaLlena():
					actual, mediana, nuevo = self.__dividirPagina(actual, mediana, nuevo, indice)
				else:
					actual = self.__insertarEnHoja(actual, mediana, nuevo, indice)
					return False, mediana, nuevo, actual
			return subir, mediana, nuevo, actual

	def __dividirPagina(self, actual, mediana, nuevo, indice):
		posicion = 0
		if (indice <= self.medio):
			posicion = self.medio
		else:
			posicion = self.medio + 1
		auxiliar = Pagina.Pagina()
		contador = posicion + 1
		while(contador < self.orden):
			auxiliar.nodos[contador - posicion] = actual.nodos[contador]
			auxiliar.ramas[contador - posicion] = actual.ramas[contador]
			contador += 1
		auxiliar.cuenta = (self.orden - 1) - posicion
		actual.cuenta = posicion
		if (indice <= self.medio):
			actual = self.__insertarEnHoja(actual, mediana, nuevo, indice)
		else:
			auxiliar = self.__insertarEnHoja(auxiliar, mediana, nuevo, indice - posicion)
		mediana = actual.nodos[actual.cuenta]
		auxiliar.ramas[0] = actual.ramas[actual.cuenta]
		actual.cuenta -= 1
		return actual, mediana, auxiliar

	def __insertarEnHoja(self, actual, nuevo, derecha, indice):
		posicion = actual.cuenta
		while (posicion >= indice + 1):
			actual.nodos[posicion + 1] = actual.nodos[posicion]
			actual.ramas[posicion + 1] = actual.ramas[posicion]
			posicion = posicion - 1
		actual.nodos[indice + 1] = nuevo
		actual.ramas[posicion + 1] = derecha
		actual.cuenta += 1
		return actual

	def eliminar(self, artista):
		self.raiz = self.__eliminar(self.raiz, artista)

	def __eliminar(self, raiz, artista):
		encontrado = False
		raiz_ = Pagina.Pagina()
		encontrado, raiz_ = self.__eliminarNodo(raiz, artista, encontrado)
		if encontrado:
			print "Artista "+ artista + " fue eliminado."
			if raiz_.estaVacia():
				raiz_ = raiz_.ramas[0]
		else:
			raiz_ = self.raiz
		return raiz_

	def __eliminarNodo(self, actual, artista, encontrado):
		indice = 0
		if actual == None:
			return False, actual
		else:
			encontrado, indice = self.__buscarNodo(actual, artista, indice)
			if encontrado:
				if actual.ramas[indice - 1] == None:
					actual = self.__remover(actual, indice)
				else:
					actual = self.__porSucesor(actual, indice)
					encontrado, actual.ramas[indice] = self.__eliminarNodo(actual.ramas[indice], actual.nodos[indice].artista, encontrado)
			else:
				encontrado, actual.ramas[indice] = self.__eliminarNodo(actual.ramas[indice], artista, encontrado)
			if actual.ramas[indice] != None and actual.ramas[indice].cuenta < self.medio:
				actual = self.__restaurar(actual, indice)
			return encontrado, actual

	def __remover(self, actual, indice):
		indice += 1
		while (indice <= actual.cuenta):
			actual.nodos[indice - 1] = actual.nodos[indice]
			actual.ramas[indice - 1] = actual.ramas[indice]
			indice += 1
		actual.cuenta -= 1
		return actual

	def __porSucesor(self, actual, indice):
		auxiliar = actual.ramas[indice]
		while (auxiliar.ramas[0] != None):
			auxiliar = auxiliar.ramas[0]
		actual.nodos[indice] = auxiliar.nodos[1]
		return actual

	def __restaurar(self, actual, indice):
		if indice > 0:
			if actual.ramas[indice - 1].cuenta > self.medio:
				actual = self.__moverDerecha(actual, indice)
			else:
				self.__combinar(actual, indice)
		else:
			if actual.ramas[1].cuenta > self.medio:
				actual = self.__moverIzquierda(actual, 1)
			else:
				self.__combinar(actual, 1)
		return actual

	def __moverDerecha(self, actual, indice):
		problema = actual.ramas[indice]
		izquierda = actual.ramas[indice - 1]
		contador = problema.cuenta
		while(contador >= 1):
			problema.nodos[contador + 1] = problema.nodos[contador]
			problema.ramas[contador + 1] = problema.ramas[contador]
			contador -= 1
		problema.cuenta += 1
		problema.ramas[1] = problema.ramas[0]
		problema.nodos[1] = actual.nodos[indice]
		actual.nodos[indice] = izquierda.nodos[izquierda.cuenta]
		problema.ramas[0] = izquierda.ramas[izquierda.cuenta]
		izquierda.cuenta -= 1
		return actual

	def __moverIzquierda(self, actual, indice):
		problema = actual.ramas[indice - 1]
		derecha = actual.ramas[indice]
		problema.cuenta += 1
		problema.nodos[problema.cuenta] = actual.nodos[indice]
		problema.ramas[problema.cuenta] = derecha.ramas[0]
		actual.nodos[indice] = derecha.nodos[1]
		derecha.ramas[1] = derecha.ramas[0]
		derecha.cuenta -= 1
		contador = 1
		while (contador <= derecha.cuenta):
			derecha.nodos[contador] = derecha.nodos[contador + 1]
			derecha.ramas[contador] = derecha.ramas[contador + 1]
			contador += 1
		return actual

	def __combinar(self, padre, indice):
		auxiliar = padre.ramas[indice]
		izquierdo = padre.ramas[indice - 1]
		izquierdo.cuenta -= 1
		izquierdo.nodos[izquierdo.cuenta] = padre.nodos[indice]
		izquierdo.ramas[izquierdo.cuenta] = auxiliar.ramas[0]
		contador = 1
		while(contador <= auxiliar.cuenta):
			izquierdo.cuenta += 1
			izquierdo.nodos[izquierdo.cuenta] = auxiliar.nodos[contador]
			izquierdo.ramas[izquierdo.cuenta] = auxiliar.ramas[contador]
			contador += 1
		contador = indice
		while(contador <= padre.cuenta):
			padre.nodos[contador] = padre.nodos[contador + 1]
			padre.ramas[contador] = padre.ramas[contador + 1]
			contador += 1
		padre.cuenta -= 1

	def graficar(self, path):
		path += "ArbolB"
		archivo = open(path + '.dot','w')
		archivo.write('digraph ArbolB{ \nnode[shape=record]\n')
		self._gpaginas(self.raiz)
		archivo.write(self.grafo + "\n")
		self.grafo = ""
		self._genlazes(self.raiz)
		archivo.write(self.grafo + "\n}")
		self.grafo = ""
		archivo.close()
		subprocess.call(["dot", path + ".dot", "-Tpng", "-o", path + ".png", "-Gcharset=latin1"])

	def _genlazes(self, actual):
		if actual != None:
			index = 0
			while index <= actual.cuenta:
				if actual.ramas[index] != None:
					self.grafo += 'node'+ str("".join(actual.nodos[1].artista.split(" "))) + ':D' + str(index) + '-> node' + str("".join(actual.ramas[index].nodos[1].artista.split(" "))) + '\n'
					self._genlazes(actual.ramas[index])
				index += 1

	def _gpaginas(self, actual):
		if actual != None:
			self.grafo += actual.graficar()
			index = 0
			while index <= actual.cuenta:
				if actual.ramas[index]!= None:
					self._gpaginas(actual.ramas[index])
				index += 1

	def obtenerLista(self, pagina, texto):
		if pagina != None:
			indice = 0
			while indice <= pagina.cuenta:
				texto = self.obtenerLista(pagina.ramas[indice], texto)
				if pagina.nodos[indice] != None:
					texto += pagina.nodos[indice].albumes.obtenerLista(pagina.nodos[indice].albumes.nodo, texto)
				indice += 1
		return texto

	def buscar_album(self, pagina, album, genero, ano):
		if pagina != None:
			indice = 0
			cadena = ""
			lista = ""
			while indice <= pagina.cuenta:
				cadena = self.buscar_album(pagina.ramas[indice], album, genero, ano)
				if pagina.nodos[indice] != None:
					lista += cadena + pagina.nodos[indice].albumes.buscar_album(album, pagina.nodos[indice].artista, genero, ano)
				indice += 1
			return lista
		return ""