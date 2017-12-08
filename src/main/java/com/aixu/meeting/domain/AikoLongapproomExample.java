package com.aixu.meeting.domain;

import java.util.ArrayList;
import java.util.List;

public class AikoLongapproomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AikoLongapproomExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andLpIdIsNull() {
            addCriterion("LP_ID is null");
            return (Criteria) this;
        }

        public Criteria andLpIdIsNotNull() {
            addCriterion("LP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLpIdEqualTo(String value) {
            addCriterion("LP_ID =", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdNotEqualTo(String value) {
            addCriterion("LP_ID <>", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdGreaterThan(String value) {
            addCriterion("LP_ID >", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdGreaterThanOrEqualTo(String value) {
            addCriterion("LP_ID >=", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdLessThan(String value) {
            addCriterion("LP_ID <", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdLessThanOrEqualTo(String value) {
            addCriterion("LP_ID <=", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdLike(String value) {
            addCriterion("LP_ID like", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdNotLike(String value) {
            addCriterion("LP_ID not like", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdIn(List<String> values) {
            addCriterion("LP_ID in", values, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdNotIn(List<String> values) {
            addCriterion("LP_ID not in", values, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdBetween(String value1, String value2) {
            addCriterion("LP_ID between", value1, value2, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdNotBetween(String value1, String value2) {
            addCriterion("LP_ID not between", value1, value2, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpResoneIsNull() {
            addCriterion("LP_RESONE is null");
            return (Criteria) this;
        }

        public Criteria andLpResoneIsNotNull() {
            addCriterion("LP_RESONE is not null");
            return (Criteria) this;
        }

        public Criteria andLpResoneEqualTo(String value) {
            addCriterion("LP_RESONE =", value, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneNotEqualTo(String value) {
            addCriterion("LP_RESONE <>", value, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneGreaterThan(String value) {
            addCriterion("LP_RESONE >", value, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneGreaterThanOrEqualTo(String value) {
            addCriterion("LP_RESONE >=", value, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneLessThan(String value) {
            addCriterion("LP_RESONE <", value, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneLessThanOrEqualTo(String value) {
            addCriterion("LP_RESONE <=", value, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneLike(String value) {
            addCriterion("LP_RESONE like", value, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneNotLike(String value) {
            addCriterion("LP_RESONE not like", value, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneIn(List<String> values) {
            addCriterion("LP_RESONE in", values, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneNotIn(List<String> values) {
            addCriterion("LP_RESONE not in", values, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneBetween(String value1, String value2) {
            addCriterion("LP_RESONE between", value1, value2, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpResoneNotBetween(String value1, String value2) {
            addCriterion("LP_RESONE not between", value1, value2, "lpResone");
            return (Criteria) this;
        }

        public Criteria andLpRestwoIsNull() {
            addCriterion("LP_RESTWO is null");
            return (Criteria) this;
        }

        public Criteria andLpRestwoIsNotNull() {
            addCriterion("LP_RESTWO is not null");
            return (Criteria) this;
        }

        public Criteria andLpRestwoEqualTo(String value) {
            addCriterion("LP_RESTWO =", value, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoNotEqualTo(String value) {
            addCriterion("LP_RESTWO <>", value, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoGreaterThan(String value) {
            addCriterion("LP_RESTWO >", value, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoGreaterThanOrEqualTo(String value) {
            addCriterion("LP_RESTWO >=", value, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoLessThan(String value) {
            addCriterion("LP_RESTWO <", value, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoLessThanOrEqualTo(String value) {
            addCriterion("LP_RESTWO <=", value, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoLike(String value) {
            addCriterion("LP_RESTWO like", value, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoNotLike(String value) {
            addCriterion("LP_RESTWO not like", value, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoIn(List<String> values) {
            addCriterion("LP_RESTWO in", values, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoNotIn(List<String> values) {
            addCriterion("LP_RESTWO not in", values, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoBetween(String value1, String value2) {
            addCriterion("LP_RESTWO between", value1, value2, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpRestwoNotBetween(String value1, String value2) {
            addCriterion("LP_RESTWO not between", value1, value2, "lpRestwo");
            return (Criteria) this;
        }

        public Criteria andLpResthreeIsNull() {
            addCriterion("LP_RESTHREE is null");
            return (Criteria) this;
        }

        public Criteria andLpResthreeIsNotNull() {
            addCriterion("LP_RESTHREE is not null");
            return (Criteria) this;
        }

        public Criteria andLpResthreeEqualTo(String value) {
            addCriterion("LP_RESTHREE =", value, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeNotEqualTo(String value) {
            addCriterion("LP_RESTHREE <>", value, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeGreaterThan(String value) {
            addCriterion("LP_RESTHREE >", value, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeGreaterThanOrEqualTo(String value) {
            addCriterion("LP_RESTHREE >=", value, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeLessThan(String value) {
            addCriterion("LP_RESTHREE <", value, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeLessThanOrEqualTo(String value) {
            addCriterion("LP_RESTHREE <=", value, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeLike(String value) {
            addCriterion("LP_RESTHREE like", value, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeNotLike(String value) {
            addCriterion("LP_RESTHREE not like", value, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeIn(List<String> values) {
            addCriterion("LP_RESTHREE in", values, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeNotIn(List<String> values) {
            addCriterion("LP_RESTHREE not in", values, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeBetween(String value1, String value2) {
            addCriterion("LP_RESTHREE between", value1, value2, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResthreeNotBetween(String value1, String value2) {
            addCriterion("LP_RESTHREE not between", value1, value2, "lpResthree");
            return (Criteria) this;
        }

        public Criteria andLpResfourIsNull() {
            addCriterion("LP_RESFOUR is null");
            return (Criteria) this;
        }

        public Criteria andLpResfourIsNotNull() {
            addCriterion("LP_RESFOUR is not null");
            return (Criteria) this;
        }

        public Criteria andLpResfourEqualTo(String value) {
            addCriterion("LP_RESFOUR =", value, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourNotEqualTo(String value) {
            addCriterion("LP_RESFOUR <>", value, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourGreaterThan(String value) {
            addCriterion("LP_RESFOUR >", value, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourGreaterThanOrEqualTo(String value) {
            addCriterion("LP_RESFOUR >=", value, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourLessThan(String value) {
            addCriterion("LP_RESFOUR <", value, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourLessThanOrEqualTo(String value) {
            addCriterion("LP_RESFOUR <=", value, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourLike(String value) {
            addCriterion("LP_RESFOUR like", value, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourNotLike(String value) {
            addCriterion("LP_RESFOUR not like", value, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourIn(List<String> values) {
            addCriterion("LP_RESFOUR in", values, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourNotIn(List<String> values) {
            addCriterion("LP_RESFOUR not in", values, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourBetween(String value1, String value2) {
            addCriterion("LP_RESFOUR between", value1, value2, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfourNotBetween(String value1, String value2) {
            addCriterion("LP_RESFOUR not between", value1, value2, "lpResfour");
            return (Criteria) this;
        }

        public Criteria andLpResfiveIsNull() {
            addCriterion("LP_RESFIVE is null");
            return (Criteria) this;
        }

        public Criteria andLpResfiveIsNotNull() {
            addCriterion("LP_RESFIVE is not null");
            return (Criteria) this;
        }

        public Criteria andLpResfiveEqualTo(String value) {
            addCriterion("LP_RESFIVE =", value, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveNotEqualTo(String value) {
            addCriterion("LP_RESFIVE <>", value, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveGreaterThan(String value) {
            addCriterion("LP_RESFIVE >", value, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveGreaterThanOrEqualTo(String value) {
            addCriterion("LP_RESFIVE >=", value, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveLessThan(String value) {
            addCriterion("LP_RESFIVE <", value, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveLessThanOrEqualTo(String value) {
            addCriterion("LP_RESFIVE <=", value, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveLike(String value) {
            addCriterion("LP_RESFIVE like", value, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveNotLike(String value) {
            addCriterion("LP_RESFIVE not like", value, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveIn(List<String> values) {
            addCriterion("LP_RESFIVE in", values, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveNotIn(List<String> values) {
            addCriterion("LP_RESFIVE not in", values, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveBetween(String value1, String value2) {
            addCriterion("LP_RESFIVE between", value1, value2, "lpResfive");
            return (Criteria) this;
        }

        public Criteria andLpResfiveNotBetween(String value1, String value2) {
            addCriterion("LP_RESFIVE not between", value1, value2, "lpResfive");
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