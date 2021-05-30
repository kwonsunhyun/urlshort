package com.musinsa.urlshort.repository;

import com.musinsa.urlshort.domain.UrlShort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlShort, Integer> {
    Optional<UrlShort> findByUrl(String req_url);
}
