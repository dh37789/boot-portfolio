package com.mho.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mho.portfolio.advice.exception.AccessDeniedException;
import com.mho.portfolio.advice.exception.AuthenticationEntryPointException;
import com.mho.portfolio.model.response.CommonResult;

@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

  @GetMapping(value = "/entrypoint")
  public CommonResult entrypoionException() {
    throw new AuthenticationEntryPointException();
  }

  @GetMapping(value = "/accessdenied")
  public CommonResult accessdeniedException() {
    throw new AccessDeniedException();
  }
}
