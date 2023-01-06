/*Creamos la clase juego en la cual se encuentran las funciones 
para hacer los distintos procesos que necesita el juego para
funcionar.*/
import java.util.Random;
public class Juego implements LogicaJuego
{
    //Variable en la cual esta el numero de jugadores de esta partida.
	int jugadores=0;
	//Arreglo bidimencional que funciona como mano de los jugadores
	//el primer campo hace referencia al jugador y el segundo a
	//las cartas que tenga en su mano dicho jugador.
	int mano[][] = new int[4][6];
	//Arreglo que hace referencia a la carta que tendra libre el jugador 
	//o la carta que se usara para poder hacer el cambio de cartas.
	int cartaLibre[][] = new int[4][1];
	//Arreglo que verifica que todos las cartas sean pares
	//En caso de que alguna carta no sea par le asigna a la
	//posicion el valor de falso.
	boolean mano2[] = new boolean[6];
	//Variable que lleva el control del juego.
	//Esta variable es usada para hacer el ciclo de repeticion 
	//mientras ningun jugador gane.
	boolean ganador = false;
	//Se crea una cola que servira como el maso de las cartas que
	//no esten en las manos de los jugadores
	Cola maso = new Cola();
	//Funcion que agrega las cartas al maso.
	//Usa un random para no llevar un orden.
	public void barajear(){
		//Creo el objeto random
		Random rand = new Random();
		//Un arreblo del tamaño de las cartas que hay en un juego.
		//Es de valor booleano ya que si la carta ya fue agregada
		//al maso se agrega el valor false para no repetir dicha carta.
		boolean arr[] = new boolean[52];
		//Variable que es usada para almacenar el numero random
		int num;
		//Variable que lleva el contador de cuantas cartas han sido agregadas
		//al llegar a 52 hacer que se termine el ciclo de repeticion
		//ya que se considera que todas las cartas han sido agregadas
		int con=0;
		//For que es usado para asginar a todas las cartas en la
		//baraja el valor de true que indica que esta disponible 
		//para ser agregado al maso.
		for (int i=0;i<52 ;arr[i++] = true);
		//Ciclo de repeticion el cual terminara cuando el valor
		//del contador sea igual a 52.
		while (con != 52) {
			//Se el asigna a num el valor de un numero
			//aleatorio de entre 0 y 51
			num = rand.nextInt(52);
			//Verifico que dicha carta no haya sido agregada con
			//anterioridad al maso.
			if (arr[num]){
				//En caso de no ser agregada anteriormente
				//le asigno el valor de false para no volver
				//a ser agregada
				arr[num] = false;
				//agrego al maso el valor del numero asignado mas 1
				maso.agregar(num+1);
				//Incremento en 1 el valor del contador
				con++;
			}
		}
	}
	//Funcion que asigna el numero de jugadores al la variable jugadores
	public void jugadores_de_partida(int x){jugadores = x;}
	//Funcion que da las primeras 5 cartas a los jugadores
	public void darcartas(){
		//For que es usado para poder recorrer a todos los jugadores
		//de la partida
		for (int i = 0;i < jugadores; i++ ) {
			//For que es usado para poder recorrer las primeras 5 cartas
			//de la mano de cada jugador
			for (int j = 0;j <5 ; j++ ) {
				//Le agrego a la mano del jugador las cartas que son extraidas
				//del maso en el orden que fueron agregadas.
				mano[i][j] = maso.mostrar();
			}
			//Asigno a cada jugador la posicion de la carta que hace falta
			cartaLibre[i][0]=5;
		}
	}
	//Variable que retorna el estado de la partida ya que si hay un ganador el juego tiene que terminar
	boolean hayGanador(){return ganador;}
	//Funcion para asignar una carta a la mano del jugador
	//en la posicion donde se encuentre con una carta libre.
	public void darCarta(int jugador){
		mano[jugador][cartaLibre[jugador][0]] = maso.mostrar();
	}
	//Funcion para mostrar el tipo y el valor de la carta
	public void carta(int x){
		//Variables que son usadas para llevar el control
		//del tipo de carta (picas, Diamantes, Trevoles, Corazones)
		//y el valor de dicha carta (As,2,3,4,5,6,7,8,9,10,Jack,Queen,Rey)
		int tipo;
		int valor;
		/*Divido la carta entre 13 (13 es el numero total de cartas que hay en cada palo)
		para poder sacar que tipo es (0,1,2,3... despues se asigna lo de picas, corazones, etc)*/
		tipo = x/13;
		/*Sacamos lo que resta de la divicion de el valor de la carta entre 13
		de esa forma el valor de la carta que ocupa en dicho palo*/
		valor = x%13;
		//En caso de que el valor sea igual a 0 (Que es el caso en el cual los reyes caen)
		if (valor == 0) {
			//le resto 1 a tipo para optener su valor real en el juego
			tipo--;
			//Le asigno el valor de 13 a valor
			valor = 13;
		}
		/*Usamos un switch para imprimir el tipo de palo al que pertenece cada carta*/
		switch (tipo) {
			case 0:
				System.out.print("PICAS ♠️");
			break;
			case 1:
				System.out.print("DIAMANTES ♦️");
			break;
			case 2:
				System.out.print("TREVOLES ♣️");
			break;
			case 3:
				System.out.print("CORAZONES ♥️");
			break;
		}
		//Imprimo 3 guiones medios solo para marcar una separacion entre el valor de la carta y el tipo
		System.out.print(" ➤ ");
		//Uso un switch para poder imprimir el valor correspondiente a la carta
		switch (valor) {
			case 1:
				System.out.println("As");
			break;
			case 11:
				System.out.println("Jota");
			break;
			case 12:
				System.out.println("Reina");
			break;
			case 13:
				System.out.println("Rey");
			break;
			default:
				System.out.println(valor);
			break;
		}
	}
	//Funcion que es usada para imprimir la mano del jugaro
	public void mostrarMano(int jugador){
		//Recorre todas las posiciones de la mano del jugador
		for (int i = 0;i < 6 ; i++ ) {
			//Imprimo el valor de la posicion y un guion para
			//hacer una pequeña separacion.
			System.out.print((i+1)+"-");
			//llamomos a la funcion que me imprime el valor de la carta
			this.carta(mano[jugador][i]);
		}
	}
	//Funcion que verifica que el jugador gano
	boolean gano(int jugador){
		//For que le asigna a mano2 el valor de false
		for (int i=0;i<6 ;mano2[i++]= false );
		//For que visita todas las cartas del jugador
		for (int i = 0;i<6 ;i++ )
			//For que va a comparar las cartas
			for (int j=0;j<6 ;j++ )
				//Validamos que no este comparando la misma carta
				if (i != j) 
					//Sacamos el modulo de las dos cartas y los comparo
					if((mano[jugador][i]%13) == (mano[jugador][j]%13))
						//Si son iguales indicamos que dicha posicion si tiene un par
						mano2[i] = true;
		//Nuevamente visitamos el valor de todas las cartas en la mano del jugador
		for (int i=0;i<6 ;i++ ) {
			//validamos que sea par
			if (!mano2[i]) {
				//en caso de no ser par retornamos como valor false
				//que indica que el jugador aun no gana
				return false;
			}
		}
		//En caso de que todas las cartas tengan un par
		//retornamos el valor de true lo cual indica que
		//el jugador gano
		return true;
	}
	//Funcion que es usada para quitar una carta de
	//la mano del jugador y volverla a agregar al maso.
	//Esta funcion recibe como parametros el jugador
	//que va a quitar la carta y la posicion de dicha carta
	public void quitarCarta(int jugador, int posicion){
		//Indicamos que la carta libre esta en la posicion que se envio
		cartaLibre[jugador][0]= posicion-1;
		//Agregamos el valor de dicha posicion de la mano del jugador
		//al maso para que vuleva a estar en juego la carta
		maso.agregar(mano[jugador][posicion-1]);
	}
	
}

