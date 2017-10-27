package com.ztel.app.vo.wms;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StorageAreaInOutVo {
    /**
     * null
     */
    private BigDecimal id;

    /**
     * 储区编号
     */
    private BigDecimal areaid;

    /**
     * 储位编号
     */
    private String cellno;

    /**
     * 数量
     */
    private BigDecimal qty;

    /**
     * 类型（出 10  入 20）
     */
    private BigDecimal inouttype;

    /**
     * 任务号
     */
    private String taskno;

    /**
     * 品牌Code
     */
    private String cigarettecode;

    /**
     * 品牌名称
     */
    private Object cigarettename;

    /**
     * 入库开始时间
     */
    private Date createtime;

    /**
     * 入库结束时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date finishtime;

    /**
     * 10 入库中  20 完成出入库
     */
    private BigDecimal status;

    /**
     * 件烟数量
     */
    private BigDecimal boxqty;

    /**
     * 10 来烟破损  20 机损烟（针对散烟区）
     */
    private BigDecimal cigarattetype;

    /**
     * 记录人
     */
    private Object createname;
    /**
     * 件码
     */
    private String barcode;
    
    private String searchdate;

    public String getSearchdate() {
		return searchdate;
	}

	public void setSearchdate(String searchdate) {
		this.searchdate = searchdate;
	}

	/**
     * 件码
     * @return
     */
    public String getBarcode() {
		return barcode;
	}

    /**
     * 件码
     * @param barcode
     */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
     * 储区编号
     * @return AREAID 储区编号
     */
    public BigDecimal getAreaid() {
        return areaid;
    }

    /**
     * 储区编号
     * @param areaid 储区编号
     */
    public void setAreaid(BigDecimal areaid) {
        this.areaid = areaid;
    }

    /**
     * 储位编号
     * @return CELLNO 储位编号
     */
    public String getCellno() {
        return cellno;
    }

    /**
     * 储位编号
     * @param cellno 储位编号
     */
    public void setCellno(String cellno) {
        this.cellno = cellno == null ? null : cellno.trim();
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
     * 类型（出 10  入 20）
     * @return INOUTTYPE 类型（出 10  入 20）
     */
    public BigDecimal getInouttype() {
        return inouttype;
    }

    /**
     * 类型（出 10  入 20）
     * @param inouttype 类型（出 10  入 20）
     */
    public void setInouttype(BigDecimal inouttype) {
        this.inouttype = inouttype;
    }

    /**
     * 任务号
     * @return TASKNO 任务号
     */
    public String getTaskno() {
        return taskno;
    }

    /**
     * 任务号
     * @param taskno 任务号
     */
    public void setTaskno(String taskno) {
        this.taskno = taskno == null ? null : taskno.trim();
    }

    /**
     * 品牌Code
     * @return CIGARETTECODE 品牌Code
     */
    public String getCigarettecode() {
        return cigarettecode;
    }

    /**
     * 品牌Code
     * @param cigarettecode 品牌Code
     */
    public void setCigarettecode(String cigarettecode) {
        this.cigarettecode = cigarettecode == null ? null : cigarettecode.trim();
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
     * 入库开始时间
     * @return CREATETIME 入库开始时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 入库开始时间
     * @param createtime 入库开始时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 入库结束时间
     * @return FINISHTIME 入库结束时间
     */
    public Date getFinishtime() {
        return finishtime;
    }

    /**
     * 入库结束时间
     * @param finishtime 入库结束时间
     */
    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    /**
     * 10 入库中  20 完成出入库
     * @return STATUS 10 入库中  20 完成出入库
     */
    public BigDecimal getStatus() {
        return status;
    }

    /**
     * 10 入库中  20 完成出入库
     * @param status 10 入库中  20 完成出入库
     */
    public void setStatus(BigDecimal status) {
        this.status = status;
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
     * 10 来烟破损  20 机损烟（针对散烟区）
     * @return CIGARATTETYPE 10 来烟破损  20 机损烟（针对散烟区）
     */
    public BigDecimal getCigarattetype() {
        return cigarattetype;
    }

    /**
     * 10 来烟破损  20 机损烟（针对散烟区）
     * @param cigarattetype 10 来烟破损  20 机损烟（针对散烟区）
     */
    public void setCigarattetype(BigDecimal cigarattetype) {
        this.cigarattetype = cigarattetype;
    }

    /**
     * 记录人
     * @return CREATENAME 记录人
     */
    public Object getCreatename() {
        return createname;
    }

    /**
     * 记录人
     * @param createname 记录人
     */
    public void setCreatename(Object createname) {
        this.createname = createname;
    }
}