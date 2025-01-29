package com.projetonaruto.fixture;

import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.model.NinjaGenjutsu;
import com.projetonaruto.model.Personagem;

public class DtoFixture {

    public static NovoPersonagemDto ninjaGenjutsuDto() {
        return new NovoPersonagemDto(
                "Genjutsu",
                21,
                "São Paulo",
                "ninjaGenjutsu",
                10
        );
    }

    public static NovoPersonagemDto ninjaNinjutsu() {
        return new NovoPersonagemDto(
                "Ninjutsu",
                31,
                "Campinas",
                "ninjaNinjutsu",
                20
        );
    }

    public static NovoPersonagemDto ninjaTaijutsuDto() {
        return new NovoPersonagemDto(
                "Taijutsu",
                41,
                "minas",
                "nijaTaijutsu",
                30
        );
    }

    public static NovoPersonagemDto personagemDto() {
        return new NovoPersonagemDto(
                "Personagem",
                45,
                "Santos",
                "",
                40
        );
    }

    public static NovoPersonagemDto personagemComCategoriaErradaDto() {
        return new NovoPersonagemDto(
                "Personagem",
                45,
                "Santos",
                "categoria inexistente",
                40
        );
    }
}