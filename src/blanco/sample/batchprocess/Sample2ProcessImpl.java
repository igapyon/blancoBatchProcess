package blanco.sample.batchprocess;

import java.io.IOException;

import blanco.sample.batchprocess.valueobject.Sample2ProcessInput;

/**
 * �T���v���E�o�b�`�����̃R���p�C����ʂ����߂̃_�~�[�N���X�B
 */
public class Sample2ProcessImpl implements Sample2Process {
    /**
     * �N���X���C���X�^���X�����ď��������s����ۂ̃G���g���|�C���g�ł��B
     * 
     * @param input
     *            �����̓��̓p�����[�^�B
     * @return �����̎��s���ʁB
     * @throws IOException
     *             ���o�͗�O�����������ꍇ�B
     * @throws IllegalArgumentException
     *             ���͒l�ɕs�������������ꍇ�B
     */
    public int execute(Sample2ProcessInput input) throws IOException,
            IllegalArgumentException {
        // ���ɏ����͖����B
        return 0;
    }

    /**
     * �����̒��ŃA�C�e������������邽�тɐi���񍐂Ƃ��ăR�[���o�b�N���܂��B
     * 
     * @param argProgressMessage
     *            ���ݏ������Ă���A�C�e���Ɋւ��郁�b�Z�[�W�B
     * @return ���������̂܂܌p������ꍇ�� false�B�������f�����N�G�X�g�������ꍇ�� true�B
     */
    public boolean progress(String argProgressMessage) {
        return false;
    }
}
