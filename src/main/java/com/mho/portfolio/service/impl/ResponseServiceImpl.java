package com.mho.portfolio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mho.portfolio.model.response.CommonResult;
import com.mho.portfolio.model.response.ListResult;
import com.mho.portfolio.model.response.SingleResult;
import com.mho.portfolio.service.ResponseService;

import lombok.Getter;

@Service
public class ResponseServiceImpl implements ResponseService{

	@Getter
	public enum CommonResponse {
		SUCCESS(0, "성공하였습니다."),
		FAIL(-1, "실패하였습니다.");
		
		int code;
		String msg;
		
		private CommonResponse(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}
	}
	
	@Override
	public <T> SingleResult<T> getSingleResult(T data) {
		SingleResult<T> result = new SingleResult<>();
		result.setData(data);
		setSuccessResult(result);
		return result;
	}

	@Override
	public <T> ListResult<T> getListResult(List<T> list) {
		ListResult<T> result = new ListResult<>();
		result.setList(list);
		setSuccessResult(result);
		return result;
	}

	@Override
	public CommonResult getSuccessResult() {
		CommonResult result = new CommonResult();
		setSuccessResult(result);
		return result;
	}

	@Override
	public CommonResult getFailResult() {
		CommonResult result = new CommonResult();
		result.setSuccess(false);
		result.setCode(CommonResponse.FAIL.getCode());
		result.setMsg(CommonResponse.FAIL.getMsg());
		return result;
	}
	
	private void setSuccessResult(CommonResult result) {
		result.setSuccess(true);
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMsg(CommonResponse.SUCCESS.getMsg());
	}

}
