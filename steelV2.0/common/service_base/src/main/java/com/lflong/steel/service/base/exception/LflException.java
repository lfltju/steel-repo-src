package com.lflong.steel.service.base.exception;

import com.lflong.steel.common.base.result.ResultCodeEnum;
import lombok.Data;

@Data
public class LflException extends RuntimeException {

    private Integer code;

    public LflException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public LflException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "LflException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
