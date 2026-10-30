package br.com.fiapride.model;


public class Microondas implements FuncaoForno, Temporizavel {
    private String marca;

    public Microondas(String marca) {
        this.marca = marca;
    }

    @Override
    public void assar(String alimento) {
        System.out.println("Microondas " + marca + " esquentando/assando: " + alimento);
    }

    @Override
    public void programarTimer(int minutos) {
        System.out.println("Timer do microondas ajustado para " + minutos + " minutos.");
    }
}