package com.hs.shop.domain;

public class R {
    private int code;  // 响应状态码
    private String msg;    // 响应信息
    private Object data;   // 响应数据

    public static  R ok() {
        return result(null, 200, "操作成功");
    }
    public static  R ok(Object data) {
        return result(data, 200, "操作成功");
    }

    public static  R ok(String msg) {
        return result(null, 200, msg);
    }

    public static  R ok(int code,String msg) {
        return result(null, code, msg);
    }

    public static  R ok(Object data, String msg) {
        return result(data, 200, msg);
    }

    public static  R failed(int code) {
        return result(null, code, "操作失败");
    }

    public static  R failed(int code,String msg)
    {
        return result(null, code, msg);
    }

    private static  R result(Object data, int code, String msg) {
        R result = new R();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
