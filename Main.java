import java.util.Scanner;
import clases.*;

public class Main {
    // Scanner único para todo el programa:
    // - Lee datos desde teclado (System.in)
    // - static: permite usarlo en todos los métodos static de Main
    // - final: evita reasignarlo accidentalmente
    // - private: solo se usa dentro de esta clase
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ListaGenerica<Animal> animales = new ListaGenerica<>();
        ListaGenerica<Veterinario> veterinarios = new ListaGenerica<>();
        ListaGenerica<Atencion> atenciones = new ListaGenerica<>();

        sistema(animales, veterinarios, atenciones);

        scanner.close();
    }

    public static void sistema(ListaGenerica<Animal> animales,
                               ListaGenerica<Veterinario> veterinarios,
                               ListaGenerica<Atencion> atenciones) {

        int opcion;

        do {
            opcion = imprimirMenu();

            switch (opcion) {
                case 1:
                    agregarVeterinario(veterinarios);
                    break;

                case 2:
                    agregarAnimal(animales);
                    break;

                case 3:
                    atenderAnimal(animales, veterinarios);
                    break;

                case -1:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != -1);
    }

    private static void agregarAnimal(ListaGenerica<Animal> animales) {
        System.out.println("\n===== Sistema Veterinario ======");
        System.out.println("Ingrese 1 para agregar Perro");
        System.out.println("Ingrese 2 para agregar Gato");

        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion == 1) agregarPerro(animales);
        else if (opcion == 2) agregarGato(animales);
    }

    private static void agregarPerro(ListaGenerica<Animal> animales) {
       System.out.println("\n===== Datos Perro =====");

        System.out.print("Identificador: ");
        String id = scanner.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Raza: ");
        String raza = scanner.nextLine();

        Perro perro = new Perro(id, nombre, edad, raza);

        animales.addLast(perro);

        System.out.println("\nPerro agregado correctamente.");

        mostrarAnimal(animales);
    }

    private static void agregarGato(ListaGenerica<Animal> animales) {
       System.out.println("\n===== Datos Gato =====");

        System.out.print("Identificador: ");
        String id = scanner.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        Gato gato = new Gato(id, nombre, edad);

        animales.addLast(gato);

        System.out.println("\nGato agregado correctamente.");

        mostrarAnimal(animales);
    }

    public static int imprimirMenu() {

        System.out.println("\n===== Sistema Veterinario ======");
        System.out.println("Ingrese 1 para agregar veterinario");
        System.out.println("Ingrese 2 para agregar animal");
        System.out.println("Ingrese 3 para atender un animal");
        System.out.println("Ingrese -1 para salir");
        System.out.print("Opción: ");

        return Integer.parseInt(scanner.nextLine());
        
    }

    public static void agregarVeterinario(ListaGenerica<Veterinario> veterinarios) {

        System.out.println("\n===== Datos Veterinario =====");

        System.out.print("Rut: ");
        String rut = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        Veterinario vet = new Veterinario(rut, edad, nombre, "...", 0);

        veterinarios.addLast(vet);

        System.out.println("\nVeterinario agregado correctamente.");

        mostrarVeterinarios(veterinarios);
    }

    public static void mostrarVeterinarios(ListaGenerica<Veterinario> veterinarios) {

        if (veterinarios.isEmpty()) {
            System.out.println("No hay veterinarios registrados.");
            return;
        }

        System.out.println("\n===== Veterinarios en sistema =====");

        for (int i = 0; i < veterinarios.getSize(); i++) {
            Veterinario vet = veterinarios.get(i);

            if (vet != null) {
                System.out.println("Veterinario #" + (i + 1));
                System.out.println("Rut: " + vet.getRut());
                System.out.println("Nombre: " + vet.getNombre());
                System.out.println("Edad: " + vet.getEdad());
                System.out.println("--------------------------");
            }
        }
    }

    public static void mostrarAnimal(ListaGenerica<Animal> animales) {

        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }

        System.out.println("\n===== animales en sistema =====");

        for (int i = 0; i < animales.getSize(); i++) {
            Animal animal = animales.get(i);
            animal.obtenerDatos();
        }
    }

    public static void atenderAnimal(ListaGenerica<Animal> animales,
                                 ListaGenerica<Veterinario> veterinarios) {

        if (veterinarios.isEmpty()) {
            System.out.println("No hay veterinarios registrados.");
            return;
        }

        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }

        System.out.println("\n===== Atender Animal =====");

        System.out.println("\nVeterinarios disponibles:");
        for (int i = 0; i < veterinarios.getSize(); i++) {
            Veterinario vet = veterinarios.get(i);
            System.out.println("Rut: " + vet.getRut() + " | Nombre: " + vet.getNombre());
        }

        System.out.print("\nIngrese Rut del veterinario: ");
        String rutBuscado = scanner.nextLine();

        Veterinario veterinarioSeleccionado = null;

        for (int i = 0; i < veterinarios.getSize(); i++) {
            Veterinario vet = veterinarios.get(i);

            if (vet.getRut().equals(rutBuscado)) {
                veterinarioSeleccionado = vet;
                break;
            }
        }

        if (veterinarioSeleccionado == null) {
            System.out.println("Veterinario no encontrado.");
            return;
        }

        System.out.println("\nAnimales disponibles:");
        for (int i = 0; i < animales.getSize(); i++) {
            Animal animal = animales.get(i);
            System.out.println("ID: " + animal.getIdentificador() + " | Nombre: " + animal.getNombre());
        }

        System.out.print("\nIngrese ID del animal: ");
        String idBuscado = scanner.nextLine();

        Animal animalSeleccionado = null;

        for (int i = 0; i < animales.getSize(); i++) {
            Animal animal = animales.get(i);

            if (animal.getIdentificador().equals(idBuscado)) {
                animalSeleccionado = animal;
                break;
            }
        }

        if (animalSeleccionado == null) {
            System.out.println("Animal no encontrado.");
            return;
        }

        System.out.print("Ingrese diagnóstico: ");
        String diagnostico = scanner.nextLine();

        System.out.print("Ingrese tratamiento: ");
        String tratamiento = scanner.nextLine();

        System.out.println("\n===== Atención registrada correctamente =====");
        System.out.println("Veterinario: " + veterinarioSeleccionado.getNombre());
        System.out.println("Animal: " + animalSeleccionado.getNombre());
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Tratamiento: " + tratamiento);
    }
}