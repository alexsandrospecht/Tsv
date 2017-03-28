package tests;

import com.github.alexsandrospecht.Tsv;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.*;


/**
 * Created by Alexsandro on 27/03/2017.
 */
public class TsvTests {

    private final static String INPUT = new File(TsvTests.class.getResource("/INPUT_1.txt").getFile()).getAbsolutePath();
    private final static String TEMPLATE = new File(TsvTests.class.getResource("/TEMPLATE.txt").getFile()).getAbsolutePath();
    private final static String OUTPUT = "saida.csv";

    @Test
    public void fileTrasform() throws Exception {
        Tsv.main(new String[]{INPUT, TEMPLATE, OUTPUT});

        File actualFile = new File(OUTPUT);
        File expectedFile = new File(TsvTests.class.getResource("/SAIDA_1.csv").getFile());

        assertThat(actualFile).hasSameContentAs(expectedFile);
    }
}
