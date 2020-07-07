package com.UPP.Serwer.RepositoryInterface;

import com.UPP.Serwer.Model.Temat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TematDBRepository extends JpaRepository<Temat, Long> {

    @Transactional
    @Modifying
    @Query("Update Temat t set t.ostatnioDodane = ?1 where t.id = ?2")
    void updateTemat(String data, Long id);
}
