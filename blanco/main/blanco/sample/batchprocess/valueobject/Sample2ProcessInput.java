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

import java.math.BigDecimal;

/**
 * �����N���X [Sample2Process]�̓��̓o�����[�I�u�W�F�N�g�N���X�ł��B
 */
public class Sample2ProcessInput {
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
     * �t�B�[���h: [field_int_req]�B
     */
    private int fFieldIntReq;

    /**
     * �t�B�[���h: [field_int]�B
     */
    private int fFieldInt;

    /**
     * �t�B�[���h: [field_long_req]�B
     */
    private long fFieldLongReq;

    /**
     * �t�B�[���h: [field_long]�B
     */
    private long fFieldLong;

    /**
     * �t�B�[���h: [field_decimal_req]�B
     */
    private BigDecimal fFieldDecimalReq;

    /**
     * �t�B�[���h: [field_decimal]�B
     */
    private BigDecimal fFieldDecimal;

    /**
     * �t�B�[���h: [field_boolean_req]�B
     */
    private boolean fFieldBooleanReq;

    /**
     * �t�B�[���h: [field_boolean]�B
     */
    private boolean fFieldBoolean;

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
     * �t�B�[���h [field_int_req] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argFieldIntReq �t�B�[���h[field_int_req]�ɐݒ肷��l�B
     */
    public void setFieldIntReq(final int argFieldIntReq) {
        fFieldIntReq = argFieldIntReq;
    }

    /**
     * �t�B�[���h [field_int_req] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[field_int_req]����擾�����l�B
     */
    public int getFieldIntReq() {
        return fFieldIntReq;
    }

    /**
     * �t�B�[���h [field_int] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argFieldInt �t�B�[���h[field_int]�ɐݒ肷��l�B
     */
    public void setFieldInt(final int argFieldInt) {
        fFieldInt = argFieldInt;
    }

    /**
     * �t�B�[���h [field_int] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[field_int]����擾�����l�B
     */
    public int getFieldInt() {
        return fFieldInt;
    }

    /**
     * �t�B�[���h [field_long_req] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argFieldLongReq �t�B�[���h[field_long_req]�ɐݒ肷��l�B
     */
    public void setFieldLongReq(final long argFieldLongReq) {
        fFieldLongReq = argFieldLongReq;
    }

    /**
     * �t�B�[���h [field_long_req] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[field_long_req]����擾�����l�B
     */
    public long getFieldLongReq() {
        return fFieldLongReq;
    }

    /**
     * �t�B�[���h [field_long] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argFieldLong �t�B�[���h[field_long]�ɐݒ肷��l�B
     */
    public void setFieldLong(final long argFieldLong) {
        fFieldLong = argFieldLong;
    }

    /**
     * �t�B�[���h [field_long] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[field_long]����擾�����l�B
     */
    public long getFieldLong() {
        return fFieldLong;
    }

    /**
     * �t�B�[���h [field_decimal_req] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argFieldDecimalReq �t�B�[���h[field_decimal_req]�ɐݒ肷��l�B
     */
    public void setFieldDecimalReq(final BigDecimal argFieldDecimalReq) {
        fFieldDecimalReq = argFieldDecimalReq;
    }

    /**
     * �t�B�[���h [field_decimal_req] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[field_decimal_req]����擾�����l�B
     */
    public BigDecimal getFieldDecimalReq() {
        return fFieldDecimalReq;
    }

    /**
     * �t�B�[���h [field_decimal] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argFieldDecimal �t�B�[���h[field_decimal]�ɐݒ肷��l�B
     */
    public void setFieldDecimal(final BigDecimal argFieldDecimal) {
        fFieldDecimal = argFieldDecimal;
    }

    /**
     * �t�B�[���h [field_decimal] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[field_decimal]����擾�����l�B
     */
    public BigDecimal getFieldDecimal() {
        return fFieldDecimal;
    }

    /**
     * �t�B�[���h [field_boolean_req] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argFieldBooleanReq �t�B�[���h[field_boolean_req]�ɐݒ肷��l�B
     */
    public void setFieldBooleanReq(final boolean argFieldBooleanReq) {
        fFieldBooleanReq = argFieldBooleanReq;
    }

    /**
     * �t�B�[���h [field_boolean_req] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[field_boolean_req]����擾�����l�B
     */
    public boolean getFieldBooleanReq() {
        return fFieldBooleanReq;
    }

    /**
     * �t�B�[���h [field_boolean] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argFieldBoolean �t�B�[���h[field_boolean]�ɐݒ肷��l�B
     */
    public void setFieldBoolean(final boolean argFieldBoolean) {
        fFieldBoolean = argFieldBoolean;
    }

    /**
     * �t�B�[���h [field_boolean] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[field_boolean]����擾�����l�B
     */
    public boolean getFieldBoolean() {
        return fFieldBoolean;
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
        buf.append("blanco.sample.batchprocess.valueobject.Sample2ProcessInput[");
        buf.append("require=" + fRequire);
        buf.append(",dispstr=" + fDispstr);
        buf.append(",normalparam=" + fNormalparam);
        buf.append(",field_int_req=" + fFieldIntReq);
        buf.append(",field_int=" + fFieldInt);
        buf.append(",field_long_req=" + fFieldLongReq);
        buf.append(",field_long=" + fFieldLong);
        buf.append(",field_decimal_req=" + fFieldDecimalReq);
        buf.append(",field_decimal=" + fFieldDecimal);
        buf.append(",field_boolean_req=" + fFieldBooleanReq);
        buf.append(",field_boolean=" + fFieldBoolean);
        buf.append("]");
        return buf.toString();
    }
}
