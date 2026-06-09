package gspoo;


public abstract class SistemaPropulsao {
    private String nome;
    private double potenciaAtual;
    private boolean ligado;

    public SistemaPropulsao(String nome) {
        setNome(nome);
        this.potenciaAtual = 0;
        this.ligado = false;
    }

    public void ligarMotor() {
        this.ligado = true;
    }

    public void desligarMotor() {
        this.ligado = false;
        this.potenciaAtual = 0;
    }

    
    
    
    
    
    
    
    public String acelerar(double potencia) {
        if (!ligado) {
            return "Não foi possível acelerar: o motor está desligado.";
        }

        if (potencia < 0 || potencia > 100) {
            return "Potência inválida. Informe um valor entre 0 e 100.";
        }

        this.potenciaAtual = potencia;
        return "Potência ajustada para " + String.format("%.2f", potenciaAtual) + "%";
    }
    public abstract double calcularEmpuxo();

    
    
    
    
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            this.nome = "Propulsão sem nome";
        }
    }

    public double getPotenciaAtual() {
        return potenciaAtual;
    }

    public boolean isLigado() {
        return ligado;
    }

    public String exibirStatus() {
        return "Sistema: " + nome +
                " | Ligado: " + (ligado ? "Sim" : "Não") +
                " | Potência: " + String.format("%.2f", potenciaAtual) + "%" +
                " | Empuxo: " + String.format("%.2f", calcularEmpuxo()) + " N";
    }
}