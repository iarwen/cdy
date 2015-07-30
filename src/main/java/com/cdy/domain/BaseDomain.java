package com.cdy.domain;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 所有entity的基类
 * @author changwentao
 *
 */

public class BaseDomain implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 4790880892674195147L;

	/**所有entity都有的属性*/
	private long id;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
 

}
