package com.paracamplus.ilp1.ilp1tme3.compiler;

import com.paracamplus.ilp1.compiler.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.compiler.interfaces.IOperatorEnvironment;

public class Compiler extends com.paracamplus.ilp1.compiler.Compiler  {
	
	public Compiler (IOperatorEnvironment ioe,
            IGlobalVariableEnvironment igve ) {
            super(ioe,igve);

                  cProgramPrefix = ""
                    + "#include <stdio.h> \n"
                    + "#include <stdlib.h> \n"
                    + "#include \"ilp.h\" \n"
                    + "#include \"sinus.h\" \n"
                    + "#include <math.h>  \n"
                    ;
	
	
	}
	

}
