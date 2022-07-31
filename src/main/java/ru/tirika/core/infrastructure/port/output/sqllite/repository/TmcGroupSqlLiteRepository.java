package ru.tirika.core.infrastructure.port.output.sqllite.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ru.tirika.core.application.port.TmcGroupPort;
import ru.tirika.core.domain.entity.TmcGroup;
import ru.tirika.core.infrastructure.port.output.sqllite.entity.TmcGroupSQlite;

@Repository
public interface TmcGroupSqlLiteRepository extends JpaRepository<TmcGroupSQlite, Long>, JpaSpecificationExecutor<TmcGroupSQlite>, TmcGroupPort {

    @Override
    default TmcGroup dropObject(Long id) {
        final TmcGroupSQlite tmcGroupSQlite = findById(id).get();
        tmcGroupSQlite.setIsDeleted(true);
        final TmcGroupSQlite savedTmcGroup = save(tmcGroupSQlite);
        return TmcGroupSQlite.toDomain(savedTmcGroup);
    }

    @Override
    default TmcGroup findObject(Long id) {
        TmcGroupSQlite tmcFroupSQlite = findById(id).orElse(null);
        return TmcGroupSQlite.toDomain(tmcFroupSQlite);
    }

    @Override
    default Collection<TmcGroup> findPartitionalObjects(long offset, long limit) {
        final Pageable pageable = new OffsetBasedPageRequest(offset, (int) limit);
        final Page<TmcGroupSQlite> tmcGroupsDb = findAll(pageable);
        final Collection<TmcGroup> tmcGroupsDomain = new ArrayList<>();
        for (TmcGroupSQlite tmcGroupSQlite : tmcGroupsDb.getContent()) {
            final TmcGroup tmcGroupDomain = TmcGroupSQlite.toDomain(tmcGroupSQlite);
            tmcGroupsDomain.add(tmcGroupDomain);
        }
        return tmcGroupsDomain;
    }

    @Override
    default TmcGroup saveObject(TmcGroup tmcGroup) {
        final TmcGroupSQlite tmcGroupSQlite = TmcGroupSQlite.fromDomain(tmcGroup);
        final TmcGroupSQlite savedTmcGroupSQlite = save(tmcGroupSQlite);
        return TmcGroupSQlite.toDomain(savedTmcGroupSQlite);
    }

    @Override
    default TmcGroup saveChildGroup(TmcGroup tmcGroup, Long parentGroupid) {
        final TmcGroupSQlite tmcGroupSQlite = TmcGroupSQlite.fromDomain(tmcGroup);
        tmcGroupSQlite.setParentId(parentGroupid);
        final TmcGroupSQlite savedTmcGroupSQlite = save(tmcGroupSQlite);
        return TmcGroupSQlite.toDomain(savedTmcGroupSQlite);
    }
}
