package principal;

/**
 * @author N�stor
 * @version 2013-14-V2
*/
public abstract class AbstractHash <T extends Comparable<T>>{

    /**
     * Devuelve el n�mero de elementos que contiene la tabla Hash en el momento de la invocaci�n
     * 
     * @return El n�mero de elementos.
     */
    abstract public int getNumElem();


    /**
     * Devuelve el tama�o de la tabla Hash
     * 
     * @return El tama�o de la tabla, deber�a ser un n�mero primo
     */
    abstract public int getSize();
    
    /**
     * Inserta un nuevo elemento en la tabla hash 
     *  
     * @param elem Elemento que se inserta
     * @return true si lo ha insertado o false en caso contrario
     */
    abstract public boolean  add(T elem);

    /**
     * Busca y devuelve un elemento de la tabla hash 
     * 
     * @param elem La clave que se busca, 
     *  
     * @return El elemento encontrado si lo encuentra o null en caso contrario
     */
    abstract public T find(T elem);

    /**
     * Borra un elemento que se encuentra en la tabla hash
     * 
     * @param elem elemento para borrar
     * @return true si lo ha borrado o false en caso contrario
     */
    abstract public boolean remove(T elem);

    /**
     * Realiza una redispersi�n (aumentando el tama�o) si es necesario por FC alto
     * 
     * @return true si la realiza, false en caso contrario
     */
    abstract protected boolean redispersion ();

    /**
     * Realiza una redispersi�n inversa (dismiuyendo el tama�o) si es necesario por FC peque�o
     * @return true si la realiza, false en caso contrario
     */
    abstract protected boolean redispersionInversa();

    /**
     * Convierte la tabla a una String que se pueda mostrar de forma "visible"
     *
     * @return el String con la informaci�n de la tabla hash
     */
    abstract public String toString ();

    /**
     * Calcula el resultado de aplicar la funci�n hash sobre el par�metro
     * Si es un entero, utiliza la funci�n fHashInteger()
     * Si es un String, utiliza la funci�n fHashString()
     * Si es otro objeto, utiliza hashCode()
     *
     * @return el resultado correspondiente
     */
     protected int fHash(T elem){
         if (elem instanceof Integer) 
             return fHashInteger((Integer) elem);
         else if (elem instanceof String) 
             return fHashString((String) elem);
         else 
             return elem.hashCode()%getSize();
     }

    /**
     * Calcula el resultado de aplicar la funci�n hash sobre enteros de teor�a
     *
     * @return el resultado correspondiente
     */
     abstract protected int fHashInteger (int clave);
 


    /**
     * Calcula el resultado de aplicar la funci�n hash sobre String de teor�a 
     *        utiliza la longitud completa del String
     *
     * @return el resultado correspondiente
     */
     abstract protected int fHashString(String clave); 


    /**
      * 
      * Calcula si un n�mero positivo es un n�mero primo, los negativos devuelve que no lo son
      * 
     * @param n El n�mero que queremos comprobar
     * @return true si es primo, false en caso contrario
     */
    protected boolean esPrimo(long n){
         if (n<0 || n%2==0)
             return false;
         if (n<=7)
             return true;
         for (int i=3;i*i<=n;i+=2) //impares
             if (n%i==0)
                 return false; // no es primo
         return true;
     }
     
     protected int numPrimoMayor(int n){
         int num=n+1;
         while (!esPrimo(num)) {
        	 num++;
         }
         return num;
     }
     
     protected int numPrimoMenor (int n){
         int num=n;
         while (!esPrimo(num)) {
             num--;
         }
         return num;
     }

}
