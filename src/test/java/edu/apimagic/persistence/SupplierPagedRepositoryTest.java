package edu.apimagic.persistence;

import edu.apimagic.domain.SupplierRepository;
import edu.apimagic.domain.model.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierPagedRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    @Transactional
    @Rollback
    public void test() {
        for (int i = 0; i < 50; i++) {
            final Supplier supplier = new Supplier();
            supplier.setName("Supplier " + i);
            this.entityManager.persist(supplier);
        }

        final var page = this.supplierRepository.findByName("Supplier 3", PageRequest.of(0, 10));
        assertThat(page.getTotalElements()).isEqualTo(1);
    }
}
