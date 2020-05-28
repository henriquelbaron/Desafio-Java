package br.com.camtwo.spring.exceptions;

public class PessoaNaoEFuncionario extends  RuntimeException {
    public PessoaNaoEFuncionario(String message) {
        super(message);
    }

}
