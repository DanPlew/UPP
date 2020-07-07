package com.UPP.Serwer.RepositoryInterface;

import com.UPP.Serwer.Model.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UzytkownikDBRepository extends JpaRepository<Uzytkownik, Long> {
}