package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaJutsuEnum;
import com.projetonaruto.exceptions.PersonagemNaoGuerreiroExcepition;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Personagem  {

    private String Nome;
    private int Idade;
    private String Aldeia;
    private List<String> Jutsuses = new ArrayList<>();
    private int Chakra;

    public Personagem() {
    }
    public Personagem(String nome, int idade, String aldeia, String jutsus, int chakra) {
        this.Nome = nome;
        this.Idade = idade;
        this.Aldeia = aldeia;
        this.Jutsuses.add(jutsus);
        this.Chakra = chakra;
    }

    public void adicionarJutsu(String jutsu){
            Jutsuses.add(jutsu);
    }

    public boolean aumentarChakra(int chakra){
        this.Chakra += chakra;
        return true;
    }


    public String usarJutsu() {
        throw new PersonagemNaoGuerreiroExcepition("O personagem "+ getNome() + " não é guerreiro.");
    }


    public String desviar() {
        throw new PersonagemNaoGuerreiroExcepition("O personagem "+ getNome() + " não é guerreiro.");

    }
    @Override
    public String toString() {
        return "Personagem " + "\n" +
                "nome: " + Nome + "\n" +
                "idade: " + Idade + "\n" +
                "aldeia: " + Aldeia + "\n" +
                "jutsuses: " + Jutsuses + "\n" +
                "chakra: " + Chakra + "\n";
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public String getAldeia() {
        return Aldeia;
    }

    public void setAldeia(String aldeia) {
        Aldeia = aldeia;
    }

    public List<String> getJutsuses() {
        return Jutsuses;
    }


    public int getChakra() {
        return Chakra;
    }

    public void setChakra(int chakra) {
        Chakra = chakra;
    }
}