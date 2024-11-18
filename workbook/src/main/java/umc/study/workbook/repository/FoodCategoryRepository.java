package umc.study.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.workbook.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {


}
