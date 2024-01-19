package TicTacToe;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TicTacToeUI extends JFrame{
    private JPanel mainPNL;
    private JPanel B1;
    private JPanel B2;
    private JPanel B3;
    private JPanel B4;
    private JPanel B5;
    private JPanel B6;
    private JPanel B7;
    private JPanel B8;
    private JPanel B9;
    private JLabel OptionLBL;
    private JButton XBTN;
    private JButton OBTN;
    private JLabel BL1;
    private JLabel BL2;
    private JLabel BL3;
    private JLabel BL4;
    private JLabel BL5;
    private JLabel BL6;
    private JLabel BL7;
    private JLabel BL8;
    private JLabel BL9;
    private JPanel resultPNL;
    private JLabel resultLBL;
    private JButton resetBTN;
    private int opt;
    String choice;
    private boolean btnSelected = false;
    public TicTacToeUI() {
        add(mainPNL);
        setUI();

        XBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                opt = 0;
                choice = "You selected X";
                resultLBL.setText(choice);
                btnSelected = true;
            }
        });
        OBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                opt = 1;
                choice = "You selected O";
                resultLBL.setText(choice);
                btnSelected = true;
            }
        });
        resetBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               resetGame();;
            }
        });
    }
    private void setUI(){
        setVisible(true);
        setSize(400,500);
        setTitle("TIc Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        setBoard(B1, BL1);
        setBoard(B2, BL2);
        setBoard(B3, BL3);
        setBoard(B4, BL4);
        setBoard(B5, BL5);
        setBoard(B6, BL6);
        setBoard(B7, BL7);
        setBoard(B8, BL8);
        setBoard(B9, BL9);
    }

    private void resetGame(){
        BL1.setText("");
        BL2.setText("");
        BL3.setText("");
        BL4.setText("");
        BL5.setText("");
        BL6.setText("");
        BL7.setText("");
        BL8.setText("");
        BL9.setText("");
        resultLBL.setText("");
        resultLBL.setText(choice);

        BL1.setEnabled(true);
        BL2.setEnabled(true);
        BL3.setEnabled(true);
        BL4.setEnabled(true);
        BL5.setEnabled(true);
        BL6.setEnabled(true);
        BL7.setEnabled(true);
        BL8.setEnabled(true);
        BL9.setEnabled(true);
    }

    private void setBoard(JPanel bPNL, JLabel bLBL){
        bPNL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!btnSelected) {
                    resultLBL.setText("Please select X or O before selecting cells.");
                    return;
                }

                if(bLBL.getText().equals("")){
                    if(opt == 0){
                     bLBL.setText("X");
                    }else{
                     bLBL.setText("O");
                    }

                    if(checkWins()){
                        resultLBL.setText("YOU WON! (" + choice + ")");
                        disableCells();
                    }else{
                        computer();
                    }
                }
            }
        });
    }

    private void computer() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(() -> {
            Random random = new Random();
            int emptyCell;

            do {
                emptyCell = random.nextInt(9) + 1;
            }while(!isCellEmpty(emptyCell));

            switch (emptyCell) {
                case 1:
                    if (BL1.getText().equals("")) {
                        if(opt == 0) {
                            BL1.setText("O");
                        }else{
                            BL1.setText("X");
                        }
                    }
                    break;

                case 2:
                    if(BL2.getText().equals("")){
                        if(opt == 0){
                            BL2.setText("O");
                        }else{
                            BL2.setText("X");
                        }
                    }
                    break;

                case 3:
                    if(BL3.getText().equals("")){
                        if(opt == 0){
                            BL3.setText("O");
                        }else{
                            BL3.setText("X");
                        }
                    }
                    break;

                case 4:
                    if(BL4.getText().equals("")){
                        if(opt == 0){
                            BL4.setText("O");
                        }else{
                            BL4.setText("X");
                        }
                    }
                    break;

                case 5:
                    if(BL5.getText().equals("")){
                        if(opt == 0){
                            BL5.setText("O");
                        }else{
                            BL5.setText("X");
                        }
                    }
                    break;

                case 6:
                    if(BL6.getText().equals("")){
                        if(opt == 0){
                            BL6.setText("O");
                        }else{
                            BL6.setText("X");
                        }
                    }
                    break;

                case 7:
                    if(BL7.getText().equals("")){
                        if(opt == 0){
                            BL7.setText("O");
                        }else{
                            BL7.setText("X");
                        }
                    }
                    break;

                case 8:
                    if(BL8.getText().equals("")){
                        if(opt == 0){
                            BL8.setText("O");
                        }else{
                            BL8.setText("X");
                        }
                    }
                    break;

                case 9:
                    if(BL9.getText().equals("")){
                        if(opt == 0){
                            BL9.setText("O");
                        }else{
                            BL9.setText("X");
                        }
                    }
                    break;
            }
            if(checkWins()){
                resultLBL.setText("YOU LOST! (" + choice + ")");
                disableCells();
            }
            executor.shutdown();
        }, 500, TimeUnit.MILLISECONDS);
    }

    private boolean isCellEmpty(int cell) {
        switch (cell) {
            case 1:
                return BL1.getText().equals("");
            case 2:
                return BL2.getText().equals("");
            case 3:
                return BL3.getText().equals("");
            case 4:
                return BL4.getText().equals("");
            case 5:
                return BL5.getText().equals("");
            case 6:
                return BL6.getText().equals("");
            case 7:
                return BL7.getText().equals("");
            case 8:
                return BL8.getText().equals("");
            case 9:
                return BL9.getText().equals("");
            default:
                return true; // Return true for invalid cell numbers
        }
    }

    private String getCellValue(int cell){
        switch (cell){
            case 1:
                return BL1.getText();
            case 2:
                return BL2.getText();
            case 3:
                return BL3.getText();
            case 4:
                return BL4.getText();
            case 5:
                return BL5.getText();
            case 6:
                return BL6.getText();
            case 7:
                return BL7.getText();
            case 8:
                return BL8.getText();
            case 9:
                return BL9.getText();
            default:
                return "";
        }
    }

    private boolean isBoardFull() {
        return !BL1.getText().equals("") && !BL2.getText().equals("") && !BL3.getText().equals("") &&
                !BL4.getText().equals("") && !BL5.getText().equals("") && !BL6.getText().equals("") &&
                !BL7.getText().equals("") && !BL8.getText().equals("") && !BL9.getText().equals("");
    }

    private boolean checkEquals(int cell1, int cell2, int cell3) {
        return getCellValue(cell1).equals(getCellValue((cell2))) && getCellValue(cell2).equals(getCellValue(cell3)) && !getCellValue(cell1).equals("");
    }

    private boolean checkWins() {
        for(int i =1; i<=7; i+=3){
            if(checkEquals(i, i+1, i+2)){
                return true;
            }
        }

        for(int i =1; i<=3; i++){
            if(checkEquals(i, i+3, i+6)){
                return true;
            }
        }

        if(checkEquals(1,5,9) || checkEquals(3,5,7)){
            return true;
        }

        if(isBoardFull()){
            resultLBL.setText("It is a draw");
            disableCells();
            return true;
        }

        return false;
    }

    private void disableCells(){
        if(checkWins()){
            BL1.setEnabled(false);
            BL2.setEnabled(false);
            BL3.setEnabled(false);
            BL4.setEnabled(false);
            BL5.setEnabled(false);
            BL6.setEnabled(false);
            BL7.setEnabled(false);
            BL8.setEnabled(false);
            BL9.setEnabled(false);
        }

    }

    public static void main(String[] args) {
        TicTacToeUI game = new TicTacToeUI();
    }
}