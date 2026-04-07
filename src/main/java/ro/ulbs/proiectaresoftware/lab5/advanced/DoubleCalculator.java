package ro.ulbs.proiectaresoftware.lab5.advanced;

class DoubleCalculator extends ACalculator {

    public DoubleCalculator(Double initialState) {
        this.state = initialState;
    }

    @Override
    public void init() {
        this.state = 0.0;
    }

    public DoubleCalculator add(Double value) {
        this.state = (Double) this.state + value;
        return this;
    }

    public DoubleCalculator subtract(Double value) {
        this.state = (Double) this.state - value;
        return this;
    }

    public DoubleCalculator multiply(Double value) {
        this.state = (Double) this.state * value;
        return this;
    }
}
