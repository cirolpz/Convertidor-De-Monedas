package main;

import logic.CurrencyConvert;

import java.util.Scanner;

public class Main {
    private static boolean flag = true;

    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        while (flag) {
            menu(read);
        }
        read.close();
    }

    private static void menu(Scanner read) {
        int option = 0;
        System.out.println(
                """
                        ----------------*-*-*-*-*-----------------------*--*--*--*--*--*--*--*--*--*--*---*--------------------*-*-*-*-*-----------------------"
                                                C O N V E R S O R  __D E __  M O N E D A S
                        ----------------*-*-*-*-*-----------------------*--*--*--*--*--*--*--*--*--*--*---*--------------------*-*-*-*-*-----------------------"
                        1-Convert ARS -> USD
                        2-Convert USD -> ARS
                        3-Convert EUR -> ARS
                        4-Convert ARS -> EUR
                        5-Convert COP -> ARS
                        6-Convert ARS -> COP
                        7-Convert ARS -> MXN
                        8-Convert MXN -> ARS
                        9-Convert BRL -> ARS
                        10-Convert ARS -> BRL
                        11-Convert x -> x
                        12- Closed """);
        System.out.print("Seleccione una opción: ");
        if (read.hasNextInt()) {
            option = read.nextInt();
        } else {
            System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 12.");
            read.next();
            return;
        }
        selector(option, read);
    }

    private static void selector(int option, Scanner read) {
        CurrencyConvert currencyConvert = new CurrencyConvert();
        Double money;
        String currency1;
        String currency2;

        switch (option) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10:
                System.out.print("Ingresar monto a convertir: ");
                if (read.hasNextDouble()) {
                    money = read.nextDouble();
                    System.out.println(currencyConvert.currencyConver(option, money));
                } else {
                    read.next();
                }
                break;
            case 11:
                System.out.print("Ingresar divisa a convertir: ");
                currency1 = read.next();
                System.out.print("Ingrese la moneda a la que desea convertir: ");
                currency2 = read.next();
                System.out.print("Ingresar monto a convertir: ");
                if (read.hasNextDouble()) {
                    money = read.nextDouble();
                } else {
                    System.out.println("Monto inválido. Por favor, ingrese un número.");
                    read.next();
                }
                break;
            case 12:
                flag = false;
                System.out.println("Cerrando el conversor de monedas.");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 12.");
        }
    }
}