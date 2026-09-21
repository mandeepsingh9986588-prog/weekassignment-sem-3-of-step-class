class TrafficLight {
    private final String lightId;
    private String currentColor;

    public TrafficLight(String lightId) {
        this.lightId = lightId;
        this.currentColor = "RED";
    }

    public String getLightId() {
        return lightId;
    }

    public String getColor() {
        return currentColor;
    }

    public String next() {
        if (currentColor.equals("RED")) {
            currentColor = "GREEN";
        } else if (currentColor.equals("GREEN")) {
            currentColor = "YELLOW";
        } else if (currentColor.equals("YELLOW")) {
            currentColor = "RED";
        }
        return currentColor;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
    }
}