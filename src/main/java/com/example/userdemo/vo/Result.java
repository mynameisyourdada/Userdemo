package com.example.userdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Result<T>{
        private Integer  code;
        private  String message;
        private  T data;

        public  static <T>  Result<T> success(){
            return  new Result<>(20000,"响应成功",null);
        }

        public  static <T>  Result<T> success(T data) {
            return new Result<>(20000, "响应成功", data);
        }

        public  static <T>  Result<T> success(String message) {
            return new Result<>(20000, message, null);
        }

        public  static <T>  Result<T> fail(  ) {

            return new Result<>(20001, "响应失败", null);
        }

        public  static <T>  Result<T> fail(Integer code) {

            return new Result<>(code, "响应失败", null);
        }
        public  static <T>  Result<T> fail(Integer code,T data) {

            return new Result<>(code, "响应失败",null );
        }

    }

