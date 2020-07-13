package com.jhipster.service;

import com.jhipster.domain.Vendor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Vendor}.
 */
public interface VendorService {

    /**
     * Save a vendor.
     *
     * @param vendor the entity to save.
     * @return the persisted entity.
     */
    Vendor save(Vendor vendor);

    /**
     * Get all the vendors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Vendor> findAll(Pageable pageable);


    /**
     * Get the "id" vendor.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Vendor> findOne(Long id);

    /**
     * Delete the "id" vendor.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
