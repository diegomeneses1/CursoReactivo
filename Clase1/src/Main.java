import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //1) Funciones de Orden Superior
        //Las funciones de orden superior son aquellas que pueden tomar una o más funciones como argumentos y/o devolver funciones como resultado. Esto permite una composición de funciones más flexible y potente.
        //Ejemplo en Java:
        Function<Integer, Integer> cuadrado = x -> x * x;
        Function<Integer, Integer> doble = x -> x * 2;

        // Composición de funciones
        Function<Integer, Integer> cuadradoDelDoble = cuadrado.compose(doble);

        System.out.println(cuadradoDelDoble.apply(5)); // Salida: ??


        //2)Inmutabilidad de Datos
        //En la programación funcional, los datos son inmutables, lo que significa que una vez que se crean, no pueden modificarse. Esto evita efectos secundarios no deseados y hace que el código sea más predecible y fácil de razonar.
        //Ejemplo en Java:
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);

        // Operación de mapa para crear una nueva lista con los cuadrados de los números
        List<Integer> cuadrados = numeros.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());

        System.out.println(cuadrados); // Salida: ??


        //Función pura
        //La transparencia referencial significa que una función siempre devolverá el mismo resultado para los mismos argumentos, sin efectos secundarios observables. Esto facilita la comprensión y la depuración del código.
        //Ejemplo en Java:
        int resultado = sumar(3, 4);
        System.out.println(resultado); // Salida: ??
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    //Conclusiones

    //La programación funcional promueve la composición de funciones, la inmutabilidad de datos y la función pura.
    //Estos conceptos ayudan a escribir código más conciso, predecible y fácil de razonar.
    //Java ofrece soporte para programación funcional a través de características como lambdas, streams y funciones de orden superior.
}
