package com.ztel.app.vo.cost;

import java.math.BigDecimal;

public class SPLTypeInfoVo {
    /**
     * ID号
     */
    private Integer id;

    /**
     * 类别名称
     */
    private String typename;

    /**
     * 级别
     */
    private Integer clevel;

    /**
     * 父级别ID
     */
    private Integer fid;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 设备单价
     */
    private BigDecimal price;

    /**
     * 删除标志 10:在用  0:删除
     */
    private String delstatus;

    /**
     * 是否为生产物资类别  0:普通物资类别  10:生产领料类别
     */
    private String isproduce;
    
	private String checked;
	private String state;
	private String ftypename;//父类名称
	private String isproducename;//是否生产物资，0：否  10：是

    /**
     * ID号
     * @return ID ID号
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID号
     * @param id ID号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 类别名称
     * @return TYPENAME 类别名称
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 类别名称
     * @param typename 类别名称
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     * 级别
     * @return CLEVEL 级别
     */
    public Integer getClevel() {
        return clevel;
    }

    /**
     * 级别
     * @param clevel 级别
     */
    public void setClevel(Integer clevel) {
        this.clevel = clevel;
    }

    /**
     * 父级别ID
     * @return FID 父级别ID
     */
    public Integer getFid() {
        return fid;
    }

    /**
     * 父级别ID
     * @param fid 父级别ID
     */
    public void setFid(Integer fid) {
        this.fid = fid;
    }

    /**
     * 计量单位
     * @return UNIT 计量单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 计量单位
     * @param unit 计量单位
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 设备单价
     * @return PRICE 设备单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设备单价
     * @param price 设备单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 删除标志 10:在用  0:删除
     * @return DELSTATUS 删除标志 10:在用  0:删除
     */
    public String getDelstatus() {
        return delstatus;
    }

    /**
     * 删除标志 10:在用  0:删除
     * @param delstatus 删除标志 10:在用  0:删除
     */
    public void setDelstatus(String delstatus) {
        this.delstatus = delstatus == null ? null : delstatus.trim();
    }

    /**
     * 是否为生产物资类别  10:普通物资类别  20:生产领料类别
     * @return ISPRODUCE 是否为生产物资类别  10:普通物资类别  20:生产领料类别
     */
    public String getIsproduce() {
        return isproduce;
    }

    /**
     * 是否为生产物资类别  10:普通物资类别  20:生产领料类别
     * @param isproduce 是否为生产物资类别  10:普通物资类别  20:生产领料类别
     */
    public void setIsproduce(String isproduce) {
        this.isproduce = isproduce == null ? null : isproduce.trim();
    }

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFtypename() {
		return ftypename;
	}

	public void setFtypename(String ftypename) {
		this.ftypename = ftypename;
	}

	public String getIsproducename() {
		return isproducename;
	}

	public void setIsproducename(String isproducename) {
		this.isproducename = isproducename;
	}
	
	
    
}