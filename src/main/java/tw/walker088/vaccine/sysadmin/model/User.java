package tw.walker088.vaccine.sysadmin.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class User {
    @Id
    private String user_email;

    @Column(name = "user_pass", nullable = false)
    private String user_pass;

    @Column(name = "first_name", length = 30)
    private String first_name;

    @Column(name = "last_name", length = 30)
    private String last_name;

    @Column(name = "user_state", nullable = false)
    private Integer user_state;

    @Column(name = "created_user", nullable = false)
    private String created_user;

    @CreationTimestamp
    @Column(name = "created_time", nullable = false, updatable = false)
    private LocalDateTime created_time;

    @Column(name = "modified_user", nullable = false)
    private String modified_user;

    @UpdateTimestamp
    @Column(name = "modified_time", nullable = false)
    private LocalDateTime modified_time;
}
