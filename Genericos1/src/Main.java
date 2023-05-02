import org.example.Caja;
import org.example.Comida;
import org.example.cajaSinGenericos;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Caja<String> miCaja = new Caja<>(new String[10]);
        miCaja.add(0,"Hola");
        miCaja.add(1,"Adios");
        miCaja.add(2,"Hi");
        System.out.println(miCaja);

        String temp = miCaja.get(0);

        System.out.println("-------");

        cajaSinGenericos cajaSin = new cajaSinGenericos( new Object[10]);
        cajaSin.add(0,"Hola");
        cajaSin.add(1,"Adios");
        cajaSin.add(2,"Hi");
        System.out.println(cajaSin);

        String temp2 = (String) miCaja.get(0);

        System.out.println("-----Comida-----");

        Caja<Comida> cajaComida = new Caja<>( new Comida[10]);
        cajaComida.add(0, new Comida("Yogurt",true));
        System.out.println(cajaComida.get(0));
        System.out.println("---------------");

        ArrayList <Comida> comidas = new ArrayList<>();
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Zanahoria",true));
        comidas.add(new Comida("Manzana",true));
        System.out.println(comidas.size());
        System.out.println(comidas.get(8));

        ArrayList<Comida> comidas2 = new ArrayList<>();
        comidas2.add( new Comida("Zanahoria",false));
        comidas2.add( new Comida("Yogurth",true));
        comidas2.add( new Comida("Danonino",true));
        comidas2.add( new Comida("Manzana",false));
        comidas2.add( new Comida("Bisteck",false));

        System.out.println(comidas2.get(3));
        comidas2.set(3, new Comida("Fresa",false));
        comidas2.add(3, new Comida("Naranja",false));

        System.out.println("-----------Final-------------");

        for (Comida comida : comidas2) {
            System.out.println(comida);
        }





    }
}