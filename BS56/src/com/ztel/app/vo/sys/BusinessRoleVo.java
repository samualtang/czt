package com.ztel.app.vo.sys;

public class BusinessRoleVo {
    /**
     * 业务角色ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 10：在用   0：删除
     */
    private String delstatus;
    
    private String usernames;

    /**
     * 业务角色ID
     * @return ID 业务角色ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 业务角色ID
     * @param id 业务角色ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色名称
     * @return ROLENAME 角色名称
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 角色名称
     * @param rolename 角色名称
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * 备注信息
     * @return REMARKS 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注信息
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 10：在用   0：删除
     * @return DELSTATUS 10：在用   0：删除
     */
    public String getDelstatus() {
        return delstatus;
    }

    /**
     * 10：在用   0：删除
     * @param delstatus 10：在用   0：删除
     */
    public void setDelstatus(String delstatus) {
        this.delstatus = delstatus == null ? null : delstatus.trim();
    }

	public String getUsernames() {
		return usernames;
	}

	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}

    
}