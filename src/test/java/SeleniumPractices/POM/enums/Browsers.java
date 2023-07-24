package SeleniumPractices.POM.enums;

public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");
    private final String browser;

    Browsers(String browser) {
        this.browser = browser;
    }

    public String value() {
        return this.browser;
    }
}

