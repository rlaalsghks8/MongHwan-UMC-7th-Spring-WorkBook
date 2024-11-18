package umc.study.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.workbook.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
