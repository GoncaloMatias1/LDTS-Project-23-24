package com.goncalomatias1.l05gr06.Objects.Characteristics;

public class Health {
    private int healthpoints;
    private boolean isAlive;

    public void lowerHealth(){
        healthpoints--;
        if (healthpoints == 0) dies();
    };
    public void dies(){
        isAlive = false;

        //TODO Tirar da tela, não sei se será aqui ou noutra função
    }



    public int getHealthpoints(){
        return healthpoints;
    }

    public boolean getisAlive(){
        return isAlive;
    }
}
