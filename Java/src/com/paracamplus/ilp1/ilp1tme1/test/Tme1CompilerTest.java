package com.paracamplus.ilp1.ilp1tme1.test;

import com.paracamplus.ilp1.compiler.test.CompilerRunner;
import com.paracamplus.ilp1.compiler.test.CompilerTest;

import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Collection;

public class Tme1CompilerTest extends CompilerTest  {
    protected static String[] samplesDirName = { "SamplesTME1" };
    
    public Tme1CompilerTest(File file) {
        super(file);
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<File[]> data() throws Exception {
        return CompilerRunner.getFileList(samplesDirName, pattern);
    }
}