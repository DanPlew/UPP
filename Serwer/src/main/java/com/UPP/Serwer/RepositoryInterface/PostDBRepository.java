package com.UPP.Serwer.RepositoryInterface;

import com.UPP.Serwer.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PostDBRepository extends JpaRepository<Post, Long> {

    @Transactional
    @Modifying
    @Query("Update Post p set p.wiadomosc = ?1 where p.id = ?2")
    void updatePost(String wiadomosc, Long id);
}
