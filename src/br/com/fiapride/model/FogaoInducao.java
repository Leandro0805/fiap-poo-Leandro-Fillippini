package br.com.fiapride.model;

// O Cooktop de Indução não tem forno, mas tem o painel com Timer
public class FogaoInducao extends Fogao implements Temporizavel {
    private float potenciaMaxima;
    
    public FogaoInducao(Proprietario proprietario, String tamanho, int quantidadeBocas, float potenciaMaxima) {
        super(proprietario, tamanho, quantidadeBocas);
        this.potenciaMaxima = potenciaMaxima;
    }
    
    public void setPotenciaMaxima(float potenciaMaxima) { this.potenciaMaxima = potenciaMaxima; }
    public float getPotenciaMaxima() { return potenciaMaxima; }
    
    @Override
    public void prepararParaUso() {
        System.out.println("Fogão de indução: verificando se a panela é compatível.");
    }
    
    @Override
    public void tipoEnergia() {
        System.out.println("Esse fogão é abastecido por energia elétrica.");
    }

    // Contrato da Interface Temporizavel
    @Override
    public void programarTimer(int minutos) {
        if (minutos > TEMPO_MAXIMO_MINUTOS) {
            System.out.println("O tempo máximo do timer é " + TEMPO_MAXIMO_MINUTOS + " minutos.");
        } else {
            System.out.println("Timer do painel de indução programado para " + minutos + " minutos.");
        }
    }
}