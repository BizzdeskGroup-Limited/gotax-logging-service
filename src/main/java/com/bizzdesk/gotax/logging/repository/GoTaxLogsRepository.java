package com.bizzdesk.gotax.logging.repository;

import com.bizzdesk.gotax.logging.entity.GoTaxLogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoTaxLogsRepository extends PagingAndSortingRepository<GoTaxLogs, String> {

    Page<GoTaxLogs> findAll(Pageable pageable);
}
