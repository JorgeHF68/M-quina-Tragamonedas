public class Symbol {
    private String name; // Variable privada que almacena el nombre del símbolo

    // Constructor que inicializa el objeto Symbol con un nombre específico
    public Symbol(String name) {
        this.name = name; // Asigna el nombre del símbolo a la variable de instancia
    }

    // Método público que devuelve el nombre del símbolo
    public String getName() {
        return name; // Retorna el nombre del símbolo
    }
}
