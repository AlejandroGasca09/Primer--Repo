package org.example;

import java.util.Arrays;

public class cajaSinGenericos {
    Object[] contend;

    public cajaSinGenericos() {
    }

    public cajaSinGenericos(Object[] contend) {
        this.contend = contend;
    }
    public  void add(int pos , Object objeto){
        contend[pos] = objeto;
    }
    public Object  get(int pos){
        return contend[pos];
    }

    @Override
    public String toString() {
        return "cajaSinGenericos{" +
                "contend=" + Arrays.toString(contend) +
                '}';
    }
}
