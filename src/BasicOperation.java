/**
 * Created by Administrator on 2016/10/26.
 */
public enum BasicOperation implements IOperation {
    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    };
    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol=symbol;
    }

    public String getSymbol(){
        return symbol;
    }
}
