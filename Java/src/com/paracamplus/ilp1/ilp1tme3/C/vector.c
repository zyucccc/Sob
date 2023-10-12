#include "vector.h"
#include "ilp.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <string.h>
#include <setjmp.h>
#include <math.h>

ILP_Object
ILP_makeVector (ILP_Object taille,ILP_Object valeur)
{
	 if ( ILP_isInteger(taille) ) {
           int taille1 = taille -> _content.asInteger;
           ILP_Object vector = ILP_AllocateVector(taille1);
                  vector->_content.asVector._taille = taille1;
                  for(int i = 0; i < taille1; i++){
                             vector->_content.asVector.valeur[i] = valeur;
                         }
                         return vector;
	 }else{
		 return ILP_domain_error("la taille non numérique", taille);
	 }

}

ILP_Object
ILP_vectorLength (ILP_Object vector)
{
     if ( ILP_isVector(vector) ) {

     return ILP_make_integer(vector->_content.asVector._taille);

     }else {
     return  ILP_domain_error("une valeur non vector", vector);}
}


ILP_Object
ILP_vectorGet (ILP_Object vector,ILP_Object index)
{
     if ( ILP_isVector(vector) ) {
    	 if ( ILP_isInteger(index) ){

    		 int index1 = index->_content.asInteger;
    		 return vector->_content.asVector.valeur[index1];}
    	 else { return  ILP_domain_error("index non numérique", index);}


     }else{
     return  ILP_domain_error("une valeur non vector", vector);}
}




