package com.qinzhiying.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2配置信息
 *
 * @author qzy
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket linkinQApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("LinkinQApi")
                .apiInfo(linkinQApiInfo())
                .groupName("LinkinQApi")
                .select()
                //只显示Linkinq路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/test/.*")))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(getParameterList());
    }

    /**
     * 添加head参数配置
     */
    private List<Parameter> getParameterList() {
//        ParameterBuilder username = new ParameterBuilder();
//        ParameterBuilder password = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
//        username.name("username")
//                .description("用户名")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false)
//                .defaultValue("nature")
//                .build();
//
//        password.name("password")
//                .description("密码")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .defaultValue("123456")
//                //设置false，表示clientId参数 非必填,可传可不传！
//                .required(false)
//                .build();
//        pars.add(username.build());
//        pars.add(password.build());
        return pars;
    }

    /**
     * ApiInfo配置
     * String	title	标题	Api Documentation
     * String	description	描述	Api Documentation
     * String	termsOfServiceUrl	服务条款网址	urn:tos
     * String	license	许可	Apache 2.0
     * String	licenseUrl	许可链接	http://www.apache.org/licenses/LICENSE-2.0
     * String	version	版本	1.0
     * Contact	Contact	维护人信息	null
     *
     * @return
     */
    private ApiInfo linkinQApiInfo() {
        return new ApiInfoBuilder()
                .title("LinkinQ-API文档")
                .description("本文档描述了（LinkinQ）接口定义")
                .version("1.0")
                .contact(new Contact("qzy", "", "993443784@qq.com"))
                .build();
    }
}
