JUEGO DE CARTAS EN JAVA APLICANO POO.

IMPLEMENTACION:

Inicialmente tenemos la interfaz LogicaJuego, en la cual declaramos los métodos que va a tener la lógica del juego, estos métodos son: barajear, jugadores de partida, dar cartas, carta, mostrar mano y quitar carta, cabe aclarar que estos métodos son de tipo void, es decir, que no retornan ningún valor.
Esta interfaz es implementada por la clase ‘Juego’ donde va tenerla lógica del mismo e implementará los métodos que están en la interfaz, esta clase utiliza una lista enlazada de tipo cola, entonces si vamos a la clase ‘Cola’ tenemos dos atributos públicos, en este caso, los cuales son; raíz y fondo, que vendría siendo la cola de cartas. Estos atributos son de tipo Nodo, si vamos a la clase ‘Nodo’, tenemos dos atributos, el primero es el dato, en este atributo se va aguardar el dato en la lista enlazada, y tenemos otro atributo de tipo Nodo el cual va tener la referencia del siguiente dato y para finalizar tiene el constructor por defecto con sus getters y setters. En la clase cola igualmente tenemos el constructor por defecto, también tenemos el método agregar, el cual recibirá el dato que se guardará en la lista, tenemos el método mostrar, es el que nos va a devolver el dato que está en la cola de cartas y por último tenemos el método vacía, que nos indica si la lista está vacía. 
Finalmente tenemos la clase Servidor, aquí se encuentra el método main y es aquí donde utilizamos una instancia de la clase Juego para iniciar la simulación del juego.


REGLAS  DE JUEGO:


En el juego usaremos una baraja compuesta por 52 cartas. Además tendremos un mínimo de 2 jugadores y un máximo 4, lo cual se deben especificar por consola al momento de iniciar el juego.

Las reglas de este juego serán las siguientes:

1. Mezclar la baraja y repartir 6 cartas a cada jugador, se deja un mazo a parte para las cartas sobrantes.
2. Se le asigna un turno a cada jugador y el que inicia por defecto, es el jugador 1. 	
3. El juego se desarrolla por turnos, cada jugador puede cambiar una sola carta por turno.
4. Los jugadores deben saber cual carta cambiar al momento del turno, el juego consiste en obtener tres parejas del mismo rango en su mazo de 6 cartas o conseguir 2 tríos del mismo rango (Es válido si las cartas son del mismo rango pero de diferente mazo.)
5. El ganador será el primer jugador que consiga las tres parejas o los dos trios en su respectivo mazo.

EJEMPLO:

        ✭TURNO DEL JUGADOR 2✭


1-CORAZONES ♥️ ➤ Rey
2-TREVOLES ♣️ ➤ Rey
3-CORAZONES ♥️ ➤ Reina
4-CORAZONES ♥️ ➤ As
5-DIAMANTES ♦️ ➤ As
6-DIAMANTES ♦️ ➤ Reina

        ::::::::::::::::::
        EL JUGADOR 2 GANÓ.
        ::::::::::::::::::

OTRA MANERA DE GANAR:

EJEMPLO:

✭TURNO DEL JUGADOR 2✭


1-TREVOLES ♣ ➤ 6
2-CORAZONES ♥ ➤ 6
3-TREVOLES ♣ ➤ Rey
4-CORAZONES ♥ ➤ Rey
5-DIAMANTES ♦ ➤ 6
6-DIAMANTES ♦ ➤ Rey

        ::::::::::::::::::
        EL JUGADOR 2 GANÓ.
        ::::::::::::::::::
