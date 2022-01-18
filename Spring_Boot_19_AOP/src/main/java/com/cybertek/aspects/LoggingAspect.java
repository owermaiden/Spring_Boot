package com.cybertek.aspects;

import com.cybertek.controller.ProductController;
import com.cybertek.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

//    @Pointcut("execution(* com.cybertek.controller.ProductController.*(..))") // pointcut tells where to apply...this means execute every method in that controller
//    public void pointcut(){}
//
//    @Before("pointcut()") // this is an Advice...it tells us When to apply this logging...
//    public void log(){
//        logger.info("-------------");
//    }
//
//
//    @Before("execution(* com.cybertek.controller.ProductController.*(..))") // we can combine pointcut and advice with this syntax...
//    public void beforeAdvice(){
//        logger.info("-----------");
//    }


//    //execution
//    @Pointcut("execution(* com.cybertek.controller.ProductController.up*(..))")   // method ismi up ile başlayan tüm methodlar...
//    private void anyUpdateOperation(){}
//
//    @Pointcut("execution(* com.cybertek.repository.ProductRepository.findById(Long))")  // this method çağırıldığında...
//    private void anyProductRepositoryFindById(){}
//
//    @Before("anyProductRepositoryFindById()")                                           // Bu methoddan önce bu uygulansın...
//    public void beforeProductRepoAdvice(JoinPoint joinPoint){
//        logger.info("Before(findById) -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }
//
//    @Before("anyUpdateOperation()")
//    public void beforeControllerAdvice1(JoinPoint joinPoint){
//        logger.info("Before -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }                                                                 // Method      Arguments          Target
//
    //within - this is class level...
    @Pointcut("within(com.cybertek.controller..*)") // under controller package any class, subpackages dahil..
    private void anyControllerOperation(){}

    @Pointcut("@within(org.springframework.stereotype.Service)") // @Service annotation olan tüm classlarda uygula - class level annotation
    private void anyServiceAnnotatedOperation(){}

    @Before("anyServiceAnnotatedOperation() || anyControllerOperation() ")
    public void beforeControllerAdvice2(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }                                                                                                    // get target class ın object ini veriyor...

    //annotation - this is method level pointcut...@within is class level
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteProductOperation(){}

    @Before("anyDeleteProductOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }

    //after returning - execution successfully done..
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetProductOperation(){}

    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Product results){
        logger.info("After Returning(Mono Result) -> Method : {} - results :{}",joinPoint.getSignature().toShortString(),results);
    }

    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice2(JoinPoint joinPoint, List<Product> results){
        logger.info("After Returning(List Result) -> Method : {} - results :{}",joinPoint.getSignature().toShortString(),results);
    }

    //after throwing - if execution throws an error...
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation(){}

    @AfterThrowing(pointcut = "anyGetPutProductOperation()",throwing = "exception")
    public void afterThrowingControllerAdvice(JoinPoint joinPoint,RuntimeException exception){
        logger.info("After Throwing(Send Email to L2 Team) -> Method: {} - Exception : {}",joinPoint.getSignature().toShortString(),exception.getMessage());
    }

    //after - do it after, good or bad..
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation2(){}

    @After("anyGetPutProductOperation2()")
    public void afterControllerAdvice(JoinPoint joinPoint){
        logger.info("After finally -> Method : {} - results :{}",joinPoint.getSignature().toShortString());
    }

    @After("anyGetPutProductOperation2()")
    public void afterControllerAdvice2(JoinPoint joinPoint){
        logger.info("After finally -> Method : {} - results :{}",joinPoint.getSignature().toShortString());
    }

    //around
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void anyPostProductOperation(){}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    private void anyPutProductOperation(){}

    @Around("anyPostProductOperation()") // combination of before and after.. performance metric
    public Object anyPostControllerAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        logger.info("Before(Method : {} - Parameters : {}",proceedingJoinPoint.getSignature().toShortString(),proceedingJoinPoint.getArgs());

        List<Product> results = new ArrayList<>();
        results =(List<Product>) proceedingJoinPoint.proceed(); // we have to proceed

        logger.info("After(Method: {} - Results : {}",proceedingJoinPoint.getSignature().toShortString(),results);

        return results;
    }

































}