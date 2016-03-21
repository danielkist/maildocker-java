package com.maildocker.api.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TemplateMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Address to;
	
	private String template;
	
	private Map<String, String> merge_vars;

	public void addVar(String key, Object value) {
		if(this.getMergeVars() == null) this.setMergeVars(new HashMap<String, String>());
		this.getMergeVars().put(key, value.toString());
	}
	
	public Address getTo() {
		return to;
	}

	public void setTo(Address to) {
		this.to = to;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Map<String, String> getMergeVars() {
		return merge_vars;
	}

	public void setMergeVars(Map<String, String> merge_vars) {
		this.merge_vars = merge_vars;
	}

}
