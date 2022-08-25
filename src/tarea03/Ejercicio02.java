package tarea03;

// Incluir los imports que se necesiten
import java.util.Random;    //Importamos la clase Random
import libtarea3.Dado;      //Importamos la clase Dado

/**
 * Ejercicio 2: Lanzando los dados.
 *
 * @author G0LF0
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Variables de salida
        // (no hace falta ninguna)
        // Variables auxiliares
        System.out.println("LANZANDO LOS DADOS");
        System.out.println("------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 1. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
        System.out.println();

        // 1.1. Número total de dados creados
        System.out.printf("Número total de dados creados: %d\n", Dado.getNumeroDadosCreados()); // Utilizamos printf al numero total de dados creados añadiendo el metodo getNumeroDadosCreados.

        // 1.2. Número total de lanzamientos
        System.out.printf("Número total de lanzamientos: %d\n", Dado.getNumeroLanzamientosGlobal()); //Utilizamos el metodo getNumeroLanzamientosGlobal para saber cuantos números de lanzamientos totales.

        // 1.3. Consulta de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar) 
        int maxCaras2 = 4;
        for (int i = 1; i <= maxCaras2; i++) {

            System.out.printf("Cantidad de veces que han salido las caras con valores %d en total: %d\n", i , Dado.getNumeroVecesCaraGlobal(i)); //Utilizamos un bucle for para ir recorriendo los números con un maximo de 4 valores.
        }

        //----------------------------------------------
        //      Creación y lanzamiento de dados
        //----------------------------------------------
        System.out.println();
        System.out.println("2.- CREACIÓN Y LANZAMIENTO DE DADOS");
        System.out.println("-----------------------------------");
        System.out.println();
        // 2.1. Intentos de creación 
        // Se intentan crear 10 dados que tengan aleatoriamente entre 0 y 8 caras (bucle)
        // Sólo algunas llamadas al constructor funcionarán y en esos casos es cuando se podrá lanzar el dado
        // Otras harán que salte una excepción IllegalArgumentException
        // Habrá que recogerla y mostrar el mensaje de error por pantalla
        Dado dado;
        Random rand = new Random();
        int maxCaras = 8;               //variable de tipo int para indicar el máximo de caras
        for (int i = 0; i <= 10; i++) {  // Utilizamos un bucle for para crear 10 objetos 

            try {
                dado = new Dado(rand.nextInt(maxCaras + 1)); //Utilizamos el método Random para coger un número al azar entre el 0-8 con un maximo de 10 vueltas
                for (int j = 0; j < dado.getNumeroCaras(); j++) { //utilizamos otro bucle para llamar al metodo número de caras y ejecutamos el metodo lanzar
                    dado.lanzar();
                }
                System.out.println("Historial de resultados:  " + dado.getSerieHistoricaLanzamientos()); //Utilizamos el metodo para saber el historial de lanzamientos e imprimimos en pantallas
                System.out.printf("Suma de puntuación: %d\n", dado.getSumaPuntuacionHistorica()); // Utilizamos el metodo de puntuación historica e imprimimos por pantalla.

            } catch (IllegalArgumentException il) {                                               // Dentro de los bucles for, iniciamos una excepción, donde metemos el tipo de excepción e imprimimos a través de un metodo.
                System.out.println("Error:  " + il.getMessage());

            }

        }

        //----------------------------------------------
        //         Análisis de resultados finales
        //----------------------------------------------
        // 3. Análisis de resultados una vez realizados todos los lanzamientos
        System.out.println();
        System.out.println("3.-ANÁLISIS DE RESULTADOS FINALES");
        System.out.println("---------------------------------");

        // 3.1. Número total de dados creados
        System.out.printf("Número de dados creados: %d\n", Dado.getNumeroDadosCreados()); // Imprimimos y llamamos al metodo para ver el numero de dados creados.
        // 3.2. Número total de lanzamientos
        System.out.printf("Número de lanzamientos global: %d\n", Dado.getNumeroLanzamientosGlobal()); // Imprimimos y llamamos al metodo para ver número de lanzamientos global.
        // 3.3. Análisis de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)

        for (int i = 1; i <= maxCaras2; i++) {                     // Realizamos un blucle for con un maximo de caras (4) para recorre cuantas veces ha salido la cara 1, 2 , 3 , 4
            System.out.printf("Cantidad de veces que han salido las caras con valores %d en total: %d\n ", i , Dado.getNumeroVecesCaraGlobal(i));
        }

    }

}
