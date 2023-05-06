import javax.imageio.IIOException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LeerArchivo lectura = new LeerArchivo();
        try {
            lectura.metodouno("datos.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}