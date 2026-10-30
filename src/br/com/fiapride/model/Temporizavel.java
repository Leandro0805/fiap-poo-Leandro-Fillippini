package br.com.fiapride.model;

public interface Temporizavel {
    int TEMPO_MAXIMO_MINUTOS = 120;
    
    void programarTimer(int minutos);
}