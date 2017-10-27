package com.ztel.app.vo.wms;

import java.math.BigDecimal;

public class ShipOrderLineVo {
    /**
     * 主键
     */
    private String id;

    /**
     * 订单头
     */
    private String orderno;

    /**
     * 品牌id
     */
    private String itemId;

    /**
     * 单位id
     */
    private BigDecimal uomId;

    /**
     * 单价
     */
    private BigDecimal itemprice;

    /**
     * 订单数量
     */
    private BigDecimal qty;

    /**
     * 总金额
     */
    private BigDecimal saleamount;

    /**
     * 10正常  0退货  
     */
    private BigDecimal orderstatus;

    /**
     * null
     */
    private String itemname;
    
    private String barcode;

    public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
     * 主键
     * @return ID 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 订单头
     * @return ORDERNO 订单头
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 订单头
     * @param orderno 订单头
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    /**
     * 品牌id
     * @return ITEM_ID 品牌id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 品牌id
     * @param itemId 品牌id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    /**
     * 单位id
     * @return UOM_ID 单位id
     */
    public BigDecimal getUomId() {
        return uomId;
    }

    /**
     * 单位id
     * @param uomId 单位id
     */
    public void setUomId(BigDecimal uomId) {
        this.uomId = uomId;
    }

    /**
     * 单价
     * @return ITEMPRICE 单价
     */
    public BigDecimal getItemprice() {
        return itemprice;
    }

    /**
     * 单价
     * @param itemprice 单价
     */
    public void setItemprice(BigDecimal itemprice) {
        this.itemprice = itemprice;
    }

    /**
     * 订单数量
     * @return QTY 订单数量
     */
    public BigDecimal getQty() {
        return qty;
    }

    /**
     * 订单数量
     * @param qty 订单数量
     */
    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * 总金额
     * @return SALEAMOUNT 总金额
     */
    public BigDecimal getSaleamount() {
        return saleamount;
    }

    /**
     * 总金额
     * @param saleamount 总金额
     */
    public void setSaleamount(BigDecimal saleamount) {
        this.saleamount = saleamount;
    }

    /**
     * 10正常  0退货  
     * @return ORDERSTATUS 10正常  0退货  
     */
    public BigDecimal getOrderstatus() {
        return orderstatus;
    }

    /**
     * 10正常  0退货  
     * @param orderstatus 10正常  0退货  
     */
    public void setOrderstatus(BigDecimal orderstatus) {
        this.orderstatus = orderstatus;
    }

    /**
     * null
     * @return ITEMNAME null
     */
    public String getItemname() {
        return itemname;
    }

    /**
     * null
     * @param itemname null
     */
    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }
}