import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Calculadora ---");
        int hola = 0;
        while(hola != 5){
            System.out.println("1.- SUMA");
            System.out.println("2.- RESTA");
            System.out.println("3.- MULTIPLICACION");
            System.out.println("4.- DIVISION");
            System.out.println("5.- SALIR");
            hola = Integer.parseInt(scanner.nextLine());
            if (hola == 1){
                System.out.println("Ingrese el primer numero: ");
                int num1 = Integer.parseInt(scanner.nextLine());
                System.out.println("Ingrese el segundo numero: ");
                int num2 = Integer.parseInt(scanner.nextLine());
                int resultado = num1 + num2;
                System.out.println("El resultado de la suma es: " + resultado);
            }
            //SUMAA



            //RESTA


            // MULTIPLICACION


            // DIVISION
        }
    
    }
}