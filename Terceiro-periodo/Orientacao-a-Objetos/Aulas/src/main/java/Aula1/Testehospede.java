package Aula1;

import Aula2.Hospede;

import java.util.*;

public class Testehospede {
    public static void main(String[] args) {
        Hospede hosp = new Hospede();
        hosp.setNome("Matheus");
        hosp.setSobrenome("Martins dos Santos");
        System.out.println("Nome: " + hosp.getNome() + " " + hosp.getSobrenome());

        Date date = new Date();
        System.out.println(date);
    }
}
