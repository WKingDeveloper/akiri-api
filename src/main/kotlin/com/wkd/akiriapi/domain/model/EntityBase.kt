package com.wkd.akiriapi.domain.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
abstract class EntityBase {
    @Version
    protected val version: Long? = null

    @field:CreationTimestamp
    @Column(
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
        insertable = false,
        updatable = false
    )
    val createdAt: Instant? = null

    @field:UpdateTimestamp
    @Column(
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
        insertable = false,
        updatable = false
    )
    val updatedAt: Instant? = null

}
