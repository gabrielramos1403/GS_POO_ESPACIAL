package gspoo;
public class PropulsaoEletrica extends SistemaPropulsao {
    private double consumoEnergia;

    
    
    public PropulsaoEletrica(String nome) {
        super(nome);
        this.consumoEnergia = 0;
    }

    @Override
    public String acelerar(double potencia) {
        
    	
    	
        String respostaBase = super.acelerar(potencia);

        if (!isLigado() || potencia < 0 || potencia > 100) {
            return respostaBase;
        }

        
        
        consumoEnergia = getPotenciaAtual() * 1.20;

        return respostaBase +
                "\nPropulsão elétrica ativada." +
                "\nConsumo de energia: " + String.format("%.2f", consumoEnergia) + " kWh" +
                "\nEmpuxo gerado: " + String.format("%.2f", calcularEmpuxo()) + " N";
    }

    @Override
    public double calcularEmpuxo() {
        return getPotenciaAtual() * 700;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }
}