package com.example.userdemo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3307/db";
        String username="root";
        String password="123456";
        String table ="x_user";
        String module="sys";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("yao") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\Users\\GuaZI\\IdeaProjects\\Userdemo\\src\\main\\java"); // 指定输出目录
                })

                .packageConfig(builder -> {
                    builder.parent("com.example.userdemo") // 设置父包名
                            .moduleName(module) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "C:\\Users\\GuaZI\\IdeaProjects\\Userdemo\\src\\main\\resources\\mapper\\"+module)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(table); // 设置需要生成的表名
                    builder.addTablePrefix("x_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
