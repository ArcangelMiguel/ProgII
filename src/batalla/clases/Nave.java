package batalla.clases;

/**
 * Created by Usuario1 on 19/08/2016.
 */
public class Nave {
    private Block dim1;
    private Block dim2;


    public Nave(Block dim1, Block dim2){

        this.dim1=dim1;
        this.dim2=dim2;
    }

    public Block getDim1() {
        return dim1;
    }

    public Block getDim2() {
        return dim2;
    }

    @Override
    public String toString() {
        return "("
                 + dim1 + ' '
                +dim2 +
                ')';
    }
}
