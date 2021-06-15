package com.study.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostsRepository : Posts클래스로 Database를 접근하게 해주는 클래스
 * 보통 IBATIS나 mYbATIS 등에서 Dao라고 불리는 DB Layer 접근자
 * JPA에선 Repository라고 부르며 인터페이스로 생성
 * 단순히 인터페이스 생성 후, JpaRepository<Entity 클래스, PK 타입>을 상속하면
 * 기본적인 CRUD 메소드가 자동으로 생성함
 *
 * Entity 클래스와 기본 EntityRepository는 함께 위치해야 한다다 * */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
