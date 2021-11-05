package com.xsp.Initializer;

import com.xsp.Config.MyConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 基于Java的配置类加载Spring的应⽤上下⽂
        AnnotationConfigWebApplicationContext ctx = new
                AnnotationConfigWebApplicationContext();
        // 注册 Mvc 配置信息
        ctx.register(MyConfig.class);
        // 设置 ServletContext 上下⽂信息
        ctx.setServletContext(servletContext);
        //配置转发器 Dispatcher
        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        // 设置映射路径
        servlet.addMapping("/");
        // 启动时即实例化 Bean
        servlet.setLoadOnStartup(1);

    }
}
