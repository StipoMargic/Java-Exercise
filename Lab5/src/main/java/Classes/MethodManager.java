package Classes;

public class MethodManager {
    public String method;

    public MethodManager(String method) {
        this.method = method;
    }

    private boolean isMQTT() {
        return this.method == "MQTT";
    }
}
