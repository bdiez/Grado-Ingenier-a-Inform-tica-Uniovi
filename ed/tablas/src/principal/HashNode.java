package principal;

/**
 * @author Néstor
 * @version 2013-14-V1
*/
public class HashNode<T> {
    T info;
    byte estado;

    final byte BORRADO = -1;
    final byte VACIO = 0;
    final byte LLENO = 1;

    HashNode () {
        info = null;
        estado=VACIO;
    }
    
    public T getInfo() {
        return info;
    }
    
    public void borrar (){
        estado=BORRADO;
    }
    
    public void setInfo(T elem){
        info=elem;
        estado=LLENO;
    }
    
    public byte getEstado() {
        return estado;
    }

}
