package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;

public interface PlantillaServicio<E> {
	
	public List<E> listado();
	
	public E bucar(Integer id);
	
	public void guardar(E inmueble);
	
	public void eliminar(Integer id);
	
	public void actualizar(E actualizado);

}
