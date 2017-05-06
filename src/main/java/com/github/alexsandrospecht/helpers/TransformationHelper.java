package com.github.alexsandrospecht.helpers;

import com.github.alexsandrospecht.engine.Field;
import com.github.alexsandrospecht.engine.FieldWrapper;
import com.github.alexsandrospecht.engine.ParameterDTO;
import com.github.alexsandrospecht.enums.OperationType;

import java.util.List;
import java.util.stream.Stream;

import static com.github.alexsandrospecht.helpers.FileHelper.loadStreamFromFile;


/**
 * Created by alexsandrospecht on 17/03/17.
 */
public class TransformationHelper {

    public static final String CRLF = "\r\n";
    private static final String DEFAULT_FILE = "./saida.csv";

    public static void transform(ParameterDTO params) throws Exception {
        final StringBuilder sb = new StringBuilder();
        final OperationType type = FieldWrapper.loadOperationType(loadStreamFromFile(params.getTemplate()));
        final List<Field> fields = FieldWrapper.loadFields(loadStreamFromFile(params.getTemplate()));

        fields.forEach(f -> {
            sb.append(f.getName());
            sb.append(params.getSeparator());
        });
        sb.append(CRLF);

        TransformationHelper.cut(sb, loadStreamFromFile(params.getInput()), type, params.getSeparator(), fields);

        final String filename = params.getOutput() == null ? DEFAULT_FILE : params.getOutput();
        FileHelper.writeFile(filename, sb);
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
                    if (f.isStringfy())
                        appendValue(sb, '"' + l.substring(f.getStart(), end) + '"', separator);
                    else
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
