package com.ztel.app.vo.gis;

import java.math.BigDecimal;

public class GroupinfoVo {
    /**
     * null
     */
    private BigDecimal id;

    /**
     * 装卸组编号
     */
    private String groupcode;

    /**
     * 装卸组名称
     */
    private String groupname;

    /**
     * 装卸组人员id
     */
    private Long member;

    /**
     * 装卸组人员名称
     */
    private String membername;

    /**
     * 10:正常   0:删除
     */
    private BigDecimal delstatus;

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
     * 装卸组编号
     * @return GROUPCODE 装卸组编号
     */
    public String getGroupcode() {
        return groupcode;
    }

    /**
     * 装卸组编号
     * @param groupcode 装卸组编号
     */
    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
    }

    /**
     * 装卸组名称
     * @return GROUPNAME 装卸组名称
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * 装卸组名称
     * @param groupname 装卸组名称
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    /**
     * 装卸组人员id
     * @return MEMBER 装卸组人员id
     */
    public Long getMember() {
        return member;
    }

    /**
     * 装卸组人员id
     * @param member 装卸组人员id
     */
    public void setMember(Long member) {
        this.member = member;
    }

    /**
     * 装卸组人员名称
     * @return MEMBERNAME 装卸组人员名称
     */
    public String getMembername() {
        return membername;
    }

    /**
     * 装卸组人员名称
     * @param membername 装卸组人员名称
     */
    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    /**
     * 10:正常   0:删除
     * @return DELSTATUS 10:正常   0:删除
     */
    public BigDecimal getDelstatus() {
        return delstatus;
    }

    /**
     * 10:正常   0:删除
     * @param delstatus 10:正常   0:删除
     */
    public void setDelstatus(BigDecimal delstatus) {
        this.delstatus = delstatus;
    }

	public void setCreateid(Long userVo) {
		// TODO 自动生成的方法存根
		
	}
}