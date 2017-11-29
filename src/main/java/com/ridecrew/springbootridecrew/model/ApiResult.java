package com.ridecrew.springbootridecrew.model;

public class ApiResult<T> {
	private boolean success = true;
	private String version = "v1";
	private ApiError error;
	private T data;
	
	public ApiResult() {

    }

    public ApiResult(T data) {
        this.data = data;
    }

    public ApiResult(Throwable e, ApiErrorCode errorCode, String message) {
        this.error = new ApiError(ApiErrorType.UNKNOWN, errorCode, message, e);
        this.success = false;
    }
    
    public ApiResult(Throwable e) {
        this.error = new ApiError(e);
        this.success = false;
    }
    
    public ApiResult(ApiErrorType type, ApiErrorCode errorCode, String message) {
        this.error = new ApiError(type, errorCode, message);
        this.success = false;
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ApiError getError() {
		return error;
	}

	public void setError(ApiError error) {
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
    
}
