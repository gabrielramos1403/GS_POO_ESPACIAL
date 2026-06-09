package gspoo;







public class DadosMissao {
    private String coordenadas;
    private String codigoAcesso;
    private double combustivel;
    private String trajetoria;
    private int numeroTripulantes;

    public DadosMissao(String coordenadas, String codigoAcesso, double combustivel,
                       String trajetoria, int numeroTripulantes) {
        this.coordenadas = coordenadas;
        setCodigoAcesso(codigoAcesso);
        setCombustivel(combustivel);
        setTrajetoria(trajetoria);
        setNumeroTripulantes(numeroTripulantes);
    }

    
    
    
    
    private boolean validarCodigo(String codigoInformado) {
        return codigoInformado != null && codigoInformado.equals(this.codigoAcesso);
    }

    public String getCoordenadas(String codigoInformado) {
        if (validarCodigo(codigoInformado)) {
            return coordenadas;
        }
        return "ACESSO NEGADO: código de acesso incorreto.";
    }

    
    
    
    public boolean setCoordenadas(String coordenadas, String codigoInformado) {
        if (!validarCodigo(codigoInformado)) {
            return false;
        }

        if (coordenadas != null && !coordenadas.trim().isEmpty()) {
            this.coordenadas = coordenadas;
            return true;
        }

        return false;
    }

    
    public String getCodigoAcesso(String codigoInformado) {
        if (validarCodigo(codigoInformado)) {
            return codigoAcesso;
        }
        return "ACESSO NEGADO.";
    }

    public void setCodigoAcesso(String codigoAcesso) {
        if (codigoAcesso != null && codigoAcesso.length() >= 4) {
            this.codigoAcesso = codigoAcesso;
        } else {
            this.codigoAcesso = "GS2026";
        }
    }

    public boolean alterarCodigoAcesso(String codigoAtual, String novoCodigo) {
        if (validarCodigo(codigoAtual) && novoCodigo != null && novoCodigo.length() >= 4) {
            this.codigoAcesso = novoCodigo;
            return true;
        }

        return false;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(double combustivel) {
        
    	
    	
    	
    	
    	
        if (combustivel >= 0 && combustivel <= 100) {
            this.combustivel = combustivel;
        } else {
            System.out.println("Valor inválido. O combustível deve ficar entre 0% e 100%.");
        }
    }

    public String verificarAlertaCombustivel() {
        if (combustivel < 20) {
            return "ALERTA: combustível abaixo de 20%. Planejar reabastecimento ou economia de energia.";
        }

        return "Combustível em nível seguro.";
    }

    public String getTrajetoria() {
        return trajetoria;
    }

    public void setTrajetoria(String trajetoria) {
        if (trajetoria != null && !trajetoria.trim().isEmpty()) {
            this.trajetoria = trajetoria;
        } else {
            this.trajetoria = "Trajetória não definida";
        }
    }

    public int getNumeroTripulantes() {
        return numeroTripulantes;
    }

    public void setNumeroTripulantes(int numeroTripulantes) {
        if (numeroTripulantes >= 0) {
            this.numeroTripulantes = numeroTripulantes;
        } else {
            this.numeroTripulantes = 0;
        }
    }

    public String exibirDadosPublicos() {
        return "Trajetória: " + trajetoria +
                "\nCombustível: " + String.format("%.2f", combustivel) + "%" +
                "\nTripulantes: " + numeroTripulantes +
                "\n" + verificarAlertaCombustivel();
    }
}