class Libro extends entidad {
    String ISBN;
    String autor;
    String editorial;
    int anoPublicacion;
    char genero;
    int numeroDeCopias;
    String estado;
    Persona prestadoA; // Persona a quien está prestado el libro
    
    public Libro(String nombre, String codigo, String ISBN, String autor, String editorial, int anoPublicacion, char genero, int numeroDeCopias, String estado) {
        super(nombre, codigo);
        this.ISBN = ISBN;
        this.autor = autor;
        this.editorial = editorial;
        this.anoPublicacion = anoPublicacion;
        this.genero = genero;
        this.numeroDeCopias = numeroDeCopias;
        this.estado = estado;
        this.prestadoA = null; // Inicialmente, el libro no está prestado
    }
    
    public void Imprimir() {
        super.imprimir();
        System.out.println("ISBN: " + ISBN);
        System.out.println("Autor: " + autor);
        System.out.println("Editorial: " + editorial);
        System.out.println("Año de Publicación: " + anoPublicacion);
        System.out.println("Género: " + genero);
        System.out.println("Número de Copias: " + numeroDeCopias);
        System.out.println("Estado: " + estado);
        if (prestadoA != null) {
            System.out.println("Prestado a: " + prestadoA.nombre);
        }
        System.out.println();
    }
}
