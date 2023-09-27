package com.paracamplus.ilp1.ilp1tme1.sequence;

import com.paracamplus.ilp1.ast.ASTinteger;
import org.junit.Test;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

import static org.junit.Assert.*;

public class ASTsequenceTest {
	IASTexpression[] expr_list = {
			new ASTinteger("1"),
			new ASTinteger("1"),
			new ASTinteger("1"),
	};
    IASTsequence seq1 = new ASTsequence(expr_list);
    @Test
    public void test() {
    	try {
    		IASTexpression[] Butlast = seq1.getAllButLastInstructions();
    		assertEquals(Butlast.length, seq1.getExpressions().length - 1);
    	}
    	catch(EvaluationException e) {
            e.getStackTrace();
        }
    }
}
