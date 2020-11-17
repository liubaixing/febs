package com.febs.shangpin.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: Temp
 * @Description:
 * @Author:
 * @Date 2020/11/17
 * @Version 1.0
 */
public class Temp {

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List< Criterion> getAllCriteria() {
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

        
        
        
        public Criteria andQttmIsNull() {
            addCriterion("qttm is null");
            return ( Criteria) this;
        }

        public  Criteria andQttmIsNotNull() {
            addCriterion("qttm is not null");
            return ( Criteria) this;
        }

        public  Criteria andQttmEqualTo(String value) {
            addCriterion("qttm =", value, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmNotEqualTo(String value) {
            addCriterion("qttm <>", value, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmGreaterThan(String value) {
            addCriterion("qttm >", value, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmGreaterThanOrEqualTo(String value) {
            addCriterion("qttm >=", value, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmLessThan(String value) {
            addCriterion("qttm <", value, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmLessThanOrEqualTo(String value) {
            addCriterion("qttm <=", value, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmLike(String value) {
            addCriterion("qttm like", value, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmNotLike(String value) {
            addCriterion("qttm not like", value, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmIn(List<String> values) {
            addCriterion("qttm in", values, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmNotIn(List<String> values) {
            addCriterion("qttm not in", values, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmBetween(String value1, String value2) {
            addCriterion("qttm between", value1, value2, "qttm");
            return (Criteria) this;
        }

        public Criteria andQttmNotBetween(String value1, String value2) {
            addCriterion("qttm not between", value1, value2, "qttm");
            return (Criteria) this;
        }

    }

    public static class Criteria extends  GeneratedCriteria {
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
