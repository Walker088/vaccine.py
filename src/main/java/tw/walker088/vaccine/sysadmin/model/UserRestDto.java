package tw.walker088.vaccine.sysadmin.model;

import java.time.LocalDateTime;

public interface UserRestDto {
    String getUser_email();
    String getFirst_name();
    String getLast_name();
    String getUser_state();
    String getCreated_user();
    LocalDateTime getCreated_time();
    String getModified_user();
    LocalDateTime getModified_time();

    default String getFullName() {
        return getFirst_name().concat(" ").concat(getLast_name());
    }
}
