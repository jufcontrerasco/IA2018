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
public class Israel  extends SimpleTeseoAgentProgram {
    private int[][] matrizRecorrida;
    private int x;
    private int y;
    private int aux=0;
    private int pasos = 0;


    public Israel() {
        matrizRecorrida = new int[21][21];
        x = 2;
        y = 2;
        matrizRecorrida[x][y]=1;
    }

    public Israel(   SimpleLanguage _language  ) {
        super(_language);

    }


    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) {
        if (MT) return -1;

        int a1 = PF ? 1 : 0;
        int a2 = PD ? 1 : 0;
        int a3 = PA ? 1 : 0;
        int a4 = PI ? 1 : 0;
        int paredes = a1 + a2 + a3 + a4;
        int vacios = 0;
        int visitados_mal=0;
        int visitados_bien=0;

        int k=0;
        boolean flag = true;
        switch (aux){
            case 0:
                if(!PI){
                    switch (matrizRecorrida[x][y-1]){
                        case 0:
                            vacios += 1;
                            k=3;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=3;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PA){
                    switch (matrizRecorrida[x+1][y]){
                        case 0:
                            vacios += 1;
                            k=2;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=2;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PD){
                    switch (matrizRecorrida[x][y+1]){
                        case 0:
                            vacios += 1;
                            k=1;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=1;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PF){
                    switch (matrizRecorrida[x-1][y]){
                        case 0:
                            vacios += 1;
                            k=0;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=0;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
            break;
            case 1:
                if(!PI){
                    switch (matrizRecorrida[x-1][y]){
                        case 0:
                            vacios += 1;
                            k=3;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=3;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PA){
                    switch (matrizRecorrida[x][y-1]){
                        case 0:
                            vacios += 1;
                            k=2;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=2;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                    }
                }
                if(!PD){
                    switch (matrizRecorrida[x+1][y]){
                        case 0:
                            vacios += 1;
                            k=1;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=1;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PF){
                    switch (matrizRecorrida[x][y+1]){
                        case 0:
                            vacios += 1;
                            k=0;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=0;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
            break;
            case 2:
                if(!PI){
                    switch (matrizRecorrida[x][y+1]){
                        case 0:
                            vacios += 1;
                            k=3;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=3;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PA){
                    switch (matrizRecorrida[x-1][y]){
                        case 0:
                            vacios += 1;
                            k=2;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=2;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PD){
                    switch (matrizRecorrida[x][y-1]){
                        case 0:
                            vacios += 1;
                            k=1;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=1;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PF){
                    switch (matrizRecorrida[x+1][y]){
                        case 0:
                            vacios += 1;
                            k=0;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=0;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
            break;
            case 3:
                if(!PI){
                    switch (matrizRecorrida[x+1][y]){
                        case 0:
                            vacios += 1;
                            k=3;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=3;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PA){
                    switch (matrizRecorrida[x][y+1]){
                        case 0:
                            vacios += 1;
                            k=2;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=2;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PD){
                    switch (matrizRecorrida[x-1][y]){
                        case 0:
                            vacios += 1;
                            k=1;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=1;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                if(!PF){
                    switch (matrizRecorrida[x][y-1]){
                        case 0:
                            vacios += 1;
                            k=0;
                            flag=false;
                            break;
                        case 1:
                            visitados_mal +=1;
                            if(flag){
                                k=0;
                            }
                            break;
                        case 2:
                            visitados_bien +=1;
                            break;
                    }
                }
                break;
        }
        if(vacios != 0) {
            if (vacios >= 2) {
                matrizRecorrida[x][y] = 1;
            } else {
                if (paredes + visitados_bien == 3) {
                    System.out.println("opcion 1");
                    matrizRecorrida[x][y] = 2;
                } else {
                    matrizRecorrida[x][y] = 1;
                }
            }
        }else if (paredes + visitados_bien == 4) {
            //codigo en caso de quedar encerrado
            if(!PI){
                k=3;
            }else if(!PF){
                k=0;
            }else if(!PD){
                k=1;
            }else{
                k=2;
            }
            System.out.println("hubo algun error; no hay movimientos posibles");
            System.out.printf("pos x > %d , y > %d, vacios - %d , bien - %d , mal - %d , paredes - %d", x,y,vacios,visitados_bien,visitados_mal,paredes);
            matrizRecorrida[x][y] = 2;
        }else if(vacios == 0){
            System.out.println("opcion 2");
            matrizRecorrida[x][y] = 2;
        }
        System.out.printf("pos x > %d , y > %d, vacios - %d , bien - %d , mal - %d , paredes - %d", x,y,vacios,visitados_bien,visitados_mal,paredes);
        System.out.println("--");

        for (int i = 0; i < matrizRecorrida.length; i++) {
            for (int j = 0; j < matrizRecorrida.length; j++) {
                System.out.print(matrizRecorrida[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        aux = (aux+k)%4;
        switch (aux){
            case 0:
                x = x-1;
                break;
            case 1:
                y = y+1;
                break;
            case 2:
                x = x+1;
                break;
            default:
                y = y-1;
                break;
        }
        pasos +=1;
        System.out.println("Numero de pasos: "+pasos);
        return k;
    }
}