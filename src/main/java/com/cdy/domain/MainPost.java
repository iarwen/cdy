package com.cdy.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *<br>
 * <b>类描述:</b>
 * 
 * <pre>
 * 主题对应的主题帖
 * </pre>
 * 
 * @see
 *@since
 */
@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "post_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("2")
public class MainPost extends Post {

    /**
     * 2014 by RD_wentao_chang
     * 2014年5月15日 下午3:04:17
     */
    private static final long serialVersionUID = -3720420143351850970L;

}
