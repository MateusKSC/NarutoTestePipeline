package com.projetonaruto.service;

import com.projetonaruto.dto.AumentarChakraDto;
import com.projetonaruto.dto.NovoJutsuDto;
import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.model.Personagem;
import java.util.Map;

public interface PersonagemServiceInterface {

    public Personagem novoPersonagem(NovoPersonagemDto novoPersonagem);

    public Map<String, Personagem> buscar();

    public String usarJutsu(String nomeDoPersonagem);

    public String desviar(String nomeDoPersonagem);

    public Personagem adicionarJutsu(String nome, NovoJutsuDto dto);

    public Personagem aumentarChakra(String nome, AumentarChakraDto dto);
}
