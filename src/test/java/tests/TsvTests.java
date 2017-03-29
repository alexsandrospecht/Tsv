package tests;

import com.github.alexsandrospecht.Tsv;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.*;


/**
 * Created by Alexsandro on 27/03/2017.
 */
public class TsvTests {

    private final static String OUTPUT = System.getProperty("java.io.tmpdir") + "saida.csv";

    @Test
    public void fileTrasformInput1() throws Exception {
        final String INPUT = new File(TsvTests.class.getResource("/input_1/INPUT_1.txt").getFile()).getAbsolutePath();
        final String TEMPLATE = new File(TsvTests.class.getResource("/input_1/TEMPLATE_1.txt").getFile()).getAbsolutePath();

        Tsv.main(new String[]{INPUT, TEMPLATE, OUTPUT});

        File actualFile = new File(OUTPUT);
        File expectedFile = new File(TsvTests.class.getResource("/input_1/SAIDA_1.csv").getFile());

        assertThat(actualFile).hasSameContentAs(expectedFile);
    }

    @Test
    public void fileTrasformInput2() throws Exception {
        final String INPUT = new File(TsvTests.class.getResource("/input_2/INPUT_2.txt").getFile()).getAbsolutePath();
        final String TEMPLATE = new File(TsvTests.class.getResource("/input_2/TEMPLATE_2.txt").getFile()).getAbsolutePath();

        Tsv.main(new String[]{INPUT, TEMPLATE, OUTPUT});

        File actualFile = new File(OUTPUT);
        File expectedFile = new File(TsvTests.class.getResource("/input_2/SAIDA_2.csv").getFile());

        assertThat(actualFile).hasSameContentAs(expectedFile);
    }
}
