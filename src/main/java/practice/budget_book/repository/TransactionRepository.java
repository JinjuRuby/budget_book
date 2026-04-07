package practice.budget_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.budget_book.entity.Transaction;
import practice.budget_book.entity.TransactionType;
import practice.budget_book.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // 기본 전체 조회
    List<Transaction> findByUser(User user);

    // 특정 기간 내역 조회
    List<Transaction> findByUserAndTransactionDateTimeBetween(User user, LocalDateTime startTime, LocalDateTime endTime);

    // 수입/지출 유형별 내역 조회
    List<Transaction> findByUserAndTransactionType(User user, TransactionType type);

    // 카테고리별 내역 조회
    List<Transaction> findByUserAndCategory(User user, String category);
}
