/*
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
	private int orientacion = 0;
	private int k = 0;
	private int x;
	private int y;
	public IrrationalAgents() {
        matriz = new int [31][31]; 
        x = 15;
    	y = 15;
    	matriz[x][y] = 2;
	}
    
    public IrrationalAgents(   SimpleLanguage _language  ) {
  	  super(_language);
    }
    
    

    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) { 	
    
    	    	
        if (MT) return -1;        
        // Norte= 1, Oriente=2, Sur=3, Occidente=4
        System.out.println(k);
        System.out.println(orientacion);
        System.out.println("   "+PF);
        System.out.println(PI);
        System.out.println("          "+PD);
        System.out.println("   "+PA);
        System.out.println(x+","+y);
 
        
        switch(orientacion){
    	case 0: //Al Frente        		
    		if(!PF){
    			if(matriz[x][y-1] == 0 && orientacion == 0){
    				matriz[x][y-1] = 1;
    				}
    		}
    		if(!PD){
    			if(matriz[x+1][y] == 0 && orientacion == 0){
    				matriz[x+1][y] = 1;
    				}
    		}
    		if(!PA){
    			if(matriz[x][y+1] == 0 && orientacion == 0){
    				matriz[x][y+1] = 1;
    				System.out.println("Error");
    				}
    		}
    		if(!PI){
    			if(matriz[x-1][y] == 0 && orientacion == 0){
    				matriz[x-1][y] = 1;
    				System.out.println("Marca OF-I");
    				}
    		}
	    case 1: //Derecha        		
			if(!PF){
				if(matriz[x+1][y] == 0 && orientacion == 1){
					matriz[x+1][y] = 1;
					}
			}
			if(!PD){
				if(matriz[x][y+1] == 0 && orientacion == 1){
					matriz[x][y+1] = 1;
					}
			}
			if(!PA){
				if(matriz[x-1][y] == 0 && orientacion == 1){
					matriz[x-1][y] = 1;
					}
			}
			if(!PI){
				if(matriz[x][y-1] == 0 && orientacion == 1){
					matriz[x][y-1] = 1;
					}
			}
	    case 2: //Atras        		
			if(!PF){
				if(matriz[x][y+1] == 0 && orientacion == 2){
					matriz[x][y+1] = 1;
					}
			}
			if(!PD){
				if(matriz[x-1][y] == 0 && orientacion == 2){
					matriz[x-1][y] = 1;
					}
			}
			if(!PA){
				if(matriz[x][y-1] == 0 && orientacion == 2){
					matriz[x][y-1] = 1;
					}
			}
			if(!PI){
				if(matriz[x+1][y] == 0 && orientacion == 2){
					matriz[x+1][y] = 1;
					}
			}
	    case 3: //Izquierda        		
			if(!PF){
				if(matriz[x-1][y] == 0 && orientacion == 3){
					matriz[x-1][y] = 1;
					}
			}
			if(!PD){
				if(matriz[x][y-1] == 0 && orientacion == 3){
					matriz[x][y-1] = 1;
					}
			}
			if(!PA){
				if(matriz[x+1][y] == 0 && orientacion == 3){
					matriz[x+1][y] = 1;
					}
			}
			if(!PI){
				if(matriz[x][y+1] == 0 && orientacion == 3){
					matriz[x][y+1] = 1;
					}
			}
	    }

               
        switch(orientacion){
        	case 0: //Al Frente        		
        		if(!PF){
        			switch(matriz[x][y-1]){     					
            			case 1:
        					k = 0;
        					matriz[x][y]= 2;
        					y = y-1;
        					orientacion = 0;
        					System.out.println("Entra OF-F");
        					break;
        					
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x-1][y] != 1 && matriz[x+1][y] != 1 || PD && PA && PI ) {
        						k = 0;
        						matriz[x][y] = 3;
        						y = y - 1;
        						orientacion = 0;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                if(!PD){
                	switch(matriz[x+1][y]){
	    				case 1:
	    					k = 1;
	    					matriz[x][y]= 2;
	    					x = x + 1;
	    					orientacion = 1;
	    					break;
	    				case 2:
	    					if(matriz[x][y+1] != 1 && matriz[x-1][y] != 1 && matriz[x][y-1] != 1 || PF && PA && PI) {
        						k = 1;
        						matriz[x][y] = 3;
        						x = x + 1;
        						orientacion = 1;
        					}	    					
	    					break;
	    				case 3:
	    					break;
	    			  
	    			}  
                	break;
                }                
                if(!PA){
                	switch(matriz[x][y+1]){              		

	    				case 1:
	    					k = 2;
	    					matriz[x][y]= 2;
	    					y = y + 1;
	    					orientacion = 2;
	    					break;
	    				case 2:
	    					System.out.println("Entra atras");
	    					if(matriz[x][y-1] != 1 && matriz[x-1][y] != 1 && matriz[x+1][y] != 1 || PF && PD && PI) {
        						k = 2;
        						matriz[x][y] = 3;
        						y = y + 1;
        						orientacion = 2;
        					break;
        					}	    					
	    				case 3:
	    					break;
	    			}
                }
                if(!PI){
                	switch(matriz[x-1][y]){  
	    				case 1:
	    					k = 3;
	    					matriz[x][y]= 2;
	    					x = x-1;
	    					orientacion = 3;
	    					System.out.println("Entra OF-I");
	    					System.out.println(k);
	    					break;
	    				case 2:
	    					if(matriz[x][y+1] != 1 && matriz[x][y-1] != 1 && matriz[x+1][y] != 1 || PF && PD && PA) {
        						k = 3;
        						matriz[x][y] = 3;
        						x = x - 1;
        						orientacion = 3;
        					}	    					
	    					break;
	    				case 3:
	    					break;
	    			}
                }    
                break;
        	case 1: //Orientacion a la Derecha        		
        		if(!PF){
        			switch(matriz[x+1][y]){

        				case 1:
        					k = 1;
        					matriz[x][y]= 2;
        					x = x + 1;
        					orientacion = 1;
        					break;
        					
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x-1][y] != 1 && matriz[x][y-1] != 1 || PD && PA && PI) {
        						k = 1;
        						matriz[x][y] = 3;
        						x = x + 1;
        						orientacion = 1;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                if(!PD){
        			switch(matriz[x][y+1]){
        				case 1:
        					k = 2;
        					matriz[x][y]= 2;
        					y = y+1;
        					orientacion = 2;
        					break;
        				case 2:
        					if(matriz[x][y-1] != 1 && matriz[x-1][y] != 1 && matriz[x+1][y] != 1 || PF && PA && PI) {
        						k = 2;
        						matriz[x][y] = 3;
        						y = y + 1;
        						orientacion = 2;
        					}  
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                
                if(!PA){
        			switch(matriz[x-1][y]){
	      
        				case 1:
        					k = 3;
        					matriz[x][y]= 2;
        					x = x-1;
        					orientacion = 3;
        					break;
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x][y-1] != 1 && matriz[x+1][y] != 1 || PF && PD && PI ) {
        						k = 3;
        						matriz[x][y] = 3;
        						x = x - 1;
        						orientacion = 3;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                if(!PI){
        			switch(matriz[x][y-1]){

        				case 1:
        					k = 0;
        					matriz[x][y]= 2;
        					y = y - 1;
        					orientacion = 0;
        					break;
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x-1][y] != 1 && matriz[x+1][y] != 1 || PF && PD && PA) {
        						k = 0;
        						matriz[x][y] = 3;
        						y = y - 1;
        						orientacion = 0;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
            
        	case 2: //Orientacion a la Atras
        		
        		if(!PF){
        			switch(matriz[x][y+1]){        				
        				case 1:
        					k = 2;
        					matriz[x][y]= 2;
        					y = y+1;
        					orientacion = 2;
        					break;
        				case 2:
        					if(matriz[x][y-1] != 1 && matriz[x-1][y] != 1 && matriz[x+1][y] != 1 || PD && PA && PI) {
        						k = 2;
        						matriz[x][y] = 3;
        						y = y + 1;
        						orientacion = 2;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                if(!PD){
        			switch(matriz[x-1][y]){        				
        				case 1:
        					k = 3;
        					matriz[x][y]= 2;
        					x = x-1;
        					orientacion = 3;
        					break;
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x][y-1] != 1 && matriz[x+1][y] != 1 || PF && PA && PI) {
        						k = 3;
        						matriz[x][y] = 3;
        						x = x - 1;
        						orientacion = 3;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                
                if(!PA){
        			switch(matriz[x][y-1]){        				
        				case 1:
        					k = 0;
        					matriz[x][y]= 2;
        					y = y-1;
        					orientacion = 0;
        					break;
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x-1][y] != 1 && matriz[x+1][y] != 1 || PF && PD && PI) {
        						k = 0;
        						matriz[x][y] = 3;
        						y = y - 1;
        						orientacion = 0;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                if(!PI){
        			switch(matriz[x+1][y]){        				
        				case 1:
        					k = 1;
        					matriz[x][y]= 2;
        					x = x+1;
        					orientacion = 1;
        					break;
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x-1][y] != 1 && matriz[x][y-1] != 1 || PF && PD && PA) {
        						k = 1;
        						matriz[x][y] = 3;
        						x = x + 1;
        						orientacion = 1;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                
        	case 3: //Orientacion a la Izquierda
        		
        		if(!PF){
        			switch(matriz[x-1][y]){        				
        				case 1:
        					k = 3;
        					matriz[x][y]= 2;
        					x = x-1;
        					orientacion = 3;
        					break;
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x][y-1] != 1 && matriz[x+1][y] != 1 || PD && PA && PI) {
        						k = 3;
        						matriz[x][y] = 3;
        						x = x - 1;
        						orientacion = 3;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                if(!PD){
        			switch(matriz[x][y-1]){        				
        				case 1:
        					k = 0;
        					matriz[x][y]= 2;
        					y = y-1;
        					orientacion = 0;
        					break;
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x-1][y] != 1 && matriz[x+1][y] != 1 || PF && PA && PI) {
        						k = 0;
        						matriz[x][y] = 3;
        						y = y - 1;
        						orientacion = 0;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                                
                if(!PA){
        			switch(matriz[x+1][y]){
        				case 1:
        					k = 1;
        					matriz[x][y]= 2;
        					x = x+1;
        					orientacion = 1;
        					break;
        				case 2:
        					if(matriz[x][y+1] != 1 && matriz[x-1][y] != 1 && matriz[x][y-1] != 1 || PF && PD && PI) {
        						k = 1;
        						matriz[x][y] = 3;
        						x = x + 1;
        						orientacion = 1;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                if(!PI){
        			switch(matriz[x][y+1]){        				
        				case 1:
        					k = 2;
        					matriz[x][y]= 2;
        					y = y+1;
        					orientacion = 2;
        					break;
        				case 2:
        					if(matriz[x][y-1] != 1 && matriz[x-1][y] != 1 && matriz[x+1][y] != 1 || PF && PD && PA) {
        						k = 2;
        						matriz[x][y] = 3;
        						y = y + 1;
        						orientacion = 2;
        					}        					
        					break;
        				case 3:
        					break;
        			}
        			break;
                }
                
        }
        

        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println();            
        }
        System.out.println("___________________");
        return k;
    }
    
}
