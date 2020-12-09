package com.koesob.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
// JPA Entity 클래스들이 얘 상속하면 얘가 갖고 있는 필드도 컬럼으로 인식
@MappedSuperclass
// Auditing 기능 포함 = 매번 자동으로 값 넣음, '감시하다, 감사하다' 란 뜻
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
