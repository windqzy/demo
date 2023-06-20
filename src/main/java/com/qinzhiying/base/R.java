package com.qinzhiying.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 全局统一返回结果类
 */
@Data
@ApiModel(value = "全局统一返回结果")
public class R<T> {

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public R() {
    }

    protected static <T> R<T> build(T data) {
        R<T> result = new R<T>();
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static <T> R<T> build(T body, RMessage rMessage) {
        R<T> result = build(body);
        result.setCode(rMessage.getCode());
        result.setMessage(rMessage.getMessage());
        return result;
    }

    public static <T> R<T> build(Integer code, String message) {
        R<T> result = build(null);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> R<T> ok() {
        return R.ok(null);
    }

    /**
     * 操作成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R<T> ok(T data) {
        R<T> result = build(data);
        return build(data, RMessage.SUCCESS);
    }

    public static <T> R<T> fail() {
        return R.fail(null);
    }

    /**
     * 操作失败
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R<T> fail(T data) {
        R<T> result = build(data);
        return build(data, RMessage.FAIL);
    }

    public R<T> message(String msg) {
        this.setMessage(msg);
        return this;
    }

    public R<T> code(Integer code) {
        this.setCode(code);
        return this;
    }
}
