package com.yiran.crm.pojo;

import java.util.ArrayList;
import java.util.List;

public class CstCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CstCustomerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Long value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Long value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Long value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Long value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Long value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Long> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Long> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Long value1, Long value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Long value1, Long value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustSourceIsNull() {
            addCriterion("cust_source is null");
            return (Criteria) this;
        }

        public Criteria andCustSourceIsNotNull() {
            addCriterion("cust_source is not null");
            return (Criteria) this;
        }

        public Criteria andCustSourceEqualTo(String value) {
            addCriterion("cust_source =", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceNotEqualTo(String value) {
            addCriterion("cust_source <>", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceGreaterThan(String value) {
            addCriterion("cust_source >", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceGreaterThanOrEqualTo(String value) {
            addCriterion("cust_source >=", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceLessThan(String value) {
            addCriterion("cust_source <", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceLessThanOrEqualTo(String value) {
            addCriterion("cust_source <=", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceLike(String value) {
            addCriterion("cust_source like", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceNotLike(String value) {
            addCriterion("cust_source not like", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceIn(List<String> values) {
            addCriterion("cust_source in", values, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceNotIn(List<String> values) {
            addCriterion("cust_source not in", values, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceBetween(String value1, String value2) {
            addCriterion("cust_source between", value1, value2, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceNotBetween(String value1, String value2) {
            addCriterion("cust_source not between", value1, value2, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustIndustryIsNull() {
            addCriterion("cust_industry is null");
            return (Criteria) this;
        }

        public Criteria andCustIndustryIsNotNull() {
            addCriterion("cust_industry is not null");
            return (Criteria) this;
        }

        public Criteria andCustIndustryEqualTo(String value) {
            addCriterion("cust_industry =", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotEqualTo(String value) {
            addCriterion("cust_industry <>", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryGreaterThan(String value) {
            addCriterion("cust_industry >", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("cust_industry >=", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryLessThan(String value) {
            addCriterion("cust_industry <", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryLessThanOrEqualTo(String value) {
            addCriterion("cust_industry <=", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryLike(String value) {
            addCriterion("cust_industry like", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotLike(String value) {
            addCriterion("cust_industry not like", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryIn(List<String> values) {
            addCriterion("cust_industry in", values, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotIn(List<String> values) {
            addCriterion("cust_industry not in", values, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryBetween(String value1, String value2) {
            addCriterion("cust_industry between", value1, value2, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotBetween(String value1, String value2) {
            addCriterion("cust_industry not between", value1, value2, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustLevelIsNull() {
            addCriterion("cust_level is null");
            return (Criteria) this;
        }

        public Criteria andCustLevelIsNotNull() {
            addCriterion("cust_level is not null");
            return (Criteria) this;
        }

        public Criteria andCustLevelEqualTo(String value) {
            addCriterion("cust_level =", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotEqualTo(String value) {
            addCriterion("cust_level <>", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelGreaterThan(String value) {
            addCriterion("cust_level >", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelGreaterThanOrEqualTo(String value) {
            addCriterion("cust_level >=", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelLessThan(String value) {
            addCriterion("cust_level <", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelLessThanOrEqualTo(String value) {
            addCriterion("cust_level <=", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelLike(String value) {
            addCriterion("cust_level like", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotLike(String value) {
            addCriterion("cust_level not like", value, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelIn(List<String> values) {
            addCriterion("cust_level in", values, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotIn(List<String> values) {
            addCriterion("cust_level not in", values, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelBetween(String value1, String value2) {
            addCriterion("cust_level between", value1, value2, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustLevelNotBetween(String value1, String value2) {
            addCriterion("cust_level not between", value1, value2, "custLevel");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNull() {
            addCriterion("cust_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNotNull() {
            addCriterion("cust_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneEqualTo(String value) {
            addCriterion("cust_phone =", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotEqualTo(String value) {
            addCriterion("cust_phone <>", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThan(String value) {
            addCriterion("cust_phone >", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cust_phone >=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThan(String value) {
            addCriterion("cust_phone <", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThanOrEqualTo(String value) {
            addCriterion("cust_phone <=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLike(String value) {
            addCriterion("cust_phone like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotLike(String value) {
            addCriterion("cust_phone not like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIn(List<String> values) {
            addCriterion("cust_phone in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotIn(List<String> values) {
            addCriterion("cust_phone not in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneBetween(String value1, String value2) {
            addCriterion("cust_phone between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotBetween(String value1, String value2) {
            addCriterion("cust_phone not between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustRegionIsNull() {
            addCriterion("cust_region is null");
            return (Criteria) this;
        }

        public Criteria andCustRegionIsNotNull() {
            addCriterion("cust_region is not null");
            return (Criteria) this;
        }

        public Criteria andCustRegionEqualTo(String value) {
            addCriterion("cust_region =", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionNotEqualTo(String value) {
            addCriterion("cust_region <>", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionGreaterThan(String value) {
            addCriterion("cust_region >", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionGreaterThanOrEqualTo(String value) {
            addCriterion("cust_region >=", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionLessThan(String value) {
            addCriterion("cust_region <", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionLessThanOrEqualTo(String value) {
            addCriterion("cust_region <=", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionLike(String value) {
            addCriterion("cust_region like", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionNotLike(String value) {
            addCriterion("cust_region not like", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionIn(List<String> values) {
            addCriterion("cust_region in", values, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionNotIn(List<String> values) {
            addCriterion("cust_region not in", values, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionBetween(String value1, String value2) {
            addCriterion("cust_region between", value1, value2, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionNotBetween(String value1, String value2) {
            addCriterion("cust_region not between", value1, value2, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustZipIsNull() {
            addCriterion("cust_zip is null");
            return (Criteria) this;
        }

        public Criteria andCustZipIsNotNull() {
            addCriterion("cust_zip is not null");
            return (Criteria) this;
        }

        public Criteria andCustZipEqualTo(String value) {
            addCriterion("cust_zip =", value, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipNotEqualTo(String value) {
            addCriterion("cust_zip <>", value, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipGreaterThan(String value) {
            addCriterion("cust_zip >", value, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipGreaterThanOrEqualTo(String value) {
            addCriterion("cust_zip >=", value, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipLessThan(String value) {
            addCriterion("cust_zip <", value, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipLessThanOrEqualTo(String value) {
            addCriterion("cust_zip <=", value, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipLike(String value) {
            addCriterion("cust_zip like", value, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipNotLike(String value) {
            addCriterion("cust_zip not like", value, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipIn(List<String> values) {
            addCriterion("cust_zip in", values, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipNotIn(List<String> values) {
            addCriterion("cust_zip not in", values, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipBetween(String value1, String value2) {
            addCriterion("cust_zip between", value1, value2, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustZipNotBetween(String value1, String value2) {
            addCriterion("cust_zip not between", value1, value2, "custZip");
            return (Criteria) this;
        }

        public Criteria andCustAddressIsNull() {
            addCriterion("cust_address is null");
            return (Criteria) this;
        }

        public Criteria andCustAddressIsNotNull() {
            addCriterion("cust_address is not null");
            return (Criteria) this;
        }

        public Criteria andCustAddressEqualTo(String value) {
            addCriterion("cust_address =", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotEqualTo(String value) {
            addCriterion("cust_address <>", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressGreaterThan(String value) {
            addCriterion("cust_address >", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressGreaterThanOrEqualTo(String value) {
            addCriterion("cust_address >=", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressLessThan(String value) {
            addCriterion("cust_address <", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressLessThanOrEqualTo(String value) {
            addCriterion("cust_address <=", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressLike(String value) {
            addCriterion("cust_address like", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotLike(String value) {
            addCriterion("cust_address not like", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressIn(List<String> values) {
            addCriterion("cust_address in", values, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotIn(List<String> values) {
            addCriterion("cust_address not in", values, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressBetween(String value1, String value2) {
            addCriterion("cust_address between", value1, value2, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotBetween(String value1, String value2) {
            addCriterion("cust_address not between", value1, value2, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustFaxIsNull() {
            addCriterion("cust_fax is null");
            return (Criteria) this;
        }

        public Criteria andCustFaxIsNotNull() {
            addCriterion("cust_fax is not null");
            return (Criteria) this;
        }

        public Criteria andCustFaxEqualTo(String value) {
            addCriterion("cust_fax =", value, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxNotEqualTo(String value) {
            addCriterion("cust_fax <>", value, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxGreaterThan(String value) {
            addCriterion("cust_fax >", value, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxGreaterThanOrEqualTo(String value) {
            addCriterion("cust_fax >=", value, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxLessThan(String value) {
            addCriterion("cust_fax <", value, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxLessThanOrEqualTo(String value) {
            addCriterion("cust_fax <=", value, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxLike(String value) {
            addCriterion("cust_fax like", value, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxNotLike(String value) {
            addCriterion("cust_fax not like", value, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxIn(List<String> values) {
            addCriterion("cust_fax in", values, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxNotIn(List<String> values) {
            addCriterion("cust_fax not in", values, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxBetween(String value1, String value2) {
            addCriterion("cust_fax between", value1, value2, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustFaxNotBetween(String value1, String value2) {
            addCriterion("cust_fax not between", value1, value2, "custFax");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteIsNull() {
            addCriterion("cust_website is null");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteIsNotNull() {
            addCriterion("cust_website is not null");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteEqualTo(String value) {
            addCriterion("cust_website =", value, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteNotEqualTo(String value) {
            addCriterion("cust_website <>", value, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteGreaterThan(String value) {
            addCriterion("cust_website >", value, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("cust_website >=", value, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteLessThan(String value) {
            addCriterion("cust_website <", value, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteLessThanOrEqualTo(String value) {
            addCriterion("cust_website <=", value, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteLike(String value) {
            addCriterion("cust_website like", value, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteNotLike(String value) {
            addCriterion("cust_website not like", value, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteIn(List<String> values) {
            addCriterion("cust_website in", values, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteNotIn(List<String> values) {
            addCriterion("cust_website not in", values, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteBetween(String value1, String value2) {
            addCriterion("cust_website between", value1, value2, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustWebsiteNotBetween(String value1, String value2) {
            addCriterion("cust_website not between", value1, value2, "custWebsite");
            return (Criteria) this;
        }

        public Criteria andCustLicenceIsNull() {
            addCriterion("cust_licence is null");
            return (Criteria) this;
        }

        public Criteria andCustLicenceIsNotNull() {
            addCriterion("cust_licence is not null");
            return (Criteria) this;
        }

        public Criteria andCustLicenceEqualTo(String value) {
            addCriterion("cust_licence =", value, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceNotEqualTo(String value) {
            addCriterion("cust_licence <>", value, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceGreaterThan(String value) {
            addCriterion("cust_licence >", value, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceGreaterThanOrEqualTo(String value) {
            addCriterion("cust_licence >=", value, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceLessThan(String value) {
            addCriterion("cust_licence <", value, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceLessThanOrEqualTo(String value) {
            addCriterion("cust_licence <=", value, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceLike(String value) {
            addCriterion("cust_licence like", value, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceNotLike(String value) {
            addCriterion("cust_licence not like", value, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceIn(List<String> values) {
            addCriterion("cust_licence in", values, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceNotIn(List<String> values) {
            addCriterion("cust_licence not in", values, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceBetween(String value1, String value2) {
            addCriterion("cust_licence between", value1, value2, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustLicenceNotBetween(String value1, String value2) {
            addCriterion("cust_licence not between", value1, value2, "custLicence");
            return (Criteria) this;
        }

        public Criteria andCustCorporationIsNull() {
            addCriterion("cust_corporation is null");
            return (Criteria) this;
        }

        public Criteria andCustCorporationIsNotNull() {
            addCriterion("cust_corporation is not null");
            return (Criteria) this;
        }

        public Criteria andCustCorporationEqualTo(String value) {
            addCriterion("cust_corporation =", value, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationNotEqualTo(String value) {
            addCriterion("cust_corporation <>", value, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationGreaterThan(String value) {
            addCriterion("cust_corporation >", value, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationGreaterThanOrEqualTo(String value) {
            addCriterion("cust_corporation >=", value, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationLessThan(String value) {
            addCriterion("cust_corporation <", value, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationLessThanOrEqualTo(String value) {
            addCriterion("cust_corporation <=", value, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationLike(String value) {
            addCriterion("cust_corporation like", value, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationNotLike(String value) {
            addCriterion("cust_corporation not like", value, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationIn(List<String> values) {
            addCriterion("cust_corporation in", values, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationNotIn(List<String> values) {
            addCriterion("cust_corporation not in", values, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationBetween(String value1, String value2) {
            addCriterion("cust_corporation between", value1, value2, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCorporationNotBetween(String value1, String value2) {
            addCriterion("cust_corporation not between", value1, value2, "custCorporation");
            return (Criteria) this;
        }

        public Criteria andCustCapitalIsNull() {
            addCriterion("cust_capital is null");
            return (Criteria) this;
        }

        public Criteria andCustCapitalIsNotNull() {
            addCriterion("cust_capital is not null");
            return (Criteria) this;
        }

        public Criteria andCustCapitalEqualTo(Long value) {
            addCriterion("cust_capital =", value, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustCapitalNotEqualTo(Long value) {
            addCriterion("cust_capital <>", value, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustCapitalGreaterThan(Long value) {
            addCriterion("cust_capital >", value, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustCapitalGreaterThanOrEqualTo(Long value) {
            addCriterion("cust_capital >=", value, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustCapitalLessThan(Long value) {
            addCriterion("cust_capital <", value, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustCapitalLessThanOrEqualTo(Long value) {
            addCriterion("cust_capital <=", value, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustCapitalIn(List<Long> values) {
            addCriterion("cust_capital in", values, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustCapitalNotIn(List<Long> values) {
            addCriterion("cust_capital not in", values, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustCapitalBetween(Long value1, Long value2) {
            addCriterion("cust_capital between", value1, value2, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustCapitalNotBetween(Long value1, Long value2) {
            addCriterion("cust_capital not between", value1, value2, "custCapital");
            return (Criteria) this;
        }

        public Criteria andCustBankIsNull() {
            addCriterion("cust_bank is null");
            return (Criteria) this;
        }

        public Criteria andCustBankIsNotNull() {
            addCriterion("cust_bank is not null");
            return (Criteria) this;
        }

        public Criteria andCustBankEqualTo(String value) {
            addCriterion("cust_bank =", value, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankNotEqualTo(String value) {
            addCriterion("cust_bank <>", value, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankGreaterThan(String value) {
            addCriterion("cust_bank >", value, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankGreaterThanOrEqualTo(String value) {
            addCriterion("cust_bank >=", value, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankLessThan(String value) {
            addCriterion("cust_bank <", value, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankLessThanOrEqualTo(String value) {
            addCriterion("cust_bank <=", value, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankLike(String value) {
            addCriterion("cust_bank like", value, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankNotLike(String value) {
            addCriterion("cust_bank not like", value, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankIn(List<String> values) {
            addCriterion("cust_bank in", values, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankNotIn(List<String> values) {
            addCriterion("cust_bank not in", values, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankBetween(String value1, String value2) {
            addCriterion("cust_bank between", value1, value2, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustBankNotBetween(String value1, String value2) {
            addCriterion("cust_bank not between", value1, value2, "custBank");
            return (Criteria) this;
        }

        public Criteria andCustPicIsNull() {
            addCriterion("cust_pic is null");
            return (Criteria) this;
        }

        public Criteria andCustPicIsNotNull() {
            addCriterion("cust_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCustPicEqualTo(String value) {
            addCriterion("cust_pic =", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicNotEqualTo(String value) {
            addCriterion("cust_pic <>", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicGreaterThan(String value) {
            addCriterion("cust_pic >", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicGreaterThanOrEqualTo(String value) {
            addCriterion("cust_pic >=", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicLessThan(String value) {
            addCriterion("cust_pic <", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicLessThanOrEqualTo(String value) {
            addCriterion("cust_pic <=", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicLike(String value) {
            addCriterion("cust_pic like", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicNotLike(String value) {
            addCriterion("cust_pic not like", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicIn(List<String> values) {
            addCriterion("cust_pic in", values, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicNotIn(List<String> values) {
            addCriterion("cust_pic not in", values, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicBetween(String value1, String value2) {
            addCriterion("cust_pic between", value1, value2, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicNotBetween(String value1, String value2) {
            addCriterion("cust_pic not between", value1, value2, "custPic");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}