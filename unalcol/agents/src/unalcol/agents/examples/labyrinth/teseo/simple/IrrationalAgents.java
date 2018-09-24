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
	private int x = 15;
	private int y = 15;
	public IrrationalAgents() {}
    
    public IrrationalAgents(   SimpleLanguage _language  ) {
  	  super(_language);
    }

    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) {
        if (MT) return -1;
        
        int k = 0;
        matriz = new int [31][31];
        orientacion = 0; // Norte= 0, Oriente=1, Sur=2, Occidente=3
        switch(orientacion){
        	case 0: //Al Frente
        		if(!PF){
        			matriz[x][y-1]= 0;
        			switch(matriz[x][y-1]){
        				case 0:
        					k = 0;
        					matriz[x][y]= 1;
        					y = y-1;
        					orientacion = 0;
        					break;
        				case 1:
        					if(PD && PA && PI){
        						matriz[x][y]=2;
        						y = y-1;
        						orientacion = 0;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PD){
                	matriz[x+1][y]= 0;
                	switch(matriz[x+1][y]){
	    				case 0:
	    					k = 1;
	    					matriz[x][y]= 1;
	    					x = x+1;
	    					orientacion = 1;
	    					break;
	    				case 1:
	    					if(PF && PA && PI){
	    						matriz[x][y]=2;
	    						x = x+1;
	    						orientacion = 1;
	    					}
	    					break;
	    				case 2:
	    					break;
	    			}
                	break;
                }
                if(!PA){
                	matriz[x][y+1]= 0;
                	switch(matriz[x][y+1]){
	    				case 0:
	    					k = 2;
	    					matriz[x][y]= 1;
	    					y = y+1;
	    					orientacion = 2;
	    					break;
	    				case 1:
	    					if(PF && PD && PI){
	    						matriz[x][y]=2;
	    						y = y+1;
	    						orientacion = 2;
	    					}
	    					break;
	    				case 2:
	    					break;
	    			}
                	break;
                }
                if(!PI){
                	matriz[x-1][y]= 0;
                	switch(matriz[x-1][y]){
	    				case 0:
	    					k = 3;
	    					matriz[x][y]= 1;
	    					x = x-1;
	    					orientacion = 3;
	    					break;
	    				case 1:
	    					if(PF && PD && PA){
	    						matriz[x][y]=2;
	    						x = x-1;
	    						orientacion = 3;
	    					}
	    					break;
	    				case 2:
	    					break;
	    			}
                	break;
                }
                break;
        	case 1: //Orientacion a la Derecha
        		if(!PF){
        			matriz[x+1][y]= 0;
        			switch(matriz[x+1][y]){
        				case 0:
        					k = 0;
        					matriz[x][y]= 1;
        					x = x+1;
        					break;
        				case 1:
        					if(PD && PA && PI){
        						matriz[x][y]=2;
        						x = x+1;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PD){
                	matriz[x][y+1]= 0;
        			switch(matriz[x][y+1]){
        				case 0:
        					k = 2;
        					matriz[x][y]= 1;
        					y = y+1;
        					orientacion = 2;
        					break;
        				case 1:
        					if(PF && PA && PI){
        						matriz[x][y]=2;
        						y = y+1;
        						orientacion = 2;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PA){
                	matriz[x-1][y]= 0;
        			switch(matriz[x-1][y]){
        				case 0:
        					k = 3;
        					matriz[x][y]= 1;
        					x = x-1;
        					orientacion = 3;
        					break;
        				case 1:
        					if(PF && PD && PI){
        						matriz[x][y]=2;
        						x = x-1;
        						orientacion = 3;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PI){
                	matriz[x][y+1]= 0;
        			switch(matriz[x][y+1]){
        				case 0:
        					k = 0;
        					matriz[x][y]= 1;
        					y = y-1;
        					orientacion = 0;
        					break;
        				case 1:
        					if(PF && PD && PA){
        						matriz[x][y]=2;
        						y = y-1;
        						orientacion = 0;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                break;
        	case 2: //Orientacion a la Atras
        		if(!PF){
        			matriz[x][y+1]= 0;
        			switch(matriz[x][y+1]){
        				case 0:
        					k = 0;
        					matriz[x][y]= 1;
        					x = x+1;
        					break;
        				case 1:
        					if(PD && PA && PI){
        						matriz[x][y]=2;
        						x = x+1;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PD){
                	matriz[x][y+1]= 0;
        			switch(matriz[x][y+1]){
        				case 0:
        					k = 2;
        					matriz[x][y]= 1;
        					y = y+1;
        					orientacion = 2;
        					break;
        				case 1:
        					if(PF && PA && PI){
        						matriz[x][y]=2;
        						y = y+1;
        						orientacion = 2;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PA){
                	matriz[x-1][y]= 0;
        			switch(matriz[x-1][y]){
        				case 0:
        					k = 3;
        					matriz[x][y]= 1;
        					x = x-1;
        					orientacion = 3;
        					break;
        				case 1:
        					if(PF && PD && PI){
        						matriz[x][y]=2;
        						x = x-1;
        						orientacion = 3;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PI){
                	matriz[x][y+1]= 0;
        			switch(matriz[x][y+1]){
        				case 0:
        					k = 0;
        					matriz[x][y]= 1;
        					y = y-1;
        					orientacion = 0;
        					break;
        				case 1:
        					if(PF && PD && PA){
        						matriz[x][y]=2;
        						y = y-1;
        						orientacion = 0;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                break;
        	case 3: //Orientacion a la Izquierda
        		if(!PF){
        			matriz[x-1][y]= 0;
        			switch(matriz[x-1][y]){
        				case 0:
        					k = 0;
        					matriz[x][y]= 1;
        					x = x-1;
        					break;
        				case 1:
        					if(PD && PA && PI){
        						matriz[x][y]=2;
        						x = x-1;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PD){
                	matriz[x][y+1]= 0;
        			switch(matriz[x][y+1]){
        				case 0:
        					k = 2;
        					matriz[x][y]= 1;
        					y = y+1;
        					orientacion = 2;
        					break;
        				case 1:
        					if(PF && PA && PI){
        						matriz[x][y]=2;
        						y = y+1;
        						orientacion = 2;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PA){
                	matriz[x+1][y]= 0;
        			switch(matriz[x+1][y]){
        				case 0:
        					k = 3;
        					matriz[x][y]= 1;
        					x = x+1;
        					orientacion = 3;
        					break;
        				case 1:
        					if(PF && PD && PI){
        						matriz[x][y]=2;
        						x = x-1;
        						orientacion = 3;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                if(!PI){
                	matriz[x][y-1]= 0;
        			switch(matriz[x][y-1]){
        				case 0:
        					k = 3;
        					matriz[x][y]= 1;
        					y = y-1;
        					orientacion = 0;
        					break;
        				case 1:
        					if(PF && PD && PA){
        						matriz[x][y]=2;
        						y = y-1;
        						orientacion = 0;
        					}
        					break;
        				case 2:
        					break;
        			}
        			break;
                }
                break;
        }
        return k;
    }
    
}
