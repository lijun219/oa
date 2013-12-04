package com.office.oa.security.shared;

import lombok.Getter;
import lombok.Setter;

/**
 * 抽象类,接口实现类注入参数
 * 
 * @author huan.tao
 * 
 */
public abstract class AbstarctDirectUrlResolver implements DirectUrlResolver {

	@Getter
	@Setter
	protected String directUrl; // 跳转登陆地址

}
