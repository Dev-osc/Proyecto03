package tarea03;

import java.time.LocalDate;
import libtarea3.CuentaBancaria;

// Incluir el resto de los imports que se necesiten
/**
 * Ejercicio 1: Uso de cuentas bancarias.
 *
 * @author G0LF0
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1. Declaración de tres variables referencia a objetos instancia de la clase CuentaBancaria

        CuentaBancaria cuentaPrivada;

        CuentaBancaria cuentaConjunta;

        CuentaBancaria cuentaFamiliar;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("USANDO CUENTAS BANCARIAS");
        System.out.println("------------------------");
        System.out.printf("Fecha actual: %s\n", LocalDate.now());
        System.out.println();

        // 2.- Instanciación de tres objetos CuentaBancaria
        System.out.println("-----------------------------------");

        System.out.println("---------------------------------");

        // 2.1.- Intento de crear una cuenta con fecha no válida (hay gestionar la posible excepción)
        System.out.println("Cuentas con parámetros erroneos");

        try {
            CuentaBancaria cuentaNoValida = new CuentaBancaria(300.00, LocalDate.of(2027, 9, 1));
        } catch (IllegalArgumentException i) {
            System.out.println("Error: " + i.getMessage());

        }

        // 2.2.- Intento de crear una cuenta con saldo no válido (hay gestionar la posible excepción)
        try {
            CuentaBancaria cuentaSaldoNulo = new CuentaBancaria(-200.00);

        } catch (IllegalArgumentException il) {
            System.out.println("Error: " + il.getMessage());
        }

        System.out.println("--------------------------------");

        // 2.3.- Creación de una cuenta válida usando el constructor de tres parámetros
        cuentaPrivada = new CuentaBancaria(1000.00, LocalDate.of(2021, 7, 1), -200.00);

        // 2.4.- Creación de una cuenta válida usando el constructor de dos parámetros 
        cuentaConjunta = new CuentaBancaria(200.00, LocalDate.of(2021, 7, 1));

        // 2.5.- Creación de una cuenta válida usando el constructor sin parámetros
        cuentaFamiliar = new CuentaBancaria();

        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        // 3.- Obtención de información de la cuenta privada
        System.out.printf("ID:%d\n", cuentaPrivada.getId());
        System.out.printf("Fecha creación:%s\n ", cuentaPrivada.getFechaCreacion());
        System.out.printf("Limite de descubierto: %s\n ", cuentaPrivada.getLimiteDescubierto());
        System.out.printf("Cuenta embargada:%s\n ", ((cuentaPrivada.isEmbargada()) ? "Si" : "No"));
        System.out.printf("Cuenta en descubierto: %s\n  ", ((cuentaPrivada.isEmbargada()) ? "Si" : "No"));
        System.out.printf("Número de días cuenta abierta: %d\n", cuentaPrivada.getDiasCuenta());

        System.out.println("--------------------------------------");

        // 4.- Realización de operaciones sobre las cuentas
        //Ingresar 100.00 euros en la cuenta familiar
        cuentaFamiliar.ingresar(100.00);
        //Extraer 100.00 euros en la cuenta conjunta
        cuentaConjunta.extraer(100.00);
        //Transferir 1100.00 euros de cuenta privada a familiar
        cuentaPrivada.transferir(1100.00, cuentaFamiliar);

        // 5.- Estado final de las cuentas
        System.out.printf("Estado final de la cuenta: %s\n", cuentaPrivada.toString());
        System.out.printf("Estado final de la cuenta:  %s\n", cuentaConjunta.toString());
        System.out.printf("Estado final de la cuenta: %s\n ", cuentaFamiliar.toString());

    }

}
