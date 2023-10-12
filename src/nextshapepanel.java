import java.awt.Color;

public class nextshapepanel {

    public void setcolorandshape(int shapex[],int shapey[],Color c,int shape,gamepanel gp) {

        System.out.println("shape : "+shape);
        System.out.println("color: "+c);


        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
               gp.allcolornextshape[i][j]=Color.black;
            }
        }

        for(int i = 0; i < 4; i++){

            System.out.print(shapex[i]);
            System.out.println(shapey[i]);

            gp.allcolornextshape[shapey[i]][shapex[i]-3]=c;

        }
        gp.repaintnext=true;

    }
}
