import engine.Field;
import engine.FieldWrapper;
import enums.OperationType;
import helpers.TransformationHelper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static helpers.LoaderHelper.loadFile;

/**
 * Created by alexsandrospecht on 16/03/17.
 */
public class Tsv {

    private static List<Field> fields = new ArrayList<>();

    private static StringBuilder sb = new StringBuilder();

    private static OperationType type;

    /**
     * args[0] INPUT_FILE
     * args[1] TEMPLATE_FILE
     */
    public static void main(String[] args) throws Exception {

        type = FieldWrapper.loadOperationType(loadFile(args[1]));
        fields = FieldWrapper.loadFields(loadFile(args[1]));

        fields.forEach(f -> {
            sb.append(f.getName());
            sb.append(",");
        });

        sb.append("\n");

        TransformationHelper.transform(sb, loadFile(args[0]), type, fields);

        File file = new File("./saida.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sb.toString());
        }
    }

}
