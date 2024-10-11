package edu.apimagic.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface SupplierPagedRepository<Supplier> extends PagingAndSortingRepository<Supplier, Long> {

    Page findByName(String name, Pageable pageable);
}
