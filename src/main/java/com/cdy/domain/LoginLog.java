package com.cdy.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "t_login_log")
public class LoginLog extends BaseDomain {
  
    /**
     * 2014 by RD_wentao_chang
     * 2014年5月15日 
     */
    private static final long serialVersionUID = -5387540448796975006L;

	
	@Column(name = "login_datetime")
	private Date loginDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
    private User user;

	@Column(name = "ip")
	private String ip;

	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
