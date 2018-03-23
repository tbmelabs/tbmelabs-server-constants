package ch.tbmelabs.tv.core.authorizationserver.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.tbmelabs.tv.core.authorizationserver.domain.Scope;

@Repository
public interface ScopeCRUDRepository extends CrudRepository<Scope, Long> {
  Page<Scope> findAll(Pageable pageable);
}