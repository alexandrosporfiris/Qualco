package com.qualco.project.model.repository;

import com.qualco.project.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface LanguageRepository extends JpaRepository<Language, BigInteger> {
}
