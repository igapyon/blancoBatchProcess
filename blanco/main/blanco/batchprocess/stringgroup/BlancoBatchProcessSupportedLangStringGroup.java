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
 * �T�|�[�g���錾��̈ꗗ��ێ����܂��B
 */
public class BlancoBatchProcessSupportedLangStringGroup {
    /**
     * No.1 ����:Java����B
     */
    public static final int JAVA = 1;

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
        // ����:Java����B
        if ("java".equals(argCheck)) {
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
        // ����:Java����B
        if ("java".equalsIgnoreCase(argCheck)) {
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
        // ����:Java����B
        if ("java".equals(argCheck)) {
            return JAVA;
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
        // ����:Java����B
        if (argCheck == JAVA) {
            return "java";
        }
        // ����`�B
        if (argCheck == NOT_DEFINED) {
            return "";
        }

        // ������ɂ��Y�����܂���ł����B
        throw new IllegalArgumentException("�^����ꂽ�l(" + argCheck + ")�͕�����O���[�v[BlancoBatchProcessSupportedLang]�ł͒�`����Ȃ��l�ł��B");
    }
}
