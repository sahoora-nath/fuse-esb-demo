package com.sahoora.fuse.demo.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import com.sahoora.fuse.demo.dao.StudentResultDao;
import com.sahoora.fuse.demo.dao.base.impl.EntityManagerBaseImpl;
import com.sahoora.fuse.demo.domain.StudentsResultDBO;

public class StudentResultDaoImpl extends EntityManagerBaseImpl<StudentsResultDBO, Long> implements StudentResultDao {
	
	public StudentResultDaoImpl() {
		super(StudentsResultDBO.class);
	}
	
	@Override
	public StudentsResultDBO save(StudentsResultDBO entityToSave) {
		StudentsResultDBO attachedEntity = findById(entityToSave.getId());
		if (attachedEntity == null) {
			attachedEntity = create(entityToSave);
			return attachedEntity;
		} else {
			return create(entityToSave);
		}
	}

	@Override
	public Double getStudentPercentage(int studentId) {
		TypedQuery<Double> query = 
				getEntityManager().createNamedQuery("StudentsResultDBO.findPercentageById", Double.class);
		query.setParameter("id", Long.valueOf(studentId));
		List<Double> resultList = query.getResultList();
		if (resultList.size() > 0) {
			return resultList.get(0);
		}
		return null;
	}
	
	@Override
	public StudentsResultDBO lookupStudent(int studentId) {
		return findById(Long.valueOf(studentId));
	}
}
