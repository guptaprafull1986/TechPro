package BridgePattern;

public class Pentagon extends Shape {
    public Pentagon(Color color) {
        super(color);
    }

    @Override
    String getShareName()
    {
        return Pentagon.class.getSimpleName();
    }
}
