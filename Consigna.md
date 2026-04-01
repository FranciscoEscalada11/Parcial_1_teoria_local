Examen Parcial: Normalización Resiliente de Datos de Telemetría
===============================================================

Objetivo
--------

Evaluar la implementación de sistemas tolerantes a fallos para la ingesta de datos mediante el manejo avanzado y granular de excepciones. Se requiere garantizar la continuidad del hilo de ejecución ante datos corruptos, asimetría en las estructuras de datos, referencias nulas y violaciones aritméticas.

Especificaciones Técnicas
-------------------------

Desarrollar el método estático `normalizarTelemetria` con la siguiente firma:

```java
public static String[] normalizarTelemetria(String[] lecturas, String[] factores, int capacidad)
```

### **Comportamiento del Método**

1.  **Iteración y Asimetría de Datos:** El método debe iterar concurrentemente sobre los arreglos `lecturas` (datos crudos) y `factores` (escalas de conversión) hasta alcanzar el límite máximo definido por el parámetro `capacidad`. Los arreglos de entrada pueden poseer **longitudes diferentes** entre sí, o ser de menor dimensión que la `capacidad` requerida.

2.  **Parsing y Normalización:** Efectuar la conversión estricta de `String` a `int` para cada par de valores. Calcular el valor normalizado mediante la operación de división entera: `lecturas[i] / factores[i]`. Si la operación es exitosa, el resultado aritmético debe castearse a `String` y almacenarse en el arreglo de salida.

3.  **Resiliencia y Manejo de Anomalías:** El flujo de ejecución es estricto y no debe colapsar ante fallos. Si un par de valores presenta anomalías de cualquier índole, la iteración actual debe atrapar la excepción correspondiente y persistir un código de error estandarizado en la posición `[i]` del arreglo de retorno:

    -   **Datos no numéricos o malformados:** Ante la imposibilidad de parsear el dato (`NumberFormatException`), persistir el literal `"ERR_FORMATO"`.

    -   **Violación Aritmética:** Si el factor de conversión es cero (`ArithmeticException`), persistir el literal `"ERR_DIV_CERO"`.

    -   **Ausencia de Datos (Null):** Si un elemento puntual de los arreglos es `null` (`NullPointerException`), persistir el literal `"ERR_NULO"`.

    -   **Desbordamiento de Estructura:** Si se agota uno o ambos arreglos de entrada antes de alcanzar el ciclo final dictado por la `capacidad` (`ArrayIndexOutOfBoundsException`), persistir el literal `"ERR_INDICE"` para todos los ciclos restantes.

4.  **Valor de Retorno:** El método devolverá un `String[]` instanciado con un tamaño exacto igual a `capacidad`. El mismo contendrá una matriz heterogénea conformada por los registros numéricos normalizados con éxito (representados como cadenas) y los códigos de error capturados durante la ejecución.

La idea es que cada posicion especifica de los arreglos se procece entre si, solo cuando los datos sean validos en ambos.

Capacidad, es el total de numeros a procesar, este puede ser menos, o mas que los datos ingresados, para lo cual se debera retornar un codigo de error apropiado.

### Prioridades

En orden de prioridad, los entregables son.
1. La clase Telemetria que implementa la funcion pedida y sus auxiliares.
2. Los tests que verifican Telemetria y sus auxiliares
3. El main