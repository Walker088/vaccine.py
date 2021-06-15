package tw.walker088.vaccine.sysadmin.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.walker088.vaccine.sysadmin.model.User;
import tw.walker088.vaccine.sysadmin.model.UserDto;

@Repository
public interface UserRepository extends CrudRepository<User, String> {


    @Query(value = "SELECT ui.user_email\\:\\:TEXT, TRIM(ui.first_name) first_name, TRIM(ui.last_name) last_name, CASE WHEN ui.is_activate IS TRUE THEN '<i class=\"far fa-check-circle\"></i>' ELSE '<i class=\"far fa-times-circle\"></i>' END is_activate, ui.created_user\\:\\:TEXT, TO_CHAR(ui.created_time, 'YYYY-MM-DD HH24:MI:SS') created_time, ui.modified_user\\:\\:TEXT, TO_CHAR(ui.modified_time, 'YYYY-MM-DD HH24:MI:SS') modified_time FROM user_info ui",
        nativeQuery = true)
    List<UserDto> findAllUserAsDto();

}
