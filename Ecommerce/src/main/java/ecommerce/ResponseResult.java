package ecommerce;
class Code {
    public static int OK = 200;

    public static int ERROR = 400;
}

public class ResponseResult {
    private int code;
    private String message;
    private Object data;

    public static ResponseResult createOk(Object data){
        return createResponse(Code.OK, null, data);
    }

    public static ResponseResult createOkMessage(String message){
        return createResponse(Code.OK, message, null);
    }

    public static ResponseResult createErrMessage(String message){
        return createResponse(Code.ERROR, message, null);
    }

    private static ResponseResult createResponse(int code, String message, Object data){
        ResponseResult result = new ResponseResult();
        result.code = code;
        result.data = data;
        result.message = message;
        return result;
    }
    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

}
