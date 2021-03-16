package Entities;

import java.util.Objects;

/**
 * @author tfifha youssef
 */
public class Oeuvre {
    private int ID_Oeuvre;
    private String NomOeuvre;
    private float PrixOeuvre;
    private int ID_Artiste;
    private String Image;
    public Oeuvre() {
    }

    public Oeuvre(int ID_Oeuvre, String nomOeuvre, float prixOeuvre, int ID_Artiste, String image) {
        this.ID_Oeuvre = ID_Oeuvre;
        NomOeuvre = nomOeuvre;
        PrixOeuvre = prixOeuvre;
        this.ID_Artiste = ID_Artiste;
        Image = image;
    }

    public Oeuvre(int ID_Oeuvre, String nomOeuvre, float prixOeuvre, int ID_Artiste) {
        this.ID_Oeuvre = ID_Oeuvre;
        NomOeuvre = nomOeuvre;
        PrixOeuvre = prixOeuvre;
        this.ID_Artiste = ID_Artiste;
    }

    public Oeuvre(String nomOeuvre, float prixOeuvre) {
        NomOeuvre = nomOeuvre;
        PrixOeuvre = prixOeuvre;
    }

    public Oeuvre(int ID_Oeuvre, String nomOeuvre, float prixOeuvre) {
        this.ID_Oeuvre = ID_Oeuvre;
        NomOeuvre = nomOeuvre;
        PrixOeuvre = prixOeuvre;
    }

    public int getID_Oeuvre() {
        return ID_Oeuvre;
    }

    public void setID_Oeuvre(int ID_Oeuvre) {
        this.ID_Oeuvre = ID_Oeuvre;
    }

    public String getNomOeuvre() {
        return NomOeuvre;
    }

    public void setNomOeuvre(String nomOeuvre) {
        NomOeuvre = nomOeuvre;
    }

    public float getPrixOeuvre() {
        return PrixOeuvre;
    }

    public void setPrixOeuvre(float prixOeuvre) {
        PrixOeuvre = prixOeuvre;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Override
    public String toString() {
        return "Oeuvre{" +
                "ID_Oeuvre=" + ID_Oeuvre +
                ", NomOeuvre='" + NomOeuvre + '\'' +
                ", PrixOeuvre=" + PrixOeuvre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Oeuvre oeuvre = (Oeuvre) o;
        return getID_Oeuvre () == oeuvre.getID_Oeuvre () && Float.compare (oeuvre.getPrixOeuvre (), getPrixOeuvre ()) == 0 && Objects.equals (getNomOeuvre (), oeuvre.getNomOeuvre ());
    }
}

