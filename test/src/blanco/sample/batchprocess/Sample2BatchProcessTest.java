package blanco.sample.batchprocess;

import junit.framework.TestCase;

public class Sample2BatchProcessTest extends TestCase {

    public void testMain() {
        if (false) {
            // ����JUnit�����s����ƁA�����I�� System.exit�����s����܂��B
            final String[] args = { "-require=�K�{����", "-field_int_req=123",
                    "-field_long_req=456", "-field_decimal_req=123.456" };
            Sample2BatchProcess.main(args);
        }

        if (false) {
            // ����JUnit�����s����ƁA�����I�� System.exit�����s����܂��B
            final String[] args = { "-require=�K�{����", "-field_int_req=123",
                    "-field_long_req=456", "-field_decimal_req=�p�[�X�s�\",
                    "-field_boolean_req=false" };
            Sample2BatchProcess.main(args);
        }
    }

    public void testExecute() {
    }

    public void testUsage() {
    }

    public void testValidateInput() {
    }
}
