package ru.tirika.core.infrastructure.port.output.sqllite.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import ru.tirika.core.domain.entity.Tmc;

@Data
@Entity
@Table(name = "goods")
public class TmcSQlite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_id")
    private Long idGroup;
    private String name;
    private BigDecimal price;
    @Column(name = "is_deleted")
    private Boolean isDeleted = Boolean.FALSE;

    public static TmcSQlite fromDomain(Tmc tmc) {
        if (tmc == null) {
            return null;
        }
        TmcSQlite tmcSQlite = new TmcSQlite();
        tmcSQlite.setId(tmc.getId());
        tmcSQlite.setIdGroup(tmc.getIdGroup());
        tmcSQlite.setName(tmc.getName());
        tmcSQlite.setPrice(tmc.getPrice());

        return tmcSQlite;
    }

    public static Tmc toDomain(TmcSQlite tmcSQlite) {
        if (tmcSQlite == null) {
            return null;
        }
        final Tmc tmc = new Tmc(tmcSQlite.getId(), tmcSQlite.getName(), tmcSQlite.getPrice(), null, null);
        return tmc;
    }
}
