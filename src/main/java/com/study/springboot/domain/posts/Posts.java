package com.study.springboot.domain.posts;

import com.study.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/*
* domain 패키지 : 소프트웨어에 대한 요구사항 혹은 문제 영역
* */
@Getter // Getter 메소드를 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // @Entity : JPA 어노테이션
        // 테이블과 링크될 클래스임을 나타냄.
        // 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭함
/*
* Entity 메소드 : Setter 메소드를 만들지 않는다.
* 대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는
* 메소드를 생성해야 함!!
*
* Setter 대신 생성자나 @Builder를 통해 최종값을 채운 후 DB에 삽입
* 값 변경이 필요한 경우 해당 이벤트에 맞는
* public 메소드를 호출하여 변경하는 것을 전제로 함
* */
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄
                                                        // 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다
                                            // 사용 이유 : 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용함
                                            // 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나 타입을 변경하고 싶거나 등의 경우에 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    /*
    * 빌더 패턴 : 어느 필드에 어떤 값을 채워야 할지 명확하게 인지할 수 있음
    * Example.builder()
    *        .a(a)
    *        .b(b)
    *        .build();
    * */
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
