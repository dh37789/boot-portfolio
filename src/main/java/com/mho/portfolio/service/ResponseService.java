package com.mho.portfolio.service;

import java.util.List;

import com.mho.portfolio.model.response.CommonResult;
import com.mho.portfolio.model.response.ListResult;
import com.mho.portfolio.model.response.SingleResult;

public interface ResponseService {
	public <T> SingleResult<T> getSingleResult(T data);
	public <T> ListResult<T> getListResult(List<T> list);
	public CommonResult getSuccessResult();
	public CommonResult getFailResult();
}
