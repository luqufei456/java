package com.yiran.crm.pojo;

import java.io.Serializable;

public class CstCustomer implements Serializable {
    private Long custId;

    private String custName;


    // 数据字典 - 外键列
    private String custSource;
    private String custIndustry;
    private String custLevel;

    // 对象之间关联关系
    private BaseDict baseDict_custSource;
    private BaseDict baseDict_custIndustry;
    private BaseDict baseDict_custLevel;


    private String custPhone;

    private String custRegion;

    private String custZip;

    private String custAddress;

    private String custFax;

    private String custWebsite;

    private String custLicence;

    private String custCorporation;

    private Long custCapital;

    private String custBank;

    private String custPic;

    private String custMemo;

    public BaseDict getBaseDict_custSource() {
        return baseDict_custSource;
    }

    public void setBaseDict_custSource(BaseDict baseDict_custSource) {
        this.baseDict_custSource = baseDict_custSource;
    }

    public BaseDict getBaseDict_custIndustry() {
        return baseDict_custIndustry;
    }

    public void setBaseDict_custIndustry(BaseDict baseDict_custIndustry) {
        this.baseDict_custIndustry = baseDict_custIndustry;
    }

    public BaseDict getBaseDict_custLevel() {
        return baseDict_custLevel;
    }

    public void setBaseDict_custLevel(BaseDict baseDict_custLevel) {
        this.baseDict_custLevel = baseDict_custLevel;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource == null ? null : custSource.trim();
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry == null ? null : custIndustry.trim();
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel == null ? null : custLevel.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCustRegion() {
        return custRegion;
    }

    public void setCustRegion(String custRegion) {
        this.custRegion = custRegion == null ? null : custRegion.trim();
    }

    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip == null ? null : custZip.trim();
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress == null ? null : custAddress.trim();
    }

    public String getCustFax() {
        return custFax;
    }

    public void setCustFax(String custFax) {
        this.custFax = custFax == null ? null : custFax.trim();
    }

    public String getCustWebsite() {
        return custWebsite;
    }

    public void setCustWebsite(String custWebsite) {
        this.custWebsite = custWebsite == null ? null : custWebsite.trim();
    }

    public String getCustLicence() {
        return custLicence;
    }

    public void setCustLicence(String custLicence) {
        this.custLicence = custLicence == null ? null : custLicence.trim();
    }

    public String getCustCorporation() {
        return custCorporation;
    }

    public void setCustCorporation(String custCorporation) {
        this.custCorporation = custCorporation == null ? null : custCorporation.trim();
    }

    public Long getCustCapital() {
        return custCapital;
    }

    public void setCustCapital(Long custCapital) {
        this.custCapital = custCapital;
    }

    public String getCustBank() {
        return custBank;
    }

    public void setCustBank(String custBank) {
        this.custBank = custBank == null ? null : custBank.trim();
    }

    public String getCustPic() {
        return custPic;
    }

    public void setCustPic(String custPic) {
        this.custPic = custPic == null ? null : custPic.trim();
    }

    public String getCustMemo() {
        return custMemo;
    }

    public void setCustMemo(String custMemo) {
        this.custMemo = custMemo == null ? null : custMemo.trim();
    }
}