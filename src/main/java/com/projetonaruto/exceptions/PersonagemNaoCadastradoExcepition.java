package com.projetonaruto.exceptions;

public class PersonagemNaoCadastradoExcepition extends RuntimeException{
    public PersonagemNaoCadastradoExcepition(String mensagem){
        super(mensagem);
    }
}