package com.exercise.mutantes.beans;

public class GeneralRequest<T> {
	
	private T params;
	
	public GeneralRequest() {
		
	}

	public GeneralRequest(T params) {
		super();
		this.params = params;
	}

	public T getParams() {
		return params;
	}

	public void setParams(T params) {
		this.params = params;
	}

}
