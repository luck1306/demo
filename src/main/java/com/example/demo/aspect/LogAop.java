package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Component
@Slf4j
@Aspect
public class LogAop {
    @After("execution(* com.example.demo.*.*.*(..))")
    // within(com.example.demo.controller.*)
    // execution(* com.example.demo.controller.*.*(..))
    public void doAfterLogicProcess(JoinPoint joinPoint) {
        Integer argCnt = 0;
        ClassNameSeparate target = new ClassNameSeparate(joinPoint.getThis().getClass().getName(), '$');
        log.info("----------------[{}]-------------------", target.getOnlyClassName());
        log.info("kind : {}", joinPoint.getKind());
        log.info("----args start----");
        for (Object arg : joinPoint.getArgs()) {
            ClassNameSeparate argClassName = new ClassNameSeparate(arg.getClass().getName(), '@');
            log.info("arg{} : [{}]", argCnt, argClassName.getOnlyClassName());
            argCnt++;
        }
        log.info("----args end----");
        String exeMethod = joinPoint.toShortString();
        log.info("[EXECUTE METHOD] : {}", exeMethod.substring("execution(".length(), exeMethod.length()-1));
        log.info("--------------------------------------");
    }

    class ClassNameSeparate {
        private final String baseName;

        private final Integer endIndex;

        ClassNameSeparate(String baseName, Character excludePoint) {
            this.baseName = baseName;
            this.endIndex = baseName.indexOf(excludePoint);
        }

        public String getOnlyClassName() {
            return this.baseName.substring(0, this.endIndex == -1 ? this.baseName.length() : this.endIndex);
        }
    }
}
