package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication   // @Configuration + @ComponentScan + @EnableAutoConfiguration....
                         // ComponentScan bu paket ve altındaki subpaketleri tarar....


public class SpringBoot01DemoApplication {

    public static void main(String[] args) {
       ApplicationContext container =  SpringApplication.run(SpringBoot01DemoApplication.class, args); // creates container and all the beans from component annotation

        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();

    }

}
