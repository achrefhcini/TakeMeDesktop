package model.entities;

/**
 * Created by SAW on 04/02/2017.
 */
public class Favoris {

    private int id_user;
    private int id_followed;

    public int getId_user() {
        return id_user;
    }

    public int getId_followed() {
        return id_followed;
    }

    public Favoris(int id_user, int id_follower) {
        this.id_user = id_user;
        this.id_followed = id_follower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Favoris that = (Favoris) o;

        if (id_user != that.id_user) return false;
        return id_followed == that.id_followed;
    }

    @Override
    public int hashCode() {
        int result = id_user;
        result = 31 * result + id_followed;
        return result;
    }

    @Override
    public String toString() {
        return "CrudFavoris{" +
                "id_user=" + id_user +
                ", id_follower=" + id_followed +
                '}';
    }
}
