package engine;

import enums.OperationType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

/**
 * Created by alexsandrospecht on 17/03/17.
 */
public class FieldWrapper {

    private static final String SEPARATOR = ";";

    public static List<Field> loadFields(Stream<String> fieldStream) {
        final List<Field> fields = new ArrayList<>();

        fieldStream.forEach(s -> {
            if (!s.contains("OPERATION=")) {
                String[] retorno = s.split(SEPARATOR);

                if (retorno.length == 3) {
                    String name = retorno[0];
                    int start = parseInt(retorno[1]);
                    int end = parseInt(retorno[2]);

                    fields.add(new Field(name, start, end));
                }
            }
        });

        return fields;
    }

    public static OperationType loadOperationType(Stream<String> fieldStream) throws Exception {
        String[] retorno = fieldStream.findFirst().get().split("=");

        if (retorno != null && retorno.length == 2) {
            if (("OPERATION").equals(retorno[0])) {
                OperationType type = OperationType.valueOf(retorno[1]);

                if (type != null)
                    return type;
            }
        }
        throw new Exception("OPERATION NOT DEFINED!");
    }
}
