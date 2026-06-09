package gspoo;

import java.util.Random;

// Classe  para leitura simulada da pressão.
public class SensorPressao extends ComponenteEspacial implements Sensor {
    private double limiteAlerta;
    private double ultimoValorLido;
    private Random random;

    public SensorPressao(int id, String nome) {
        super(id, nome, 22.0);
        this.limiteAlerta = 100.0;
        this.ultimoValorLido = 0.0;
        this.random = new Random();
    }
    @Override
    public double lerValor() {
        
        ultimoValorLido = 40 + random.nextDouble() * 100;
        return ultimoValorLido;
    }
    @Override
    public boolean verificarFuncionamento() {
        return getStatus().equals("LIGADO");
    }
 
    
    
    
    @Override
    public String retornarTipo() {
        return "Sensor de Pressão";
    }

    @Override
    public String verificarStatus() {
        if (!verificarFuncionamento()) {
            return "Sensor de pressão desligado. Ligue o componente para realizar leituras.";
        }

        if (ultimoValorLido <= 100) {
            return "NORMAL: pressão dentro da faixa segura.";
        } else if (ultimoValorLido <= 115) {
            return "ATENÇÃO: pressão um pouco acima do recomendado.";
        } else if (ultimoValorLido <= 130) {
            return "ALERTA: pressão elevada no sistema.";
        } else {
            return "CRÍTICO: pressão extremamente alta. Risco para o sistema!";
        }
    }
    public void definirValorManual(double valor) {
        this.ultimoValorLido = valor;
    }

    public double getLimiteAlerta() {
        return limiteAlerta;
    }

    public double getUltimoValorLido() {
        return ultimoValorLido;
    }
}