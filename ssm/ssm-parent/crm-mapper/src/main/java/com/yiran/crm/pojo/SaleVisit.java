package com.yiran.crm.pojo;

import java.io.Serializable;
import java.util.Date;

// 沟通记录
public class SaleVisit implements Serializable {
    private String visitId;

    // 客户
    private Long visitCustId;
    private CstCustomer cstCustomer;

    // 系统用户
    private Long visitUserId;
    private SysUser sysUser;

    private Date visitTime;

    private String visitInterviewee;

    private String visitAddr;

    private String visitDetail;

    private Date visitNexttime;

    public CstCustomer getCstCustomer() {
        return cstCustomer;
    }

    public void setCstCustomer(CstCustomer cstCustomer) {
        this.cstCustomer = cstCustomer;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId == null ? null : visitId.trim();
    }

    public Long getVisitCustId() {
        return visitCustId;
    }

    public void setVisitCustId(Long visitCustId) {
        this.visitCustId = visitCustId;
    }

    public Long getVisitUserId() {
        return visitUserId;
    }

    public void setVisitUserId(Long visitUserId) {
        this.visitUserId = visitUserId;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitInterviewee() {
        return visitInterviewee;
    }

    public void setVisitInterviewee(String visitInterviewee) {
        this.visitInterviewee = visitInterviewee == null ? null : visitInterviewee.trim();
    }

    public String getVisitAddr() {
        return visitAddr;
    }

    public void setVisitAddr(String visitAddr) {
        this.visitAddr = visitAddr == null ? null : visitAddr.trim();
    }

    public String getVisitDetail() {
        return visitDetail;
    }

    public void setVisitDetail(String visitDetail) {
        this.visitDetail = visitDetail == null ? null : visitDetail.trim();
    }

    public Date getVisitNexttime() {
        return visitNexttime;
    }

    public void setVisitNexttime(Date visitNexttime) {
        this.visitNexttime = visitNexttime;
    }
}