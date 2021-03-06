/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.service.sq;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ztel.app.vo.sq.RouteMonthstarVo;
import com.ztel.framework.vo.Pagination;

/**
 * @author yy
 * @since 2017年5月25日
 */
public interface RouteMonthstarService {
	public List<RouteMonthstarVo> searchRouteMonthstarList(Pagination<?> page);
	
	
	 List<RouteMonthstarVo> getRouteMonthstarsumPageList(Pagination<?> page);
	 
	 List<RouteMonthstarVo> getRoutestarbymonthList(Pagination<?> page);


	List<RouteMonthstarVo> getRoutestarbymonthPageList(Pagination<?> page);
	
}

