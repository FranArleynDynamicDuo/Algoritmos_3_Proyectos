/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Servicio Alicia
 * Clase Grafo
 */
package reinablanca;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Implmentacion de la claso Grafo para el Proyecto 2 de CI2693
 * @author franciscosucre
 */
     class Grafo
    {
        // STATES
        
        private String nombre_;
        private HashSet<Nodo> hojas_;        
        private HashSet<Arista> aristas_;
        private Integer iteraciones_;
        
        // CONSTRUCTORS.
        
        public Grafo(HashSet<Nodo> hojas,HashSet<Arista> aristas)
                
        // Constructor con 2 argumentos que forma un grafo con un conjunto de 
        // aristas y una lista de nodos que pertenecen a el                
        
        {
            aristas_ = aristas;    
            hojas_ = hojas; // Agregamos los nodos
        }
        
        
        public Grafo()
                
        // Constructor que no recibe argumentos y forma un grafo vacio   
                
        {
            hojas_ = new HashSet<>(); // Inicializamos el conjunto de nodos en el
                                    // grafo como un HashSet vacio
            aristas_ = new HashSet<Arista>();           
        }
        
        public Grafo(Nodo nodoNuevo)
                
        // Constructor que no recibe argumentos y forma un grafo vacio   
                
        {
            hojas_ = new HashSet<>(); // Inicializamos el conjunto de nodos en el
                                      // grafo como un HashSet vacio
            hojas_.add(nodoNuevo);
            aristas_ = new HashSet<Arista>();
        }        

        // GETTERS.
        
        public int obtenerIteraciones()

		// Metodo que obtiene la cantidad de veces que se aplicara el
		// el algoritmo de crearDisputas

        {
            return iteraciones_;
        }
        
        public HashSet <Nodo> obtenerNodos() 
                
        // Metodo que obtiene el conjunto de nodos en el grafo, asi pueden 
        // usarse o guardarse                
                
        {      
            return hojas_; // Retorna el conjunto de los nodos del grafo    
        }    

        public HashSet <Arista> obtenerAristas() 
                
        // Metodo que obtiene el conjunto de aristas en el grafo, asi pueden 
        // usarse o guardarse                
                
        {
            return aristas_; // Retorna el conjunto de los nodos del grafo       
        }
        
        // SETTERS.   

        public Grafo agregarNodo(Nodo hoja)
                
        // Metodo que agrega un nodo al conjunto de nodos del grafo  
                
        {
            hojas_.add(hoja);   // Agregamos el nodo
            boolean repetido;   // Variable para examinar si hay otro nodo con
                                // el mismo nombre en el grafo
            return this;      
        }      
          
        
        // COMPLEX METHODS.        

    public Grafo leerArbolRR(String archivoEntrada)
      throws IOException 
            
            // Metodo que lee el mapa de la reina roja y construye un arbol
    
    {
        int i;
        File file = new File (archivoEntrada); // Variable para manejar el
                                               // archivo de texto
        FileReader fileReader = new FileReader(file);
        
           try (BufferedReader in = new BufferedReader(fileReader)) 
            {
                String s;
                String[] palabras; 
                int localidades;
                int linea;
                HashSet<Nodo> conexion = new HashSet<Nodo>();
                Boolean repetida;
                repetida = false;

                
                s = in.readLine(); // Leo una linea
                localidades = (new Integer(s)); // La asigno como el numero de
                                                // nodos
                Nodo[] nodosAgre = new Nodo[localidades + 1]; // Lista de los 
                                                              // nodos creados
                
                // Creo cuantos nodos sean necesarios
                
                for(i = 0; i < localidades; i++)
                    
                {    
                    nodosAgre[i] =(new Nodo(("localidad " + (
                            new Integer(i + 1)).toString())));
                }       
                
                linea = 0;
                
                // En el resto del archivo leeremos la matriz de adyacencia
                // para crear las aristas y las adyacencias
                
                while ((s = in.readLine()) != null && (linea < localidades) )
                    
                {
                    
                    palabras = s.split(""); // Divido la linea de caracteres
                    
                    for(i = 0; i < palabras.length; i++)
                        
                    {
                        
                        if (palabras[i].equals("#") && (!(i == linea)))
                            
                        {

                            // Si quiero contar los bucles como adyacencias
                            // ponemos 
                            // nodosAgre[linea].agregarAdyacente(conexiones);
                            
                            nodosAgre[linea].agregarAdyacente(nodosAgre[i]);
                            conexion.add(nodosAgre[linea]);
                            conexion.add(nodosAgre[i]);                            
                            nodosAgre[linea].agregarArista(new Arista(
                                    0, (HashSet<Nodo>) conexion.clone()));
                            Arista verifica;
                            verifica = (new Arista(0,conexion));
                            
                            // Agrego las aristas y sus adyacencias
                            
                            for (Arista arista : aristas_)
                            
                            {
                            
                                if (((verifica.obtenerIncidentes().equals(
                                        arista.obtenerIncidentes()))))
                                    
                                {
                                
                                    repetida = true;
                                    break;
                                
                                }
                                
                                
                                if (!(((verifica.obtenerIncidentes().equals(
                                        arista.obtenerIncidentes())))))
                                    
                                {
                                
                                    repetida = false;
                                
                                }                                
                            }
                            
                            if (repetida.equals(false))
                                
                            {
                                aristas_.add(new Arista(0,(HashSet<Nodo>)
                                        conexion.clone()));   
                            }
                            
                            conexion.clear();
                            this.agregarNodo(nodosAgre[linea]);
                        }     
                    }                           
                linea = linea + 1;          
                }  
                palabras = s.split(" ");
                iteraciones_ = new Integer(palabras[0]);
            }
        return this;
    
    }   

    public Grafo leerArbolRB(String archivoEntrada)
      throws IOException 
    
            // Metodo que lee el mapa de la reina blanca y construye un arbol
            
    {
        int i;
        File file = new File (archivoEntrada);
        FileReader fileReader = new FileReader(file);
        
           try (BufferedReader in = new BufferedReader(fileReader)) 
            {
                String s; 
                String[] palabras; 
                int localidades; // Entero done guardaremos el numero de nodos
                int linea; // Entero con el cual ubicaremos la linea en la que
                           // estamos
                HashSet<Nodo> conexion = new HashSet<Nodo>();
                Boolean repetida;
                repetida = false;

                
                s = in.readLine();
                localidades = (new Integer(s));
                Nodo[] nodosAgre = new Nodo[localidades + 1];                
                
                for(i = 0; i < localidades; i++)
                    
                { 
                    nodosAgre[i] =(new Nodo(("localidad " + (
                            new Integer(i + 1)).toString())));
                }       
                
                linea = 0;
                
                // En el resto del archivo leeremos la matriz de adyacencia
                // para crear las aristas y las adyacencias  
                
                while ((s = in.readLine()) != null )
                    
                {
                    
                    palabras = s.split("");
                    
                    for(i = 0; i < palabras.length; i++)
                        
                    {
                        
                        if (!(palabras[i].equals(".")) && !(palabras[i].
                                equals("0")) && (i != linea))
                        
                        {
                            
                            conexion.add(nodosAgre[linea]);
                            conexion.add(nodosAgre[i]);
                            
                            // Si quiero contar los bucles como adyacencias
                            // ponemos 
                            // nodosAgre[linea].agregarAdyacente(conexiones);
                            
                            nodosAgre[linea].agregarAdyacente(nodosAgre[i]);
                            
                            nodosAgre[linea].agregarArista(new Arista(
                                    (new Integer(palabras[i])),
                                    conexion));
                            Arista verifica;
                            verifica = (new Arista((new Integer(palabras[i])),
                                    conexion));
                            
                            for (Arista arista : aristas_)
                            
                            {
                            
                                if ((verifica.obtenerCosto().equals(arista.
                                        obtenerCosto())) && (verifica.
                                        obtenerIncidentes().equals(
                                        arista.obtenerIncidentes())))
                                    
                                {
                                
                                    repetida = true;
                                    break;
                                
                                }
                                
                                
                                if (!((verifica.obtenerCosto().equals(arista.
                                        obtenerCosto())) && (verifica.
                                        obtenerIncidentes().equals(arista.
                                        obtenerIncidentes()))))
                                    
                                {
                                
                                    repetida = false;
                                
                                }                                
                            }
                            
                            if (repetida.equals(false))
                                
                            {
                                aristas_.add(new Arista((new Integer(
                                palabras[i])), (HashSet<Nodo>) 
                                        conexion.clone()));   
                            }
                            
                            conexion.clear();
                            this.agregarNodo(nodosAgre[linea]);
                        }     
                    }       
                linea = linea + 1;          
                }     
            }
        return this;
    
    }              
    
    public int crearDisputas()

		// Metodo que calcula el minimo numero de disputas que deben
		// ser creadas por la reina roja para cortar la comunicacion con al 
		// menos una localizacion
            
    {
        List<Nodo> nodosConectados = new ArrayList();
        Arista aristaAgregar;
        Nodo[] incidentes; // Arreglo que usaremos para manejar los nodos
                             // incidentes a las aristass

        // Se inicializa la estructura de conjuntos disjuntos con todos los
        // nodos del grafo a separar
        
        ConjuntoDisjunto bosqueB = new ConjuntoDisjunto();       
        
        hojas_.stream().forEach((nodos) -> 
        {
            bosqueB.makeSet(nodos);
        });

        // Se inicializa la estructura de cola aleatorizada con todos las
        // aristas del grafo a separar        
                
        ColaAleatorizada colaAle = new ColaAleatorizada();        
        colaAle.insertarVarios((HashSet<Arista>) aristas_);
        
        // Inicializamos una arista y un conjunto de aristas que usaremos para
        // manejar los valores
        
        HashSet<Arista> aristas = new HashSet<Arista>();
        Arista aristaUsar = new Arista(0);
        
        int conjuntos = hojas_.size(); // Guardamos el numero de conjuntos
                                       // originales
        
        int minimoCorte = 0; // Inicializamos la variable resultado     
        
        // Volvemos conjuntos disjuntos a los nodos indicidentes a las aristas
        
        for (Arista aristas1 : colaAle.obtenerElementos())  
        {            
            for (Nodo incidentes1 : aristas1.obtenerIncidentes())
            {
                bosqueB.makeSet(incidentes1);            
            }        
        }  

        //    Mientras la cola no este vacia:
    
        
        while (!(colaAle.vacio()))
        
        {
            //  - Se selecciona un lado
            
            aristaUsar = colaAle.extraerAzar();
            incidentes = ((aristaUsar).obtenerIncidentes()).toArray(
                    new Nodo[2]);  
            
            // Comprobamos que no estamos trabajando con la misma componente
            
            if (bosqueB.find(incidentes[0]).equals(bosqueB.find(incidentes[1])))
                
            {
                System.out.println("no se agrego nada");  
            }

            // Si al unir los conjuntos que corresponden ambos extremos del
            // lado la cantidad de conjuntos disjuntos se hace 1, se descarta
            // ese lado, de lo contrario se unen los conjuntos                
            
            if (!(bosqueB.find(incidentes[0]).equals(
                    bosqueB.find(incidentes[1]))))
                
            {
                if (conjuntos - 1 <= 1)
                
                {
                    minimoCorte = minimoCorte + 1;
                }
                
                if (conjuntos - 1 > 1)
                    
                {
                bosqueB.Union(incidentes[0],incidentes[1]);                
                nodosConectados.add(incidentes[0]);
                nodosConectados.add(incidentes[1]);
                aristas.add(aristaUsar);
                conjuntos = conjuntos - 1;
                }
            }
        }
        
        // Se reporta la cantidad de lados descartados como el corte
        // minimo del grafo        
        return minimoCorte; 
    }       
    
    public int minimizarMonedas()

		// Metodo que calcula el camino de costo minimo para alcanzar
		// a todos los nodos del grafo
            
    {
        
        /*  Funciona de la siguiente manera:


            2) 
            3) 
            4) 
        */
        
        HashSet<Arista> aristas = new HashSet<Arista>();  
        aristas.addAll(aristas_);
        List<Nodo> nodosConectados = new ArrayList(); // Lista para manejar
                                                      // los nodos incidentes
                                                      // a las aristas
        Arista aristaAgregar; // Variable para manejar las operaciones
        int monedas = 0; // Inicializamos la variable resultado
        
        // Comparador que usaremos para ordenar la cola de prioridades
        
        Comparator<Arista> comparator = new Comparator<Arista>() 
        
        {
            @Override
            public int compare(Arista o1, Arista o2) 
            {
                return (o1.obtenerCosto()).compareTo(o2.obtenerCosto());
            }
        };
        
        // Se crea un conjunto C que contenga a todas las aristas del grafo que
        // es una cola de prioridades
        
        PriorityQueue<Arista> cola = new PriorityQueue<Arista>(aristas_.size(), 
                (Arista o1, Arista o2) -> 
                        (o1.obtenerCosto()).compareTo(o2.obtenerCosto()));
        
        cola.addAll((HashSet<Arista>) aristas_);
        ConjuntoDisjunto bosqueB = new ConjuntoDisjunto();
        Nodo[] incidentes; // 
        
        // se crea un bosque B (un conjunto de árboles), donde cada vértice 
        // del grafo es un árbol separado
        
        for (Nodo nodos : hojas_ )
        
        {
            bosqueB.makeSet(nodos);
        }
        
        for (Arista aristas1 : cola)
        {
            for (Nodo incidentes1 : aristas1.obtenerIncidentes())
            {
                bosqueB.makeSet(incidentes1);
            }
        
        }

        while (!(cola.isEmpty()))
        
        {
            // eliminar una arista de peso mínimo de C
                    
            incidentes = (cola.peek().obtenerIncidentes()).toArray(new Nodo[2]);  
            
            // si esa arista conecta dos árboles diferentes se añade al bosque, 
            // combinando los dos árboles en un solo árbol en caso contrario, se 
            // desecha la arista
            
            if (bosqueB.find(incidentes[0]).equals(bosqueB.find(incidentes[1])))
                
            {        
                cola.remove();     
            }
            
            if (!(bosqueB.find(incidentes[0]).equals(
                    bosqueB.find(incidentes[1]))))
                
            {
                bosqueB.Union(incidentes[0],incidentes[1]);                
                nodosConectados.add(incidentes[0]);
                nodosConectados.add(incidentes[1]);
                aristas.add(cola.poll());                
            }

        }
        
        for (Arista aristas2 : aristas)
        
        {
        
            monedas = monedas + aristas2.obtenerCosto();
            
        }
        
        return monedas;
            
    }
    
    public void imprimir()
                
        // Metodo que imprime todos los nodos del grafo junto con sus conjuntos
        // de adyacencia                
                
        { 
            int i = 0; // Inicio el mensajes para saber cuando estoy en el
                       // ultimo nodo
            //System.out.println();
            //System.out.println("Los Nodos Del grafo son: ");
            System.out.println();
            System.out.println("---------------------------");
            System.out.println();
            
            for (Nodo hojas : hojas_) // Recorro todos los nodos del conjunto 
                                      // ir imprimiendolos 1 a 1

            {

                hojas.imprimir();
                i = i + 1;
                       
            }
                               
            System.out.println();
            System.out.println("---------------------------");
            System.out.println();
        }        
}
