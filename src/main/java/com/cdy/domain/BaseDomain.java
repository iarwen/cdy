package com.cdy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * <br>
 * <b>类描述:</b>
 *
 * <pre>
 * 所有PO的父类
 * </pre>
 *
 * @see
 * @since
 */
public class BaseDomain implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4790880892674195147L;

	@Column
	@Id
	private String id;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
