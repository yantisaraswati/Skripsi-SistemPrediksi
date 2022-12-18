package com.yanti.inventorycontroll.domain.model.movingaveragedetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HMovingAverageDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HMovingAverageDetailCriteria() {
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

        public Criteria andMovingAverageDetailIdIsNull() {
            addCriterion("moving_average_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdIsNotNull() {
            addCriterion("moving_average_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdEqualTo(Long value) {
            addCriterion("moving_average_detail_id =", value, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdNotEqualTo(Long value) {
            addCriterion("moving_average_detail_id <>", value, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdGreaterThan(Long value) {
            addCriterion("moving_average_detail_id >", value, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("moving_average_detail_id >=", value, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdLessThan(Long value) {
            addCriterion("moving_average_detail_id <", value, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("moving_average_detail_id <=", value, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdIn(List<Long> values) {
            addCriterion("moving_average_detail_id in", values, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdNotIn(List<Long> values) {
            addCriterion("moving_average_detail_id not in", values, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdBetween(Long value1, Long value2) {
            addCriterion("moving_average_detail_id between", value1, value2, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("moving_average_detail_id not between", value1, value2, "movingAverageDetailId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdIsNull() {
            addCriterion("moving_average_id is null");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdIsNotNull() {
            addCriterion("moving_average_id is not null");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdEqualTo(Long value) {
            addCriterion("moving_average_id =", value, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdNotEqualTo(Long value) {
            addCriterion("moving_average_id <>", value, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdGreaterThan(Long value) {
            addCriterion("moving_average_id >", value, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("moving_average_id >=", value, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdLessThan(Long value) {
            addCriterion("moving_average_id <", value, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdLessThanOrEqualTo(Long value) {
            addCriterion("moving_average_id <=", value, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdIn(List<Long> values) {
            addCriterion("moving_average_id in", values, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdNotIn(List<Long> values) {
            addCriterion("moving_average_id not in", values, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdBetween(Long value1, Long value2) {
            addCriterion("moving_average_id between", value1, value2, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andMovingAverageIdNotBetween(Long value1, Long value2) {
            addCriterion("moving_average_id not between", value1, value2, "movingAverageId");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(String value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(String value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(String value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(String value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(String value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLike(String value) {
            addCriterion("period like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotLike(String value) {
            addCriterion("period not like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<String> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<String> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(String value1, String value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(String value1, String value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andForecastIsNull() {
            addCriterion("forecast is null");
            return (Criteria) this;
        }

        public Criteria andForecastIsNotNull() {
            addCriterion("forecast is not null");
            return (Criteria) this;
        }

        public Criteria andForecastEqualTo(Double value) {
            addCriterion("forecast =", value, "forecast");
            return (Criteria) this;
        }

        public Criteria andForecastNotEqualTo(Double value) {
            addCriterion("forecast <>", value, "forecast");
            return (Criteria) this;
        }

        public Criteria andForecastGreaterThan(Double value) {
            addCriterion("forecast >", value, "forecast");
            return (Criteria) this;
        }

        public Criteria andForecastGreaterThanOrEqualTo(Double value) {
            addCriterion("forecast >=", value, "forecast");
            return (Criteria) this;
        }

        public Criteria andForecastLessThan(Double value) {
            addCriterion("forecast <", value, "forecast");
            return (Criteria) this;
        }

        public Criteria andForecastLessThanOrEqualTo(Double value) {
            addCriterion("forecast <=", value, "forecast");
            return (Criteria) this;
        }

        public Criteria andForecastIn(List<Double> values) {
            addCriterion("forecast in", values, "forecast");
            return (Criteria) this;
        }

        public Criteria andForecastNotIn(List<Double> values) {
            addCriterion("forecast not in", values, "forecast");
            return (Criteria) this;
        }

        public Criteria andForecastBetween(Double value1, Double value2) {
            addCriterion("forecast between", value1, value2, "forecast");
            return (Criteria) this;
        }

        public Criteria andForecastNotBetween(Double value1, Double value2) {
            addCriterion("forecast not between", value1, value2, "forecast");
            return (Criteria) this;
        }

        public Criteria andErrorIsNull() {
            addCriterion("error is null");
            return (Criteria) this;
        }

        public Criteria andErrorIsNotNull() {
            addCriterion("error is not null");
            return (Criteria) this;
        }

        public Criteria andErrorEqualTo(Double value) {
            addCriterion("error =", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorNotEqualTo(Double value) {
            addCriterion("error <>", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorGreaterThan(Double value) {
            addCriterion("error >", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorGreaterThanOrEqualTo(Double value) {
            addCriterion("error >=", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorLessThan(Double value) {
            addCriterion("error <", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorLessThanOrEqualTo(Double value) {
            addCriterion("error <=", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorIn(List<Double> values) {
            addCriterion("error in", values, "error");
            return (Criteria) this;
        }

        public Criteria andErrorNotIn(List<Double> values) {
            addCriterion("error not in", values, "error");
            return (Criteria) this;
        }

        public Criteria andErrorBetween(Double value1, Double value2) {
            addCriterion("error between", value1, value2, "error");
            return (Criteria) this;
        }

        public Criteria andErrorNotBetween(Double value1, Double value2) {
            addCriterion("error not between", value1, value2, "error");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteIsNull() {
            addCriterion("error_absolute is null");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteIsNotNull() {
            addCriterion("error_absolute is not null");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteEqualTo(Double value) {
            addCriterion("error_absolute =", value, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteNotEqualTo(Double value) {
            addCriterion("error_absolute <>", value, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteGreaterThan(Double value) {
            addCriterion("error_absolute >", value, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteGreaterThanOrEqualTo(Double value) {
            addCriterion("error_absolute >=", value, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteLessThan(Double value) {
            addCriterion("error_absolute <", value, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteLessThanOrEqualTo(Double value) {
            addCriterion("error_absolute <=", value, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteIn(List<Double> values) {
            addCriterion("error_absolute in", values, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteNotIn(List<Double> values) {
            addCriterion("error_absolute not in", values, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteBetween(Double value1, Double value2) {
            addCriterion("error_absolute between", value1, value2, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorAbsoluteNotBetween(Double value1, Double value2) {
            addCriterion("error_absolute not between", value1, value2, "errorAbsolute");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredIsNull() {
            addCriterion("error_squared is null");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredIsNotNull() {
            addCriterion("error_squared is not null");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredEqualTo(Double value) {
            addCriterion("error_squared =", value, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredNotEqualTo(Double value) {
            addCriterion("error_squared <>", value, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredGreaterThan(Double value) {
            addCriterion("error_squared >", value, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredGreaterThanOrEqualTo(Double value) {
            addCriterion("error_squared >=", value, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredLessThan(Double value) {
            addCriterion("error_squared <", value, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredLessThanOrEqualTo(Double value) {
            addCriterion("error_squared <=", value, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredIn(List<Double> values) {
            addCriterion("error_squared in", values, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredNotIn(List<Double> values) {
            addCriterion("error_squared not in", values, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredBetween(Double value1, Double value2) {
            addCriterion("error_squared between", value1, value2, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorSquaredNotBetween(Double value1, Double value2) {
            addCriterion("error_squared not between", value1, value2, "errorSquared");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageIsNull() {
            addCriterion("error_percentage is null");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageIsNotNull() {
            addCriterion("error_percentage is not null");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageEqualTo(Double value) {
            addCriterion("error_percentage =", value, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageNotEqualTo(Double value) {
            addCriterion("error_percentage <>", value, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageGreaterThan(Double value) {
            addCriterion("error_percentage >", value, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageGreaterThanOrEqualTo(Double value) {
            addCriterion("error_percentage >=", value, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageLessThan(Double value) {
            addCriterion("error_percentage <", value, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageLessThanOrEqualTo(Double value) {
            addCriterion("error_percentage <=", value, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageIn(List<Double> values) {
            addCriterion("error_percentage in", values, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageNotIn(List<Double> values) {
            addCriterion("error_percentage not in", values, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageBetween(Double value1, Double value2) {
            addCriterion("error_percentage between", value1, value2, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andErrorPercentageNotBetween(Double value1, Double value2) {
            addCriterion("error_percentage not between", value1, value2, "errorPercentage");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(Long value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(Long value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(Long value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(Long value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(Long value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(Long value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<Long> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<Long> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(Long value1, Long value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(Long value1, Long value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("updated_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(Long value) {
            addCriterion("updated_by =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(Long value) {
            addCriterion("updated_by <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(Long value) {
            addCriterion("updated_by >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(Long value) {
            addCriterion("updated_by >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(Long value) {
            addCriterion("updated_by <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(Long value) {
            addCriterion("updated_by <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<Long> values) {
            addCriterion("updated_by in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<Long> values) {
            addCriterion("updated_by not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(Long value1, Long value2) {
            addCriterion("updated_by between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(Long value1, Long value2) {
            addCriterion("updated_by not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNull() {
            addCriterion("updated_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNotNull() {
            addCriterion("updated_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateEqualTo(Date value) {
            addCriterion("updated_date =", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotEqualTo(Date value) {
            addCriterion("updated_date <>", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThan(Date value) {
            addCriterion("updated_date >", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_date >=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThan(Date value) {
            addCriterion("updated_date <", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThanOrEqualTo(Date value) {
            addCriterion("updated_date <=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIn(List<Date> values) {
            addCriterion("updated_date in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotIn(List<Date> values) {
            addCriterion("updated_date not in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateBetween(Date value1, Date value2) {
            addCriterion("updated_date between", value1, value2, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotBetween(Date value1, Date value2) {
            addCriterion("updated_date not between", value1, value2, "updatedDate");
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