package com.cibertec.contacto.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.contacto.model.Contacto;


@Repository
public interface IContacto extends CrudRepository<Contacto, Integer> {

}
