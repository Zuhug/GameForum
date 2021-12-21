package top.zugovo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//如果我们要扩展SpringMVC, 官方建议我们这样去做

// 如果声明了这个注解, springboot中webmvc自动装配会失效
// 因为在WebMvcAutoConfiguration中有一个@ConditionalOnMissingBean({WebMvcConfigurationSupport.class})
// 只有在没有WebMvcConfigurationSupport的时候, 才会生效
// 但是@EnableWebMvc导入了DelegatingWebConfiguration, 然而这个类继承了WebMvcConfigurationSupport
// 所以一旦声明这个标签, 将会导致WebMvc自动装配失效

// @EnableWebMvc // 这玩意就是导入了一个类: DelegatingWebMvcConfiguration: 从容器中获取所有的webmvcconfig
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/toRegister").setViewName("register");
        registry.addViewController("/toLogin").setViewName("login");
        registry.addViewController("/poke-dex").setViewName("poke-dex");
        registry.addViewController("/detail").setViewName("detail");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/help").setViewName("help");
        registry.addViewController("/user/toTopicDetail").setViewName("user/topic-detail");
        registry.addViewController("/user/success").setViewName("user/index");
        registry.addViewController("/user/index").setViewName("user/index");
        registry.addViewController("/user/info.html").setViewName("user/info");
        registry.addViewController("/user/toTopic").setViewName("user/forum_topic");
        registry.addViewController("/user/artical").setViewName("/user/article-detail");
        registry.addViewController("/user/latest-change").setViewName("user/latest-change");
        registry.addViewController("/error/404").setViewName("error/404");
    }

    // /img/header/** 从C:/Users/headers/** 获取资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/header/**")
                .addResourceLocations("file:F:/Root/images/head/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                // 对/user/, /admin/ 下的资源进行拦截
                .addPathPatterns("/user/**", "/admin/**")
                // 静态资源放行
                .excludePathPatterns("/css/**", "/js/**", "/imgs/**");
    }
}