package com.febs.receipt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderXsmxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderXsmxExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andSpIdIsNull() {
            addCriterion("sp_id is null");
            return (Criteria) this;
        }

        public Criteria andSpIdIsNotNull() {
            addCriterion("sp_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpIdEqualTo(Integer value) {
            addCriterion("sp_id =", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotEqualTo(Integer value) {
            addCriterion("sp_id <>", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThan(Integer value) {
            addCriterion("sp_id >", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_id >=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThan(Integer value) {
            addCriterion("sp_id <", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThanOrEqualTo(Integer value) {
            addCriterion("sp_id <=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdIn(List<Integer> values) {
            addCriterion("sp_id in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotIn(List<Integer> values) {
            addCriterion("sp_id not in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdBetween(Integer value1, Integer value2) {
            addCriterion("sp_id between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_id not between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andGg1IdIsNull() {
            addCriterion("gg1_id is null");
            return (Criteria) this;
        }

        public Criteria andGg1IdIsNotNull() {
            addCriterion("gg1_id is not null");
            return (Criteria) this;
        }

        public Criteria andGg1IdEqualTo(Integer value) {
            addCriterion("gg1_id =", value, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg1IdNotEqualTo(Integer value) {
            addCriterion("gg1_id <>", value, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg1IdGreaterThan(Integer value) {
            addCriterion("gg1_id >", value, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg1IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg1_id >=", value, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg1IdLessThan(Integer value) {
            addCriterion("gg1_id <", value, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg1IdLessThanOrEqualTo(Integer value) {
            addCriterion("gg1_id <=", value, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg1IdIn(List<Integer> values) {
            addCriterion("gg1_id in", values, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg1IdNotIn(List<Integer> values) {
            addCriterion("gg1_id not in", values, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg1IdBetween(Integer value1, Integer value2) {
            addCriterion("gg1_id between", value1, value2, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg1IdNotBetween(Integer value1, Integer value2) {
            addCriterion("gg1_id not between", value1, value2, "gg1Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdIsNull() {
            addCriterion("gg2_id is null");
            return (Criteria) this;
        }

        public Criteria andGg2IdIsNotNull() {
            addCriterion("gg2_id is not null");
            return (Criteria) this;
        }

        public Criteria andGg2IdEqualTo(Integer value) {
            addCriterion("gg2_id =", value, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdNotEqualTo(Integer value) {
            addCriterion("gg2_id <>", value, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdGreaterThan(Integer value) {
            addCriterion("gg2_id >", value, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg2_id >=", value, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdLessThan(Integer value) {
            addCriterion("gg2_id <", value, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdLessThanOrEqualTo(Integer value) {
            addCriterion("gg2_id <=", value, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdIn(List<Integer> values) {
            addCriterion("gg2_id in", values, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdNotIn(List<Integer> values) {
            addCriterion("gg2_id not in", values, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdBetween(Integer value1, Integer value2) {
            addCriterion("gg2_id between", value1, value2, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andGg2IdNotBetween(Integer value1, Integer value2) {
            addCriterion("gg2_id not between", value1, value2, "gg2Id");
            return (Criteria) this;
        }

        public Criteria andJhslIsNull() {
            addCriterion("jhsl is null");
            return (Criteria) this;
        }

        public Criteria andJhslIsNotNull() {
            addCriterion("jhsl is not null");
            return (Criteria) this;
        }

        public Criteria andJhslEqualTo(Integer value) {
            addCriterion("jhsl =", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslNotEqualTo(Integer value) {
            addCriterion("jhsl <>", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslGreaterThan(Integer value) {
            addCriterion("jhsl >", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslGreaterThanOrEqualTo(Integer value) {
            addCriterion("jhsl >=", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslLessThan(Integer value) {
            addCriterion("jhsl <", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslLessThanOrEqualTo(Integer value) {
            addCriterion("jhsl <=", value, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslIn(List<Integer> values) {
            addCriterion("jhsl in", values, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslNotIn(List<Integer> values) {
            addCriterion("jhsl not in", values, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslBetween(Integer value1, Integer value2) {
            addCriterion("jhsl between", value1, value2, "jhsl");
            return (Criteria) this;
        }

        public Criteria andJhslNotBetween(Integer value1, Integer value2) {
            addCriterion("jhsl not between", value1, value2, "jhsl");
            return (Criteria) this;
        }

        public Criteria andTzslIsNull() {
            addCriterion("tzsl is null");
            return (Criteria) this;
        }

        public Criteria andTzslIsNotNull() {
            addCriterion("tzsl is not null");
            return (Criteria) this;
        }

        public Criteria andTzslEqualTo(Integer value) {
            addCriterion("tzsl =", value, "tzsl");
            return (Criteria) this;
        }

        public Criteria andTzslNotEqualTo(Integer value) {
            addCriterion("tzsl <>", value, "tzsl");
            return (Criteria) this;
        }

        public Criteria andTzslGreaterThan(Integer value) {
            addCriterion("tzsl >", value, "tzsl");
            return (Criteria) this;
        }

        public Criteria andTzslGreaterThanOrEqualTo(Integer value) {
            addCriterion("tzsl >=", value, "tzsl");
            return (Criteria) this;
        }

        public Criteria andTzslLessThan(Integer value) {
            addCriterion("tzsl <", value, "tzsl");
            return (Criteria) this;
        }

        public Criteria andTzslLessThanOrEqualTo(Integer value) {
            addCriterion("tzsl <=", value, "tzsl");
            return (Criteria) this;
        }

        public Criteria andTzslIn(List<Integer> values) {
            addCriterion("tzsl in", values, "tzsl");
            return (Criteria) this;
        }

        public Criteria andTzslNotIn(List<Integer> values) {
            addCriterion("tzsl not in", values, "tzsl");
            return (Criteria) this;
        }

        public Criteria andTzslBetween(Integer value1, Integer value2) {
            addCriterion("tzsl between", value1, value2, "tzsl");
            return (Criteria) this;
        }

        public Criteria andTzslNotBetween(Integer value1, Integer value2) {
            addCriterion("tzsl not between", value1, value2, "tzsl");
            return (Criteria) this;
        }

        public Criteria andCkslIsNull() {
            addCriterion("cksl is null");
            return (Criteria) this;
        }

        public Criteria andCkslIsNotNull() {
            addCriterion("cksl is not null");
            return (Criteria) this;
        }

        public Criteria andCkslEqualTo(Integer value) {
            addCriterion("cksl =", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslNotEqualTo(Integer value) {
            addCriterion("cksl <>", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslGreaterThan(Integer value) {
            addCriterion("cksl >", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslGreaterThanOrEqualTo(Integer value) {
            addCriterion("cksl >=", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslLessThan(Integer value) {
            addCriterion("cksl <", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslLessThanOrEqualTo(Integer value) {
            addCriterion("cksl <=", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslIn(List<Integer> values) {
            addCriterion("cksl in", values, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslNotIn(List<Integer> values) {
            addCriterion("cksl not in", values, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslBetween(Integer value1, Integer value2) {
            addCriterion("cksl between", value1, value2, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslNotBetween(Integer value1, Integer value2) {
            addCriterion("cksl not between", value1, value2, "cksl");
            return (Criteria) this;
        }

        public Criteria andDjIsNull() {
            addCriterion("dj is null");
            return (Criteria) this;
        }

        public Criteria andDjIsNotNull() {
            addCriterion("dj is not null");
            return (Criteria) this;
        }

        public Criteria andDjEqualTo(BigDecimal value) {
            addCriterion("dj =", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotEqualTo(BigDecimal value) {
            addCriterion("dj <>", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjGreaterThan(BigDecimal value) {
            addCriterion("dj >", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dj >=", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjLessThan(BigDecimal value) {
            addCriterion("dj <", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dj <=", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjIn(List<BigDecimal> values) {
            addCriterion("dj in", values, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotIn(List<BigDecimal> values) {
            addCriterion("dj not in", values, "dj");
            return (Criteria) this;
        }

        public Criteria andDjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dj between", value1, value2, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dj not between", value1, value2, "dj");
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

        public Criteria andZkIsNull() {
            addCriterion("zk is null");
            return (Criteria) this;
        }

        public Criteria andZkIsNotNull() {
            addCriterion("zk is not null");
            return (Criteria) this;
        }

        public Criteria andZkEqualTo(BigDecimal value) {
            addCriterion("zk =", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotEqualTo(BigDecimal value) {
            addCriterion("zk <>", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkGreaterThan(BigDecimal value) {
            addCriterion("zk >", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zk >=", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkLessThan(BigDecimal value) {
            addCriterion("zk <", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zk <=", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkIn(List<BigDecimal> values) {
            addCriterion("zk in", values, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotIn(List<BigDecimal> values) {
            addCriterion("zk not in", values, "zk");
            return (Criteria) this;
        }

        public Criteria andZkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zk between", value1, value2, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zk not between", value1, value2, "zk");
            return (Criteria) this;
        }

        public Criteria andXsjeIsNull() {
            addCriterion("xsje is null");
            return (Criteria) this;
        }

        public Criteria andXsjeIsNotNull() {
            addCriterion("xsje is not null");
            return (Criteria) this;
        }

        public Criteria andXsjeEqualTo(BigDecimal value) {
            addCriterion("xsje =", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeNotEqualTo(BigDecimal value) {
            addCriterion("xsje <>", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeGreaterThan(BigDecimal value) {
            addCriterion("xsje >", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("xsje >=", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeLessThan(BigDecimal value) {
            addCriterion("xsje <", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("xsje <=", value, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeIn(List<BigDecimal> values) {
            addCriterion("xsje in", values, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeNotIn(List<BigDecimal> values) {
            addCriterion("xsje not in", values, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xsje between", value1, value2, "xsje");
            return (Criteria) this;
        }

        public Criteria andXsjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xsje not between", value1, value2, "xsje");
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

        public Criteria andJsjgIsNull() {
            addCriterion("jsjg is null");
            return (Criteria) this;
        }

        public Criteria andJsjgIsNotNull() {
            addCriterion("jsjg is not null");
            return (Criteria) this;
        }

        public Criteria andJsjgEqualTo(BigDecimal value) {
            addCriterion("jsjg =", value, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJsjgNotEqualTo(BigDecimal value) {
            addCriterion("jsjg <>", value, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJsjgGreaterThan(BigDecimal value) {
            addCriterion("jsjg >", value, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJsjgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jsjg >=", value, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJsjgLessThan(BigDecimal value) {
            addCriterion("jsjg <", value, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJsjgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jsjg <=", value, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJsjgIn(List<BigDecimal> values) {
            addCriterion("jsjg in", values, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJsjgNotIn(List<BigDecimal> values) {
            addCriterion("jsjg not in", values, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJsjgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jsjg between", value1, value2, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJsjgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jsjg not between", value1, value2, "jsjg");
            return (Criteria) this;
        }

        public Criteria andJishuijeIsNull() {
            addCriterion("jishuije is null");
            return (Criteria) this;
        }

        public Criteria andJishuijeIsNotNull() {
            addCriterion("jishuije is not null");
            return (Criteria) this;
        }

        public Criteria andJishuijeEqualTo(BigDecimal value) {
            addCriterion("jishuije =", value, "jishuije");
            return (Criteria) this;
        }

        public Criteria andJishuijeNotEqualTo(BigDecimal value) {
            addCriterion("jishuije <>", value, "jishuije");
            return (Criteria) this;
        }

        public Criteria andJishuijeGreaterThan(BigDecimal value) {
            addCriterion("jishuije >", value, "jishuije");
            return (Criteria) this;
        }

        public Criteria andJishuijeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jishuije >=", value, "jishuije");
            return (Criteria) this;
        }

        public Criteria andJishuijeLessThan(BigDecimal value) {
            addCriterion("jishuije <", value, "jishuije");
            return (Criteria) this;
        }

        public Criteria andJishuijeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jishuije <=", value, "jishuije");
            return (Criteria) this;
        }

        public Criteria andJishuijeIn(List<BigDecimal> values) {
            addCriterion("jishuije in", values, "jishuije");
            return (Criteria) this;
        }

        public Criteria andJishuijeNotIn(List<BigDecimal> values) {
            addCriterion("jishuije not in", values, "jishuije");
            return (Criteria) this;
        }

        public Criteria andJishuijeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jishuije between", value1, value2, "jishuije");
            return (Criteria) this;
        }

        public Criteria andJishuijeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jishuije not between", value1, value2, "jishuije");
            return (Criteria) this;
        }

        public Criteria andSkuIsNull() {
            addCriterion("sku is null");
            return (Criteria) this;
        }

        public Criteria andSkuIsNotNull() {
            addCriterion("sku is not null");
            return (Criteria) this;
        }

        public Criteria andSkuEqualTo(String value) {
            addCriterion("sku =", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotEqualTo(String value) {
            addCriterion("sku <>", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThan(String value) {
            addCriterion("sku >", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThanOrEqualTo(String value) {
            addCriterion("sku >=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThan(String value) {
            addCriterion("sku <", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThanOrEqualTo(String value) {
            addCriterion("sku <=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLike(String value) {
            addCriterion("sku like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotLike(String value) {
            addCriterion("sku not like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuIn(List<String> values) {
            addCriterion("sku in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotIn(List<String> values) {
            addCriterion("sku not in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuBetween(String value1, String value2) {
            addCriterion("sku between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotBetween(String value1, String value2) {
            addCriterion("sku not between", value1, value2, "sku");
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

        public Criteria andCbjeIsNull() {
            addCriterion("cbje is null");
            return (Criteria) this;
        }

        public Criteria andCbjeIsNotNull() {
            addCriterion("cbje is not null");
            return (Criteria) this;
        }

        public Criteria andCbjeEqualTo(BigDecimal value) {
            addCriterion("cbje =", value, "cbje");
            return (Criteria) this;
        }

        public Criteria andCbjeNotEqualTo(BigDecimal value) {
            addCriterion("cbje <>", value, "cbje");
            return (Criteria) this;
        }

        public Criteria andCbjeGreaterThan(BigDecimal value) {
            addCriterion("cbje >", value, "cbje");
            return (Criteria) this;
        }

        public Criteria andCbjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cbje >=", value, "cbje");
            return (Criteria) this;
        }

        public Criteria andCbjeLessThan(BigDecimal value) {
            addCriterion("cbje <", value, "cbje");
            return (Criteria) this;
        }

        public Criteria andCbjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cbje <=", value, "cbje");
            return (Criteria) this;
        }

        public Criteria andCbjeIn(List<BigDecimal> values) {
            addCriterion("cbje in", values, "cbje");
            return (Criteria) this;
        }

        public Criteria andCbjeNotIn(List<BigDecimal> values) {
            addCriterion("cbje not in", values, "cbje");
            return (Criteria) this;
        }

        public Criteria andCbjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cbje between", value1, value2, "cbje");
            return (Criteria) this;
        }

        public Criteria andCbjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cbje not between", value1, value2, "cbje");
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