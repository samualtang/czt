package com.ztel.app.vo.wms;

import java.math.BigDecimal;
import java.util.Date;

public class ItemVo {
    /**
     * 主键
     */
    private String id;

    /**
     * null
     */
    private String dcno;

    /**
     * 货主
     */
    private BigDecimal shipperId;

    /**
     * 商品代码(超过7位为罚没烟)
     */
    private String itemno;

    /**
     * 商品名称
     */
    private String itemname;

    /**
     * 商品简称
     */
    private String shortname;

    /**
     * 规格
     */
    private String spec;

    /**
     * "A类 - 10  B类 - 20C类 - 30  默认值为 C 类"
     */
    private BigDecimal abccode;

    /**
     * 商品价格
     */
    private BigDecimal itemprice;

    /**
     * 0为正常烟，1为异性烟
     */
    private String shiptype;

    /**
     * 0为正常烟，1为异性烟
     */
    private String shiptypename;
    
    /**
     * 1卷烟 2三方
     */
    private Object itemtypeId;

    /**
     * 产区0：省内，1：省外，3：国外
     */
    private Object producearea;

    /**
     * 制造商
     */
    private BigDecimal manufacturerId;

    /**
     * 供应商
     */
    private BigDecimal vendorId;

    /**
     * 基本计量单位
     */
    private String baseuomId;

    /**
     * 库存计量单位
     */
    private String defaultuomId;

    /**
     * 存储条件
     */
    private String storagecondition;

    /**
     * null
     */
    private BigDecimal islotctrl;

    /**
     * 贮藏期限
     */
    private BigDecimal shelflife;

    /**
     * 是否上架销售 1上架 0 下架,多用于第三方
     */
    private String shelflifetype;

    /**
     * 托盘比例
     */
    private Short palletratio;

    /**
     * 创建日期
     */
    private Date createtime;

    /**
     * 创建人
     */
    private String createuser;

    /**
     * 修改时间
     */
    private Date modifytime;

    /**
     * 修改人
     */
    private String modifyuser;

    /**
     * 0删除,10为正常
     */
    private BigDecimal rowstatus;

    /**
     * null
     */
    private BigDecimal catid;

    /**
     * 件烟条形码，件烟码前6位,(91)除外
     */
    private String bigboxBar;

    /**
     * 条烟条形码
     */
    private String packBar;

    /**
     * 商品类别 1：商品，2：促销品，3：样品，4：罚没烟，5：其他
     */
    private String itemKind;

    /**
     * 价类 1：一类，2：二类，3：三类，4：四类，5：五类，6：无价类
     */
    private String kind;

    /**
     * 盒支比率   
     */
    private BigDecimal hSize;

    /**
     * 条支比率
     */
    private BigDecimal tSize;

    /**
     * 件支比率
     */
    private BigDecimal jSize;

    /**
     * 万支支比率
     */
    private BigDecimal wSize;

    /**
     *  箱支比率 
     */
    private BigDecimal xSize;

    /**
     * 每件烟重量，以克为单位，用于出库称重
     */
    private BigDecimal weight;

    /**
     * 满盘数量，正常烟为30一托盘，异型烟为40?
     */
    private BigDecimal fullcount;

    /**
     * 10 自动拆垛 0 人工拆垛
     */
    private BigDecimal cdtype;

    /**
     * 10 能扫码识别  0无法扫码识别
     */
    private BigDecimal iscanscancode;

    /**
     *   垛形 默认1
     */
    private String dxtype;

    /**
     * 件条
     */
    private BigDecimal jtSize;

    /**
     * 万条
     */
    private BigDecimal wzSize;
    
    /**
     * 搜索关键字
     */
    private String keyword;

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
     * null
     * @return DCNO null
     */
    public String getDcno() {
        return dcno;
    }

    /**
     * null
     * @param dcno null
     */
    public void setDcno(String dcno) {
        this.dcno = dcno == null ? null : dcno.trim();
    }

    /**
     * 货主
     * @return SHIPPER_ID 货主
     */
    public BigDecimal getShipperId() {
        return shipperId;
    }

    /**
     * 货主
     * @param shipperId 货主
     */
    public void setShipperId(BigDecimal shipperId) {
        this.shipperId = shipperId;
    }

    /**
     * 商品代码(超过7位为罚没烟)
     * @return ITEMNO 商品代码(超过7位为罚没烟)
     */
    public String getItemno() {
        return itemno;
    }

    /**
     * 商品代码(超过7位为罚没烟)
     * @param itemno 商品代码(超过7位为罚没烟)
     */
    public void setItemno(String itemno) {
        this.itemno = itemno == null ? null : itemno.trim();
    }

    /**
     * 商品名称
     * @return ITEMNAME 商品名称
     */
    public String getItemname() {
        return itemname;
    }

    /**
     * 商品名称
     * @param itemname 商品名称
     */
    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    /**
     * 商品简称
     * @return SHORTNAME 商品简称
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * 商品简称
     * @param shortname 商品简称
     */
    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    /**
     * 规格
     * @return SPEC 规格
     */
    public String getSpec() {
        return spec;
    }

    /**
     * 规格
     * @param spec 规格
     */
    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    /**
     * "A类 - 10  B类 - 20C类 - 30  默认值为 C 类"
     * @return ABCCODE "A类 - 10  B类 - 20C类 - 30  默认值为 C 类"
     */
    public BigDecimal getAbccode() {
        return abccode;
    }

    /**
     * "A类 - 10  B类 - 20C类 - 30  默认值为 C 类"
     * @param abccode "A类 - 10  B类 - 20C类 - 30  默认值为 C 类"
     */
    public void setAbccode(BigDecimal abccode) {
        this.abccode = abccode;
    }

    /**
     * 商品价格
     * @return ITEMPRICE 商品价格
     */
    public BigDecimal getItemprice() {
        return itemprice;
    }

    /**
     * 商品价格
     * @param itemprice 商品价格
     */
    public void setItemprice(BigDecimal itemprice) {
        this.itemprice = itemprice;
    }

    /**
     * 0为正常烟，1为异性烟
     * @return SHIPTYPE 0为正常烟，1为异性烟
     */
    public String getShiptype() {
        return shiptype;
    }

    /**
     * 0为正常烟，1为异性烟
     * @param shiptype 0为正常烟，1为异性烟
     */
    public void setShiptype(String shiptype) {
        this.shiptype = shiptype == null ? null : shiptype.trim();
    }

    /**
     * 1卷烟 2三方
     * @return ITEMTYPE_ID 1卷烟 2三方
     */
    public Object getItemtypeId() {
        return itemtypeId;
    }

    /**
     * 1卷烟 2三方
     * @param itemtypeId 1卷烟 2三方
     */
    public void setItemtypeId(Object itemtypeId) {
        this.itemtypeId = itemtypeId;
    }

    /**
     * 产区0：省内，1：省外，3：国外
     * @return PRODUCEAREA 产区0：省内，1：省外，3：国外
     */
    public Object getProducearea() {
        return producearea;
    }

    /**
     * 产区0：省内，1：省外，3：国外
     * @param producearea 产区0：省内，1：省外，3：国外
     */
    public void setProducearea(Object producearea) {
        this.producearea = producearea;
    }

    /**
     * 制造商
     * @return MANUFACTURER_ID 制造商
     */
    public BigDecimal getManufacturerId() {
        return manufacturerId;
    }

    /**
     * 制造商
     * @param manufacturerId 制造商
     */
    public void setManufacturerId(BigDecimal manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    /**
     * 供应商
     * @return VENDOR_ID 供应商
     */
    public BigDecimal getVendorId() {
        return vendorId;
    }

    /**
     * 供应商
     * @param vendorId 供应商
     */
    public void setVendorId(BigDecimal vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * 基本计量单位
     * @return BASEUOM_ID 基本计量单位
     */
    public String getBaseuomId() {
        return baseuomId;
    }

    /**
     * 基本计量单位
     * @param baseuomId 基本计量单位
     */
    public void setBaseuomId(String baseuomId) {
        this.baseuomId = baseuomId == null ? null : baseuomId.trim();
    }

    /**
     * 库存计量单位
     * @return DEFAULTUOM_ID 库存计量单位
     */
    public String getDefaultuomId() {
        return defaultuomId;
    }

    /**
     * 库存计量单位
     * @param defaultuomId 库存计量单位
     */
    public void setDefaultuomId(String defaultuomId) {
        this.defaultuomId = defaultuomId == null ? null : defaultuomId.trim();
    }

    /**
     * 存储条件
     * @return STORAGECONDITION 存储条件
     */
    public String getStoragecondition() {
        return storagecondition;
    }

    /**
     * 存储条件
     * @param storagecondition 存储条件
     */
    public void setStoragecondition(String storagecondition) {
        this.storagecondition = storagecondition == null ? null : storagecondition.trim();
    }

    /**
     * null
     * @return ISLOTCTRL null
     */
    public BigDecimal getIslotctrl() {
        return islotctrl;
    }

    /**
     * null
     * @param islotctrl null
     */
    public void setIslotctrl(BigDecimal islotctrl) {
        this.islotctrl = islotctrl;
    }

    /**
     * 贮藏期限
     * @return SHELFLIFE 贮藏期限
     */
    public BigDecimal getShelflife() {
        return shelflife;
    }

    /**
     * 贮藏期限
     * @param shelflife 贮藏期限
     */
    public void setShelflife(BigDecimal shelflife) {
        this.shelflife = shelflife;
    }

    /**
     * 是否上架销售 1上架 0 下架,多用于第三方
     * @return SHELFLIFETYPE 是否上架销售 1上架 0 下架,多用于第三方
     */
    public String getShelflifetype() {
        return shelflifetype;
    }

    /**
     * 是否上架销售 1上架 0 下架,多用于第三方
     * @param shelflifetype 是否上架销售 1上架 0 下架,多用于第三方
     */
    public void setShelflifetype(String shelflifetype) {
        this.shelflifetype = shelflifetype == null ? null : shelflifetype.trim();
    }

    /**
     * 托盘比例
     * @return PALLETRATIO 托盘比例
     */
    public Short getPalletratio() {
        return palletratio;
    }

    /**
     * 托盘比例
     * @param palletratio 托盘比例
     */
    public void setPalletratio(Short palletratio) {
        this.palletratio = palletratio;
    }

    /**
     * 创建日期
     * @return CREATETIME 创建日期
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建日期
     * @param createtime 创建日期
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 创建人
     * @return CREATEUSER 创建人
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     * 创建人
     * @param createuser 创建人
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    /**
     * 修改时间
     * @return MODIFYTIME 修改时间
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * 修改时间
     * @param modifytime 修改时间
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    /**
     * 修改人
     * @return MODIFYUSER 修改人
     */
    public String getModifyuser() {
        return modifyuser;
    }

    /**
     * 修改人
     * @param modifyuser 修改人
     */
    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser == null ? null : modifyuser.trim();
    }

    /**
     * 0删除,10为正常
     * @return ROWSTATUS 0删除,10为正常
     */
    public BigDecimal getRowstatus() {
        return rowstatus;
    }

    /**
     * 0删除,10为正常
     * @param rowstatus 0删除,10为正常
     */
    public void setRowstatus(BigDecimal rowstatus) {
        this.rowstatus = rowstatus;
    }

    /**
     * null
     * @return CATID null
     */
    public BigDecimal getCatid() {
        return catid;
    }

    /**
     * null
     * @param catid null
     */
    public void setCatid(BigDecimal catid) {
        this.catid = catid;
    }

    /**
     * 件烟条形码，件烟码前6位,(91)除外
     * @return BIGBOX_BAR 件烟条形码，件烟码前6位,(91)除外
     */
    public String getBigboxBar() {
        return bigboxBar;
    }

    /**
     * 件烟条形码，件烟码前6位,(91)除外
     * @param bigboxBar 件烟条形码，件烟码前6位,(91)除外
     */
    public void setBigboxBar(String bigboxBar) {
        this.bigboxBar = bigboxBar == null ? null : bigboxBar.trim();
    }

    /**
     * 条烟条形码
     * @return PACK_BAR 条烟条形码
     */
    public String getPackBar() {
        return packBar;
    }

    /**
     * 条烟条形码
     * @param packBar 条烟条形码
     */
    public void setPackBar(String packBar) {
        this.packBar = packBar == null ? null : packBar.trim();
    }

    /**
     * 商品类别 1：商品，2：促销品，3：样品，4：罚没烟，5：其他
     * @return ITEM_KIND 商品类别 1：商品，2：促销品，3：样品，4：罚没烟，5：其他
     */
    public String getItemKind() {
        return itemKind;
    }

    /**
     * 商品类别 1：商品，2：促销品，3：样品，4：罚没烟，5：其他
     * @param itemKind 商品类别 1：商品，2：促销品，3：样品，4：罚没烟，5：其他
     */
    public void setItemKind(String itemKind) {
        this.itemKind = itemKind == null ? null : itemKind.trim();
    }

    /**
     * 价类 1：一类，2：二类，3：三类，4：四类，5：五类，6：无价类
     * @return KIND 价类 1：一类，2：二类，3：三类，4：四类，5：五类，6：无价类
     */
    public String getKind() {
        return kind;
    }

    /**
     * 价类 1：一类，2：二类，3：三类，4：四类，5：五类，6：无价类
     * @param kind 价类 1：一类，2：二类，3：三类，4：四类，5：五类，6：无价类
     */
    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    /**
     * 盒支比率   
     * @return H_SIZE 盒支比率   
     */
    public BigDecimal gethSize() {
        return hSize;
    }

    /**
     * 盒支比率   
     * @param hSize 盒支比率   
     */
    public void sethSize(BigDecimal hSize) {
        this.hSize = hSize;
    }

    /**
     * 条支比率
     * @return T_SIZE 条支比率
     */
    public BigDecimal gettSize() {
        return tSize;
    }

    /**
     * 条支比率
     * @param tSize 条支比率
     */
    public void settSize(BigDecimal tSize) {
        this.tSize = tSize;
    }

    /**
     * 件支比率
     * @return J_SIZE 件支比率
     */
    public BigDecimal getjSize() {
        return jSize;
    }

    /**
     * 件支比率
     * @param jSize 件支比率
     */
    public void setjSize(BigDecimal jSize) {
        this.jSize = jSize;
    }

    /**
     * 万支支比率
     * @return W_SIZE 万支支比率
     */
    public BigDecimal getwSize() {
        return wSize;
    }

    /**
     * 万支支比率
     * @param wSize 万支支比率
     */
    public void setwSize(BigDecimal wSize) {
        this.wSize = wSize;
    }

    /**
     *  箱支比率 
     * @return X_SIZE  箱支比率 
     */
    public BigDecimal getxSize() {
        return xSize;
    }

    /**
     *  箱支比率 
     * @param xSize  箱支比率 
     */
    public void setxSize(BigDecimal xSize) {
        this.xSize = xSize;
    }

    /**
     * 每件烟重量，以克为单位，用于出库称重
     * @return WEIGHT 每件烟重量，以克为单位，用于出库称重
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 每件烟重量，以克为单位，用于出库称重
     * @param weight 每件烟重量，以克为单位，用于出库称重
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 满盘数量，正常烟为30一托盘，异型烟为40?
     * @return FULLCOUNT 满盘数量，正常烟为30一托盘，异型烟为40?
     */
    public BigDecimal getFullcount() {
        return fullcount;
    }

    /**
     * 满盘数量，正常烟为30一托盘，异型烟为40?
     * @param fullcount 满盘数量，正常烟为30一托盘，异型烟为40?
     */
    public void setFullcount(BigDecimal fullcount) {
        this.fullcount = fullcount;
    }

    /**
     * 10 自动拆垛 0 人工拆垛
     * @return CDTYPE 10 自动拆垛 0 人工拆垛
     */
    public BigDecimal getCdtype() {
        return cdtype;
    }

    /**
     * 10 自动拆垛 0 人工拆垛
     * @param cdtype 10 自动拆垛 0 人工拆垛
     */
    public void setCdtype(BigDecimal cdtype) {
        this.cdtype = cdtype;
    }

    /**
     * 10 能扫码识别  0无法扫码识别
     * @return ISCANSCANCODE 10 能扫码识别  0无法扫码识别
     */
    public BigDecimal getIscanscancode() {
        return iscanscancode;
    }

    /**
     * 10 能扫码识别  0无法扫码识别
     * @param iscanscancode 10 能扫码识别  0无法扫码识别
     */
    public void setIscanscancode(BigDecimal iscanscancode) {
        this.iscanscancode = iscanscancode;
    }

    /**
     *   垛形 默认1
     * @return DXTYPE   垛形 默认1
     */
    public String getDxtype() {
        return dxtype;
    }

    /**
     *   垛形 默认1
     * @param dxtype   垛形 默认1
     */
    public void setDxtype(String dxtype) {
        this.dxtype = dxtype == null ? null : dxtype.trim();
    }

    /**
     * 件条
     * @return JT_SIZE 件条
     */
    public BigDecimal getJtSize() {
        return jtSize;
    }

    /**
     * 件条
     * @param jtSize 件条
     */
    public void setJtSize(BigDecimal jtSize) {
        this.jtSize = jtSize;
    }

    /**
     * 万条
     * @return WZ_SIZE 万条
     */
    public BigDecimal getWzSize() {
        return wzSize;
    }

    /**
     * 万条
     * @param wzSize 万条
     */
    public void setWzSize(BigDecimal wzSize) {
        this.wzSize = wzSize;
    }

    /**
     * 0为正常烟，1为异性烟
     * @return
     */
	public String getShiptypename() {
		return shiptypename;
	}

	/**
	 * 0为正常烟，1为异性烟
	 * @param shiptypename
	 */
	public void setShiptypename(String shiptypename) {
		this.shiptypename = shiptypename;
	}

	/**
	 * 搜素关键字
	 * @return
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * 搜素关键字
	 * @param keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
    
	
}