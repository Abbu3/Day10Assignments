package com.java.wipro.FirstSpringProject;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.java.wipro.FirstSpringProject.configuration.ConfigurationClass;
import com.java.wipro.FirstSpringProject.pojo.Address;
import com.java.wipro.FirstSpringProject.pojo.Employee;
import com.java.wipro.FirstSpringProject.repository.EmployeeRepositoryImpl;
import com.java.wipro.FirstSpringProject.service.EmployeeServiceImpl;

/**
 * Hello world!
 *
 */

//@Configuration
//@ComponentScan(basePackages = "com.java.wipro.FirstSpringProject.pojo")
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
//      Object bean = applicationContext.getBean("emp", Employee.class);
//      System.out.println(bean);
//      Object bean1 = applicationContext.getBean("emp", Employee.class);
//      System.out.println(bean1);

       
//       Employee bean1 = applicationContext.getBean("emp", Employee.class);
//       System.out.println("Employee class items " +bean1);
//       System.out.println("Employee class " +bean1.getClass());
//       
//       
//       Address bean2 = applicationContext.getBean("addr", Address.class);
//       System.out.println("Address class items " +bean2);
//       System.out.println("Address class " +bean2.getClass());
       
       
   
       
       
       
       EmployeeServiceImpl bean3 = applicationContext.getBean(EmployeeServiceImpl.class);
       
       bean3.items();
       
       Employee bean4 = applicationContext.getBean("employee", Employee.class);
       System.out.println(bean4);
       
       
       
    }
}
