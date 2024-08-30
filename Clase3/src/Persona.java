import java.util.List;
import java.util.Optional;

public class Persona {
    String nombre;
    int edad;
    String genero;
    List<Transaction> transaction;

    public Persona(String nombre, int edad, String genero, List<Transaction> transaction) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.transaction = transaction;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public List<Transaction> getTransactions() {
        return transaction;
    }

    @Override
    public String toString() {
        return nombre + " - " + edad + " - " + genero;
    }


}
