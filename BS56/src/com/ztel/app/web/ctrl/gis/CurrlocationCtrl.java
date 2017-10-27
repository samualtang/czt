package com.ztel.app.web.ctrl.gis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztel.app.service.gis.CurrlocationVoService;
import com.ztel.app.vo.gis.CurrlocationVo;
import com.ztel.app.vo.wms.CigarettedamagedVo;
import com.ztel.framework.vo.Pagination;
import com.ztel.framework.web.ctrl.BaseCtrl;

/**
 * 工业来烟接口数据车辆当前位置
 * @author lcf
 *
 */
@Controller
@RequestMapping("/gis/currlocation")
public class CurrlocationCtrl  extends BaseCtrl{
	private static Logger logger = LogManager.getLogger(CurrlocationCtrl.class);
	
	@Autowired 
	private CurrlocationVoService currlocationVoService = null;
	
	@RequestMapping("toCurrlocation")
	public String toCurrlocation(HttpServletRequest request) {
		return "/gis/v_currlocation";
	}
	
	@RequestMapping(value="getCurrlocationPageList")
	 @ResponseBody
	 public Map<String, Object> getCurrlocationPageList(HttpServletRequest request) throws Exception{
		 Map<String, Object> result=new HashMap<String, Object>();  
		 
//		 String keyword = cigarettedamagedVo.getKeyword();
		 String status = request.getParameter("status");
		 String keyword = request.getParameter("keyword");
		 if(status==null||status.equals(""))status="00";

		Pagination<?> page = this.getPagination(request);
		CurrlocationVo currlocationVo = new CurrlocationVo();
		currlocationVo.setStatus(status);
		if(keyword!=null&&!keyword.equals(""))currlocationVo.setKeyword(keyword);
		if (currlocationVo!=null) {
			 page.setParam(currlocationVo);
		}
		List<CurrlocationVo> currlocationVoList = new ArrayList<CurrlocationVo>();
		currlocationVoList = currlocationVoService.getCurrlocationPageList(page);
		
		 result.put("rows",currlocationVoList);  
		 result.put("total",page.getTotalCount());  
		 
		return result;
	}
}
