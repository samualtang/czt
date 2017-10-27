package com.ztel.app.vo.wms;

import java.math.BigDecimal;
import java.util.Date;

public class InventoryLineVo {
    /**
     * null
     */
    private BigDecimal id;

    /**
     * 盘点编号
     */
    private BigDecimal inventoryid;

    /**
     * 品牌名称
     */
    private Object cigarettename;

    /**
     * 编码
     */
    private String cigarettecode;

    /**
     * 件烟数量
     */
    private BigDecimal boxqty;

    /**
     * 条烟数量
     */
    private BigDecimal itemqty;

    /**
     * 盘点时间
     */
    private Date createtime;

    /**
     * 盘点类型(日清日结 月度等)
     */
    private BigDecimal inventorytype;

    /**
     * 货主
     */
    private Object consignsor;

    /**
     * 盘点区域
     */
    private BigDecimal areaid;

    /**
     * 通道号
     */
    private Object troughno;

    //用于盘点报表展示
    private BigDecimal inoutqty;//调拨数量
    private BigDecimal totalqty;//合计数量
    
    public BigDecimal getInoutqty() {
		return inoutqty;
	}

	public void setInoutqty(BigDecimal inoutqty) {
		this.inoutqty = inoutqty;
	}

	public BigDecimal getTotalqty() {
		return totalqty;
	}

	public void setTotalqty(BigDecimal totalqty) {
		this.totalqty = totalqty;
	}

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
     * 盘点编号
     * @return INVENTORYID 盘点编号
     */
    public BigDecimal getInventoryid() {
        return inventoryid;
    }

    /**
     * 盘点编号
     * @param inventoryid 盘点编号
     */
    public void setInventoryid(BigDecimal inventoryid) {
        this.inventoryid = inventoryid;
    }

    /**
     * 品牌名称
     * @return CIGARETTENAME 品牌名称
     */
    public Object getCigarettename() {
        return cigarettename;
    }

    /**
     * 品牌名称
     * @param cigarettename 品牌名称
     */
    public void setCigarettename(Object cigarettename) {
        this.cigarettename = cigarettename;
    }

    /**
     * 编码
     * @return CIGARETTECODE 编码
     */
    public String getCigarettecode() {
        return cigarettecode;
    }

    /**
     * 编码
     * @param cigarettecode 编码
     */
    public void setCigarettecode(String cigarettecode) {
        this.cigarettecode = cigarettecode == null ? null : cigarettecode.trim();
    }

    /**
     * 件烟数量
     * @return BOXQTY 件烟数量
     */
    public BigDecimal getBoxqty() {
        return boxqty;
    }

    /**
     * 件烟数量
     * @param boxqty 件烟数量
     */
    public void setBoxqty(BigDecimal boxqty) {
        this.boxqty = boxqty;
    }

    /**
     * 条烟数量
     * @return ITEMQTY 条烟数量
     */
    public BigDecimal getItemqty() {
        return itemqty;
    }

    /**
     * 条烟数量
     * @param itemqty 条烟数量
     */
    public void setItemqty(BigDecimal itemqty) {
        this.itemqty = itemqty;
    }

    /**
     * 盘点时间
     * @return CREATETIME 盘点时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 盘点时间
     * @param createtime 盘点时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 盘点类型(日清日结 月度等)
     * @return INVENTOYPTYPE 盘点类型(日清日结 月度等)
     */
    public BigDecimal getInventorytype() {
        return inventorytype;
    }

    /**
     * 盘点类型(日清日结 月度等)
     * @param inventoyptype 盘点类型(日清日结 月度等)
     */
    public void setInventorytype(BigDecimal inventorytype) {
        this.inventorytype = inventorytype;
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
     * 盘点区域
     * @return AREAID 盘点区域
     */
    public BigDecimal getAreaid() {
        return areaid;
    }

    /**
     * 盘点区域
     * @param areaid 盘点区域
     */
    public void setAreaid(BigDecimal areaid) {
        this.areaid = areaid;
    }

    /**
     * 通道号
     * @return TROUGHNO 通道号
     */
    public Object getTroughno() {
        return troughno;
    }

    /**
     * 通道号
     * @param troughno 通道号
     */
    public void setTroughno(Object troughno) {
        this.troughno = troughno;
    }
}