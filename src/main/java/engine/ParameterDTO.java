package engine;

/**
 * Created by alexsandrospecht on 20/03/17.
 */
public class ParameterDTO {

    private String input;

    private String template;

    private String output;

    public ParameterDTO(String input, String template, String output) {
        this.input = input;
        this.template = template;
        this.output = output;
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
}
