package Model.Player;

import Model.Board.Board;
import Model.Ship.Ship;
import View.GameView;
import View.GameViewImp;

import java.util.ArrayList;
import java.util.Random;

public class VirtualPlayer extends Player{

    public VirtualPlayer() {
        this.playerType = 2;
        this.playerName = "Computer";
    }


}
