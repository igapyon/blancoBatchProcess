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
import java.math.BigDecimal;

import blanco.sample.batchprocess.valueobject.Sample2ProcessInput;

/**
 * �o�b�`�����N���X [Sample2BatchProcess]�B
 *
 * <P>�o�b�`�����̌Ăяo����B</P>
 * <code>
 * java -classpath (�N���X�p�X) blanco.sample.batchprocess.Sample2BatchProcess -help
 * </code>
 */
public class Sample2BatchProcess {
    /**
     * ����I���B
     */
    public static final int END_SUCCESS = 0;

    /**
     * ���ُ͈�I���B�����I��java.lang.IllegalArgumentException�����������ꍇ�B
     */
    public static final int END_ILLEGAL_ARGUMENT_EXCEPTION = 97;

    /**
     * ���o�͗�O�I���B�����I��java.io.IOException�����������ꍇ�B
     */
    public static final int END_IO_EXCEPTION = 98;

    /**
     * �ُ�I���B�o�b�`�̏����J�n�Ɏ��s�����ꍇ�A����ѓ����I��java.lang.Error�܂���java.lang.RuntimeException�����������ꍇ�B
     */
    public static final int END_ERROR = 99;

    /**
     * �R�}���h���C��������s���ꂽ�ۂ̃G���g���|�C���g�ł��B
     *
     * @param args �R���\�[����������p���ꂽ�����B
     */
    public static final void main(final String[] args) {
        final Sample2BatchProcess batchProcess = new Sample2BatchProcess();

        // �o�b�`�����̈����B
        final Sample2ProcessInput input = new Sample2ProcessInput();

        boolean isNeedUsage = false;
        boolean isFieldRequireProcessed = false;
        boolean isFieldFieldIntReqProcessed = false;
        boolean isFieldFieldLongReqProcessed = false;
        boolean isFieldFieldDecimalReqProcessed = false;
        boolean isFieldFieldBooleanReqProcessed = false;

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
            } else if (arg.startsWith("-field_int_req=")) {
                try {
                    input.setFieldIntReq(Integer.parseInt(arg.substring(15)));
                } catch (NumberFormatException e) {
                    System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̃t�B�[���h[field_int_req]�𐔒l(int)�Ƃ��ăp�[�X�����݂܂��������s���܂����B: " + e.toString());
                    System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
                }
                isFieldFieldIntReqProcessed = true;
            } else if (arg.startsWith("-field_int=")) {
                try {
                    input.setFieldInt(Integer.parseInt(arg.substring(11)));
                } catch (NumberFormatException e) {
                    System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̃t�B�[���h[field_int]�𐔒l(int)�Ƃ��ăp�[�X�����݂܂��������s���܂����B: " + e.toString());
                    System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
                }
            } else if (arg.startsWith("-field_long_req=")) {
                try {
                    input.setFieldLongReq(Long.parseLong(arg.substring(16)));
                } catch (NumberFormatException e) {
                    System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̃t�B�[���h[field_long_req]�𐔒l(long)�Ƃ��ăp�[�X�����݂܂��������s���܂����B: " + e.toString());
                    System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
                }
                isFieldFieldLongReqProcessed = true;
            } else if (arg.startsWith("-field_long=")) {
                try {
                    input.setFieldLong(Long.parseLong(arg.substring(12)));
                } catch (NumberFormatException e) {
                    System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̃t�B�[���h[field_long]�𐔒l(long)�Ƃ��ăp�[�X�����݂܂��������s���܂����B: " + e.toString());
                    System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
                }
            } else if (arg.startsWith("-field_decimal_req=")) {
                try {
                    input.setFieldDecimalReq(new BigDecimal(arg.substring(19)));
                } catch (NumberFormatException e) {
                    System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̃t�B�[���h[field_decimal_req]�𐔒l(decimal)�Ƃ��ăp�[�X�����݂܂��������s���܂����B: " + e.toString());
                    System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
                }
                isFieldFieldDecimalReqProcessed = true;
            } else if (arg.startsWith("-field_decimal=")) {
                try {
                    input.setFieldDecimal(new BigDecimal(arg.substring(15)));
                } catch (NumberFormatException e) {
                    System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̃t�B�[���h[field_decimal]�𐔒l(decimal)�Ƃ��ăp�[�X�����݂܂��������s���܂����B: " + e.toString());
                    System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
                }
            } else if (arg.startsWith("-field_boolean_req=")) {
                input.setFieldBooleanReq(Boolean.valueOf(arg.substring(19)).booleanValue());
                isFieldFieldBooleanReqProcessed = true;
            } else if (arg.startsWith("-field_boolean=")) {
                input.setFieldBoolean(Boolean.valueOf(arg.substring(15)).booleanValue());
            } else if (arg.equals("-?") || arg.equals("-help")) {
                usage();
                System.exit(END_SUCCESS);
            } else {
                System.out.println("Sample2BatchProcess: ���̓p�����[�^[" + arg + "]�͖�������܂����B");
                isNeedUsage = true;
            }
        }

        if (isNeedUsage) {
            usage();
        }

        if( isFieldRequireProcessed == false) {
            System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[require]�ɒl���ݒ肳��Ă��܂���B");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldFieldIntReqProcessed == false) {
            System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[field_int_req]�ɒl���ݒ肳��Ă��܂���B");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldFieldLongReqProcessed == false) {
            System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[field_long_req]�ɒl���ݒ肳��Ă��܂���B");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldFieldDecimalReqProcessed == false) {
            System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[field_decimal_req]�ɒl���ݒ肳��Ă��܂���B");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldFieldBooleanReqProcessed == false) {
            System.out.println("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[field_boolean_req]�ɒl���ݒ肳��Ă��܂���B");
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
     * @return �o�b�`�����̏I���R�[�h�BEND_SUCCESS, END_ILLEGAL_ARGUMENT_EXCEPTION, END_IO_EXCEPTION, END_ERROR �̂����ꂩ�̒l��߂��܂��B����I���̏ꍇ��0�B
     * @throws IOException ���o�͗�O�����������ꍇ�B
     * @throws IllegalArgumentException ���͒l�ɕs�������������ꍇ�B
     */
    public int process(final Sample2ProcessInput input) throws IOException, IllegalArgumentException {
        // ���̓p�����[�^���`�F�b�N���܂��B
        validateInput(input);

        // ���̉ӏ��ŃR���p�C���G���[����������ꍇ�ASample2Process�C���^�t�F�[�X���������� blanco.sample.batchprocess�p�b�P�[�W�� Sample2ProcessImpl�N���X���쐬���邱�Ƃɂ������ł���ꍇ������܂��B
        final Sample2Process process = new Sample2ProcessImpl();

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
     * @return �o�b�`�����̏I���R�[�h�BEND_SUCCESS, END_ILLEGAL_ARGUMENT_EXCEPTION, END_IO_EXCEPTION, END_ERROR �̂����ꂩ�̒l��߂��܂��B����I���̏ꍇ��0�B
     * @throws IllegalArgumentException ���͒l�ɕs�������������ꍇ�B
     */
    public final int execute(final Sample2ProcessInput input) throws IllegalArgumentException {
        try {
            System.out.println("Sample2BatchProcess: begin");

            // �o�b�`�����̖{�̂����s���܂��B
            int retCode = process(input);

            System.out.println("Sample2BatchProcess: end (" + retCode + ")");
            return retCode;
        } catch (IllegalArgumentException ex) {
            System.out.println("Sample2BatchProcess: ���͗�O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            // ���ُ͈�I���B
            return END_ILLEGAL_ARGUMENT_EXCEPTION;
        } catch (IOException ex) {
            System.out.println("Sample2BatchProcess: ���o�͗�O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            // ���ُ͈�I���B
            return END_IO_EXCEPTION;
        } catch (RuntimeException ex) {
            System.out.println("Sample2BatchProcess: �����^�C����O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            ex.printStackTrace();
            // �ُ�I���B
            return END_ERROR;
        } catch (Error er) {
            System.out.println("Sample2BatchProcess: �����^�C���G���[���������܂����B�o�b�`�����𒆒f���܂��B:" + er.toString());
            er.printStackTrace();
            // �ُ�I���B
            return END_ERROR;
        }
    }

    /**
     * ���̃o�b�`�����N���X�̎g�����̐�����W���o�͂Ɏ������߂̃��\�b�h�ł��B
     */
    public static final void usage() {
        System.out.println("Sample2BatchProcess: Usage:");
        System.out.println("  java blanco.sample.batchprocess.Sample2BatchProcess -require=�l1 -dispstr=�l2 -normalparam=�l3 -field_int_req=�l4 -field_int=�l5 -field_long_req=�l6 -field_long=�l7 -field_decimal_req=�l8 -field_decimal=�l9 -field_boolean_req=�l10 -field_boolean=�l11");
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
        System.out.println("    -field_int_req");
        System.out.println("      �^[���l(int)]");
        System.out.println("      �K�{�p�����[�^");
        System.out.println("    -field_int");
        System.out.println("      �^[���l(int)]");
        System.out.println("    -field_long_req");
        System.out.println("      �^[���l(long)]");
        System.out.println("      �K�{�p�����[�^");
        System.out.println("    -field_long");
        System.out.println("      �^[���l(long)]");
        System.out.println("    -field_decimal_req");
        System.out.println("      �^[���l(decimal)]");
        System.out.println("      �K�{�p�����[�^");
        System.out.println("    -field_decimal");
        System.out.println("      �^[���l(decimal)]");
        System.out.println("    -field_boolean_req");
        System.out.println("      �^[�^�U]");
        System.out.println("      �K�{�p�����[�^");
        System.out.println("    -field_boolean");
        System.out.println("      �^[�^�U]");
        System.out.println("    -? , -help");
        System.out.println("      ����[�g������\�����܂��B]");
    }

    /**
     * ���̃o�b�`�����N���X�̓��̓p�����[�^�̑Ó����`�F�b�N�����{���邽�߂̃��\�b�h�ł��B
     *
     * @param input �o�b�`�����̓��̓p�����[�^�B
     * @throws IllegalArgumentException ���͒l�ɕs�������������ꍇ�B
     */
    public void validateInput(final Sample2ProcessInput input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("BlancoBatchProcessBatchProcess: �����J�n���s�B���̓p�����[�^[input]��null���^�����܂����B");
        }
        if (input.getRequire() == null) {
            throw new IllegalArgumentException("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[require]�ɒl���ݒ肳��Ă��܂���B");
        }
        if (input.getFieldDecimalReq() == null) {
            throw new IllegalArgumentException("Sample2BatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[field_decimal_req]�ɒl���ݒ肳��Ă��܂���B");
        }
    }
}
