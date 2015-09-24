package net.objectof.connector;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class Parameter {

    public enum Hint {
        PASSWORD, DIRECTORY, FILE
    }

    private String value;
    private String title;
    private Hint hint;
    private List<Consumer<String>> valueListeners = new ArrayList<>();

    public Parameter() {
        this("", null);
    }

    public Parameter(String title) {
        this(title, null);
    }

    public Parameter(String title, Hint hint) {
        this.title = title;
        this.hint = hint;
    }

    public final String getTitle() {
        return title;
    }

    public String getValue() {
        if (value == null) { return ""; }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Hint getHint() {
        return hint;
    }

    public void setHint(Hint hint) {
        this.hint = hint;
    }

    public void addValueListener(Consumer<String> listener) {
        valueListeners.add(listener);
    }

    public void removeValueListener(Consumer<String> listener) {
        valueListeners.remove(listener);
    }
}
