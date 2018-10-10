package com.assignment.exceptions;

public enum ErrorCode {


	TECH_ERROR("00001","TechnicalError");

    private String code;
    private String desc;

    ErrorCode(String code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }
    
    public String getCode() {
        return code;
    }


}
