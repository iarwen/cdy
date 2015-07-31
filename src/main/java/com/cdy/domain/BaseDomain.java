package com.cdy.domain;

import java.io.Serializable;
import java.util.Date;

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
	/**id*/
	private long id;
	
	/**创建时间*/
	private Date createTime;
	
	/**更新时间*/
	private Date updateTime;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
 

}
