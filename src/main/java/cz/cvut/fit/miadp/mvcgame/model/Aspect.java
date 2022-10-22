package cz.cvut.fit.miadp.mvcgame.model;

public class Aspect {

    private String name;

    // and another properties appropriate for aspect
    // e.g. origin (like cannon), description etc.

    public Aspect( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

}
