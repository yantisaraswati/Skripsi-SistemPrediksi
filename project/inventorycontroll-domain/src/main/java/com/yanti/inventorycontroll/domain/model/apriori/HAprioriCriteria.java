package com.yanti.inventorycontroll.domain.model.apriori;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HAprioriCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HAprioriCriteria() {
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

        public Criteria andAprioriIdIsNull() {
            addCriterion("apriori_id is null");
            return (Criteria) this;
        }

        public Criteria andAprioriIdIsNotNull() {
            addCriterion("apriori_id is not null");
            return (Criteria) this;
        }

        public Criteria andAprioriIdEqualTo(Long value) {
            addCriterion("apriori_id =", value, "aprioriId");
            return (Criteria) this;
        }

        public Criteria andAprioriIdNotEqualTo(Long value) {
            addCriterion("apriori_id <>", value, "aprioriId");
            return (Criteria) this;
        }

        public Criteria andAprioriIdGreaterThan(Long value) {
            addCriterion("apriori_id >", value, "aprioriId");
            return (Criteria) this;
        }

        public Criteria andAprioriIdGreaterThanOrEqualTo(Long value) {
            addCriterion("apriori_id >=", value, "aprioriId");
            return (Criteria) this;
        }

        public Criteria andAprioriIdLessThan(Long value) {
            addCriterion("apriori_id <", value, "aprioriId");
            return (Criteria) this;
        }

        public Criteria andAprioriIdLessThanOrEqualTo(Long value) {
            addCriterion("apriori_id <=", value, "aprioriId");
            return (Criteria) this;
        }

        public Criteria andAprioriIdIn(List<Long> values) {
            addCriterion("apriori_id in", values, "aprioriId");
            return (Criteria) this;
        }

        public Criteria andAprioriIdNotIn(List<Long> values) {
            addCriterion("apriori_id not in", values, "aprioriId");
            return (Criteria) this;
        }

        public Criteria andAprioriIdBetween(Long value1, Long value2) {
            addCriterion("apriori_id between", value1, value2, "aprioriId");
            return (Criteria) this;
        }

        public Criteria andAprioriIdNotBetween(Long value1, Long value2) {
            addCriterion("apriori_id not between", value1, value2, "aprioriId");
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

        public Criteria andMinSupportIsNull() {
            addCriterion("min_support is null");
            return (Criteria) this;
        }

        public Criteria andMinSupportIsNotNull() {
            addCriterion("min_support is not null");
            return (Criteria) this;
        }

        public Criteria andMinSupportEqualTo(Integer value) {
            addCriterion("min_support =", value, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinSupportNotEqualTo(Integer value) {
            addCriterion("min_support <>", value, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinSupportGreaterThan(Integer value) {
            addCriterion("min_support >", value, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinSupportGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_support >=", value, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinSupportLessThan(Integer value) {
            addCriterion("min_support <", value, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinSupportLessThanOrEqualTo(Integer value) {
            addCriterion("min_support <=", value, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinSupportIn(List<Integer> values) {
            addCriterion("min_support in", values, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinSupportNotIn(List<Integer> values) {
            addCriterion("min_support not in", values, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinSupportBetween(Integer value1, Integer value2) {
            addCriterion("min_support between", value1, value2, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinSupportNotBetween(Integer value1, Integer value2) {
            addCriterion("min_support not between", value1, value2, "minSupport");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceIsNull() {
            addCriterion("min_confidence is null");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceIsNotNull() {
            addCriterion("min_confidence is not null");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceEqualTo(Integer value) {
            addCriterion("min_confidence =", value, "minConfidence");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceNotEqualTo(Integer value) {
            addCriterion("min_confidence <>", value, "minConfidence");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceGreaterThan(Integer value) {
            addCriterion("min_confidence >", value, "minConfidence");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_confidence >=", value, "minConfidence");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceLessThan(Integer value) {
            addCriterion("min_confidence <", value, "minConfidence");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceLessThanOrEqualTo(Integer value) {
            addCriterion("min_confidence <=", value, "minConfidence");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceIn(List<Integer> values) {
            addCriterion("min_confidence in", values, "minConfidence");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceNotIn(List<Integer> values) {
            addCriterion("min_confidence not in", values, "minConfidence");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceBetween(Integer value1, Integer value2) {
            addCriterion("min_confidence between", value1, value2, "minConfidence");
            return (Criteria) this;
        }

        public Criteria andMinConfidenceNotBetween(Integer value1, Integer value2) {
            addCriterion("min_confidence not between", value1, value2, "minConfidence");
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