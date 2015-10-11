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
import blanco.batchprocess.valueobject.BlancoBatchProcessStructure;
import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.transformer.BlancoCgTransformerFactory;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoNameAdjuster;
import blanco.commons.util.BlancoStringUtil;

/**
 * ����(blancoProcess)�̂��߂̃��C���N���X�B
 * 
 * �����C���^�t�F�[�X��W�J���܂��B
 */
class BlancoBatchProcessExpandProcess {
    /**
     * �o�͑ΏۂƂȂ�v���O���~���O����B
     */
    private int fTargetLang = BlancoBatchProcessSupportedLangStringGroup.NOT_DEFINED;

    /**
     * �����^�C���p�b�P�[�W�B
     */
    private String fRuntimePackage = null;

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
    private BlancoCgInterface fCgInterface = null;

    /**
     * ������������\�[�X�t�@�C���̕����G���R�[�f�B���O�B
     */
    private String fEncoding = null;

    public void setEncoding(final String argEncoding) {
        fEncoding = argEncoding;
    }

    /**
     * ���W���ꂽ�������ɁA�\�[�X�R�[�h�������������܂��B
     * 
     * @param argProcessStructure
     *            ���^�t�@�C��������W�ł��������\���f�[�^�B
     * @param argRuntimePackage
     *            �����^�C���p�b�P�[�W�Bnull����ђ���0�̕�����̏ꍇ�͒�`�����ƂɃ����^�C���N���X�𐶐��B
     * @param argTargetLang
     *            �o�͑Ώۃv���O���~���O����B
     * @param argDirectoryTarget
     *            �\�[�X�R�[�h�̏o�͐�t�H���_�B
     */
    public void expandSourceFile(
            final BlancoBatchProcessStructure argProcessStructure,
            final String argRuntimePackage, final int argTargetLang,
            final File argDirectoryTarget) {
        fRuntimePackage = argRuntimePackage;
        fTargetLang = argTargetLang;

        // �]���ƌ݊������������邽�߁A/main�T�u�t�H���_�ɏo�͂��܂��B
        final File fileBlancoMain = new File(argDirectoryTarget
                .getAbsolutePath()
                + "/main");

        fCgFactory = BlancoCgObjectFactory.getInstance();
        fCgSourceFile = fCgFactory.createSourceFile(argProcessStructure
                .getPackage(), null);
        fCgSourceFile.setEncoding(fEncoding);
        fCgInterface = fCgFactory.createInterface(
                getProcessInterfaceName(argProcessStructure), BlancoStringUtil
                        .null2Blank(argProcessStructure.getDescription()));
        fCgSourceFile.getInterfaceList().add(fCgInterface);

        fCgInterface.setAccess("");

        fCgInterface.setDescription("���� ["
                + getProcessInterfaceName(argProcessStructure) + "]�C���^�t�F�[�X�B");
        fCgInterface.getLangDoc().getDescriptionList().add(
                "���̃C���^�t�F�[�X���p������ [" + argProcessStructure.getPackage()
                        + "]�p�b�P�[�W��["
                        + getProcessInterfaceName(argProcessStructure)
                        + "]�N���X���쐬���Ď��ۂ̃o�b�`�������������Ă��������B<br>");
        fCgInterface.getLangDoc().getDescriptionList().add("");

        expandMethodExecute(argProcessStructure);

        expandMethodProgress();

        {
            final BlancoBatchProcessExpandProcessInput expandProcessInput = new BlancoBatchProcessExpandProcessInput();
            expandProcessInput.setEncoding(fEncoding);
            expandProcessInput.expandSourceFile(argProcessStructure,
                    argDirectoryTarget);
        }

        if (BlancoStringUtil.null2Blank(
                argProcessStructure.getOutput().getEndBatchProcessException())
                .length() > 0) {
            // �o�b�`������O�I���̒l���ݒ肳��Ă���ꍇ�ɂ̂ݐ������܂��B

            fCgSourceFile.getImportList().add(
                    getBatchProcessExceptionClassName(argProcessStructure));

            if (BlancoStringUtil.null2Blank(fRuntimePackage).length() == 0) {
                // ��`�����Ƃɓ���p�b�P�[�W�Ƀ����^�C���N���X�𐶐��B
                new BlancoBatchProcessExpandException().expandSourceFile(
                        argProcessStructure.getPackage(), fTargetLang,
                        argDirectoryTarget);
            } else {
                // �����^�C���p�b�P�[�W�w�肪����̂ŁA�w��̃����^�C���p�b�P�[�W�ɃN���X�𐶐��B
                new BlancoBatchProcessExpandException().expandSourceFile(
                        fRuntimePackage, fTargetLang, argDirectoryTarget);
            }
        }

        switch (fTargetLang) {
        case BlancoBatchProcessSupportedLangStringGroup.JAVA:
            BlancoCgTransformerFactory.getJavaSourceTransformer().transform(
                    fCgSourceFile, fileBlancoMain);
            break;
        default:
            break;
        }
    }

    /**
     * execute ���\�b�h��W�J���܂��B
     * 
     * @param argProcessStructure
     *            ���^�t�@�C��������W�ł��������\���f�[�^�B
     */
    private void expandMethodExecute(
            final BlancoBatchProcessStructure argProcessStructure) {
        final BlancoCgMethod method = fCgFactory.createMethod("execute",
                "�N���X���C���X�^���X�����ď��������s����ۂ̃G���g���|�C���g�ł��B");
        fCgInterface.getMethodList().add(method);
        method.setFinal(true);

        method
                .getParameterList()
                .add(
                        fCgFactory
                                .createParameter(
                                        "input",
                                        argProcessStructure.getPackage()
                                                + ".valueobject."
                                                + BlancoBatchProcessExpandProcessInput
                                                        .getBatchProcessValueObjectInputClassName(argProcessStructure),
                                        "�����̓��̓p�����[�^�B"));
        method.setReturn(fCgFactory.createReturn("int", "�����̎��s���ʁB"));
        method.getThrowList().add(
                fCgFactory.createException("java.io.IOException",
                        "���o�͗�O�����������ꍇ�B"));
        method.getThrowList().add(
                fCgFactory
                        .createException("java.lang.IllegalArgumentException",
                                "���͒l�ɕs�������������ꍇ�B"));
    }

    /**
     * execute ���\�b�h��W�J���܂��B
     * 
     * @param argProcessStructure
     *            ���^�t�@�C��������W�ł��������\���f�[�^�B
     */
    private void expandMethodProgress() {
        final BlancoCgMethod method = fCgFactory.createMethod("progress",
                "�����̒��ŃA�C�e������������邽�тɐi���񍐂Ƃ��ăR�[���o�b�N���܂��B");
        fCgInterface.getMethodList().add(method);
        method.setFinal(true);

        method.getParameterList().add(
                fCgFactory.createParameter("argProgressMessage",
                        "java.lang.String", "���ݏ������Ă���A�C�e���Ɋւ��郁�b�Z�[�W�B"));
        method.setReturn(fCgFactory.createReturn("boolean",
                "���������̂܂܌p������ꍇ�� false�B�������f�����N�G�X�g�������ꍇ�� true�B"));
    }

    /**
     * �o�͐�ƂȂ鏈���C���^�t�F�[�X�����擾���܂��B
     * 
     * @param argProcessStructure
     * @return
     */
    static String getProcessInterfaceName(
            final BlancoBatchProcessStructure argProcessStructure) {
        return BlancoNameAdjuster.toClassName(argProcessStructure.getName())
                + "Process";
    }

    /**
     * �o�b�`������O�N���X�����擾���܂��B
     * 
     * @param argProcessStructure
     * @return
     */
    String getBatchProcessExceptionClassName(
            final BlancoBatchProcessStructure argProcessStructure) {
        if (BlancoStringUtil.null2Blank(
                argProcessStructure.getOutput().getEndBatchProcessException())
                .length() == 0) {
            throw new IllegalArgumentException(
                    "�o�b�`������O�I����OFF�ł���̂ɁABlancoBatchProcessException �N���X���擾�̃��\�b�h���Ăяo����܂����B�������Ă��܂�");
        }

        if (BlancoStringUtil.null2Blank(fRuntimePackage).length() == 0) {
            return argProcessStructure.getPackage()
                    + ".BlancoBatchProcessException";
        } else {
            return fRuntimePackage + ".BlancoBatchProcessException";
        }
    }
}
