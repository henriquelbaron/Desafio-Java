package br.com.camtwo.spring.util;

import br.com.camtwo.spring.exceptions.DataFormatoErrado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilsDate {

    private final static String DATA = "dd/MM/yyyy";

    public static LocalDate stringToLocalDate(String data) {
        if(data == null || data.isEmpty()) return null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATA);
            return LocalDate.parse(data, formatter);
        }catch (Exception e){
            throw  new DataFormatoErrado("Data não deve estar no formato dd/MM/yyyy");

        }
    }
}
