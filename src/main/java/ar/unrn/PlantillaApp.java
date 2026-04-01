package ar.unrn;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Esta es una plantilla de main.
 * Usen Shift+F6 sobre el nombre para cambiarlo al que necesiten.
 * ¡Esto lo pueden utilizar en cualquier identificador!
 * Acá va la consigna del ejercicio.
 */
public class PlantillaApp {

    /**/
    public static String[] normalizarTelemetria(String[] lecturas, String[] factores, int capacidad){
        int lLecturas = lecturas.length;
        int lFactores = lecturas.length;
        String[] salida = new String[capacidad];

        for(int i = 0; i < capacidad; i++){
            try{
                if(i > lLecturas || i > lFactores){
                    throw new IndexOutOfBoundsException("Alguno de los arreglos es menor a la capacidad pedidad")
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("ERR_INDICE" + e.getMessage());
            }
            try{
                if (lecturas[i] == null || factores[i] == null){
                    throw new NullPointerException("La cadena evaluada es NULL");
                }
            } catch (NullPointerException e) {
                //asignacion
                salida[i] = "ERR_NULO";
            }
            int nLecturas = Integer.parseInt(lecturas[i]);
            int nFactores = Integer.parseInt(factores[i]);
            try{
                int normalizado = nLecturas / nFactores;
                String fila = Integer.toString(normalizado);
                salida[i] = fila;
            } catch (ArithmeticException e){
                System.out.println("ERR_DIV_ZERO" + e.getMessage());
                salida[i] = "ERR_DIV_ZERO";
            }
        }
        return salida;
    }

    /**
     * Punto de entrada del ejercicio.
     *
     * @param args son los argumentos de invocación.
     */
    public static void main(String[] args) {
        System.out.println("Completar con el main");
    }
}
