package implemica.TwoTask;


/**
 * Created 22.11.2024.
 */
public class City {

    private int[][] Cost;

    /* Argument is the number of vertices in the graph */
    public City(int vertices){
        Cost = new int [vertices][vertices];
    }
    /* Set the weight between the neighbors */
    public void setEdge (int i, int j, int weight){
        Cost [i][j] = weight;
    }
    public int getCost(int i , int j){

        if (i==j){
            return 0;
        }
        if (Cost[i][j]==0){
            return 10001;
        }
        return Cost[i][j];
    }

    /*Find index of min element*/
    protected int minCost(Integer[] result, boolean[] visited){
        int best =-1;
        for (int i=0; i<Cost.length; i++){
            if (!visited[i]&&((best<0)||(result[i] < result[best]))) {
                best =i;
            }
        }
        return best;
    }

    /*Find min distance between two cities*/
    public Integer[] distancesFrom (int source){
        Integer[] result = new Integer[Cost.length];
        java.util.Arrays.fill(result,10001);// Set tops mark
        result [source]=source;//Assign 1st top mark equal to "source", because this vertex
        boolean []visited = new boolean [Cost.length];// visit the city
        for (int i =0; i<Cost.length;i++){
            int City = minCost(result, visited);// Select the top of which has a minimum mark
            visited [City]=true;// Note selected vertex visited
            for (int j =0; j<Cost.length;j++){
                result [j] = Math.min(result[j], result[City]+getCost(City,j));// Write the smallest path from one vertex to another
            }
        }
        return result;
    }
}
