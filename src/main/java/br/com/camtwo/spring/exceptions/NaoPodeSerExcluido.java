package br.com.camtwo.spring.exceptions;

public class NaoPodeSerExcluido extends  RuntimeException {
    public NaoPodeSerExcluido(String message) {
        super(message);
    }

}
