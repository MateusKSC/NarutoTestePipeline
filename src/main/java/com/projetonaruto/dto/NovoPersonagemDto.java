package com.projetonaruto.dto;

import com.projetonaruto.enuns.CategoriaJutsuEnum;

public record NovoPersonagemDto(


        String nome,
        int idade,
        String aldeia,
        String categoriaJutsu,
         int chakra
) {
}
