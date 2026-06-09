package gspoo;

// vou criar a nossa Classe abstrata para servir como modelo dos componentes espaciais.
public abstract class ComponenteEspacial {
    private int id;
    private String nome;
    private String status;
    private double temperatura;

    public ComponenteEspacial(int id, String nome, double temperatura) {
        setId(id);
        setNome(nome);
        setTemperatura(temperatura);
        this.status = "DESLIGADO";
    }

    
    public void ligar() {
        this.status = "LIGADO";
    }

    
    public void desligar() {
        this.status = "DESLIGADO";
    }

    
    public abstract String verificarStatus();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            this.id = 1;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            this.nome = "Componente sem nome";
        }
    }

    public String getStatus() {
        return status;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        if (temperatura >= -273.15) {
            this.temperatura = temperatura;
        } else {
            this.temperatura = 0;
        }
    }

    public String exibirInformacoesBasicas() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Status: " + status +
                " | Temperatura interna: " + String.format("%.2f", temperatura) + " °C";
    }
}