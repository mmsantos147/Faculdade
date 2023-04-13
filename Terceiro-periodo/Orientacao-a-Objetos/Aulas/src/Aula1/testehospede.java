package Aula1;

import sla.*;

import java.util.*;

public class testehospede {
    public static void main(String[] args) {
        Hospede hosp = new Hospede();
        hosp.setNome("Matheus");
        hosp.setSobrenome("Martins dos Santos");
        System.out.println("Nome: " + hosp.getNome() + " " + hosp.getSobrenome());

        Date date = new Date();
        System.out.println(date);
    }
}
