﻿Proyecto 2 de Algoritmos 3
Nombre: Arleyn Goncalves 10 -1010290
	Francisco Sucre 10 -10717

	El proyecto 2 de Algoritmos y Estructuras III, esta conformado por las 
    clases ReinaRoja, ReinaBlanca, Arista, ColaAleatorizada, Conjuntos Disjuntos,
    Grafo y Nodo.

	Para utilizarlo llame a reinablanca o reina roja utilizando como argumentos
	archivos de texto que cumplan con la especificacion de entrada del proyecto

	Grafo tiene los procedimientos clasificados como Getter, Setter, y 
    Complex Methods:

 GETTERS:

        obtenerIteraciones: Obtiene la cantidad de veces que se aplicara el
		el algoritmo de crearDisputas
        
        obtenerNodos: Metodo que obtiene el conjunto de nodos en el grafo, asi 
        pueden usarse o guardarse                

        obtenerAristas: Metodo que obtiene el conjunto de aristas en el grafo,
        asi pueden usarse o guardarse         
        

  SETTERS:

     - agregarNodo: Metodo que agrega un nodo al conjunto de nodos del grafo, el 
       procedimiento retorna el grafo con la actualizacion del nodo agregado.

  COMPLEX METHODS

     - leerArbolRR: Metodo que lee el mapa de la reina roja y construye un grafo

     - leerArbolRB: Metodo que lee el mapa de la reina blanca y construye un grafo 
    
     - crearDisputas(): Metodo que calcula el minimo numero de disputas que deben
	  ser creadas por la reina roja para cortar la comunicacion con al menos una
	  localizacion

    
     - minimizarMonedas: Metodo que calcula el camino de costo minimo para alcanzar
	  a todos los nodos del grafo

     - imprimir: Metodo que imprime todos los nodos del grafo junto con sus conjuntos
       de adyacencia.



    Nodo tiene los procedimientos clasificados como Getter, Setter y 
	Complex Methods:

  GETTERS: 

    - obtenerNombre: Metodo para obtener el nombre de un nodo y guardarlo en una
	  variable, retorna el nombre del nodo

    - obtenerAdyacentes: Metodo para obtener el conjunto de adyacencia de un  
      nodo, retornamos el conjunto de las adyacencias.

    - obtenerAristas: Metodo para obtener la lista de aristas asociadas al nodo
        

  SETTERS:

    - agregarArista: Agrega una arista a la lista de aristas de un nodo

    - agregarAdyacente: Metodo para agregar adyacente a un nodo a la lista de adyacencia de 
      un nodo, y retorna el conjunto modificado.

    - agregarVariosAdyacentes: Metodo que agrega una lista de nodos a la lista de adyacencia 
      de un nodo, y retorna el conjunto de adyacencia modificado.

    COMPLEX METHODS.

    - imprimir: Metodo que imprime el nombre del nodo y su conjunto de adyacencia.

    ConjuntoDisjunto tiene los procedimientos clasificados como Getter, Setter y 
	Complex Methods:

	GETTERS:

	- find: Metodo que encuentra el representante del conjunto al cual 
      pertenece un nodo 

	SETTERS:   

    - makeSet: Metodo que genera un conjunto a partir de un nodo

    - Union: Metodo que une dos conjuntos disjuntos

    ConjuntoDisjunto tiene los procedimientos clasificados como Getter
    
        - obtenerIncidentes: Metodo que obtiene el conjunto de los nodos 
		  incidentes a la arista
        
        - obtenerCosto: Metodo que obtiene el costo de una arista

    ColaAleatorizada tiene los procedimientos clasificados como Getter y Setters

    // GETTERS
    
    - vacio: Metodo que comprueba si la cola esta "vacia", es decir si ya 
      todos sus elementos fueron extraidos

    - obtenerElementos: Metodo que obtiene los elementos de la cola   
 
    // SETTERS
    
    - insertar: Metodo que agrega un elemento a la cola
    
    - insertarVarios: Metodo que agrega Varios elementos a la Cola

    - Arista extraerAzar: Metodo que obtiene un elemento al azar de la cola y 
      lo "remueve", sin cambiar las probabilidades de ser extraidos de los otros
      elementos

    - extraer: Metodo que extrae un elemento seleccionado de la cola   
    

