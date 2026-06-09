package gspoo;
// vou importar uma biblioteca do java, para gerar numeros aleatrioss
import java.util.Random;





public class SensorRadiacao extends ComponenteEspacial implements Sensor {
    private double limiteAlerta;
    private double ultimoValorLido;
    private Random random;

    public SensorRadiacao(int id, String nome) {
        super(id, nome, 20.0);
        this.limiteAlerta = 50.0;
        this.ultimoValorLido = 0.0;
        this.random = new Random();
    }

    @Override
    public double lerValor() {
      
    	
        ultimoValorLido = 5 + random.nextDouble() * 85;
        return ultimoValorLido;
    }

    @Override
    public boolean verificarFuncionamento() {
        return getStatus().equals("LIGADO");
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Radiação";
    }

    @Override
    public String verificarStatus() {
        if (!verificarFuncionamento()) {
            return "Sensor de radiação desligado. Ligue o componente para realizar leituras.";
        }

        if (ultimoValorLido <= 50) {
            return "NORMAL: radiação em nível aceitável.";
        } else if (ultimoValorLido <= 65) {
            return "ATENÇÃO: radiação acima do ideal.";
        } else if (ultimoValorLido <= 80) {
            return "ALERTA: radiação elevada. Reduzir exposição.";
        } else {
            return "CRÍTICO: radiação perigosa. Ativar protocolo de segurança!";
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