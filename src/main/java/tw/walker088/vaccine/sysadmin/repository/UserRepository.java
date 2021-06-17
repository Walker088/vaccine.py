package tw.walker088.vaccine.sysadmin.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tw.walker088.vaccine.sysadmin.model.User;
import tw.walker088.vaccine.sysadmin.model.UserRestDto;
import tw.walker088.vaccine.sysadmin.model.UserViewDto;

@Repository
public interface UserRepository extends CrudRepository<User, String> {


    @Query(value = "SELECT ui.user_email\\:\\:TEXT, TRIM(ui.first_name) first_name, TRIM(ui.last_name) last_name, ui.user_state, ui.created_user\\:\\:TEXT, TO_CHAR(ui.created_time, 'YYYY-MM-DD HH24:MI:SS') created_time, ui.modified_user\\:\\:TEXT, TO_CHAR(ui.modified_time, 'YYYY-MM-DD HH24:MI:SS') modified_time FROM user_info ui WHERE ui.user_state <> 3",
        nativeQuery = true)
    List<UserViewDto> findAllUserAsDto();

    @Query(value = "SELECT ui.user_email\\:\\:TEXT, TRIM(ui.first_name) first_name, TRIM(ui.last_name) last_name, CASE WHEN ui.user_state = 1 THEN 'ACTIVATE' WHEN ui.user_state = 2 THEN 'INACTIVATE' WHEN ui.user_state = 3 THEN 'DELETED' ELSE 'UNKNOWN' END user_state, ui.created_user\\:\\:TEXT, ui.created_time, ui.modified_user\\:\\:TEXT, ui.modified_time FROM user_info ui WHERE ui.user_email = :email",
        nativeQuery = true)
    UserRestDto findUserAsDto(@Param("email")  String email);

}
