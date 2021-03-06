package com.ztel.app.vo.sq;

import java.math.BigDecimal;

public class EvalitemVo {
    /**
     * 考核项id
     */
    private Integer id;

    /**
     * 考核内容简称
     */
    private String contentshort;

    /**
     * 考核分值
     */
    private Integer score;

    /**
     * 考核权重
     */
    private BigDecimal assessweight;

    /**
     * 考核标志10：公司 20：车组 10，20：对两者考核
     */
    private String flag;

    /**
     * 否决标志：10：考核项 20：一票否决
     */
    private String voteflag;

    /**
     * 考核项人员标志  10：司机 20：收款员 30：司机和收款员
     */
    private String usetype;

    /**
     * 考核方式 1：话务考核 2：领导考核 3：市场考核 4:自动语音 8:工业客户问题
     */
    private String assesstype;

    /**
     * 删除标志 10：正常 0：删除 默认：10
     */
    private String delstatus;

    /**
     * 预留字段
     */
    private String reserve;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 考核内容全名
     */
    private String content;

    /**
     * null
     */
    private String voxfile;

    /**
     * 考核项数字
     */
    private Integer itemnum;
    
    
    private String usetypename;

    public String getUsetypename() {
		return usetypename;
	}

	public void setUsetypename(String usetypename) {
		this.usetypename = usetypename;
	}

	/**
     * 考核项id
     * @return ID 考核项id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 考核项id
     * @param id 考核项id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 考核内容简称
     * @return CONTENTSHORT 考核内容简称
     */
    public String getContentshort() {
        return contentshort;
    }

    /**
     * 考核内容简称
     * @param contentshort 考核内容简称
     */
    public void setContentshort(String contentshort) {
        this.contentshort = contentshort == null ? null : contentshort.trim();
    }

    /**
     * 考核分值
     * @return SCORE 考核分值
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 考核分值
     * @param score 考核分值
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 考核权重
     * @return ASSESSWEIGHT 考核权重
     */
    public BigDecimal getAssessweight() {
        return assessweight;
    }

    /**
     * 考核权重
     * @param assessweight 考核权重
     */
    public void setAssessweight(BigDecimal assessweight) {
        this.assessweight = assessweight;
    }

    /**
     * 考核标志10：公司 20：车组 10，20：对两者考核
     * @return FLAG 考核标志10：公司 20：车组 10，20：对两者考核
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 考核标志10：公司 20：车组 10，20：对两者考核
     * @param flag 考核标志10：公司 20：车组 10，20：对两者考核
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * 否决标志：10：考核项 20：一票否决
     * @return VOTEFLAG 否决标志：10：考核项 20：一票否决
     */
    public String getVoteflag() {
        return voteflag;
    }

    /**
     * 否决标志：10：考核项 20：一票否决
     * @param voteflag 否决标志：10：考核项 20：一票否决
     */
    public void setVoteflag(String voteflag) {
        this.voteflag = voteflag == null ? null : voteflag.trim();
    }

    /**
     * 考核项人员标志  10：司机 20：收款员 30：司机和收款员
     * @return USETYPE 考核项人员标志  10：司机 20：收款员 30：司机和收款员
     */
    public String getUsetype() {
        return usetype;
    }

    /**
     * 考核项人员标志  10：司机 20：收款员 30：司机和收款员
     * @param usetype 考核项人员标志  10：司机 20：收款员 30：司机和收款员
     */
    public void setUsetype(String usetype) {
        this.usetype = usetype == null ? null : usetype.trim();
    }

    /**
     * 考核方式 1：话务考核 2：领导考核 3：市场考核 4:自动语音 8:工业客户问题
     * @return ASSESSTYPE 考核方式 1：话务考核 2：领导考核 3：市场考核 4:自动语音 8:工业客户问题
     */
    public String getAssesstype() {
        return assesstype;
    }

    /**
     * 考核方式 1：话务考核 2：领导考核 3：市场考核 4:自动语音 8:工业客户问题
     * @param assesstype 考核方式 1：话务考核 2：领导考核 3：市场考核 4:自动语音 8:工业客户问题
     */
    public void setAssesstype(String assesstype) {
        this.assesstype = assesstype == null ? null : assesstype.trim();
    }

    /**
     * 删除标志 10：正常 0：删除 默认：10
     * @return DELSTATUS 删除标志 10：正常 0：删除 默认：10
     */
    public String getDelstatus() {
        return delstatus;
    }

    /**
     * 删除标志 10：正常 0：删除 默认：10
     * @param delstatus 删除标志 10：正常 0：删除 默认：10
     */
    public void setDelstatus(String delstatus) {
        this.delstatus = delstatus == null ? null : delstatus.trim();
    }

    /**
     * 预留字段
     * @return RESERVE 预留字段
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * 预留字段
     * @param reserve 预留字段
     */
    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }

    /**
     * 备注
     * @return REMARKS 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 考核内容全名
     * @return CONTENT 考核内容全名
     */
    public String getContent() {
        return content;
    }

    /**
     * 考核内容全名
     * @param content 考核内容全名
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * null
     * @return VOXFILE null
     */
    public String getVoxfile() {
        return voxfile;
    }

    /**
     * null
     * @param voxfile null
     */
    public void setVoxfile(String voxfile) {
        this.voxfile = voxfile == null ? null : voxfile.trim();
    }

    /**
     * 考核项数字
     * @return ITEMNUM 考核项数字
     */
    public Integer getItemnum() {
        return itemnum;
    }

    /**
     * 考核项数字
     * @param itemnum 考核项数字
     */
    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }
}