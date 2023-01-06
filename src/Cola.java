//Creamos la clase Cola para almacenar la baraja
public class Cola {
	/*clase Nodo para que la Cola 
    sea de almacenanimiento dinamico*/
	public class Nodo
    {
		//Variable entera que almacena el numero de la carta
		int dato;
		//Nodo que relaciona con el nodo siguiente
		Nodo sgn;
	}
	/*Creamos los dos nodos que usaremos para
	la interaccion con la cola*/
	Nodo raiz, fondo;
	//Constructor de la cola para asignar valores nulos
	//a la raiz y al fondo
	Cola(){
		raiz = null;
		fondo = null;
	}
	//Funcion de tipo boolean para saber si la cola
	//tiene algo o se encuentrea vacia
	boolean vacia(){
		if (raiz == null)
			return true;
		else
			return false;
	}
	//Funcion para agregar un elemento a la cola
	//el elemento nuevo es enviado por parametro de la cola
	//es de tipo entero
	public void agregar(int x)
    {
		//Nodo auxiliar para poder interactuar con la cola
		Nodo nuevo;
		nuevo = new Nodo();
		//asignamos el valor enviado a el valor que alamacena el nodo
		nuevo.dato = x;
		//asignamoso el valor de nulo al nodo siguiente ya
		//que posterior mente se convertira en el ultimo
		//nodo en ser arreglado.
		nuevo.sgn = null;
		//Verificamos que la cola no esta vacia
		if (vacia()) 
        {
			//En caso de que la cola este vacia apunto a la raiz
			//y al fondo hacia el mismo nodo.
			raiz = nuevo;
			fondo = nuevo;
		}
        else
        {
			//En caso de que no este vacia la cola apunto el nodo
			//fondo en siguiente al nodo nuevo para poder unirlo
			//a la cola y luego apunto el fondo al nodo nuevo
			fondo.sgn = nuevo;
			fondo = nuevo;
		}
	}
	int mostrar()
    {
		//Creo una variable que le asigno el valor del nodo raiz
		int info = raiz.dato;
		//Verifico que el raiz apunte al mismo nodo que fondo
		if (raiz == fondo) 
        {
			//En caso de que raiz apunte al mismo nodo que fondo
			//le afigno los valores de null a raiz y a fondo
			//para vaciar la cola.
			raiz = null;
			fondo = null;
		}
        else
        {
			//En caso de que raiz no apunte al mismo nodo que fondo
			//hago que raiz apunte al nodo siguiente del cual el apunta.
			raiz = raiz.sgn;
		}
		//Retornamos el valor que se encuantra en la variable info.
		return info;
	}
}

