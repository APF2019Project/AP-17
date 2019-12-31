package model;

import control.BattleClasses.Map;

public class ReverseProjectile extends Projectile{
    public ReverseProjectile(int damage, int speedDecreasePercent, boolean air, int x, int y, Map map){
        super(damage, speedDecreasePercent, air, x, y, map);
    }
}
