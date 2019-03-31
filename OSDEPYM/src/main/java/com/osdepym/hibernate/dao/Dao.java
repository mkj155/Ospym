package com.osdepym.hibernate.dao;

import java.util.List;

public interface Dao<T>{
	
	T get(Integer id);
    
    List<T> getAll();
     
    boolean save(T t);
     
    boolean update(T t);
     
    boolean delete(T t);

}
