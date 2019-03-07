package edu.gatech.cs2340.spacetrader.model;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.spacetrader.entity.Planet;
import edu.gatech.cs2340.spacetrader.entity.Player;
import edu.gatech.cs2340.spacetrader.entity.Ship;
import edu.gatech.cs2340.spacetrader.entity.Universe;
import edu.gatech.cs2340.spacetrader.entity.tradegoods.TradeGood;

public class Repository {

    private Ship myShip;

    private Player myPlayer;

    private Universe myUniverse;

    /**
     * constructor for repository
     */
    public Repository() {
        myPlayer = new Player();
        myShip = new Ship();
    }

    /**
     * getter method for player
     *
     * @return player
     */
    public Player getMyPlayer() {return myPlayer;}

    /**
     * getter method for ship
     *
     * @return ship
     */
    public Ship getMyShip() {return myShip;}

    public Universe getMyUniverse() {
        return myUniverse;
    }

    /**
     * setter method for ship
     *
     * @param ship new ship
     */
    public void setMyShip(Ship ship) {this.myShip = ship;}

    /**
     * setter method for player
     *
     * @param myPlayer new player
     */
    public void setMyPlayer(Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    /**
     * setter method for universe
     *
     * @param myUniverse new universe
     */
    public void setMyUniverse(Universe myUniverse) { this.myUniverse = myUniverse; }

    public List<TradeGood> getTradeGoodsForPlanet(Planet planet) {
        List<TradeGood> toReturn = new ArrayList<>();
        for(TradeGood t : planet.getGoods()) {
            toReturn.add(t);
        }
        return toReturn;
    }
}
