package br.com.todolist.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class Response<T> {
	private T data;
	private List<String> errors;
	
	public Response() {
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<String> getErrors() {
		if(CollectionUtils.isEmpty(errors)) {
			this.errors = new ArrayList<>();
		}
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public void addError(String error){
	    if(StringUtils.isEmpty(error)){
	        return;
        }
	    getErrors().add(error);
    }

	public boolean hasErrors() {
		return !CollectionUtils.isEmpty(getErrors());
	}
	
	

}
