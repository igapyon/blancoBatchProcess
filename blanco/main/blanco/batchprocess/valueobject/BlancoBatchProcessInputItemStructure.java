/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.batchprocess.valueobject;

/**
 * blancoBatchProcess ��������������o�b�`�����N���X�̓��͂�����킵�܂��B
 */
public class BlancoBatchProcessInputItemStructure {
    /**
     * �p�����[�^�����w�肵�܂��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * �^�������܂��B
     *
     * �t�B�[���h: [type]�B
     * �f�t�H���g: ["blanco:string"]�B
     */
    private String fType = "blanco:string";

    /**
     * �K�{���ڂł��邩�ǂ����B
     *
     * �t�B�[���h: [require]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fRequire = false;

    /**
     * �f�t�H���g�l�B
     *
     * �t�B�[���h: [default]�B
     */
    private String fDefault;

    /**
     * �����B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�p�����[�^�����w�肵�܂��B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�p�����[�^�����w�肵�܂��B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [type] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�^�������܂��B]�B
     *
     * @param argType �t�B�[���h[type]�ɐݒ肷��l�B
     */
    public void setType(final String argType) {
        fType = argType;
    }

    /**
     * �t�B�[���h [type] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�^�������܂��B]�B
     * �f�t�H���g: ["blanco:string"]�B
     *
     * @return �t�B�[���h[type]����擾�����l�B
     */
    public String getType() {
        return fType;
    }

    /**
     * �t�B�[���h [require] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�K�{���ڂł��邩�ǂ����B]�B
     *
     * @param argRequire �t�B�[���h[require]�ɐݒ肷��l�B
     */
    public void setRequire(final boolean argRequire) {
        fRequire = argRequire;
    }

    /**
     * �t�B�[���h [require] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�K�{���ڂł��邩�ǂ����B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[require]����擾�����l�B
     */
    public boolean getRequire() {
        return fRequire;
    }

    /**
     * �t�B�[���h [default] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�f�t�H���g�l�B]�B
     *
     * @param argDefault �t�B�[���h[default]�ɐݒ肷��l�B
     */
    public void setDefault(final String argDefault) {
        fDefault = argDefault;
    }

    /**
     * �t�B�[���h [default] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�f�t�H���g�l�B]�B
     *
     * @return �t�B�[���h[default]����擾�����l�B
     */
    public String getDefault() {
        return fDefault;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
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
        buf.append("blanco.batchprocess.valueobject.BlancoBatchProcessInputItemStructure[");
        buf.append("name=" + fName);
        buf.append(",type=" + fType);
        buf.append(",require=" + fRequire);
        buf.append(",default=" + fDefault);
        buf.append(",description=" + fDescription);
        buf.append("]");
        return buf.toString();
    }
}
