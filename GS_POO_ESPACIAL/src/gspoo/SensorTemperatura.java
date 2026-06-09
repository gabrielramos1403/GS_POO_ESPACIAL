package gspoo;
// Aqqui tamnbem importei a biblioteca Random para me ajudar na questão de gerar numeros aleatorios, para a simulação do projeto!!
import java.util.Random;




public class SensorTemperatura extends ComponenteEspacial implements Sensor {
    private double limiteAlerta;
    private double ultimoValorLido;
    private Random random;

    public SensorTemperatura(int id, String nome) {
        super(id, nome, 25.0);
        this.limiteAlerta = 70.0;
        this.ultimoValorLido = 0.0;
        this.random = new Random();
    }

    @Override
    public double lerValor() {
        ultimoValorLido = 30 + random.nextDouble() * 80;
        setTemperatura(ultimoValorLido);
        return ultimoValorLido;
    }

    @Override
    public boolean verificarFuncionamento() {
        return getStatus().equals("LIGADO");
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Temperatura";
    }

    @Override
    public String verificarStatus() {
        if (!verificarFuncionamento()) {
            return "Sensor de temperatura desligado. Ligue o componente para realizar leituras.";
        }

        if (ultimoValorLido <= 70) {
            return "NORMAL: temperatura dentro do limite seguro.";
        } else if (ultimoValorLido <= 85) {
            return "ATENÇÃO: temperatura acima do ideal.";
        } else if (ultimoValorLido <= 95) {
            return "ALERTA: temperatura elevada. Monitorar imediatamente.";
        } else {
            return "CRÍTICO: superaquecimento detectado. Ação urgente necessária!";
        }
    }

    
    
    
    public void definirValorManual(double valor) {
        this.ultimoValorLido = valor;
        setTemperatura(valor);
    }

    public double getLimiteAlerta() {
        return limiteAlerta;
    }

    public double getUltimoValorLido() {
        return ultimoValorLido;
    }
}