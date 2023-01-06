public interface LogicaJuego {

    //metodos que necesitaremos para desarrolar la logica del juego
    public void barajear();
    public void jugadores_de_partida(int x);
    public void darcartas();
    public void darCarta(int jugador);
    public void carta(int x);
    public void mostrarMano(int jugador);
    public void quitarCarta(int jugador, int posicion);
    
    
}
