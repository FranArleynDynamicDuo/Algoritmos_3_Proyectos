﻿Proyecto 2 de Algoritmos 3
Nombre: Arleyn Goncalves 10 -1010290
	Francisco Sucre 10 -10717

	El proyecto 3 de Algoritmos y Estructuras III, esta conformado por las 
    clases RutasTransporte,Ciudad,Autopista y Mapa.

	Para utilizarlo llame a RutasTransporte utilizando como argumento el
	archivo de texto que cumpla con la especificacion de entrada del proyecto

	Mapa tiene los procedimientos clasificados como Getter, Setter, y 
    Complex Methods:

 GETTERS:
        
     - obtenerCiudades: Metodo que obtiene el conjunto de Ciudades en el Mapa,
	   asi pueden usarse o guardarse                

     - obtenerAutopistas: Metodo que obtiene el conjunto de Autopistas en el Mapa,
       asi pueden usarse o guardarse  

	 - encontrarAutopista(origen,Destino): Busca en las autopistas del mapa
	   una que salga de "origen" y que llegue a "destino"       
        

  SETTERS:

     - agregarCiudad: Metodo que agrega un Ciudad al conjunto de Ciudades del 
       Mapa

     - agregarAutopista: Metodo que agrega un ciudad al conjunto de ciudades
 	   del Mapa 

  COMPLEX METHODS

     - analizarRutas(bw): Metodo que analiza el mapa y detectalas rutas no 
	   rentables para la compañia utilizando una implementacion del algoritmo
	   BellmanFord para detectar ciclos negativos

     - imprimir: Metodo que imprime todos los Ciudades del Mapa junto con sus conjuntos
       de adyacencia.

    Ciudad tiene los procedimientos clasificados como Getter, Setter y 
	Complex Methods:

  GETTERS: 

    - obtenerNombre: Metodo para obtener el nombre de un Ciudad y guardarlo en una
	  variable, retorna el nombre del Ciudad

    - obtenerAdyacentes: Metodo para obtener el conjunto de adyacencia de un  
      Ciudad, retornamos el conjunto de las adyacencias.

    - obtenerAutopistas: Metodo para obtener la lista de Autopistas asociadas al Ciudad

    - obtenerDistancia: Metodo que devuelve la distancia de una ciudad para la
      implementacion del BellmanFord

    - obtenerGanancia: Metodo que devuelve la ganancia de una ciudad

    - obtenerPredecesor: Metodo que obtiene el predecesor de una ciudad 

  SETTERS:

    - agregarAutopista: Agrega una Autopista a la lista de Autopistas de un Ciudad

    - modificarPredecesor: Metodo que modifica el predecesor de una ciudad

    - modificarDistancia: Metodo que modifica la distancia para la 
	  implementacion del BellmanFord 

    - ciudadeIguales: Metodo que compara 2 ciudades con sus nombres  

    - agregarAdyacente: Metodo para agregar adyacente a un Ciudad a la lista de
	  adyacencia de un Ciudad, y retorna el conjunto modificado.

  COMPLEX METHODS.

    - imprimir: Metodo que imprime el nombre del Ciudad y su conjunto de 
	  adyacencia.

	Autopista tiene los procedimientos clasificados como Getter y Setter

  GETTERS

    - obtenerIncidentes: Metodo que obtiene el conjunto de los ciudads 
      incidentes a la arista
        
    - obtenerCosto: Metodo que obtiene el costo de una arista

    - obtenerOrigen: Metodo que obtiene el costo de una arista
        
    - obtenerDestino:Metodo que obtiene el costo de una arista    

    - modificarDistancia: Metodo que obtiene el conjunto de los ciudads 
      incidentes a la arista

  
    

