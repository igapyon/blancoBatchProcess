/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.batchprocess;

import java.io.File;

import blanco.batchprocess.stringgroup.BlancoBatchProcessSupportedLangStringGroup;
import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.transformer.BlancoCgTransformerFactory;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * blancoBatchProcess�̂��߂̗�O�N���X���o�͂��܂��B
 */
class BlancoBatchProcessExpandException {
    /**
     * �o�͑ΏۂƂȂ�v���O���~���O����B
     */
    private int fTargetLang = BlancoBatchProcessSupportedLangStringGroup.NOT_DEFINED;

    /**
     * �����I�ɗ��p����blancoCg�p�t�@�N�g���B
     */
    private BlancoCgObjectFactory fCgFactory = null;

    /**
     * �����I�ɗ��p����blancoCg�p�\�[�X�t�@�C�����B
     */
    private BlancoCgSourceFile fCgSourceFile = null;

    /**
     * �����I�ɗ��p����blancoCg�p�N���X���B
     */
    private BlancoCgClass fCgClass = null;

    /**
     * ���W���ꂽ�������ɁA�\�[�X�R�[�h�������������܂��B
     * 
     * @param argRuntimePackage
     *            ���^�t�@�C��������W�ł��������\���f�[�^�B
     * @param argTargetLang
     *            �o�͑Ώۃv���O���~���O����B
     * @param argDirectoryTarget
     *            �\�[�X�R�[�h�̏o�͐�t�H���_�B
     */
    public void expandSourceFile(final String argRuntimePackage,
            final int argTargetLang, final File argDirectoryTarget) {
        fTargetLang = argTargetLang;

        // �]���ƌ݊������������邽�߁A/main�T�u�t�H���_�ɏo�͂��܂��B
        final File fileBlancoMain = new File(argDirectoryTarget
                .getAbsolutePath()
                + "/main");

        fCgFactory = BlancoCgObjectFactory.getInstance();
        fCgSourceFile = fCgFactory.createSourceFile(argRuntimePackage, null);
        fCgClass = fCgFactory.createClass("BlancoBatchProcessException",
                "�o�b�`�����ɂ����ė�O�����������ۂɗ��p����܂��BblancoBatchProcess�̗�O�ł��B");
        fCgSourceFile.getClassList().add(fCgClass);

        fCgClass.getExtendClassList().add(
                fCgFactory.createType("java.lang.RuntimeException"));

        // �V���A��ID�̌x����}���B
        fCgClass.getAnnotationList().add("SuppressWarnings(\"serial\")");

        // �R���X�g���N�^��ǉ����܂��B
        BlancoCgUtil.addConstructorForException(fCgFactory, fCgClass);

        switch (fTargetLang) {
        case BlancoBatchProcessSupportedLangStringGroup.JAVA:
            BlancoCgTransformerFactory.getJavaSourceTransformer().transform(
                    fCgSourceFile, fileBlancoMain);
            break;
        default:
            break;
        }
    }
}
