package gov.iti.jets.repo.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "admins", catalog = "restapi")
public class AdminEntity extends UserEntity implements Serializable {

    public AdminEntity() {

    }
}
