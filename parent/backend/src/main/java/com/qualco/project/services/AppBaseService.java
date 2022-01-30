package com.qualco.project.services;

import java.util.List;

public interface AppBaseService<ENTITY, ID_TYPE> {

  ENTITY getById(ID_TYPE id);

  List<ENTITY> getAll();

  boolean delete(ID_TYPE id);

  ENTITY createWithEntity(ENTITY entity);

}
