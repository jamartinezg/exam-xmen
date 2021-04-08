package com.exercise.mutantes.beans;

public class GeneralResponse<T> {
	
	private T data;
	
	public GeneralResponse() {
		
	}

	public GeneralResponse(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
