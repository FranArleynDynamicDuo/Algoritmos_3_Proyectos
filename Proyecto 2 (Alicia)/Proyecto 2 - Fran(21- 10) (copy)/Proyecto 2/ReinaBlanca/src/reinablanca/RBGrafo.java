/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Servicio Alicia
 * Clase Grafo
 */
package reinaroja;
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
        {
            return iteraciones_;
        }
        
        public HashSet <Nodo> obtenerNodos() 
                
        // Metodo que obtiene el conjunto de nodos en el grafo, asi pueden 
        // usarse o guardarse                
                
        {      
            return hojas_; // Retorna el conjunto de los nodos del grafo    
        }    

        public HashSet <Arista> obtenerRRAristas() 
                
        // Metodo que obtiene el conjunto de nodos en el grafo, asi pueden 
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
        
        public Grafo removerNodo(Nodo hoja)
                
        // Metodo que remueve un nodo del conjunto de nodos del grafo  
                
        {
            
            hojas_.remove(hoja); // Removemos el nodo
            return this;
                
        } 
          
        
        // COMPLEX METHODS.        
    public Grafo leerArbolRB(String archivoEntrada)
      throws IOException 
    
    {
        int i;
        Nodo[] nodosAgre = new Nodo[50];
        File file = new File (archivoEntrada);
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

                
                s = in.readLine();
                localidades = (new Integer(s));
                
                
                for(i = 0; i < localidades; i++)
                    
                {
                    
                    nodosAgre[i] =(new Nodo(("localidad " + (
                            new Integer(i + 1)).toString())));
                    
                }       
                
                linea = 0;
                
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
    public Grafo leerArbolRR(String archivoEntrada)
      throws IOException 
    
    {
        int i;
        File file = new File (archivoEntrada);
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

                
                s = in.readLine();
                localidades = (new Integer(s));
                Nodo[] nodosAgre = new Nodo[localidades + 1];
                
                
                for(i = 0; i < localidades; i++)
                    
                {    
                    nodosAgre[i] =(new Nodo(("localidad " + (
                            new Integer(i + 1)).toString())));
                }       
                
                linea = 0;
                
                while ((s = in.readLine()) != null && (linea < localidades) )
                    
                {
                    
                    palabras = s.split("");
                    
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
                                    0,conexion));
                            Arista verifica;
                            verifica = (new Arista(0,conexion));
                            
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
        
    
    public int crearDisputas()
            
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
            
    {
        
        /*  Funciona de la siguiente manera:

            1) se crea un bosque B (un conjunto de árboles), donde cada vértice 
            del grafo es un árbol separado
            2) se crea un conjunto C que contenga a todas las aristas del grafo
            mientras C es no vacío
            3) eliminar una arista de peso mínimo de C
            4) si esa arista conecta dos árboles diferentes se añade al bosque, 
            combinando los dos árboles en un solo árbol en caso contrario, se 
            desecha la arista
        */
        
        HashSet<Arista> aristas = new HashSet<Arista>();  
        aristas.addAll(aristas_);
        List<Nodo> nodosConectados = new ArrayList();
        Arista aristaAgregar;
        int monedas;
        monedas = 0;
        int nivel;
        nivel = 0;
        
        //HashSet<Nodo> nodosConectados = new HashSet<Nodo>();
        //Nodo[] nodosConectados = new Nodo[hojas_.size() + 1];
        
        Comparator<Arista> comparator = new Comparator<Arista>() 
        
        {

            @Override
            public int compare(Arista o1, Arista o2) 
            {
                return (o1.obtenerCosto()).compareTo(o2.obtenerCosto());
            }
        };
        
        
        PriorityQueue<Arista> cola = new PriorityQueue<Arista>(50, new 
        Comparator<Arista>()
        
        {
            public int compare(Arista o1, Arista o2) 
            {
                return (o1.obtenerCosto()).compareTo(o2.obtenerCosto());
            }
            
        });
        
        cola.addAll((HashSet<Arista>) aristas.clone());
        ConjuntoDisjunto bosqueB = new ConjuntoDisjunto();
        aristas.clear();

        Nodo[] incidentes; 
        
        
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
        
            incidentes = (cola.peek().obtenerIncidentes()).toArray(new Nodo[2]);  
            System.out.println("El tamaño de la cola es " + cola.size());
            System.out.println("El costo de la arista actual es " + 
                    cola.peek().obtenerCosto());
            System.out.println();
            System.out.println("Los nodos incidentes a la arista actual son ");
            System.out.println(incidentes[0].obtenerNombre());
            System.out.println(incidentes[1].obtenerNombre());
            System.out.println();
            System.out.println("El find de cada nodo es ");
            System.out.println(bosqueB.find(incidentes[0]).obtenerNombre());
            System.out.println(bosqueB.find(incidentes[1]).obtenerNombre());
            System.out.println();
            
            if (bosqueB.find(incidentes[0]).equals(bosqueB.find(incidentes[1])))
                
            {
            
                cola.remove();
                System.out.println("no se agrego nada");
                
            }
            
            if (!(bosqueB.find(incidentes[0]).equals(
                    bosqueB.find(incidentes[1]))))
                
            {
                
                bosqueB.Union(incidentes[0],incidentes[1]);                
                nodosConectados.add(incidentes[0]);
                nodosConectados.add(incidentes[1]);
                aristas.add(cola.poll());
                System.out.println("SE AGREGO UNA ARISTA");
                System.out.println();
                
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
