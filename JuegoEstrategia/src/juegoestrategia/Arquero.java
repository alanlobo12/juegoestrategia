package juegoestrategia;

class Arquero extends Personaje {
    public Arquero(String nombre) {
        super(nombre, 120, 25, 15);
    }

    @Override
    public void habilidadEspecial(Personaje enemigo) {
        System.out.println(nombre + " usa 'Disparo Preciso' contra " + enemigo.nombre + "!");
        int daño = fuerza + 30;
        enemigo.vida -= daño;
        System.out.println("Causa " + daño + " de daño.");
    }
}
