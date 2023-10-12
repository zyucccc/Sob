#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <string.h>
#include <setjmp.h>
#include <math.h>

#include "ilp.h"

extern ILP_Object ILP_makeVector (ILP_Object taille,ILP_Object valeur);
extern ILP_Object ILP_vectorLength (ILP_Object vector);
extern ILP_Object ILP_vectorGet (ILP_Object vector,ILP_Object index);


