package practice.budget_book.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    // 가계부 날짜
    // LocalDateTime은 년, 월, 일, 시간, 분, 초가 저장된다. 이 가계부 프로젝트에서는 30분 단위로 가계부를 작성할 수 있도록 할 예정
    private LocalDateTime transactionDateTime;

    // 거래 유형
    @Enumerated(EnumType.STRING) // enum타입을 String으로 저장. ORDINAL로 사용하면 0, 1,.. 대로 저장되는데
                                 // 나중에 순서를 바꿔야 할 경우가 생기면 데이터가 꼬이기 때문에 반드시 STRING으로 설정
    private TransactionType transactionType;

    // 금액
    private Long amount;

    // 구분
    private String category;

    // 상세내역
    private String memo;

    // 사용자
    @ManyToOne // 다대일 관계에서는 다 쪽에서 외래키를 가지고 있어야한다.
    @JoinColumn(name = "user_id")
    private User user;
}
