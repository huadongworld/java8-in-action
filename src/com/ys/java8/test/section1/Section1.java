package com.ys.java8.test.section1;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class Section1 {

    @Test
    public void Demo01() {

        /**
         * 函数式编程：编写把函数作为一等值来传递的程序
         */
        File[] hiddenFiles = new File(".").listFiles(
                new FileFilter() {
                    public boolean accept(File file) {
                        return file.isHidden();
                    }
                }
        );

        File[] hiddenFiles1 = new File(".").listFiles(File::isHidden);
    }
}
