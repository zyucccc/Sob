#include "sinus.h"
#include "ilp.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <string.h>
#include <setjmp.h>
#include <math.h>

ILP_Object
ILP_sinus (ILP_Object val)
{
     if ( ILP_isInteger(val) ) {

     return ILP_make_float(sin(val->_content.asInteger));

     }else if ( ILP_isFloat(val) ) {

    	 return ILP_make_float(sin(val->_content.asFloat));
    }
     return  ILP_domain_error("une valeur non numérique", val);
}


