package gspoo;

// aqui vamos gerar a interface que define os métodos obrigatórios para qualquer sensor do sistema.
public interface Sensor {
    double lerValor();
    boolean verificarFuncionamento();
    String retornarTipo();
}