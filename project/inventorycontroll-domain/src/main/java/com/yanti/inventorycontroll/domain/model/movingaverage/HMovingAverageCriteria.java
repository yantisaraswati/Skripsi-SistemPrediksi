package com.yanti.inventorycontroll.domain.model.movingaverage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HMovingAverageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HMovingAverageCriteria() {
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

        public Criteria andOrganizationIdIsNull() {
            addCriterion("organization_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdIsNotNull() {
            addCriterion("organization_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdEqualTo(Long value) {
            addCriterion("organization_id =", value, "organizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdNotEqualTo(Long value) {
            addCriterion("organization_id <>", value, "organizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdGreaterThan(Long value) {
            addCriterion("organization_id >", value, "organizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("organization_id >=", value, "organizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdLessThan(Long value) {
            addCriterion("organization_id <", value, "organizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdLessThanOrEqualTo(Long value) {
            addCriterion("organization_id <=", value, "organizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdIn(List<Long> values) {
            addCriterion("organization_id in", values, "organizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdNotIn(List<Long> values) {
            addCriterion("organization_id not in", values, "organizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdBetween(Long value1, Long value2) {
            addCriterion("organization_id between", value1, value2, "organizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationIdNotBetween(Long value1, Long value2) {
            addCriterion("organization_id not between", value1, value2, "organizationId");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
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

        public Criteria andNMonthIsNull() {
            addCriterion("n_month is null");
            return (Criteria) this;
        }

        public Criteria andNMonthIsNotNull() {
            addCriterion("n_month is not null");
            return (Criteria) this;
        }

        public Criteria andNMonthEqualTo(Integer value) {
            addCriterion("n_month =", value, "nMonth");
            return (Criteria) this;
        }

        public Criteria andNMonthNotEqualTo(Integer value) {
            addCriterion("n_month <>", value, "nMonth");
            return (Criteria) this;
        }

        public Criteria andNMonthGreaterThan(Integer value) {
            addCriterion("n_month >", value, "nMonth");
            return (Criteria) this;
        }

        public Criteria andNMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("n_month >=", value, "nMonth");
            return (Criteria) this;
        }

        public Criteria andNMonthLessThan(Integer value) {
            addCriterion("n_month <", value, "nMonth");
            return (Criteria) this;
        }

        public Criteria andNMonthLessThanOrEqualTo(Integer value) {
            addCriterion("n_month <=", value, "nMonth");
            return (Criteria) this;
        }

        public Criteria andNMonthIn(List<Integer> values) {
            addCriterion("n_month in", values, "nMonth");
            return (Criteria) this;
        }

        public Criteria andNMonthNotIn(List<Integer> values) {
            addCriterion("n_month not in", values, "nMonth");
            return (Criteria) this;
        }

        public Criteria andNMonthBetween(Integer value1, Integer value2) {
            addCriterion("n_month between", value1, value2, "nMonth");
            return (Criteria) this;
        }

        public Criteria andNMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("n_month not between", value1, value2, "nMonth");
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

        public Criteria andMaeIsNull() {
            addCriterion("mae is null");
            return (Criteria) this;
        }

        public Criteria andMaeIsNotNull() {
            addCriterion("mae is not null");
            return (Criteria) this;
        }

        public Criteria andMaeEqualTo(Double value) {
            addCriterion("mae =", value, "mae");
            return (Criteria) this;
        }

        public Criteria andMaeNotEqualTo(Double value) {
            addCriterion("mae <>", value, "mae");
            return (Criteria) this;
        }

        public Criteria andMaeGreaterThan(Double value) {
            addCriterion("mae >", value, "mae");
            return (Criteria) this;
        }

        public Criteria andMaeGreaterThanOrEqualTo(Double value) {
            addCriterion("mae >=", value, "mae");
            return (Criteria) this;
        }

        public Criteria andMaeLessThan(Double value) {
            addCriterion("mae <", value, "mae");
            return (Criteria) this;
        }

        public Criteria andMaeLessThanOrEqualTo(Double value) {
            addCriterion("mae <=", value, "mae");
            return (Criteria) this;
        }

        public Criteria andMaeIn(List<Double> values) {
            addCriterion("mae in", values, "mae");
            return (Criteria) this;
        }

        public Criteria andMaeNotIn(List<Double> values) {
            addCriterion("mae not in", values, "mae");
            return (Criteria) this;
        }

        public Criteria andMaeBetween(Double value1, Double value2) {
            addCriterion("mae between", value1, value2, "mae");
            return (Criteria) this;
        }

        public Criteria andMaeNotBetween(Double value1, Double value2) {
            addCriterion("mae not between", value1, value2, "mae");
            return (Criteria) this;
        }

        public Criteria andMseIsNull() {
            addCriterion("mse is null");
            return (Criteria) this;
        }

        public Criteria andMseIsNotNull() {
            addCriterion("mse is not null");
            return (Criteria) this;
        }

        public Criteria andMseEqualTo(Double value) {
            addCriterion("mse =", value, "mse");
            return (Criteria) this;
        }

        public Criteria andMseNotEqualTo(Double value) {
            addCriterion("mse <>", value, "mse");
            return (Criteria) this;
        }

        public Criteria andMseGreaterThan(Double value) {
            addCriterion("mse >", value, "mse");
            return (Criteria) this;
        }

        public Criteria andMseGreaterThanOrEqualTo(Double value) {
            addCriterion("mse >=", value, "mse");
            return (Criteria) this;
        }

        public Criteria andMseLessThan(Double value) {
            addCriterion("mse <", value, "mse");
            return (Criteria) this;
        }

        public Criteria andMseLessThanOrEqualTo(Double value) {
            addCriterion("mse <=", value, "mse");
            return (Criteria) this;
        }

        public Criteria andMseIn(List<Double> values) {
            addCriterion("mse in", values, "mse");
            return (Criteria) this;
        }

        public Criteria andMseNotIn(List<Double> values) {
            addCriterion("mse not in", values, "mse");
            return (Criteria) this;
        }

        public Criteria andMseBetween(Double value1, Double value2) {
            addCriterion("mse between", value1, value2, "mse");
            return (Criteria) this;
        }

        public Criteria andMseNotBetween(Double value1, Double value2) {
            addCriterion("mse not between", value1, value2, "mse");
            return (Criteria) this;
        }

        public Criteria andMapeIsNull() {
            addCriterion("mape is null");
            return (Criteria) this;
        }

        public Criteria andMapeIsNotNull() {
            addCriterion("mape is not null");
            return (Criteria) this;
        }

        public Criteria andMapeEqualTo(Double value) {
            addCriterion("mape =", value, "mape");
            return (Criteria) this;
        }

        public Criteria andMapeNotEqualTo(Double value) {
            addCriterion("mape <>", value, "mape");
            return (Criteria) this;
        }

        public Criteria andMapeGreaterThan(Double value) {
            addCriterion("mape >", value, "mape");
            return (Criteria) this;
        }

        public Criteria andMapeGreaterThanOrEqualTo(Double value) {
            addCriterion("mape >=", value, "mape");
            return (Criteria) this;
        }

        public Criteria andMapeLessThan(Double value) {
            addCriterion("mape <", value, "mape");
            return (Criteria) this;
        }

        public Criteria andMapeLessThanOrEqualTo(Double value) {
            addCriterion("mape <=", value, "mape");
            return (Criteria) this;
        }

        public Criteria andMapeIn(List<Double> values) {
            addCriterion("mape in", values, "mape");
            return (Criteria) this;
        }

        public Criteria andMapeNotIn(List<Double> values) {
            addCriterion("mape not in", values, "mape");
            return (Criteria) this;
        }

        public Criteria andMapeBetween(Double value1, Double value2) {
            addCriterion("mape between", value1, value2, "mape");
            return (Criteria) this;
        }

        public Criteria andMapeNotBetween(Double value1, Double value2) {
            addCriterion("mape not between", value1, value2, "mape");
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