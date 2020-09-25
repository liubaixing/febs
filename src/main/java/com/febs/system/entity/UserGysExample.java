package com.febs.system.entity;

import java.util.ArrayList;
import java.util.List;

public class UserGysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserGysExample() {
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

        public Criteria andUserGysIdIsNull() {
            addCriterion("user_gys_id is null");
            return (Criteria) this;
        }

        public Criteria andUserGysIdIsNotNull() {
            addCriterion("user_gys_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserGysIdEqualTo(Long value) {
            addCriterion("user_gys_id =", value, "userGysId");
            return (Criteria) this;
        }

        public Criteria andUserGysIdNotEqualTo(Long value) {
            addCriterion("user_gys_id <>", value, "userGysId");
            return (Criteria) this;
        }

        public Criteria andUserGysIdGreaterThan(Long value) {
            addCriterion("user_gys_id >", value, "userGysId");
            return (Criteria) this;
        }

        public Criteria andUserGysIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_gys_id >=", value, "userGysId");
            return (Criteria) this;
        }

        public Criteria andUserGysIdLessThan(Long value) {
            addCriterion("user_gys_id <", value, "userGysId");
            return (Criteria) this;
        }

        public Criteria andUserGysIdLessThanOrEqualTo(Long value) {
            addCriterion("user_gys_id <=", value, "userGysId");
            return (Criteria) this;
        }

        public Criteria andUserGysIdIn(List<Long> values) {
            addCriterion("user_gys_id in", values, "userGysId");
            return (Criteria) this;
        }

        public Criteria andUserGysIdNotIn(List<Long> values) {
            addCriterion("user_gys_id not in", values, "userGysId");
            return (Criteria) this;
        }

        public Criteria andUserGysIdBetween(Long value1, Long value2) {
            addCriterion("user_gys_id between", value1, value2, "userGysId");
            return (Criteria) this;
        }

        public Criteria andUserGysIdNotBetween(Long value1, Long value2) {
            addCriterion("user_gys_id not between", value1, value2, "userGysId");
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

        public Criteria andGysIdIsNull() {
            addCriterion("gys_id is null");
            return (Criteria) this;
        }

        public Criteria andGysIdIsNotNull() {
            addCriterion("gys_id is not null");
            return (Criteria) this;
        }

        public Criteria andGysIdEqualTo(Long value) {
            addCriterion("gys_id =", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdNotEqualTo(Long value) {
            addCriterion("gys_id <>", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdGreaterThan(Long value) {
            addCriterion("gys_id >", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gys_id >=", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdLessThan(Long value) {
            addCriterion("gys_id <", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdLessThanOrEqualTo(Long value) {
            addCriterion("gys_id <=", value, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdIn(List<Long> values) {
            addCriterion("gys_id in", values, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdNotIn(List<Long> values) {
            addCriterion("gys_id not in", values, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdBetween(Long value1, Long value2) {
            addCriterion("gys_id between", value1, value2, "gysId");
            return (Criteria) this;
        }

        public Criteria andGysIdNotBetween(Long value1, Long value2) {
            addCriterion("gys_id not between", value1, value2, "gysId");
            return (Criteria) this;
        }

        public Criteria andControlStatusIsNull() {
            addCriterion("control_status is null");
            return (Criteria) this;
        }

        public Criteria andControlStatusIsNotNull() {
            addCriterion("control_status is not null");
            return (Criteria) this;
        }

        public Criteria andControlStatusEqualTo(String value) {
            addCriterion("control_status =", value, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusNotEqualTo(String value) {
            addCriterion("control_status <>", value, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusGreaterThan(String value) {
            addCriterion("control_status >", value, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusGreaterThanOrEqualTo(String value) {
            addCriterion("control_status >=", value, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusLessThan(String value) {
            addCriterion("control_status <", value, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusLessThanOrEqualTo(String value) {
            addCriterion("control_status <=", value, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusLike(String value) {
            addCriterion("control_status like", value, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusNotLike(String value) {
            addCriterion("control_status not like", value, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusIn(List<String> values) {
            addCriterion("control_status in", values, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusNotIn(List<String> values) {
            addCriterion("control_status not in", values, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusBetween(String value1, String value2) {
            addCriterion("control_status between", value1, value2, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andControlStatusNotBetween(String value1, String value2) {
            addCriterion("control_status not between", value1, value2, "controlStatus");
            return (Criteria) this;
        }

        public Criteria andExtrasIsNull() {
            addCriterion("extras is null");
            return (Criteria) this;
        }

        public Criteria andExtrasIsNotNull() {
            addCriterion("extras is not null");
            return (Criteria) this;
        }

        public Criteria andExtrasEqualTo(String value) {
            addCriterion("extras =", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotEqualTo(String value) {
            addCriterion("extras <>", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasGreaterThan(String value) {
            addCriterion("extras >", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasGreaterThanOrEqualTo(String value) {
            addCriterion("extras >=", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasLessThan(String value) {
            addCriterion("extras <", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasLessThanOrEqualTo(String value) {
            addCriterion("extras <=", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasLike(String value) {
            addCriterion("extras like", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotLike(String value) {
            addCriterion("extras not like", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasIn(List<String> values) {
            addCriterion("extras in", values, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotIn(List<String> values) {
            addCriterion("extras not in", values, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasBetween(String value1, String value2) {
            addCriterion("extras between", value1, value2, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotBetween(String value1, String value2) {
            addCriterion("extras not between", value1, value2, "extras");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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