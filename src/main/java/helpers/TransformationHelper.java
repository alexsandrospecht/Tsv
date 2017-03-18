package helpers;

import engine.Field;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by alexsandrospecht on 17/03/17.
 */
public class TransformationHelper {

    public static final String COMMA = ",";
    public static final String CRLF = "\r\n";

    public static StringBuilder transform(StringBuilder sb, Stream<String> stream, List<Field> fields) {
        stream.forEach(l -> {
            int lineLenght = l.length();

            fields.forEach(f -> {
                int start = f.getStart();
                int end = f.getStart() + f.getSize();

                if (lineLenght > start && lineLenght > end) {
                    appendValue(sb, l.substring(f.getStart(), end));
                }
            });

            sb.append(CRLF);
        });
        return sb;
    }

    private static void appendValue(StringBuilder sb, String value) {
        sb.append(value);
        sb.append(COMMA);
    }
}
