package basics.other;

public class NoughtsAndCrosses {

    private String[][] area;
    private int step = 0;

    public NoughtsAndCrosses () {
        area = new String[3][3];
    }

    public void player(String first) {

        while (true) {
            if (first.equals("X")) {
                put("X");
                if (checkWinner("X")) {
                    System.out.println();
                    System.out.println("Xs win!");
                    break;
                }
                else if (step>=9) break;
                else {
                    put("O");
                    if (checkWinner("O")) {
                        System.out.println();
                        System.out.println("Os win!");
                        break;
                    }
                }
            }
        }
    }

    private void put (String s) {

        int x = generate();
        int y = generate();

        if (area[x][y]==null) {
            area[x][y] = s;
            step++;
            System.out.println("x="+x+" y="+y+" value: "+area[x][y]+" steps: "+step);
        }
        else put(s);

//        return false;
    }

    private int generate () {

        int i = (int)(Math.random()*10);

        if (i>2) return generate();
        else return i;

    }

    private boolean checkWinner (String s) {

        if (checkRows(s)) return true;
        else if (checkColumns(s))  return true;
        else if (checkDiagonals(s)) return true;

        return false;
    }

    private boolean checkDiagonals (String s) {

        if (area[0][0]!=null && area[1][1]!=null && area[2][2]!=null)
            if (area[0][0].equals(s) && area[1][1].equals(s) && area[2][2].equals(s))
                return true;
        if (area[0][2]!=null && area[1][1]!=null && area[2][0]!=null)
            if (area[0][2].equals(s) && area[1][1].equals(s) && area[2][0].equals(s))
                return true;
        return false;
    }


    public boolean checkRows (String s) {
        for (int i = 0 ; i < area.length ; i++) {
            int flag = 0;
            for (int j = 0 ; j<area[i].length; j++){
                if (area[i][j]!=null&&area[i][j].equals(s)) flag++;
                if (flag==3) return true;
            }
        }
        return false;
    }

    public boolean checkColumns (String s) {
        for (int i = 0 ; i < area.length ; i++) {
            int flag = 0;
            for (int j = 0 ; j<area[i].length; j++){
                if (area[j][i]!=null&&area[j][i].equals(s)) flag++;
                if (flag==3) return true;
            }
        }
        return false;
    }

    public void printResult () {
        for (String arr[] : area) {
            for (String str : arr) {
                if (str!= null) System.out.print(str+" ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        NoughtsAndCrosses first = new NoughtsAndCrosses();

        first.player("X");
        System.out.println();
        first.printResult();


    }
}