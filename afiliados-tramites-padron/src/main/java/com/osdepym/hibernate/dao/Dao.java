package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;

public interface Dao<T>{
	
	/**
	 * @param id
	 * @return specified entity
	 * @throws CustomException
	 */
	T get(Long id) throws CustomException;
    
    /**
     * @return list of specified entities
     * @throws CustomException
     */
    List<T> getAll() throws CustomException;
     
    /**
     * @param t
     * @return 
     * @throws CustomException
     */
    void save(T t) throws CustomException;
     
    /**
     * @param t
     * @throws CustomException
     */
    void update(T t) throws CustomException;
     
    /**
     * @param t
     * @throws CustomException
     */
    void delete(T t) throws CustomException;

}
