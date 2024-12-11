package juegoestrategia;

class Mago extends Personaje {
    public Mago(String nombre) {
        super(nombre, 100, 20, 10);
    }

    @Override
    public void habilidadEspecial(Personaje enemigo) {
        System.out.println(nombre + " usa 'Bola de Fuego' contra " + enemigo.nombre + "!");
        int daño = 50;
        enemigo.vida -= daño;
        System.out.println("Causa " + daño + " de daño.");
    }
}
