package com.cdy.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

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
 */
@MappedSuperclass
public abstract class BaseDomain implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4790880892674195147L;

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
