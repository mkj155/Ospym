package com.osdepym.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osdepym.dto.TestDTO;
import com.osdepym.hibernate.dao.TestCursoDAO;
import com.osdepym.hibernate.dao.TestCursoDAOImpl;
import com.osdepym.hibernate.dao.TestProfesoresDAO;
import com.osdepym.hibernate.entity.Cursos;


@Service
public class TestService{
	
	@Autowired
	private TestCursoDAO cursosDAO;

	@Transactional
	public List<TestDTO> getCursosByLetter(String letter) {
		
		List<Cursos> cursos = cursosDAO.getAll();
		List<TestDTO> cursosDTO = new ArrayList<TestDTO>();
		
		if(cursos != null){
			for(Cursos curso : cursos) {
				if(curso.getCurso().startsWith(letter) || letter == null) {
					TestDTO dto = new TestDTO();
					dto.setId(curso.getIdCurso());
					dto.setNombre(curso.getCurso());
					cursosDTO.add(dto);
				}
			}
		}
		
		return cursosDTO;
		
	}
}
