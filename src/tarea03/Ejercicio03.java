package tarea03;

// Incluir los imports que se necesiten
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Ejercicio 3: Horario de clases.
 *
 * @author Profesor
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        int hora, minutos;

        // Variables de salida
        // Variables auxiliares
        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("HORARIO DE CLASES");
        System.out.println("-----------------");

        // 1. Creación de un objeto de la clase LocalTime con la primera hors de clase (08:00)
        final LocalTime HORA_INICIO = LocalTime.of(8, 00);

        // 2. Lectura por teclado y comprobación de hora y minuto
        // 2.1. Leer y comprobar la hora (debe estar entre 0 y 23)
        do {
            System.out.println("Introduzca la hora: ");
            hora = teclado.nextInt();

        } while (hora > 23 || hora < 0);

        // 2.2.  Leer y comprobar el minuto (entre 0 y 59)
        do {
            System.out.println("Introduzca los minutos: ");
            minutos = teclado.nextInt();

        } while (minutos > 59 || minutos < 0);

        // 3. Creación de objeto LocalTime a partir de los datos leídos por teclado
        LocalTime horaSelec = LocalTime.of(hora, minutos);

        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        // 4. Obtener el rango en el que se encuentra la hora a partir de los dos objetos LocalTime
        if (horaSelec.isBefore(HORA_INICIO)) {
            System.out.println("Todavia no han empezado las clases, quedan : " + horaSelec.until(HORA_INICIO, ChronoUnit.MINUTES) + " minutos");
        } else if (horaSelec.isBefore(HORA_INICIO.plusHours(2))) {
            System.out.println("Estamos en clase de programación");

        } else if (horaSelec.isBefore(HORA_INICIO.plusHours(4))) {
            System.out.println("Estamos en clase de Sistemas Informáticos");
        } else if (horaSelec.isBefore(HORA_INICIO.plusHours(6))) {
            System.out.println("Estamos en clase de Entornos de Desarrollo");

        } else {
            System.out.println("Las clases han finalizado hace: " + horaSelec.minusHours(14));
        }

        //----------------------------------------------
        //            Salida de resultados 
        //----------------------------------------------
        // 5. Mostrar la hora y introducida y los resultados obtenidos
        DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;

        System.out.println(horaSelec.format(formatter));
    }

}
