package juegoestrategia;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    private ArrayList<Personaje> jugadores = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciarJuego();
    }
    
    public void iniciarJuego() {
        System.out.println("Bienvenido al juego de estrategia por turnos!");
        crearJugadores();
        jugar();
    }

    private void crearJugadores() {
        System.out.println("Creando jugadores...");
        jugadores.add(new Guerrero("Guerrero A"));
        jugadores.add(new Mago("Mago B"));
        jugadores.add(new Arquero("Arquero C"));
        jugadores.add(new Guerrero("Guerrero D"));
        jugadores.add(new Mago("Mago E"));
    }

    private void jugar() {
        while (jugadores.stream().filter(Personaje::estaVivo).count() > 1) {
            for (int i = 0; i < jugadores.size(); i++) {
                Personaje jugador = jugadores.get(i);
                if (jugador.estaVivo()) {
                    System.out.println("\nTurno de " + jugador.nombre);
                    jugador.mostrarEstado();

                    Personaje enemigo = seleccionarEnemigo(jugador);
                    if (enemigo != null) {
                        System.out.println("1. Atacar\n2. Habilidad Especial");
                        int opcion = scanner.nextInt();

                        if (opcion == 1) {
                            jugador.atacar(enemigo);
                        } else if (opcion == 2) {
                            jugador.habilidadEspecial(enemigo);
                        }

                        if (!enemigo.estaVivo()) {
                            System.out.println(enemigo.nombre + " ha sido derrotado!");
                        }
                    }
                }
            }
        }

        System.out.println("\nEl juego ha terminado!");
        jugadores.stream().filter(Personaje::estaVivo).forEach(j -> System.out.println(j.nombre + " es el ganador!"));
    }

    private Personaje seleccionarEnemigo(Personaje jugador) {
        System.out.println("Selecciona un enemigo:");
        for (int i = 0; i < jugadores.size(); i++) {
            Personaje enemigo = jugadores.get(i);
            if (enemigo != jugador && enemigo.estaVivo()) {
                System.out.println(i + ". " + enemigo.nombre);
            }
        }

        int seleccion = scanner.nextInt();
        if (seleccion >= 0 && seleccion < jugadores.size()) {
            return jugadores.get(seleccion);
        }
        System.out.println("Selección inválida.");
        return null;
    }

    
}