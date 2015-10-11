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
import java.util.List;

import blanco.batchprocess.stringgroup.BlancoBatchProcessBlancoTypeStringGroup;
import blanco.batchprocess.stringgroup.BlancoBatchProcessSupportedLangStringGroup;
import blanco.batchprocess.valueobject.BlancoBatchProcessInputItemStructure;
import blanco.batchprocess.valueobject.BlancoBatchProcessStructure;
import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.transformer.BlancoCgTransformerFactory;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoJavaSourceUtil;
import blanco.commons.util.BlancoNameAdjuster;
import blanco.commons.util.BlancoStringUtil;

/**
 * �o�b�`�������ۃN���X��W�J���܂��B
 */
class BlancoBatchProcessExpandBatchProcess {
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
    private BlancoCgClass fCgClass = null;

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
        fCgClass = fCgFactory.createClass(
                getBatchProcessClassName(argProcessStructure), BlancoStringUtil
                        .null2Blank(argProcessStructure.getDescription()));
        fCgSourceFile.getClassList().add(fCgClass);

        fCgClass.setDescription("�o�b�`�����N���X ["
                + getBatchProcessClassName(argProcessStructure) + "]�B");
        fCgClass.getLangDoc().getDescriptionList().add("");
        fCgClass.getLangDoc().getDescriptionList().add("<P>�o�b�`�����̌Ăяo����B</P>");

        fCgClass.getLangDoc().getDescriptionList().add("<code>");
        fCgClass.getLangDoc().getDescriptionList().add(
                "java -classpath (�N���X�p�X) " + argProcessStructure.getPackage()
                        + "." + getBatchProcessClassName(argProcessStructure)
                        + " -help");
        fCgClass.getLangDoc().getDescriptionList().add("</code>");

        expandField(argProcessStructure);
        expandMethodMain(argProcessStructure);
        expandMethodProcess(argProcessStructure);
        expandMethodExecute(argProcessStructure);
        expandMethodUsage(argProcessStructure);
        expandValidateInput(argProcessStructure);

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
     * �t�B�[���h��W�J���܂��B
     * 
     * @param argProcessStructure
     *            ���^�t�@�C��������W�ł��������\���f�[�^�B
     */
    private void expandField(
            final BlancoBatchProcessStructure argProcessStructure) {

        {
            final BlancoCgField field = fCgFactory.createField("END_SUCCESS",
                    "int", "����I���B");
            fCgClass.getFieldList().add(field);

            field.setAccess("public");
            field.setStatic(true);
            field.setFinal(true);
            field.setDefault(argProcessStructure.getOutput().getEndSuccess());
        }

        if (BlancoStringUtil.null2Blank(
                argProcessStructure.getOutput().getEndBatchProcessException())
                .length() > 0) {
            // �o�b�`������O�I���̒l���ݒ肳��Ă���ꍇ�ɂ̂ݐ������܂��B

            final BlancoCgField field = fCgFactory.createField(
                    "END_BATCHPROCESS_EXCEPTION", "int",
                    "�o�b�`������O�I���B�����I��BatchProcessException�����������ꍇ�B");
            fCgClass.getFieldList().add(field);

            field.setAccess("public");
            field.setStatic(true);
            field.setFinal(true);
            field.setDefault(argProcessStructure.getOutput()
                    .getEndBatchProcessException());
        }

        {
            final BlancoCgField field = fCgFactory.createField(
                    "END_ILLEGAL_ARGUMENT_EXCEPTION", "int",
                    "���ُ͈�I���B�����I��java.lang.IllegalArgumentException�����������ꍇ�B");
            fCgClass.getFieldList().add(field);

            field.setAccess("public");
            field.setStatic(true);
            field.setFinal(true);
            field.setDefault(argProcessStructure.getOutput()
                    .getEndIllegalArgumentException());
        }

        {
            final BlancoCgField field = fCgFactory.createField(
                    "END_IO_EXCEPTION", "int",
                    "���o�͗�O�I���B�����I��java.io.IOException�����������ꍇ�B");
            fCgClass.getFieldList().add(field);

            field.setAccess("public");
            field.setStatic(true);
            field.setFinal(true);
            field.setDefault(argProcessStructure.getOutput()
                    .getEndIoException());
        }

        {
            final BlancoCgField field = fCgFactory
                    .createField(
                            "END_ERROR",
                            "int",
                            "�ُ�I���B�o�b�`�̏����J�n�Ɏ��s�����ꍇ�A����ѓ����I��java.lang.Error�܂���java.lang.RuntimeException�����������ꍇ�B");
            fCgClass.getFieldList().add(field);

            field.setAccess("public");
            field.setStatic(true);
            field.setFinal(true);
            field.setDefault(argProcessStructure.getOutput().getEndError());
        }
    }

    /**
     * main ���\�b�h��W�J���܂��B
     * 
     * @param argProcessStructure
     *            ���^�t�@�C��������W�ł��������\���f�[�^�B
     */
    private void expandMethodMain(
            final BlancoBatchProcessStructure argProcessStructure) {

        final BlancoCgMethod method = fCgFactory.createMethod("main",
                "�R�}���h���C��������s���ꂽ�ۂ̃G���g���|�C���g�ł��B");
        fCgClass.getMethodList().add(method);

        method.setStatic(true);
        method.setFinal(true);
        method.getParameterList().add(
                fCgFactory.createParameter("args", "java.lang.String[]",
                        "�R���\�[����������p���ꂽ�����B"));

        final List<java.lang.String> listLine = method.getLineList();
        listLine.add("final " + getBatchProcessClassName(argProcessStructure)
                + " batchProcess = new "
                + getBatchProcessClassName(argProcessStructure) + "();");
        listLine.add("");
        listLine.add("// �o�b�`�����̈����B");
        final String valueObjectClassname = BlancoBatchProcessExpandProcessInput
                .getBatchProcessValueObjectInputClassName(argProcessStructure);
        fCgSourceFile.getImportList().add(
                argProcessStructure.getPackage() + ".valueobject."
                        + valueObjectClassname);
        listLine.add("final " + valueObjectClassname + " input = new "
                + valueObjectClassname + "();");
        listLine.add("");
        listLine.add("boolean isNeedUsage = false;");

        for (int index = 0; index < argProcessStructure.getInputItemList()
                .size(); index++) {
            final BlancoBatchProcessInputItemStructure inputItem = (BlancoBatchProcessInputItemStructure) argProcessStructure
                    .getInputItemList().get(index);
            if (inputItem.getRequire()) {
                listLine.add("boolean isField"
                        + BlancoNameAdjuster.toClassName(inputItem.getName())
                        + "Processed = false;");
            }
        }

        listLine.add("");
        listLine.add("// �R�}���h���C�������̉�͂������Ȃ��܂��B");
        listLine.add("for (int index = 0; index < args.length; index++) {");
        listLine.add("String arg = args[index];");
        for (int index = 0; index < argProcessStructure.getInputItemList()
                .size(); index++) {
            final BlancoBatchProcessInputItemStructure inputItem = (BlancoBatchProcessInputItemStructure) argProcessStructure
                    .getInputItemList().get(index);
            String line = "";
            if (index == 0) {
            } else {
                line += "} else ";
            }
            line += "if (arg.startsWith(\"-" + inputItem.getName() + "=\")) {";
            listLine.add(line);
            switch (new BlancoBatchProcessBlancoTypeStringGroup()
                    .convertToInt(inputItem.getType())) {
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_STRING:
                listLine.add("input.set"
                        + BlancoNameAdjuster.toClassName(inputItem.getName())
                        + "(arg.substring("
                        + (inputItem.getName().length() + 2) + "));");
                break;
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_INT:
                listLine.add("try {");
                listLine.add("input.set"
                        + BlancoNameAdjuster.toClassName(inputItem.getName())
                        + "(Integer.parseInt(arg.substring("
                        + (inputItem.getName().length() + 2) + ")));");
                listLine.add("} catch (NumberFormatException e) {");
                listLine.add("System.out.println(\""
                        + getBatchProcessClassName(argProcessStructure)
                        + ": �����J�n���s�B���̓p�����[�^[input]�̃t�B�[���h["
                        + inputItem.getName()
                        + "]�𐔒l(int)�Ƃ��ăp�[�X�����݂܂��������s���܂����B: \" + e.toString());");
                listLine.add("System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);");
                listLine.add("}");
                break;
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_LONG:
                listLine.add("try {");
                listLine.add("input.set"
                        + BlancoNameAdjuster.toClassName(inputItem.getName())
                        + "(Long.parseLong(arg.substring("
                        + (inputItem.getName().length() + 2) + ")));");
                listLine.add("} catch (NumberFormatException e) {");
                listLine
                        .add("System.out.println(\""
                                + getBatchProcessClassName(argProcessStructure)
                                + ": �����J�n���s�B���̓p�����[�^[input]�̃t�B�[���h["
                                + inputItem.getName()
                                + "]�𐔒l(long)�Ƃ��ăp�[�X�����݂܂��������s���܂����B: \" + e.toString());");
                listLine.add("System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);");
                listLine.add("}");
                break;
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_DECIMAL:
                fCgSourceFile.getImportList().add("java.math.BigDecimal");
                listLine.add("try {");
                listLine.add("input.set"
                        + BlancoNameAdjuster.toClassName(inputItem.getName())
                        + "(new BigDecimal(arg.substring("
                        + (inputItem.getName().length() + 2) + ")));");
                listLine.add("} catch (NumberFormatException e) {");
                listLine
                        .add("System.out.println(\""
                                + getBatchProcessClassName(argProcessStructure)
                                + ": �����J�n���s�B���̓p�����[�^[input]�̃t�B�[���h["
                                + inputItem.getName()
                                + "]�𐔒l(decimal)�Ƃ��ăp�[�X�����݂܂��������s���܂����B: \" + e.toString());");
                listLine.add("System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);");
                listLine.add("}");
                break;
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_BOOLEAN:
                listLine.add("input.set"
                        + BlancoNameAdjuster.toClassName(inputItem.getName())
                        + "(Boolean.valueOf(arg.substring("
                        + (inputItem.getName().length() + 2)
                        + ")).booleanValue());");
                break;
            }
            if (inputItem.getRequire()) {
                listLine.add("isField"
                        + BlancoNameAdjuster.toClassName(inputItem.getName())
                        + "Processed = true;");
            }
        }
        listLine.add((argProcessStructure.getInputItemList().size() == 0 ? ""
                : "} else ")
                + "if (arg.equals(\"-?\") || arg.equals(\"-help\")) {");
        listLine.add("usage();");
        listLine.add("System.exit(END_SUCCESS);");
        listLine.add("} else {");
        listLine.add("System.out.println(\""
                + getBatchProcessClassName(argProcessStructure)
                + ": ���̓p�����[�^[\" + arg + \"]�͖�������܂����B\");");
        listLine.add("isNeedUsage = true;");
        listLine.add("}");
        listLine.add("}");
        listLine.add("");
        listLine.add("if (isNeedUsage) {");
        listLine.add("usage();");
        listLine.add("}");
        listLine.add("");
        for (int index = 0; index < argProcessStructure.getInputItemList()
                .size(); index++) {
            final BlancoBatchProcessInputItemStructure inputItem = (BlancoBatchProcessInputItemStructure) argProcessStructure
                    .getInputItemList().get(index);
            if (inputItem.getRequire()) {
                listLine.add("if( isField"
                        + BlancoNameAdjuster.toClassName(inputItem.getName())
                        + "Processed == false) {");
                listLine.add("System.out.println(\""
                        + getBatchProcessClassName(argProcessStructure)
                        + ": �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l["
                        + inputItem.getName() + "]�ɒl���ݒ肳��Ă��܂���B\");");
                listLine.add("System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);");
                listLine.add("}");
            }
        }
        listLine.add("");
        listLine.add("int retCode = batchProcess.execute(input);");
        listLine.add("");
        listLine.add("// �I���R�[�h��߂��܂��B");
        listLine.add("// �����ӁFSystem.exit()���Ăяo���Ă���_�ɒ��ӂ��Ă��������B");
        listLine.add("System.exit(retCode);");
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
                "�N���X���C���X�^���X�����ăo�b�`�����s����ۂ̃G���g���|�C���g�ł��B");
        fCgClass.getMethodList().add(method);
        method.setFinal(true);
        method.getLangDoc().getDescriptionList().add("���̃��\�b�h�͉��L�̎d�l��񋟂��܂��B");
        method.getLangDoc().getDescriptionList().add("<ul>");
        method.getLangDoc().getDescriptionList()
                .add("<li>���\�b�h�̓��̓p�����[�^�̓��e�`�F�b�N�B");
        method
                .getLangDoc()
                .getDescriptionList()
                .add(
                        "<li>IllegalArgumentException, RuntimeException, Error�Ȃǂ̗�O��catch���Ė߂�l�ւƕϊ��B");
        method.getLangDoc().getDescriptionList().add("</ul>");

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
                                        "�o�b�`�����̓��̓p�����[�^�B"));
        method.setReturn(fCgFactory.createReturn("int",
                getReturnJavadocDescription(argProcessStructure)));
        method.getThrowList().add(
                fCgFactory
                        .createException("java.lang.IllegalArgumentException",
                                "���͒l�ɕs�������������ꍇ�B"));

        final List<java.lang.String> listLine = method.getLineList();

        listLine.add("try {");
        if (argProcessStructure.getShowMessageBeginEnd()) {
            listLine.add("System.out.println(\""
                    + getBatchProcessClassName(argProcessStructure)
                    + ": begin\");");
            listLine.add("");
        }

        listLine.add("// �o�b�`�����̖{�̂����s���܂��B");
        listLine.add("int retCode = process(input);");
        listLine.add("");
        if (argProcessStructure.getShowMessageBeginEnd()) {
            listLine.add("System.out.println(\""
                    + getBatchProcessClassName(argProcessStructure)
                    + ": end (\" + retCode + \")\");");
        }
        listLine.add("return retCode;");

        if (BlancoStringUtil.null2Blank(
                argProcessStructure.getOutput().getEndBatchProcessException())
                .length() > 0) {
            // �o�b�`������O�I���̒l���ݒ肳��Ă���ꍇ�ɂ̂ݐ������܂��B

            listLine.add("} catch (BlancoBatchProcessException ex) {");
            listLine.add("System.out.println(\""
                    + getBatchProcessClassName(argProcessStructure)
                    + ": �o�b�`������O���������܂����B�o�b�`�����𒆒f���܂��B:\" + ex.toString());");
            listLine.add("// �o�b�`������O�I���B");
            listLine.add("return END_BATCHPROCESS_EXCEPTION;");
        }
        listLine.add("} catch (IllegalArgumentException ex) {");
        listLine.add("System.out.println(\""
                + getBatchProcessClassName(argProcessStructure)
                + ": ���͗�O���������܂����B�o�b�`�����𒆒f���܂��B:\" + ex.toString());");
        listLine.add("// ���ُ͈�I���B");
        listLine.add("return END_ILLEGAL_ARGUMENT_EXCEPTION;");
        listLine.add("} catch (IOException ex) {");
        listLine.add("System.out.println(\""
                + getBatchProcessClassName(argProcessStructure)
                + ": ���o�͗�O���������܂����B�o�b�`�����𒆒f���܂��B:\" + ex.toString());");
        listLine.add("// ���ُ͈�I���B");
        listLine.add("return END_IO_EXCEPTION;");
        listLine.add("} catch (RuntimeException ex) {");
        listLine.add("System.out.println(\""
                + getBatchProcessClassName(argProcessStructure)
                + ": �����^�C����O���������܂����B�o�b�`�����𒆒f���܂��B:\" + ex.toString());");
        listLine.add("ex.printStackTrace();");
        listLine.add("// �ُ�I���B");
        listLine.add("return END_ERROR;");
        listLine.add("} catch (Error er) {");
        listLine.add("System.out.println(\""
                + getBatchProcessClassName(argProcessStructure)
                + ": �����^�C���G���[���������܂����B�o�b�`�����𒆒f���܂��B:\" + er.toString());");
        listLine.add("er.printStackTrace();");
        listLine.add("// �ُ�I���B");
        listLine.add("return END_ERROR;");
        listLine.add("}");
    }

    /**
     * process ���\�b�h��W�J���܂��B
     * 
     * @param argProcessStructure
     *            ���^�t�@�C��������W�ł��������\���f�[�^�B
     */
    private void expandMethodProcess(
            final BlancoBatchProcessStructure argProcessStructure) {

        final BlancoCgMethod method = fCgFactory.createMethod("process",
                "��̓I�ȃo�b�`�������e���L�q���邽�߂̃��\�b�h�ł��B");
        fCgClass.getMethodList().add(method);

        method.getLangDoc().getDescriptionList().add("���̃��\�b�h�Ɏ��ۂ̏������e���L�q���܂��B");
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
                                        "�o�b�`�����̓��̓p�����[�^�B"));
        method.setReturn(fCgFactory.createReturn("int",
                getReturnJavadocDescription(argProcessStructure)));
        method.getThrowList().add(
                fCgFactory.createException("java.io.IOException",
                        "���o�͗�O�����������ꍇ�B"));
        method.getThrowList().add(
                fCgFactory
                        .createException("java.lang.IllegalArgumentException",
                                "���͒l�ɕs�������������ꍇ�B"));

        final List<java.lang.String> listLine = method.getLineList();
        listLine.add("// ���̓p�����[�^���`�F�b�N���܂��B");
        listLine.add("validateInput(input);");
        listLine.add("");
        listLine.add("// ���̉ӏ��ŃR���p�C���G���[����������ꍇ�A"
                + BlancoNameAdjuster.toClassName(argProcessStructure.getName())
                + "Process�C���^�t�F�[�X���������� " + argProcessStructure.getPackage()
                + "�p�b�P�[�W�� "
                + BlancoNameAdjuster.toClassName(argProcessStructure.getName())
                + "ProcessImpl�N���X���쐬���邱�Ƃɂ������ł���ꍇ������܂��B");
        listLine.add("final "
                + BlancoNameAdjuster.toClassName(argProcessStructure.getName())
                + "Process process = new "
                + BlancoNameAdjuster.toClassName(argProcessStructure.getName())
                + "ProcessImpl();");
        listLine.add("");
        listLine.add("// �����̖{�̂����s���܂��B");
        listLine.add("final int retCode = process.execute(input);");
        listLine.add("");
        listLine.add("return retCode;");
    }

    /**
     * execute ���\�b�h��W�J���܂��B
     * 
     * @param argProcessStructure
     *            ���^�t�@�C��������W�ł��������\���f�[�^�B
     */
    private void expandMethodUsage(
            final BlancoBatchProcessStructure argProcessStructure) {

        final BlancoCgMethod method = fCgFactory.createMethod("usage",
                "���̃o�b�`�����N���X�̎g�����̐�����W���o�͂Ɏ������߂̃��\�b�h�ł��B");
        fCgClass.getMethodList().add(method);

        method.setStatic(true);
        method.setFinal(true);

        final List<java.lang.String> listLine = method.getLineList();
        listLine.add("System.out.println(\""
                + getBatchProcessClassName(argProcessStructure)
                + ": Usage:\");");
        {
            String strArg = "System.out.println(\"  java "
                    + argProcessStructure.getPackage() + "."
                    + getBatchProcessClassName(argProcessStructure);
            for (int index = 0; index < argProcessStructure.getInputItemList()
                    .size(); index++) {
                final BlancoBatchProcessInputItemStructure inparam = (BlancoBatchProcessInputItemStructure) argProcessStructure
                        .getInputItemList().get(index);
                strArg += " -" + inparam.getName() + "=�l" + (index + 1) + "";
            }
            strArg += "\");";
            listLine.add(strArg);
        }

        for (int index = 0; index < argProcessStructure.getInputItemList()
                .size(); index++) {
            final BlancoBatchProcessInputItemStructure inputItem = (BlancoBatchProcessInputItemStructure) argProcessStructure
                    .getInputItemList().get(index);
            listLine.add("System.out.println(\"    -" + inputItem.getName()
                    + "\");");
            if (inputItem.getDescription() != null) {
                listLine.add("System.out.println(\"      ����["
                        + BlancoJavaSourceUtil
                                .escapeStringAsJavaSource(inputItem
                                        .getDescription()) + "]\");");
            }
            switch (new BlancoBatchProcessBlancoTypeStringGroup()
                    .convertToInt(inputItem.getType())) {
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_STRING:
                listLine.add("System.out.println(\"      �^[������]\");");
                break;
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_INT:
                listLine.add("System.out.println(\"      �^[���l(int)]\");");
                break;
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_LONG:
                listLine.add("System.out.println(\"      �^[���l(long)]\");");
                break;
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_DECIMAL:
                listLine.add("System.out.println(\"      �^[���l(decimal)]\");");
                break;
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_BOOLEAN:
                listLine.add("System.out.println(\"      �^[�^�U]\");");
                break;
            }
            if (inputItem.getRequire()) {
                listLine.add("System.out.println(\"      �K�{�p�����[�^\");");
            }
            if (inputItem.getDefault() != null) {
                listLine.add("System.out.println(\"      �f�t�H���g�l["
                        + BlancoJavaSourceUtil
                                .escapeStringAsJavaSource(inputItem
                                        .getDefault()) + "]\");");
            }
        }
        listLine.add("System.out.println(\"    -? , -help\");");
        listLine.add("System.out.println(\"      ����[�g������\�����܂��B]\");");
    }

    /**
     * validateInput ���\�b�h��W�J���܂��B
     * 
     * @param argProcessStructure
     *            ���^�t�@�C��������W�ł��������\���f�[�^�B
     */
    private void expandValidateInput(
            final BlancoBatchProcessStructure argProcessStructure) {

        final BlancoCgMethod method = fCgFactory.createMethod("validateInput",
                "���̃o�b�`�����N���X�̓��̓p�����[�^�̑Ó����`�F�b�N�����{���邽�߂̃��\�b�h�ł��B");
        fCgClass.getMethodList().add(method);

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
                                        "�o�b�`�����̓��̓p�����[�^�B"));
        method.getThrowList().add(
                fCgFactory
                        .createException("java.lang.IllegalArgumentException",
                                "���͒l�ɕs�������������ꍇ�B"));

        final List<java.lang.String> listLine = method.getLineList();

        listLine.add("if (input == null) {");
        listLine
                .add("throw new IllegalArgumentException(\"BlancoBatchProcessBatchProcess: �����J�n���s�B���̓p�����[�^[input]��null���^�����܂����B\");");
        listLine.add("}");

        for (int index = 0; index < argProcessStructure.getInputItemList()
                .size(); index++) {
            final BlancoBatchProcessInputItemStructure inputItem = (BlancoBatchProcessInputItemStructure) argProcessStructure
                    .getInputItemList().get(index);
            switch (new BlancoBatchProcessBlancoTypeStringGroup()
                    .convertToInt(inputItem.getType())) {
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_STRING:
            case BlancoBatchProcessBlancoTypeStringGroup.BLANCO_DECIMAL:
                // �K�{���ǂ����Ō^���ς��Ȃ����̂̂݃`�F�b�N���܂��B
                if (inputItem.getRequire()) {
                    listLine.add("if (input.get"
                            + BlancoNameAdjuster.toClassName(inputItem
                                    .getName()) + "() == null) {");
                    listLine.add("throw new IllegalArgumentException(\""
                            + getBatchProcessClassName(argProcessStructure)
                            + ": �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l["
                            + inputItem.getName() + "]�ɒl���ݒ肳��Ă��܂���B\");");
                    listLine.add("}");
                }
                break;
            }
        }
    }

    /**
     * �o�͐�ƂȂ�o�b�`�����N���X�����擾���܂��B
     * 
     * @param argProcessStructure
     * @return
     */
    static String getBatchProcessClassName(
            final BlancoBatchProcessStructure argProcessStructure) {
        return BlancoNameAdjuster.toClassName(argProcessStructure.getName())
                + BlancoStringUtil.null2Blank(argProcessStructure.getSuffix());
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

    /**
     * �o�b�`�̃��\�b�h�̖߂�l��JavaDoc�������擾���܂��B
     * 
     * @param argProcessStructure
     * @return
     */
    private static String getReturnJavadocDescription(
            final BlancoBatchProcessStructure argProcessStructure) {
        return "�o�b�`�����̏I���R�[�h�BEND_SUCCESS, END_ILLEGAL_ARGUMENT_EXCEPTION, END_IO_EXCEPTION, END_ERROR"
                + (BlancoStringUtil.null2Blank(
                        argProcessStructure.getOutput()
                                .getEndBatchProcessException()).length() == 0 ? ""
                        : ", END_BATCHPROCESS_EXCEPTION")
                + " �̂����ꂩ�̒l��߂��܂��B"
                + BlancoStringUtil.null2Blank(argProcessStructure.getOutput()
                        .getDescription());
    }
}
