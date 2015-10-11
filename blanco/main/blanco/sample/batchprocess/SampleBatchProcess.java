/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.sample.batchprocess;

import java.io.IOException;

import blanco.sample.batchprocess.valueobject.SampleProcessInput;

/**
 * �o�b�`�����N���X [SampleBatchProcess]�B
 *
 * <P>�o�b�`�����̌Ăяo����B</P>
 * <code>
 * java -classpath (�N���X�p�X) blanco.sample.batchprocess.SampleBatchProcess -help
 * </code>
 */
public class SampleBatchProcess {
    /**
     * ����I���B
     */
    public static final int END_SUCCESS = 0;

    /**
     * �o�b�`������O�I���B�����I��BatchProcessException�����������ꍇ�B
     */
    public static final int END_BATCHPROCESS_EXCEPTION = 6;

    /**
     * ���ُ͈�I���B�����I��java.lang.IllegalArgumentException�����������ꍇ�B
     */
    public static final int END_ILLEGAL_ARGUMENT_EXCEPTION = 7;

    /**
     * ���o�͗�O�I���B�����I��java.io.IOException�����������ꍇ�B
     */
    public static final int END_IO_EXCEPTION = 8;

    /**
     * �ُ�I���B�o�b�`�̏����J�n�Ɏ��s�����ꍇ�A����ѓ����I��java.lang.Error�܂���java.lang.RuntimeException�����������ꍇ�B
     */
    public static final int END_ERROR = 9;

    /**
     * �R�}���h���C��������s���ꂽ�ۂ̃G���g���|�C���g�ł��B
     *
     * @param args �R���\�[����������p���ꂽ�����B
     */
    public static final void main(final String[] args) {
        final SampleBatchProcess batchProcess = new SampleBatchProcess();

        // �o�b�`�����̈����B
        final SampleProcessInput input = new SampleProcessInput();

        boolean isNeedUsage = false;
        boolean isFieldRequireProcessed = false;

        // �R�}���h���C�������̉�͂������Ȃ��܂��B
        for (int index = 0; index < args.length; index++) {
            String arg = args[index];
            if (arg.startsWith("-require=")) {
                input.setRequire(arg.substring(9));
                isFieldRequireProcessed = true;
            } else if (arg.startsWith("-dispstr=")) {
                input.setDispstr(arg.substring(9));
            } else if (arg.startsWith("-normalparam=")) {
                input.setNormalparam(arg.substring(13));
            } else if (arg.equals("-?") || arg.equals("-help")) {
                usage();
                System.exit(END_SUCCESS);
            } else {
                System.out.println("SampleBatchProcess: ���̓p�����[�^[" + arg + "]�͖�������܂����B");
                isNeedUsage = true;
            }
        }

        if (isNeedUsage) {
            usage();
        }

        if( isFieldRequireProcessed == false) {
            System.out.println("SampleBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[require]�ɒl���ݒ肳��Ă��܂���B");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }

        int retCode = batchProcess.execute(input);

        // �I���R�[�h��߂��܂��B
        // �����ӁFSystem.exit()���Ăяo���Ă���_�ɒ��ӂ��Ă��������B
        System.exit(retCode);
    }

    /**
     * ��̓I�ȃo�b�`�������e���L�q���邽�߂̃��\�b�h�ł��B
     *
     * ���̃��\�b�h�Ɏ��ۂ̏������e���L�q���܂��B
     *
     * @param input �o�b�`�����̓��̓p�����[�^�B
     * @return �o�b�`�����̏I���R�[�h�BEND_SUCCESS, END_ILLEGAL_ARGUMENT_EXCEPTION, END_IO_EXCEPTION, END_ERROR, END_BATCHPROCESS_EXCEPTION �̂����ꂩ�̒l��߂��܂��B����I���̏ꍇ��0�B�s�����͏I���̏ꍇ��7�B�ُ�I���̏ꍇ��9�B
     * @throws IOException ���o�͗�O�����������ꍇ�B
     * @throws IllegalArgumentException ���͒l�ɕs�������������ꍇ�B
     */
    public int process(final SampleProcessInput input) throws IOException, IllegalArgumentException {
        // ���̓p�����[�^���`�F�b�N���܂��B
        validateInput(input);

        // ���̉ӏ��ŃR���p�C���G���[����������ꍇ�ASampleProcess�C���^�t�F�[�X���������� blanco.sample.batchprocess�p�b�P�[�W�� SampleProcessImpl�N���X���쐬���邱�Ƃɂ������ł���ꍇ������܂��B
        final SampleProcess process = new SampleProcessImpl();

        // �����̖{�̂����s���܂��B
        final int retCode = process.execute(input);

        return retCode;
    }

    /**
     * �N���X���C���X�^���X�����ăo�b�`�����s����ۂ̃G���g���|�C���g�ł��B
     *
     * ���̃��\�b�h�͉��L�̎d�l��񋟂��܂��B
     * <ul>
     * <li>���\�b�h�̓��̓p�����[�^�̓��e�`�F�b�N�B
     * <li>IllegalArgumentException, RuntimeException, Error�Ȃǂ̗�O��catch���Ė߂�l�ւƕϊ��B
     * </ul>
     *
     * @param input �o�b�`�����̓��̓p�����[�^�B
     * @return �o�b�`�����̏I���R�[�h�BEND_SUCCESS, END_ILLEGAL_ARGUMENT_EXCEPTION, END_IO_EXCEPTION, END_ERROR, END_BATCHPROCESS_EXCEPTION �̂����ꂩ�̒l��߂��܂��B����I���̏ꍇ��0�B�s�����͏I���̏ꍇ��7�B�ُ�I���̏ꍇ��9�B
     * @throws IllegalArgumentException ���͒l�ɕs�������������ꍇ�B
     */
    public final int execute(final SampleProcessInput input) throws IllegalArgumentException {
        try {
            System.out.println("SampleBatchProcess: begin");

            // �o�b�`�����̖{�̂����s���܂��B
            int retCode = process(input);

            System.out.println("SampleBatchProcess: end (" + retCode + ")");
            return retCode;
        } catch (BlancoBatchProcessException ex) {
            System.out.println("SampleBatchProcess: �o�b�`������O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            // �o�b�`������O�I���B
            return END_BATCHPROCESS_EXCEPTION;
        } catch (IllegalArgumentException ex) {
            System.out.println("SampleBatchProcess: ���͗�O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            // ���ُ͈�I���B
            return END_ILLEGAL_ARGUMENT_EXCEPTION;
        } catch (IOException ex) {
            System.out.println("SampleBatchProcess: ���o�͗�O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            // ���ُ͈�I���B
            return END_IO_EXCEPTION;
        } catch (RuntimeException ex) {
            System.out.println("SampleBatchProcess: �����^�C����O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            ex.printStackTrace();
            // �ُ�I���B
            return END_ERROR;
        } catch (Error er) {
            System.out.println("SampleBatchProcess: �����^�C���G���[���������܂����B�o�b�`�����𒆒f���܂��B:" + er.toString());
            er.printStackTrace();
            // �ُ�I���B
            return END_ERROR;
        }
    }

    /**
     * ���̃o�b�`�����N���X�̎g�����̐�����W���o�͂Ɏ������߂̃��\�b�h�ł��B
     */
    public static final void usage() {
        System.out.println("SampleBatchProcess: Usage:");
        System.out.println("  java blanco.sample.batchprocess.SampleBatchProcess -require=�l1 -dispstr=�l2 -normalparam=�l3");
        System.out.println("    -require");
        System.out.println("      ����[�K�{�����̃T���v���B]");
        System.out.println("      �^[������]");
        System.out.println("      �K�{�p�����[�^");
        System.out.println("    -dispstr");
        System.out.println("      ����[�\��������̃T���v���B]");
        System.out.println("      �^[������]");
        System.out.println("      �f�t�H���g�l[���Ɏw�肪�����ꍇ�̕�����]");
        System.out.println("    -normalparam");
        System.out.println("      ����[�K�{�ł��Ȃ��A�܂��f�t�H���g�������Ȃ������̗�B]");
        System.out.println("      �^[������]");
        System.out.println("    -? , -help");
        System.out.println("      ����[�g������\�����܂��B]");
    }

    /**
     * ���̃o�b�`�����N���X�̓��̓p�����[�^�̑Ó����`�F�b�N�����{���邽�߂̃��\�b�h�ł��B
     *
     * @param input �o�b�`�����̓��̓p�����[�^�B
     * @throws IllegalArgumentException ���͒l�ɕs�������������ꍇ�B
     */
    public void validateInput(final SampleProcessInput input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("BlancoBatchProcessBatchProcess: �����J�n���s�B���̓p�����[�^[input]��null���^�����܂����B");
        }
        if (input.getRequire() == null) {
            throw new IllegalArgumentException("SampleBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[require]�ɒl���ݒ肳��Ă��܂���B");
        }
    }
}
