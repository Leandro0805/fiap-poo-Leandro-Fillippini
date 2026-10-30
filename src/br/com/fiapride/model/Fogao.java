package br.com.fiapride.model;

public abstract class Fogao {
    private Proprietario proprietario;
    private String tamanho;
    private boolean ligado;
    private int quantidadeBocas;
    private int bocasAcesas;

    public Fogao(Proprietario proprietario, String tamanho, int quantidadeBocas) {
        if (proprietario == null) {
            System.out.println("Erro: Todo fogão precisa de um proprietário válido!");
        } else {
            this.proprietario = proprietario;
        }

        if (tamanho == null || tamanho.trim().isEmpty()) {
            System.out.println("Erro: Tamanho inválido!");
            this.tamanho = "Indefinido";
        } else {
            this.tamanho = tamanho;
        }

        if (quantidadeBocas > 0) {
            this.quantidadeBocas = quantidadeBocas;
        } else {
            System.out.println("Erro: Quantidade de bocas deve ser maior que zero!");
            this.quantidadeBocas = 1;
        }
        
        this.ligado = false;
        this.bocasAcesas = 0;
    }

    // AULA 4: Uso do this() para encadear construtores (Garante a nota do requisito)
    public Fogao(Proprietario proprietario, int quantidadeBocas) {
        this(proprietario, "Padrão", quantidadeBocas);
    }

    private void setBocasAcesas(int bocasAcesas) {
        if (bocasAcesas >= 0 && bocasAcesas <= this.quantidadeBocas) {
            this.bocasAcesas = bocasAcesas;
        } else {
            System.out.println("Quantidade de bocas acesas inválida!");
        }
    }

    public Proprietario getProprietario() { return proprietario; }
    public String getTamanho() { return tamanho; }
    public boolean isLigado() { return ligado; }
    public int getQuantidadeBocas() { return quantidadeBocas; }
    public int getBocasAcesas() { return bocasAcesas; }

    public void ligarFogao() {
        if (ligado) {
            System.out.println("O seu fogão já está ligado!");
        } else {
            ligado = true;
            System.out.println("Fogão ligado!");
        }
    }

    public void desligarFogao() {
        this.ligado = false;
        this.bocasAcesas = 0;
        System.out.println("Fogão desligado e todas as bocas foram apagadas.");
    }

    // CORREÇÃO: Agora o método soma as bocas em vez de só substituir o valor
    public void ligarBocas(int quantidade) {
        if (!ligado) {
            System.out.println("Não é possível acender as bocas com o fogão desligado!");
        } else if (quantidade <= 0 || (this.bocasAcesas + quantidade) > this.quantidadeBocas) {
            System.out.println("Quantidade de bocas inválida ou limite excedido!");
        } else {
            setBocasAcesas(this.bocasAcesas + quantidade);
            System.out.println("Foram acesas mais " + quantidade + " bocas. Total: " + this.bocasAcesas);
        }
    }

    public void prepararParaUso() {
        System.out.println("Preparando o fogão para utilização.");
    }

    public abstract void tipoEnergia();
}