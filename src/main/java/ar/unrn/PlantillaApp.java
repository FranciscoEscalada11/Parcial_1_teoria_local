package ar.unrn;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Parcial 1 - 2026 - Francisco Thomas Escalada
 */
public class PlantillaApp {

    /*
    * Recorre dos arreglos de String convirtiendo cada elemento de los arreglos en enteros y asi al dividirlos
    * obtiene un valor decodificado, este formara parte del arreglo de String de salida
    * @param lecturas Arreglo de string a recorrer
    * @param factores Arreglo de string a recorrer
    * @pre lecturas y factores no pueden ser null
    * @return salida un Arreglo de strings con los valores decodificados o mensajes de error correspondientes
    * @post Si la capacidad pedida para el arreglo de salida supera la capacidad de alguno de los arreglos de entrada
    * la fila correspondiente estara completa con el mensaje de error ERROR_INDICE
    * @post Si alguno de los Strings es null, la fila correspondiente del arreglo de salida mostrara el mensaje de
    * error ERROR_NULO
    * @post Si al momento de la decodificacion el valor del arreglo factores es 0, este se posicionara como divisor
    * por lo que en la fila del arreglo de salida correspondiente se vera el mensaje de error ERROR_DIV_ZERO*/
    public static String[] normalizarTelemetria(String[] lecturas, String[] factores, int capacidad){
        int lLecturas = lecturas.length;
        int lFactores = lecturas.length;
        String[] salida = new String[capacidad];

        for(int i = 0; i < capacidad; i++){
            try{
                if(i > lLecturas || i > lFactores){
                    throw new IndexOutOfBoundsException("Alguno de los arreglos es menor a la capacidad pedidad");
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
        String[] lecturas = {"123","345","0","12","2"};
        String[] factores = {"45","22","11", "0"};
        String[] salida = normalizarTelemetria(lecturas,factores,5
        );
        for(int i = 0; i < salida.length; i++){
            System.out.println(salida[i]);
        }
    }
}
