package com.projetonaruto.fixture;

import com.projetonaruto.model.NinjaGenjutsu;
import com.projetonaruto.model.Personagem;

public class PersonagensFixture {

    public static Personagem ninjaGenjutsu(){
        return new NinjaGenjutsu(
                "Genjutsu",
                21,
                "São Paulo",
                "ninjaGenjutsu",
                10
        );
    }

    public static Personagem ninjaNinjutsu(){
        return new NinjaGenjutsu(
                "Ninjutsu",
                31,
                "Campinas",
                "ninjaNinjutsu",
                20
        );
    }

    public static Personagem ninjaTaijutsu(){
        return new NinjaGenjutsu(
                "Taijutsu",
                41,
                "minas",
                "ninjaTaijutsu",
                30
        );
    }

    public static Personagem personagem(){
        return new NinjaGenjutsu(
                "Personagem",
                45,
                "Santos",
                "",
                40
        );
    }
}