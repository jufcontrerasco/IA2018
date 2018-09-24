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
	private int orientacion = 0;  // Norte= 0, Oriente=1, Sur=2, Occidente=3
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
        switch(orientacion){
        	case 0: //Orientacion hacia al Frente
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
<<<<<<< HEAD
            
        	case 1: //Orientacion hacia a la Derecha
=======
                break;
        	case 1: //Orientacion a la Derecha
>>>>>>> 51189adbb18dd7cd011a6e901007e0d9b83a6778
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
<<<<<<< HEAD
                } 
        	case 2: //Orientacion hacia Atras
=======
        			break;
                }
                break;
        	case 2: //Orientacion a la Atras
>>>>>>> 51189adbb18dd7cd011a6e901007e0d9b83a6778
        		if(!PF){
        			matriz[x][y+1]= 0;
        			switch(matriz[x][y+1]){
        				case 0:
<<<<<<< HEAD
        					k = 2;
        					matriz[x][y]= 1;
        					y = y+1;
        				case 1:
        					if(PD && PA && PI){
        						matriz[x][y]=2;
        						y = y+1;
        					}
        				case 2:
        					break;
        			}
                }
                if(!PD){
                	matriz[x-1][y]= 0;
        			switch(matriz[x-1][y]){
        				case 0:
        					k = 3;
        					matriz[x][y]= 1;
        					x = x-1;
        					orientacion = 3;
        				case 1:
        					if(PF && PA && PI){
        						matriz[x][y]=2;
        						x = x-1;
        						orientacion = 3;
        					}
        				case 2:
        					break;
        			}
                }
                if(!PA){
                	matriz[x][y-1]= 0;
        			switch(matriz[x][y-1]){
        				case 0:
        					k = 0;
        					matriz[x][y]= 1;
        					y = y-1;
        					orientacion = 0;
        				case 1:
        					if(PF && PD && PI){
        						matriz[x][y]=2;
        						y = y-1;
        						orientacion = 0;
        					}
        				case 2:
        					break;
        			}
                }
                if(!PI){
                	matriz[x+1][y]= 0;
        			switch(matriz[x+1][y]){
        				case 0:
        					k = 1;
        					matriz[x][y]= 1;
        					x = x+1;
        					orientacion = 1;
        				case 1:
        					if(PF && PD && PA){
        						matriz[x][y]=2;
        						x = x+1;
        						orientacion = 1;
        					}
        				case 2:
        					break;
        			}
                }         		
        	case 3: //Orientacion hacia a la Izquierda
=======
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
>>>>>>> 51189adbb18dd7cd011a6e901007e0d9b83a6778
        		if(!PF){
        			matriz[x-1][y]= 0;
        			switch(matriz[x-1][y]){
        				case 0:
<<<<<<< HEAD
        					k = 3;
        					matriz[x][y]= 1;
        					x = x-1;
        				case 1:
        					if(PI && PD && PA){
        						matriz[x][y]=2;
        						x = x-1;
        					}
        				case 2:
        					break;
        			}
                }
                if(!PD){
                	matriz[x][y-1]= 0;
        			switch(matriz[x][y-1]){
        				case 0:
        					k = 0;
        					matriz[x][y]= 1;
        					y = y-1;
        					orientacion = 0;
        				case 1:
        					if(PI && PF && PA){
        						matriz[x][y]=2;
        						y = y-1;
        						orientacion = 0;
        					}
        				case 2:
        					break;
        			}
=======
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
>>>>>>> 51189adbb18dd7cd011a6e901007e0d9b83a6778
                }
                if(!PA){
                	matriz[x+1][y]= 0;
        			switch(matriz[x+1][y]){
        				case 0:
<<<<<<< HEAD
        					k = 1;
        					matriz[x][y]= 1;
        					x = x+1;
        					orientacion = 1;
        				case 1:
        					if(PI && PF && PA){
        						matriz[x][y]=2;
        						x = x+1;
        						orientacion = 1;
        					}
        				case 2:
        					break;
        			}
                }
                if(!PI){
                	matriz[x][y+1]= 0;
        			switch(matriz[x][y+1]){
        				case 0:
        					k = 2;
        					matriz[x][y]= 1;
        					y = y+1;
        					orientacion = 2;
        				case 1:
        					if(PI && PF && PA){
        						matriz[x][y]=2;
        						y = y+1;
        						orientacion = 2;
        					}
        				case 2:
        					break;
        			}
                } 
=======
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
>>>>>>> 51189adbb18dd7cd011a6e901007e0d9b83a6778
        }
        System.out.println(orientacion);
        return k;
    }
    
}
