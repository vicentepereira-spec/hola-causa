import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Calculadora ---");
        int hola = 0;
        while (hola != 5) {
            System.out.println("1.- SUMA");
            System.out.println("2.- RESTA");
            System.out.println("3.- MULTIPLICACION");
            System.out.println("4.- DIVISION");
            System.out.println("5.- SALIR");
            // SUMAA
            hola = Integer.parseInt(scanner.nextLine());
            if (hola == 5)
                break;
            if (hola == 1) {
                System.out.println("Ingrese el primer numero: ");
                int num1 = Integer.parseInt(scanner.nextLine());
                System.out.println("Ingrese el segundo numero: ");
                int num2 = Integer.parseInt(scanner.nextLine());
                int resultado = num1 + num2;
                System.out.println("El resultado de la suma es: " + resultado);
            }
            // RESTAS
            else if (hola == 2) {
                System.out.println("Ingrese el primer numero: ");
                int num1 = Integer.parseInt(scanner.nextLine());
                System.out.println("Ingrese el segundo numero: ");
                int num2 = Integer.parseInt(scanner.nextLine());
                int resultado = num1 - num2;
                System.out.println("El resultado de la resta es: " + resultado);
            }
            // MULTIPLICACION
            else if (hola == 3){
                System.out.println("Ingresa el primer numero: ");
                int num1 = Integer.parseInt(scanner.nextLine());
                System.out.println("ingrese el segundo numero: ");
                int num2= Integer.parseInt(scanner.nextLine());
                int resultado = num1 * num2;
                System.out.println("El resultado del producto es: " + resultado);
                }
            // DIVISION
            else if (hola == 4){
                System.out.println("Ingrese el numerador");
                float num1 = Integer.parseInt(scanner.nextLine());
                System.out.println("Ingresa el denominador");
                float num2 = Integer.parseInt(scanner.nextLine());
                float resultado= num1/num2;
                System.out.println("El resultado de la división es: " + resultado);
            }
        

        }

    }
}