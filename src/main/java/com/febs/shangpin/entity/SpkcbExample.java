package com.febs.shangpin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpkcbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpkcbExample() {
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

        public Criteria andCkIdIsNull() {
            addCriterion("ck_id is null");
            return (Criteria) this;
        }

        public Criteria andCkIdIsNotNull() {
            addCriterion("ck_id is not null");
            return (Criteria) this;
        }

        public Criteria andCkIdEqualTo(Integer value) {
            addCriterion("ck_id =", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdNotEqualTo(Integer value) {
            addCriterion("ck_id <>", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdGreaterThan(Integer value) {
            addCriterion("ck_id >", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ck_id >=", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdLessThan(Integer value) {
            addCriterion("ck_id <", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdLessThanOrEqualTo(Integer value) {
            addCriterion("ck_id <=", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdIn(List<Integer> values) {
            addCriterion("ck_id in", values, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdNotIn(List<Integer> values) {
            addCriterion("ck_id not in", values, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdBetween(Integer value1, Integer value2) {
            addCriterion("ck_id between", value1, value2, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ck_id not between", value1, value2, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkNameIsNull() {
            addCriterion("ck_name is null");
            return (Criteria) this;
        }

        public Criteria andCkNameIsNotNull() {
            addCriterion("ck_name is not null");
            return (Criteria) this;
        }

        public Criteria andCkNameEqualTo(String value) {
            addCriterion("ck_name =", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameNotEqualTo(String value) {
            addCriterion("ck_name <>", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameGreaterThan(String value) {
            addCriterion("ck_name >", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameGreaterThanOrEqualTo(String value) {
            addCriterion("ck_name >=", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameLessThan(String value) {
            addCriterion("ck_name <", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameLessThanOrEqualTo(String value) {
            addCriterion("ck_name <=", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameLike(String value) {
            addCriterion("ck_name like", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameNotLike(String value) {
            addCriterion("ck_name not like", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameIn(List<String> values) {
            addCriterion("ck_name in", values, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameNotIn(List<String> values) {
            addCriterion("ck_name not in", values, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameBetween(String value1, String value2) {
            addCriterion("ck_name between", value1, value2, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameNotBetween(String value1, String value2) {
            addCriterion("ck_name not between", value1, value2, "ckName");
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

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Integer value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Integer value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Integer value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Integer value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Integer> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Integer> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Integer value1, Integer value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNull() {
            addCriterion("color_id is null");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNotNull() {
            addCriterion("color_id is not null");
            return (Criteria) this;
        }

        public Criteria andColorIdEqualTo(Integer value) {
            addCriterion("color_id =", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotEqualTo(Integer value) {
            addCriterion("color_id <>", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThan(Integer value) {
            addCriterion("color_id >", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("color_id >=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThan(Integer value) {
            addCriterion("color_id <", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThanOrEqualTo(Integer value) {
            addCriterion("color_id <=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdIn(List<Integer> values) {
            addCriterion("color_id in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotIn(List<Integer> values) {
            addCriterion("color_id not in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdBetween(Integer value1, Integer value2) {
            addCriterion("color_id between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("color_id not between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andSizeIdIsNull() {
            addCriterion("size_id is null");
            return (Criteria) this;
        }

        public Criteria andSizeIdIsNotNull() {
            addCriterion("size_id is not null");
            return (Criteria) this;
        }

        public Criteria andSizeIdEqualTo(Integer value) {
            addCriterion("size_id =", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdNotEqualTo(Integer value) {
            addCriterion("size_id <>", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdGreaterThan(Integer value) {
            addCriterion("size_id >", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("size_id >=", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdLessThan(Integer value) {
            addCriterion("size_id <", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("size_id <=", value, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdIn(List<Integer> values) {
            addCriterion("size_id in", values, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdNotIn(List<Integer> values) {
            addCriterion("size_id not in", values, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdBetween(Integer value1, Integer value2) {
            addCriterion("size_id between", value1, value2, "sizeId");
            return (Criteria) this;
        }

        public Criteria andSizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("size_id not between", value1, value2, "sizeId");
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

        public Criteria andSl1IsNull() {
            addCriterion("sl1 is null");
            return (Criteria) this;
        }

        public Criteria andSl1IsNotNull() {
            addCriterion("sl1 is not null");
            return (Criteria) this;
        }

        public Criteria andSl1EqualTo(Integer value) {
            addCriterion("sl1 =", value, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl1NotEqualTo(Integer value) {
            addCriterion("sl1 <>", value, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl1GreaterThan(Integer value) {
            addCriterion("sl1 >", value, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl1GreaterThanOrEqualTo(Integer value) {
            addCriterion("sl1 >=", value, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl1LessThan(Integer value) {
            addCriterion("sl1 <", value, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl1LessThanOrEqualTo(Integer value) {
            addCriterion("sl1 <=", value, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl1In(List<Integer> values) {
            addCriterion("sl1 in", values, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl1NotIn(List<Integer> values) {
            addCriterion("sl1 not in", values, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl1Between(Integer value1, Integer value2) {
            addCriterion("sl1 between", value1, value2, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl1NotBetween(Integer value1, Integer value2) {
            addCriterion("sl1 not between", value1, value2, "sl1");
            return (Criteria) this;
        }

        public Criteria andSl2IsNull() {
            addCriterion("sl2 is null");
            return (Criteria) this;
        }

        public Criteria andSl2IsNotNull() {
            addCriterion("sl2 is not null");
            return (Criteria) this;
        }

        public Criteria andSl2EqualTo(Integer value) {
            addCriterion("sl2 =", value, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl2NotEqualTo(Integer value) {
            addCriterion("sl2 <>", value, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl2GreaterThan(Integer value) {
            addCriterion("sl2 >", value, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl2GreaterThanOrEqualTo(Integer value) {
            addCriterion("sl2 >=", value, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl2LessThan(Integer value) {
            addCriterion("sl2 <", value, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl2LessThanOrEqualTo(Integer value) {
            addCriterion("sl2 <=", value, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl2In(List<Integer> values) {
            addCriterion("sl2 in", values, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl2NotIn(List<Integer> values) {
            addCriterion("sl2 not in", values, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl2Between(Integer value1, Integer value2) {
            addCriterion("sl2 between", value1, value2, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl2NotBetween(Integer value1, Integer value2) {
            addCriterion("sl2 not between", value1, value2, "sl2");
            return (Criteria) this;
        }

        public Criteria andSl3IsNull() {
            addCriterion("sl3 is null");
            return (Criteria) this;
        }

        public Criteria andSl3IsNotNull() {
            addCriterion("sl3 is not null");
            return (Criteria) this;
        }

        public Criteria andSl3EqualTo(Integer value) {
            addCriterion("sl3 =", value, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl3NotEqualTo(Integer value) {
            addCriterion("sl3 <>", value, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl3GreaterThan(Integer value) {
            addCriterion("sl3 >", value, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl3GreaterThanOrEqualTo(Integer value) {
            addCriterion("sl3 >=", value, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl3LessThan(Integer value) {
            addCriterion("sl3 <", value, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl3LessThanOrEqualTo(Integer value) {
            addCriterion("sl3 <=", value, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl3In(List<Integer> values) {
            addCriterion("sl3 in", values, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl3NotIn(List<Integer> values) {
            addCriterion("sl3 not in", values, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl3Between(Integer value1, Integer value2) {
            addCriterion("sl3 between", value1, value2, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl3NotBetween(Integer value1, Integer value2) {
            addCriterion("sl3 not between", value1, value2, "sl3");
            return (Criteria) this;
        }

        public Criteria andSl4IsNull() {
            addCriterion("sl4 is null");
            return (Criteria) this;
        }

        public Criteria andSl4IsNotNull() {
            addCriterion("sl4 is not null");
            return (Criteria) this;
        }

        public Criteria andSl4EqualTo(Integer value) {
            addCriterion("sl4 =", value, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl4NotEqualTo(Integer value) {
            addCriterion("sl4 <>", value, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl4GreaterThan(Integer value) {
            addCriterion("sl4 >", value, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl4GreaterThanOrEqualTo(Integer value) {
            addCriterion("sl4 >=", value, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl4LessThan(Integer value) {
            addCriterion("sl4 <", value, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl4LessThanOrEqualTo(Integer value) {
            addCriterion("sl4 <=", value, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl4In(List<Integer> values) {
            addCriterion("sl4 in", values, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl4NotIn(List<Integer> values) {
            addCriterion("sl4 not in", values, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl4Between(Integer value1, Integer value2) {
            addCriterion("sl4 between", value1, value2, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl4NotBetween(Integer value1, Integer value2) {
            addCriterion("sl4 not between", value1, value2, "sl4");
            return (Criteria) this;
        }

        public Criteria andSl5IsNull() {
            addCriterion("sl5 is null");
            return (Criteria) this;
        }

        public Criteria andSl5IsNotNull() {
            addCriterion("sl5 is not null");
            return (Criteria) this;
        }

        public Criteria andSl5EqualTo(Integer value) {
            addCriterion("sl5 =", value, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl5NotEqualTo(Integer value) {
            addCriterion("sl5 <>", value, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl5GreaterThan(Integer value) {
            addCriterion("sl5 >", value, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl5GreaterThanOrEqualTo(Integer value) {
            addCriterion("sl5 >=", value, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl5LessThan(Integer value) {
            addCriterion("sl5 <", value, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl5LessThanOrEqualTo(Integer value) {
            addCriterion("sl5 <=", value, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl5In(List<Integer> values) {
            addCriterion("sl5 in", values, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl5NotIn(List<Integer> values) {
            addCriterion("sl5 not in", values, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl5Between(Integer value1, Integer value2) {
            addCriterion("sl5 between", value1, value2, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl5NotBetween(Integer value1, Integer value2) {
            addCriterion("sl5 not between", value1, value2, "sl5");
            return (Criteria) this;
        }

        public Criteria andSl6IsNull() {
            addCriterion("sl6 is null");
            return (Criteria) this;
        }

        public Criteria andSl6IsNotNull() {
            addCriterion("sl6 is not null");
            return (Criteria) this;
        }

        public Criteria andSl6EqualTo(Integer value) {
            addCriterion("sl6 =", value, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl6NotEqualTo(Integer value) {
            addCriterion("sl6 <>", value, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl6GreaterThan(Integer value) {
            addCriterion("sl6 >", value, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl6GreaterThanOrEqualTo(Integer value) {
            addCriterion("sl6 >=", value, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl6LessThan(Integer value) {
            addCriterion("sl6 <", value, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl6LessThanOrEqualTo(Integer value) {
            addCriterion("sl6 <=", value, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl6In(List<Integer> values) {
            addCriterion("sl6 in", values, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl6NotIn(List<Integer> values) {
            addCriterion("sl6 not in", values, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl6Between(Integer value1, Integer value2) {
            addCriterion("sl6 between", value1, value2, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl6NotBetween(Integer value1, Integer value2) {
            addCriterion("sl6 not between", value1, value2, "sl6");
            return (Criteria) this;
        }

        public Criteria andSl7IsNull() {
            addCriterion("sl7 is null");
            return (Criteria) this;
        }

        public Criteria andSl7IsNotNull() {
            addCriterion("sl7 is not null");
            return (Criteria) this;
        }

        public Criteria andSl7EqualTo(Integer value) {
            addCriterion("sl7 =", value, "sl7");
            return (Criteria) this;
        }

        public Criteria andSl7NotEqualTo(Integer value) {
            addCriterion("sl7 <>", value, "sl7");
            return (Criteria) this;
        }

        public Criteria andSl7GreaterThan(Integer value) {
            addCriterion("sl7 >", value, "sl7");
            return (Criteria) this;
        }

        public Criteria andSl7GreaterThanOrEqualTo(Integer value) {
            addCriterion("sl7 >=", value, "sl7");
            return (Criteria) this;
        }

        public Criteria andSl7LessThan(Integer value) {
            addCriterion("sl7 <", value, "sl7");
            return (Criteria) this;
        }

        public Criteria andSl7LessThanOrEqualTo(Integer value) {
            addCriterion("sl7 <=", value, "sl7");
            return (Criteria) this;
        }

        public Criteria andSl7In(List<Integer> values) {
            addCriterion("sl7 in", values, "sl7");
            return (Criteria) this;
        }

        public Criteria andSl7NotIn(List<Integer> values) {
            addCriterion("sl7 not in", values, "sl7");
            return (Criteria) this;
        }

        public Criteria andSl7Between(Integer value1, Integer value2) {
            addCriterion("sl7 between", value1, value2, "sl7");
            return (Criteria) this;
        }

        public Criteria andSl7NotBetween(Integer value1, Integer value2) {
            addCriterion("sl7 not between", value1, value2, "sl7");
            return (Criteria) this;
        }

        public Criteria andCkdmIsNull() {
            addCriterion("ckdm is null");
            return (Criteria) this;
        }

        public Criteria andCkdmIsNotNull() {
            addCriterion("ckdm is not null");
            return (Criteria) this;
        }

        public Criteria andCkdmEqualTo(String value) {
            addCriterion("ckdm =", value, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmNotEqualTo(String value) {
            addCriterion("ckdm <>", value, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmGreaterThan(String value) {
            addCriterion("ckdm >", value, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmGreaterThanOrEqualTo(String value) {
            addCriterion("ckdm >=", value, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmLessThan(String value) {
            addCriterion("ckdm <", value, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmLessThanOrEqualTo(String value) {
            addCriterion("ckdm <=", value, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmLike(String value) {
            addCriterion("ckdm like", value, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmNotLike(String value) {
            addCriterion("ckdm not like", value, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmIn(List<String> values) {
            addCriterion("ckdm in", values, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmNotIn(List<String> values) {
            addCriterion("ckdm not in", values, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmBetween(String value1, String value2) {
            addCriterion("ckdm between", value1, value2, "ckdm");
            return (Criteria) this;
        }

        public Criteria andCkdmNotBetween(String value1, String value2) {
            addCriterion("ckdm not between", value1, value2, "ckdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmIsNull() {
            addCriterion("shangpin_spdm is null");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmIsNotNull() {
            addCriterion("shangpin_spdm is not null");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmEqualTo(String value) {
            addCriterion("shangpin_spdm =", value, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmNotEqualTo(String value) {
            addCriterion("shangpin_spdm <>", value, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmGreaterThan(String value) {
            addCriterion("shangpin_spdm >", value, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmGreaterThanOrEqualTo(String value) {
            addCriterion("shangpin_spdm >=", value, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmLessThan(String value) {
            addCriterion("shangpin_spdm <", value, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmLessThanOrEqualTo(String value) {
            addCriterion("shangpin_spdm <=", value, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmLike(String value) {
            addCriterion("shangpin_spdm like", value, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmNotLike(String value) {
            addCriterion("shangpin_spdm not like", value, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmIn(List<String> values) {
            addCriterion("shangpin_spdm in", values, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmNotIn(List<String> values) {
            addCriterion("shangpin_spdm not in", values, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmBetween(String value1, String value2) {
            addCriterion("shangpin_spdm between", value1, value2, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andShangpinSpdmNotBetween(String value1, String value2) {
            addCriterion("shangpin_spdm not between", value1, value2, "shangpinSpdm");
            return (Criteria) this;
        }

        public Criteria andColorCodeIsNull() {
            addCriterion("color_code is null");
            return (Criteria) this;
        }

        public Criteria andColorCodeIsNotNull() {
            addCriterion("color_code is not null");
            return (Criteria) this;
        }

        public Criteria andColorCodeEqualTo(String value) {
            addCriterion("color_code =", value, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeNotEqualTo(String value) {
            addCriterion("color_code <>", value, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeGreaterThan(String value) {
            addCriterion("color_code >", value, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("color_code >=", value, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeLessThan(String value) {
            addCriterion("color_code <", value, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeLessThanOrEqualTo(String value) {
            addCriterion("color_code <=", value, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeLike(String value) {
            addCriterion("color_code like", value, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeNotLike(String value) {
            addCriterion("color_code not like", value, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeIn(List<String> values) {
            addCriterion("color_code in", values, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeNotIn(List<String> values) {
            addCriterion("color_code not in", values, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeBetween(String value1, String value2) {
            addCriterion("color_code between", value1, value2, "colorCode");
            return (Criteria) this;
        }

        public Criteria andColorCodeNotBetween(String value1, String value2) {
            addCriterion("color_code not between", value1, value2, "colorCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeIsNull() {
            addCriterion("size_code is null");
            return (Criteria) this;
        }

        public Criteria andSizeCodeIsNotNull() {
            addCriterion("size_code is not null");
            return (Criteria) this;
        }

        public Criteria andSizeCodeEqualTo(String value) {
            addCriterion("size_code =", value, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeNotEqualTo(String value) {
            addCriterion("size_code <>", value, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeGreaterThan(String value) {
            addCriterion("size_code >", value, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("size_code >=", value, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeLessThan(String value) {
            addCriterion("size_code <", value, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeLessThanOrEqualTo(String value) {
            addCriterion("size_code <=", value, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeLike(String value) {
            addCriterion("size_code like", value, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeNotLike(String value) {
            addCriterion("size_code not like", value, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeIn(List<String> values) {
            addCriterion("size_code in", values, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeNotIn(List<String> values) {
            addCriterion("size_code not in", values, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeBetween(String value1, String value2) {
            addCriterion("size_code between", value1, value2, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andSizeCodeNotBetween(String value1, String value2) {
            addCriterion("size_code not between", value1, value2, "sizeCode");
            return (Criteria) this;
        }

        public Criteria andLastchangedIsNull() {
            addCriterion("lastchanged is null");
            return (Criteria) this;
        }

        public Criteria andLastchangedIsNotNull() {
            addCriterion("lastchanged is not null");
            return (Criteria) this;
        }

        public Criteria andLastchangedEqualTo(Date value) {
            addCriterion("lastchanged =", value, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andLastchangedNotEqualTo(Date value) {
            addCriterion("lastchanged <>", value, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andLastchangedGreaterThan(Date value) {
            addCriterion("lastchanged >", value, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andLastchangedGreaterThanOrEqualTo(Date value) {
            addCriterion("lastchanged >=", value, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andLastchangedLessThan(Date value) {
            addCriterion("lastchanged <", value, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andLastchangedLessThanOrEqualTo(Date value) {
            addCriterion("lastchanged <=", value, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andLastchangedIn(List<Date> values) {
            addCriterion("lastchanged in", values, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andLastchangedNotIn(List<Date> values) {
            addCriterion("lastchanged not in", values, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andLastchangedBetween(Date value1, Date value2) {
            addCriterion("lastchanged between", value1, value2, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andLastchangedNotBetween(Date value1, Date value2) {
            addCriterion("lastchanged not between", value1, value2, "lastchanged");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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