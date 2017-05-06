package com.github.alexsandrospecht.engine;

/**
 * Created by alexsandrospecht on 20/03/17.
 */
public class ParameterDTO {

    private String input;

    private String template;

    private String output;

    private String separator;

    public ParameterDTO(String input, String template, String output, String separator) {
        this.input = input;
        this.template = template;
        this.output = output;
        this.separator = separator == "" ? "," : separator;
    }

    public String getInput() {
        return input;
    }

    public String getTemplate() {
        return template;
    }

    public String getOutput() {
        return output;
    }

    public String getSeparator() { return separator; }
}
