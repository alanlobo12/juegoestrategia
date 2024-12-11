package juegoestrategia;

abstract class Personaje {
    protected String nombre;
    protected int vida;
    protected int fuerza;
    protected int defensa;

    public Personaje(String nombre, int vida, int fuerza, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public abstract void habilidadEspecial(Personaje enemigo);

    public void atacar(Personaje enemigo) {
        int daño = Math.max(fuerza - enemigo.defensa, 0);
        enemigo.vida -= daño;
        System.out.println(nombre + " ataca a " + enemigo.nombre + " causando " + daño + " de daño.");
    }

    public void mostrarEstado() {
        System.out.println(nombre + " - Vida: " + vida + ", Fuerza: " + fuerza + ", Defensa: " + defensa);
    }
}