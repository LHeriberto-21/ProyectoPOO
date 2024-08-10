import java.util.Scanner;

public class Biblioteca {
    Libro[] libros;
    
    public Biblioteca() {
        libros = new Libro[3];

        libros[0] = new Libro("El Quijote", "001", "978-3-16-148410-0", "Miguel de Cervantes", "Editorial A", 1605, 'F', 4, "Disponible");
        libros[1] = new Libro("Cien Años de Soledad", "002", "978-0-14-028333-4", "Gabriel García Márquez", "Editorial B", 1967, 'F', 1, "Disponible");
        libros[2] = new Libro("Don Juan Tenorio", "003", "978-0-452-28423-4", "José Zorrilla", "Editorial C", 1844, 'D', 2, "Disponible");
    }
    
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Menu");
            System.out.println("1. Prestar un libro");
            System.out.println("2. Libros disponibles");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción:");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (option) {
                case 1:
                    prestar();
                    break;
                case 2:
                    librosDisponibles();
                    break;
                case 3:
                    devolver();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema:D...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 4);
        scanner.close();
    }
    
    public void prestar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        String Nombre = scanner.nextLine();
        System.out.println("Ingrese su código:");
        String codigo = scanner.nextLine();
        Persona persona = new Persona(Nombre, codigo);
        
        System.out.println("Selecciona el título del libro:");
        String titulo = scanner.nextLine();
        
        for (Libro libro : libros) {
            if (libro != null && libro.nombre.equalsIgnoreCase(titulo) && libro.numeroDeCopias > 0) {
                libro.numeroDeCopias--;
                libro.prestadoA = persona;
                System.out.println("Se ha prestado: " + libro.nombre + " a " + Nombre);
                return;
            }
            scanner.close();
        }
        System.out.println("No está disponible o no se encontró el libro.");
    }
    
    public void devolver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro a devolver:");
        String titulo = scanner.nextLine();
        
        for (Libro libro : libros) {
            if (libro != null && libro.nombre.equalsIgnoreCase(titulo)) {
                libro.numeroDeCopias++;
                libro.prestadoA = null; // Libera la referencia de la persona
                System.out.println("Se ha devuelto: " + libro.nombre);
                return;
            }
            scanner.close();
        }
        System.out.println("No se encontró el libro.");
    }
    
    public void librosDisponibles() {
        System.out.println("Libros disponibles:");
        for (Libro libro : libros) {
            if (libro != null && libro.numeroDeCopias > 0) {
                libro.imprimir();
            }
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.menu();
    }
}

