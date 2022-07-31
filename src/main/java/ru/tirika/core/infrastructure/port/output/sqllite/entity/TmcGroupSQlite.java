package ru.tirika.core.infrastructure.port.output.sqllite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import ru.tirika.core.domain.entity.TmcGroup;

@Data
@Entity
@Table(name = "good_groups")
public class TmcGroupSQlite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_deleted")
    private Boolean isDeleted = Boolean.FALSE;
    private String name;
    @Column(name = "parent_id")
    private Long parentId = -1L;
    @Column(name = "foreign_id")
    private Long foreignId = -1L;
    private Long section = -1L;
    @Column(name = "is_published")
    private Boolean isPublished = Boolean.FALSE;
    @Column(name = "full_name")
    private String fullName;

    public static TmcGroupSQlite fromDomain(final TmcGroup tmcGroup) {
        final TmcGroupSQlite tmcGroupSQlite = new TmcGroupSQlite();
        tmcGroupSQlite.setId(tmcGroup.getId());
        tmcGroupSQlite.setName(tmcGroup.getName());
        tmcGroupSQlite.setFullName(tmcGroup.getName());
        tmcGroupSQlite.setParentId(-1L);
        return tmcGroupSQlite;
    }

    public static TmcGroup toDomain(final TmcGroupSQlite tmcGroupSQlite) {
        return new TmcGroup(tmcGroupSQlite.getId(), tmcGroupSQlite.getName());
    }
}
