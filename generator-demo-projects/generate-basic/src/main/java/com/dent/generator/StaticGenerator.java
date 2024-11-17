package com.dent.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;


public class StaticGenerator {
    public static void main(String[] args) {
        //GET ROOT PATH
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        //INPUT PATH
        String inputPath = new File(parentFile, "acm-template").getAbsolutePath();
        String outputPath = projectPath;
        copyFilesbyHutool(inputPath, outputPath);
    }

    public static void copyFilesbyHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    public static void copyFilesByMyself(String inputPath, String outputPath) {
        File src = new File(inputPath);
        File dest = new File(outputPath);

    }
}
