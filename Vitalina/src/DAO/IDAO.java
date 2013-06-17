package DAO;
import java.util.ArrayList;

public interface IDAO <T> {
	
	void salvar(T objeto);
	
	ArrayList<T> buscar();
	T buscar(int codigo);
	
	void update(T objeto);
	
	void deletar(int codigo);
	
	int getLast();
}