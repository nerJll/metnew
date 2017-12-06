package com.aixu.meeting.domain;

import java.util.ArrayList;
import java.util.List;

public class AixuAudioinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AixuAudioinfoExample() {
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

        public Criteria andAuIdIsNull() {
            addCriterion("AU_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuIdIsNotNull() {
            addCriterion("AU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuIdEqualTo(String value) {
            addCriterion("AU_ID =", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotEqualTo(String value) {
            addCriterion("AU_ID <>", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdGreaterThan(String value) {
            addCriterion("AU_ID >", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdGreaterThanOrEqualTo(String value) {
            addCriterion("AU_ID >=", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdLessThan(String value) {
            addCriterion("AU_ID <", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdLessThanOrEqualTo(String value) {
            addCriterion("AU_ID <=", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdLike(String value) {
            addCriterion("AU_ID like", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotLike(String value) {
            addCriterion("AU_ID not like", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdIn(List<String> values) {
            addCriterion("AU_ID in", values, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotIn(List<String> values) {
            addCriterion("AU_ID not in", values, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdBetween(String value1, String value2) {
            addCriterion("AU_ID between", value1, value2, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotBetween(String value1, String value2) {
            addCriterion("AU_ID not between", value1, value2, "auId");
            return (Criteria) this;
        }

        public Criteria andAuAccountIsNull() {
            addCriterion("AU_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAuAccountIsNotNull() {
            addCriterion("AU_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAuAccountEqualTo(String value) {
            addCriterion("AU_ACCOUNT =", value, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountNotEqualTo(String value) {
            addCriterion("AU_ACCOUNT <>", value, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountGreaterThan(String value) {
            addCriterion("AU_ACCOUNT >", value, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountGreaterThanOrEqualTo(String value) {
            addCriterion("AU_ACCOUNT >=", value, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountLessThan(String value) {
            addCriterion("AU_ACCOUNT <", value, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountLessThanOrEqualTo(String value) {
            addCriterion("AU_ACCOUNT <=", value, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountLike(String value) {
            addCriterion("AU_ACCOUNT like", value, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountNotLike(String value) {
            addCriterion("AU_ACCOUNT not like", value, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountIn(List<String> values) {
            addCriterion("AU_ACCOUNT in", values, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountNotIn(List<String> values) {
            addCriterion("AU_ACCOUNT not in", values, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountBetween(String value1, String value2) {
            addCriterion("AU_ACCOUNT between", value1, value2, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuAccountNotBetween(String value1, String value2) {
            addCriterion("AU_ACCOUNT not between", value1, value2, "auAccount");
            return (Criteria) this;
        }

        public Criteria andAuPasswordIsNull() {
            addCriterion("AU_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andAuPasswordIsNotNull() {
            addCriterion("AU_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andAuPasswordEqualTo(String value) {
            addCriterion("AU_PASSWORD =", value, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordNotEqualTo(String value) {
            addCriterion("AU_PASSWORD <>", value, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordGreaterThan(String value) {
            addCriterion("AU_PASSWORD >", value, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("AU_PASSWORD >=", value, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordLessThan(String value) {
            addCriterion("AU_PASSWORD <", value, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordLessThanOrEqualTo(String value) {
            addCriterion("AU_PASSWORD <=", value, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordLike(String value) {
            addCriterion("AU_PASSWORD like", value, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordNotLike(String value) {
            addCriterion("AU_PASSWORD not like", value, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordIn(List<String> values) {
            addCriterion("AU_PASSWORD in", values, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordNotIn(List<String> values) {
            addCriterion("AU_PASSWORD not in", values, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordBetween(String value1, String value2) {
            addCriterion("AU_PASSWORD between", value1, value2, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuPasswordNotBetween(String value1, String value2) {
            addCriterion("AU_PASSWORD not between", value1, value2, "auPassword");
            return (Criteria) this;
        }

        public Criteria andAuResoneIsNull() {
            addCriterion("AU_RESONE is null");
            return (Criteria) this;
        }

        public Criteria andAuResoneIsNotNull() {
            addCriterion("AU_RESONE is not null");
            return (Criteria) this;
        }

        public Criteria andAuResoneEqualTo(String value) {
            addCriterion("AU_RESONE =", value, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneNotEqualTo(String value) {
            addCriterion("AU_RESONE <>", value, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneGreaterThan(String value) {
            addCriterion("AU_RESONE >", value, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneGreaterThanOrEqualTo(String value) {
            addCriterion("AU_RESONE >=", value, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneLessThan(String value) {
            addCriterion("AU_RESONE <", value, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneLessThanOrEqualTo(String value) {
            addCriterion("AU_RESONE <=", value, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneLike(String value) {
            addCriterion("AU_RESONE like", value, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneNotLike(String value) {
            addCriterion("AU_RESONE not like", value, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneIn(List<String> values) {
            addCriterion("AU_RESONE in", values, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneNotIn(List<String> values) {
            addCriterion("AU_RESONE not in", values, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneBetween(String value1, String value2) {
            addCriterion("AU_RESONE between", value1, value2, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuResoneNotBetween(String value1, String value2) {
            addCriterion("AU_RESONE not between", value1, value2, "auResone");
            return (Criteria) this;
        }

        public Criteria andAuRestwoIsNull() {
            addCriterion("AU_RESTWO is null");
            return (Criteria) this;
        }

        public Criteria andAuRestwoIsNotNull() {
            addCriterion("AU_RESTWO is not null");
            return (Criteria) this;
        }

        public Criteria andAuRestwoEqualTo(String value) {
            addCriterion("AU_RESTWO =", value, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoNotEqualTo(String value) {
            addCriterion("AU_RESTWO <>", value, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoGreaterThan(String value) {
            addCriterion("AU_RESTWO >", value, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoGreaterThanOrEqualTo(String value) {
            addCriterion("AU_RESTWO >=", value, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoLessThan(String value) {
            addCriterion("AU_RESTWO <", value, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoLessThanOrEqualTo(String value) {
            addCriterion("AU_RESTWO <=", value, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoLike(String value) {
            addCriterion("AU_RESTWO like", value, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoNotLike(String value) {
            addCriterion("AU_RESTWO not like", value, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoIn(List<String> values) {
            addCriterion("AU_RESTWO in", values, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoNotIn(List<String> values) {
            addCriterion("AU_RESTWO not in", values, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoBetween(String value1, String value2) {
            addCriterion("AU_RESTWO between", value1, value2, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuRestwoNotBetween(String value1, String value2) {
            addCriterion("AU_RESTWO not between", value1, value2, "auRestwo");
            return (Criteria) this;
        }

        public Criteria andAuResthreeIsNull() {
            addCriterion("AU_RESTHREE is null");
            return (Criteria) this;
        }

        public Criteria andAuResthreeIsNotNull() {
            addCriterion("AU_RESTHREE is not null");
            return (Criteria) this;
        }

        public Criteria andAuResthreeEqualTo(String value) {
            addCriterion("AU_RESTHREE =", value, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeNotEqualTo(String value) {
            addCriterion("AU_RESTHREE <>", value, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeGreaterThan(String value) {
            addCriterion("AU_RESTHREE >", value, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeGreaterThanOrEqualTo(String value) {
            addCriterion("AU_RESTHREE >=", value, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeLessThan(String value) {
            addCriterion("AU_RESTHREE <", value, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeLessThanOrEqualTo(String value) {
            addCriterion("AU_RESTHREE <=", value, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeLike(String value) {
            addCriterion("AU_RESTHREE like", value, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeNotLike(String value) {
            addCriterion("AU_RESTHREE not like", value, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeIn(List<String> values) {
            addCriterion("AU_RESTHREE in", values, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeNotIn(List<String> values) {
            addCriterion("AU_RESTHREE not in", values, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeBetween(String value1, String value2) {
            addCriterion("AU_RESTHREE between", value1, value2, "auResthree");
            return (Criteria) this;
        }

        public Criteria andAuResthreeNotBetween(String value1, String value2) {
            addCriterion("AU_RESTHREE not between", value1, value2, "auResthree");
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