package com.example.handle;

import com.example.Entity.Result;
import com.example.utlis.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shen on 2018/1/7.
 * 异常捕获方法
 */
@ControllerAdvice
public class ExceptionHandle {
// 这个方式就把异常捕获了 这样就不会报错了
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        return ResultUtil.error(0, e.getMessage());
    }
}
