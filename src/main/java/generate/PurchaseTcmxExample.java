package generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseTcmxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchaseTcmxExample() {
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