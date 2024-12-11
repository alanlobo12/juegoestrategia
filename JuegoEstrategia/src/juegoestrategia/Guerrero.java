
package juegoestrategia;

class Guerrero extends Personaje {
    public Guerrero(String nombre) {
        super(nombre, 150, 30, 20);
    }

    @Override
    public void habilidadEspecial(Personaje enemigo) {
        System.out.println(nombre + " usa 'Golpe Fuerte' contra " + enemigo.nombre + "!");
        int daño = fuerza * 2;
        enemigo.vida -= daño;
        System.out.println("Causa " + daño + " de daño.");
    }
}

