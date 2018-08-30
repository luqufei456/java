package com.yiran.crm.pojo;

import java.io.Serializable;

public class CstLinkman implements Serializable {
    private Long lkmId;

    private String lkmName;

    private Long lkmCustId;

    private String lkmGender;

    private String lkmPhone;

    private String lkmMobile;

    private String lkmEmail;

    private String lkmQq;

    private String lkmPosition;

    private String lkmMemo;

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName == null ? null : lkmName.trim();
    }

    public Long getLkmCustId() {
        return lkmCustId;
    }

    public void setLkmCustId(Long lkmCustId) {
        this.lkmCustId = lkmCustId;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender == null ? null : lkmGender.trim();
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone == null ? null : lkmPhone.trim();
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile == null ? null : lkmMobile.trim();
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail == null ? null : lkmEmail.trim();
    }

    public String getLkmQq() {
        return lkmQq;
    }

    public void setLkmQq(String lkmQq) {
        this.lkmQq = lkmQq == null ? null : lkmQq.trim();
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition == null ? null : lkmPosition.trim();
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo == null ? null : lkmMemo.trim();
    }
}