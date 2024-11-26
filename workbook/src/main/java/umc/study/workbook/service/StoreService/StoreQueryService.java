package umc.study.workbook.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.workbook.domain.Review;
import umc.study.workbook.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
