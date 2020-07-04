package au.com.totemsoft.serverless.elixir;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import au.com.totemsoft.serverless.elixir.config.AuthServerOAuth2Config;
import au.com.totemsoft.serverless.elixir.config.Encoders;
import au.com.totemsoft.serverless.elixir.config.HibernateConfiguration;
import au.com.totemsoft.serverless.elixir.config.ResourceServerConfiguration;
import au.com.totemsoft.serverless.elixir.config.ServerSecurityConfig;
import au.com.totemsoft.serverless.elixir.controller.SurveyController;
import au.com.totemsoft.serverless.elixir.service.SurveyApiImpl;
import au.com.totemsoft.serverless.elixir.service.UserDetailsServiceImpl;

@Configuration
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan("au.com.totemsoft.serverless.elixir")
@Import({
    SurveyController.class,
    SurveyApiImpl.class,
    UserDetailsServiceImpl.class,
    HibernateConfiguration.class,
    AuthServerOAuth2Config.class,
    Encoders.class,
    ResourceServerConfiguration.class,
    ServerSecurityConfig.class
})
public class SpringApiConfig {

    /*
     * Create required HandlerMapping, to avoid several default HandlerMapping instances being created
     */
    @Bean
    public HandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    /*
     * Create required HandlerAdapter, to avoid several default HandlerAdapter instances being created
     */
    @Bean
    public HandlerAdapter handlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }

    /*
     * optimization - avoids creating default exception resolvers; not required as the serverless container handles
     * all exceptions
     *
     * By default, an ExceptionHandlerExceptionResolver is created which creates many dependent object, including
     * an expensive ObjectMapper instance.
     * 
     * To enable custom @ControllerAdvice classes remove this bean.
     */
    @Bean
    public HandlerExceptionResolver handlerExceptionResolver() {
        return new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
                return null;
            }
        };
    }

}
