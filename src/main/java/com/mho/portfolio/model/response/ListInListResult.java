package com.mho.portfolio.model.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ListInListResult<E> extends CommonResult{
  private List<E> list;
}
