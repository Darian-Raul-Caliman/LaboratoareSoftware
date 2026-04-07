package ro.ulbs.proiectaresoftware.lab5.advanced;


abstract class ACalculator {

    protected Object state;


    public Object result() {
        return this.state;
    }


    public ACalculator clear() {
        init();
        return this;
    }

    public abstract void init();
}
