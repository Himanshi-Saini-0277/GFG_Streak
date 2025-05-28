class Solution {
    public boolean ValidCorner(int mat[][]) {
        // Code here
        for (int i = 0; i < mat.length; i++) {
            List<Integer> rowOnes = new ArrayList<>();
            for (int j = 0; j < mat[0].length; j++) {
                
                if (mat[i][j] == 1) {
                    boolean onesFound = false;
                    
                    for (int k = i + 1; k < mat.length; k++) {
                        if (mat[k][j] == 1) {
                            onesFound = true;
                            for (int col: rowOnes) {
                                if (mat[k][col] == 1) return true;
                            }
                        }
                    }
                    
                    if (onesFound) rowOnes.add(j);
                }
            }
        }
        
        return false;
    }
}