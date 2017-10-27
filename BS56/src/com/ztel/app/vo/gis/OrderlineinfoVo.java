package com.ztel.app.vo.gis;

import java.math.BigDecimal;
import java.util.Date;

public class OrderlineinfoVo {
    /**
     * null
     */
    private BigDecimal id;

    /**
     * 单据主键ID
     */
    private String orderDetailId;

    /**
     * 票号
     */
    private String orderId;

    /**
     * 批次ＩＤ
     */
    private String batchId;

    /**
     * 承运车号
     */
    private String truckNum;

    /**
     * 随车准运证号
     */
    private String cgtMpNum;

    /**
     * 随车合同号
     */
    private String cgtContNum;

    /**
     * 是否到货  00：在途 01：到货
     */
    private String isArrived;
    
    /**
     * 是否到货名称  00：在途 01：到货
     */
    private String isArrivedname;

    /**
     * 发货日期  YYYYMMDDHHMISS
     */
    private String outDate;

    /**
     * 发货单位代码
     */
    private String orgOrgCode;

    /**
     * 发货单位名称
     */
    private String orgOrgName;

    /**
     * 发货仓库代码
     */
    private String orgStoCode;

    /**
     * 发货仓库名称
     */
    private String orgStoName;

    /**
     * 到货单位代码
     */
    private String destOrgCode;

    /**
     * 到货单位名称
     */
    private String destOrgName;

    /**
     * 到货仓库代码
     */
    private String destStoCode;

    /**
     * 到货仓库名称
     */
    private String destStoName;

    /**
     * 发货地点联系人
     */
    private String orgLinkman;

    /**
     * 到货地点联系人
     */
    private String destLinkman;

    /**
     * 到货地址
     */
    private String arrivedAdress;

    /**
     * 到货地点联系人联系电话
     */
    private String destLinkmanTel;

    /**
     * 发货地点联系人联系电话
     */
    private String orgLinkmanTel;

    /**
     * 运输方式  01：汽车；02：火车；03：轮船；04：飞机；05：其他
     */
    private String transMode;
    
    /**
     * 运输方式  01：汽车；02：火车；03：轮船；04：飞机；05：其他
     */
    private String transModename;

    /**
     * 运输单位名称
     */
    private String tranOrgName;

    /**
     * 业务类型  00：通常业务；01：合作生产(自销)；02：合作生产(代销)；10：品牌使用；20：商业自提
     */
    private String businessType;

    /**
     * 牌号规格代码
     */
    private String cgtBrandCode;

    /**
     * 品牌（规格）
     */
    private String tradeName;

    /**
     * 数量（件）
     */
    private BigDecimal cgtPurQty1;

    /**
     * 数量（万支）
     */
    private BigDecimal cgtPurQty2;

    /**
     * 品牌所有者
     */
    private String orgCode;

    /**
     * 到货日期  YYYYMMDDHHMISS
     */
    private String arrivedDate;

    /**
     * 更新日期  
     */
    private Date updatetime;

    /**
     * 状态  10:最新数据  20:历史数据
     */
    private String rowstatus;
    
    private String keyword;

    /**
     * 插入时间
     */
    private Date itime;

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
     * 单据主键ID
     * @return ORDER_DETAIL_ID 单据主键ID
     */
    public String getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * 单据主键ID
     * @param orderDetailId 单据主键ID
     */
    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId == null ? null : orderDetailId.trim();
    }

    /**
     * 票号
     * @return ORDER_ID 票号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 票号
     * @param orderId 票号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 批次ＩＤ
     * @return BATCH_ID 批次ＩＤ
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * 批次ＩＤ
     * @param batchId 批次ＩＤ
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    /**
     * 承运车号
     * @return TRUCK_NUM 承运车号
     */
    public String getTruckNum() {
        return truckNum;
    }

    /**
     * 承运车号
     * @param truckNum 承运车号
     */
    public void setTruckNum(String truckNum) {
        this.truckNum = truckNum == null ? null : truckNum.trim();
    }

    /**
     * 随车准运证号
     * @return CGT_MP_NUM 随车准运证号
     */
    public String getCgtMpNum() {
        return cgtMpNum;
    }

    /**
     * 随车准运证号
     * @param cgtMpNum 随车准运证号
     */
    public void setCgtMpNum(String cgtMpNum) {
        this.cgtMpNum = cgtMpNum == null ? null : cgtMpNum.trim();
    }

    /**
     * 随车合同号
     * @return CGT_CONT_NUM 随车合同号
     */
    public String getCgtContNum() {
        return cgtContNum;
    }

    /**
     * 随车合同号
     * @param cgtContNum 随车合同号
     */
    public void setCgtContNum(String cgtContNum) {
        this.cgtContNum = cgtContNum == null ? null : cgtContNum.trim();
    }

    /**
     * 是否到货  00：在途 01：到货
     * @return IS_ARRIVED 是否到货  00：在途 01：到货
     */
    public String getIsArrived() {
        return isArrived;
    }

    /**
     * 是否到货  00：在途 01：到货
     * @param isArrived 是否到货  00：在途 01：到货
     */
    public void setIsArrived(String isArrived) {
        this.isArrived = isArrived == null ? null : isArrived.trim();
    }

    /**
     * 发货日期  YYYYMMDDHHMISS
     * @return OUT_DATE 发货日期  YYYYMMDDHHMISS
     */
    public String getOutDate() {
        return outDate;
    }

    /**
     * 发货日期  YYYYMMDDHHMISS
     * @param outDate 发货日期  YYYYMMDDHHMISS
     */
    public void setOutDate(String outDate) {
        this.outDate = outDate == null ? null : outDate.trim();
    }

    /**
     * 发货单位代码
     * @return ORG_ORG_CODE 发货单位代码
     */
    public String getOrgOrgCode() {
        return orgOrgCode;
    }

    /**
     * 发货单位代码
     * @param orgOrgCode 发货单位代码
     */
    public void setOrgOrgCode(String orgOrgCode) {
        this.orgOrgCode = orgOrgCode == null ? null : orgOrgCode.trim();
    }

    /**
     * 发货单位名称
     * @return ORG_ORG_NAME 发货单位名称
     */
    public String getOrgOrgName() {
        return orgOrgName;
    }

    /**
     * 发货单位名称
     * @param orgOrgName 发货单位名称
     */
    public void setOrgOrgName(String orgOrgName) {
        this.orgOrgName = orgOrgName == null ? null : orgOrgName.trim();
    }

    /**
     * 发货仓库代码
     * @return ORG_STO_CODE 发货仓库代码
     */
    public String getOrgStoCode() {
        return orgStoCode;
    }

    /**
     * 发货仓库代码
     * @param orgStoCode 发货仓库代码
     */
    public void setOrgStoCode(String orgStoCode) {
        this.orgStoCode = orgStoCode == null ? null : orgStoCode.trim();
    }

    /**
     * 发货仓库名称
     * @return ORG_STO_NAME 发货仓库名称
     */
    public String getOrgStoName() {
        return orgStoName;
    }

    /**
     * 发货仓库名称
     * @param orgStoName 发货仓库名称
     */
    public void setOrgStoName(String orgStoName) {
        this.orgStoName = orgStoName == null ? null : orgStoName.trim();
    }

    /**
     * 到货单位代码
     * @return DEST_ORG_CODE 到货单位代码
     */
    public String getDestOrgCode() {
        return destOrgCode;
    }

    /**
     * 到货单位代码
     * @param destOrgCode 到货单位代码
     */
    public void setDestOrgCode(String destOrgCode) {
        this.destOrgCode = destOrgCode == null ? null : destOrgCode.trim();
    }

    /**
     * 到货单位名称
     * @return DEST_ORG_NAME 到货单位名称
     */
    public String getDestOrgName() {
        return destOrgName;
    }

    /**
     * 到货单位名称
     * @param destOrgName 到货单位名称
     */
    public void setDestOrgName(String destOrgName) {
        this.destOrgName = destOrgName == null ? null : destOrgName.trim();
    }

    /**
     * 到货仓库代码
     * @return DEST_STO_CODE 到货仓库代码
     */
    public String getDestStoCode() {
        return destStoCode;
    }

    /**
     * 到货仓库代码
     * @param destStoCode 到货仓库代码
     */
    public void setDestStoCode(String destStoCode) {
        this.destStoCode = destStoCode == null ? null : destStoCode.trim();
    }

    /**
     * 到货仓库名称
     * @return DEST_STO_NAME 到货仓库名称
     */
    public String getDestStoName() {
        return destStoName;
    }

    /**
     * 到货仓库名称
     * @param destStoName 到货仓库名称
     */
    public void setDestStoName(String destStoName) {
        this.destStoName = destStoName == null ? null : destStoName.trim();
    }

    /**
     * 发货地点联系人
     * @return ORG_LINKMAN 发货地点联系人
     */
    public String getOrgLinkman() {
        return orgLinkman;
    }

    /**
     * 发货地点联系人
     * @param orgLinkman 发货地点联系人
     */
    public void setOrgLinkman(String orgLinkman) {
        this.orgLinkman = orgLinkman == null ? null : orgLinkman.trim();
    }

    /**
     * 到货地点联系人
     * @return DEST_LINKMAN 到货地点联系人
     */
    public String getDestLinkman() {
        return destLinkman;
    }

    /**
     * 到货地点联系人
     * @param destLinkman 到货地点联系人
     */
    public void setDestLinkman(String destLinkman) {
        this.destLinkman = destLinkman == null ? null : destLinkman.trim();
    }

    /**
     * 到货地址
     * @return ARRIVED_ADRESS 到货地址
     */
    public String getArrivedAdress() {
        return arrivedAdress;
    }

    /**
     * 到货地址
     * @param arrivedAdress 到货地址
     */
    public void setArrivedAdress(String arrivedAdress) {
        this.arrivedAdress = arrivedAdress == null ? null : arrivedAdress.trim();
    }

    /**
     * 到货地点联系人联系电话
     * @return DEST_LINKMAN_TEL 到货地点联系人联系电话
     */
    public String getDestLinkmanTel() {
        return destLinkmanTel;
    }

    /**
     * 到货地点联系人联系电话
     * @param destLinkmanTel 到货地点联系人联系电话
     */
    public void setDestLinkmanTel(String destLinkmanTel) {
        this.destLinkmanTel = destLinkmanTel == null ? null : destLinkmanTel.trim();
    }

    /**
     * 发货地点联系人联系电话
     * @return ORG_LINKMAN_TEL 发货地点联系人联系电话
     */
    public String getOrgLinkmanTel() {
        return orgLinkmanTel;
    }

    /**
     * 发货地点联系人联系电话
     * @param orgLinkmanTel 发货地点联系人联系电话
     */
    public void setOrgLinkmanTel(String orgLinkmanTel) {
        this.orgLinkmanTel = orgLinkmanTel == null ? null : orgLinkmanTel.trim();
    }

    /**
     * 运输方式  01：汽车；02：火车；03：轮船；04：飞机；05：其他
     * @return TRANS_MODE 运输方式  01：汽车；02：火车；03：轮船；04：飞机；05：其他
     */
    public String getTransMode() {
        return transMode;
    }

    /**
     * 运输方式  01：汽车；02：火车；03：轮船；04：飞机；05：其他
     * @param transMode 运输方式  01：汽车；02：火车；03：轮船；04：飞机；05：其他
     */
    public void setTransMode(String transMode) {
        this.transMode = transMode == null ? null : transMode.trim();
    }

    /**
     * 运输单位名称
     * @return TRAN_ORG_NAME 运输单位名称
     */
    public String getTranOrgName() {
        return tranOrgName;
    }

    /**
     * 运输单位名称
     * @param tranOrgName 运输单位名称
     */
    public void setTranOrgName(String tranOrgName) {
        this.tranOrgName = tranOrgName == null ? null : tranOrgName.trim();
    }

    /**
     * 业务类型  00：通常业务；01：合作生产(自销)；02：合作生产(代销)；10：品牌使用；20：商业自提
     * @return BUSINESS_TYPE 业务类型  00：通常业务；01：合作生产(自销)；02：合作生产(代销)；10：品牌使用；20：商业自提
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 业务类型  00：通常业务；01：合作生产(自销)；02：合作生产(代销)；10：品牌使用；20：商业自提
     * @param businessType 业务类型  00：通常业务；01：合作生产(自销)；02：合作生产(代销)；10：品牌使用；20：商业自提
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * 牌号规格代码
     * @return CGT_BRAND_CODE 牌号规格代码
     */
    public String getCgtBrandCode() {
        return cgtBrandCode;
    }

    /**
     * 牌号规格代码
     * @param cgtBrandCode 牌号规格代码
     */
    public void setCgtBrandCode(String cgtBrandCode) {
        this.cgtBrandCode = cgtBrandCode == null ? null : cgtBrandCode.trim();
    }

    /**
     * 品牌（规格）
     * @return TRADE_NAME 品牌（规格）
     */
    public String getTradeName() {
        return tradeName;
    }

    /**
     * 品牌（规格）
     * @param tradeName 品牌（规格）
     */
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName == null ? null : tradeName.trim();
    }

    /**
     * 数量（件）
     * @return CGT_PUR_QTY1 数量（件）
     */
    public BigDecimal getCgtPurQty1() {
        return cgtPurQty1;
    }

    /**
     * 数量（件）
     * @param cgtPurQty1 数量（件）
     */
    public void setCgtPurQty1(BigDecimal cgtPurQty1) {
        this.cgtPurQty1 = cgtPurQty1;
    }

    /**
     * 数量（万支）
     * @return CGT_PUR_QTY2 数量（万支）
     */
    public BigDecimal getCgtPurQty2() {
        return cgtPurQty2;
    }

    /**
     * 数量（万支）
     * @param cgtPurQty2 数量（万支）
     */
    public void setCgtPurQty2(BigDecimal cgtPurQty2) {
        this.cgtPurQty2 = cgtPurQty2;
    }

    /**
     * 品牌所有者
     * @return ORG_CODE 品牌所有者
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 品牌所有者
     * @param orgCode 品牌所有者
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * 到货日期  YYYYMMDDHHMISS
     * @return ARRIVED_DATE 到货日期  YYYYMMDDHHMISS
     */
    public String getArrivedDate() {
        return arrivedDate;
    }

    /**
     * 到货日期  YYYYMMDDHHMISS
     * @param arrivedDate 到货日期  YYYYMMDDHHMISS
     */
    public void setArrivedDate(String arrivedDate) {
        this.arrivedDate = arrivedDate == null ? null : arrivedDate.trim();
    }

    /**
     * 更新日期  
     * @return UPDATETIME 更新日期  
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 更新日期  
     * @param updatetime 更新日期  
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 状态  10:最新数据  20:历史数据
     * @return ROWSTATUS 状态  10:最新数据  20:历史数据
     */
    public String getRowstatus() {
        return rowstatus;
    }

    /**
     * 状态  10:最新数据  20:历史数据
     * @param rowstatus 状态  10:最新数据  20:历史数据
     */
    public void setRowstatus(String rowstatus) {
        this.rowstatus = rowstatus == null ? null : rowstatus.trim();
    }

    /**
     * 插入时间
     * @return ITIME 插入时间
     */
    public Date getItime() {
        return itime;
    }

    /**
     * 插入时间
     * @param itime 插入时间
     */
    public void setItime(Date itime) {
        this.itime = itime;
    }

	/**
	 * @return 是否到货名称  00：在途 01：到货
	 */
	public String getIsArrivedname() {
		return isArrivedname;
	}

	/**
	 * @param isArrivedname 是否到货名称  00：在途 01：到货
	 */
	public void setIsArrivedname(String isArrivedname) {
		this.isArrivedname = isArrivedname;
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
	 * @return 运输方式  01：汽车；02：火车；03：轮船；04：飞机；05：其他
	 */
	public String getTransModename() {
		return transModename;
	}

	/**
	 * @param transModename 运输方式  01：汽车；02：火车；03：轮船；04：飞机；05：其他
	 */
	public void setTransModename(String transModename) {
		this.transModename = transModename;
	}
    
    
}