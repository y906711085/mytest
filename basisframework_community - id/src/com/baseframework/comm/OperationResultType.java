package com.baseframework.comm;

/**
 * 操作结果类型
 * 
 * @author 王鸿钦
 * 
 *
 */
public enum OperationResultType {

	/**
	 * 操作成功
	 */
	Success,

	/**
	 * 操作取消或操作没引发任何变化
	 */
	NoChanged,

	/**
	 * 参数错误
	 */
	ParamError,

	/**
	 * 指定参数的数据不存在
	 */
	QueryNull,

	/**
	 * 权限不足
	 */
	PurviewLack,

	/**
	 * 非法操作
	 */
	IllegalOperation,

	/**
	 * 警告
	 */
	Warning,

	/**
	 * 操作引发错误
	 */
	Error,
}
