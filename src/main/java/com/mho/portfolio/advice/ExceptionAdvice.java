package com.mho.portfolio.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mho.portfolio.advice.exception.AccessDeniedException;
import com.mho.portfolio.advice.exception.AuthenticationEntryPointException;
import com.mho.portfolio.advice.exception.CUserNotFoundException;
import com.mho.portfolio.advice.exception.LoginFailException;
import com.mho.portfolio.model.response.CommonResult;
import com.mho.portfolio.service.ResponseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {
	
	private final ResponseService responseService;
	
	private final MessageSource messageSource;
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected CommonResult defaultException(HttpServletRequest req, Exception e) {
		return responseService.getFailResult(Integer.valueOf(getMessage("unKnown.code")), getMessage("unKnown.msg"));
	}
	
	@ExceptionHandler(CUserNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected CommonResult userNotFoundException(HttpServletRequest req, CUserNotFoundException e) {
		return responseService.getFailResult(Integer.valueOf(getMessage("userNotFound.code")), getMessage("userNotFound.msg"));
	}

	@ExceptionHandler(LoginFailException.class)
	public CommonResult loginFailException(HttpServletRequest req, LoginFailException e) {
		return responseService.getFailResult(Integer.valueOf(getMessage("loginFail.code")), getMessage("loginFail.msg"));
	}
	
	@ExceptionHandler(AuthenticationEntryPointException.class)
	public CommonResult authenticationEntryPoionException(HttpServletRequest req, AuthenticationEntryPointException e) {
		return responseService.getFailResult(Integer.valueOf(getMessage("entryPoionException.code")), getMessage("entryPoionException.msg"));
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public CommonResult accessDeniedException(HttpServletRequest req, AccessDeniedException e) {
		return responseService.getFailResult(Integer.valueOf(getMessage("accessDeniedException.code")), getMessage("accessDeniedException.msg"));
	}
	
	private String getMessage(String code) {
		return getMessage(code, null);
	}

	private String getMessage(String code, Object[] args) {
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}
}
