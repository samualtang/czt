package com.ztel.app.vo.cost;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SPLApplyListVo {
    /**
     * id序号
     */
    private BigDecimal id;

    /**
     * 申请人id
     */
    private Long applyid;

    /**
     * 申请日期
     */
    private Date applydate;

    /**
     * 仓管审核人id
     */
    private Long keeperid;

    /**
     * 审核标志：0：未审核 10：仓管审核通过 20：仓管审核驳回 30：经理审核通过 40：经理审核驳回 50：发料完成60：退库完成
     */
    private String auditflag;

    /**
     * 仓管审核意见
     */
    private String keepersuggestion;

    /**
     * 仓管审核日期
     */
    private Date keeperauditdate;

    /**
     * 审核经理id
     */
    private Long mngid;

    /**
     * 审核经理意见
     */
    private String mngsuggestion;

    /**
     * 经理审核日期
     */
    private Date mngauditdate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 领料日期
     */
    private Date issuedate;

    /**
     * 部门id
     */
    private Integer deptid;

    /**
     * 申请物料用途
     */
    private String purpose;

    /**
     * 申请单标志（10：一般领料   20：生产领料）
     */
    private String listtype;

    /**
     * 10:申请领用，20：申请退库
     */
    private String applytype;
    
    /**
     * 申请人姓名
     */
    private String applyusername;
    
    /**
     * 经理审核姓名
     */
    private String mngusername;
    
    /**
     * 审核状态名称
     */
    private String auditflagname;
    
    /**
     * 查询关键字
     */
    private String keyword;
    
    /**
     * 删除标志
     */
    private String delstatus;
    
    /**
     * 部门名称
     */
    private String deptname;
    
    
    /**
     * 搜索的查询开始日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String startdate;
    /**
     * 搜索的结束日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String enddate;

    /**
     * id序号
     * @return ID id序号
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * id序号
     * @param id id序号
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * 申请人id
     * @return APPLYID 申请人id
     */
    public Long getApplyid() {
        return applyid;
    }

    /**
     * 申请人id
     * @param applyid 申请人id
     */
    public void setApplyid(Long applyid) {
        this.applyid = applyid;
    }

    /**
     * 申请日期
     * @return APPLYDATE 申请日期
     */
    public Date getApplydate() {
        return applydate;
    }

    /**
     * 申请日期
     * @param applydate 申请日期
     */
    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    /**
     * 仓管审核人id
     * @return KEEPERID 仓管审核人id
     */
    public Long getKeeperid() {
        return keeperid;
    }

    /**
     * 仓管审核人id
     * @param keeperid 仓管审核人id
     */
    public void setKeeperid(Long keeperid) {
        this.keeperid = keeperid;
    }

    /**
     * 审核标志：0：未审核 10：仓管审核通过 20：仓管审核驳回 30：经理审核通过 40：经理审核驳回 50：发料完成60：退库完成
     * @return AUDITFLAG 审核标志：0：未审核 10：仓管审核通过 20：仓管审核驳回 30：经理审核通过 40：经理审核驳回 50：发料完成60：退库完成
     */
    public String getAuditflag() {
        return auditflag;
    }

    /**
     * 审核标志：0：未审核 10：仓管审核通过 20：仓管审核驳回 30：经理审核通过 40：经理审核驳回 50：发料完成60：退库完成
     * @param auditflag 审核标志：0：未审核 10：仓管审核通过 20：仓管审核驳回 30：经理审核通过 40：经理审核驳回 50：发料完成60：退库完成
     */
    public void setAuditflag(String auditflag) {
        this.auditflag = auditflag == null ? null : auditflag.trim();
    }

    /**
     * 仓管审核意见
     * @return KEEPERSUGGESTION 仓管审核意见
     */
    public String getKeepersuggestion() {
        return keepersuggestion;
    }

    /**
     * 仓管审核意见
     * @param keepersuggestion 仓管审核意见
     */
    public void setKeepersuggestion(String keepersuggestion) {
        this.keepersuggestion = keepersuggestion == null ? null : keepersuggestion.trim();
    }

    /**
     * 仓管审核日期
     * @return KEEPERAUDITDATE 仓管审核日期
     */
    public Date getKeeperauditdate() {
        return keeperauditdate;
    }

    /**
     * 仓管审核日期
     * @param keeperauditdate 仓管审核日期
     */
    public void setKeeperauditdate(Date keeperauditdate) {
        this.keeperauditdate = keeperauditdate;
    }

    /**
     * 审核经理id
     * @return MNGID 审核经理id
     */
    public Long getMngid() {
        return mngid;
    }

    /**
     * 审核经理id
     * @param mngid 审核经理id
     */
    public void setMngid(Long mngid) {
        this.mngid = mngid;
    }

    /**
     * 审核经理意见
     * @return MNGSUGGESTION 审核经理意见
     */
    public String getMngsuggestion() {
        return mngsuggestion;
    }

    /**
     * 审核经理意见
     * @param mngsuggestion 审核经理意见
     */
    public void setMngsuggestion(String mngsuggestion) {
        this.mngsuggestion = mngsuggestion == null ? null : mngsuggestion.trim();
    }

    /**
     * 经理审核日期
     * @return MNGAUDITDATE 经理审核日期
     */
    public Date getMngauditdate() {
        return mngauditdate;
    }

    /**
     * 经理审核日期
     * @param mngauditdate 经理审核日期
     */
    public void setMngauditdate(Date mngauditdate) {
        this.mngauditdate = mngauditdate;
    }

    /**
     * 备注信息
     * @return REMARKS 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注信息
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 领料日期
     * @return ISSUEDATE 领料日期
     */
    public Date getIssuedate() {
        return issuedate;
    }

    /**
     * 领料日期
     * @param issuedate 领料日期
     */
    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    /**
     * 部门id
     * @return DEPTID 部门id
     */
    public Integer getDeptid() {
        return deptid;
    }

    /**
     * 部门id
     * @param deptid 部门id
     */
    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    /**
     * 申请物料用途
     * @return PURPOSE 申请物料用途
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * 申请物料用途
     * @param purpose 申请物料用途
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    /**
     * 申请单标志（10：一般领料   20：生产领料）
     * @return LISTTYPE 申请单标志（10：一般领料   20：生产领料）
     */
    public String getListtype() {
        return listtype;
    }

    /**
     * 申请单标志（10：一般领料   20：生产领料）
     * @param listtype 申请单标志（10：一般领料   20：生产领料）
     */
    public void setListtype(String listtype) {
        this.listtype = listtype == null ? null : listtype.trim();
    }

    /**
     * 10:申请领用，20：申请退库
     * @return APPLYTYPE 10:申请领用，20：申请退库
     */
    public String getApplytype() {
        return applytype;
    }

    /**
     * 10:申请领用，20：申请退库
     * @param applytype 10:申请领用，20：申请退库
     */
    public void setApplytype(String applytype) {
        this.applytype = applytype == null ? null : applytype.trim();
    }

	public String getApplyusername() {
		return applyusername;
	}

	public void setApplyusername(String applyusername) {
		this.applyusername = applyusername;
	}

	public String getMngusername() {
		return mngusername;
	}

	public void setMngusername(String mngusername) {
		this.mngusername = mngusername;
	}

	public String getAuditflagname() {
		return auditflagname;
	}

	public void setAuditflagname(String auditflagname) {
		this.auditflagname = auditflagname;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getDelstatus() {
		return delstatus;
	}

	public void setDelstatus(String delstatus) {
		this.delstatus = delstatus;
	}

	
}