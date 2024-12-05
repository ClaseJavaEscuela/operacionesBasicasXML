package Ejemplo_1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileXML {
    private String path;
    private List<Producto> productos;

    public FileXML(String path) {
        this.path = path;
        this.productos = new ArrayList<>();
    }

    public void radeFileXML() {}
    public void writeFileXML(Producto nuevoProducto) {
        try{
            productos.add(nuevoProducto);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =factory.newDocumentBuilder();
            Document documento = builder.newDocument();
            Element raiz = documento.createElement("Producto");
            documento.appendChild(raiz);
            for(Producto producto:productos){
                Element etiquetaProducto = documento.createElement("producto");
                raiz.appendChild(etiquetaProducto);

                Element nombre = documento.createElement("nombre");
                nombre.appendChild(documento.createTextNode(producto.getNombre()));
                etiquetaProducto.appendChild(nombre);
                Element precio = documento.createElement("precio");
                precio.appendChild(documento.createTextNode(String.valueOf(producto.getPrecio())));
                etiquetaProducto.appendChild(precio);
                Element stock = documento.createElement("stock");
                stock.appendChild(documento.createTextNode(String.valueOf(producto.getStock())));
                etiquetaProducto.appendChild(stock);
                Element categoria = documento.createElement("categoria");
                categoria.appendChild(documento.createTextNode(producto.getCategoria()));
                etiquetaProducto.appendChild(categoria);
                Element id = documento.createElement("id");
                id.appendChild(documento.createTextNode(producto.getId()));
                etiquetaProducto.appendChild(id);
            }
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File(this.path));

        }catch (ParserConfigurationException e){
            System.out.println("Error: "+e.getMessage());
        }

    }

}
