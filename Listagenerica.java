package clases;
import java.util.LinkedList;

public class ListaGenerica<T> {

    private final LinkedList<T> lista;

    public ListaGenerica() {
        this.lista = new LinkedList<>();
    }

    public void addLast(T element) {
        int i = lista.size();
        lista.add(i, element);
    }

    public T get(int index) {
        for (int i = 0; i < lista.size(); i++) {
            if (i == index) {
                return lista.get(i);
            }
        }
        return null;
    }

    public int getSize() {
        return lista.size();
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public boolean contains(T element) {
        return lista.contains(element);
    }

}