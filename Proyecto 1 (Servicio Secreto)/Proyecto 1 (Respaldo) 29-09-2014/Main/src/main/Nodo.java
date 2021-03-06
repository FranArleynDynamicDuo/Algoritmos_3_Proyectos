/*
 *Arleyn Goncalves
 *Francisco Sucre
 * Proyecto 1 De Laboratorio Algoritmos 3
 * Servicio Secreto
 * Clase Nodo
 */
package main;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
Implementación de la clase Nodo, el nodo es la unida básica del grafo y en esta
implementación consta de un String como nombre y de un HashSet que representa
el conjunto de adyacencia del nodo
 */


public class Nodo

{
	// STATES.
    
	private String nombre_; // Nombre con el cual se identifica al nodo
	private HashSet<Nodo> adyacentes_; // Conjunto de adyacencia
        private boolean visitado_; // variable booleana para los metodos 
                                   // de recorrido
    private Object nodo;
        
	// CONSTRUCTORS.
   
	public Nodo(String nombre,Nodo[] adyacentes)
                
        //Constructor de nodos con lista de adyacencia        
                
        {	
            nombre_ = nombre; // Le Asignamos el nombre
            
            adyacentes_ = new HashSet(); // Inicializamos su conjunto de 
                                         // adyaencia
            
            adyacentes_.addAll(Arrays.asList(adyacentes)); // Agregamos los
                                                           // nodos
        }
         
                              
        public Nodo(String nombre)
                
        // Constructor de nodos sin lista de adyacencia         
                
        {	
            nombre_ = nombre; // Asignamos su nombre
            adyacentes_ = new HashSet(); // Inicializamos su conjunto       
        }

	// GETTERS.

	public String obtenerNombre()
                
        // Metodo para obtener el nombre de un nodo y guardarlo en una variable

        {
            return nombre_; // Hacemos return solo con el nombre del nodo
        }
        
        public HashSet<Nodo> obtenerAdyacentes()
                
        // Metodo para obtener el conjunto de adyacencia de un nodo                
                
        {
            return adyacentes_; // Hacemos return solo con el conjunto 
        }
        
        
        public boolean esVisitado() 
        
        {     
          return visitado_;
        }
        
        public Nodo resetearVisitados()
        
        // Metodo que cambia todos los booleanos de los nodos alcanzables a
        // false
                
        {
            Queue<Nodo> cola = new LinkedList<Nodo>(); // Cola usada para
                                                       // recorrer el grafo
            
            HashSet<Nodo> alcanzable = new HashSet<Nodo>();   // Conjunto de
                                                              // nodos
                                                              //alcanzables
                                                              // desde un nodo
            
            cola.add((Nodo) this); //Agrego el nodo original a la cola
            
           while (!cola.isEmpty())
            
            // Mientras la cola no este vacia recorrere el arbol   
               
            {   
                alcanzable.add((Nodo)cola.peek()); // Añado el primer nodo en la
                                                   // cola a la lista de
                                                   // alcanzables
                
                for (Nodo nodo : cola.peek().adyacentes_)
                    
                // Recorremos los nodos adyacentes de la cabeza de la cola
                    
                {
                    if (nodo.esVisitado() == true)
                
                    // Si el nodo tiene '.visitado' se cambia a falsey lo
                    // agregamos a la cola
                        
                    {
                        nodo.visitado_ = false;
                        cola.add(nodo);
                    }
                }
                
                cola.remove();
            }        
            return this;
        }
        
        public HashSet<Nodo> obtenerAlcanzables()
                
        // Metodo que dado un nodo, devuelva un conjunto con todos los nodos 
        // que son alcanzables desde el mismo (incluyéndolo a el mismo)
                
        {   
            visitado_ = false; // Inicializo el booleano 'visitado' del nodo
            
            this.resetearVisitados(); // Reseteo el booleano 'visitado' para
                                      // los alcanzables del nodo
            
            Queue<Nodo> cola = new LinkedList<Nodo>();  // Cola usada para
                                                        // recorrer el grafo 
            
            HashSet<Nodo> alcanzable = new HashSet<Nodo>(); // Conjunto de nodos
                                                            // alcanzables
                                                            // desde un nodo
            
            cola.add((Nodo) this);  //Agrego el nodo original a la cola
            visitado_ = true;   // Marco el nodo original como visitado
            
            while (!cola.isEmpty())

            // Mientras la cola no este vacia recorrere el arbol                
                
            {   
                alcanzable.add((Nodo)cola.peek()); // Añado el primer nodo en la
                                                   // cola a la lista de
                                                   // alcanzables
                
                for (Nodo nodo : cola.peek().adyacentes_)
                    
                // Recorro todos los nodos del conjunto de adyacencia del nodo
                // que esta de primero en la cola
                
                {
                    if (nodo.esVisitado() == false) // Busco los nodos no
                                                    // visitados
                    {
                        nodo.visitado_ = true; // Marco el nodo como visitado
                        cola.add(nodo); // Lo agrego a la cola
 
                    }
                }
                
                cola.remove(); // Remuevo el primer Nodo de la cola
            }
            
            String lista = ""; // Inicializo e1l string donde imprimire todos
                               // los nodos adyacentes
            
            int contador = 0;
                
            // Recorro toda la lista de adyacencia y concateno el nombre de
            // cada nodo a la lista
                
            for (Nodo hoja : alcanzable)

            {        
                    lista += hoja.nombre_;
                    contador = contador + 1;

                    // Sino es el ultimo nodo, añado una ',' para separarlo
                    // de siguiente

                    if (contador != alcanzable.size())

                    {
                        lista += ", ";
                    } 
            }
            
            System.out.println("["+ nombre_ + "] -> [" + lista + "]");    
            return alcanzable;
        } 

        
	public Nodo agregarAdyacente(Nodo nodoNuevo)
                
	// Metodo para agregarAdyacente un nodo a la lista de adyacencia
        // de un nodo
                
        {
            adyacentes_.add(nodoNuevo); // Añadimos el nuevo nodo al conjunto
                                        // de adyacencia
            
            return this; // Y hacemos return con el conjunto modificado             
        } 
        
        
        public Nodo agregarVariosAdyacentes(Nodo... hojasNew)
                
        // Metodo que agrega una lista de nodos a la lista de adyacencia de un
        // nodo                
                
        {
            // Usamos un 'for' para recorrer todos los elementos en la lista
            // de nodos y asi agregarlos uno a uno
            
            adyacentes_.addAll(Arrays.asList(hojasNew)); // Agregamos un nodo al
                                                         // conjunto
                
            return this; // Devuelve el nodo con su conjunto de adyacencia
                         // modificado
        }

	public Nodo remover(Nodo nodoBotar)
                
	// Metodo para remover un nodo de la lista de adyacencia de un nodo                

        {		
            adyacentes_.remove(nodoBotar); // Removemos el nodo del conjunto
            
            return this; // Devuelve el Nodo con su conjunto de adyacencia
                         // modificado
        } 

        
        public Nodo removerVarios(Nodo[] hojasOld)
                
        // Metodo para remover una lista de nodos de la lista de adyacencia
        // de un nodo     
                
        {
            // Usamos un 'for' para recorrer todos los elementos en la lista
            // de nodos y removerrr uno a uno de las adyacencias
                
            for (Nodo hojaVieja : hojasOld)
                    
            { 
                adyacentes_.remove(hojaVieja); // Removemos el nodo
            }
                
            return this;
        }   
   
        
        public void imprimir()
                
        // Metodo que imprime el nombre del nodo y su conjunto de adyacencia
                
        {      
            String lista = ""; // Inicializo el string donde imprimire todos
                               // los nodos adyacentes
                
            int contador = 0;
                
            // Recorro toda la lista de adyacencia y concateno el nombre de
            // cada nodo a la lista
                
            for (Nodo hoja : adyacentes_)

            {   
                lista += hoja.nombre_;
                contador = contador + 1;
                       
                // Sino es el ultimo nodo, añado una ',' para separarlo
                // de siguiente
                       
                if (contador != adyacentes_.size())
                               
                {            
                    lista += ", ";               
                }          
            }
                
            System.out.println("["+ nombre_ + "] -> [" + lista + "]");
        }
}