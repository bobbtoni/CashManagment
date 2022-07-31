package ru.tirika.core.infrastructure.port.output.sqllite.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ru.tirika.core.application.port.TmcPort;
import ru.tirika.core.domain.entity.Tmc;
import ru.tirika.core.infrastructure.port.output.sqllite.entity.TmcSQlite;

@Repository
public interface TmcSqlLiteRepository extends JpaRepository<TmcSQlite, Long>, JpaSpecificationExecutor<TmcSQlite>, TmcPort {
    @Override
    default Tmc dropObject(Long id) {
        final TmcSQlite tmcSQlite = findById(id).get();
        tmcSQlite.setIsDeleted(true);
        final TmcSQlite savedTmc = save(tmcSQlite);
        return TmcSQlite.toDomain(savedTmc);
    }

    @Override
    default Tmc findObject(Long id) {
        TmcSQlite tmcSQlite = findById(id).orElse(null);
        return TmcSQlite.toDomain(tmcSQlite);
    }

    @Override
    default Collection<Tmc> findPartitionalObjects(long offset, long limit) {
        final Pageable pageable = new OffsetBasedPageRequest(offset, (int) limit);
        final Page<TmcSQlite> tmcsDb = findAll(pageable);
        final Collection<Tmc> tmcsDomain = new ArrayList<>();
        for (TmcSQlite tmcSQlite : tmcsDb.getContent()) {
            final Tmc tmcDomain = TmcSQlite.toDomain(tmcSQlite);
            tmcsDomain.add(tmcDomain);
        }
        return tmcsDomain;
    }

    @Override
    default Tmc saveObject(Tmc tmc) {
        final TmcSQlite tmcSQlite = TmcSQlite.fromDomain(tmc);
        final TmcSQlite savedTmcSQlite = save(tmcSQlite);
        return TmcSQlite.toDomain(savedTmcSQlite);
    }
}
