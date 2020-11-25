package BridgePattern;

public class Yellow implements Color {
    @Override
    public String getColor() {
        return Yellow.class.getSimpleName();
    }
}
