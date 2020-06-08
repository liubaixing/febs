package com.febs.shangpin.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShangpinGysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShangpinGysExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSpdmIsNull() {
            addCriterion("spdm is null");
            return (Criteria) this;
        }

        public Criteria andSpdmIsNotNull() {
            addCriterion("spdm is not null");
            return (Criteria) this;
        }

        public Criteria andSpdmEqualTo(String value) {
            addCriterion("spdm =", value, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmNotEqualTo(String value) {
            addCriterion("spdm <>", value, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmGreaterThan(String value) {
            addCriterion("spdm >", value, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmGreaterThanOrEqualTo(String value) {
            addCriterion("spdm >=", value, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmLessThan(String value) {
            addCriterion("spdm <", value, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmLessThanOrEqualTo(String value) {
            addCriterion("spdm <=", value, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmLike(String value) {
            addCriterion("spdm like", value, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmNotLike(String value) {
            addCriterion("spdm not like", value, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmIn(List<String> values) {
            addCriterion("spdm in", values, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmNotIn(List<String> values) {
            addCriterion("spdm not in", values, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmBetween(String value1, String value2) {
            addCriterion("spdm between", value1, value2, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpdmNotBetween(String value1, String value2) {
            addCriterion("spdm not between", value1, value2, "spdm");
            return (Criteria) this;
        }

        public Criteria andSpmcIsNull() {
            addCriterion("spmc is null");
            return (Criteria) this;
        }

        public Criteria andSpmcIsNotNull() {
            addCriterion("spmc is not null");
            return (Criteria) this;
        }

        public Criteria andSpmcEqualTo(String value) {
            addCriterion("spmc =", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotEqualTo(String value) {
            addCriterion("spmc <>", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcGreaterThan(String value) {
            addCriterion("spmc >", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcGreaterThanOrEqualTo(String value) {
            addCriterion("spmc >=", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcLessThan(String value) {
            addCriterion("spmc <", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcLessThanOrEqualTo(String value) {
            addCriterion("spmc <=", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcLike(String value) {
            addCriterion("spmc like", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotLike(String value) {
            addCriterion("spmc not like", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcIn(List<String> values) {
            addCriterion("spmc in", values, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotIn(List<String> values) {
            addCriterion("spmc not in", values, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcBetween(String value1, String value2) {
            addCriterion("spmc between", value1, value2, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotBetween(String value1, String value2) {
            addCriterion("spmc not between", value1, value2, "spmc");
            return (Criteria) this;
        }


        public Criteria andXsjIsNull() {
            addCriterion("xsj is null");
            return (Criteria) this;
        }

        public Criteria andXsjIsNotNull() {
            addCriterion("xsj is not null");
            return (Criteria) this;
        }

        public Criteria andXsjEqualTo(BigDecimal value) {
            addCriterion("xsj =", value, "xsj");
            return (Criteria) this;
        }

        public Criteria andXsjNotEqualTo(BigDecimal value) {
            addCriterion("xsj <>", value, "xsj");
            return (Criteria) this;
        }

        public Criteria andXsjGreaterThan(BigDecimal value) {
            addCriterion("xsj >", value, "xsj");
            return (Criteria) this;
        }

        public Criteria andXsjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("xsj >=", value, "xsj");
            return (Criteria) this;
        }

        public Criteria andXsjLessThan(BigDecimal value) {
            addCriterion("xsj <", value, "xsj");
            return (Criteria) this;
        }

        public Criteria andXsjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("xsj <=", value, "xsj");
            return (Criteria) this;
        }

        public Criteria andXsjIn(List<BigDecimal> values) {
            addCriterion("xsj in", values, "xsj");
            return (Criteria) this;
        }

        public Criteria andXsjNotIn(List<BigDecimal> values) {
            addCriterion("xsj not in", values, "xsj");
            return (Criteria) this;
        }

        public Criteria andXsjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xsj between", value1, value2, "xsj");
            return (Criteria) this;
        }

        public Criteria andXsjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xsj not between", value1, value2, "xsj");
            return (Criteria) this;
        }

        public Criteria andDpjIsNull() {
            addCriterion("dpj is null");
            return (Criteria) this;
        }

        public Criteria andDpjIsNotNull() {
            addCriterion("dpj is not null");
            return (Criteria) this;
        }

        public Criteria andDpjEqualTo(BigDecimal value) {
            addCriterion("dpj =", value, "dpj");
            return (Criteria) this;
        }

        public Criteria andDpjNotEqualTo(BigDecimal value) {
            addCriterion("dpj <>", value, "dpj");
            return (Criteria) this;
        }

        public Criteria andDpjGreaterThan(BigDecimal value) {
            addCriterion("dpj >", value, "dpj");
            return (Criteria) this;
        }

        public Criteria andDpjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dpj >=", value, "dpj");
            return (Criteria) this;
        }

        public Criteria andDpjLessThan(BigDecimal value) {
            addCriterion("dpj <", value, "dpj");
            return (Criteria) this;
        }

        public Criteria andDpjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dpj <=", value, "dpj");
            return (Criteria) this;
        }

        public Criteria andDpjIn(List<BigDecimal> values) {
            addCriterion("dpj in", values, "dpj");
            return (Criteria) this;
        }

        public Criteria andDpjNotIn(List<BigDecimal> values) {
            addCriterion("dpj not in", values, "dpj");
            return (Criteria) this;
        }

        public Criteria andDpjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dpj between", value1, value2, "dpj");
            return (Criteria) this;
        }

        public Criteria andDpjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dpj not between", value1, value2, "dpj");
            return (Criteria) this;
        }

        public Criteria andYsjIsNull() {
            addCriterion("ysj is null");
            return (Criteria) this;
        }

        public Criteria andYsjIsNotNull() {
            addCriterion("ysj is not null");
            return (Criteria) this;
        }

        public Criteria andYsjEqualTo(BigDecimal value) {
            addCriterion("ysj =", value, "ysj");
            return (Criteria) this;
        }

        public Criteria andYsjNotEqualTo(BigDecimal value) {
            addCriterion("ysj <>", value, "ysj");
            return (Criteria) this;
        }

        public Criteria andYsjGreaterThan(BigDecimal value) {
            addCriterion("ysj >", value, "ysj");
            return (Criteria) this;
        }

        public Criteria andYsjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ysj >=", value, "ysj");
            return (Criteria) this;
        }

        public Criteria andYsjLessThan(BigDecimal value) {
            addCriterion("ysj <", value, "ysj");
            return (Criteria) this;
        }

        public Criteria andYsjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ysj <=", value, "ysj");
            return (Criteria) this;
        }

        public Criteria andYsjIn(List<BigDecimal> values) {
            addCriterion("ysj in", values, "ysj");
            return (Criteria) this;
        }

        public Criteria andYsjNotIn(List<BigDecimal> values) {
            addCriterion("ysj not in", values, "ysj");
            return (Criteria) this;
        }

        public Criteria andYsjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ysj between", value1, value2, "ysj");
            return (Criteria) this;
        }

        public Criteria andYsjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ysj not between", value1, value2, "ysj");
            return (Criteria) this;
        }

        public Criteria andShangpinIdIsNull() {
            addCriterion("shangpin_id is null");
            return (Criteria) this;
        }

        public Criteria andShangpinIdIsNotNull() {
            addCriterion("shangpin_id is not null");
            return (Criteria) this;
        }

        public Criteria andShangpinIdEqualTo(Integer value) {
            addCriterion("shangpin_id =", value, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andShangpinIdNotEqualTo(Integer value) {
            addCriterion("shangpin_id <>", value, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andShangpinIdGreaterThan(Integer value) {
            addCriterion("shangpin_id >", value, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andShangpinIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shangpin_id >=", value, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andShangpinIdLessThan(Integer value) {
            addCriterion("shangpin_id <", value, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andShangpinIdLessThanOrEqualTo(Integer value) {
            addCriterion("shangpin_id <=", value, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andShangpinIdIn(List<Integer> values) {
            addCriterion("shangpin_id in", values, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andShangpinIdNotIn(List<Integer> values) {
            addCriterion("shangpin_id not in", values, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andShangpinIdBetween(Integer value1, Integer value2) {
            addCriterion("shangpin_id between", value1, value2, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andShangpinIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shangpin_id not between", value1, value2, "shangpinId");
            return (Criteria) this;
        }

        public Criteria andCgjIsNull() {
            addCriterion("cgj is null");
            return (Criteria) this;
        }

        public Criteria andCgjIsNotNull() {
            addCriterion("cgj is not null");
            return (Criteria) this;
        }

        public Criteria andCgjEqualTo(BigDecimal value) {
            addCriterion("cgj =", value, "cgj");
            return (Criteria) this;
        }

        public Criteria andCgjNotEqualTo(BigDecimal value) {
            addCriterion("cgj <>", value, "cgj");
            return (Criteria) this;
        }

        public Criteria andCgjGreaterThan(BigDecimal value) {
            addCriterion("cgj >", value, "cgj");
            return (Criteria) this;
        }

        public Criteria andCgjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cgj >=", value, "cgj");
            return (Criteria) this;
        }

        public Criteria andCgjLessThan(BigDecimal value) {
            addCriterion("cgj <", value, "cgj");
            return (Criteria) this;
        }

        public Criteria andCgjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cgj <=", value, "cgj");
            return (Criteria) this;
        }

        public Criteria andCgjIn(List<BigDecimal> values) {
            addCriterion("cgj in", values, "cgj");
            return (Criteria) this;
        }

        public Criteria andCgjNotIn(List<BigDecimal> values) {
            addCriterion("cgj not in", values, "cgj");
            return (Criteria) this;
        }

        public Criteria andCgjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cgj between", value1, value2, "cgj");
            return (Criteria) this;
        }

        public Criteria andCgjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cgj not between", value1, value2, "cgj");
            return (Criteria) this;
        }

        public Criteria andGysIdIsNull() {
            addCriterion("gys_id is null");
            return (Criteria) this;
        }

        public Criteria andGysIdIsNotNull() {
            addCriterion("gys_id is not null");
            return (Criteria) this;
        }

        public Criteria andGysIdEqualTo(Integer value) {
            addCriterion("gys_id =", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdNotEqualTo(Integer value) {
            addCriterion("gys_id <>", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdGreaterThan(Integer value) {
            addCriterion("gys_id >", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gys_id >=", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdLessThan(Integer value) {
            addCriterion("gys_id <", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdLessThanOrEqualTo(Integer value) {
            addCriterion("gys_id <=", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdIn(List<Integer> values) {
            addCriterion("gys_id in", values, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdNotIn(List<Integer> values) {
            addCriterion("gys_id not in", values, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdBetween(Integer value1, Integer value2) {
            addCriterion("gys_id between", value1, value2, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gys_id not between", value1, value2, "gysId");
            return (Criteria) this;
        }

        public Criteria andQdlIsNull() {
            addCriterion("qdl is null");
            return (Criteria) this;
        }

        public Criteria andQdlIsNotNull() {
            addCriterion("qdl is not null");
            return (Criteria) this;
        }

        public Criteria andQdlEqualTo(Integer value) {
            addCriterion("qdl =", value, "qdl");
            return (Criteria) this;
        }

        public Criteria andQdlNotEqualTo(Integer value) {
            addCriterion("qdl <>", value, "qdl");
            return (Criteria) this;
        }

        public Criteria andQdlGreaterThan(Integer value) {
            addCriterion("qdl >", value, "qdl");
            return (Criteria) this;
        }

        public Criteria andQdlGreaterThanOrEqualTo(Integer value) {
            addCriterion("qdl >=", value, "qdl");
            return (Criteria) this;
        }

        public Criteria andQdlLessThan(Integer value) {
            addCriterion("qdl <", value, "qdl");
            return (Criteria) this;
        }

        public Criteria andQdlLessThanOrEqualTo(Integer value) {
            addCriterion("qdl <=", value, "qdl");
            return (Criteria) this;
        }

        public Criteria andQdlIn(List<Integer> values) {
            addCriterion("qdl in", values, "qdl");
            return (Criteria) this;
        }

        public Criteria andQdlNotIn(List<Integer> values) {
            addCriterion("qdl not in", values, "qdl");
            return (Criteria) this;
        }

        public Criteria andQdlBetween(Integer value1, Integer value2) {
            addCriterion("qdl between", value1, value2, "qdl");
            return (Criteria) this;
        }

        public Criteria andQdlNotBetween(Integer value1, Integer value2) {
            addCriterion("qdl not between", value1, value2, "qdl");
            return (Criteria) this;
        }

        public Criteria andJldwIdIsNull() {
            addCriterion("jldw_id is null");
            return (Criteria) this;
        }

        public Criteria andJldwIdIsNotNull() {
            addCriterion("jldw_id is not null");
            return (Criteria) this;
        }

        public Criteria andJldwIdEqualTo(Integer value) {
            addCriterion("jldw_id =", value, "jldwId");
            return (Criteria) this;
        }

        public Criteria andJldwIdNotEqualTo(Integer value) {
            addCriterion("jldw_id <>", value, "jldwId");
            return (Criteria) this;
        }

        public Criteria andJldwIdGreaterThan(Integer value) {
            addCriterion("jldw_id >", value, "jldwId");
            return (Criteria) this;
        }

        public Criteria andJldwIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("jldw_id >=", value, "jldwId");
            return (Criteria) this;
        }

        public Criteria andJldwIdLessThan(Integer value) {
            addCriterion("jldw_id <", value, "jldwId");
            return (Criteria) this;
        }

        public Criteria andJldwIdLessThanOrEqualTo(Integer value) {
            addCriterion("jldw_id <=", value, "jldwId");
            return (Criteria) this;
        }

        public Criteria andJldwIdIn(List<Integer> values) {
            addCriterion("jldw_id in", values, "jldwId");
            return (Criteria) this;
        }

        public Criteria andJldwIdNotIn(List<Integer> values) {
            addCriterion("jldw_id not in", values, "jldwId");
            return (Criteria) this;
        }

        public Criteria andJldwIdBetween(Integer value1, Integer value2) {
            addCriterion("jldw_id between", value1, value2, "jldwId");
            return (Criteria) this;
        }

        public Criteria andJldwIdNotBetween(Integer value1, Integer value2) {
            addCriterion("jldw_id not between", value1, value2, "jldwId");
            return (Criteria) this;
        }

        public Criteria andMrtpIsNull() {
            addCriterion("mrtp is null");
            return (Criteria) this;
        }

        public Criteria andMrtpIsNotNull() {
            addCriterion("mrtp is not null");
            return (Criteria) this;
        }

        public Criteria andMrtpEqualTo(String value) {
            addCriterion("mrtp =", value, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpNotEqualTo(String value) {
            addCriterion("mrtp <>", value, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpGreaterThan(String value) {
            addCriterion("mrtp >", value, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpGreaterThanOrEqualTo(String value) {
            addCriterion("mrtp >=", value, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpLessThan(String value) {
            addCriterion("mrtp <", value, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpLessThanOrEqualTo(String value) {
            addCriterion("mrtp <=", value, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpLike(String value) {
            addCriterion("mrtp like", value, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpNotLike(String value) {
            addCriterion("mrtp not like", value, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpIn(List<String> values) {
            addCriterion("mrtp in", values, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpNotIn(List<String> values) {
            addCriterion("mrtp not in", values, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpBetween(String value1, String value2) {
            addCriterion("mrtp between", value1, value2, "mrtp");
            return (Criteria) this;
        }

        public Criteria andMrtpNotBetween(String value1, String value2) {
            addCriterion("mrtp not between", value1, value2, "mrtp");
            return (Criteria) this;
        }

        public Criteria andZlIdIsNull() {
            addCriterion("zl_id is null");
            return (Criteria) this;
        }

        public Criteria andZlIdIsNotNull() {
            addCriterion("zl_id is not null");
            return (Criteria) this;
        }

        public Criteria andZlIdEqualTo(Integer value) {
            addCriterion("zl_id =", value, "zlId");
            return (Criteria) this;
        }

        public Criteria andZlIdNotEqualTo(Integer value) {
            addCriterion("zl_id <>", value, "zlId");
            return (Criteria) this;
        }

        public Criteria andZlIdGreaterThan(Integer value) {
            addCriterion("zl_id >", value, "zlId");
            return (Criteria) this;
        }

        public Criteria andZlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("zl_id >=", value, "zlId");
            return (Criteria) this;
        }

        public Criteria andZlIdLessThan(Integer value) {
            addCriterion("zl_id <", value, "zlId");
            return (Criteria) this;
        }

        public Criteria andZlIdLessThanOrEqualTo(Integer value) {
            addCriterion("zl_id <=", value, "zlId");
            return (Criteria) this;
        }

        public Criteria andZlIdIn(List<Integer> values) {
            addCriterion("zl_id in", values, "zlId");
            return (Criteria) this;
        }

        public Criteria andZlIdNotIn(List<Integer> values) {
            addCriterion("zl_id not in", values, "zlId");
            return (Criteria) this;
        }

        public Criteria andZlIdBetween(Integer value1, Integer value2) {
            addCriterion("zl_id between", value1, value2, "zlId");
            return (Criteria) this;
        }

        public Criteria andZlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("zl_id not between", value1, value2, "zlId");
            return (Criteria) this;
        }

        public Criteria andDlIdIsNull() {
            addCriterion("dl_id is null");
            return (Criteria) this;
        }

        public Criteria andDlIdIsNotNull() {
            addCriterion("dl_id is not null");
            return (Criteria) this;
        }

        public Criteria andDlIdEqualTo(Integer value) {
            addCriterion("dl_id =", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdNotEqualTo(Integer value) {
            addCriterion("dl_id <>", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdGreaterThan(Integer value) {
            addCriterion("dl_id >", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dl_id >=", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdLessThan(Integer value) {
            addCriterion("dl_id <", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdLessThanOrEqualTo(Integer value) {
            addCriterion("dl_id <=", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdIn(List<Integer> values) {
            addCriterion("dl_id in", values, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdNotIn(List<Integer> values) {
            addCriterion("dl_id not in", values, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdBetween(Integer value1, Integer value2) {
            addCriterion("dl_id between", value1, value2, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dl_id not between", value1, value2, "dlId");
            return (Criteria) this;
        }

        public Criteria andXlIdIsNull() {
            addCriterion("xl_id is null");
            return (Criteria) this;
        }

        public Criteria andXlIdIsNotNull() {
            addCriterion("xl_id is not null");
            return (Criteria) this;
        }

        public Criteria andXlIdEqualTo(Integer value) {
            addCriterion("xl_id =", value, "xlId");
            return (Criteria) this;
        }

        public Criteria andXlIdNotEqualTo(Integer value) {
            addCriterion("xl_id <>", value, "xlId");
            return (Criteria) this;
        }

        public Criteria andXlIdGreaterThan(Integer value) {
            addCriterion("xl_id >", value, "xlId");
            return (Criteria) this;
        }

        public Criteria andXlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("xl_id >=", value, "xlId");
            return (Criteria) this;
        }

        public Criteria andXlIdLessThan(Integer value) {
            addCriterion("xl_id <", value, "xlId");
            return (Criteria) this;
        }

        public Criteria andXlIdLessThanOrEqualTo(Integer value) {
            addCriterion("xl_id <=", value, "xlId");
            return (Criteria) this;
        }

        public Criteria andXlIdIn(List<Integer> values) {
            addCriterion("xl_id in", values, "xlId");
            return (Criteria) this;
        }

        public Criteria andXlIdNotIn(List<Integer> values) {
            addCriterion("xl_id not in", values, "xlId");
            return (Criteria) this;
        }

        public Criteria andXlIdBetween(Integer value1, Integer value2) {
            addCriterion("xl_id between", value1, value2, "xlId");
            return (Criteria) this;
        }

        public Criteria andXlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("xl_id not between", value1, value2, "xlId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdIsNull() {
            addCriterion("qtlb_id is null");
            return (Criteria) this;
        }

        public Criteria andQtlbIdIsNotNull() {
            addCriterion("qtlb_id is not null");
            return (Criteria) this;
        }

        public Criteria andQtlbIdEqualTo(Integer value) {
            addCriterion("qtlb_id =", value, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdNotEqualTo(Integer value) {
            addCriterion("qtlb_id <>", value, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdGreaterThan(Integer value) {
            addCriterion("qtlb_id >", value, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("qtlb_id >=", value, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdLessThan(Integer value) {
            addCriterion("qtlb_id <", value, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdLessThanOrEqualTo(Integer value) {
            addCriterion("qtlb_id <=", value, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdIn(List<Integer> values) {
            addCriterion("qtlb_id in", values, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdNotIn(List<Integer> values) {
            addCriterion("qtlb_id not in", values, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdBetween(Integer value1, Integer value2) {
            addCriterion("qtlb_id between", value1, value2, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andQtlbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("qtlb_id not between", value1, value2, "qtlbId");
            return (Criteria) this;
        }

        public Criteria andPpIdIsNull() {
            addCriterion("pp_id is null");
            return (Criteria) this;
        }

        public Criteria andPpIdIsNotNull() {
            addCriterion("pp_id is not null");
            return (Criteria) this;
        }

        public Criteria andPpIdEqualTo(Integer value) {
            addCriterion("pp_id =", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotEqualTo(Integer value) {
            addCriterion("pp_id <>", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThan(Integer value) {
            addCriterion("pp_id >", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_id >=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThan(Integer value) {
            addCriterion("pp_id <", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThanOrEqualTo(Integer value) {
            addCriterion("pp_id <=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdIn(List<Integer> values) {
            addCriterion("pp_id in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotIn(List<Integer> values) {
            addCriterion("pp_id not in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdBetween(Integer value1, Integer value2) {
            addCriterion("pp_id between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_id not between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andLyxtIsNull() {
            addCriterion("lyxt is null");
            return (Criteria) this;
        }

        public Criteria andLyxtIsNotNull() {
            addCriterion("lyxt is not null");
            return (Criteria) this;
        }

        public Criteria andLyxtEqualTo(Byte value) {
            addCriterion("lyxt =", value, "lyxt");
            return (Criteria) this;
        }

        public Criteria andLyxtNotEqualTo(Byte value) {
            addCriterion("lyxt <>", value, "lyxt");
            return (Criteria) this;
        }

        public Criteria andLyxtGreaterThan(Byte value) {
            addCriterion("lyxt >", value, "lyxt");
            return (Criteria) this;
        }

        public Criteria andLyxtGreaterThanOrEqualTo(Byte value) {
            addCriterion("lyxt >=", value, "lyxt");
            return (Criteria) this;
        }

        public Criteria andLyxtLessThan(Byte value) {
            addCriterion("lyxt <", value, "lyxt");
            return (Criteria) this;
        }

        public Criteria andLyxtLessThanOrEqualTo(Byte value) {
            addCriterion("lyxt <=", value, "lyxt");
            return (Criteria) this;
        }

        public Criteria andLyxtIn(List<Byte> values) {
            addCriterion("lyxt in", values, "lyxt");
            return (Criteria) this;
        }

        public Criteria andLyxtNotIn(List<Byte> values) {
            addCriterion("lyxt not in", values, "lyxt");
            return (Criteria) this;
        }

        public Criteria andLyxtBetween(Byte value1, Byte value2) {
            addCriterion("lyxt between", value1, value2, "lyxt");
            return (Criteria) this;
        }

        public Criteria andLyxtNotBetween(Byte value1, Byte value2) {
            addCriterion("lyxt not between", value1, value2, "lyxt");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }
    }

    /**
     */
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