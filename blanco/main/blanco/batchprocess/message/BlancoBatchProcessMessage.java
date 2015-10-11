/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ���Ď�����������Ă��܂��B
 */
package blanco.batchprocess.message;

/**
 * blancoBatchProcess�̃��b�Z�[�W�N���X�B�v���O�������ŗ��p����郁�b�Z�[�W���i�[���܂��B
 */
public class BlancoBatchProcessMessage {
    /**
     * ���b�Z�[�W���v���p�e�B�t�@�C���Ή������邽�߂̓����I�ɗ��p���郊�\�[�X�o���h���N���X�B
     */
    protected final BlancoBatchProcessMessageResourceBundle fBundle = new BlancoBatchProcessMessageResourceBundle();

    /**
     * ���b�Z�[�W��`ID[BlancoBatchProcess]�A�L�[[MBBPI001]�̕�������擾���܂��B
     *
     * No.2:
     * ������[�o�b�`������`ID[{0}]�̃p�b�P�[�W�����w�肳��Ă��܂���B]
     *
     * @param arg0 �u��������{0}�̒l�B
     * @return ���b�Z�[�W������B
     */
    public String getMbbpi001(final String arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("���\�b�h[getMbbpi001]�̃p�����[�^[arg0]��null���^�����܂����B�������A���̃p�����[�^��null��^���邱�Ƃ͂ł��܂���B");
        }

        return "[MBBPI001] " + fBundle.getMbbpi001(arg0);
    }

    /**
     * ���b�Z�[�W��`ID[BlancoBatchProcess]�A�L�[[MBBPI002]�̕�������擾���܂��B
     *
     * No.3:
     * ������[�T�|�[�g���Ȃ��o�̓v���O���~���O���ꏈ���n[{0}]���w�肳��܂����B]
     *
     * @param arg0 �u��������{0}�̒l�B
     * @return ���b�Z�[�W������B
     */
    public String getMbbpi002(final String arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("���\�b�h[getMbbpi002]�̃p�����[�^[arg0]��null���^�����܂����B�������A���̃p�����[�^��null��^���邱�Ƃ͂ł��܂���B");
        }

        return "[MBBPI002] " + fBundle.getMbbpi002(arg0);
    }

    /**
     * ���b�Z�[�W��`ID[BlancoBatchProcess]�A�L�[[MBBPI003]�̕�������擾���܂��B
     *
     * No.4:
     * ������[�o�b�`������`ID[{0}]�ɂ����āA���̓p�����[�^[{1}]�Ɂu�K�{�v�Ɓu�f�t�H���g�v�������Ɏw�肳��Ă��܂��B�����͓����Ɏw�肷�邱�Ƃ͂ł��܂���B]
     *
     * @param arg0 �u��������{0}�̒l�B
     * @param arg1 �u��������{1}�̒l�B
     * @return ���b�Z�[�W������B
     */
    public String getMbbpi003(final String arg0, final String arg1) {
        if (arg0 == null) {
            throw new IllegalArgumentException("���\�b�h[getMbbpi003]�̃p�����[�^[arg0]��null���^�����܂����B�������A���̃p�����[�^��null��^���邱�Ƃ͂ł��܂���B");
        }
        if (arg1 == null) {
            throw new IllegalArgumentException("���\�b�h[getMbbpi003]�̃p�����[�^[arg1]��null���^�����܂����B�������A���̃p�����[�^��null��^���邱�Ƃ͂ł��܂���B");
        }

        return "[MBBPI003] " + fBundle.getMbbpi003(arg0, arg1);
    }

    /**
     * ���b�Z�[�W��`ID[BlancoBatchProcess]�A�L�[[MBBPA001]�̕�������擾���܂��B
     *
     * No.7:
     * ������[���^�f�B���N�g��[{0}]�����݂��܂���B]
     *
     * @param arg0 �u��������{0}�̒l�B
     * @return ���b�Z�[�W������B
     */
    public String getMbbpa001(final String arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("���\�b�h[getMbbpa001]�̃p�����[�^[arg0]��null���^�����܂����B�������A���̃p�����[�^��null��^���邱�Ƃ͂ł��܂���B");
        }

        return "[MBBPA001] " + fBundle.getMbbpa001(arg0);
    }
}
