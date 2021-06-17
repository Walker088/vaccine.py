package tw.walker088.vaccine.sysadmin.model;


public interface UserViewDto {
    String getUser_email();
    String getFirst_name();
    String getLast_name();
    Integer getUser_state();
    String getCreated_user();
    String getCreated_time();
    String getModified_user();
    String getModified_time();

    default String getFullName() {
        return getFirst_name().concat(" ").concat(getLast_name());
    }
    default String getUserStateIcon() {
        if (getUser_state().equals(1)) return "<i class=\"far fa-check-circle\"></i>";
        if (getUser_state().equals(2)) return "<i class=\"far fa-times-circle\"></i>";
        if (getUser_state().equals(3)) return "<i class=\"fas fa-user-times\"></i>";
        return "<i class=\"far fa-question-circle\"></i>";
    }
}
