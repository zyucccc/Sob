package com.paracamplus.ilp1.ilp1tme2.ex2;

import antlr4.ILPMLgrammar1Parser;
import com.paracamplus.ilp1.interfaces.IASTfactory;

public class ILPMLListener extends com.paracamplus.ilp1.parser.ilpml.ILPMLListener {
    protected int cpt = 0;

    public int getCpt() {
        return cpt;
    }

    public ILPMLListener(IASTfactory factory) {
        super(factory);
    }

    public void exitConstFloat(ILPMLgrammar1Parser.ConstFloatContext ctx) {
        super.exitConstFloat(ctx);
        cpt++;
    }

    public void exitConstInteger(ILPMLgrammar1Parser.ConstIntegerContext ctx) {
        super.exitConstInteger(ctx);
        cpt++;
    }

    public void exitConstFalse(ILPMLgrammar1Parser.ConstFalseContext ctx) {
        super.exitConstFalse(ctx);
        cpt++;
    }

    public void exitConstTrue(ILPMLgrammar1Parser.ConstTrueContext ctx) {
        super.exitConstTrue(ctx);
        cpt++;
    }

    
    public void exitConstString(ILPMLgrammar1Parser.ConstStringContext ctx) {
        super.exitConstString(ctx);
        cpt++;
    }
}