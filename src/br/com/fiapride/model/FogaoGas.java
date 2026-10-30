package br.com.fiapride.model;

// O Fogão a Gás implementa o forno
public class FogaoGas extends Fogao implements FuncaoForno {
    private String tipoGas;
    
    public FogaoGas(Proprietario proprietario, String tamanho, int quantidadeBocas, String tipoGas) {
        super(proprietario, tamanho, quantidadeBocas);    
        this.tipoGas = tipoGas;
    }

    public void setTipoGas(String tipoGas) { this.tipoGas = tipoGas; }
    public String getTipoGas() { return tipoGas; }
        
    @Override
    public void prepararParaUso() {
        System.out.println("Fogão a gás: abrindo o registro de gás e verificando vazamentos.");
    }
    
    @Override
    public void tipoEnergia() {
        System.out.println("Abastecido por gás (" + tipoGas + ").");
    }

    // Contrato da Interface FuncaoForno
    @Override
    public void assar(String alimento) {
        System.out.println("Assando " + alimento + " no forno do fogão a gás.");
    }
}