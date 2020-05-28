package br.com.camtwo.spring.exceptions;

public class DataFormatoErrado extends  RuntimeException {
    public DataFormatoErrado(String message) {
        super(message);
    }

}
