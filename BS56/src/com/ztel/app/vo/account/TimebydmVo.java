package com.ztel.app.vo.account;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TimebydmVo {
    /**
     * null
     */
    private BigDecimal id;

    /**
     * 订单日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date orderdate;

    /**
     * 更新时间
     */
    private Date uptime;

    /**
     * 送货日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date deliverydate;

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


    public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	/**
     * 送货日期
     * @return DELIVERYDATE 送货日期
     */
    public Date getDeliverydate() {
        return deliverydate;
    }

    /**
     * 送货日期
     * @param deliverydate 送货日期
     */
    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }
    private String begdate;
    private String enddate;
    public String getBegdate() {
		return begdate;
	}

	public void setBegdate(String begdate) {
		this.begdate = begdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
}