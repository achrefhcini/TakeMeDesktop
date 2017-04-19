package model.interfaces;

import model.entities.Session;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by SAW on 12/02/2017.
 */
public interface ICrudSession {
    public int afficheNbrSession(LocalDate from_date, LocalDate to_date, String plateform);
    public boolean ajouterSession(Session s);
}
