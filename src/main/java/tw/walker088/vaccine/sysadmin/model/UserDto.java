package tw.walker088.vaccine.sysadmin.model;


public interface UserDto {
    String getUser_email();
    String getFirst_name();
    String getLast_name();
    String getIs_activate();
    String getCreated_user();
    String getCreated_time();
    String getModified_user();
    String getModified_time();

    default String getFullName() {
        return getFirst_name().concat(" ").concat(getLast_name());
    }
}
