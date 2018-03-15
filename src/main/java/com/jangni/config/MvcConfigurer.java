package com.jangni.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @Description: 通过实现接口配置全局特性
 * @Autor: Jangni
 * @Date: Created in  2018/2/24/024 22:26
 */
@Configuration
@EnableWebMvc
public class MvcConfigurer implements WebMvcConfigurer {

    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }
    /* 配置内容裁决的一些选项*/
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    //格式化
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    //拦截器 对特定的URI设定拦截器以检查用户是否登录
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        interceptorRegistry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/valid/**");
    }
    /**
     *静态资源处理
     */
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    //跨域访问配置
    public void addCorsMappings(CorsRegistry corsRegistry) {

        corsRegistry.addMapping("api/**")
                .allowedOrigins("http://domain2.com")
                .allowedHeaders("POST","GET");
    }

    //URI到视图的映射
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/index.html").setViewName("/valid.btl");
        viewControllerRegistry.addRedirectViewController("/**/*.do","/index.html");
    }
    /**
     * 这里配置视图解析器
     */
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }
    /*参数解析*/
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }
    /*返回值解析*/
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }
    /*异常处理*/
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    //验证器
    public Validator getValidator() {
        return null;
    }

    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
