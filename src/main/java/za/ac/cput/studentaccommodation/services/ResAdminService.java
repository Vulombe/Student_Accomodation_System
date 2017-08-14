package za.ac.cput.studentaccommodation.services;

import za.ac.cput.studentaccommodation.domain.ResAdmin;

import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
public interface ResAdminService {
    List<ResAdmin> getResAdmins();

    ResAdmin getResAdmin(Long empID);
}
