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

import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgMethod;

/**
 * blancoCg�̂��߂̓T�^�I�ȃ��[�e�B���e�B�B
 * 
 * TODO blancoCg�ɕ����ł��Ȃ����ǂ����������邱�ƁB
 */
class BlancoCgUtil {
    /**
     * ��O�N���X�̂��߂̓T�^�I�ȃR���X�g���N�^4��ǉ����܂��B
     * 
     * @param argCgFactory
     *            blancoCg�I�u�W�F�N�g�t�@�N�g���̃C���X�^���X�B
     * @param argCgClass
     *            �N���X���B
     */
    public static void addConstructorForException(
            final BlancoCgObjectFactory argCgFactory,
            final BlancoCgClass argCgClass) {
        {
            final BlancoCgMethod method = argCgFactory.createMethod(argCgClass
                    .getName(), "�ڍ׃��b�Z�[�W�������Ȃ���O���\�z���܂��B");
            argCgClass.getMethodList().add(method);

            method.setConstructor(true);
            method.setSuperclassInvocation("super()");
        }

        {
            final BlancoCgMethod method = argCgFactory.createMethod(argCgClass
                    .getName(), "�w�肳�ꂽ�ڍ׃��b�Z�[�W������O���\�z���܂��B");
            argCgClass.getMethodList().add(method);

            method.setConstructor(true);
            method.setSuperclassInvocation("super(message)");

            method.getParameterList().add(
                    argCgFactory.createParameter("message", "java.lang.String",
                            "�ڍ׃��b�Z�[�W�B"));
        }

        {
            final BlancoCgMethod method = argCgFactory.createMethod(argCgClass
                    .getName(), "�w�肳�ꂽ�ڍ׃��b�Z�[�W����ь������w�肵�ė�O���\�z���܂��B");
            argCgClass.getMethodList().add(method);

            method.setConstructor(true);
            method.setSuperclassInvocation("super(message, cause)");

            method.getParameterList().add(
                    argCgFactory.createParameter("message", "java.lang.String",
                            "�ڍ׃��b�Z�[�W�B"));
            method.getParameterList().add(
                    argCgFactory.createParameter("cause",
                            "java.lang.Throwable", "�����B"));

        }

        {
            final BlancoCgMethod method = argCgFactory.createMethod(argCgClass
                    .getName(), "�������w�肵�ė�O���\�z���܂��B");
            argCgClass.getMethodList().add(method);

            method.setConstructor(true);
            method.setSuperclassInvocation("super(cause)");

            method.getParameterList().add(
                    argCgFactory.createParameter("cause",
                            "java.lang.Throwable", "�����B"));

        }
    }
}
