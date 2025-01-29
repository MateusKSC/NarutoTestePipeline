package com.projetonaruto.model;

import com.projetonaruto.enuns.CategoriaJutsuEnum;
import com.projetonaruto.interfaces.Ninja;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NinjaGenjutsu extends Personagem implements Ninja {

    public NinjaGenjutsu() {
        super();
    }

    public NinjaGenjutsu(String nome, int idade, String aldeia, String jutsus, int chakra) {
        super(nome, idade, aldeia, jutsus, chakra);
    }

    @Override
    public String usarJutsu() {
        return "O personagem está usando um jutsu de NinjaGenjutsu.";
    }

    @Override
    public String desviar() {
        return "o personagem está desviando de um ataque usando sua habilidade em NinjaGenjutsu";
    }
}