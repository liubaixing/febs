package com.febs.purchase.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseCgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchaseCgExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDjbhIsNull() {
            addCriterion("djbh is null");
            return (Criteria) this;
        }

        public Criteria andDjbhIsNotNull() {
            addCriterion("djbh is not null");
            return (Criteria) this;
        }

        public Criteria andDjbhEqualTo(String value) {
            addCriterion("djbh =", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhNotEqualTo(String value) {
            addCriterion("djbh <>", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhGreaterThan(String value) {
            addCriterion("djbh >", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhGreaterThanOrEqualTo(String value) {
            addCriterion("djbh >=", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhLessThan(String value) {
            addCriterion("djbh <", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhLessThanOrEqualTo(String value) {
            addCriterion("djbh <=", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhLike(String value) {
            addCriterion("djbh like", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhNotLike(String value) {
            addCriterion("djbh not like", value, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhIn(List<String> values) {
            addCriterion("djbh in", values, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhNotIn(List<String> values) {
            addCriterion("djbh not in", values, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhBetween(String value1, String value2) {
            addCriterion("djbh between", value1, value2, "djbh");
            return (Criteria) this;
        }

        public Criteria andDjbhNotBetween(String value1, String value2) {
            addCriterion("djbh not between", value1, value2, "djbh");
            return (Criteria) this;
        }

        public Criteria andXdrqIsNull() {
            addCriterion("xdrq is null");
            return (Criteria) this;
        }

        public Criteria andXdrqIsNotNull() {
            addCriterion("xdrq is not null");
            return (Criteria) this;
        }

        public Criteria andXdrqEqualTo(Date value) {
            addCriterion("xdrq =", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqNotEqualTo(Date value) {
            addCriterion("xdrq <>", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqGreaterThan(Date value) {
            addCriterion("xdrq >", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqGreaterThanOrEqualTo(Date value) {
            addCriterion("xdrq >=", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqLessThan(Date value) {
            addCriterion("xdrq <", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqLessThanOrEqualTo(Date value) {
            addCriterion("xdrq <=", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqIn(List<Date> values) {
            addCriterion("xdrq in", values, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqNotIn(List<Date> values) {
            addCriterion("xdrq not in", values, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqBetween(Date value1, Date value2) {
            addCriterion("xdrq between", value1, value2, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqNotBetween(Date value1, Date value2) {
            addCriterion("xdrq not between", value1, value2, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXsdhIsNull() {
            addCriterion("xsdh is null");
            return (Criteria) this;
        }

        public Criteria andXsdhIsNotNull() {
            addCriterion("xsdh is not null");
            return (Criteria) this;
        }

        public Criteria andXsdhEqualTo(String value) {
            addCriterion("xsdh =", value, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhNotEqualTo(String value) {
            addCriterion("xsdh <>", value, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhGreaterThan(String value) {
            addCriterion("xsdh >", value, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhGreaterThanOrEqualTo(String value) {
            addCriterion("xsdh >=", value, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhLessThan(String value) {
            addCriterion("xsdh <", value, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhLessThanOrEqualTo(String value) {
            addCriterion("xsdh <=", value, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhLike(String value) {
            addCriterion("xsdh like", value, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhNotLike(String value) {
            addCriterion("xsdh not like", value, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhIn(List<String> values) {
            addCriterion("xsdh in", values, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhNotIn(List<String> values) {
            addCriterion("xsdh not in", values, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhBetween(String value1, String value2) {
            addCriterion("xsdh between", value1, value2, "xsdh");
            return (Criteria) this;
        }

        public Criteria andXsdhNotBetween(String value1, String value2) {
            addCriterion("xsdh not between", value1, value2, "xsdh");
            return (Criteria) this;
        }

        public Criteria andYdjhIsNull() {
            addCriterion("ydjh is null");
            return (Criteria) this;
        }

        public Criteria andYdjhIsNotNull() {
            addCriterion("ydjh is not null");
            return (Criteria) this;
        }

        public Criteria andYdjhEqualTo(String value) {
            addCriterion("ydjh =", value, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhNotEqualTo(String value) {
            addCriterion("ydjh <>", value, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhGreaterThan(String value) {
            addCriterion("ydjh >", value, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhGreaterThanOrEqualTo(String value) {
            addCriterion("ydjh >=", value, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhLessThan(String value) {
            addCriterion("ydjh <", value, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhLessThanOrEqualTo(String value) {
            addCriterion("ydjh <=", value, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhLike(String value) {
            addCriterion("ydjh like", value, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhNotLike(String value) {
            addCriterion("ydjh not like", value, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhIn(List<String> values) {
            addCriterion("ydjh in", values, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhNotIn(List<String> values) {
            addCriterion("ydjh not in", values, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhBetween(String value1, String value2) {
            addCriterion("ydjh between", value1, value2, "ydjh");
            return (Criteria) this;
        }

        public Criteria andYdjhNotBetween(String value1, String value2) {
            addCriterion("ydjh not between", value1, value2, "ydjh");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andBmIdIsNull() {
            addCriterion("bm_id is null");
            return (Criteria) this;
        }

        public Criteria andBmIdIsNotNull() {
            addCriterion("bm_id is not null");
            return (Criteria) this;
        }

        public Criteria andBmIdEqualTo(Integer value) {
            addCriterion("bm_id =", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdNotEqualTo(Integer value) {
            addCriterion("bm_id <>", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdGreaterThan(Integer value) {
            addCriterion("bm_id >", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bm_id >=", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdLessThan(Integer value) {
            addCriterion("bm_id <", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdLessThanOrEqualTo(Integer value) {
            addCriterion("bm_id <=", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdIn(List<Integer> values) {
            addCriterion("bm_id in", values, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdNotIn(List<Integer> values) {
            addCriterion("bm_id not in", values, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdBetween(Integer value1, Integer value2) {
            addCriterion("bm_id between", value1, value2, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bm_id not between", value1, value2, "bmId");
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

        public Criteria andCangkuIdIsNull() {
            addCriterion("cangku_id is null");
            return (Criteria) this;
        }

        public Criteria andCangkuIdIsNotNull() {
            addCriterion("cangku_id is not null");
            return (Criteria) this;
        }

        public Criteria andCangkuIdEqualTo(Integer value) {
            addCriterion("cangku_id =", value, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andCangkuIdNotEqualTo(Integer value) {
            addCriterion("cangku_id <>", value, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andCangkuIdGreaterThan(Integer value) {
            addCriterion("cangku_id >", value, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andCangkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cangku_id >=", value, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andCangkuIdLessThan(Integer value) {
            addCriterion("cangku_id <", value, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andCangkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("cangku_id <=", value, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andCangkuIdIn(List<Integer> values) {
            addCriterion("cangku_id in", values, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andCangkuIdNotIn(List<Integer> values) {
            addCriterion("cangku_id not in", values, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andCangkuIdBetween(Integer value1, Integer value2) {
            addCriterion("cangku_id between", value1, value2, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andCangkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cangku_id not between", value1, value2, "cangkuId");
            return (Criteria) this;
        }

        public Criteria andFpslIdIsNull() {
            addCriterion("fpsl_id is null");
            return (Criteria) this;
        }

        public Criteria andFpslIdIsNotNull() {
            addCriterion("fpsl_id is not null");
            return (Criteria) this;
        }

        public Criteria andFpslIdEqualTo(Integer value) {
            addCriterion("fpsl_id =", value, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFpslIdNotEqualTo(Integer value) {
            addCriterion("fpsl_id <>", value, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFpslIdGreaterThan(Integer value) {
            addCriterion("fpsl_id >", value, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFpslIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fpsl_id >=", value, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFpslIdLessThan(Integer value) {
            addCriterion("fpsl_id <", value, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFpslIdLessThanOrEqualTo(Integer value) {
            addCriterion("fpsl_id <=", value, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFpslIdIn(List<Integer> values) {
            addCriterion("fpsl_id in", values, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFpslIdNotIn(List<Integer> values) {
            addCriterion("fpsl_id not in", values, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFpslIdBetween(Integer value1, Integer value2) {
            addCriterion("fpsl_id between", value1, value2, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFpslIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fpsl_id not between", value1, value2, "fpslId");
            return (Criteria) this;
        }

        public Criteria andFplxIdIsNull() {
            addCriterion("fplx_id is null");
            return (Criteria) this;
        }

        public Criteria andFplxIdIsNotNull() {
            addCriterion("fplx_id is not null");
            return (Criteria) this;
        }

        public Criteria andFplxIdEqualTo(Integer value) {
            addCriterion("fplx_id =", value, "fplxId");
            return (Criteria) this;
        }

        public Criteria andFplxIdNotEqualTo(Integer value) {
            addCriterion("fplx_id <>", value, "fplxId");
            return (Criteria) this;
        }

        public Criteria andFplxIdGreaterThan(Integer value) {
            addCriterion("fplx_id >", value, "fplxId");
            return (Criteria) this;
        }

        public Criteria andFplxIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fplx_id >=", value, "fplxId");
            return (Criteria) this;
        }

        public Criteria andFplxIdLessThan(Integer value) {
            addCriterion("fplx_id <", value, "fplxId");
            return (Criteria) this;
        }

        public Criteria andFplxIdLessThanOrEqualTo(Integer value) {
            addCriterion("fplx_id <=", value, "fplxId");
            return (Criteria) this;
        }

        public Criteria andFplxIdIn(List<Integer> values) {
            addCriterion("fplx_id in", values, "fplxId");
            return (Criteria) this;
        }

        public Criteria andFplxIdNotIn(List<Integer> values) {
            addCriterion("fplx_id not in", values, "fplxId");
            return (Criteria) this;
        }

        public Criteria andFplxIdBetween(Integer value1, Integer value2) {
            addCriterion("fplx_id between", value1, value2, "fplxId");
            return (Criteria) this;
        }

        public Criteria andFplxIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fplx_id not between", value1, value2, "fplxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdIsNull() {
            addCriterion("djlx_id is null");
            return (Criteria) this;
        }

        public Criteria andDjlxIdIsNotNull() {
            addCriterion("djlx_id is not null");
            return (Criteria) this;
        }

        public Criteria andDjlxIdEqualTo(Integer value) {
            addCriterion("djlx_id =", value, "djlxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdNotEqualTo(Integer value) {
            addCriterion("djlx_id <>", value, "djlxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdGreaterThan(Integer value) {
            addCriterion("djlx_id >", value, "djlxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("djlx_id >=", value, "djlxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdLessThan(Integer value) {
            addCriterion("djlx_id <", value, "djlxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdLessThanOrEqualTo(Integer value) {
            addCriterion("djlx_id <=", value, "djlxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdIn(List<Integer> values) {
            addCriterion("djlx_id in", values, "djlxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdNotIn(List<Integer> values) {
            addCriterion("djlx_id not in", values, "djlxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdBetween(Integer value1, Integer value2) {
            addCriterion("djlx_id between", value1, value2, "djlxId");
            return (Criteria) this;
        }

        public Criteria andDjlxIdNotBetween(Integer value1, Integer value2) {
            addCriterion("djlx_id not between", value1, value2, "djlxId");
            return (Criteria) this;
        }

        public Criteria andCgfzrIsNull() {
            addCriterion("cgfzr is null");
            return (Criteria) this;
        }

        public Criteria andCgfzrIsNotNull() {
            addCriterion("cgfzr is not null");
            return (Criteria) this;
        }

        public Criteria andCgfzrEqualTo(Integer value) {
            addCriterion("cgfzr =", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrNotEqualTo(Integer value) {
            addCriterion("cgfzr <>", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrGreaterThan(Integer value) {
            addCriterion("cgfzr >", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrGreaterThanOrEqualTo(Integer value) {
            addCriterion("cgfzr >=", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrLessThan(Integer value) {
            addCriterion("cgfzr <", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrLessThanOrEqualTo(Integer value) {
            addCriterion("cgfzr <=", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrIn(List<Integer> values) {
            addCriterion("cgfzr in", values, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrNotIn(List<Integer> values) {
            addCriterion("cgfzr not in", values, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrBetween(Integer value1, Integer value2) {
            addCriterion("cgfzr between", value1, value2, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrNotBetween(Integer value1, Integer value2) {
            addCriterion("cgfzr not between", value1, value2, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrIsNull() {
            addCriterion("xdfzr is null");
            return (Criteria) this;
        }

        public Criteria andXdfzrIsNotNull() {
            addCriterion("xdfzr is not null");
            return (Criteria) this;
        }

        public Criteria andXdfzrEqualTo(Integer value) {
            addCriterion("xdfzr =", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrNotEqualTo(Integer value) {
            addCriterion("xdfzr <>", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrGreaterThan(Integer value) {
            addCriterion("xdfzr >", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrGreaterThanOrEqualTo(Integer value) {
            addCriterion("xdfzr >=", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrLessThan(Integer value) {
            addCriterion("xdfzr <", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrLessThanOrEqualTo(Integer value) {
            addCriterion("xdfzr <=", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrIn(List<Integer> values) {
            addCriterion("xdfzr in", values, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrNotIn(List<Integer> values) {
            addCriterion("xdfzr not in", values, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrBetween(Integer value1, Integer value2) {
            addCriterion("xdfzr between", value1, value2, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrNotBetween(Integer value1, Integer value2) {
            addCriterion("xdfzr not between", value1, value2, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andSfjjIsNull() {
            addCriterion("sfjj is null");
            return (Criteria) this;
        }

        public Criteria andSfjjIsNotNull() {
            addCriterion("sfjj is not null");
            return (Criteria) this;
        }

        public Criteria andSfjjEqualTo(Byte value) {
            addCriterion("sfjj =", value, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfjjNotEqualTo(Byte value) {
            addCriterion("sfjj <>", value, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfjjGreaterThan(Byte value) {
            addCriterion("sfjj >", value, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfjjGreaterThanOrEqualTo(Byte value) {
            addCriterion("sfjj >=", value, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfjjLessThan(Byte value) {
            addCriterion("sfjj <", value, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfjjLessThanOrEqualTo(Byte value) {
            addCriterion("sfjj <=", value, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfjjIn(List<Byte> values) {
            addCriterion("sfjj in", values, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfjjNotIn(List<Byte> values) {
            addCriterion("sfjj not in", values, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfjjBetween(Byte value1, Byte value2) {
            addCriterion("sfjj between", value1, value2, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfjjNotBetween(Byte value1, Byte value2) {
            addCriterion("sfjj not between", value1, value2, "sfjj");
            return (Criteria) this;
        }

        public Criteria andSfdzIsNull() {
            addCriterion("sfdz is null");
            return (Criteria) this;
        }

        public Criteria andSfdzIsNotNull() {
            addCriterion("sfdz is not null");
            return (Criteria) this;
        }

        public Criteria andSfdzEqualTo(Byte value) {
            addCriterion("sfdz =", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzNotEqualTo(Byte value) {
            addCriterion("sfdz <>", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzGreaterThan(Byte value) {
            addCriterion("sfdz >", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzGreaterThanOrEqualTo(Byte value) {
            addCriterion("sfdz >=", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzLessThan(Byte value) {
            addCriterion("sfdz <", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzLessThanOrEqualTo(Byte value) {
            addCriterion("sfdz <=", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzIn(List<Byte> values) {
            addCriterion("sfdz in", values, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzNotIn(List<Byte> values) {
            addCriterion("sfdz not in", values, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzBetween(Byte value1, Byte value2) {
            addCriterion("sfdz between", value1, value2, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzNotBetween(Byte value1, Byte value2) {
            addCriterion("sfdz not between", value1, value2, "sfdz");
            return (Criteria) this;
        }

        public Criteria andWldhIsNull() {
            addCriterion("wldh is null");
            return (Criteria) this;
        }

        public Criteria andWldhIsNotNull() {
            addCriterion("wldh is not null");
            return (Criteria) this;
        }

        public Criteria andWldhEqualTo(String value) {
            addCriterion("wldh =", value, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhNotEqualTo(String value) {
            addCriterion("wldh <>", value, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhGreaterThan(String value) {
            addCriterion("wldh >", value, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhGreaterThanOrEqualTo(String value) {
            addCriterion("wldh >=", value, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhLessThan(String value) {
            addCriterion("wldh <", value, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhLessThanOrEqualTo(String value) {
            addCriterion("wldh <=", value, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhLike(String value) {
            addCriterion("wldh like", value, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhNotLike(String value) {
            addCriterion("wldh not like", value, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhIn(List<String> values) {
            addCriterion("wldh in", values, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhNotIn(List<String> values) {
            addCriterion("wldh not in", values, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhBetween(String value1, String value2) {
            addCriterion("wldh between", value1, value2, "wldh");
            return (Criteria) this;
        }

        public Criteria andWldhNotBetween(String value1, String value2) {
            addCriterion("wldh not between", value1, value2, "wldh");
            return (Criteria) this;
        }

        public Criteria andYqdhrqIsNull() {
            addCriterion("yqdhrq is null");
            return (Criteria) this;
        }

        public Criteria andYqdhrqIsNotNull() {
            addCriterion("yqdhrq is not null");
            return (Criteria) this;
        }

        public Criteria andYqdhrqEqualTo(Date value) {
            addCriterion("yqdhrq =", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqNotEqualTo(Date value) {
            addCriterion("yqdhrq <>", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqGreaterThan(Date value) {
            addCriterion("yqdhrq >", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqGreaterThanOrEqualTo(Date value) {
            addCriterion("yqdhrq >=", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqLessThan(Date value) {
            addCriterion("yqdhrq <", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqLessThanOrEqualTo(Date value) {
            addCriterion("yqdhrq <=", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqIn(List<Date> values) {
            addCriterion("yqdhrq in", values, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqNotIn(List<Date> values) {
            addCriterion("yqdhrq not in", values, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqBetween(Date value1, Date value2) {
            addCriterion("yqdhrq between", value1, value2, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqNotBetween(Date value1, Date value2) {
            addCriterion("yqdhrq not between", value1, value2, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andSlIsNull() {
            addCriterion("sl is null");
            return (Criteria) this;
        }

        public Criteria andSlIsNotNull() {
            addCriterion("sl is not null");
            return (Criteria) this;
        }

        public Criteria andSlEqualTo(Integer value) {
            addCriterion("sl =", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotEqualTo(Integer value) {
            addCriterion("sl <>", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThan(Integer value) {
            addCriterion("sl >", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThanOrEqualTo(Integer value) {
            addCriterion("sl >=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThan(Integer value) {
            addCriterion("sl <", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThanOrEqualTo(Integer value) {
            addCriterion("sl <=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlIn(List<Integer> values) {
            addCriterion("sl in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotIn(List<Integer> values) {
            addCriterion("sl not in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlBetween(Integer value1, Integer value2) {
            addCriterion("sl between", value1, value2, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotBetween(Integer value1, Integer value2) {
            addCriterion("sl not between", value1, value2, "sl");
            return (Criteria) this;
        }

        public Criteria andKpslIsNull() {
            addCriterion("kpsl is null");
            return (Criteria) this;
        }

        public Criteria andKpslIsNotNull() {
            addCriterion("kpsl is not null");
            return (Criteria) this;
        }

        public Criteria andKpslEqualTo(Integer value) {
            addCriterion("kpsl =", value, "kpsl");
            return (Criteria) this;
        }

        public Criteria andKpslNotEqualTo(Integer value) {
            addCriterion("kpsl <>", value, "kpsl");
            return (Criteria) this;
        }

        public Criteria andKpslGreaterThan(Integer value) {
            addCriterion("kpsl >", value, "kpsl");
            return (Criteria) this;
        }

        public Criteria andKpslGreaterThanOrEqualTo(Integer value) {
            addCriterion("kpsl >=", value, "kpsl");
            return (Criteria) this;
        }

        public Criteria andKpslLessThan(Integer value) {
            addCriterion("kpsl <", value, "kpsl");
            return (Criteria) this;
        }

        public Criteria andKpslLessThanOrEqualTo(Integer value) {
            addCriterion("kpsl <=", value, "kpsl");
            return (Criteria) this;
        }

        public Criteria andKpslIn(List<Integer> values) {
            addCriterion("kpsl in", values, "kpsl");
            return (Criteria) this;
        }

        public Criteria andKpslNotIn(List<Integer> values) {
            addCriterion("kpsl not in", values, "kpsl");
            return (Criteria) this;
        }

        public Criteria andKpslBetween(Integer value1, Integer value2) {
            addCriterion("kpsl between", value1, value2, "kpsl");
            return (Criteria) this;
        }

        public Criteria andKpslNotBetween(Integer value1, Integer value2) {
            addCriterion("kpsl not between", value1, value2, "kpsl");
            return (Criteria) this;
        }

        public Criteria andFkslIsNull() {
            addCriterion("fksl is null");
            return (Criteria) this;
        }

        public Criteria andFkslIsNotNull() {
            addCriterion("fksl is not null");
            return (Criteria) this;
        }

        public Criteria andFkslEqualTo(Integer value) {
            addCriterion("fksl =", value, "fksl");
            return (Criteria) this;
        }

        public Criteria andFkslNotEqualTo(Integer value) {
            addCriterion("fksl <>", value, "fksl");
            return (Criteria) this;
        }

        public Criteria andFkslGreaterThan(Integer value) {
            addCriterion("fksl >", value, "fksl");
            return (Criteria) this;
        }

        public Criteria andFkslGreaterThanOrEqualTo(Integer value) {
            addCriterion("fksl >=", value, "fksl");
            return (Criteria) this;
        }

        public Criteria andFkslLessThan(Integer value) {
            addCriterion("fksl <", value, "fksl");
            return (Criteria) this;
        }

        public Criteria andFkslLessThanOrEqualTo(Integer value) {
            addCriterion("fksl <=", value, "fksl");
            return (Criteria) this;
        }

        public Criteria andFkslIn(List<Integer> values) {
            addCriterion("fksl in", values, "fksl");
            return (Criteria) this;
        }

        public Criteria andFkslNotIn(List<Integer> values) {
            addCriterion("fksl not in", values, "fksl");
            return (Criteria) this;
        }

        public Criteria andFkslBetween(Integer value1, Integer value2) {
            addCriterion("fksl between", value1, value2, "fksl");
            return (Criteria) this;
        }

        public Criteria andFkslNotBetween(Integer value1, Integer value2) {
            addCriterion("fksl not between", value1, value2, "fksl");
            return (Criteria) this;
        }

        public Criteria andTkslIsNull() {
            addCriterion("tksl is null");
            return (Criteria) this;
        }

        public Criteria andTkslIsNotNull() {
            addCriterion("tksl is not null");
            return (Criteria) this;
        }

        public Criteria andTkslEqualTo(Integer value) {
            addCriterion("tksl =", value, "tksl");
            return (Criteria) this;
        }

        public Criteria andTkslNotEqualTo(Integer value) {
            addCriterion("tksl <>", value, "tksl");
            return (Criteria) this;
        }

        public Criteria andTkslGreaterThan(Integer value) {
            addCriterion("tksl >", value, "tksl");
            return (Criteria) this;
        }

        public Criteria andTkslGreaterThanOrEqualTo(Integer value) {
            addCriterion("tksl >=", value, "tksl");
            return (Criteria) this;
        }

        public Criteria andTkslLessThan(Integer value) {
            addCriterion("tksl <", value, "tksl");
            return (Criteria) this;
        }

        public Criteria andTkslLessThanOrEqualTo(Integer value) {
            addCriterion("tksl <=", value, "tksl");
            return (Criteria) this;
        }

        public Criteria andTkslIn(List<Integer> values) {
            addCriterion("tksl in", values, "tksl");
            return (Criteria) this;
        }

        public Criteria andTkslNotIn(List<Integer> values) {
            addCriterion("tksl not in", values, "tksl");
            return (Criteria) this;
        }

        public Criteria andTkslBetween(Integer value1, Integer value2) {
            addCriterion("tksl between", value1, value2, "tksl");
            return (Criteria) this;
        }

        public Criteria andTkslNotBetween(Integer value1, Integer value2) {
            addCriterion("tksl not between", value1, value2, "tksl");
            return (Criteria) this;
        }

        public Criteria andJeIsNull() {
            addCriterion("je is null");
            return (Criteria) this;
        }

        public Criteria andJeIsNotNull() {
            addCriterion("je is not null");
            return (Criteria) this;
        }

        public Criteria andJeEqualTo(BigDecimal value) {
            addCriterion("je =", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeNotEqualTo(BigDecimal value) {
            addCriterion("je <>", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeGreaterThan(BigDecimal value) {
            addCriterion("je >", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("je >=", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeLessThan(BigDecimal value) {
            addCriterion("je <", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("je <=", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeIn(List<BigDecimal> values) {
            addCriterion("je in", values, "je");
            return (Criteria) this;
        }

        public Criteria andJeNotIn(List<BigDecimal> values) {
            addCriterion("je not in", values, "je");
            return (Criteria) this;
        }

        public Criteria andJeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("je between", value1, value2, "je");
            return (Criteria) this;
        }

        public Criteria andJeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("je not between", value1, value2, "je");
            return (Criteria) this;
        }

        public Criteria andKpjeIsNull() {
            addCriterion("kpje is null");
            return (Criteria) this;
        }

        public Criteria andKpjeIsNotNull() {
            addCriterion("kpje is not null");
            return (Criteria) this;
        }

        public Criteria andKpjeEqualTo(BigDecimal value) {
            addCriterion("kpje =", value, "kpje");
            return (Criteria) this;
        }

        public Criteria andKpjeNotEqualTo(BigDecimal value) {
            addCriterion("kpje <>", value, "kpje");
            return (Criteria) this;
        }

        public Criteria andKpjeGreaterThan(BigDecimal value) {
            addCriterion("kpje >", value, "kpje");
            return (Criteria) this;
        }

        public Criteria andKpjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kpje >=", value, "kpje");
            return (Criteria) this;
        }

        public Criteria andKpjeLessThan(BigDecimal value) {
            addCriterion("kpje <", value, "kpje");
            return (Criteria) this;
        }

        public Criteria andKpjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kpje <=", value, "kpje");
            return (Criteria) this;
        }

        public Criteria andKpjeIn(List<BigDecimal> values) {
            addCriterion("kpje in", values, "kpje");
            return (Criteria) this;
        }

        public Criteria andKpjeNotIn(List<BigDecimal> values) {
            addCriterion("kpje not in", values, "kpje");
            return (Criteria) this;
        }

        public Criteria andKpjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kpje between", value1, value2, "kpje");
            return (Criteria) this;
        }

        public Criteria andKpjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kpje not between", value1, value2, "kpje");
            return (Criteria) this;
        }

        public Criteria andFkjeIsNull() {
            addCriterion("fkje is null");
            return (Criteria) this;
        }

        public Criteria andFkjeIsNotNull() {
            addCriterion("fkje is not null");
            return (Criteria) this;
        }

        public Criteria andFkjeEqualTo(BigDecimal value) {
            addCriterion("fkje =", value, "fkje");
            return (Criteria) this;
        }

        public Criteria andFkjeNotEqualTo(BigDecimal value) {
            addCriterion("fkje <>", value, "fkje");
            return (Criteria) this;
        }

        public Criteria andFkjeGreaterThan(BigDecimal value) {
            addCriterion("fkje >", value, "fkje");
            return (Criteria) this;
        }

        public Criteria andFkjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fkje >=", value, "fkje");
            return (Criteria) this;
        }

        public Criteria andFkjeLessThan(BigDecimal value) {
            addCriterion("fkje <", value, "fkje");
            return (Criteria) this;
        }

        public Criteria andFkjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fkje <=", value, "fkje");
            return (Criteria) this;
        }

        public Criteria andFkjeIn(List<BigDecimal> values) {
            addCriterion("fkje in", values, "fkje");
            return (Criteria) this;
        }

        public Criteria andFkjeNotIn(List<BigDecimal> values) {
            addCriterion("fkje not in", values, "fkje");
            return (Criteria) this;
        }

        public Criteria andFkjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fkje between", value1, value2, "fkje");
            return (Criteria) this;
        }

        public Criteria andFkjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fkje not between", value1, value2, "fkje");
            return (Criteria) this;
        }

        public Criteria andTkjeIsNull() {
            addCriterion("tkje is null");
            return (Criteria) this;
        }

        public Criteria andTkjeIsNotNull() {
            addCriterion("tkje is not null");
            return (Criteria) this;
        }

        public Criteria andTkjeEqualTo(BigDecimal value) {
            addCriterion("tkje =", value, "tkje");
            return (Criteria) this;
        }

        public Criteria andTkjeNotEqualTo(BigDecimal value) {
            addCriterion("tkje <>", value, "tkje");
            return (Criteria) this;
        }

        public Criteria andTkjeGreaterThan(BigDecimal value) {
            addCriterion("tkje >", value, "tkje");
            return (Criteria) this;
        }

        public Criteria andTkjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tkje >=", value, "tkje");
            return (Criteria) this;
        }

        public Criteria andTkjeLessThan(BigDecimal value) {
            addCriterion("tkje <", value, "tkje");
            return (Criteria) this;
        }

        public Criteria andTkjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tkje <=", value, "tkje");
            return (Criteria) this;
        }

        public Criteria andTkjeIn(List<BigDecimal> values) {
            addCriterion("tkje in", values, "tkje");
            return (Criteria) this;
        }

        public Criteria andTkjeNotIn(List<BigDecimal> values) {
            addCriterion("tkje not in", values, "tkje");
            return (Criteria) this;
        }

        public Criteria andTkjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tkje between", value1, value2, "tkje");
            return (Criteria) this;
        }

        public Criteria andTkjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tkje not between", value1, value2, "tkje");
            return (Criteria) this;
        }

        public Criteria andFjIsNull() {
            addCriterion("fj is null");
            return (Criteria) this;
        }

        public Criteria andFjIsNotNull() {
            addCriterion("fj is not null");
            return (Criteria) this;
        }

        public Criteria andFjEqualTo(String value) {
            addCriterion("fj =", value, "fj");
            return (Criteria) this;
        }

        public Criteria andFjNotEqualTo(String value) {
            addCriterion("fj <>", value, "fj");
            return (Criteria) this;
        }

        public Criteria andFjGreaterThan(String value) {
            addCriterion("fj >", value, "fj");
            return (Criteria) this;
        }

        public Criteria andFjGreaterThanOrEqualTo(String value) {
            addCriterion("fj >=", value, "fj");
            return (Criteria) this;
        }

        public Criteria andFjLessThan(String value) {
            addCriterion("fj <", value, "fj");
            return (Criteria) this;
        }

        public Criteria andFjLessThanOrEqualTo(String value) {
            addCriterion("fj <=", value, "fj");
            return (Criteria) this;
        }

        public Criteria andFjLike(String value) {
            addCriterion("fj like", value, "fj");
            return (Criteria) this;
        }

        public Criteria andFjNotLike(String value) {
            addCriterion("fj not like", value, "fj");
            return (Criteria) this;
        }

        public Criteria andFjIn(List<String> values) {
            addCriterion("fj in", values, "fj");
            return (Criteria) this;
        }

        public Criteria andFjNotIn(List<String> values) {
            addCriterion("fj not in", values, "fj");
            return (Criteria) this;
        }

        public Criteria andFjBetween(String value1, String value2) {
            addCriterion("fj between", value1, value2, "fj");
            return (Criteria) this;
        }

        public Criteria andFjNotBetween(String value1, String value2) {
            addCriterion("fj not between", value1, value2, "fj");
            return (Criteria) this;
        }

        public Criteria andZdrIsNull() {
            addCriterion("zdr is null");
            return (Criteria) this;
        }

        public Criteria andZdrIsNotNull() {
            addCriterion("zdr is not null");
            return (Criteria) this;
        }

        public Criteria andZdrEqualTo(String value) {
            addCriterion("zdr =", value, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrNotEqualTo(String value) {
            addCriterion("zdr <>", value, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrGreaterThan(String value) {
            addCriterion("zdr >", value, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrGreaterThanOrEqualTo(String value) {
            addCriterion("zdr >=", value, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrLessThan(String value) {
            addCriterion("zdr <", value, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrLessThanOrEqualTo(String value) {
            addCriterion("zdr <=", value, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrLike(String value) {
            addCriterion("zdr like", value, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrNotLike(String value) {
            addCriterion("zdr not like", value, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrIn(List<String> values) {
            addCriterion("zdr in", values, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrNotIn(List<String> values) {
            addCriterion("zdr not in", values, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrBetween(String value1, String value2) {
            addCriterion("zdr between", value1, value2, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrNotBetween(String value1, String value2) {
            addCriterion("zdr not between", value1, value2, "zdr");
            return (Criteria) this;
        }

        public Criteria andZdrqIsNull() {
            addCriterion("zdrq is null");
            return (Criteria) this;
        }

        public Criteria andZdrqIsNotNull() {
            addCriterion("zdrq is not null");
            return (Criteria) this;
        }

        public Criteria andZdrqEqualTo(Date value) {
            addCriterion("zdrq =", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqNotEqualTo(Date value) {
            addCriterion("zdrq <>", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqGreaterThan(Date value) {
            addCriterion("zdrq >", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqGreaterThanOrEqualTo(Date value) {
            addCriterion("zdrq >=", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqLessThan(Date value) {
            addCriterion("zdrq <", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqLessThanOrEqualTo(Date value) {
            addCriterion("zdrq <=", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqIn(List<Date> values) {
            addCriterion("zdrq in", values, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqNotIn(List<Date> values) {
            addCriterion("zdrq not in", values, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqBetween(Date value1, Date value2) {
            addCriterion("zdrq between", value1, value2, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqNotBetween(Date value1, Date value2) {
            addCriterion("zdrq not between", value1, value2, "zdrq");
            return (Criteria) this;
        }

        public Criteria andQrIsNull() {
            addCriterion("qr is null");
            return (Criteria) this;
        }

        public Criteria andQrIsNotNull() {
            addCriterion("qr is not null");
            return (Criteria) this;
        }

        public Criteria andQrEqualTo(Byte value) {
            addCriterion("qr =", value, "qr");
            return (Criteria) this;
        }

        public Criteria andQrNotEqualTo(Byte value) {
            addCriterion("qr <>", value, "qr");
            return (Criteria) this;
        }

        public Criteria andQrGreaterThan(Byte value) {
            addCriterion("qr >", value, "qr");
            return (Criteria) this;
        }

        public Criteria andQrGreaterThanOrEqualTo(Byte value) {
            addCriterion("qr >=", value, "qr");
            return (Criteria) this;
        }

        public Criteria andQrLessThan(Byte value) {
            addCriterion("qr <", value, "qr");
            return (Criteria) this;
        }

        public Criteria andQrLessThanOrEqualTo(Byte value) {
            addCriterion("qr <=", value, "qr");
            return (Criteria) this;
        }

        public Criteria andQrIn(List<Byte> values) {
            addCriterion("qr in", values, "qr");
            return (Criteria) this;
        }

        public Criteria andQrNotIn(List<Byte> values) {
            addCriterion("qr not in", values, "qr");
            return (Criteria) this;
        }

        public Criteria andQrBetween(Byte value1, Byte value2) {
            addCriterion("qr between", value1, value2, "qr");
            return (Criteria) this;
        }

        public Criteria andQrNotBetween(Byte value1, Byte value2) {
            addCriterion("qr not between", value1, value2, "qr");
            return (Criteria) this;
        }

        public Criteria andQrrIsNull() {
            addCriterion("qrr is null");
            return (Criteria) this;
        }

        public Criteria andQrrIsNotNull() {
            addCriterion("qrr is not null");
            return (Criteria) this;
        }

        public Criteria andQrrEqualTo(String value) {
            addCriterion("qrr =", value, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrNotEqualTo(String value) {
            addCriterion("qrr <>", value, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrGreaterThan(String value) {
            addCriterion("qrr >", value, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrGreaterThanOrEqualTo(String value) {
            addCriterion("qrr >=", value, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrLessThan(String value) {
            addCriterion("qrr <", value, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrLessThanOrEqualTo(String value) {
            addCriterion("qrr <=", value, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrLike(String value) {
            addCriterion("qrr like", value, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrNotLike(String value) {
            addCriterion("qrr not like", value, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrIn(List<String> values) {
            addCriterion("qrr in", values, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrNotIn(List<String> values) {
            addCriterion("qrr not in", values, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrBetween(String value1, String value2) {
            addCriterion("qrr between", value1, value2, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrNotBetween(String value1, String value2) {
            addCriterion("qrr not between", value1, value2, "qrr");
            return (Criteria) this;
        }

        public Criteria andQrrqIsNull() {
            addCriterion("qrrq is null");
            return (Criteria) this;
        }

        public Criteria andQrrqIsNotNull() {
            addCriterion("qrrq is not null");
            return (Criteria) this;
        }

        public Criteria andQrrqEqualTo(Date value) {
            addCriterion("qrrq =", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqNotEqualTo(Date value) {
            addCriterion("qrrq <>", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqGreaterThan(Date value) {
            addCriterion("qrrq >", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqGreaterThanOrEqualTo(Date value) {
            addCriterion("qrrq >=", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqLessThan(Date value) {
            addCriterion("qrrq <", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqLessThanOrEqualTo(Date value) {
            addCriterion("qrrq <=", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqIn(List<Date> values) {
            addCriterion("qrrq in", values, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqNotIn(List<Date> values) {
            addCriterion("qrrq not in", values, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqBetween(Date value1, Date value2) {
            addCriterion("qrrq between", value1, value2, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqNotBetween(Date value1, Date value2) {
            addCriterion("qrrq not between", value1, value2, "qrrq");
            return (Criteria) this;
        }

        public Criteria andShIsNull() {
            addCriterion("sh is null");
            return (Criteria) this;
        }

        public Criteria andShIsNotNull() {
            addCriterion("sh is not null");
            return (Criteria) this;
        }

        public Criteria andShEqualTo(Byte value) {
            addCriterion("sh =", value, "sh");
            return (Criteria) this;
        }

        public Criteria andShNotEqualTo(Byte value) {
            addCriterion("sh <>", value, "sh");
            return (Criteria) this;
        }

        public Criteria andShGreaterThan(Byte value) {
            addCriterion("sh >", value, "sh");
            return (Criteria) this;
        }

        public Criteria andShGreaterThanOrEqualTo(Byte value) {
            addCriterion("sh >=", value, "sh");
            return (Criteria) this;
        }

        public Criteria andShLessThan(Byte value) {
            addCriterion("sh <", value, "sh");
            return (Criteria) this;
        }

        public Criteria andShLessThanOrEqualTo(Byte value) {
            addCriterion("sh <=", value, "sh");
            return (Criteria) this;
        }

        public Criteria andShIn(List<Byte> values) {
            addCriterion("sh in", values, "sh");
            return (Criteria) this;
        }

        public Criteria andShNotIn(List<Byte> values) {
            addCriterion("sh not in", values, "sh");
            return (Criteria) this;
        }

        public Criteria andShBetween(Byte value1, Byte value2) {
            addCriterion("sh between", value1, value2, "sh");
            return (Criteria) this;
        }

        public Criteria andShNotBetween(Byte value1, Byte value2) {
            addCriterion("sh not between", value1, value2, "sh");
            return (Criteria) this;
        }

        public Criteria andShrIsNull() {
            addCriterion("shr is null");
            return (Criteria) this;
        }

        public Criteria andShrIsNotNull() {
            addCriterion("shr is not null");
            return (Criteria) this;
        }

        public Criteria andShrEqualTo(String value) {
            addCriterion("shr =", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotEqualTo(String value) {
            addCriterion("shr <>", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrGreaterThan(String value) {
            addCriterion("shr >", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrGreaterThanOrEqualTo(String value) {
            addCriterion("shr >=", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrLessThan(String value) {
            addCriterion("shr <", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrLessThanOrEqualTo(String value) {
            addCriterion("shr <=", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrLike(String value) {
            addCriterion("shr like", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotLike(String value) {
            addCriterion("shr not like", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrIn(List<String> values) {
            addCriterion("shr in", values, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotIn(List<String> values) {
            addCriterion("shr not in", values, "shr");
            return (Criteria) this;
        }

        public Criteria andShrBetween(String value1, String value2) {
            addCriterion("shr between", value1, value2, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotBetween(String value1, String value2) {
            addCriterion("shr not between", value1, value2, "shr");
            return (Criteria) this;
        }

        public Criteria andShrqIsNull() {
            addCriterion("shrq is null");
            return (Criteria) this;
        }

        public Criteria andShrqIsNotNull() {
            addCriterion("shrq is not null");
            return (Criteria) this;
        }

        public Criteria andShrqEqualTo(Date value) {
            addCriterion("shrq =", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotEqualTo(Date value) {
            addCriterion("shrq <>", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqGreaterThan(Date value) {
            addCriterion("shrq >", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqGreaterThanOrEqualTo(Date value) {
            addCriterion("shrq >=", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqLessThan(Date value) {
            addCriterion("shrq <", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqLessThanOrEqualTo(Date value) {
            addCriterion("shrq <=", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqIn(List<Date> values) {
            addCriterion("shrq in", values, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotIn(List<Date> values) {
            addCriterion("shrq not in", values, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqBetween(Date value1, Date value2) {
            addCriterion("shrq between", value1, value2, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotBetween(Date value1, Date value2) {
            addCriterion("shrq not between", value1, value2, "shrq");
            return (Criteria) this;
        }

        public Criteria andEcshIsNull() {
            addCriterion("ecsh is null");
            return (Criteria) this;
        }

        public Criteria andEcshIsNotNull() {
            addCriterion("ecsh is not null");
            return (Criteria) this;
        }

        public Criteria andEcshEqualTo(Byte value) {
            addCriterion("ecsh =", value, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshNotEqualTo(Byte value) {
            addCriterion("ecsh <>", value, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshGreaterThan(Byte value) {
            addCriterion("ecsh >", value, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshGreaterThanOrEqualTo(Byte value) {
            addCriterion("ecsh >=", value, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshLessThan(Byte value) {
            addCriterion("ecsh <", value, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshLessThanOrEqualTo(Byte value) {
            addCriterion("ecsh <=", value, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshIn(List<Byte> values) {
            addCriterion("ecsh in", values, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshNotIn(List<Byte> values) {
            addCriterion("ecsh not in", values, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshBetween(Byte value1, Byte value2) {
            addCriterion("ecsh between", value1, value2, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshNotBetween(Byte value1, Byte value2) {
            addCriterion("ecsh not between", value1, value2, "ecsh");
            return (Criteria) this;
        }

        public Criteria andEcshrIsNull() {
            addCriterion("ecshr is null");
            return (Criteria) this;
        }

        public Criteria andEcshrIsNotNull() {
            addCriterion("ecshr is not null");
            return (Criteria) this;
        }

        public Criteria andEcshrEqualTo(String value) {
            addCriterion("ecshr =", value, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrNotEqualTo(String value) {
            addCriterion("ecshr <>", value, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrGreaterThan(String value) {
            addCriterion("ecshr >", value, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrGreaterThanOrEqualTo(String value) {
            addCriterion("ecshr >=", value, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrLessThan(String value) {
            addCriterion("ecshr <", value, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrLessThanOrEqualTo(String value) {
            addCriterion("ecshr <=", value, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrLike(String value) {
            addCriterion("ecshr like", value, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrNotLike(String value) {
            addCriterion("ecshr not like", value, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrIn(List<String> values) {
            addCriterion("ecshr in", values, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrNotIn(List<String> values) {
            addCriterion("ecshr not in", values, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrBetween(String value1, String value2) {
            addCriterion("ecshr between", value1, value2, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrNotBetween(String value1, String value2) {
            addCriterion("ecshr not between", value1, value2, "ecshr");
            return (Criteria) this;
        }

        public Criteria andEcshrqIsNull() {
            addCriterion("ecshrq is null");
            return (Criteria) this;
        }

        public Criteria andEcshrqIsNotNull() {
            addCriterion("ecshrq is not null");
            return (Criteria) this;
        }

        public Criteria andEcshrqEqualTo(Date value) {
            addCriterion("ecshrq =", value, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andEcshrqNotEqualTo(Date value) {
            addCriterion("ecshrq <>", value, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andEcshrqGreaterThan(Date value) {
            addCriterion("ecshrq >", value, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andEcshrqGreaterThanOrEqualTo(Date value) {
            addCriterion("ecshrq >=", value, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andEcshrqLessThan(Date value) {
            addCriterion("ecshrq <", value, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andEcshrqLessThanOrEqualTo(Date value) {
            addCriterion("ecshrq <=", value, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andEcshrqIn(List<Date> values) {
            addCriterion("ecshrq in", values, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andEcshrqNotIn(List<Date> values) {
            addCriterion("ecshrq not in", values, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andEcshrqBetween(Date value1, Date value2) {
            addCriterion("ecshrq between", value1, value2, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andEcshrqNotBetween(Date value1, Date value2) {
            addCriterion("ecshrq not between", value1, value2, "ecshrq");
            return (Criteria) this;
        }

        public Criteria andKsshIsNull() {
            addCriterion("kssh is null");
            return (Criteria) this;
        }

        public Criteria andKsshIsNotNull() {
            addCriterion("kssh is not null");
            return (Criteria) this;
        }

        public Criteria andKsshEqualTo(Byte value) {
            addCriterion("kssh =", value, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshNotEqualTo(Byte value) {
            addCriterion("kssh <>", value, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshGreaterThan(Byte value) {
            addCriterion("kssh >", value, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshGreaterThanOrEqualTo(Byte value) {
            addCriterion("kssh >=", value, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshLessThan(Byte value) {
            addCriterion("kssh <", value, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshLessThanOrEqualTo(Byte value) {
            addCriterion("kssh <=", value, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshIn(List<Byte> values) {
            addCriterion("kssh in", values, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshNotIn(List<Byte> values) {
            addCriterion("kssh not in", values, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshBetween(Byte value1, Byte value2) {
            addCriterion("kssh between", value1, value2, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshNotBetween(Byte value1, Byte value2) {
            addCriterion("kssh not between", value1, value2, "kssh");
            return (Criteria) this;
        }

        public Criteria andKsshrIsNull() {
            addCriterion("ksshr is null");
            return (Criteria) this;
        }

        public Criteria andKsshrIsNotNull() {
            addCriterion("ksshr is not null");
            return (Criteria) this;
        }

        public Criteria andKsshrEqualTo(String value) {
            addCriterion("ksshr =", value, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrNotEqualTo(String value) {
            addCriterion("ksshr <>", value, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrGreaterThan(String value) {
            addCriterion("ksshr >", value, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrGreaterThanOrEqualTo(String value) {
            addCriterion("ksshr >=", value, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrLessThan(String value) {
            addCriterion("ksshr <", value, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrLessThanOrEqualTo(String value) {
            addCriterion("ksshr <=", value, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrLike(String value) {
            addCriterion("ksshr like", value, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrNotLike(String value) {
            addCriterion("ksshr not like", value, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrIn(List<String> values) {
            addCriterion("ksshr in", values, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrNotIn(List<String> values) {
            addCriterion("ksshr not in", values, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrBetween(String value1, String value2) {
            addCriterion("ksshr between", value1, value2, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrNotBetween(String value1, String value2) {
            addCriterion("ksshr not between", value1, value2, "ksshr");
            return (Criteria) this;
        }

        public Criteria andKsshrqIsNull() {
            addCriterion("ksshrq is null");
            return (Criteria) this;
        }

        public Criteria andKsshrqIsNotNull() {
            addCriterion("ksshrq is not null");
            return (Criteria) this;
        }

        public Criteria andKsshrqEqualTo(Date value) {
            addCriterion("ksshrq =", value, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andKsshrqNotEqualTo(Date value) {
            addCriterion("ksshrq <>", value, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andKsshrqGreaterThan(Date value) {
            addCriterion("ksshrq >", value, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andKsshrqGreaterThanOrEqualTo(Date value) {
            addCriterion("ksshrq >=", value, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andKsshrqLessThan(Date value) {
            addCriterion("ksshrq <", value, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andKsshrqLessThanOrEqualTo(Date value) {
            addCriterion("ksshrq <=", value, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andKsshrqIn(List<Date> values) {
            addCriterion("ksshrq in", values, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andKsshrqNotIn(List<Date> values) {
            addCriterion("ksshrq not in", values, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andKsshrqBetween(Date value1, Date value2) {
            addCriterion("ksshrq between", value1, value2, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andKsshrqNotBetween(Date value1, Date value2) {
            addCriterion("ksshrq not between", value1, value2, "ksshrq");
            return (Criteria) this;
        }

        public Criteria andShqrIsNull() {
            addCriterion("shqr is null");
            return (Criteria) this;
        }

        public Criteria andShqrIsNotNull() {
            addCriterion("shqr is not null");
            return (Criteria) this;
        }

        public Criteria andShqrEqualTo(Byte value) {
            addCriterion("shqr =", value, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrNotEqualTo(Byte value) {
            addCriterion("shqr <>", value, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrGreaterThan(Byte value) {
            addCriterion("shqr >", value, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrGreaterThanOrEqualTo(Byte value) {
            addCriterion("shqr >=", value, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrLessThan(Byte value) {
            addCriterion("shqr <", value, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrLessThanOrEqualTo(Byte value) {
            addCriterion("shqr <=", value, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrIn(List<Byte> values) {
            addCriterion("shqr in", values, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrNotIn(List<Byte> values) {
            addCriterion("shqr not in", values, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrBetween(Byte value1, Byte value2) {
            addCriterion("shqr between", value1, value2, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrNotBetween(Byte value1, Byte value2) {
            addCriterion("shqr not between", value1, value2, "shqr");
            return (Criteria) this;
        }

        public Criteria andShqrrIsNull() {
            addCriterion("shqrr is null");
            return (Criteria) this;
        }

        public Criteria andShqrrIsNotNull() {
            addCriterion("shqrr is not null");
            return (Criteria) this;
        }

        public Criteria andShqrrEqualTo(String value) {
            addCriterion("shqrr =", value, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrNotEqualTo(String value) {
            addCriterion("shqrr <>", value, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrGreaterThan(String value) {
            addCriterion("shqrr >", value, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrGreaterThanOrEqualTo(String value) {
            addCriterion("shqrr >=", value, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrLessThan(String value) {
            addCriterion("shqrr <", value, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrLessThanOrEqualTo(String value) {
            addCriterion("shqrr <=", value, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrLike(String value) {
            addCriterion("shqrr like", value, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrNotLike(String value) {
            addCriterion("shqrr not like", value, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrIn(List<String> values) {
            addCriterion("shqrr in", values, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrNotIn(List<String> values) {
            addCriterion("shqrr not in", values, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrBetween(String value1, String value2) {
            addCriterion("shqrr between", value1, value2, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrNotBetween(String value1, String value2) {
            addCriterion("shqrr not between", value1, value2, "shqrr");
            return (Criteria) this;
        }

        public Criteria andShqrrqIsNull() {
            addCriterion("shqrrq is null");
            return (Criteria) this;
        }

        public Criteria andShqrrqIsNotNull() {
            addCriterion("shqrrq is not null");
            return (Criteria) this;
        }

        public Criteria andShqrrqEqualTo(Date value) {
            addCriterion("shqrrq =", value, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andShqrrqNotEqualTo(Date value) {
            addCriterion("shqrrq <>", value, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andShqrrqGreaterThan(Date value) {
            addCriterion("shqrrq >", value, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andShqrrqGreaterThanOrEqualTo(Date value) {
            addCriterion("shqrrq >=", value, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andShqrrqLessThan(Date value) {
            addCriterion("shqrrq <", value, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andShqrrqLessThanOrEqualTo(Date value) {
            addCriterion("shqrrq <=", value, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andShqrrqIn(List<Date> values) {
            addCriterion("shqrrq in", values, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andShqrrqNotIn(List<Date> values) {
            addCriterion("shqrrq not in", values, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andShqrrqBetween(Date value1, Date value2) {
            addCriterion("shqrrq between", value1, value2, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andShqrrqNotBetween(Date value1, Date value2) {
            addCriterion("shqrrq not between", value1, value2, "shqrrq");
            return (Criteria) this;
        }

        public Criteria andKsfhIsNull() {
            addCriterion("ksfh is null");
            return (Criteria) this;
        }

        public Criteria andKsfhIsNotNull() {
            addCriterion("ksfh is not null");
            return (Criteria) this;
        }

        public Criteria andKsfhEqualTo(Byte value) {
            addCriterion("ksfh =", value, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhNotEqualTo(Byte value) {
            addCriterion("ksfh <>", value, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhGreaterThan(Byte value) {
            addCriterion("ksfh >", value, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhGreaterThanOrEqualTo(Byte value) {
            addCriterion("ksfh >=", value, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhLessThan(Byte value) {
            addCriterion("ksfh <", value, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhLessThanOrEqualTo(Byte value) {
            addCriterion("ksfh <=", value, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhIn(List<Byte> values) {
            addCriterion("ksfh in", values, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhNotIn(List<Byte> values) {
            addCriterion("ksfh not in", values, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhBetween(Byte value1, Byte value2) {
            addCriterion("ksfh between", value1, value2, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhNotBetween(Byte value1, Byte value2) {
            addCriterion("ksfh not between", value1, value2, "ksfh");
            return (Criteria) this;
        }

        public Criteria andKsfhrIsNull() {
            addCriterion("ksfhr is null");
            return (Criteria) this;
        }

        public Criteria andKsfhrIsNotNull() {
            addCriterion("ksfhr is not null");
            return (Criteria) this;
        }

        public Criteria andKsfhrEqualTo(String value) {
            addCriterion("ksfhr =", value, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrNotEqualTo(String value) {
            addCriterion("ksfhr <>", value, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrGreaterThan(String value) {
            addCriterion("ksfhr >", value, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrGreaterThanOrEqualTo(String value) {
            addCriterion("ksfhr >=", value, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrLessThan(String value) {
            addCriterion("ksfhr <", value, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrLessThanOrEqualTo(String value) {
            addCriterion("ksfhr <=", value, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrLike(String value) {
            addCriterion("ksfhr like", value, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrNotLike(String value) {
            addCriterion("ksfhr not like", value, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrIn(List<String> values) {
            addCriterion("ksfhr in", values, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrNotIn(List<String> values) {
            addCriterion("ksfhr not in", values, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrBetween(String value1, String value2) {
            addCriterion("ksfhr between", value1, value2, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrNotBetween(String value1, String value2) {
            addCriterion("ksfhr not between", value1, value2, "ksfhr");
            return (Criteria) this;
        }

        public Criteria andKsfhrqIsNull() {
            addCriterion("ksfhrq is null");
            return (Criteria) this;
        }

        public Criteria andKsfhrqIsNotNull() {
            addCriterion("ksfhrq is not null");
            return (Criteria) this;
        }

        public Criteria andKsfhrqEqualTo(Date value) {
            addCriterion("ksfhrq =", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqNotEqualTo(Date value) {
            addCriterion("ksfhrq <>", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqGreaterThan(Date value) {
            addCriterion("ksfhrq >", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqGreaterThanOrEqualTo(Date value) {
            addCriterion("ksfhrq >=", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqLessThan(Date value) {
            addCriterion("ksfhrq <", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqLessThanOrEqualTo(Date value) {
            addCriterion("ksfhrq <=", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqIn(List<Date> values) {
            addCriterion("ksfhrq in", values, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqNotIn(List<Date> values) {
            addCriterion("ksfhrq not in", values, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqBetween(Date value1, Date value2) {
            addCriterion("ksfhrq between", value1, value2, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqNotBetween(Date value1, Date value2) {
            addCriterion("ksfhrq not between", value1, value2, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsphIsNull() {
            addCriterion("ksph is null");
            return (Criteria) this;
        }

        public Criteria andKsphIsNotNull() {
            addCriterion("ksph is not null");
            return (Criteria) this;
        }

        public Criteria andKsphEqualTo(Byte value) {
            addCriterion("ksph =", value, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphNotEqualTo(Byte value) {
            addCriterion("ksph <>", value, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphGreaterThan(Byte value) {
            addCriterion("ksph >", value, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphGreaterThanOrEqualTo(Byte value) {
            addCriterion("ksph >=", value, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphLessThan(Byte value) {
            addCriterion("ksph <", value, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphLessThanOrEqualTo(Byte value) {
            addCriterion("ksph <=", value, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphIn(List<Byte> values) {
            addCriterion("ksph in", values, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphNotIn(List<Byte> values) {
            addCriterion("ksph not in", values, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphBetween(Byte value1, Byte value2) {
            addCriterion("ksph between", value1, value2, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphNotBetween(Byte value1, Byte value2) {
            addCriterion("ksph not between", value1, value2, "ksph");
            return (Criteria) this;
        }

        public Criteria andKsphrIsNull() {
            addCriterion("ksphr is null");
            return (Criteria) this;
        }

        public Criteria andKsphrIsNotNull() {
            addCriterion("ksphr is not null");
            return (Criteria) this;
        }

        public Criteria andKsphrEqualTo(String value) {
            addCriterion("ksphr =", value, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrNotEqualTo(String value) {
            addCriterion("ksphr <>", value, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrGreaterThan(String value) {
            addCriterion("ksphr >", value, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrGreaterThanOrEqualTo(String value) {
            addCriterion("ksphr >=", value, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrLessThan(String value) {
            addCriterion("ksphr <", value, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrLessThanOrEqualTo(String value) {
            addCriterion("ksphr <=", value, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrLike(String value) {
            addCriterion("ksphr like", value, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrNotLike(String value) {
            addCriterion("ksphr not like", value, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrIn(List<String> values) {
            addCriterion("ksphr in", values, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrNotIn(List<String> values) {
            addCriterion("ksphr not in", values, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrBetween(String value1, String value2) {
            addCriterion("ksphr between", value1, value2, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrNotBetween(String value1, String value2) {
            addCriterion("ksphr not between", value1, value2, "ksphr");
            return (Criteria) this;
        }

        public Criteria andKsphrqIsNull() {
            addCriterion("ksphrq is null");
            return (Criteria) this;
        }

        public Criteria andKsphrqIsNotNull() {
            addCriterion("ksphrq is not null");
            return (Criteria) this;
        }

        public Criteria andKsphrqEqualTo(Date value) {
            addCriterion("ksphrq =", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqNotEqualTo(Date value) {
            addCriterion("ksphrq <>", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqGreaterThan(Date value) {
            addCriterion("ksphrq >", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqGreaterThanOrEqualTo(Date value) {
            addCriterion("ksphrq >=", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqLessThan(Date value) {
            addCriterion("ksphrq <", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqLessThanOrEqualTo(Date value) {
            addCriterion("ksphrq <=", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqIn(List<Date> values) {
            addCriterion("ksphrq in", values, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqNotIn(List<Date> values) {
            addCriterion("ksphrq not in", values, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqBetween(Date value1, Date value2) {
            addCriterion("ksphrq between", value1, value2, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqNotBetween(Date value1, Date value2) {
            addCriterion("ksphrq not between", value1, value2, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andCgfhIsNull() {
            addCriterion("cgfh is null");
            return (Criteria) this;
        }

        public Criteria andCgfhIsNotNull() {
            addCriterion("cgfh is not null");
            return (Criteria) this;
        }

        public Criteria andCgfhEqualTo(Byte value) {
            addCriterion("cgfh =", value, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhNotEqualTo(Byte value) {
            addCriterion("cgfh <>", value, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhGreaterThan(Byte value) {
            addCriterion("cgfh >", value, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhGreaterThanOrEqualTo(Byte value) {
            addCriterion("cgfh >=", value, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhLessThan(Byte value) {
            addCriterion("cgfh <", value, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhLessThanOrEqualTo(Byte value) {
            addCriterion("cgfh <=", value, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhIn(List<Byte> values) {
            addCriterion("cgfh in", values, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhNotIn(List<Byte> values) {
            addCriterion("cgfh not in", values, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhBetween(Byte value1, Byte value2) {
            addCriterion("cgfh between", value1, value2, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhNotBetween(Byte value1, Byte value2) {
            addCriterion("cgfh not between", value1, value2, "cgfh");
            return (Criteria) this;
        }

        public Criteria andCgfhrIsNull() {
            addCriterion("cgfhr is null");
            return (Criteria) this;
        }

        public Criteria andCgfhrIsNotNull() {
            addCriterion("cgfhr is not null");
            return (Criteria) this;
        }

        public Criteria andCgfhrEqualTo(String value) {
            addCriterion("cgfhr =", value, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrNotEqualTo(String value) {
            addCriterion("cgfhr <>", value, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrGreaterThan(String value) {
            addCriterion("cgfhr >", value, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrGreaterThanOrEqualTo(String value) {
            addCriterion("cgfhr >=", value, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrLessThan(String value) {
            addCriterion("cgfhr <", value, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrLessThanOrEqualTo(String value) {
            addCriterion("cgfhr <=", value, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrLike(String value) {
            addCriterion("cgfhr like", value, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrNotLike(String value) {
            addCriterion("cgfhr not like", value, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrIn(List<String> values) {
            addCriterion("cgfhr in", values, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrNotIn(List<String> values) {
            addCriterion("cgfhr not in", values, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrBetween(String value1, String value2) {
            addCriterion("cgfhr between", value1, value2, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrNotBetween(String value1, String value2) {
            addCriterion("cgfhr not between", value1, value2, "cgfhr");
            return (Criteria) this;
        }

        public Criteria andCgfhrqIsNull() {
            addCriterion("cgfhrq is null");
            return (Criteria) this;
        }

        public Criteria andCgfhrqIsNotNull() {
            addCriterion("cgfhrq is not null");
            return (Criteria) this;
        }

        public Criteria andCgfhrqEqualTo(Date value) {
            addCriterion("cgfhrq =", value, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andCgfhrqNotEqualTo(Date value) {
            addCriterion("cgfhrq <>", value, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andCgfhrqGreaterThan(Date value) {
            addCriterion("cgfhrq >", value, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andCgfhrqGreaterThanOrEqualTo(Date value) {
            addCriterion("cgfhrq >=", value, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andCgfhrqLessThan(Date value) {
            addCriterion("cgfhrq <", value, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andCgfhrqLessThanOrEqualTo(Date value) {
            addCriterion("cgfhrq <=", value, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andCgfhrqIn(List<Date> values) {
            addCriterion("cgfhrq in", values, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andCgfhrqNotIn(List<Date> values) {
            addCriterion("cgfhrq not in", values, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andCgfhrqBetween(Date value1, Date value2) {
            addCriterion("cgfhrq between", value1, value2, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andCgfhrqNotBetween(Date value1, Date value2) {
            addCriterion("cgfhrq not between", value1, value2, "cgfhrq");
            return (Criteria) this;
        }

        public Criteria andYflrIsNull() {
            addCriterion("yflr is null");
            return (Criteria) this;
        }

        public Criteria andYflrIsNotNull() {
            addCriterion("yflr is not null");
            return (Criteria) this;
        }

        public Criteria andYflrEqualTo(Byte value) {
            addCriterion("yflr =", value, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrNotEqualTo(Byte value) {
            addCriterion("yflr <>", value, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrGreaterThan(Byte value) {
            addCriterion("yflr >", value, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrGreaterThanOrEqualTo(Byte value) {
            addCriterion("yflr >=", value, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrLessThan(Byte value) {
            addCriterion("yflr <", value, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrLessThanOrEqualTo(Byte value) {
            addCriterion("yflr <=", value, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrIn(List<Byte> values) {
            addCriterion("yflr in", values, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrNotIn(List<Byte> values) {
            addCriterion("yflr not in", values, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrBetween(Byte value1, Byte value2) {
            addCriterion("yflr between", value1, value2, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrNotBetween(Byte value1, Byte value2) {
            addCriterion("yflr not between", value1, value2, "yflr");
            return (Criteria) this;
        }

        public Criteria andYflrrIsNull() {
            addCriterion("yflrr is null");
            return (Criteria) this;
        }

        public Criteria andYflrrIsNotNull() {
            addCriterion("yflrr is not null");
            return (Criteria) this;
        }

        public Criteria andYflrrEqualTo(String value) {
            addCriterion("yflrr =", value, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrNotEqualTo(String value) {
            addCriterion("yflrr <>", value, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrGreaterThan(String value) {
            addCriterion("yflrr >", value, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrGreaterThanOrEqualTo(String value) {
            addCriterion("yflrr >=", value, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrLessThan(String value) {
            addCriterion("yflrr <", value, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrLessThanOrEqualTo(String value) {
            addCriterion("yflrr <=", value, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrLike(String value) {
            addCriterion("yflrr like", value, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrNotLike(String value) {
            addCriterion("yflrr not like", value, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrIn(List<String> values) {
            addCriterion("yflrr in", values, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrNotIn(List<String> values) {
            addCriterion("yflrr not in", values, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrBetween(String value1, String value2) {
            addCriterion("yflrr between", value1, value2, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrNotBetween(String value1, String value2) {
            addCriterion("yflrr not between", value1, value2, "yflrr");
            return (Criteria) this;
        }

        public Criteria andYflrrqIsNull() {
            addCriterion("yflrrq is null");
            return (Criteria) this;
        }

        public Criteria andYflrrqIsNotNull() {
            addCriterion("yflrrq is not null");
            return (Criteria) this;
        }

        public Criteria andYflrrqEqualTo(Date value) {
            addCriterion("yflrrq =", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqNotEqualTo(Date value) {
            addCriterion("yflrrq <>", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqGreaterThan(Date value) {
            addCriterion("yflrrq >", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqGreaterThanOrEqualTo(Date value) {
            addCriterion("yflrrq >=", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqLessThan(Date value) {
            addCriterion("yflrrq <", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqLessThanOrEqualTo(Date value) {
            addCriterion("yflrrq <=", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqIn(List<Date> values) {
            addCriterion("yflrrq in", values, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqNotIn(List<Date> values) {
            addCriterion("yflrrq not in", values, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqBetween(Date value1, Date value2) {
            addCriterion("yflrrq between", value1, value2, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqNotBetween(Date value1, Date value2) {
            addCriterion("yflrrq not between", value1, value2, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrIsNull() {
            addCriterion("ysflr is null");
            return (Criteria) this;
        }

        public Criteria andYsflrIsNotNull() {
            addCriterion("ysflr is not null");
            return (Criteria) this;
        }

        public Criteria andYsflrEqualTo(Byte value) {
            addCriterion("ysflr =", value, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrNotEqualTo(Byte value) {
            addCriterion("ysflr <>", value, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrGreaterThan(Byte value) {
            addCriterion("ysflr >", value, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrGreaterThanOrEqualTo(Byte value) {
            addCriterion("ysflr >=", value, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrLessThan(Byte value) {
            addCriterion("ysflr <", value, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrLessThanOrEqualTo(Byte value) {
            addCriterion("ysflr <=", value, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrIn(List<Byte> values) {
            addCriterion("ysflr in", values, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrNotIn(List<Byte> values) {
            addCriterion("ysflr not in", values, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrBetween(Byte value1, Byte value2) {
            addCriterion("ysflr between", value1, value2, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrNotBetween(Byte value1, Byte value2) {
            addCriterion("ysflr not between", value1, value2, "ysflr");
            return (Criteria) this;
        }

        public Criteria andYsflrrIsNull() {
            addCriterion("ysflrr is null");
            return (Criteria) this;
        }

        public Criteria andYsflrrIsNotNull() {
            addCriterion("ysflrr is not null");
            return (Criteria) this;
        }

        public Criteria andYsflrrEqualTo(String value) {
            addCriterion("ysflrr =", value, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrNotEqualTo(String value) {
            addCriterion("ysflrr <>", value, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrGreaterThan(String value) {
            addCriterion("ysflrr >", value, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrGreaterThanOrEqualTo(String value) {
            addCriterion("ysflrr >=", value, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrLessThan(String value) {
            addCriterion("ysflrr <", value, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrLessThanOrEqualTo(String value) {
            addCriterion("ysflrr <=", value, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrLike(String value) {
            addCriterion("ysflrr like", value, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrNotLike(String value) {
            addCriterion("ysflrr not like", value, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrIn(List<String> values) {
            addCriterion("ysflrr in", values, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrNotIn(List<String> values) {
            addCriterion("ysflrr not in", values, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrBetween(String value1, String value2) {
            addCriterion("ysflrr between", value1, value2, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrNotBetween(String value1, String value2) {
            addCriterion("ysflrr not between", value1, value2, "ysflrr");
            return (Criteria) this;
        }

        public Criteria andYsflrrqIsNull() {
            addCriterion("ysflrrq is null");
            return (Criteria) this;
        }

        public Criteria andYsflrrqIsNotNull() {
            addCriterion("ysflrrq is not null");
            return (Criteria) this;
        }

        public Criteria andYsflrrqEqualTo(Date value) {
            addCriterion("ysflrrq =", value, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrrqNotEqualTo(Date value) {
            addCriterion("ysflrrq <>", value, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrrqGreaterThan(Date value) {
            addCriterion("ysflrrq >", value, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrrqGreaterThanOrEqualTo(Date value) {
            addCriterion("ysflrrq >=", value, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrrqLessThan(Date value) {
            addCriterion("ysflrrq <", value, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrrqLessThanOrEqualTo(Date value) {
            addCriterion("ysflrrq <=", value, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrrqIn(List<Date> values) {
            addCriterion("ysflrrq in", values, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrrqNotIn(List<Date> values) {
            addCriterion("ysflrrq not in", values, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrrqBetween(Date value1, Date value2) {
            addCriterion("ysflrrq between", value1, value2, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andYsflrrqNotBetween(Date value1, Date value2) {
            addCriterion("ysflrrq not between", value1, value2, "ysflrrq");
            return (Criteria) this;
        }

        public Criteria andSctcIsNull() {
            addCriterion("sctc is null");
            return (Criteria) this;
        }

        public Criteria andSctcIsNotNull() {
            addCriterion("sctc is not null");
            return (Criteria) this;
        }

        public Criteria andSctcEqualTo(Byte value) {
            addCriterion("sctc =", value, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcNotEqualTo(Byte value) {
            addCriterion("sctc <>", value, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcGreaterThan(Byte value) {
            addCriterion("sctc >", value, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcGreaterThanOrEqualTo(Byte value) {
            addCriterion("sctc >=", value, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcLessThan(Byte value) {
            addCriterion("sctc <", value, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcLessThanOrEqualTo(Byte value) {
            addCriterion("sctc <=", value, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcIn(List<Byte> values) {
            addCriterion("sctc in", values, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcNotIn(List<Byte> values) {
            addCriterion("sctc not in", values, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcBetween(Byte value1, Byte value2) {
            addCriterion("sctc between", value1, value2, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcNotBetween(Byte value1, Byte value2) {
            addCriterion("sctc not between", value1, value2, "sctc");
            return (Criteria) this;
        }

        public Criteria andSctcrIsNull() {
            addCriterion("sctcr is null");
            return (Criteria) this;
        }

        public Criteria andSctcrIsNotNull() {
            addCriterion("sctcr is not null");
            return (Criteria) this;
        }

        public Criteria andSctcrEqualTo(String value) {
            addCriterion("sctcr =", value, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrNotEqualTo(String value) {
            addCriterion("sctcr <>", value, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrGreaterThan(String value) {
            addCriterion("sctcr >", value, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrGreaterThanOrEqualTo(String value) {
            addCriterion("sctcr >=", value, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrLessThan(String value) {
            addCriterion("sctcr <", value, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrLessThanOrEqualTo(String value) {
            addCriterion("sctcr <=", value, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrLike(String value) {
            addCriterion("sctcr like", value, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrNotLike(String value) {
            addCriterion("sctcr not like", value, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrIn(List<String> values) {
            addCriterion("sctcr in", values, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrNotIn(List<String> values) {
            addCriterion("sctcr not in", values, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrBetween(String value1, String value2) {
            addCriterion("sctcr between", value1, value2, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrNotBetween(String value1, String value2) {
            addCriterion("sctcr not between", value1, value2, "sctcr");
            return (Criteria) this;
        }

        public Criteria andSctcrqIsNull() {
            addCriterion("sctcrq is null");
            return (Criteria) this;
        }

        public Criteria andSctcrqIsNotNull() {
            addCriterion("sctcrq is not null");
            return (Criteria) this;
        }

        public Criteria andSctcrqEqualTo(Date value) {
            addCriterion("sctcrq =", value, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andSctcrqNotEqualTo(Date value) {
            addCriterion("sctcrq <>", value, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andSctcrqGreaterThan(Date value) {
            addCriterion("sctcrq >", value, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andSctcrqGreaterThanOrEqualTo(Date value) {
            addCriterion("sctcrq >=", value, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andSctcrqLessThan(Date value) {
            addCriterion("sctcrq <", value, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andSctcrqLessThanOrEqualTo(Date value) {
            addCriterion("sctcrq <=", value, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andSctcrqIn(List<Date> values) {
            addCriterion("sctcrq in", values, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andSctcrqNotIn(List<Date> values) {
            addCriterion("sctcrq not in", values, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andSctcrqBetween(Date value1, Date value2) {
            addCriterion("sctcrq between", value1, value2, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andSctcrqNotBetween(Date value1, Date value2) {
            addCriterion("sctcrq not between", value1, value2, "sctcrq");
            return (Criteria) this;
        }

        public Criteria andZsIsNull() {
            addCriterion("zs is null");
            return (Criteria) this;
        }

        public Criteria andZsIsNotNull() {
            addCriterion("zs is not null");
            return (Criteria) this;
        }

        public Criteria andZsEqualTo(Byte value) {
            addCriterion("zs =", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotEqualTo(Byte value) {
            addCriterion("zs <>", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsGreaterThan(Byte value) {
            addCriterion("zs >", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsGreaterThanOrEqualTo(Byte value) {
            addCriterion("zs >=", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsLessThan(Byte value) {
            addCriterion("zs <", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsLessThanOrEqualTo(Byte value) {
            addCriterion("zs <=", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsIn(List<Byte> values) {
            addCriterion("zs in", values, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotIn(List<Byte> values) {
            addCriterion("zs not in", values, "zs");
            return (Criteria) this;
        }

        public Criteria andZsBetween(Byte value1, Byte value2) {
            addCriterion("zs between", value1, value2, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotBetween(Byte value1, Byte value2) {
            addCriterion("zs not between", value1, value2, "zs");
            return (Criteria) this;
        }

        public Criteria andZsrIsNull() {
            addCriterion("zsr is null");
            return (Criteria) this;
        }

        public Criteria andZsrIsNotNull() {
            addCriterion("zsr is not null");
            return (Criteria) this;
        }

        public Criteria andZsrEqualTo(String value) {
            addCriterion("zsr =", value, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrNotEqualTo(String value) {
            addCriterion("zsr <>", value, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrGreaterThan(String value) {
            addCriterion("zsr >", value, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrGreaterThanOrEqualTo(String value) {
            addCriterion("zsr >=", value, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrLessThan(String value) {
            addCriterion("zsr <", value, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrLessThanOrEqualTo(String value) {
            addCriterion("zsr <=", value, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrLike(String value) {
            addCriterion("zsr like", value, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrNotLike(String value) {
            addCriterion("zsr not like", value, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrIn(List<String> values) {
            addCriterion("zsr in", values, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrNotIn(List<String> values) {
            addCriterion("zsr not in", values, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrBetween(String value1, String value2) {
            addCriterion("zsr between", value1, value2, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrNotBetween(String value1, String value2) {
            addCriterion("zsr not between", value1, value2, "zsr");
            return (Criteria) this;
        }

        public Criteria andZsrqIsNull() {
            addCriterion("zsrq is null");
            return (Criteria) this;
        }

        public Criteria andZsrqIsNotNull() {
            addCriterion("zsrq is not null");
            return (Criteria) this;
        }

        public Criteria andZsrqEqualTo(Date value) {
            addCriterion("zsrq =", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqNotEqualTo(Date value) {
            addCriterion("zsrq <>", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqGreaterThan(Date value) {
            addCriterion("zsrq >", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("zsrq >=", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqLessThan(Date value) {
            addCriterion("zsrq <", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqLessThanOrEqualTo(Date value) {
            addCriterion("zsrq <=", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqIn(List<Date> values) {
            addCriterion("zsrq in", values, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqNotIn(List<Date> values) {
            addCriterion("zsrq not in", values, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqBetween(Date value1, Date value2) {
            addCriterion("zsrq between", value1, value2, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqNotBetween(Date value1, Date value2) {
            addCriterion("zsrq not between", value1, value2, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZfIsNull() {
            addCriterion("zf is null");
            return (Criteria) this;
        }

        public Criteria andZfIsNotNull() {
            addCriterion("zf is not null");
            return (Criteria) this;
        }

        public Criteria andZfEqualTo(Byte value) {
            addCriterion("zf =", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfNotEqualTo(Byte value) {
            addCriterion("zf <>", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfGreaterThan(Byte value) {
            addCriterion("zf >", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfGreaterThanOrEqualTo(Byte value) {
            addCriterion("zf >=", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfLessThan(Byte value) {
            addCriterion("zf <", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfLessThanOrEqualTo(Byte value) {
            addCriterion("zf <=", value, "zf");
            return (Criteria) this;
        }

        public Criteria andZfIn(List<Byte> values) {
            addCriterion("zf in", values, "zf");
            return (Criteria) this;
        }

        public Criteria andZfNotIn(List<Byte> values) {
            addCriterion("zf not in", values, "zf");
            return (Criteria) this;
        }

        public Criteria andZfBetween(Byte value1, Byte value2) {
            addCriterion("zf between", value1, value2, "zf");
            return (Criteria) this;
        }

        public Criteria andZfNotBetween(Byte value1, Byte value2) {
            addCriterion("zf not between", value1, value2, "zf");
            return (Criteria) this;
        }

        public Criteria andZfrIsNull() {
            addCriterion("zfr is null");
            return (Criteria) this;
        }

        public Criteria andZfrIsNotNull() {
            addCriterion("zfr is not null");
            return (Criteria) this;
        }

        public Criteria andZfrEqualTo(String value) {
            addCriterion("zfr =", value, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrNotEqualTo(String value) {
            addCriterion("zfr <>", value, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrGreaterThan(String value) {
            addCriterion("zfr >", value, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrGreaterThanOrEqualTo(String value) {
            addCriterion("zfr >=", value, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrLessThan(String value) {
            addCriterion("zfr <", value, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrLessThanOrEqualTo(String value) {
            addCriterion("zfr <=", value, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrLike(String value) {
            addCriterion("zfr like", value, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrNotLike(String value) {
            addCriterion("zfr not like", value, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrIn(List<String> values) {
            addCriterion("zfr in", values, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrNotIn(List<String> values) {
            addCriterion("zfr not in", values, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrBetween(String value1, String value2) {
            addCriterion("zfr between", value1, value2, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrNotBetween(String value1, String value2) {
            addCriterion("zfr not between", value1, value2, "zfr");
            return (Criteria) this;
        }

        public Criteria andZfrqIsNull() {
            addCriterion("zfrq is null");
            return (Criteria) this;
        }

        public Criteria andZfrqIsNotNull() {
            addCriterion("zfrq is not null");
            return (Criteria) this;
        }

        public Criteria andZfrqEqualTo(Date value) {
            addCriterion("zfrq =", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqNotEqualTo(Date value) {
            addCriterion("zfrq <>", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqGreaterThan(Date value) {
            addCriterion("zfrq >", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqGreaterThanOrEqualTo(Date value) {
            addCriterion("zfrq >=", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqLessThan(Date value) {
            addCriterion("zfrq <", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqLessThanOrEqualTo(Date value) {
            addCriterion("zfrq <=", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqIn(List<Date> values) {
            addCriterion("zfrq in", values, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqNotIn(List<Date> values) {
            addCriterion("zfrq not in", values, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqBetween(Date value1, Date value2) {
            addCriterion("zfrq between", value1, value2, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqNotBetween(Date value1, Date value2) {
            addCriterion("zfrq not between", value1, value2, "zfrq");
            return (Criteria) this;
        }

        public Criteria andEx1IsNull() {
            addCriterion("ex1 is null");
            return (Criteria) this;
        }

        public Criteria andEx1IsNotNull() {
            addCriterion("ex1 is not null");
            return (Criteria) this;
        }

        public Criteria andEx1EqualTo(String value) {
            addCriterion("ex1 =", value, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1NotEqualTo(String value) {
            addCriterion("ex1 <>", value, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1GreaterThan(String value) {
            addCriterion("ex1 >", value, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1GreaterThanOrEqualTo(String value) {
            addCriterion("ex1 >=", value, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1LessThan(String value) {
            addCriterion("ex1 <", value, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1LessThanOrEqualTo(String value) {
            addCriterion("ex1 <=", value, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1Like(String value) {
            addCriterion("ex1 like", value, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1NotLike(String value) {
            addCriterion("ex1 not like", value, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1In(List<String> values) {
            addCriterion("ex1 in", values, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1NotIn(List<String> values) {
            addCriterion("ex1 not in", values, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1Between(String value1, String value2) {
            addCriterion("ex1 between", value1, value2, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx1NotBetween(String value1, String value2) {
            addCriterion("ex1 not between", value1, value2, "ex1");
            return (Criteria) this;
        }

        public Criteria andEx2IsNull() {
            addCriterion("ex2 is null");
            return (Criteria) this;
        }

        public Criteria andEx2IsNotNull() {
            addCriterion("ex2 is not null");
            return (Criteria) this;
        }

        public Criteria andEx2EqualTo(String value) {
            addCriterion("ex2 =", value, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2NotEqualTo(String value) {
            addCriterion("ex2 <>", value, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2GreaterThan(String value) {
            addCriterion("ex2 >", value, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2GreaterThanOrEqualTo(String value) {
            addCriterion("ex2 >=", value, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2LessThan(String value) {
            addCriterion("ex2 <", value, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2LessThanOrEqualTo(String value) {
            addCriterion("ex2 <=", value, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2Like(String value) {
            addCriterion("ex2 like", value, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2NotLike(String value) {
            addCriterion("ex2 not like", value, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2In(List<String> values) {
            addCriterion("ex2 in", values, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2NotIn(List<String> values) {
            addCriterion("ex2 not in", values, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2Between(String value1, String value2) {
            addCriterion("ex2 between", value1, value2, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx2NotBetween(String value1, String value2) {
            addCriterion("ex2 not between", value1, value2, "ex2");
            return (Criteria) this;
        }

        public Criteria andEx3IsNull() {
            addCriterion("ex3 is null");
            return (Criteria) this;
        }

        public Criteria andEx3IsNotNull() {
            addCriterion("ex3 is not null");
            return (Criteria) this;
        }

        public Criteria andEx3EqualTo(String value) {
            addCriterion("ex3 =", value, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3NotEqualTo(String value) {
            addCriterion("ex3 <>", value, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3GreaterThan(String value) {
            addCriterion("ex3 >", value, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3GreaterThanOrEqualTo(String value) {
            addCriterion("ex3 >=", value, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3LessThan(String value) {
            addCriterion("ex3 <", value, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3LessThanOrEqualTo(String value) {
            addCriterion("ex3 <=", value, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3Like(String value) {
            addCriterion("ex3 like", value, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3NotLike(String value) {
            addCriterion("ex3 not like", value, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3In(List<String> values) {
            addCriterion("ex3 in", values, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3NotIn(List<String> values) {
            addCriterion("ex3 not in", values, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3Between(String value1, String value2) {
            addCriterion("ex3 between", value1, value2, "ex3");
            return (Criteria) this;
        }

        public Criteria andEx3NotBetween(String value1, String value2) {
            addCriterion("ex3 not between", value1, value2, "ex3");
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