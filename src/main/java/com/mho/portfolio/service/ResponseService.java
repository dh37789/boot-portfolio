package com.mho.portfolio.service;

import com.mho.portfolio.model.response.ListInListResult;
import java.util.List;

import com.mho.portfolio.model.response.CommonResult;
import com.mho.portfolio.model.response.ListResult;
import com.mho.portfolio.model.response.SingleResult;

public interface ResponseService {
	public <T> SingleResult<T> getSingleResult(T data);
	public <T> ListResult<T> getListResult(List<T> list);
	public <E> ListInListResult<E> getListInListResult(List<E> list);
	public CommonResult getSuccessResult();
	public CommonResult getFailResult(int code, String msg);
}
