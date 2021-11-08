package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class SportDa implements iSportDa {
    private ArrayList<Sport> sports = new ArrayList<>();

    public SportDa() {
      sports.add(new Sport("basketball","this sport need tall player",""));
      sports.add(new Sport("Volleball","this","this"));
      sports.add(new Sport("tenis","this","tenis"));
    }
    public List<Sport> getSports(String car){
        ArrayList<Sport> data = new ArrayList<>();
        for (Sport b : sports){
            if(b.getTitle().equals(car))
                data.add(b);
        }
        return data;
    }

    @Override
    public String[] getcategories(int position) {
        if(position==0){
        String[] football = new String[]{"football","Football is a team sport that is played on a rectangular field. The object of the game is to get the oval-shaped football down the field, either by running it or passing it. The goal is to get the football into the opponent's end zone.","football is a great game ","The most basic rule is that a player needs to move the ball towards the opponents’ goal line and away from his/her own using any body part except the hands and arms. But what are the main rules and regulations of football? The Laws of the Game were created by the FA in 1863 when there were just 13 rules."};
        return football;
        }
        if(position==1){
            String[] basketBall = new String[]{"basketBall","basketball, game played between two teams of five players each on a rectangular court, usually indoors. Each team tries to score by tossing the ball through the opponent’s goal, an elevated horizontal hoop and net called a basket.","Basketball is a team sport. Two teams of five players each try to score by shooting a ball through a hoop elevated 10 feet above the ground. The game is played on a rectangular floor called the court, and there is a hoop at each end."};
            return basketBall;
        }
        if(position==2){
            String[] BaseBall = new String[]{"BaseBall","Baseball is a bat-and-ball game played between two opposing teams, typically of nine players each, that take turns batting and fielding. The game proceeds when a player on the fielding team, called the pitcher, throws a ball which a player on the batting team tries to hit with a bat ","The Official Baseball Rules govern all professional play in the United States and Canada, including the World Baseball Classic. The complete rules are published as the  Official Baseball Rules at MLB.com], the official web site of Major League Baseball in the United States and Canada. The rules are also published in book form in North America by the Sporting News "};
            return BaseBall;
        }
        if(position==3){
            String[] USFooball = new String[]{"USFooball","American football, referred to as football in the United States and Canada and also known as gridiron, is a team sport. It is played by two teams with 11 players on each side.","football is a great game ","American football rules\n" +
                    "Rules of American Football. Games last for four 15 minute quarters. A 2 minute break between the 1st & 2nd and 3rd & 4th quarters is had along with a 15 minute rest between 2nd and 3rd quarters (half time). Each team has 4 downs to gain 10 or more yards. They can either throw or run the ball to make the yards."};
            return USFooball;
        }
        if(position==4){
            String[] volleyBall = new String[]{"volleyBall","volleyball, game played by two teams, usually of six players on a side, in which the players use their hands to bat a ball back and forth over a high net, trying to make the ball touch the court within the opponents’ playing area before it can be returned.","Rules of Volleyball Each team consist of 6 players and 6 substitutes. Players can be substituted at any time but if they are to return can only be swapped for the player that replaced them. Each team can hit the ball up to three times before the ball must be returned."};
            return volleyBall;
        }
        if(position==5){
            String[] TableTennis = new String[]{"TableTennis","Table tennis, also known as ping-pong and whiff-whaff, is a sport in which two or four players hit a lightweight ball, also known as the ping-pong ball, back and forth across a table using small rackets. The game takes place on a hard table divided by a net. Except for the initial serve,","Whether you call it ping pong, table tennis, or whiff whaff, these official table tennis rules should help you keep things straight. 1. GAMES ARE PLAYED TO 11 POINTS A Game is played to 11 points. A Game must be won by two points. A Match is generally the best three of five Games. 2. ALTERNATE SERVES EVERY TWO POINTS"};
            return TableTennis;
        }
        if(position==6){
            String[] Tennis = new String[]{"Tennis","Object of the Game\n" +
                    "The game of tennis played on a rectangular court with a net running across the centre. The aim is to hit the ball over the net landing the ball within the margins of the court and in a way that results in your opponent being unable to return the ball. You win a point every time your opponent is unable to return the ball within the court.","Tennis RulesTennis\n" +
                    "Tennis is a sport that originated in England around the 19th century and is now played in a host of countries around the world. There are four major tournaments known as the ‘majors’ that include Wimbledon, US Open, French Open and Australian tournament."};
            return Tennis;
        }


        return null;
    }


}
