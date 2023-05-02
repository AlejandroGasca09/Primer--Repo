package org.example;

import java.util.Arrays;

public class Caja <T>{
    public static final int CAPACIDAD =10;
    private T[] contend;

    public Caja() {

    }

    public Caja(T[] contend) {
        this.contend = contend;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "contend=" + Arrays.toString(contend) +
                '}';
    }
    public  void add(int pos , T objeto){
        contend[pos] = objeto;
    }
    public T get(int pos){
        return contend[pos];
    }
}
