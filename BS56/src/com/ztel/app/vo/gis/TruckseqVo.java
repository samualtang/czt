package com.ztel.app.vo.gis;

import java.math.BigDecimal;
import java.util.Date;

public class TruckseqVo {
    /**
     * null
     */
    private BigDecimal id;

    /**
     * 车牌
     */
    private String vehicleno;

    /**
     * 工业公司名称
     */
    private String companyname;

    /**
     * 司机电话号码
     */
    private BigDecimal telnum;

    /**
     * 件数
     */
    private BigDecimal qty;

    /**
     * 入园时间
     */
    private Date arrivetime;

    /**
     * 开锁时间
     */
    private Date unlocktime;

    /**
     * 交单时间
     */
    private Date billtime;

    /**
     * 开始扫码时间
     */
    private Date begscantime;

    /**
     * 结束扫码时间
     */
    private Date endscantime;

    /**
     * 出园时间
     */
    private Date backtime;

    /**
     * 排队顺序
     */
    private BigDecimal seq;

    /**
     * 10:入园    20:开锁  30:交单  40:扫码卸货   50:卸货完成  55:同意出园 60:出园  
     */
    private BigDecimal status;
    
    /**
     * 10:入园    20:开锁  30:交单  40:扫码卸货   50:卸货完成  55:同意出园 60:出园  
     */
    private String statusname;

    /**
     * 装卸组code
     */
    private String groupcode;
    
    /**
     * 装卸组名称
     */
    private String groupname;

    /**
     * 批次
     */
    private String batchId;
    
    /**
     * 合同号
     */
    private String contractno;
    
    /**
     * 准运证
     */
    private String navicert;
    
    private String keyword;
    
    /**
     * 装卸用时(小时)
     */
    private BigDecimal loadtime;
    
    /**
     * 装卸效率
     */
    private BigDecimal efficiency;
    
    /**
     * 开始搜索时间
     */
    private Date searchbegtime;
    
    /**
     * 结束搜索时间
     */
    private Date searchendtime;
    
    /**
     * 装卸组人员名称
     */
    private String membername;

    /**
     * null
     * @return ID null
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * null
     * @param id null
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * 车牌
     * @return vehicleno 车牌
     */
    public String getVehicleno() {
        return vehicleno;
    }

    /**
     * 车牌
     * @param vehicleno 车牌
     */
    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno == null ? null : vehicleno.trim();
    }

    /**
     * 工业公司名称
     * @return COMPANYNAME 工业公司名称
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * 工业公司名称
     * @param companyname 工业公司名称
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    /**
     * 司机电话号码
     * @return TELNUM 司机电话号码
     */
    public BigDecimal getTelnum() {
        return telnum;
    }

    /**
     * 司机电话号码
     * @param telnum 司机电话号码
     */
    public void setTelnum(BigDecimal telnum) {
        this.telnum = telnum;
    }

    /**
     * 件数
     * @return QTY 件数
     */
    public BigDecimal getQty() {
        return qty;
    }

    /**
     * 件数
     * @param qty 件数
     */
    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * 入园时间
     * @return ARRIVETIME 入园时间
     */
    public Date getArrivetime() {
        return arrivetime;
    }

    /**
     * 入园时间
     * @param arrivetime 入园时间
     */
    public void setArrivetime(Date arrivetime) {
        this.arrivetime = arrivetime;
    }

    /**
     * 开锁时间
     * @return UNLOCKTIME 开锁时间
     */
    public Date getUnlocktime() {
        return unlocktime;
    }

    /**
     * 开锁时间
     * @param unlocktime 开锁时间
     */
    public void setUnlocktime(Date unlocktime) {
        this.unlocktime = unlocktime;
    }

    /**
     * 交单时间
     * @return BILLTIME 交单时间
     */
    public Date getBilltime() {
        return billtime;
    }

    /**
     * 交单时间
     * @param billtime 交单时间
     */
    public void setBilltime(Date billtime) {
        this.billtime = billtime;
    }

    /**
     * 开始扫码时间
     * @return BEGSCANTIME 开始扫码时间
     */
    public Date getBegscantime() {
        return begscantime;
    }

    /**
     * 开始扫码时间
     * @param begscantime 开始扫码时间
     */
    public void setBegscantime(Date begscantime) {
        this.begscantime = begscantime;
    }

    /**
     * 结束扫码时间
     * @return ENDSCANTIME 结束扫码时间
     */
    public Date getEndscantime() {
        return endscantime;
    }

    /**
     * 结束扫码时间
     * @param endscantime 结束扫码时间
     */
    public void setEndscantime(Date endscantime) {
        this.endscantime = endscantime;
    }

    /**
     * 出园时间
     * @return BACKTIME 出园时间
     */
    public Date getBacktime() {
        return backtime;
    }

    /**
     * 出园时间
     * @param backtime 出园时间
     */
    public void setBacktime(Date backtime) {
        this.backtime = backtime;
    }

    /**
     * 排队顺序
     * @return SEQ 排队顺序
     */
    public BigDecimal getSeq() {
        return seq;
    }

    /**
     * 排队顺序
     * @param seq 排队顺序
     */
    public void setSeq(BigDecimal seq) {
        this.seq = seq;
    }

    /**
     * 10:入园    20:开锁  30:交单  40:扫码卸货   50:卸货完成  55:同意出园 60:出园  
     * @return STATUS 10:入园    20:开锁  30:交单  40:扫码卸货   50:卸货完成  55:同意出园 60:出园  
     */
    public BigDecimal getStatus() {
        return status;
    }

    /**
     * 10:入园    20:开锁  30:交单  40:扫码卸货   50:卸货完成  55:同意出园 60:出园  
     * @param status 10:入园    20:开锁  30:交单  40:扫码卸货   50:卸货完成  55:同意出园 60:出园  
     */
    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    /**
     * 装卸组code
     * @return GROUPCODE 装卸组code
     */
    public String getGroupcode() {
        return groupcode;
    }

    /**
     * 装卸组code
     * @param groupcode 装卸组code
     */
    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
    }

    /**
     * 批次
     * @return BATCH_ID 批次
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * 批次
     * @param batchId 批次
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

	/**
	 * @return 10:入园    20:开锁  30:交单  40:扫码卸货   50:卸货完成  55:同意出园 60:出园  
	 */
	public String getStatusname() {
		return statusname;
	}

	/**
	 * @param statusname 10:入园    20:开锁  30:交单  40:扫码卸货   50:卸货完成  55:同意出园 60:出园  
	 */
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return 合同号
	 */
	public String getContractno() {
		return contractno;
	}

	/**
	 * @param contractno 合同号
	 */
	public void setContractno(String contractno) {
		this.contractno = contractno;
	}

	/**
	 * @return 准运证
	 */
	public String getNavicert() {
		return navicert;
	}

	/**
	 * @param navicert 准运证
	 */
	public void setNavicert(String navicert) {
		this.navicert = navicert;
	}

	/**
	 * @return 装卸时间
	 */
	public BigDecimal getLoadtime() {
		return loadtime;
	}

	/**
	 * @param loadtime 装卸时间
	 */
	public void setLoadtime(BigDecimal loadtime) {
		this.loadtime = loadtime;
	}

	/**
	 * @return 装卸效率
	 */
	public BigDecimal getEfficiency() {
		return efficiency;
	}

	/**
	 * @param efficiency 装卸效率
	 */
	public void setEfficiency(BigDecimal efficiency) {
		this.efficiency = efficiency;
	}

	/**
	 * @return 搜索开始时间
	 */
	public Date getSearchbegtime() {
		return searchbegtime;
	}

	/**
	 * @param searchbegtime 搜索开始时间
	 */
	public void setSearchbegtime(Date searchbegtime) {
		this.searchbegtime = searchbegtime;
	}

	/**
	 * @return 搜索结束时间
	 */
	public Date getSearchendtime() {
		return searchendtime;
	}

	/**
	 * @param searchendtime 搜索结束时间
	 */
	public void setSearchendtime(Date searchendtime) {
		this.searchendtime = searchendtime;
	}

	/**
	 * @return 装卸组人员名称
	 */
	public String getMembername() {
		return membername;
	}

	/**
	 * @param membername 装卸组人员名称
	 */
	public void setMembername(String membername) {
		this.membername = membername;
	}

	/**
	 * @return 装卸组名称
	 */
	public String getGroupname() {
		return groupname;
	}

	/**
	 * @param groupname 装卸组名称
	 */
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
    
    
}