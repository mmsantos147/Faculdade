package Laboratorios.lab12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Rodrigo");
        lista.add("Matheus");

        Iterator<String> it = lista.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
