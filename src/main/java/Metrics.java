public enum Metrics {
    m(1000),
    cm(10),
    mm(1),
    km(1000000),
    dm(100);

    private int scale;

    Metrics(int scale) {
        this.scale = scale;
    }

    public int getScale() {
        return scale;
    }
}
