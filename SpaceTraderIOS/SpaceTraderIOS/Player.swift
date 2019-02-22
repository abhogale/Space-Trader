//
//  Player.swift
//  SpaceTraderIOS
//
//  Created by Rahil Patel on 2/20/19.
//  Copyright © 2019 HackstreetBoys. All rights reserved.
//

import Foundation

class Player: CustomStringConvertible {
    var name: String
    var pilotSkill: Int
    var engineSkill: Int
    var tradeSkill: Int
    var fightSkill: Int
    var ship: ShipType
    var difficulty: Difficulty
    
    var description: String {return "Name: \(name)\nPilot Skill: \(pilotSkill)\nEngine Skill: \(engineSkill)\nTrade Skill: \(tradeSkill)\nFight Skill: \(fightSkill)\nShip Type: \(ship)\nDifficulty: \(difficulty)"}
    
    convenience init() {
        self.init(name: "", pilotSkill: 0, engineSkill: 0, tradeSkill: 0, fightSkill: 0, difficulty: .Easy)
    }
    convenience init(name: String, pilotSkill: Int, engineSkill: Int, tradeSkill: Int, fightSkill: Int, difficulty: Difficulty) {
        self.init(name: name, pilotSkill: pilotSkill, engineSkill: engineSkill, tradeSkill: tradeSkill, fightSkill: fightSkill, shipType: .Gnat, difficulty: difficulty)
    }
    
    init(name: String, pilotSkill: Int, engineSkill: Int, tradeSkill: Int, fightSkill: Int, shipType: ShipType, difficulty: Difficulty) {
        self.name = name
        self.pilotSkill = pilotSkill
        self.engineSkill = engineSkill
        self.tradeSkill = tradeSkill
        self.fightSkill = fightSkill
        self.ship = shipType
        self.difficulty = difficulty
    }
}

enum ShipType: CaseIterable {
    case Gnat
}

enum Difficulty: CaseIterable {
    case Easy
    case Medium
    case Hard
}