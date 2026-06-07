package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import clases.Veterinario;

public class App {

    public static void main(String[] args) {

        LinkedList<Veterinario> listaVeterinarios = new LinkedList<>();

        // Leer veterinarios existentes
        leerVeterinarios(listaVeterinarios);

        // Crear nuevo veterinario
        crearVeterinario(listaVeterinarios);

        // Guardar toda la lista en JSON
        guardarVeterinarios(listaVeterinarios);

        // Mostrar lista final
        mostrarLista(listaVeterinarios);
    }

    // Leer JSON
    public static void leerVeterinarios(LinkedList<Veterinario> lista) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Veterinario[] veterinarios = mapper.readValue(
                    new File("src/main/resources/veterinarios.json"),
                    Veterinario[].class
            );

            for (int i = 0; i < veterinarios.length; i++) {
                lista.add(veterinarios[i]);
            }

            System.out.println("Veterinarios cargados correctamente.\n");

        } catch (IOException e) {
            System.out.println("Error al leer JSON: " + e.getMessage());
        }
    }

    // Crear veterinario
    public static void crearVeterinario(LinkedList<Veterinario> lista) {

        Scanner sc = new Scanner(System.in);

        int id;

        while (true) {

            System.out.println("=== CREAR VETERINARIO ===");

            System.out.print("ID (-1 para salir): ");
            id = sc.nextInt();
            sc.nextLine();

            // Condición de salida
            if (id == -1) {
                break;
            }

            System.out.print("RUT: ");
            String rut = sc.nextLine();

            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();

            System.out.print("Sueldo: ");
            int sueldo = sc.nextInt();
            sc.nextLine();

            Veterinario veterinario = new Veterinario(
                    id,
                    rut,
                    especialidad,
                    sueldo
            );

            lista.add(veterinario);

            System.out.println("\nVeterinario agregado correctamente.\n");
        }
    }

    // Guardar lista completa en JSON
    public static void guardarVeterinarios(LinkedList<Veterinario> lista) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writerWithDefaultPrettyPrinter().writeValue(
                    new File("src/main/resources/veterinarios.json"),
                    lista
            );

            System.out.println("JSON actualizado correctamente.\n");

        } catch (IOException e) {
            System.out.println("Error al guardar JSON: " + e.getMessage());
        }
    }

    // Mostrar lista
    public static <T> void mostrarLista(LinkedList<T> lista) {

        if (lista.isEmpty()) {
            System.out.println("Lista vacía.");
            return;
        }

        System.out.println("=== LISTA DE VETERINARIOS ===");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}