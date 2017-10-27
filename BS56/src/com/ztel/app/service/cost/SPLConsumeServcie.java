package com.ztel.app.service.cost;

import java.util.HashMap;
import java.util.List;

import com.ztel.app.vo.cost.SPLConsumeVo;
import com.ztel.framework.vo.Pagination;

public interface SPLConsumeServcie {


	public  List<SPLConsumeVo> getSPLConsumeVoPageList(Pagination<?> page);
	public  List<HashMap<String, String>>getDeptCombobox();
	public List<SPLConsumeVo> getSPLConsummaryList(Pagination<?> page);
	
}
