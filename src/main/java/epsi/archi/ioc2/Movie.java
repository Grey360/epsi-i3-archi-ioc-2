package epsi.archi.ioc2;

import java.time.LocalDate;

public class Movie {
    private String exploitationNumber;
    private String title;
    private String realisator;
    private int duration;
    private LocalDate releaseDate;
    private String category;

    public String getExploitationNumber() {
        return exploitationNumber;
    }

    public void setExploitationNumber(String exploitationNumber) {
        this.exploitationNumber = exploitationNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRealisator() {
        return realisator;
    }

    public void setRealisator(String realisator) {
        this.realisator = realisator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "exploitationNumber='" + exploitationNumber + '\'' +
                ", title='" + title + '\'' +
                ", realisator='" + realisator + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", category='" + category + '\'' +
                '}';
    }
}
