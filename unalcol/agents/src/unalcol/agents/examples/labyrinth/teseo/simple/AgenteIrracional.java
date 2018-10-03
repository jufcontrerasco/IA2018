package unalcol.agents.examples.labyrinth.teseo.simple;

import unalcol.agents.simulate.util.SimpleLanguage;

/*
 * @author FelipeCC
 */


/*
 * eater1 = 289
 * eater2 = 216
 * segundo = 93
 */
public class AgenteIrracional extends SimpleTeseoAgentProgram {

	private int[][] matriz;
	private int or;
	private int x;
	private int y;
	private int pasos;
	private int paredes;

	public AgenteIrracional() {
		matriz = new int[31][31];
		x = 15;
		y = 15;
		matriz[x][y] = 2;
		pasos = 0;
	}

	public AgenteIrracional(SimpleLanguage _language) {
		super(_language);
	}

	public static void Percibir(boolean PF , boolean PD, boolean PA, boolean PI, int[][] matriz, int x, int y, int or) {
		System.out.println("Orientacion percepcion: "+or);
		
		switch (or) {		

		case 0: // Frente
			if (!PF && matriz[x][y - 1] == 0) {
				matriz[x][y - 1] = 1;
			}
			if (!PD && matriz[x + 1][y] == 0) {
				matriz[x + 1][y] = 1;
			}
			if (!PA && matriz[x][y + 1] == 0) {
				matriz[x][y + 1] = 1;
			}
			if (!PI && matriz[x - 1][y] == 0) {
				matriz[x - 1][y] = 1;
			}
			break;

		case 1: // Derecha
			if (!PF && matriz[x + 1][y] == 0) {
				matriz[x + 1][y] = 1;
			}
			if (!PD && matriz[x][y + 1] == 0) {
				matriz[x][y + 1] = 1;
			}
			if (!PA && matriz[x - 1][y] == 0) {
				matriz[x - 1][y] = 1;
			}
			if (!PI && matriz[x][y - 1] == 0) {
				matriz[x][y - 1] = 1;
			}
			break;

		case 2: // Atras
			if (!PF && matriz[x][y + 1] == 0) {
				matriz[x][y + 1] = 1;
			}
			if (!PD && matriz[x - 1][y] == 0) {
				matriz[x - 1][y] = 1;
			}
			if (!PA && matriz[x][y - 1] == 0) {
				matriz[x][y - 1] = 1;
			}
			if (!PI && matriz[x + 1][y] == 0) {
				matriz[x + 1][y] = 1;
			}
			break;

		case 3: // Izquierda
			if (!PF && matriz[x - 1][y] == 0) {
				matriz[x - 1][y] = 1;
			}
			if (!PD && matriz[x][y - 1] == 0) {
				matriz[x][y - 1] = 1;
			}
			if (!PA && matriz[x + 1][y] == 0) {
				matriz[x + 1][y] = 1;
			}
			if (!PI && matriz[x][y + 1] == 0) {
				matriz[x][y + 1] = 1;
			}
			break;

		}

	}

	@Override
	public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) {
		if (MT)return -1;		
		int k = 5;
		int cierres=0;
		Percibir(PF,PD, PA, PI, matriz, x, y, or);		
		System.out.println("Actuar");
		
		int a = PF ? 1:0; 		//Contar paredes
		int b = PD ? 1:0;
		int c = PA ? 1:0;
		int d = PI ? 1:0;
		paredes =a+b+c+d;
		
		//ACTUAR		
		System.out.println("Orientacion: "+or);				
		
		
				
		switch(or){	
		
		case 0: //Mirando al norte
			
			
			if(paredes < 2 && matriz[x][y+1] == 2 && !PD && matriz[x+1][y]==2 && !PA && PF){
				k = 3;
				or = 3;
				x = x-1;
				break;
			}
			
			if(PF &&  PD &&  PI && !PA){
				matriz[x][y]=3;
			}
		
		
			if(matriz[x][y+1]==3 && paredes >= 2){
				matriz[x][y] = 3;
			}
			
			//Cierres
			
			if(matriz[x][y-1] == 3 && !PF ){
				cierres+=1;
			}
			if(matriz[x][y+1] == 3 && !PA){
				cierres+=1;
			}
			if(matriz[x-1][y] == 3 && !PI){
				cierres+=1;
			}
			if(matriz[x+1][y] == 3 && !PD){
				cierres+=1;
			}
			if(cierres == 2 ){
				matriz[x][y] = 3;
			}
			

			if(matriz[x][y-1] == 1 && !PF){		
					k = 0;
					matriz[x][y-1] = 2;
					y = y - 1;		  
					break;
			}			
			
			if(matriz[x+1][y] == 1 && !PD){
				k = 1;
				matriz[x+1][y] = 2;
				x = x + 1;
				or = 1;
				break;									
			}	
			
			if(matriz[x-1][y] == 1 && !PI){
				k = 3;
				matriz[x-1][y] = 2;
				x = x - 1;
				or = 3;
				break;
			}			
			
			if(matriz[x][y+1] == 1 && !PA){ 
				k = 2;
				matriz[x][y+1] = 2;
				y = y + 1;
				or = 2;
				break;
			}	
			
			if(matriz[x][y-1] == 2 && !PF){
				if(matriz[x][y+1]!=1 || PA && matriz[x+1][y]!=1 || PD && matriz[x-1][y]!=1 || PI && !PF){
					k=0;
					y= y-1;
					break;
				}	
			}

			
			if(matriz[x+1][y] == 2 && !PD){
				if(matriz[x][y+1]!=1 || PA && matriz[x][y-1]!=1 || PF && matriz[x-1][y]!=1 || PI && !PD){
					k=1;
					x= x+1;
					or = 1;
					break;
				}
			}
			
			if(matriz[x-1][y] == 2 && !PI){
				if(matriz[x][y+1]!=1 || PA && matriz[x][y-1]!=1 || PF && matriz[x+1][y]!=1 || PD && !PI){
					k= 3;
					x= x-1;
					or = 3;
					System.out.println("Entro");
					break;
				}
			}
			
					
			if(matriz[x][y+1] == 2 && !PA){
				if(matriz[x][y-1]!=1 || PF && matriz[x+1][y]!=1 || PD && matriz[x-1][y]!=1 || PI && !PA){
					k=2;
					y= y+1;
					or = 2;
					break;
					
				}
			}
	
			
		case 1: //Mirando a la derecha

			if(PF &&  PD &&  PI && !PA){
				matriz[x][y]=3;
			}
			
			if(matriz[x-1][y]==3 && paredes >= 2){
				matriz[x][y] = 3;
			}
			
			//Cierres
			
			if(matriz[x][y-1] == 3 && !PI ){
				cierres+=1;
			}
			if(matriz[x][y+1] == 3 && !PD){
				cierres+=1;
			}
			if(matriz[x-1][y] == 3 && !PA){
				cierres+=1;
			}
			if(matriz[x+1][y] == 3 && !PF){
				cierres+=1;
			}
			if(cierres == 2 ){
				matriz[x][y] = 3;
			}
				
			if(matriz[x+1][y] == 1 && !PF){		
				k = 0;
				matriz[x+1][y] = 2;
				x= x+1;
				or = 1;
				break;
			}					
			
			if(matriz[x][y+1] == 1 && !PD){
				k = 1;
				matriz[x][y+1] = 2;
				y = y + 1;
				or = 2;
				break;
			}
			if(matriz[x][y-1] == 1 && !PI){
				k = 3;
				matriz[x][y-1] = 2;
				y = y - 1;
				or = 0;
				break;
			}					
			
			if(matriz[x-1][y] == 1 && !PA){ 
				k = 2;
				matriz[x-1][y] = 2;
				x = x - 1;
				or = 3;
				break;
			}

			if(matriz[x+1][y] == 2 && !PF){
				if(matriz[x][y+1]!=1 || PD && matriz[x][y-1]!=1 || PI && matriz[x-1][y]!=1 || PA && !PF){
					k=0;
					x= x+ 1;
					or = 1;
					break;
				}
			}			

			if(matriz[x][y+1] == 2 && !PD){
				if(matriz[x+1][y]!=1 || PF && matriz[x][y-1]!=1 || PI && matriz[x-1][y]!=1 || PA && !PD){
					k=1;
					y= y+1;
					or = 2;
					break;
				}
			}
			
			if(matriz[x][y-1] == 2 && !PI){
				if(matriz[x][y+1]!=1 || PD && matriz[x-1][y]!=1 || PA && matriz[x+1][y]!=1 || PF && !PI){
					k= 3;
					y= y-1;
					or = 0;
					break;
				}
			}			
			
			if(matriz[x-1][y] == 2 && !PA){
				if(matriz[x][y-1]!=1 || PI && matriz[x+1][y]!=1 || PF && matriz[x][y+1]!=1 || PD && !PA){
					k=2;
					x= x-1;
					or = 3;
					break;
				}
			}
			
			
		case 2: //Mirando al sur
			
			if(PF &&  PD &&  PI && !PA){
				matriz[x][y]= 3;
			}
			
			if(paredes < 2 && matriz[x][y-1] == 2 && !PD && matriz[x-1][y]==2 && !PA && PF && matriz[x-1][y-1]==2){
				k = 3;
				or = 1;
				x = x+1;
				break;
			}			
			
			if(matriz[x][y-1]==3 && paredes >= 2){
				matriz[x][y] = 3;
			}	
			
			//Cierres
			
			if(matriz[x][y-1] == 3 && !PA ){
				cierres+=1;
			}
			if(matriz[x][y+1] == 3 && !PF){
				cierres+=1;
			}
			if(matriz[x-1][y] == 3 && !PD){
				cierres+=1;
			}
			if(matriz[x+1][y] == 3 && !PI){
				cierres+=1;
			}
			
			if(cierres == 2 ){
				matriz[x][y] = 3;
			}
			
			if(matriz[x][y+1] == 1 && !PF){		
				k = 0;
				matriz[x][y+1] = 2;
				y = y + 1;	
				or = 2;
				break;
			
			}				
			
			if(matriz[x-1][y] == 1 && !PD){
				k = 1;
				matriz[x-1][y] = 2;
				x = x - 1;
				or = 3;
				break;
			}
			if(matriz[x+1][y] == 1 && !PI){
				k = 3;
				matriz[x+1][y] = 2;
				x = x + 1;
				or = 1;
				break;
			}			
			
			if(matriz[x][y-1] == 1 && !PA){ 
				k = 2;
				matriz[x][y-1] = 2;
				y = y - 1;
				or = 0;
				break;
			}
			
			if(matriz[x][y+1] == 2 && !PF){
				if(matriz[x][y-1]!=1 || PA && matriz[x+1][y]!=1 || PI && matriz[x-1][y]!=1 || PD && !PF){
					k=0;
					y= y+1;
					or = 2;
					break;
				}
			}	
					
			if(matriz[x-1][y] == 2 && !PD){
				if(matriz[x][y+1]!=1 || PF && matriz[x][y-1]!=1 || PA  && matriz[x+1][y]!=1 || PI && !PD){
					System.out.println("Aqui no");
					k=1;
					x= x-1;
					or = 3;
					break;
				}
			}
			
			if(matriz[x+1][y] == 2 && !PI){
				if(matriz[x][y+1]!=1 || PF && matriz[x][y-1]!=1 || PA && matriz[x-1][y]!=1 || PD && !PI){
					k= 3;
					x= x+1;
					or = 1;
					break;
				}

			}
			
			if(matriz[x][y-1] == 2 && !PA){
				if(matriz[x][y+1]!=1 || PF && matriz[x+1][y]!=1 || PI && matriz[x-1][y]!=1 || PD && !PA){
					System.out.println("Aqui");
					k=2;
					y= y-1;
					or = 0;
					break;
				}
			}			
			
		case 3: //Mirando a la izquierda
			
			//Frente
			if(PF &&  PD &&  PI && !PA){
				matriz[x][y]=3;
			}
			
			if(matriz[x+1][y]==3 && paredes >= 2){
				matriz[x][y] = 3;
			}	
			
			//Cierres
			
			if(matriz[x][y-1] == 3 && !PD ){
				cierres+=1;
			}
			if(matriz[x][y+1] == 3 && !PI){
				cierres+=1;
			}
			if(matriz[x-1][y] == 3 && !PF){
				cierres+=1;
			}
			if(matriz[x+1][y] == 3 && !PA){
				cierres+=1;
			}
			
			if(cierres == 2 ){
				matriz[x][y] = 3;
			}

			if(matriz[x-1][y] == 1 && !PF){		
				k = 0;
				matriz[x-1][y] = 2;
				x= x-1;
				or = 3;
				break;
			}				
			
			if(matriz[x][y-1] == 1 && !PD){
				k = 1;
				matriz[x][y-1] = 2;
				y = y - 1;
				or = 0;
				break;
			}			

			if(matriz[x][y+1] == 1 && !PI){
				k = 3;
				matriz[x][y+1] = 2;
				y = y + 1;
				or = 2;
				break;
			}				
			
			if(matriz[x+1][y] == 1 && !PA){ 
				k = 2;
				matriz[x+1][y] = 2;
				x = x + 1;
				or = 1;
				break;
			}
			
		
			if(matriz[x-1][y] == 2 && !PF){
				if(matriz[x][y+1]!=1 || PD && matriz[x][y-1]!=1 || PI && matriz[x+1][y]!=1 || PA && !PF){
					k=0;
					x=x- 1;
					or = 3;
					break;
				}
			}
						
			
			if(matriz[x][y-1] == 2 && !PD){
				if(matriz[x+1][y]!=1 || PA && matriz[x][y+1]!=1 || PI && matriz[x-1][y]!=1 || PF && !PD){
					k=1;
					y= y-1;
					or = 0;
					break;
				}
			}			
			
			
			if(matriz[x][y+1] == 2 && !PI){
				if(matriz[x][y-1]!=1 || PD && matriz[x-1][y]!=1 || PF && matriz[x+1][y]!=1 || PA && !PI){
					k= 3;
					y= y+1;
					or = 2;
					break;
				}
			}			
			
			if(matriz[x+1][y] == 2 && !PA){
				if(matriz[x][y-1]!=1 || PD && matriz[x-1][y]!=1 || PF && matriz[x][y+1]!=1 || PI && !PA){
					k=2;
					x= x+1;
					or = 1;
					break;
				}
			}		
		
		}
				

		
        System.out.println("Movimiento:"+k);
        System.out.println("Cambio a Posicion: "+(x-15)+" "+(y-15));
		
		for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println(); 
        }        
        System.out.println("_______________________\n Nueva Interacion");
		
        pasos +=1;
        System.out.println("Numero de pasos: "+pasos);
        
         
		return k;		
	}
}