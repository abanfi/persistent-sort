package com.testproject.ps.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.testproject.ps.domain.SortableObject;
import com.testproject.ps.service.SortableObjectService;

@Service
public class SortableObjectServiceImpl implements SortableObjectService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<SortableObject> getAllObject() {
		return this.entityManager.createQuery("SELECT o FROM SortableObject o order by o.position",
				SortableObject.class).getResultList();
	}

	@Override
	public void savePositions(final Map<Long, Integer> positionMap) throws Exception {
		for (Long objectId : positionMap.keySet()) {
			SortableObject sortableObject = SortableObject.findSortableObject(objectId);
			sortableObject.setPosition(positionMap.get(objectId));
			sortableObject.merge();
		}
	}

}
