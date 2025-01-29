package com.projetonaruto.service.impl;

import com.projetonaruto.dto.AumentarChakraDto;
import com.projetonaruto.dto.NovoJutsuDto;
import com.projetonaruto.dto.NovoPersonagemDto;
import com.projetonaruto.enuns.CategoriaJutsuEnum;
import com.projetonaruto.exceptions.JutsuInexistenteExcepition;
import com.projetonaruto.exceptions.PersonagemJaExistenteExcepition;
import com.projetonaruto.exceptions.PersonagemNaoCadastradoExcepition;
import com.projetonaruto.model.NinjaGenjutsu;
import com.projetonaruto.model.NinjaNinjutsu;
import com.projetonaruto.model.Personagem;
import com.projetonaruto.model.NinjaTaijutsu;
import com.projetonaruto.service.PersonagemServiceInterface;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonagemPersonagemServiceImpl implements PersonagemServiceInterface {

    Map<String, Personagem> personagensMap = new HashMap<>();
    @Override
    public Personagem novoPersonagem(NovoPersonagemDto dto) {
        if(personagemExiste(dto.nome())){
            throw new PersonagemJaExistenteExcepition("Personagem já cadastrado.");

        }else {
            Personagem novoPersonagem = criarPersonagem(dto.categoriaJutsu());
            novoPersonagem.setNome(dto.nome());
            novoPersonagem.setIdade(dto.idade());
            novoPersonagem.setAldeia(dto.aldeia());
            novoPersonagem.setChakra(dto.chakra());

            personagensMap.put(novoPersonagem.getNome().toUpperCase(),novoPersonagem);
            return novoPersonagem;
        }
    }

    @Override
    public Map<String, Personagem> buscar() {
        return personagensMap;
    }

    @Override
    public String usarJutsu(String nomeDoPersonagem){
        Personagem personagem = pesquisarPersonagem(nomeDoPersonagem);
            return("O personagem encontrado foi: " + personagem +
                    "e "+ personagem.usarJutsu());
    }

    @Override
    public String desviar(String nomeDoPersonagem){
        Personagem personagem = pesquisarPersonagem(nomeDoPersonagem);
        return("O personagem encontrado foi: " + personagem +
                "e "+ personagem.desviar());
    }

    @Override
    public Personagem adicionarJutsu(String nome, NovoJutsuDto dto){
        Personagem personagem = pesquisarPersonagem(nome);

        if(CategoriaJutsuEnum.contains(dto.novoJutsu())){
            personagem.adicionarJutsu(dto.novoJutsu());
        } else {
            throw new JutsuInexistenteExcepition("O jutsu "+dto.novoJutsu()+
                    " não consta no sistema.");
        }

        return personagem;
    }

    @Override
    public Personagem aumentarChakra(String nome, AumentarChakraDto dto){
        Personagem personagem = pesquisarPersonagem(nome);
        personagem.aumentarChakra(dto.quantidadeDeChakra());
        return personagem;
    }

    private  Personagem pesquisarPersonagem(String nome){
        Personagem personagemBuscado = personagensMap.get(nome.toUpperCase());

        if (personagemBuscado != null) {
            return personagemBuscado;
        } else {
            throw new PersonagemNaoCadastradoExcepition("O Personagem "+ nome + " não está cadastrado.");
        }
    }

    private boolean personagemExiste(String nome){
        if (personagensMap.containsKey(nome.toUpperCase())){
                return true;
        }
        return false;
    }

    private Personagem criarPersonagem(String categoria){
        if(categoria == null || categoria == ""){
            return new Personagem();
        }

        if(categoria.equalsIgnoreCase("ninjaTaijutsu")){
            Personagem personagem= new NinjaTaijutsu();
            personagem.adicionarJutsu(categoria.toUpperCase());
            return personagem;
        }

        if(categoria.equalsIgnoreCase("NinjaGenjutsu")){
            Personagem personagem = new NinjaGenjutsu();
            personagem.adicionarJutsu(categoria.toUpperCase());
            return personagem;
        }

        if(categoria.equalsIgnoreCase("NinjaNinjutsu")){
            Personagem personagem = new NinjaNinjutsu();
            personagem.adicionarJutsu(categoria.toUpperCase());
            return personagem;
        }

        throw new JutsuInexistenteExcepition("A categoria de Jutsu '" + categoria
       + "', não existe. ");
    }

}