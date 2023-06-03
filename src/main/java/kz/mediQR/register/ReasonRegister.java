package kz.mediQR.register;

import kz.mediQR.model.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReasonRegister extends JpaRepository<Reason, Long> {

    @Modifying
    @Query(value = "insert into reason (id, name) values (:id, :name)", nativeQuery = true)
    @Transactional
    void addReason(@Param("id") String id, @Param("name") String name);
}
