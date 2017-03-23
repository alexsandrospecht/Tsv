package com.github.alexsandrospecht.helpers;

import com.github.alexsandrospecht.engine.Field;
import com.github.alexsandrospecht.engine.FieldWrapper;
import com.github.alexsandrospecht.engine.ParameterDTO;
import com.github.alexsandrospecht.enums.OperationType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.github.alexsandrospecht.helpers.LoaderHelper.loadFile;

/**
 * Created by alexsandrospecht on 17/03/17.
 */
public class TransformationHelper {

    public static final String CRLF = "\r\n";
    private static final String DEFAULT_FILE = "./saida.csv";
    public static final String COMMA = ",";

    public static void transform(ParameterDTO params) throws Exception {
        List<Field> fields = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        OperationType type;

        type = FieldWrapper.loadOperationType(loadFile(params.getTemplate()));
        fields = FieldWrapper.loadFields(loadFile(params.getTemplate()));

        fields.forEach(f -> {
            sb.append(f.getName());
            sb.append(COMMA);
        });

        sb.append("\n");

        TransformationHelper.cut(sb, loadFile(params.getInput()), type, COMMA, fields);

        final String filename = params.getOutput() == null ? DEFAULT_FILE : params.getOutput();
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sb.toString());
        }
    }

    private static StringBuilder cut(StringBuilder sb, Stream<String> stream, OperationType type, String separator, List<Field> fields) {
        stream.forEach(l -> {
            int lineLenght = l.length();

            fields.forEach(f -> {
                int start = f.getStart();
                int end = 0;
                if (OperationType.USER_DEFINED.equals(type)) {
                    end = f.getSize();
                } else {
                    end = f.getStart() + f.getSize();
                }

                if (lineLenght > start && lineLenght >= end) {
                    appendValue(sb, l.substring(f.getStart(), end), separator);
                }
            });

            sb.append(CRLF);
        });
        return sb;
    }

    private static void appendValue(StringBuilder sb, String value, String separator) {
        sb.append(value);
        sb.append(separator);
    }
}
