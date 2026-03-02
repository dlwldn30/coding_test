class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        //시간
        int time = attacks[attacks.length-1][0];
        
        int maxHealth = health;
        
        //몬스터 공격 회차
        int t = 0;
        
        //연속 쉬는 날
        int maintain = 0;
        
        for (int i = 1; i <= time; i++){
            maintain++;
            
            //공격 받은 경우
            if(attacks[t][0] == i){
                health -= attacks[t][1];
                t++;
                maintain = 0;
            }else{
                int heal = bandage[1];
                if(maintain == bandage[0]){
                    heal += bandage[2];
                    maintain = 0;
                }
                health = health+heal > maxHealth ? maxHealth : health+heal;
            }
            
            if(health <= 0)
                return -1;
        }
        
        if(health > 0)
            return health;
        

        return -1;
    }
}   