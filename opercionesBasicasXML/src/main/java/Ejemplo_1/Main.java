package Ejemplo_1;

public class Main {
    public static void main(String[] args) {
        FileXML fileXML = new FileXML("productos.xml");

        fileXML.writeFileXML(new Producto("producto 1",25.0,10,"electronicos","1"));

    }
}