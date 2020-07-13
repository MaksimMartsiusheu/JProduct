package com.jhipster.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.jhipster.domain.Vendor;
import com.jhipster.domain.*; // for static metamodels
import com.jhipster.repository.VendorRepository;
import com.jhipster.service.dto.VendorCriteria;

/**
 * Service for executing complex queries for {@link Vendor} entities in the database.
 * The main input is a {@link VendorCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Vendor} or a {@link Page} of {@link Vendor} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class VendorQueryService extends QueryService<Vendor> {

    private final Logger log = LoggerFactory.getLogger(VendorQueryService.class);

    private final VendorRepository vendorRepository;

    public VendorQueryService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    /**
     * Return a {@link List} of {@link Vendor} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Vendor> findByCriteria(VendorCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Vendor> specification = createSpecification(criteria);
        return vendorRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Vendor} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Vendor> findByCriteria(VendorCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Vendor> specification = createSpecification(criteria);
        return vendorRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(VendorCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Vendor> specification = createSpecification(criteria);
        return vendorRepository.count(specification);
    }

    /**
     * Function to convert {@link VendorCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Vendor> createSpecification(VendorCriteria criteria) {
        Specification<Vendor> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Vendor_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Vendor_.name));
            }
            if (criteria.getCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCode(), Vendor_.code));
            }
        }
        return specification;
    }
}
