import java.util.Scanner;

public class My_App_TT {

    final String PLAY_X = "x";
    final String PLAY_O = "o";
    final String PLAY_C = ".";
    Scanner inp = new Scanner(System.in);

    String[][] table = new String[3][3];

    public static void main(String[] args) {
        new My_App_TT().game();
    }

    void game() {
        init_table();
        System.out.println("Игра начинается");
        print_table();
        while (true){
            player_app();
            print_table();
            if (check_win(PLAY_X)){
                System.out.println("Поздравляю, Вы победили!");
                break;
            }
            if (isTableFull()){
                System.out.println("У вас ничья!");
                break;
            }
            comp_app();
            System.out.println("Ход компьютера");
            print_table();
            if (check_win(PLAY_O)){
                System.out.println("Победил компьюьтер");
                break;
            }
            if (isTableFull()){
                System.out.println("У вас ничья!");
                break;
            }
        }
    }

    void init_table() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = PLAY_C;
            }
        }
    }

    void print_table() {
        for (int k = 0; k < 3; k++) {
            for (int m = 0; m < 3; m++) {
                System.out.print(table[k][m] + " ");
            }
            System.out.println();
        }
    }

    void player_app() {
        System.out.println("Введите координаты хода (х и у)");
        int fl = 0;
        while (fl == 0) {
            int x = inp.nextInt();
            int y = inp.nextInt();
            if ((x >= 1) & (x <= 3) & (y >= 1) & (y <= 3)) {
                fl = 1;
                y = y - 3;
                x = x - 1;
                if (y<0){
                    y = y*(-1);
                }
                table[y][x] = PLAY_X;
            }
            if ((x > 3) || (x < 0) || (y > 3) || (y < 0)) {
                System.out.println("Ошибка ввода координат; Обратите внимание, что координаты необходимо выбирать в диапозоне [1;3]");
                System.out.println("Повторите ввод ещё раз");
            }
        }
    }

    void comp_app() {
        int flcomp = 0;
        while (flcomp == 0) {
            int xcomp = (int) (Math.random() * 3);
            int ycomp = (int) (Math.random() * 3);
            if ((table[ycomp][xcomp] == PLAY_C)) {
                table[ycomp][xcomp] = "o";
                flcomp = 1;
            }
        }
    }

    boolean isTableFull() {
        for (int q = 0; q < 3; q++)
            for (int q1 = 0; q1 < 3; q1++)
                if (table[q1][q] == PLAY_C)
                    return false;
        return true;
    }

    boolean check_win(String dot){
        for (int i = 0; i < 3; i++){
            if (((table[i][0] == dot) && (table[i][1] == dot) && (table[i][2] == dot)) ||
            ((table[0][i] == dot) && (table[1][i] == dot) && (table[2][i] == dot)))
                    return true;
            if (((table[0][0] == dot) && (table[1][1] == dot) && (table[2][2] == dot)) ||
                    ((table[0][2] == dot) && (table[1][1] == dot) && (table[2][0] == dot)))
                return true;
        }
        return false;
    }
}