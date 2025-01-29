package com.projetonaruto.exceptions;

public class PersonagemJaExistenteExcepition extends RuntimeException{
    public PersonagemJaExistenteExcepition(String mensagem){
        super(mensagem);
    }
}