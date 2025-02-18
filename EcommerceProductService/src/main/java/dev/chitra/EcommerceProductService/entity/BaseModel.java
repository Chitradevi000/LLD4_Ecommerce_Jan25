package dev.chitra.EcommerceProductService.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    /*why is this abstract class?
    because you should not create an obj of basemodel class*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @CreationTimestamp
    private Instant createdAt; // it ll store no of millisecs since Jan 1, 1970 UTC
    @UpdateTimestamp
    private Instant updatedAt; //instead of Timestamp, you can use Instant

}
