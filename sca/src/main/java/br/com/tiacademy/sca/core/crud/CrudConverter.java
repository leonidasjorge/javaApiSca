package br.com.tiacademy.sca.core.crud;

public interface CrudConverter<T, D> {

	D entidadeParaDTO(T entidade);
	T dtoParaEntidade(D dto);
	
}
