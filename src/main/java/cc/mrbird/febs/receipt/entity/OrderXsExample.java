package cc.mrbird.febs.receipt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderXsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderXsExample() {
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

        public Criteria andXdrqEqualTo(Integer value) {
            addCriterion("xdrq =", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqNotEqualTo(Integer value) {
            addCriterion("xdrq <>", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqGreaterThan(Integer value) {
            addCriterion("xdrq >", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("xdrq >=", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqLessThan(Integer value) {
            addCriterion("xdrq <", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqLessThanOrEqualTo(Integer value) {
            addCriterion("xdrq <=", value, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqIn(List<Integer> values) {
            addCriterion("xdrq in", values, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqNotIn(List<Integer> values) {
            addCriterion("xdrq not in", values, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqBetween(Integer value1, Integer value2) {
            addCriterion("xdrq between", value1, value2, "xdrq");
            return (Criteria) this;
        }

        public Criteria andXdrqNotBetween(Integer value1, Integer value2) {
            addCriterion("xdrq not between", value1, value2, "xdrq");
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andKehuIdIsNull() {
            addCriterion("kehu_id is null");
            return (Criteria) this;
        }

        public Criteria andKehuIdIsNotNull() {
            addCriterion("kehu_id is not null");
            return (Criteria) this;
        }

        public Criteria andKehuIdEqualTo(Integer value) {
            addCriterion("kehu_id =", value, "kehuId");
            return (Criteria) this;
        }

        public Criteria andKehuIdNotEqualTo(Integer value) {
            addCriterion("kehu_id <>", value, "kehuId");
            return (Criteria) this;
        }

        public Criteria andKehuIdGreaterThan(Integer value) {
            addCriterion("kehu_id >", value, "kehuId");
            return (Criteria) this;
        }

        public Criteria andKehuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("kehu_id >=", value, "kehuId");
            return (Criteria) this;
        }

        public Criteria andKehuIdLessThan(Integer value) {
            addCriterion("kehu_id <", value, "kehuId");
            return (Criteria) this;
        }

        public Criteria andKehuIdLessThanOrEqualTo(Integer value) {
            addCriterion("kehu_id <=", value, "kehuId");
            return (Criteria) this;
        }

        public Criteria andKehuIdIn(List<Integer> values) {
            addCriterion("kehu_id in", values, "kehuId");
            return (Criteria) this;
        }

        public Criteria andKehuIdNotIn(List<Integer> values) {
            addCriterion("kehu_id not in", values, "kehuId");
            return (Criteria) this;
        }

        public Criteria andKehuIdBetween(Integer value1, Integer value2) {
            addCriterion("kehu_id between", value1, value2, "kehuId");
            return (Criteria) this;
        }

        public Criteria andKehuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("kehu_id not between", value1, value2, "kehuId");
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

        public Criteria andKhlyIdIsNull() {
            addCriterion("khly_id is null");
            return (Criteria) this;
        }

        public Criteria andKhlyIdIsNotNull() {
            addCriterion("khly_id is not null");
            return (Criteria) this;
        }

        public Criteria andKhlyIdEqualTo(Integer value) {
            addCriterion("khly_id =", value, "khlyId");
            return (Criteria) this;
        }

        public Criteria andKhlyIdNotEqualTo(Integer value) {
            addCriterion("khly_id <>", value, "khlyId");
            return (Criteria) this;
        }

        public Criteria andKhlyIdGreaterThan(Integer value) {
            addCriterion("khly_id >", value, "khlyId");
            return (Criteria) this;
        }

        public Criteria andKhlyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("khly_id >=", value, "khlyId");
            return (Criteria) this;
        }

        public Criteria andKhlyIdLessThan(Integer value) {
            addCriterion("khly_id <", value, "khlyId");
            return (Criteria) this;
        }

        public Criteria andKhlyIdLessThanOrEqualTo(Integer value) {
            addCriterion("khly_id <=", value, "khlyId");
            return (Criteria) this;
        }

        public Criteria andKhlyIdIn(List<Integer> values) {
            addCriterion("khly_id in", values, "khlyId");
            return (Criteria) this;
        }

        public Criteria andKhlyIdNotIn(List<Integer> values) {
            addCriterion("khly_id not in", values, "khlyId");
            return (Criteria) this;
        }

        public Criteria andKhlyIdBetween(Integer value1, Integer value2) {
            addCriterion("khly_id between", value1, value2, "khlyId");
            return (Criteria) this;
        }

        public Criteria andKhlyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("khly_id not between", value1, value2, "khlyId");
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

        public Criteria andKhqyIdIsNull() {
            addCriterion("khqy_id is null");
            return (Criteria) this;
        }

        public Criteria andKhqyIdIsNotNull() {
            addCriterion("khqy_id is not null");
            return (Criteria) this;
        }

        public Criteria andKhqyIdEqualTo(Integer value) {
            addCriterion("khqy_id =", value, "khqyId");
            return (Criteria) this;
        }

        public Criteria andKhqyIdNotEqualTo(Integer value) {
            addCriterion("khqy_id <>", value, "khqyId");
            return (Criteria) this;
        }

        public Criteria andKhqyIdGreaterThan(Integer value) {
            addCriterion("khqy_id >", value, "khqyId");
            return (Criteria) this;
        }

        public Criteria andKhqyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("khqy_id >=", value, "khqyId");
            return (Criteria) this;
        }

        public Criteria andKhqyIdLessThan(Integer value) {
            addCriterion("khqy_id <", value, "khqyId");
            return (Criteria) this;
        }

        public Criteria andKhqyIdLessThanOrEqualTo(Integer value) {
            addCriterion("khqy_id <=", value, "khqyId");
            return (Criteria) this;
        }

        public Criteria andKhqyIdIn(List<Integer> values) {
            addCriterion("khqy_id in", values, "khqyId");
            return (Criteria) this;
        }

        public Criteria andKhqyIdNotIn(List<Integer> values) {
            addCriterion("khqy_id not in", values, "khqyId");
            return (Criteria) this;
        }

        public Criteria andKhqyIdBetween(Integer value1, Integer value2) {
            addCriterion("khqy_id between", value1, value2, "khqyId");
            return (Criteria) this;
        }

        public Criteria andKhqyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("khqy_id not between", value1, value2, "khqyId");
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

        public Criteria andYqdhrqEqualTo(Integer value) {
            addCriterion("yqdhrq =", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqNotEqualTo(Integer value) {
            addCriterion("yqdhrq <>", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqGreaterThan(Integer value) {
            addCriterion("yqdhrq >", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("yqdhrq >=", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqLessThan(Integer value) {
            addCriterion("yqdhrq <", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqLessThanOrEqualTo(Integer value) {
            addCriterion("yqdhrq <=", value, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqIn(List<Integer> values) {
            addCriterion("yqdhrq in", values, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqNotIn(List<Integer> values) {
            addCriterion("yqdhrq not in", values, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqBetween(Integer value1, Integer value2) {
            addCriterion("yqdhrq between", value1, value2, "yqdhrq");
            return (Criteria) this;
        }

        public Criteria andYqdhrqNotBetween(Integer value1, Integer value2) {
            addCriterion("yqdhrq not between", value1, value2, "yqdhrq");
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

        public Criteria andZdrqEqualTo(Integer value) {
            addCriterion("zdrq =", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqNotEqualTo(Integer value) {
            addCriterion("zdrq <>", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqGreaterThan(Integer value) {
            addCriterion("zdrq >", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("zdrq >=", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqLessThan(Integer value) {
            addCriterion("zdrq <", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqLessThanOrEqualTo(Integer value) {
            addCriterion("zdrq <=", value, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqIn(List<Integer> values) {
            addCriterion("zdrq in", values, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqNotIn(List<Integer> values) {
            addCriterion("zdrq not in", values, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqBetween(Integer value1, Integer value2) {
            addCriterion("zdrq between", value1, value2, "zdrq");
            return (Criteria) this;
        }

        public Criteria andZdrqNotBetween(Integer value1, Integer value2) {
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

        public Criteria andQrrqEqualTo(Integer value) {
            addCriterion("qrrq =", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqNotEqualTo(Integer value) {
            addCriterion("qrrq <>", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqGreaterThan(Integer value) {
            addCriterion("qrrq >", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("qrrq >=", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqLessThan(Integer value) {
            addCriterion("qrrq <", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqLessThanOrEqualTo(Integer value) {
            addCriterion("qrrq <=", value, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqIn(List<Integer> values) {
            addCriterion("qrrq in", values, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqNotIn(List<Integer> values) {
            addCriterion("qrrq not in", values, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqBetween(Integer value1, Integer value2) {
            addCriterion("qrrq between", value1, value2, "qrrq");
            return (Criteria) this;
        }

        public Criteria andQrrqNotBetween(Integer value1, Integer value2) {
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

        public Criteria andShrqEqualTo(Integer value) {
            addCriterion("shrq =", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotEqualTo(Integer value) {
            addCriterion("shrq <>", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqGreaterThan(Integer value) {
            addCriterion("shrq >", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("shrq >=", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqLessThan(Integer value) {
            addCriterion("shrq <", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqLessThanOrEqualTo(Integer value) {
            addCriterion("shrq <=", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqIn(List<Integer> values) {
            addCriterion("shrq in", values, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotIn(List<Integer> values) {
            addCriterion("shrq not in", values, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqBetween(Integer value1, Integer value2) {
            addCriterion("shrq between", value1, value2, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotBetween(Integer value1, Integer value2) {
            addCriterion("shrq not between", value1, value2, "shrq");
            return (Criteria) this;
        }

        public Criteria andZxIsNull() {
            addCriterion("zx is null");
            return (Criteria) this;
        }

        public Criteria andZxIsNotNull() {
            addCriterion("zx is not null");
            return (Criteria) this;
        }

        public Criteria andZxEqualTo(Byte value) {
            addCriterion("zx =", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxNotEqualTo(Byte value) {
            addCriterion("zx <>", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxGreaterThan(Byte value) {
            addCriterion("zx >", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxGreaterThanOrEqualTo(Byte value) {
            addCriterion("zx >=", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxLessThan(Byte value) {
            addCriterion("zx <", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxLessThanOrEqualTo(Byte value) {
            addCriterion("zx <=", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxIn(List<Byte> values) {
            addCriterion("zx in", values, "zx");
            return (Criteria) this;
        }

        public Criteria andZxNotIn(List<Byte> values) {
            addCriterion("zx not in", values, "zx");
            return (Criteria) this;
        }

        public Criteria andZxBetween(Byte value1, Byte value2) {
            addCriterion("zx between", value1, value2, "zx");
            return (Criteria) this;
        }

        public Criteria andZxNotBetween(Byte value1, Byte value2) {
            addCriterion("zx not between", value1, value2, "zx");
            return (Criteria) this;
        }

        public Criteria andZxrIsNull() {
            addCriterion("zxr is null");
            return (Criteria) this;
        }

        public Criteria andZxrIsNotNull() {
            addCriterion("zxr is not null");
            return (Criteria) this;
        }

        public Criteria andZxrEqualTo(String value) {
            addCriterion("zxr =", value, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrNotEqualTo(String value) {
            addCriterion("zxr <>", value, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrGreaterThan(String value) {
            addCriterion("zxr >", value, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrGreaterThanOrEqualTo(String value) {
            addCriterion("zxr >=", value, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrLessThan(String value) {
            addCriterion("zxr <", value, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrLessThanOrEqualTo(String value) {
            addCriterion("zxr <=", value, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrLike(String value) {
            addCriterion("zxr like", value, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrNotLike(String value) {
            addCriterion("zxr not like", value, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrIn(List<String> values) {
            addCriterion("zxr in", values, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrNotIn(List<String> values) {
            addCriterion("zxr not in", values, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrBetween(String value1, String value2) {
            addCriterion("zxr between", value1, value2, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrNotBetween(String value1, String value2) {
            addCriterion("zxr not between", value1, value2, "zxr");
            return (Criteria) this;
        }

        public Criteria andZxrqIsNull() {
            addCriterion("zxrq is null");
            return (Criteria) this;
        }

        public Criteria andZxrqIsNotNull() {
            addCriterion("zxrq is not null");
            return (Criteria) this;
        }

        public Criteria andZxrqEqualTo(Integer value) {
            addCriterion("zxrq =", value, "zxrq");
            return (Criteria) this;
        }

        public Criteria andZxrqNotEqualTo(Integer value) {
            addCriterion("zxrq <>", value, "zxrq");
            return (Criteria) this;
        }

        public Criteria andZxrqGreaterThan(Integer value) {
            addCriterion("zxrq >", value, "zxrq");
            return (Criteria) this;
        }

        public Criteria andZxrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("zxrq >=", value, "zxrq");
            return (Criteria) this;
        }

        public Criteria andZxrqLessThan(Integer value) {
            addCriterion("zxrq <", value, "zxrq");
            return (Criteria) this;
        }

        public Criteria andZxrqLessThanOrEqualTo(Integer value) {
            addCriterion("zxrq <=", value, "zxrq");
            return (Criteria) this;
        }

        public Criteria andZxrqIn(List<Integer> values) {
            addCriterion("zxrq in", values, "zxrq");
            return (Criteria) this;
        }

        public Criteria andZxrqNotIn(List<Integer> values) {
            addCriterion("zxrq not in", values, "zxrq");
            return (Criteria) this;
        }

        public Criteria andZxrqBetween(Integer value1, Integer value2) {
            addCriterion("zxrq between", value1, value2, "zxrq");
            return (Criteria) this;
        }

        public Criteria andZxrqNotBetween(Integer value1, Integer value2) {
            addCriterion("zxrq not between", value1, value2, "zxrq");
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

        public Criteria andKsfhrqEqualTo(Integer value) {
            addCriterion("ksfhrq =", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqNotEqualTo(Integer value) {
            addCriterion("ksfhrq <>", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqGreaterThan(Integer value) {
            addCriterion("ksfhrq >", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("ksfhrq >=", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqLessThan(Integer value) {
            addCriterion("ksfhrq <", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqLessThanOrEqualTo(Integer value) {
            addCriterion("ksfhrq <=", value, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqIn(List<Integer> values) {
            addCriterion("ksfhrq in", values, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqNotIn(List<Integer> values) {
            addCriterion("ksfhrq not in", values, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqBetween(Integer value1, Integer value2) {
            addCriterion("ksfhrq between", value1, value2, "ksfhrq");
            return (Criteria) this;
        }

        public Criteria andKsfhrqNotBetween(Integer value1, Integer value2) {
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

        public Criteria andKsphrqEqualTo(Integer value) {
            addCriterion("ksphrq =", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqNotEqualTo(Integer value) {
            addCriterion("ksphrq <>", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqGreaterThan(Integer value) {
            addCriterion("ksphrq >", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("ksphrq >=", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqLessThan(Integer value) {
            addCriterion("ksphrq <", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqLessThanOrEqualTo(Integer value) {
            addCriterion("ksphrq <=", value, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqIn(List<Integer> values) {
            addCriterion("ksphrq in", values, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqNotIn(List<Integer> values) {
            addCriterion("ksphrq not in", values, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqBetween(Integer value1, Integer value2) {
            addCriterion("ksphrq between", value1, value2, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andKsphrqNotBetween(Integer value1, Integer value2) {
            addCriterion("ksphrq not between", value1, value2, "ksphrq");
            return (Criteria) this;
        }

        public Criteria andBhfhIsNull() {
            addCriterion("bhfh is null");
            return (Criteria) this;
        }

        public Criteria andBhfhIsNotNull() {
            addCriterion("bhfh is not null");
            return (Criteria) this;
        }

        public Criteria andBhfhEqualTo(Byte value) {
            addCriterion("bhfh =", value, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhNotEqualTo(Byte value) {
            addCriterion("bhfh <>", value, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhGreaterThan(Byte value) {
            addCriterion("bhfh >", value, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhGreaterThanOrEqualTo(Byte value) {
            addCriterion("bhfh >=", value, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhLessThan(Byte value) {
            addCriterion("bhfh <", value, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhLessThanOrEqualTo(Byte value) {
            addCriterion("bhfh <=", value, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhIn(List<Byte> values) {
            addCriterion("bhfh in", values, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhNotIn(List<Byte> values) {
            addCriterion("bhfh not in", values, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhBetween(Byte value1, Byte value2) {
            addCriterion("bhfh between", value1, value2, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhNotBetween(Byte value1, Byte value2) {
            addCriterion("bhfh not between", value1, value2, "bhfh");
            return (Criteria) this;
        }

        public Criteria andBhfhrIsNull() {
            addCriterion("bhfhr is null");
            return (Criteria) this;
        }

        public Criteria andBhfhrIsNotNull() {
            addCriterion("bhfhr is not null");
            return (Criteria) this;
        }

        public Criteria andBhfhrEqualTo(String value) {
            addCriterion("bhfhr =", value, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrNotEqualTo(String value) {
            addCriterion("bhfhr <>", value, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrGreaterThan(String value) {
            addCriterion("bhfhr >", value, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrGreaterThanOrEqualTo(String value) {
            addCriterion("bhfhr >=", value, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrLessThan(String value) {
            addCriterion("bhfhr <", value, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrLessThanOrEqualTo(String value) {
            addCriterion("bhfhr <=", value, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrLike(String value) {
            addCriterion("bhfhr like", value, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrNotLike(String value) {
            addCriterion("bhfhr not like", value, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrIn(List<String> values) {
            addCriterion("bhfhr in", values, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrNotIn(List<String> values) {
            addCriterion("bhfhr not in", values, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrBetween(String value1, String value2) {
            addCriterion("bhfhr between", value1, value2, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrNotBetween(String value1, String value2) {
            addCriterion("bhfhr not between", value1, value2, "bhfhr");
            return (Criteria) this;
        }

        public Criteria andBhfhrqIsNull() {
            addCriterion("bhfhrq is null");
            return (Criteria) this;
        }

        public Criteria andBhfhrqIsNotNull() {
            addCriterion("bhfhrq is not null");
            return (Criteria) this;
        }

        public Criteria andBhfhrqEqualTo(Integer value) {
            addCriterion("bhfhrq =", value, "bhfhrq");
            return (Criteria) this;
        }

        public Criteria andBhfhrqNotEqualTo(Integer value) {
            addCriterion("bhfhrq <>", value, "bhfhrq");
            return (Criteria) this;
        }

        public Criteria andBhfhrqGreaterThan(Integer value) {
            addCriterion("bhfhrq >", value, "bhfhrq");
            return (Criteria) this;
        }

        public Criteria andBhfhrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("bhfhrq >=", value, "bhfhrq");
            return (Criteria) this;
        }

        public Criteria andBhfhrqLessThan(Integer value) {
            addCriterion("bhfhrq <", value, "bhfhrq");
            return (Criteria) this;
        }

        public Criteria andBhfhrqLessThanOrEqualTo(Integer value) {
            addCriterion("bhfhrq <=", value, "bhfhrq");
            return (Criteria) this;
        }

        public Criteria andBhfhrqIn(List<Integer> values) {
            addCriterion("bhfhrq in", values, "bhfhrq");
            return (Criteria) this;
        }

        public Criteria andBhfhrqNotIn(List<Integer> values) {
            addCriterion("bhfhrq not in", values, "bhfhrq");
            return (Criteria) this;
        }

        public Criteria andBhfhrqBetween(Integer value1, Integer value2) {
            addCriterion("bhfhrq between", value1, value2, "bhfhrq");
            return (Criteria) this;
        }

        public Criteria andBhfhrqNotBetween(Integer value1, Integer value2) {
            addCriterion("bhfhrq not between", value1, value2, "bhfhrq");
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

        public Criteria andYflrrqEqualTo(Integer value) {
            addCriterion("yflrrq =", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqNotEqualTo(Integer value) {
            addCriterion("yflrrq <>", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqGreaterThan(Integer value) {
            addCriterion("yflrrq >", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("yflrrq >=", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqLessThan(Integer value) {
            addCriterion("yflrrq <", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqLessThanOrEqualTo(Integer value) {
            addCriterion("yflrrq <=", value, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqIn(List<Integer> values) {
            addCriterion("yflrrq in", values, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqNotIn(List<Integer> values) {
            addCriterion("yflrrq not in", values, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqBetween(Integer value1, Integer value2) {
            addCriterion("yflrrq between", value1, value2, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andYflrrqNotBetween(Integer value1, Integer value2) {
            addCriterion("yflrrq not between", value1, value2, "yflrrq");
            return (Criteria) this;
        }

        public Criteria andSctkIsNull() {
            addCriterion("sctk is null");
            return (Criteria) this;
        }

        public Criteria andSctkIsNotNull() {
            addCriterion("sctk is not null");
            return (Criteria) this;
        }

        public Criteria andSctkEqualTo(Byte value) {
            addCriterion("sctk =", value, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkNotEqualTo(Byte value) {
            addCriterion("sctk <>", value, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkGreaterThan(Byte value) {
            addCriterion("sctk >", value, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkGreaterThanOrEqualTo(Byte value) {
            addCriterion("sctk >=", value, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkLessThan(Byte value) {
            addCriterion("sctk <", value, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkLessThanOrEqualTo(Byte value) {
            addCriterion("sctk <=", value, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkIn(List<Byte> values) {
            addCriterion("sctk in", values, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkNotIn(List<Byte> values) {
            addCriterion("sctk not in", values, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkBetween(Byte value1, Byte value2) {
            addCriterion("sctk between", value1, value2, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkNotBetween(Byte value1, Byte value2) {
            addCriterion("sctk not between", value1, value2, "sctk");
            return (Criteria) this;
        }

        public Criteria andSctkrIsNull() {
            addCriterion("sctkr is null");
            return (Criteria) this;
        }

        public Criteria andSctkrIsNotNull() {
            addCriterion("sctkr is not null");
            return (Criteria) this;
        }

        public Criteria andSctkrEqualTo(String value) {
            addCriterion("sctkr =", value, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrNotEqualTo(String value) {
            addCriterion("sctkr <>", value, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrGreaterThan(String value) {
            addCriterion("sctkr >", value, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrGreaterThanOrEqualTo(String value) {
            addCriterion("sctkr >=", value, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrLessThan(String value) {
            addCriterion("sctkr <", value, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrLessThanOrEqualTo(String value) {
            addCriterion("sctkr <=", value, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrLike(String value) {
            addCriterion("sctkr like", value, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrNotLike(String value) {
            addCriterion("sctkr not like", value, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrIn(List<String> values) {
            addCriterion("sctkr in", values, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrNotIn(List<String> values) {
            addCriterion("sctkr not in", values, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrBetween(String value1, String value2) {
            addCriterion("sctkr between", value1, value2, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrNotBetween(String value1, String value2) {
            addCriterion("sctkr not between", value1, value2, "sctkr");
            return (Criteria) this;
        }

        public Criteria andSctkrqIsNull() {
            addCriterion("sctkrq is null");
            return (Criteria) this;
        }

        public Criteria andSctkrqIsNotNull() {
            addCriterion("sctkrq is not null");
            return (Criteria) this;
        }

        public Criteria andSctkrqEqualTo(Integer value) {
            addCriterion("sctkrq =", value, "sctkrq");
            return (Criteria) this;
        }

        public Criteria andSctkrqNotEqualTo(Integer value) {
            addCriterion("sctkrq <>", value, "sctkrq");
            return (Criteria) this;
        }

        public Criteria andSctkrqGreaterThan(Integer value) {
            addCriterion("sctkrq >", value, "sctkrq");
            return (Criteria) this;
        }

        public Criteria andSctkrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("sctkrq >=", value, "sctkrq");
            return (Criteria) this;
        }

        public Criteria andSctkrqLessThan(Integer value) {
            addCriterion("sctkrq <", value, "sctkrq");
            return (Criteria) this;
        }

        public Criteria andSctkrqLessThanOrEqualTo(Integer value) {
            addCriterion("sctkrq <=", value, "sctkrq");
            return (Criteria) this;
        }

        public Criteria andSctkrqIn(List<Integer> values) {
            addCriterion("sctkrq in", values, "sctkrq");
            return (Criteria) this;
        }

        public Criteria andSctkrqNotIn(List<Integer> values) {
            addCriterion("sctkrq not in", values, "sctkrq");
            return (Criteria) this;
        }

        public Criteria andSctkrqBetween(Integer value1, Integer value2) {
            addCriterion("sctkrq between", value1, value2, "sctkrq");
            return (Criteria) this;
        }

        public Criteria andSctkrqNotBetween(Integer value1, Integer value2) {
            addCriterion("sctkrq not between", value1, value2, "sctkrq");
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

        public Criteria andZsrqEqualTo(Integer value) {
            addCriterion("zsrq =", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqNotEqualTo(Integer value) {
            addCriterion("zsrq <>", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqGreaterThan(Integer value) {
            addCriterion("zsrq >", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("zsrq >=", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqLessThan(Integer value) {
            addCriterion("zsrq <", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqLessThanOrEqualTo(Integer value) {
            addCriterion("zsrq <=", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqIn(List<Integer> values) {
            addCriterion("zsrq in", values, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqNotIn(List<Integer> values) {
            addCriterion("zsrq not in", values, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqBetween(Integer value1, Integer value2) {
            addCriterion("zsrq between", value1, value2, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqNotBetween(Integer value1, Integer value2) {
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

        public Criteria andZfrqEqualTo(Integer value) {
            addCriterion("zfrq =", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqNotEqualTo(Integer value) {
            addCriterion("zfrq <>", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqGreaterThan(Integer value) {
            addCriterion("zfrq >", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("zfrq >=", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqLessThan(Integer value) {
            addCriterion("zfrq <", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqLessThanOrEqualTo(Integer value) {
            addCriterion("zfrq <=", value, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqIn(List<Integer> values) {
            addCriterion("zfrq in", values, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqNotIn(List<Integer> values) {
            addCriterion("zfrq not in", values, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqBetween(Integer value1, Integer value2) {
            addCriterion("zfrq between", value1, value2, "zfrq");
            return (Criteria) this;
        }

        public Criteria andZfrqNotBetween(Integer value1, Integer value2) {
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