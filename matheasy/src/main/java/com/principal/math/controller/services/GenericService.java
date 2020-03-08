package com.principal.math.controller.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericService<E, Repository extends JpaRepository<E, Integer>> {

	@Autowired
	private Repository r;

	public boolean verificaEntidade(Integer id) throws HibernateException {

		if (r.existsById(id)) {
			return false;
		} else {
			return true;
		}
	}
	
	public void salvar(E e) throws HibernateException {
		r.save(e);
	}

	public boolean existePorId(Integer id) throws HibernateException {
		return r.existsById(id);
	}

	public List<E> retornarLista() throws HibernateException {
		return r.findAll();
	}

	public void deletar(Integer id) throws HibernateException {
		r.deleteById(id);
	}

	public void atualizar(E e, Integer id) {

		if (verificaEntidade(id)) {

			E novoE = r.getOne(id);
			novoE = e;
			r.save(novoE);

		} else {
			return;
		}
	}
}
