package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성이 모두 자동으로 설정됨
// 특히 @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에
// 이 클래스는 항상 프로젝트의 최상단에 위치해야만 한다
@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    // 프로젝트의 메인 클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
