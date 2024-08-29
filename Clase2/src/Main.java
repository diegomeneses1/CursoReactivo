import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
        public static void main(String[] args) {
            List<Persona> personas = Arrays.asList(
                    new Persona("Juan", 25, "Masculino"),
                    new Persona("María", 30, "Femenino"),
                    new Persona("Pedro", 40, "Masculino"),
                    new Persona("Ana", 20, "Femenino"),
                    new Persona("Diego", 35, "Masculino"),
                    new Persona("Indigo", 11, "No binario")
            );

            //Filter: Filtrar personas mayores de 25 años.
            System.out.println(personas.stream()
                    .filter(persona -> persona.getEdad()>=25)
                            .map(persona -> persona.getNombre())
                    .collect(Collectors.toList())
            );
            //Map: Obtener una lista con los nombres de las personas.
            System.out.println(personas.stream()
                    .map(Persona::getNombre)
                    .collect(Collectors.toList())
            );
            //Reduce: Obtener la suma de las edades de todas las personas.
            System.out.println(personas.stream()
                    .map(persona -> persona.getEdad())
                    .reduce(0, Integer::sum)
            );

            //Ejercicios Extra
            //Contar la cantidad de personas de cada género.
            Map<String,Long> countGenero = personas.stream()
                    .collect(Collectors.groupingBy(persona -> persona.getGenero(), Collectors.counting()));
            System.out.println(countGenero
            );
            //Calcular el promedio de edades de las personas.
            System.out.println(personas.stream()
                    .mapToInt(persona -> persona.getEdad())
                    .average()
                    .orElse(0)
            );
            //Encontrar la persona de mayor edad.
            System.out.println(personas.stream()
                    .max(Comparator.comparingDouble(persona -> persona.getEdad()))
                    .orElseThrow()
            );
        }
    }

