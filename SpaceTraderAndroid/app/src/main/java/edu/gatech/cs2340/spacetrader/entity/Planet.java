package edu.gatech.cs2340.spacetrader.entity;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.gatech.cs2340.spacetrader.entity.tradegoods.TradeGood;

/**
 * Planet class allows Planet to be an instance class
 * Allows the player to jump to different planets which are a part of different
 * Solar Systems which are a part of different Universes
 */
public class Planet {
    private String name;
    private TechLevel techLevel;
    private Resources resources;
    private Market market;
    private Pair<Integer, Integer> coordinates;

    /**
     * No-arg constructor for the Planet class that uses constructor chaining
     * to set default values for Name, Coordinates, TechLevel, and Resources
     *
     */
    public Planet() {
        this("", TechLevel.PreAgriculture, Resources.NoSpecialResources, new Pair<Integer, Integer>(0,0));

    }

    public Planet(String name, Pair<Integer, Integer> coordinates) {
        this(name, TechLevel.PreAgriculture, Resources.NoSpecialResources, coordinates);
    }

    /**
     * Second constructor for the Planet class that allows the Planet to be instantiated
     * by the Player.
     * @param name represents the name of the planet
     * @param techLevel represents the tech level of the planet
     * @param resource represents the resource that the planet is known for
     */
    public Planet(String name, TechLevel techLevel, Resources resource, Pair<Integer, Integer> coordinates) {
        this.name = name;
        this.techLevel = techLevel;
        this.resources = resource;
        this.market = new Market();
        this.coordinates = coordinates;
    }

    /**
     * Setter method for the Planet name
     * @param name represents the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the Planet name
     * @return name of the Planet
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for tech level of planet
     * @param techLevel represents the tech level of the planet
     */
    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * Getter method for tech level of planet
     * @return techLevel of the planet
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * Setter method for resource of a planet
     * @param resource represents the resource that the planet is known for
     */
    public void setResources(Resources resource) {
        this.resources = resource;
    }

    /**
     * Getter method for the resource of a planet
     * @return resource of the planet
     */
    public Resources getResources() {
        return resources;
    }

    /**
     * Getter method for the planet's coordinates
     * @return the planet's coordinates
     */
    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }

    /**
     * assigns a random resource level and tech level and generates a market
     */
    public void generate() {
        this.resources = Resources.getRandomResources();
        this.techLevel = TechLevel.getRandomTech();
        market.setResources(resources);
        market.setTechLevel(techLevel);
        market.generateMarket();
    }

    public List<TradeGood> getGoods() {
        List<TradeGood> toReturn = new ArrayList<>();
        for (TradeGood t: market.getTradeGoods()) {
            toReturn.add(t);
        }
        return toReturn;
    }

    public int distanceTo(Pair<Integer, Integer> dest) {
        int distance = (int)Math.sqrt((coordinates.first - dest.first) * (coordinates.first - dest.first) 
                + (coordinates.second - dest.second) * (coordinates.second - dest.second));
        return distance;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\tResources: " + resources.toString() + "\tTech Level: " + techLevel.toString() + "\nMarket:\n" + market.toString();
    }
}
