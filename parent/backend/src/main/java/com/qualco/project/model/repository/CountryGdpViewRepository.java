package com.qualco.project.model.repository;

import com.qualco.project.model.view.CountryGdpView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryGdpViewRepository extends JpaRepository<CountryGdpView, String>, JpaSpecificationExecutor<CountryGdpView> {
}
