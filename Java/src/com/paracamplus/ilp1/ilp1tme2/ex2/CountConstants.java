package com.paracamplus.ilp1.ilp1tme2.ex2;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;

public class CountConstants implements IASTvisitor<Integer, Integer, Exception>{
    
	public Integer visit(IASTprogram iast, Integer data) throws Exception{
        return iast.getBody().accept(this,data);
    }	
	
	public Integer visit(IASTalternative iast, Integer data) throws Exception {
		data+=iast.getCondition().accept(this, data);
		Object c = iast.getCondition().accept(this, data);
        if ( c != null && c instanceof Boolean ) {
            Boolean b = (Boolean) c;
            if ( b ) {
            	data +=iast.getConsequence().accept(this, data);
            } else if ( iast.isTernary() ) {
            	data += iast.getAlternant().accept(this, data);                
            }
        } else {
        	data += iast.getConsequence().accept(this, data);
        }
        return data;
		
	}

	@Override
	public Integer visit(IASTbinaryOperation iast, Integer data) throws Exception {
		data+= iast.getLeftOperand().accept(this, data);
        data+= iast.getRightOperand().accept(this, data);
		return data;
	}

	@Override
	public Integer visit(IASTblock iast, Integer data) throws Exception {
		 for ( IASTbinding binding : iast.getBindings() ) {
			 data+= binding.getInitialisation().accept(this, data);
	        }
		 return data;
	}

	@Override
	public Integer visit(IASTboolean iast, Integer data) throws Exception {
		
		return data+1;
	}

	@Override
	public Integer visit(IASTfloat iast, Integer data) throws Exception {
		
		return data+1;
	}

	@Override
	public Integer visit(IASTinteger iast, Integer data) throws Exception {
		return data+1;
	}

	@Override
	public Integer visit(IASTinvocation iast, Integer data) throws Exception {
		 for (IASTexpression arg : iast.getArguments()) {
		        arg.accept(this, data);
		    }
		 return data;
	}

	@Override
	public Integer visit(IASTsequence iast, Integer data) throws Exception {
		 IASTexpression[] expressions = iast.getExpressions();
		    if (expressions != null) {
		        for (IASTexpression expression : expressions) {
		            data += expression.accept(this, data);
		        }
		    }
		    return data;
	}

	@Override
	public Integer visit(IASTstring iast, Integer data) throws Exception {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer visit(IASTunaryOperation iast, Integer data) throws Exception {
		data += iast.getOperand().accept(this,data);
        return data;
	}

	@Override
	public Integer visit(IASTvariable iast, Integer data) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}




}
