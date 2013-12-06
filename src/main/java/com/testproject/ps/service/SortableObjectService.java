package com.testproject.ps.service;

import java.util.List;
import java.util.Map;

import com.testproject.ps.domain.SortableObject;

public interface SortableObjectService {

	public List<SortableObject> getAllObject();

	public void savePositions(Map<Long, Integer> positionMap) throws Exception;

}
