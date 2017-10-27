package com.ztel.app.vo.wms;

import java.math.BigDecimal;
import java.util.Date;

public class InBoundVo {
    /**
     * 入库编号
     */
    private BigDecimal inboundid;

    /**
     * 准运证
     */
    private String navicert;

    /**
     * 合同号（退货入库 放订单号  ）
     */
    private String contractno;

    /**
     * 记录时间
     */
    private Date createtime;

    /**
     * 数量
     */
    private BigDecimal qty;

    /**
     * 供应商
     */
    private Object supplier;

    /**
     * 货主
     */
    private Object consignsor;

    /**
     * 入库类型（工业来烟（订货）10、调拨入库 20、退货入库 30、罚没烟 40 ）
     */
    private BigDecimal intype;

    /**
     * 备注
     */
    private Object remarks;

    /**
     * 入库状态  10 新增 20 入库中 30 入库完成
     */
    private String status;
    
    /**
     * 搜索关键字
     */
    private String keyword;
    
    /**
     * 查询开始\结束时间
     */
    private Date begintime;
    private Date endtime;
    
    private BigDecimal outqty;//实际出库数量（件），用于库存账面量
    private BigDecimal outitemqty;//实际出库数量（条），用于库存账面量
    
    /**
     * 入库类型名称（工业来烟（订货）10、调拨入库 20、退货入库 30、罚没烟 40）
     */
    private String intypename;
    
    /**
     * 入库状态名称  10 新增 20 入库中 30 入库完成
     */
    private String statusname;

    public String getIntypename() {
		return intypename;
	}

	public void setIntypename(String intypename) {
		this.intypename = intypename;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	/**
     * 入库编号
     * @return INBOUNDID 入库编号
     */
    public BigDecimal getInboundid() {
        return inboundid;
    }

    /**
     * 入库编号
     * @param inboundid 入库编号
     */
    public void setInboundid(BigDecimal inboundid) {
        this.inboundid = inboundid;
    }

    /**
     * 准运证
     * @return NAVICERT 准运证
     */
    public String getNavicert() {
        return navicert;
    }

    /**
     * 准运证
     * @param navicert 准运证
     */
    public void setNavicert(String navicert) {
        this.navicert = navicert == null ? null : navicert.trim();
    }

    /**
     * 合同号（退货入库 放订单号  ）
     * @return CONTRACTNO 合同号（退货入库 放订单号  ）
     */
    public String getContractno() {
        return contractno;
    }

    /**
     * 合同号（退货入库 放订单号  ）
     * @param contractno 合同号（退货入库 放订单号  ）
     */
    public void setContractno(String contractno) {
        this.contractno = contractno == null ? null : contractno.trim();
    }

    /**
     * 记录时间
     * @return CREATETIME 记录时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 记录时间
     * @param createtime 记录时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 数量
     * @return QTY 数量
     */
    public BigDecimal getQty() {
        return qty;
    }

    /**
     * 数量
     * @param qty 数量
     */
    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * 供应商
     * @return SUPPLIER 供应商
     */
    public Object getSupplier() {
        return supplier;
    }

    /**
     * 供应商
     * @param supplier 供应商
     */
    public void setSupplier(Object supplier) {
        this.supplier = supplier;
    }

    /**
     * 货主
     * @return CONSIGNSOR 货主
     */
    public Object getConsignsor() {
        return consignsor;
    }

    /**
     * 货主
     * @param consignsor 货主
     */
    public void setConsignsor(Object consignsor) {
        this.consignsor = consignsor;
    }

    /**
     * 入库类型（工业来烟（订货）10、调拨入库 20、退货入库 30、罚没烟 40 ）
     * @return INTYPE 入库类型（工业来烟（订货）10、调拨入库 20、退货入库 30、罚没烟 40 ）
     */
    public BigDecimal getIntype() {
        return intype;
    }

    /**
     * 入库类型（工业来烟（订货）10、调拨入库 20、退货入库 30、罚没烟 40 ）
     * @param intype 入库类型（工业来烟（订货）10、调拨入库 20、退货入库 30、罚没烟 40 ）
     */
    public void setIntype(BigDecimal intype) {
        this.intype = intype;
    }

    /**
     * 备注
     * @return REMARKS 备注
     */
    public Object getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks 备注
     */
    public void setRemarks(Object remarks) {
        this.remarks = remarks;
    }

    /**
     * 入库状态  10 新增 20 入库中 30 入库完成
     * @return STATUS 入库状态  10 新增 20 入库中 30 入库完成
     */
    public String getStatus() {
        return status;
    }

    /**
     * 入库状态  10 新增 20 入库中 30 入库完成
     * @param status 入库状态  10 新增 20 入库中 30 入库完成
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 搜索关键字
     * @return
     */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * 搜索关键字
	 * @param keyword 搜索关键字
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * 搜索开始时间
	 * @return
	 */
	public Date getBegintime() {
		return begintime;
	}

	/**
	 * 搜索开始时间
	 * @param begintime 搜索开始时间
	 */
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	/**
	 * 搜索结束时间
	 * @return
	 */
	public Date getEndtime() {
		return endtime;
	}

	/**
	 * 搜索结束时间
	 * @param endtime 搜索结束时间
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	/**
	 * 实际出库量(件)
	 * @return
	 */
	public BigDecimal getOutqty() {
		return outqty;
	}

	/**
	 * 实际出库量(件)
	 * @param outqty 实际出库量(件)
	 */
	public void setOutqty(BigDecimal outqty) {
		this.outqty = outqty;
	}

	/**
	 * 实际出库量(条)
	 * @return
	 */
	public BigDecimal getOutitemqty() {
		return outitemqty;
	}

	/**
	 * 实际出库量(条)
	 * @param outitemqty 实际出库量(条)
	 */
	public void setOutitemqty(BigDecimal outitemqty) {
		this.outitemqty = outitemqty;
	}
    
}