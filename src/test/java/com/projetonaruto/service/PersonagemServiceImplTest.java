package com.projetonaruto.service;

import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.exceptions.JutsuInexistenteExcepition;
import com.projetonaruto.fixture.DtoFixture;
import com.projetonaruto.model.NinjaTaijutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.service.impl.PersonagemPersonagemServiceImpl;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonagemServiceImplTest {

    @InjectMocks
    private PersonagemPersonagemServiceImpl service;
    private NovoPersonagemDto personagem01Dto;
    private NovoPersonagemDto personagemTaijutsuDto;
    private NovoPersonagemDto personagemGenjutsuDto;
    private NovoPersonagemDto personagemNinjutsuDto;

    private Personagem personagem;


    @BeforeEach
    void setUp() {
        personagem01Dto = DtoFixture.personagemDto();
        personagemTaijutsuDto = DtoFixture.ninjaTaijutsuDto();
        personagemGenjutsuDto = DtoFixture.ninjaGenjutsuDto();
        personagemNinjutsuDto = DtoFixture.ninjaNinjutsu();
    }

    @Test
    void novoPersonagemComCategoriaVazia() {
        NovoPersonagemDto dto = DtoFixture.personagemDto();
        Personagem personagemRetornado = service.novoPersonagem(dto);

        assertTrue(personagemRetornado instanceof Personagem);
        assertTrue(personagemRetornado.getJutsuses().isEmpty());
        assertEquals(personagemRetornado.getNome(), dto.nome());
        assertEquals(personagemRetornado.getAldeia(), dto.aldeia());
        assertEquals(personagemRetornado.getIdade(), dto.idade());
        assertEquals(personagemRetornado.getChakra(), dto.chakra());
    }

    @Test
    void novoPersonagemComCategoriaNijaTaijutsu() {
        NovoPersonagemDto dto = DtoFixture.ninjaNinjutsu();
        Personagem personagemRetornado = service.novoPersonagem(dto);

        assertTrue(personagemRetornado instanceof Personagem);
        assertFalse(personagemRetornado.getJutsuses().isEmpty());
        assertEquals(personagemRetornado.getNome(), dto.nome());
        assertEquals(personagemRetornado.getAldeia(), dto.aldeia());
        assertEquals(personagemRetornado.getIdade(), dto.idade());
        assertEquals(personagemRetornado.getChakra(), dto.chakra());
    }

    @Test
    void novoPersonagemComCategoriaGenjutsu() {
        NovoPersonagemDto dto = DtoFixture.ninjaGenjutsuDto();
        Personagem personagemRetornado = service.novoPersonagem(dto);

        assertTrue(personagemRetornado instanceof Personagem);
        assertFalse(personagemRetornado.getJutsuses().isEmpty());
        assertEquals(personagemRetornado.getNome(), dto.nome());
        assertEquals(personagemRetornado.getAldeia(), dto.aldeia());
        assertEquals(personagemRetornado.getIdade(), dto.idade());
        assertEquals(personagemRetornado.getChakra(), dto.chakra());
    }


}