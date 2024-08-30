import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Lista de transacciones de un cliente
        List<Transaction> client1Transactions = Arrays.asList(
                new Transaction(100.0, "deposit", "2024-08-01"),
                new Transaction(50.0, "withdrawal", "2024-08-02")
        );

        // Lista de transacciones de otro cliente
        List<Transaction> client2Transactions = Arrays.asList(
                new Transaction(200.0, "deposit", "2024-08-03"),
                new Transaction(100.0, "withdrawal", "2024-08-04")
        );

        List<Persona> personas = Arrays.asList(
                new Persona("Juan", 25, "Masculino", client1Transactions),
                new Persona("María", 30, "Femenino", client1Transactions),
                new Persona("Pedro", 40, "Masculino", client2Transactions),
                new Persona("Ana", 20, "Femenino", client2Transactions),
                new Persona("Raul", 36, "Masculino", client1Transactions)

        );


        //Filter: Filtrar personas mayores de 25 años.
        System.out.println(personas.stream()
                .filter(persona -> persona.getEdad() > 25)
                .collect(Collectors.toList())
        );

        //Map: Obtener una lista con los nombres de las personas.
        System.out.println(personas.stream()
                .map(Persona::getNombre)
                .collect(Collectors.toList()));

        //Reduce: Obtener la suma de las edades de todas las personas.
        System.out.println(personas.stream()
                .map(Persona::getEdad)
                .reduce(0, Integer::sum)
        );


        //Contar la cantidad de personas de cada género.
        Map<String, Long> countByGenero = personas.stream()
                .collect(Collectors.groupingBy(Persona::getGenero, Collectors.counting()));
        System.out.println(countByGenero);

        //Calcular el promedio de edades de las personas.
        System.out.println(personas.stream()
                .mapToInt(Persona::getEdad)
                .average()
                .orElseThrow());

        //Encontrar la persona de mayor edad.
        System.out.println(personas.stream()
                .max(Comparator.comparingInt(Persona::getEdad))
                .orElseThrow());


        // Uso de flatMap para aplanar la estructura de datos
        var total = personas.stream()//operas las personas
                .flatMap(persona -> persona.getTransactions().stream())
                .filter(transaction -> "deposit".equals(transaction.getType()))// operas las transaciones
                .mapToDouble(Transaction::getAmount)
                .sum();
        System.out.println(total);
    }

}

