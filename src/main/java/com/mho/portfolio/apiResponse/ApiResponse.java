package com.mho.portfolio.apiResponse;

import java.util.List;

import lombok.*;

@Getter @Setter
@RequiredArgsConstructor
public abstract class ApiResponse<T> {
	@NonNull private T data;
	private List<String> errors;
}
