package fashion.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration//This class is the equivalent of dispatcher-servlet.xml
@EnableWebMvc
@ComponentScan(basePackages = "fashion")
public class MyWebAppConfig implements WebMvcConfigurer {
    
//    @Autowired
//    StringToObjectSizeConverter_Example objectConverter;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/").setCachePeriod(Integer.MAX_VALUE);
    }
    
//     @Override
//    public void addFormatters(FormatterRegistry registry) {
////       registry.addConverter(this.objectConverter);
////     
//    }

}
