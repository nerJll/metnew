/**
 * WorkflowServiceHttpBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aixu.meeting.oa.workflow;

import org.apache.axis.*;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.DeserializerFactory;
import org.apache.axis.encoding.SerializerFactory;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.encoding.ser.EnumDeserializerFactory;
import org.apache.axis.encoding.ser.EnumSerializerFactory;
import org.apache.axis.encoding.ser.SimpleDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListSerializerFactory;
import org.apache.axis.encoding.ser.SimpleSerializerFactory;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;
import javax.xml.namespace.*;
import javax.xml.*;


public class WorkflowServiceHttpBindingStub extends Stub implements com.aixu.meeting.oa.workflow.WorkflowServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static OperationDesc [] _operations;

    static {
        _operations = new OperationDesc[27];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("deleteRequest");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[0] = oper;

        oper = new OperationDesc();
        oper.setName("submitWorkflowRequest");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"), com.aixu.meeting.oa.workflow.WorkflowRequestInfo.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[1] = oper;

        oper = new OperationDesc();
        oper.setName("getToDoWorkflowRequestCount");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[2] = oper;

        oper = new OperationDesc();
        oper.setName("doCreateWorkflowRequest");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"), com.aixu.meeting.oa.workflow.WorkflowRequestInfo.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[3] = oper;

        oper = new OperationDesc();
        oper.setName("getCreateWorkflowRequestInfo");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestInfo.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[4] = oper;

        oper = new OperationDesc();
        oper.setName("getAllWorkflowRequestList");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[5] = oper;

        oper = new OperationDesc();
        oper.setName("getMyWorkflowRequestList");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[6] = oper;

        oper = new OperationDesc();
        oper.setName("getProcessedWorkflowRequestCount");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[7] = oper;

        oper = new OperationDesc();
        oper.setName("getWorkflowRequest");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestInfo.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[8] = oper;

        oper = new OperationDesc();
        oper.setName("getLeaveDays");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("getWorkflowRequest4split");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestInfo.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[10] = oper;

        oper = new OperationDesc();
        oper.setName("getHendledWorkflowRequestList");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[11] = oper;

        oper = new OperationDesc();
        oper.setName("getCreateWorkflowCount");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[12] = oper;

        oper = new OperationDesc();
        oper.setName("getToDoWorkflowRequestList");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[13] = oper;

        oper = new OperationDesc();
        oper.setName("getWorkflowNewFlag");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("webservices.services.weaver.com.cn", "ArrayOfString"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[14] = oper;

        oper = new OperationDesc();
        oper.setName("getCCWorkflowRequestList");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[15] = oper;

        oper = new OperationDesc();
        oper.setName("getCreateWorkflowList");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in5"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowBaseInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowBaseInfo[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("http://webservices.workflow.weaver", "WorkflowBaseInfo"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[16] = oper;

        oper = new OperationDesc();
        oper.setName("getCCWorkflowRequestCount");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[17] = oper;

        oper = new OperationDesc();
        oper.setName("getAllWorkflowRequestCount");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[18] = oper;

        oper = new OperationDesc();
        oper.setName("getWorkflowRequestLogs");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestLog"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestLog[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("http://webservices.workflow.weaver", "WorkflowRequestLog"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("getMyWorkflowRequestCount");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[20] = oper;

        oper = new OperationDesc();
        oper.setName("getProcessedWorkflowRequestList");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[21] = oper;

        oper = new OperationDesc();
        oper.setName("getCreateWorkflowTypeCount");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[22] = oper;

        oper = new OperationDesc();
        oper.setName("forwardWorkflowRequest");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[23] = oper;

        oper = new OperationDesc();
        oper.setName("writeWorkflowReadFlag");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(XMLType.AXIS_VOID);
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[24] = oper;

        oper = new OperationDesc();
        oper.setName("getHendledWorkflowRequestCount");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[25] = oper;

        oper = new OperationDesc();
        oper.setName("getCreateWorkflowTypeList");
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in3"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("webservices.services.weaver.com.cn", "in4"), ParameterDesc.IN, new QName("webservices.services.weaver.com.cn", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new QName("webservices.services.weaver.com.cn", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowBaseInfo"));
        oper.setReturnClass(com.aixu.meeting.oa.workflow.WorkflowBaseInfo[].class);
        oper.setReturnQName(new QName("webservices.services.weaver.com.cn", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("http://webservices.workflow.weaver", "WorkflowBaseInfo"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[26] = oper;

    }

    public WorkflowServiceHttpBindingStub() throws AxisFault {
         this(null);
    }

    public WorkflowServiceHttpBindingStub(java.net.URL endpointURL, Service service) throws AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public WorkflowServiceHttpBindingStub(Service service) throws AxisFault {
        if (service == null) {
            super.service = new Service();
        } else {
            super.service = service;
        }
        ((Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            QName qName;
            QName qName2;
            java.lang.Class beansf = BeanSerializerFactory.class;
            java.lang.Class beandf = BeanDeserializerFactory.class;
            java.lang.Class enumsf = EnumSerializerFactory.class;
            java.lang.Class enumdf = EnumDeserializerFactory.class;
            java.lang.Class arraysf = ArraySerializerFactory.class;
            java.lang.Class arraydf = ArrayDeserializerFactory.class;
            java.lang.Class simplesf = SimpleSerializerFactory.class;
            java.lang.Class simpledf = SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = SimpleListDeserializerFactory.class;
            qName = new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowBaseInfo");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowBaseInfo[].class;
            cachedSerClasses.add(cls);
            qName = new QName("http://webservices.workflow.weaver", "WorkflowBaseInfo");
            qName2 = new QName("http://webservices.workflow.weaver", "WorkflowBaseInfo");
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowDetailTableInfo");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowDetailTableInfo[].class;
            cachedSerClasses.add(cls);
            qName = new QName("http://webservices.workflow.weaver", "WorkflowDetailTableInfo");
            qName2 = new QName("http://webservices.workflow.weaver", "WorkflowDetailTableInfo");
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestInfo");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class;
            cachedSerClasses.add(cls);
            qName = new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo");
            qName2 = new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo");
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestLog");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowRequestLog[].class;
            cachedSerClasses.add(cls);
            qName = new QName("http://webservices.workflow.weaver", "WorkflowRequestLog");
            qName2 = new QName("http://webservices.workflow.weaver", "WorkflowRequestLog");
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestTableField");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowRequestTableField[].class;
            cachedSerClasses.add(cls);
            qName = new QName("http://webservices.workflow.weaver", "WorkflowRequestTableField");
            qName2 = new QName("http://webservices.workflow.weaver", "WorkflowRequestTableField");
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("http://webservices.workflow.weaver", "ArrayOfWorkflowRequestTableRecord");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowRequestTableRecord[].class;
            cachedSerClasses.add(cls);
            qName = new QName("http://webservices.workflow.weaver", "WorkflowRequestTableRecord");
            qName2 = new QName("http://webservices.workflow.weaver", "WorkflowRequestTableRecord");
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("http://webservices.workflow.weaver", "WorkflowBaseInfo");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowBaseInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://webservices.workflow.weaver", "WorkflowDetailTableInfo");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowDetailTableInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://webservices.workflow.weaver", "WorkflowMainTableInfo");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowMainTableInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://webservices.workflow.weaver", "WorkflowRequestInfo");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowRequestInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://webservices.workflow.weaver", "WorkflowRequestLog");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowRequestLog.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://webservices.workflow.weaver", "WorkflowRequestTableField");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowRequestTableField.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://webservices.workflow.weaver", "WorkflowRequestTableRecord");
            cachedSerQNames.add(qName);
            cls = com.aixu.meeting.oa.workflow.WorkflowRequestTableRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("webservices.services.weaver.com.cn", "ArrayOfArrayOfString");
            cachedSerQNames.add(qName);
            cls = java.lang.String[][].class;
            cachedSerClasses.add(cls);
            qName = new QName("webservices.services.weaver.com.cn", "ArrayOfString");
            qName2 = new QName("webservices.services.weaver.com.cn", "ArrayOfString");
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("webservices.services.weaver.com.cn", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new QName("webservices.services.weaver.com.cn", "string");
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

    }

    protected Call createCall() throws java.rmi.RemoteException {
        try {
            Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        QName qName =
                                (QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof SerializerFactory) {
                            SerializerFactory sf = (SerializerFactory)
                                 cachedSerFactories.get(i);
                            DeserializerFactory df = (DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public boolean deleteRequest(int in0, int in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.deleteRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "deleteRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String submitWorkflowRequest(com.aixu.meeting.oa.workflow.WorkflowRequestInfo in0, int in1, int in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.submitWorkflowRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "submitWorkflowRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, new java.lang.Integer(in1), new java.lang.Integer(in2), in3, in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getToDoWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getToDoWorkflowRequestCount");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getToDoWorkflowRequestCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String doCreateWorkflowRequest(com.aixu.meeting.oa.workflow.WorkflowRequestInfo in0, int in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.doCreateWorkflowRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "doCreateWorkflowRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, new java.lang.Integer(in1)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestInfo getCreateWorkflowRequestInfo(int in0, int in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getCreateWorkflowRequestInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getCreateWorkflowRequestInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestInfo.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestInfo[] getAllWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getAllWorkflowRequestList");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getAllWorkflowRequestList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2), new java.lang.Integer(in3), in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestInfo[] getMyWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getMyWorkflowRequestList");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getMyWorkflowRequestList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2), new java.lang.Integer(in3), in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getProcessedWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getProcessedWorkflowRequestCount");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getProcessedWorkflowRequestCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestInfo getWorkflowRequest(int in0, int in1, int in2) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getWorkflowRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getWorkflowRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestInfo.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String getLeaveDays(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getLeaveDays");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getLeaveDays"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2, in3, in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestInfo getWorkflowRequest4Split(int in0, int in1, int in2, int in3) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getWorkflowRequest4split");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getWorkflowRequest4split"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2), new java.lang.Integer(in3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestInfo.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestInfo[] getHendledWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getHendledWorkflowRequestList");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getHendledWorkflowRequestList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2), new java.lang.Integer(in3), in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getCreateWorkflowCount(int in0, int in1, java.lang.String[] in2) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getCreateWorkflowCount");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getCreateWorkflowCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestInfo[] getToDoWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getToDoWorkflowRequestList");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getToDoWorkflowRequestList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2), new java.lang.Integer(in3), in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getWorkflowNewFlag(java.lang.String[] in0, java.lang.String in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getWorkflowNewFlag");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getWorkflowNewFlag"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestInfo[] getCCWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getCCWorkflowRequestList");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getCCWorkflowRequestList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2), new java.lang.Integer(in3), in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowBaseInfo[] getCreateWorkflowList(int in0, int in1, int in2, int in3, int in4, java.lang.String[] in5) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getCreateWorkflowList");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getCreateWorkflowList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2), new java.lang.Integer(in3), new java.lang.Integer(in4), in5});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowBaseInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowBaseInfo[]) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowBaseInfo[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getCCWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getCCWorkflowRequestCount");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getCCWorkflowRequestCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getAllWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getAllWorkflowRequestCount");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getAllWorkflowRequestCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestLog[] getWorkflowRequestLogs(java.lang.String in0, java.lang.String in1, int in2, int in3, int in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getWorkflowRequestLogs");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getWorkflowRequestLogs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, new java.lang.Integer(in2), new java.lang.Integer(in3), new java.lang.Integer(in4)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestLog[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestLog[]) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestLog[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getMyWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getMyWorkflowRequestCount");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getMyWorkflowRequestCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowRequestInfo[] getProcessedWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getProcessedWorkflowRequestList");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getProcessedWorkflowRequestList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2), new java.lang.Integer(in3), in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowRequestInfo[]) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowRequestInfo[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getCreateWorkflowTypeCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getCreateWorkflowTypeCount");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getCreateWorkflowTypeCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String forwardWorkflowRequest(int in0, java.lang.String in1, java.lang.String in2, int in3, java.lang.String in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.forwardWorkflowRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "forwardWorkflowRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), in1, in2, new java.lang.Integer(in3), in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void writeWorkflowReadFlag(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.writeWorkflowReadFlag");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "writeWorkflowReadFlag"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getHendledWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getHendledWorkflowRequestCount");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getHendledWorkflowRequestCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aixu.meeting.oa.workflow.WorkflowBaseInfo[] getCreateWorkflowTypeList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:com.aixu.meeting.oa.workflow.WorkflowService.getCreateWorkflowTypeList");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("webservices.services.weaver.com.cn", "getCreateWorkflowTypeList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(in0), new java.lang.Integer(in1), new java.lang.Integer(in2), new java.lang.Integer(in3), in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aixu.meeting.oa.workflow.WorkflowBaseInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aixu.meeting.oa.workflow.WorkflowBaseInfo[]) JavaUtils.convert(_resp, com.aixu.meeting.oa.workflow.WorkflowBaseInfo[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
