package com.education.common.util;

/**
 * 将结果封装，返回json对象
 * @author 
 *
 */
public class AjaxJson {
	
	//返回的信息
	public String msg="";
	//返回的状态 成功用0,失败用-1
	public Integer result=0;
	//返回的对象
	public Object obj;
	public String transCode;
	
	public AjaxJson(){}
	
	public AjaxJson(Integer result,String msg){
		this.result=result;
		this.msg=msg;
	}
	
	public AjaxJson(Integer result,Object obj){
		this.result=result;
		this.obj=obj;
	};
	
	public AjaxJson(Integer result,String msg,Object obj){
		this.obj=obj;
		this.result=result;
		this.msg=msg;
	}
	
	public AjaxJson(Integer result,String msg,String transCode){
		this.result=result;
		this.msg=msg;
		this.transCode=transCode;
	};
	
	public AjaxJson(Integer result,Object obj,String transCode){
		this.result=result;
		this.obj=obj;
		this.transCode=transCode;
	};
	
	public AjaxJson(Integer result,String msg,Object obj,String transCode){
		this.obj=obj;
		this.result=result;
		this.msg=msg;
		this.transCode=transCode;
	}
}
