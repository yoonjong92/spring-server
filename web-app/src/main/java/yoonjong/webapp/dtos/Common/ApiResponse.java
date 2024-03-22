package yoonjong.webapp.dtos.Common;

public class ApiResponse<T> {

    private static final String SUCCESS_STATUS = "success";
    private static final String FAIL_STATUS = "fail";
    private static final String ERROR_STATUS = "error";

    private String status;
    private T data;
    private String message;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(SUCCESS_STATUS, data, null);
    }

    public static ApiResponse<?> success() {
        return new ApiResponse<>(SUCCESS_STATUS, null, null);
    }

    public static ApiResponse<?> fail() {
        return new ApiResponse<>(FAIL_STATUS, null, null);
    }

    public static ApiResponse<?> fail(String message) {
        return new ApiResponse<>(FAIL_STATUS, null, message);
    }

    public static ApiResponse<?> error(String message) {
        return new ApiResponse<>(ERROR_STATUS, null, message);
    }

    private ApiResponse(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}