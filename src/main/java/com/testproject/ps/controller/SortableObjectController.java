package com.testproject.ps.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.testproject.ps.domain.SortableObject;
import com.testproject.ps.service.SortableObjectService;

@RequestMapping("/")
@Controller
public class SortableObjectController {

	@Autowired
	private SortableObjectService sortableObjectService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getdata() {
		ModelAndView model = new ModelAndView("index");
		List<SortableObject> objects = this.sortableObjectService.getAllObject();
		for (SortableObject sortableObject : objects) {
			if (sortableObject.getContent().length() > 30) {
				sortableObject.setContent(sortableObject.getContent().substring(0, 30) + "...");
			}
		}
		model.addObject("objects", objects);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "updatepositions")
	public @ResponseBody
	void updatePositions(@RequestParam final Map<String, String> params) throws Exception {
		String[] objects = params.get("order").split(",");
		HashMap<Long, Integer> positionMap = new HashMap<Long, Integer>();
		for (int i = 0; i < objects.length; i++) {
			positionMap.put(Long.valueOf(objects[i].substring(7)), i);
		}
		this.sortableObjectService.savePositions(positionMap);
	}
}
