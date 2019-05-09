package com.sf.dao.model;

import com.sf.constant.CryptField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tf_sys_user")
public class TfSysUser implements Serializable {
    /**
     * 用户标识
     * 加上 @GeneratedValue注解可以返回主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 账号
     */
    @Column(name = "staff_id")
    private String staffId;

    /**
     * 性别：M-男，W-女
     */
    private String sex;

    /**
     * 手机号码
     */
    @CryptField
    @Column(name = "mobile_no")
    private String mobileNo;

    /**
     * 省编码
     */
    @Column(name = "provinces_code")
    private Integer provincesCode;

    /**
     * 城市编码
     */
    @Column(name = "city_code")
    private Integer cityCode;

    /**
     * 地区编码
     */
    @Column(name = "area_code")
    private Integer areaCode;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 有效状态：1-有效，0-无效
     */
    @Column(name = "valid_tag")
    private Boolean validTag;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改人
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户标识
     *
     * @return user_id - 用户标识
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户标识
     *
     * @param userId 用户标识
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取账号
     *
     * @return staff_id - 账号
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * 设置账号
     *
     * @param staffId 账号
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取性别：M-男，W-女
     *
     * @return sex - 性别：M-男，W-女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别：M-男，W-女
     *
     * @param sex 性别：M-男，W-女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取手机号码
     *
     * @return mobile_no - 手机号码
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置手机号码
     *
     * @param mobileNo 手机号码
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 获取省编码
     *
     * @return provinces_code - 省编码
     */
    public Integer getProvincesCode() {
        return provincesCode;
    }

    /**
     * 设置省编码
     *
     * @param provincesCode 省编码
     */
    public void setProvincesCode(Integer provincesCode) {
        this.provincesCode = provincesCode;
    }

    /**
     * 获取城市编码
     *
     * @return city_code - 城市编码
     */
    public Integer getCityCode() {
        return cityCode;
    }

    /**
     * 设置城市编码
     *
     * @param cityCode 城市编码
     */
    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 获取地区编码
     *
     * @return area_code - 地区编码
     */
    public Integer getAreaCode() {
        return areaCode;
    }

    /**
     * 设置地区编码
     *
     * @param areaCode 地区编码
     */
    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取详细地址
     *
     * @return address - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取有效状态：1-有效，0-无效
     *
     * @return valid_tag - 有效状态：1-有效，0-无效
     */
    public Boolean getValidTag() {
        return validTag;
    }

    /**
     * 设置有效状态：1-有效，0-无效
     *
     * @param validTag 有效状态：1-有效，0-无效
     */
    public void setValidTag(Boolean validTag) {
        this.validTag = validTag;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人
     *
     * @return update_by - 修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改人
     *
     * @param updateBy 修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}