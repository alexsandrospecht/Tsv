import engine.Field;
import engine.FieldWrapper;
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

    public static void main(String[] args) throws Exception {

        fields = FieldWrapper.loadFields(loadFile(args[1]));

        fields.forEach(f -> {
            sb.append(f.getName());
            sb.append(",");
        });

        sb.append("\n");

        TransformationHelper.transform(sb, loadFile(args[0]), fields);

        File file = new File("./saida.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sb.toString());
        }
    }

}
