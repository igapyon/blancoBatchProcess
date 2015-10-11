/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.sample.batchprocess.valueobject;

/**
 * �����N���X [SampleProcess]�̓��̓o�����[�I�u�W�F�N�g�N���X�ł��B
 */
public class SampleProcessInput {
    /**
     * �K�{�����̃T���v���B
     *
     * �t�B�[���h: [require]�B
     */
    private String fRequire;

    /**
     * �\��������̃T���v���B
     *
     * �t�B�[���h: [dispstr]�B
     * �f�t�H���g: [���Ɏw�肪�����ꍇ�̕�����]�B
     */
    private String fDispstr = "���Ɏw�肪�����ꍇ�̕�����";

    /**
     * �K�{�ł��Ȃ��A�܂��f�t�H���g�������Ȃ������̗�B
     *
     * �t�B�[���h: [normalparam]�B
     */
    private String fNormalparam;

    /**
     * �t�B�[���h [require] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�K�{�����̃T���v���B]�B
     *
     * @param argRequire �t�B�[���h[require]�ɐݒ肷��l�B
     */
    public void setRequire(final String argRequire) {
        fRequire = argRequire;
    }

    /**
     * �t�B�[���h [require] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�K�{�����̃T���v���B]�B
     *
     * @return �t�B�[���h[require]����擾�����l�B
     */
    public String getRequire() {
        return fRequire;
    }

    /**
     * �t�B�[���h [dispstr] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�\��������̃T���v���B]�B
     *
     * @param argDispstr �t�B�[���h[dispstr]�ɐݒ肷��l�B
     */
    public void setDispstr(final String argDispstr) {
        fDispstr = argDispstr;
    }

    /**
     * �t�B�[���h [dispstr] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�\��������̃T���v���B]�B
     * �f�t�H���g: [���Ɏw�肪�����ꍇ�̕�����]�B
     *
     * @return �t�B�[���h[dispstr]����擾�����l�B
     */
    public String getDispstr() {
        return fDispstr;
    }

    /**
     * �t�B�[���h [normalparam] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�K�{�ł��Ȃ��A�܂��f�t�H���g�������Ȃ������̗�B]�B
     *
     * @param argNormalparam �t�B�[���h[normalparam]�ɐݒ肷��l�B
     */
    public void setNormalparam(final String argNormalparam) {
        fNormalparam = argNormalparam;
    }

    /**
     * �t�B�[���h [normalparam] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�K�{�ł��Ȃ��A�܂��f�t�H���g�������Ȃ������̗�B]�B
     *
     * @return �t�B�[���h[normalparam]����擾�����l�B
     */
    public String getNormalparam() {
        return fNormalparam;
    }

    /**
     * ���̃o�����[�I�u�W�F�N�g�̕�����\�����擾���܂��B
     *
     * <P>�g�p��̒���</P>
     * <UL>
     * <LI>�I�u�W�F�N�g�̃V�����[�͈͂̂ݕ����񉻂̏����ΏۂƂȂ�܂��B
     * <LI>�I�u�W�F�N�g���z�Q�Ƃ��Ă���ꍇ�ɂ́A���̃��\�b�h�͎g��Ȃ��ł��������B
     * </UL>
     *
     * @return �o�����[�I�u�W�F�N�g�̕�����\���B
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("blanco.sample.batchprocess.valueobject.SampleProcessInput[");
        buf.append("require=" + fRequire);
        buf.append(",dispstr=" + fDispstr);
        buf.append(",normalparam=" + fNormalparam);
        buf.append("]");
        return buf.toString();
    }
}
