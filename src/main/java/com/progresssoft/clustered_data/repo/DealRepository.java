package com.progresssoft.clustered_data.repo;

import com.progresssoft.clustered_data.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
    boolean existsById(Long dealId);

}
