package com.example.demo1.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo1.R;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = NullPointerException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        e.printStackTrace();
        return mav;
    }
	
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public R myE(HttpServletRequest req, MyException e) {
		e.printStackTrace();
		return R.r(400, null, "自定义异常处理器");
	}
}
