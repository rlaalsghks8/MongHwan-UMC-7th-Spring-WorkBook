package umc.study.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.workbook.domain.Store;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store,Long> {

    Optional<Store> findById(Long id);
}
