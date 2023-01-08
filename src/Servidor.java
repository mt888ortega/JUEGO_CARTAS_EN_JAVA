import java.lang.ArrayIndexOutOfBoundsException;
import java.util.InputMismatchException;
import java.lang.NullPointerException;
import java.util.Scanner;

public class Servidor 
{
    //Funcion main :D
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, InputMismatchException, java.lang.NullPointerException
    {
		//Creamos las variables y objetos que necesitaremos para llevar el control del juego
		//op es usada para asignarle valores por teclado
		int op=0;
		//Turno es usado para llevar el control de que jugador esta al mando por el momento
		int turno = 0;

		try (//Creamos el objeto para poder asignar los valores a traves del teclado
        Scanner in = new Scanner(System.in)) 
        {
            //Creamos el objeto de tipo juego.
            Juego p = new Juego();
            //Barajeamos el maso de cartas
            p.barajear();
            //Preguntamos cuantos jugadores habra en la partida.
            //si el valor es menor o igual a 1 vulevemos a preguntar
            //si es mayor a 4 vuelvemos a preguntar
			/*usamos los bloques try catch para imprimir un mensaje en dado caso 
			de que el usuario ingrese un valor invalido*/
        try{
			while(op <=1 || op >4){
				System.out.print("\nINGRESE EL NUMERO DE JUGADORES (2-4)\n➤");
				op = in.nextInt();} 
			}
		catch(InputMismatchException e){ 
				System.out.println("¡INGRESASTE UN PARAMETRO INVALIDO!");
			}
            //Indicamos cuantos jugadores hay en el juego
            p.jugadores_de_partida(op);
            //entregmos las cartas a los jugadores
            p.darcartas();
            //Verificamos que no hay gandor aun para poder repetir las veces que sean necesarias los turnos
            while(!p.hayGanador()){
            	//Le asignamos a turno el valor de 0 lo cual indica que el primer jugador es el que va a iniciar
            	turno = 0;
            	//se repite los turnos por cada jugador que hay en el juego
            	while(turno < p.jugadores) {
            		//Indicamos cual jugador lleva el turno
            		System.out.println("\n\n\t✭TURNO DEL JUGADOR "+(turno+1)+"✭\n\n");
            		//Le entregamos una carta al jugador
            		p.darCarta(turno); 
            		//Le mostramos al jugador su mano
            		p.mostrarMano(turno);
            		//Verificamos que el jugador haya ganado con los valores de sus cartas
            		if (p.gano(turno)) {
            			//En caso de que el jugador gane lo mostramos en pantalla
            			System.out.println("\t::::::::::::::::::\n\tEL JUGADOR "+(turno+1)+" GANÓ.\n\t::::::::::::::::::");
            			//Termina el juego
            			System.exit(0);
            		}else{
            			//En caso que no haya ganado el jugado
            			//a op le asignamos el valor de 0 para que se tenga que repetir el ciclo
            			op=0;
            		//Le preguntamos al jugador que carta quiere quitar de su mano
            		//Si el valor dado por el jugado es menor o igual a 0 o mayor
            		//a 6 le vuelvemos a preguntar.
			    /*usamos los bloques try catch para imprimir un mensaje en dado caso 
			    de que el usuario ingrese un valor invalido*/
			try {
				while(op <= 0 || op > 6){
					System.out.print("\n¿CUAL CARTA QUIERES QUITAR? ➤");
					op = in.nextInt();}
				//Llamamos a la funcion quitar carta y le paso como parametros
            	//los valores del jugador que tiene el mando y la posicion 
            	//De la carta que quiere quitar
				p.quitarCarta(turno,op);
			
			//Incrementamos en 1 el turno para que siga el jugador siguiente.
			turno ++;
				} 
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("¡INGRESATE UN PARAMETRO INVALIDO!");
				}
			catch (InputMismatchException e) {
				System.out.println("¡INGRESATE UN PARAMETRO INVALIDO!");
				}	
			catch (NullPointerException e) {
				System.out.println("¡INGRESATE UN PARAMETRO INVALIDO!");
				}	
            }
        }
    }	
}}}
