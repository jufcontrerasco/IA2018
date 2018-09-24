/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unalcol.agents.examples.labyrinth.teseo.simple;

import unalcol.agents.simulate.util.SimpleLanguage;

/**
 *
 * @author Jonatan
 */
public class IrrationalAgents extends SimpleTeseoAgentProgram {
	private int[][] matriz;
	private int orientacion;
	public IrrationalAgents() {}
    
    public IrrationalAgents(   SimpleLanguage _language  ) {
  	  super(_language);
    }

    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) {
        if (MT) return -1;
        
        int k = 0;
        matriz = new int [30][30];
        orientacion = 0; // Norte= 0, Oriente=1, Sur=2, Occidente=3
        
        switch(orientacion){
        	case 0:
        		if(!PF){
                	k = 3;
                	orientacion = 3;
                }
                if(!PD){
                	k = 3;
                	orientacion = 3;
                }
                if(!PA){
                	k = 3;
                	orientacion = 3;
                }
                if(!PI){
                	k = 3;
                	orientacion = 3;
                }                
        	case 1:
        		if(!PF){
                	k = 3;
                	orientacion = 3;
                }
                if(!PD){
                	k = 3;
                	orientacion = 3;
                }
                if(!PA){
                	k = 3;
                	orientacion = 3;
                }
                if(!PI){
                	k = 3;
                	orientacion = 3;
                } 
        	case 2:
        		if(!PF){
                	k = 3;
                	orientacion = 3;
                }
                if(!PD){
                	k = 3;
                	orientacion = 3;
                }
                if(!PA){
                	k = 3;
                	orientacion = 3;
                }
                if(!PI){
                	k = 3;
                	orientacion = 3;
                }         		
        	case 3:
        		if(!PF){
                	k = 3;
                	orientacion = 3;
                }
                if(!PD){
                	k = 3;
                	orientacion = 3;
                }
                if(!PA){
                	k = 3;
                	orientacion = 3;
                }
                if(!PI){
                	k = 3;
                	orientacion = 3;
                } 
        }
        return k;
    }
    
}
