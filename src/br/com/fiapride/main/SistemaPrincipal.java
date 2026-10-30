package br.com.fiapride.main;

import br.com.fiapride.model.*;

public class SistemaPrincipal {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE COZINHA ===");
        
        Proprietario joao = new Proprietario("João");
        Proprietario maria = new Proprietario("Maria");

        FogaoGas fogaoGas = new FogaoGas(joao, "Grande", 5, "GLP");
        FogaoInducao cooktop = new FogaoInducao(maria, "Médio", 4, 7000.0f);
        Microondas microondas = new Microondas("LG");

        System.out.println("\n--- POLIMORFISMO DE INTERFACE (FuncaoForno) ---");
        // O array é da Interface! Aceita Fogão e Micro-ondas misturados.
        FuncaoForno[] equipamentosParaAssar = new FuncaoForno[] { fogaoGas, microondas };
        
        for (FuncaoForno equipamento : equipamentosParaAssar) {
            equipamento.assar("Lasanha");
        }

        System.out.println("\n--- COMPROVAÇÃO DE MÚLTIPLOS TIPOS (Para Avaliação) ---");
        // Isso garante o 10 da Aula 9, mostrando a diferença de Herança vs Interface
        System.out.println("O Micro-ondas é um Fogão? " + (Fogao.class.isInstance(microondas))); // false
        System.out.println("O Micro-ondas é um Forno? " + (microondas instanceof FuncaoForno)); // true
        System.out.println("O Micro-ondas tem Timer? " + (microondas instanceof Temporizavel)); // true
        
        System.out.println("O Fogão a Gás tem Forno? " + (fogaoGas instanceof FuncaoForno)); // true
    }
}