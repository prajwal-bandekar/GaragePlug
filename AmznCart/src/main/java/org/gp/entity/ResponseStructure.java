package org.gp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {
	private T Data;
	private String message;
	private int statusCode;
}
