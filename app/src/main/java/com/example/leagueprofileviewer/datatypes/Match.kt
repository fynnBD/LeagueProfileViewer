package com.example.leagueprofileviewer.datatypes

data class Match(val gameId : String, val champion : String, val role : String, val lane : String, var matchDetails : MatchInfo)

data class MatchInfo(
    val gameCreation: Long,
    val gameDuration: Int,
    val gameId: Int,
    val gameMode: String,
    val gameType: String,
    val gameVersion: String,
    val mapId: Int,
    val participantIdentities: List<ParticipantIdentity>,
    val participants: List<Participant>,
    val platformId: String,
    val queueId: Int,
    val seasonId: Int,
    val teams: List<Team>
)

data class ParticipantIdentity(
    val participantId: Int,
    val player: Player
)

data class Participant(
    val championId: Int,
    val participantId: Int,
    val spell1Id: Int,
    val spell2Id: Int,
    val stats: Stats,
    val teamId: Int,
    val timeline: Timeline
)

data class Team(
    val bans: List<Ban>,
    val baronKills: Int,
    val dominionVictoryScore: Int,
    val dragonKills: Int,
    val firstBaron: Boolean,
    val firstBlood: Boolean,
    val firstDragon: Boolean,
    val firstInhibitor: Boolean,
    val firstRiftHerald: Boolean,
    val firstTower: Boolean,
    val inhibitorKills: Int,
    val riftHeraldKills: Int,
    val teamId: Int,
    val towerKills: Int,
    val vilemawKills: Int,
    val win: String
)

data class Player(
    val accountId: String,
    val currentAccountId: String,
    val currentPlatformId: String,
    val matchHistoryUri: String,
    val platformId: String,
    val profileIcon: Int,
    val summonerId: String,
    val summonerName: String
)

data class Stats(
    val assists: Int,
    val champLevel: Int,
    val combatPlayerScore: Int,
    val damageDealtToObjectives: Int,
    val damageDealtToTurrets: Int,
    val damageSelfMitigated: Int,
    val deaths: Int,
    val doubleKills: Int,
    val firstBloodAssist: Boolean,
    val firstBloodKill: Boolean,
    val firstTowerAssist: Boolean,
    val firstTowerKill: Boolean,
    val goldEarned: Int,
    val goldSpent: Int,
    val inhibitorKills: Int,
    val item0: Int,
    val item1: Int,
    val item2: Int,
    val item3: Int,
    val item4: Int,
    val item5: Int,
    val item6: Int,
    val killingSprees: Int,
    val kills: Int,
    val largestCriticalStrike: Int,
    val largestKillingSpree: Int,
    val largestMultiKill: Int,
    val longestTimeSpentLiving: Int,
    val magicDamageDealt: Int,
    val magicDamageDealtToChampions: Int,
    val magicalDamageTaken: Int,
    val neutralMinionsKilled: Int,
    val neutralMinionsKilledEnemyJungle: Int,
    val neutralMinionsKilledTeamJungle: Int,
    val objectivePlayerScore: Int,
    val participantId: Int,
    val pentaKills: Int,
    val perk0: Int,
    val perk0Var1: Int,
    val perk0Var2: Int,
    val perk0Var3: Int,
    val perk1: Int,
    val perk1Var1: Int,
    val perk1Var2: Int,
    val perk1Var3: Int,
    val perk2: Int,
    val perk2Var1: Int,
    val perk2Var2: Int,
    val perk2Var3: Int,
    val perk3: Int,
    val perk3Var1: Int,
    val perk3Var2: Int,
    val perk3Var3: Int,
    val perk4: Int,
    val perk4Var1: Int,
    val perk4Var2: Int,
    val perk4Var3: Int,
    val perk5: Int,
    val perk5Var1: Int,
    val perk5Var2: Int,
    val perk5Var3: Int,
    val perkPrimaryStyle: Int,
    val perkSubStyle: Int,
    val physicalDamageDealt: Int,
    val physicalDamageDealtToChampions: Int,
    val physicalDamageTaken: Int,
    val playerScore0: Int,
    val playerScore1: Int,
    val playerScore2: Int,
    val playerScore3: Int,
    val playerScore4: Int,
    val playerScore5: Int,
    val playerScore6: Int,
    val playerScore7: Int,
    val playerScore8: Int,
    val playerScore9: Int,
    val quadraKills: Int,
    val sightWardsBoughtInGame: Int,
    val statPerk0: Int,
    val statPerk1: Int,
    val statPerk2: Int,
    val timeCCingOthers: Int,
    val totalDamageDealt: Int,
    val totalDamageDealtToChampions: Int,
    val totalDamageTaken: Int,
    val totalHeal: Int,
    val totalMinionsKilled: Int,
    val totalPlayerScore: Int,
    val totalScoreRank: Int,
    val totalTimeCrowdControlDealt: Int,
    val totalUnitsHealed: Int,
    val tripleKills: Int,
    val trueDamageDealt: Int,
    val trueDamageDealtToChampions: Int,
    val trueDamageTaken: Int,
    val turretKills: Int,
    val unrealKills: Int,
    val visionScore: Int,
    val visionWardsBoughtInGame: Int,
    val wardsKilled: Int,
    val wardsPlaced: Int,
    val win: Boolean
)

data class Timeline(
    val creepsPerMinDeltas: CreepsPerMinDeltas,
    val csDiffPerMinDeltas: CsDiffPerMinDeltas,
    val damageTakenDiffPerMinDeltas: DamageTakenDiffPerMinDeltas,
    val damageTakenPerMinDeltas: DamageTakenPerMinDeltas,
    val goldPerMinDeltas: GoldPerMinDeltas,
    val lane: String,
    val participantId: Int,
    val role: String,
    val xpDiffPerMinDeltas: XpDiffPerMinDeltas,
    val xpPerMinDeltas: XpPerMinDeltas
)

data class CreepsPerMinDeltas(
    val `0-10`: Double,
    val `10-20`: Double
)

data class CsDiffPerMinDeltas(
    val `0-10`: Double,
    val `10-20`: Double
)

data class DamageTakenDiffPerMinDeltas(
    val `0-10`: Double,
    val `10-20`: Double
)

data class DamageTakenPerMinDeltas(
    val `0-10`: Double,
    val `10-20`: Double
)

data class GoldPerMinDeltas(
    val `0-10`: Double,
    val `10-20`: Double
)

data class XpDiffPerMinDeltas(
    val `0-10`: Double,
    val `10-20`: Double
)

data class XpPerMinDeltas(
    val `0-10`: Double,
    val `10-20`: Double
)

data class Ban(
    val championId: Int,
    val pickTurn: Int
)