package com.example.carscaninterview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

import static com.example.carscaninterview.utils.CustomUtil.uuid;

@MappedSuperclass
@Data
public abstract class Base {

    @Id
    @Column(unique = true, updatable = false, nullable = false, length = 100)
    String uuid = uuid();

    @CreationTimestamp
    @JsonIgnore
    @Column(updatable = false, nullable = false)
    Timestamp ctime;

    @UpdateTimestamp
    @JsonIgnore
    @Column(nullable = false)
    Timestamp mtime;

    @JsonIgnore
    @Column(nullable = false)
    boolean deleted = false;

}