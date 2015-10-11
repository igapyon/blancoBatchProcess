/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.batchprocess.stringgroup;

/**
 * �T�|�[�g����blanco�^�̈ꗗ������킵�܂��B
 */
public class BlancoBatchProcessBlancoTypeStringGroup {
    /**
     * No.1 ����:������B
     */
    public static final int BLANCO_STRING = 1;

    /**
     * No.2 ����:����(int)�B
     */
    public static final int BLANCO_INT = 2;

    /**
     * No.3 ����:����(long)�B
     */
    public static final int BLANCO_LONG = 3;

    /**
     * No.4 ����:���l(decimal)�B
     */
    public static final int BLANCO_DECIMAL = 4;

    /**
     * No.5 ����:�^�U�B
     */
    public static final int BLANCO_BOOLEAN = 5;

    /**
     * ����`�B������O���[�v�ȊO�̕�����܂��͒萔������`�̂��́B
     */
    public static final int NOT_DEFINED = -1;

    /**
     * ������O���[�v�Ɋ܂܂�镶����ł��邩�ǂ����𔻒肵�܂��B
     *
     * @param argCheck �`�F�b�N���s������������B
     * @return ������O���[�v�Ɋ܂܂�Ă����ture�B�O���[�v�Ɋ܂܂�Ȃ�������ł����false�B
     */
    public boolean match(final String argCheck) {
        // No.1
        // ����:������B
        if ("blanco:string".equals(argCheck)) {
            return true;
        }
        // No.2
        // ����:����(int)�B
        if ("blanco:int".equals(argCheck)) {
            return true;
        }
        // No.3
        // ����:����(long)�B
        if ("blanco:long".equals(argCheck)) {
            return true;
        }
        // No.4
        // ����:���l(decimal)�B
        if ("blanco:decimal".equals(argCheck)) {
            return true;
        }
        // No.5
        // ����:�^�U�B
        if ("blanco:boolean".equals(argCheck)) {
            return true;
        }
        return false;
    }

    /**
     * ������O���[�v�Ɋ܂܂�镶����ł��邩�ǂ������A�啶������������ʂ������肵�܂��B
     *
     * @param argCheck �`�F�b�N���s������������B
     * @return ������O���[�v�Ɋ܂܂�Ă����ture�B�O���[�v�Ɋ܂܂�Ȃ�������ł����false�B
     */
    public boolean matchIgnoreCase(final String argCheck) {
        // No.1
        // ����:������B
        if ("blanco:string".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.2
        // ����:����(int)�B
        if ("blanco:int".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.3
        // ����:����(long)�B
        if ("blanco:long".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.4
        // ����:���l(decimal)�B
        if ("blanco:decimal".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.5
        // ����:�^�U�B
        if ("blanco:boolean".equalsIgnoreCase(argCheck)) {
            return true;
        }
        return false;
    }

    /**
     * �����񂩂�萔�ɕϊ����܂��B
     *
     * �萔������`�̏ꍇ�� �^����ꂽ�����񂪕�����O���[�v�O�̏ꍇ�ɂ� NOT_DEFINED ��߂��܂��B
     *
     * @param argCheck �ϊ����s������������B
     * @return �萔�ɕϊ���̒l�B
     */
    public int convertToInt(final String argCheck) {
        // No.1
        // ����:������B
        if ("blanco:string".equals(argCheck)) {
            return BLANCO_STRING;
        }
        // No.2
        // ����:����(int)�B
        if ("blanco:int".equals(argCheck)) {
            return BLANCO_INT;
        }
        // No.3
        // ����:����(long)�B
        if ("blanco:long".equals(argCheck)) {
            return BLANCO_LONG;
        }
        // No.4
        // ����:���l(decimal)�B
        if ("blanco:decimal".equals(argCheck)) {
            return BLANCO_DECIMAL;
        }
        // No.5
        // ����:�^�U�B
        if ("blanco:boolean".equals(argCheck)) {
            return BLANCO_BOOLEAN;
        }

        // �Y������萔��������܂���ł����B
        return NOT_DEFINED;
    }

    /**
     * �萔���當����ɕϊ����܂��B
     *
     * �萔�ƑΉ��Â�������ɕϊ����܂��B
     *
     * @param argCheck �ϊ����s�����������萔�B
     * @return ������ɕϊ���̒l�BNOT_DEFINED�̏ꍇ�ɂ͒���0�̕�����B
     */
    public String convertToString(final int argCheck) {
        // No.1
        // ����:������B
        if (argCheck == BLANCO_STRING) {
            return "blanco:string";
        }
        // No.2
        // ����:����(int)�B
        if (argCheck == BLANCO_INT) {
            return "blanco:int";
        }
        // No.3
        // ����:����(long)�B
        if (argCheck == BLANCO_LONG) {
            return "blanco:long";
        }
        // No.4
        // ����:���l(decimal)�B
        if (argCheck == BLANCO_DECIMAL) {
            return "blanco:decimal";
        }
        // No.5
        // ����:�^�U�B
        if (argCheck == BLANCO_BOOLEAN) {
            return "blanco:boolean";
        }
        // ����`�B
        if (argCheck == NOT_DEFINED) {
            return "";
        }

        // ������ɂ��Y�����܂���ł����B
        throw new IllegalArgumentException("�^����ꂽ�l(" + argCheck + ")�͕�����O���[�v[BlancoBatchProcessBlancoType]�ł͒�`����Ȃ��l�ł��B");
    }
}
