public class SpiralMatrixSolution {

    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix==null){

            return null;

        }

        

        List<Integer> list=new LinkedList();

        

        if(matrix.length==0){

            return list;

        }

        



        

        int columnSize=matrix[0].length;

        int rowSize=matrix.length;

        

        int[][] matrixMark =new int[rowSize][columnSize];

        

        for(int i=0; i<rowSize; i++){

            for(int j=0; j<columnSize;j++){

                matrixMark[i][j]=0;

            }

        }

        

        int rowGo=0;

        int columnGo=1;

        int[] switcher= {1,1,-1,-1};

        int counter=0;

        

        int rowIndex=0;

        int columnIndex=0;

        

        

        while(isInside(rowIndex, columnIndex, rowSize, columnSize) && matrixMark[rowIndex][columnIndex]!=1){

            list.add(matrix[rowIndex][columnIndex]);

            matrixMark[rowIndex][columnIndex]=1;



            if(!(isInside(rowIndex+rowGo*switcher[counter%4], columnIndex+columnGo*switcher[counter%4], rowSize, columnSize)&& matrixMark[rowIndex+rowGo*switcher[counter%4]][columnIndex+columnGo*switcher[counter%4]]!=1)){

                int temp=rowGo;

                rowGo=columnGo;

                columnGo=temp;

                counter++;

            }

            rowIndex=rowIndex+rowGo*switcher[counter%4];

            columnIndex=columnIndex+columnGo*switcher[counter%4];

        }

        

        

        return list;

        

    }

    

    

    boolean isInside(int rowIndex, int columnIndex, int rowSize, int columnSize){

        if(rowIndex<rowSize && rowIndex>=0 && columnIndex<columnSize && columnIndex>=0){

            return true;    

        }else{

            return false;

        }

    }





}
