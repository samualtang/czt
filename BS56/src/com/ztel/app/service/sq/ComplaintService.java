package com.ztel.app.service.sq;

import java.util.List;
import java.util.Map;

import com.ztel.app.vo.sq.ComplaintVo;
import com.ztel.framework.vo.Pagination;

public interface ComplaintService {

	public List<ComplaintVo> getComplaintList(Pagination<?> page);
	
	public void doNewComplaint(ComplaintVo complaintVo);
	
	public void doUpdate(ComplaintVo complaintVo);
	
	public void deleteByPrimaryKey(List<Integer> ids);
	
	/**
	 * 投诉报表、返回type类型的数量和部门
	 * @param type
	 * @return
	 */
	public  Map<String, Object>  getComplaintReport(String starttime,String endtime);
}
