package com.ztel.app.service.produce.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztel.app.persist.mybatis.produce.OrderVoMapper;
import com.ztel.app.service.produce.OrderService;
import com.ztel.app.vo.produce.OrderVo;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderVoMapper orderVoMapper = null;

	@Override
	public String selectOrderdate() {
		// TODO Auto-generated method stub
//		OrderVo orderVo = orderVoMapper.selectOrderdate();
//		
//		
//		Date orderdateD = new Date();
//		if( orderVo!=null&& orderVo.getOrderdate()!=null)
//		orderdateD =  orderVo.getOrderdate();
//		
//		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
//		String orderdate = sdf.format(orderdateD);
		return null;
	}

}
