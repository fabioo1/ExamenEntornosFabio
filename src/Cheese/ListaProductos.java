/*
 * Examen Entornos de desarrollo - Enunciado
 */

package Cheese;
/**
 * Imports del paquete
 */

import java.util.ArrayList;
import java.util.HashMap;


public class ListaProductos {

    /**
     * Estructura HashMap para almacenar los productos de la lista de productos
     * @see "HashMap java doc"
     */
    private HashMap<String, Producto> listaP = new HashMap();
    
    /**
     * Cuenta calculada con el número de productos contenidos en la lista
     */
    private static int n = 0;


    
    private int getN() {
        return n;
    }

    private void setN(int n) {
        this.n = n;
    }
    /**
     * Comprueba si la cadena pasada es valida ( no está vacía)
     * @param campo cadena a analizar
     * @return True: Cadena vacía, False: Cadena correcta
     */
    private boolean check_null(String campo){
    
        if (campo.replace(" ","") == "")  return true; else return false;
    }
    
    /**
     * Comprueba si un producto está duplicado o no
     * @param prod objeto a analizar
     * @return null en el caso de que esté duplicado y el propio producto si no lo está
     */
    public Producto addProducto(Producto prod) {
        
        if ((prod.getcode()==null) || (prod.getcode().isEmpty())) {
            return null;
        }
        
        if (listaP.containsKey(prod.getcode())) {
            // System.out.println("Producto con código duplicado");
            return null;
        }
        n++;
        this.setN(n);
        listaP.put(prod.getcode(), prod);
        return prod;
    }

    /**
     * Elimina el producto que se le indica como parámetro de entrada
     * @param codigo cadena a analizar
     * @return prod si la cadena a analizar no es null, sino devuelve null.
     */
    public Producto eliminarProducto(String codigo) { 
        
        if ((codigo==null) || (codigo.isEmpty())) {
            return null;
        }
        
        Producto prod = buscarProducto(codigo);
        if (prod != null) {
        listaP.remove(codigo);
        n--;
        this.setN(n);
        }
        return prod;
    }

    /**
     * Comprueba que si el producto no está en la lista con ese código le
     * devolverá un valor nulo. En cambio, si está con ese código le devuelve
     * el producto con ese código.
     * @param codigo caden a analizar
     * @return null: si no está el producto con ese código. prod: si está con ese
     * código.
     */
    public Producto buscarProducto(String codigo) { 
        Producto prod = null;
        
        if ((codigo==null) || (codigo.isEmpty())) {
            return null;
        }
        
        if (!listaP.containsKey(codigo)) {
            return prod;
        }
        else{
            return listaP.get(codigo);
        }
    }

    /**
     * Devuelve toda la lista de productos.
     * @return prodsList.
     */
    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> prodsList = new ArrayList<>();
        prodsList.addAll(listaP.values());
        return prodsList;
    }
    
    /**
     * Devuelve la cantidad de productos que hay.
     * @return n proveniente de la función privada getN.
     */
    public int totalProductos(){
            return this.getN();
    }
}
