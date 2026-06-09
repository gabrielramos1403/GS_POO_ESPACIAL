package gspoo;

  






public class PropulsaoQuimica extends SistemaPropulsao {
    private double consumoCombustivel;

    public PropulsaoQuimica(String nome) {
        super(nome);
        this.consumoCombustivel = 0;
    }

    @Override
    public String acelerar(double potencia) {
       
    	
    	
        String respostaBase = super.acelerar(potencia);

        if (!isLigado() || potencia < 0 || potencia > 100) {
            return respostaBase;
        }

        consumoCombustivel = getPotenciaAtual() * 0.80;

        return respostaBase +
                "\nPropulsão química ativada." +
                "\nConsumo de combustível: " + String.format("%.2f", consumoCombustivel) + " L/min" +
                "\nEmpuxo gerado: " + String.format("%.2f", calcularEmpuxo()) + " N";
    }

    @Override
    public double calcularEmpuxo() {
        return getPotenciaAtual() * 1500;
    }

    public double getConsumoCombustivel() {
        return consumoCombustivel;
    }
}