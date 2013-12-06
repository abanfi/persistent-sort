package com.testproject.ps.domain;

import javax.persistence.Column;

import org.hibernate.annotations.Type;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class SortableObject {

	/**
	 * Current number
	 */
	@Column
	private Integer position;

	/**
	 * Text content
	 */
	@Column
	@Type(type = "text")
	private String content = "";
}
