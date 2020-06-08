package com.febs.system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GysExample() {
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

        public Criteria andGysdmIsNull() {
            addCriterion("gysdm is null");
            return (Criteria) this;
        }

        public Criteria andGysdmIsNotNull() {
            addCriterion("gysdm is not null");
            return (Criteria) this;
        }

        public Criteria andGysdmEqualTo(String value) {
            addCriterion("gysdm =", value, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmNotEqualTo(String value) {
            addCriterion("gysdm <>", value, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmGreaterThan(String value) {
            addCriterion("gysdm >", value, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmGreaterThanOrEqualTo(String value) {
            addCriterion("gysdm >=", value, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmLessThan(String value) {
            addCriterion("gysdm <", value, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmLessThanOrEqualTo(String value) {
            addCriterion("gysdm <=", value, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmLike(String value) {
            addCriterion("gysdm like", value, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmNotLike(String value) {
            addCriterion("gysdm not like", value, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmIn(List<String> values) {
            addCriterion("gysdm in", values, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmNotIn(List<String> values) {
            addCriterion("gysdm not in", values, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmBetween(String value1, String value2) {
            addCriterion("gysdm between", value1, value2, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysdmNotBetween(String value1, String value2) {
            addCriterion("gysdm not between", value1, value2, "gysdm");
            return (Criteria) this;
        }

        public Criteria andGysmcIsNull() {
            addCriterion("gysmc is null");
            return (Criteria) this;
        }

        public Criteria andGysmcIsNotNull() {
            addCriterion("gysmc is not null");
            return (Criteria) this;
        }

        public Criteria andGysmcEqualTo(String value) {
            addCriterion("gysmc =", value, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcNotEqualTo(String value) {
            addCriterion("gysmc <>", value, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcGreaterThan(String value) {
            addCriterion("gysmc >", value, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcGreaterThanOrEqualTo(String value) {
            addCriterion("gysmc >=", value, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcLessThan(String value) {
            addCriterion("gysmc <", value, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcLessThanOrEqualTo(String value) {
            addCriterion("gysmc <=", value, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcLike(String value) {
            addCriterion("gysmc like", value, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcNotLike(String value) {
            addCriterion("gysmc not like", value, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcIn(List<String> values) {
            addCriterion("gysmc in", values, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcNotIn(List<String> values) {
            addCriterion("gysmc not in", values, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcBetween(String value1, String value2) {
            addCriterion("gysmc between", value1, value2, "gysmc");
            return (Criteria) this;
        }

        public Criteria andGysmcNotBetween(String value1, String value2) {
            addCriterion("gysmc not between", value1, value2, "gysmc");
            return (Criteria) this;
        }

        public Criteria andLsrIsNull() {
            addCriterion("lsr is null");
            return (Criteria) this;
        }

        public Criteria andLsrIsNotNull() {
            addCriterion("lsr is not null");
            return (Criteria) this;
        }

        public Criteria andLsrEqualTo(String value) {
            addCriterion("lsr =", value, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrNotEqualTo(String value) {
            addCriterion("lsr <>", value, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrGreaterThan(String value) {
            addCriterion("lsr >", value, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrGreaterThanOrEqualTo(String value) {
            addCriterion("lsr >=", value, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrLessThan(String value) {
            addCriterion("lsr <", value, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrLessThanOrEqualTo(String value) {
            addCriterion("lsr <=", value, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrLike(String value) {
            addCriterion("lsr like", value, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrNotLike(String value) {
            addCriterion("lsr not like", value, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrIn(List<String> values) {
            addCriterion("lsr in", values, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrNotIn(List<String> values) {
            addCriterion("lsr not in", values, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrBetween(String value1, String value2) {
            addCriterion("lsr between", value1, value2, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrNotBetween(String value1, String value2) {
            addCriterion("lsr not between", value1, value2, "lsr");
            return (Criteria) this;
        }

        public Criteria andLsrdhIsNull() {
            addCriterion("lsrdh is null");
            return (Criteria) this;
        }

        public Criteria andLsrdhIsNotNull() {
            addCriterion("lsrdh is not null");
            return (Criteria) this;
        }

        public Criteria andLsrdhEqualTo(String value) {
            addCriterion("lsrdh =", value, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhNotEqualTo(String value) {
            addCriterion("lsrdh <>", value, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhGreaterThan(String value) {
            addCriterion("lsrdh >", value, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhGreaterThanOrEqualTo(String value) {
            addCriterion("lsrdh >=", value, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhLessThan(String value) {
            addCriterion("lsrdh <", value, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhLessThanOrEqualTo(String value) {
            addCriterion("lsrdh <=", value, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhLike(String value) {
            addCriterion("lsrdh like", value, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhNotLike(String value) {
            addCriterion("lsrdh not like", value, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhIn(List<String> values) {
            addCriterion("lsrdh in", values, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhNotIn(List<String> values) {
            addCriterion("lsrdh not in", values, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhBetween(String value1, String value2) {
            addCriterion("lsrdh between", value1, value2, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andLsrdhNotBetween(String value1, String value2) {
            addCriterion("lsrdh not between", value1, value2, "lsrdh");
            return (Criteria) this;
        }

        public Criteria andWxIsNull() {
            addCriterion("wx is null");
            return (Criteria) this;
        }

        public Criteria andWxIsNotNull() {
            addCriterion("wx is not null");
            return (Criteria) this;
        }

        public Criteria andWxEqualTo(String value) {
            addCriterion("wx =", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxNotEqualTo(String value) {
            addCriterion("wx <>", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxGreaterThan(String value) {
            addCriterion("wx >", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxGreaterThanOrEqualTo(String value) {
            addCriterion("wx >=", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxLessThan(String value) {
            addCriterion("wx <", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxLessThanOrEqualTo(String value) {
            addCriterion("wx <=", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxLike(String value) {
            addCriterion("wx like", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxNotLike(String value) {
            addCriterion("wx not like", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxIn(List<String> values) {
            addCriterion("wx in", values, "wx");
            return (Criteria) this;
        }

        public Criteria andWxNotIn(List<String> values) {
            addCriterion("wx not in", values, "wx");
            return (Criteria) this;
        }

        public Criteria andWxBetween(String value1, String value2) {
            addCriterion("wx between", value1, value2, "wx");
            return (Criteria) this;
        }

        public Criteria andWxNotBetween(String value1, String value2) {
            addCriterion("wx not between", value1, value2, "wx");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andHyIsNull() {
            addCriterion("hy is null");
            return (Criteria) this;
        }

        public Criteria andHyIsNotNull() {
            addCriterion("hy is not null");
            return (Criteria) this;
        }

        public Criteria andHyEqualTo(String value) {
            addCriterion("hy =", value, "hy");
            return (Criteria) this;
        }

        public Criteria andHyNotEqualTo(String value) {
            addCriterion("hy <>", value, "hy");
            return (Criteria) this;
        }

        public Criteria andHyGreaterThan(String value) {
            addCriterion("hy >", value, "hy");
            return (Criteria) this;
        }

        public Criteria andHyGreaterThanOrEqualTo(String value) {
            addCriterion("hy >=", value, "hy");
            return (Criteria) this;
        }

        public Criteria andHyLessThan(String value) {
            addCriterion("hy <", value, "hy");
            return (Criteria) this;
        }

        public Criteria andHyLessThanOrEqualTo(String value) {
            addCriterion("hy <=", value, "hy");
            return (Criteria) this;
        }

        public Criteria andHyLike(String value) {
            addCriterion("hy like", value, "hy");
            return (Criteria) this;
        }

        public Criteria andHyNotLike(String value) {
            addCriterion("hy not like", value, "hy");
            return (Criteria) this;
        }

        public Criteria andHyIn(List<String> values) {
            addCriterion("hy in", values, "hy");
            return (Criteria) this;
        }

        public Criteria andHyNotIn(List<String> values) {
            addCriterion("hy not in", values, "hy");
            return (Criteria) this;
        }

        public Criteria andHyBetween(String value1, String value2) {
            addCriterion("hy between", value1, value2, "hy");
            return (Criteria) this;
        }

        public Criteria andHyNotBetween(String value1, String value2) {
            addCriterion("hy not between", value1, value2, "hy");
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

        public Criteria andCgfzrEqualTo(String value) {
            addCriterion("cgfzr =", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrNotEqualTo(String value) {
            addCriterion("cgfzr <>", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrGreaterThan(String value) {
            addCriterion("cgfzr >", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrGreaterThanOrEqualTo(String value) {
            addCriterion("cgfzr >=", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrLessThan(String value) {
            addCriterion("cgfzr <", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrLessThanOrEqualTo(String value) {
            addCriterion("cgfzr <=", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrLike(String value) {
            addCriterion("cgfzr like", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrNotLike(String value) {
            addCriterion("cgfzr not like", value, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrIn(List<String> values) {
            addCriterion("cgfzr in", values, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrNotIn(List<String> values) {
            addCriterion("cgfzr not in", values, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrBetween(String value1, String value2) {
            addCriterion("cgfzr between", value1, value2, "cgfzr");
            return (Criteria) this;
        }

        public Criteria andCgfzrNotBetween(String value1, String value2) {
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

        public Criteria andXdfzrEqualTo(String value) {
            addCriterion("xdfzr =", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrNotEqualTo(String value) {
            addCriterion("xdfzr <>", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrGreaterThan(String value) {
            addCriterion("xdfzr >", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrGreaterThanOrEqualTo(String value) {
            addCriterion("xdfzr >=", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrLessThan(String value) {
            addCriterion("xdfzr <", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrLessThanOrEqualTo(String value) {
            addCriterion("xdfzr <=", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrLike(String value) {
            addCriterion("xdfzr like", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrNotLike(String value) {
            addCriterion("xdfzr not like", value, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrIn(List<String> values) {
            addCriterion("xdfzr in", values, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrNotIn(List<String> values) {
            addCriterion("xdfzr not in", values, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrBetween(String value1, String value2) {
            addCriterion("xdfzr between", value1, value2, "xdfzr");
            return (Criteria) this;
        }

        public Criteria andXdfzrNotBetween(String value1, String value2) {
            addCriterion("xdfzr not between", value1, value2, "xdfzr");
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

        public Criteria andFpsdIdIsNull() {
            addCriterion("fpsd_id is null");
            return (Criteria) this;
        }

        public Criteria andFpsdIdIsNotNull() {
            addCriterion("fpsd_id is not null");
            return (Criteria) this;
        }

        public Criteria andFpsdIdEqualTo(Integer value) {
            addCriterion("fpsd_id =", value, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andFpsdIdNotEqualTo(Integer value) {
            addCriterion("fpsd_id <>", value, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andFpsdIdGreaterThan(Integer value) {
            addCriterion("fpsd_id >", value, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andFpsdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fpsd_id >=", value, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andFpsdIdLessThan(Integer value) {
            addCriterion("fpsd_id <", value, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andFpsdIdLessThanOrEqualTo(Integer value) {
            addCriterion("fpsd_id <=", value, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andFpsdIdIn(List<Integer> values) {
            addCriterion("fpsd_id in", values, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andFpsdIdNotIn(List<Integer> values) {
            addCriterion("fpsd_id not in", values, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andFpsdIdBetween(Integer value1, Integer value2) {
            addCriterion("fpsd_id between", value1, value2, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andFpsdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fpsd_id not between", value1, value2, "fpsdId");
            return (Criteria) this;
        }

        public Criteria andSfyjIsNull() {
            addCriterion("sfyj is null");
            return (Criteria) this;
        }

        public Criteria andSfyjIsNotNull() {
            addCriterion("sfyj is not null");
            return (Criteria) this;
        }

        public Criteria andSfyjEqualTo(String value) {
            addCriterion("sfyj =", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjNotEqualTo(String value) {
            addCriterion("sfyj <>", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjGreaterThan(String value) {
            addCriterion("sfyj >", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjGreaterThanOrEqualTo(String value) {
            addCriterion("sfyj >=", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjLessThan(String value) {
            addCriterion("sfyj <", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjLessThanOrEqualTo(String value) {
            addCriterion("sfyj <=", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjLike(String value) {
            addCriterion("sfyj like", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjNotLike(String value) {
            addCriterion("sfyj not like", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjIn(List<String> values) {
            addCriterion("sfyj in", values, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjNotIn(List<String> values) {
            addCriterion("sfyj not in", values, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjBetween(String value1, String value2) {
            addCriterion("sfyj between", value1, value2, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjNotBetween(String value1, String value2) {
            addCriterion("sfyj not between", value1, value2, "sfyj");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
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