package cine.peliculas;

public class Idioma {
    private String audio;
    private String subt;
    private boolean isSubt;

    public Idioma(String audio, String subt, boolean isSubt) {
        this.audio = audio;
        this.subt = subt;
        this.isSubt = isSubt;
    }

    public String getAudio() {
        return audio;
    }

    public String getSubt() {
        return subt;
    }

    public boolean isSubt() {
        return isSubt;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public void setSubt(String subt) {
        this.subt = subt;
    }

    public void setIsSubt(boolean isSubt) {
        this.isSubt = isSubt;
    }
}
